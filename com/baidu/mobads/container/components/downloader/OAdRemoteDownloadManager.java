package com.baidu.mobads.container.components.downloader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.mobads.container.components.controller.OAdBasicNetworkBroadcastReceiver;
import com.baidu.mobads.container.components.controller.OAdBasicNetworkController;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class OAdRemoteDownloadManager {
    public static final String DEFAULT_OUTPUT_FOLDER = "";
    public static final String TAG = "OAdRemoteDownloadManager";
    public static OAdRemoteDownloadManager sInstance;
    public Context mContext;
    public OAdBasicNetworkController networkController;
    public HashMap<String, IDownloader> mAdsApkDownloaderMap = new HashMap<>();
    public AtomicBoolean restartDownloadAppBefore = new AtomicBoolean(false);

    public OAdRemoteDownloadManager(Context context) {
        this.mContext = context;
    }

    public static OAdRemoteDownloadManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new OAdRemoteDownloadManager(context);
        }
        return sInstance;
    }

    public synchronized IDownloader createAdsApkDownloader(URL url, String str, String str2, int i, String str3) {
        OAdRemoteApkDownloader oAdRemoteApkDownloader;
        oAdRemoteApkDownloader = new OAdRemoteApkDownloader(this.mContext, url, str, str2, i, str3);
        putAdsApkDownloader(str3, oAdRemoteApkDownloader);
        try {
            if (this.networkController == null) {
                this.networkController = new OAdBasicNetworkController(this.mContext);
                this.networkController.setBroadcastReceiver(new OAdBasicNetworkBroadcastReceiver(this.networkController));
                this.networkController.addEventListener(OAdBasicNetworkController.NETWORK_CHANGED, new IOAdEventListener() { // from class: com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager.1
                    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
                    public void run(IOAdEvent iOAdEvent) {
                        NetworkInfo activeNetworkInfo;
                        try {
                            RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, "网络状态已经改变");
                            activeNetworkInfo = ((ConnectivityManager) OAdRemoteDownloadManager.this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
                        } catch (Exception e2) {
                            RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e2);
                            return;
                        }
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            String typeName = activeNetworkInfo.getTypeName();
                            int type = activeNetworkInfo.getType();
                            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                            remoteXAdLogger.d(OAdRemoteDownloadManager.TAG, "当前网络名称：" + typeName + "; 网络类型：" + type);
                            ArrayList<IDownloader> allAdsApkDownloaderes = OAdRemoteDownloadManager.this.getAllAdsApkDownloaderes();
                            if (allAdsApkDownloaderes != null) {
                                for (IDownloader iDownloader : allAdsApkDownloaderes) {
                                    if (type == 1) {
                                        if (iDownloader.getState() == IDownloader.DownloadStatus.ERROR || iDownloader.getState() == IDownloader.DownloadStatus.PAUSED) {
                                            try {
                                                iDownloader.resume();
                                            } catch (Exception e3) {
                                                RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e3);
                                            }
                                        }
                                    } else if (type == 0) {
                                        RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, "mobile net work");
                                        if (!iDownloader.isDownloadOnlyWifi()) {
                                            if (iDownloader.getState() == IDownloader.DownloadStatus.ERROR || iDownloader.getState() == IDownloader.DownloadStatus.PAUSED) {
                                                try {
                                                    iDownloader.resume();
                                                } catch (Exception e4) {
                                                    RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e4);
                                                }
                                            }
                                        } else {
                                            try {
                                                iDownloader.setPausedManually(false);
                                                iDownloader.pause();
                                            } catch (Exception e5) {
                                                RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e5);
                                            }
                                        }
                                    }
                                    RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, "没有可用网络");
                    }
                });
                this.networkController.startListener();
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(TAG, e2);
        }
        return oAdRemoteApkDownloader;
    }

    public IDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        return new FileDownloader(url, str, str2, z);
    }

    public IDownloader getAdsApkDownloader(String str) {
        IDownloader iDownloader;
        synchronized (this.mAdsApkDownloaderMap) {
            iDownloader = this.mAdsApkDownloaderMap.get(str);
        }
        return iDownloader;
    }

    public ArrayList<IDownloader> getAllAdsApkDownloaderes() {
        ArrayList<IDownloader> arrayList;
        synchronized (this.mAdsApkDownloaderMap) {
            Collection<IDownloader> values = this.mAdsApkDownloaderMap.values();
            if (values.size() > 0) {
                arrayList = new ArrayList<>();
                for (IDownloader iDownloader : values) {
                    arrayList.add(iDownloader);
                }
            } else {
                arrayList = null;
            }
        }
        return arrayList;
    }

    public void putAdsApkDownloader(String str, IDownloader iDownloader) {
        synchronized (this.mAdsApkDownloaderMap) {
            this.mAdsApkDownloaderMap.put(str, iDownloader);
        }
    }

    public Boolean removeAdsApkDownloader(String str) {
        synchronized (this.mAdsApkDownloaderMap) {
            this.mAdsApkDownloaderMap.remove(str);
        }
        return Boolean.TRUE;
    }

    public void removeAllAdsApkDownloaderes() {
        synchronized (this.mAdsApkDownloaderMap) {
            this.mAdsApkDownloaderMap.clear();
        }
    }
}
