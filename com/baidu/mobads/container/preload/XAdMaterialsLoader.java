package com.baidu.mobads.container.preload;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.NetUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.sapi2.views.SmsLoginView;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdMaterialsLoader implements Observer {
    public static final String MATERIAL_SETTING_URL = "https://mobads.baidu.com/ads/preload.php";
    public static volatile XAdMaterialsLoader instance;
    public static AtomicBoolean mMaterialDownloading = new AtomicBoolean(false);
    public Context mAppContext;
    public String mAppId;
    public int materialLogType = 413;
    public List<XAdMaterialsInfo> materialsInfos;
    public String outputFolder;

    /* loaded from: classes2.dex */
    public static class MyTask extends BaseTask {
        public XAdMaterialsLoader mLoader;

        public MyTask(XAdMaterialsLoader xAdMaterialsLoader) {
            this.mLoader = xAdMaterialsLoader;
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            this.mLoader.loadSetting();
            return null;
        }
    }

    public static XAdMaterialsLoader getInstance() {
        if (instance == null) {
            synchronized (XAdMaterialsLoader.class) {
                if (instance == null) {
                    instance = new XAdMaterialsLoader();
                }
            }
        }
        return instance;
    }

    private String getOutputFolderPath(Context context) {
        return context.getFilesDir().getPath() + File.separator + "__bidu_cache_dir" + File.separator;
    }

    private boolean isDownload(XAdMaterialsInfo xAdMaterialsInfo) {
        return xAdMaterialsInfo.getAppsid().equals(this.mAppId) && stringToLong(xAdMaterialsInfo.getExpired()) <= System.currentTimeMillis();
    }

    private boolean isMaterialExists(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.outputFolder);
        sb.append(str);
        return new File(sb.toString()).exists();
    }

    private void loadMateContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.materialsInfos = XAdMaterialsInfo.fromJsonArray(new JSONObject(str).optJSONArray("preload"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSetting() {
        loadMateContent(NetUtils.doGet(AdURIUtils.replaceURLWithSupportProtocol(MATERIAL_SETTING_URL)));
        startLoadMaterials();
    }

    private void startLoad(String str, String str2) {
        try {
            SendLogUtil.START_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
            IDownloader createSimpleFileDownloader = OAdRemoteDownloadManager.getInstance(this.mAppContext).createSimpleFileDownloader(new URL(str), this.outputFolder, str2, true);
            createSimpleFileDownloader.addObserver(this);
            createSimpleFileDownloader.start();
        } catch (Exception unused) {
        }
    }

    private void startLoadMaterials() {
        List<XAdMaterialsInfo> list = this.materialsInfos;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.materialsInfos.size(); i2++) {
            XAdMaterialsInfo xAdMaterialsInfo = this.materialsInfos.get(i2);
            String url = xAdMaterialsInfo.getUrl();
            String md5 = EncryptUtils.getMD5(url);
            if (isDownload(xAdMaterialsInfo) && isMaterialExists(md5)) {
                SendLogUtil.START_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
                SendLogUtil.END_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
                SendLogUtil.sendLog(this.mAppContext, this.materialLogType, "material_has_loaded", url);
            }
            if (isDownload(xAdMaterialsInfo) && !isMaterialExists(md5)) {
                startLoad(url, md5);
            }
        }
    }

    private long stringToLong(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (Exception unused) {
            date = null;
        }
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }

    public void startLoadRemoteSetting(Context context) {
        if (mMaterialDownloading.get()) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.outputFolder = getOutputFolderPath(applicationContext);
        this.mAppId = DeviceUtils.getInstance().getAppId(this.mAppContext);
        mMaterialDownloading.set(true);
        TaskScheduler.getInstance().submitWithDelay(new MyTask(this), 2L, TimeUnit.SECONDS);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IDownloader iDownloader = (IDownloader) observable;
        if (iDownloader == null) {
            return;
        }
        if (iDownloader.getState() == IDownloader.DownloadStatus.COMPLETED) {
            SendLogUtil.END_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
            SendLogUtil.sendLog(this.mAppContext, this.materialLogType, "success", iDownloader.getURL());
        } else if (iDownloader.getState() == IDownloader.DownloadStatus.ERROR) {
            SendLogUtil.END_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
            SendLogUtil.sendLog(this.mAppContext, this.materialLogType, SmsLoginView.f.l, iDownloader.getURL());
        }
    }
}
