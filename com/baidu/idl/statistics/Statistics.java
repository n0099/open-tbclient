package com.baidu.idl.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.idl.license.License;
import com.baidu.idl.util.FileUtil;
import com.baidu.idl.util.NetUtil;
import com.baidu.idl.util.StuLogEx;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Statistics {
    public static final String AS_FILE_NAME = "as";
    public static final int MESSAGE_INSTANT_SYNC_FILE = 1;
    public static final int MESSAGE_INTERVAL_SYNC_FILE = 2;
    public static final String SERVER_URL = "http://sdkss.shitu.baidu.com/cgi-bin/sdkstat.py";
    public static final long SYNC_FILE_DELAY_TIME = 3000;
    public static final String TAG = "AuthenticationStatistics";
    public String al_version;
    public Context app;
    public String appId;
    public final Properties as;
    public File asFile;
    public String au_version;
    public boolean isInit;
    public String userId;
    public Handler workerHandler;
    public HandlerThread workerThread;

    /* loaded from: classes2.dex */
    public static final class Holder {
        public static final Statistics instance = new Statistics();
    }

    /* loaded from: classes2.dex */
    public static final class StatisticsResult {
        public String errmsg;
        public int errno;

        public StatisticsResult(int i, String str) {
            this.errno = i;
            this.errmsg = str;
        }
    }

    public static Statistics getInstance() {
        return Holder.instance;
    }

    private boolean initFile() {
        File file = new File(this.app.getFilesDir(), "as");
        this.asFile = file;
        return FileUtil.createFile(file) && FileUtil.loadPropertiesFile(this.asFile, this.as);
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
        this.workerHandler.sendEmptyMessageDelayed(2, 3000L);
    }

    public boolean init(Context context, String str) {
        if (this.isInit) {
            return true;
        }
        if (context != null && str != null && !"".equals(str)) {
            this.app = context;
            this.appId = str;
            try {
                this.userId = "0000";
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
            this.al_version = License.getAlgorithmVersion();
            this.au_version = License.getAuthorityVersion();
            HandlerThread handlerThread = new HandlerThread("workerThread");
            this.workerThread = handlerThread;
            handlerThread.start();
            this.workerHandler = new Handler(this.workerThread.getLooper()) { // from class: com.baidu.idl.statistics.Statistics.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1 || i == 2) {
                        FileUtil.savePropertiesFile(Statistics.this.asFile, Statistics.this.as);
                    }
                }
            };
            if (initFile()) {
                if (NetUtil.isConnected(context) && this.as.size() > 0) {
                    final Properties properties = (Properties) this.as.clone();
                    this.as.clear();
                    new Thread(new Runnable() { // from class: com.baidu.idl.statistics.Statistics.2
                        @Override // java.lang.Runnable
                        public void run() {
                            NetUtil.uploadData(new NetUtil.RequestAdapter<StatisticsResult>() { // from class: com.baidu.idl.statistics.Statistics.2.1
                                @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                                public String getRequestString() {
                                    String[] split;
                                    StringBuilder sb = new StringBuilder();
                                    for (Map.Entry entry : properties.entrySet()) {
                                        String str2 = (String) entry.getKey();
                                        for (String str3 : ((String) entry.getValue()).split("-")) {
                                            sb.append(Statistics.this.appId);
                                            sb.append(" ");
                                            sb.append(Statistics.this.userId);
                                            sb.append(" ");
                                            sb.append(str2);
                                            sb.append(" ");
                                            sb.append(str3);
                                            sb.append(" ");
                                            sb.append(Statistics.this.au_version);
                                            sb.append(" ");
                                            sb.append(Statistics.this.al_version);
                                            sb.append("\n");
                                        }
                                    }
                                    return sb.toString();
                                }

                                @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                                public String getURL() {
                                    return Statistics.SERVER_URL;
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
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    Statistics.this.merge(properties);
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
                                        } catch (Throwable th) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (IOException unused) {
                                            }
                                            throw th;
                                        }
                                    }
                                    byteArrayOutputStream.flush();
                                    JSONObject jSONObject = new JSONObject(new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
                                    StatisticsResult statisticsResult = new StatisticsResult(jSONObject.getInt("errno"), jSONObject.getString("errnmsg"));
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                    return statisticsResult;
                                }
                            });
                        }
                    }).start();
                }
                this.isInit = true;
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("The params is invalid!");
    }

    public synchronized void triggerEvent(String str) {
    }

    public Statistics() {
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
}
