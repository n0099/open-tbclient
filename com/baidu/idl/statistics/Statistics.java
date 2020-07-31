package com.baidu.idl.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.idl.license.License;
import com.baidu.idl.util.FileUtil;
import com.baidu.idl.util.NetUtil;
import com.baidu.idl.util.StuLogEx;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class Statistics {
    private static final String AS_FILE_NAME = "as";
    private static final int MESSAGE_INSTANT_SYNC_FILE = 1;
    private static final int MESSAGE_INTERVAL_SYNC_FILE = 2;
    private static final String SERVER_URL = "http://sdkss.shitu.baidu.com/cgi-bin/sdkstat.py";
    private static final long SYNC_FILE_DELAY_TIME = 3000;
    private static final String TAG = "AuthenticationStatistics";
    private String al_version;
    private Context app;
    private String appId;
    private final Properties as;
    private File asFile;
    private String au_version;
    private boolean isInit;
    private String userId;
    private Handler workerHandler;
    private HandlerThread workerThread;

    public boolean init(Context context, String str) {
        if (this.isInit) {
            return true;
        }
        if (context == null || str == null || "".equals(str)) {
            throw new IllegalArgumentException("The params is invalid!");
        }
        this.app = context;
        this.appId = str;
        try {
            this.userId = CommonParam.getCUID(context);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        this.al_version = License.getAlgorithmVersion();
        this.au_version = License.getAuthorityVersion();
        this.workerThread = new HandlerThread("workerThread");
        this.workerThread.start();
        this.workerHandler = new Handler(this.workerThread.getLooper()) { // from class: com.baidu.idl.statistics.Statistics.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 || message.what == 2) {
                    FileUtil.savePropertiesFile(Statistics.this.asFile, Statistics.this.as);
                }
            }
        };
        if (!initFile()) {
            return false;
        }
        if (NetUtil.isConnected(context) && this.as.size() > 0) {
            final Properties properties = (Properties) this.as.clone();
            this.as.clear();
            new Thread(new Runnable() { // from class: com.baidu.idl.statistics.Statistics.2
                @Override // java.lang.Runnable
                public void run() {
                    NetUtil.uploadData(new NetUtil.RequestAdapter<StatisticsResult>() { // from class: com.baidu.idl.statistics.Statistics.2.1
                        @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                        public String getURL() {
                            return Statistics.SERVER_URL;
                        }

                        @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                        public String getRequestString() {
                            StringBuilder sb = new StringBuilder();
                            for (Map.Entry entry : properties.entrySet()) {
                                String str2 = (String) entry.getKey();
                                String[] split = ((String) entry.getValue()).split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                for (String str3 : split) {
                                    sb.append(Statistics.this.appId).append(" ");
                                    sb.append(Statistics.this.userId).append(" ");
                                    sb.append(str2).append(" ");
                                    sb.append(str3).append(" ");
                                    sb.append(Statistics.this.au_version).append(" ");
                                    sb.append(Statistics.this.al_version);
                                    sb.append("\n");
                                }
                            }
                            return sb.toString();
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                        public StatisticsResult parseResponse(InputStream inputStream) throws IOException, JSONException {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                try {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } finally {
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                }
                            }
                            byteArrayOutputStream.flush();
                            JSONObject jSONObject = new JSONObject(new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
                            return new StatisticsResult(jSONObject.getInt(BaseJsonData.TAG_ERRNO), jSONObject.getString("errnmsg"));
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                        public void onResponse(int i, StatisticsResult statisticsResult, Exception exc) {
                            if (i != 0) {
                                StuLogEx.e(Statistics.TAG, exc.getMessage(), exc);
                            } else if (statisticsResult.errno != 0) {
                                StuLogEx.e(Statistics.TAG, statisticsResult.errmsg);
                            } else {
                                properties.clear();
                            }
                            Statistics.this.merge(properties);
                        }
                    });
                }
            }).start();
        }
        this.isInit = true;
        return true;
    }

    private boolean initFile() {
        this.asFile = new File(this.app.getFilesDir(), "as");
        return FileUtil.createFile(this.asFile) && FileUtil.loadPropertiesFile(this.asFile, this.as);
    }

    public synchronized void triggerEvent(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void merge(Properties properties) {
        for (Map.Entry entry : properties.entrySet()) {
            String obj = entry.getKey().toString();
            String obj2 = entry.getValue().toString();
            if (!this.as.containsKey(obj)) {
                this.as.setProperty(obj, obj2);
            } else {
                this.as.setProperty(obj, String.format(Locale.getDefault(), "%s-%s", obj2, this.as.getProperty(obj)));
            }
        }
        syncFile(true);
    }

    private void syncFile(boolean z) {
        if (z) {
            this.workerHandler.removeMessages(1);
            this.workerHandler.sendEmptyMessage(1);
            return;
        }
        this.workerHandler.removeMessages(2);
        this.workerHandler.sendEmptyMessageDelayed(2, SYNC_FILE_DELAY_TIME);
    }

    private Statistics() {
        this.app = null;
        this.appId = null;
        this.userId = null;
        this.al_version = null;
        this.au_version = null;
        this.isInit = false;
        this.asFile = null;
        this.as = new Properties();
        this.workerThread = null;
        this.workerHandler = null;
    }

    public static Statistics getInstance() {
        return Holder.instance;
    }

    /* loaded from: classes20.dex */
    private static final class Holder {
        private static final Statistics instance = new Statistics();

        private Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static final class StatisticsResult {
        public String errmsg;
        public int errno;

        public StatisticsResult(int i, String str) {
            this.errno = i;
            this.errmsg = str;
        }
    }
}
