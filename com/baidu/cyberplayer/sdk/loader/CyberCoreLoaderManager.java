package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.MediaPlayerReduceHelper;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import com.baidu.cyberplayer.sdk.statistics.DpInitKernelSession;
import com.baidu.cyberplayer.sdk.statistics.DpLibsInitSession;
import com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class CyberCoreLoaderManager {
    public static final String LATEST_SUCCESS_LOADED_PREF_NAME = "latest_success_loaded_";
    public static final int MSG_TYPE_ERROR = 1;
    public static final int MSG_TYPE_IS_LOADED = 3;
    public static final int MSG_TYPE_LIB_PATH = 4;
    public static final int MSG_TYPE_PROGRESS = 2;
    public static final int MSG_TYPE_SUCCESS = 0;
    public static final String TAG = "CyberCoreLoaderManager";
    public static Map<Integer, Object> mLibPathMap = new ConcurrentHashMap();
    public static volatile CyberCoreLoaderManager sInstance = null;
    public Context mContext;
    public final Object mLock = new Object();
    public volatile int sCurLoadingLibs = 0;
    public long mStartLoadTime = -1;
    public long mInitDpTime = -1;
    public Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            int i2 = 0;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                for (int i3 = 0; i3 < CyberCoreLoaderManager.this.mInstallObserversList.size(); i3++) {
                                    CyberCoreInstallObserver cyberCoreInstallObserver = (CyberCoreInstallObserver) CyberCoreLoaderManager.this.mInstallObserversList.get(i3);
                                    if (cyberCoreInstallObserver.mListener != null && (cyberCoreInstallObserver.mListener instanceof CyberPlayerManager.InstallListener2)) {
                                        ((CyberPlayerManager.InstallListener2) cyberCoreInstallObserver.mListener).onInstallInfo(message.arg1, 0, message.obj);
                                    }
                                }
                            }
                        } else {
                            Object obj = message.obj;
                            if (obj != null) {
                                ((CyberPlayerManager.InstallListener) obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                            }
                        }
                    } else {
                        while (i2 < CyberCoreLoaderManager.this.mInstallObserversList.size()) {
                            CyberCoreInstallObserver cyberCoreInstallObserver2 = (CyberCoreInstallObserver) CyberCoreLoaderManager.this.mInstallObserversList.get(i2);
                            if (cyberCoreInstallObserver2.mListener != null) {
                                cyberCoreInstallObserver2.mListener.onInstallProgress(message.arg1, message.arg2);
                                if (cyberCoreInstallObserver2.mListener instanceof CyberPlayerManager.InstallListener2) {
                                    ((CyberPlayerManager.InstallListener2) cyberCoreInstallObserver2.mListener).onInstallInfo(103, message.arg2, null);
                                }
                            }
                            i2++;
                        }
                    }
                } else {
                    synchronized (CyberCoreLoaderManager.this.mLock) {
                        while (i2 < CyberCoreLoaderManager.this.mInstallObserversList.size()) {
                            CyberCoreInstallObserver cyberCoreInstallObserver3 = (CyberCoreInstallObserver) CyberCoreLoaderManager.this.mInstallObserversList.get(i2);
                            if (cyberCoreInstallObserver3.mListener != null) {
                                cyberCoreInstallObserver3.mListener.onInstallError(message.arg1, message.arg2, (String) message.obj);
                            }
                            i2++;
                        }
                        CyberCoreLoaderManager.this.removeListener(message.arg1);
                    }
                }
            } else {
                synchronized (CyberCoreLoaderManager.this.mLock) {
                    while (i2 < CyberCoreLoaderManager.this.mInstallObserversList.size()) {
                        CyberCoreInstallObserver cyberCoreInstallObserver4 = (CyberCoreInstallObserver) CyberCoreLoaderManager.this.mInstallObserversList.get(i2);
                        if (cyberCoreInstallObserver4.mListener != null && CyberPlayerManager.isCoreLoaded(cyberCoreInstallObserver4.mType)) {
                            cyberCoreInstallObserver4.mListener.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        }
                        i2++;
                    }
                    CyberCoreLoaderManager.this.removeListener(message.arg1);
                }
            }
            super.handleMessage(message);
        }
    };
    public List<CyberCoreInstallObserver> mInstallObserversList = new ArrayList();
    public ExecutorService mLoadServer = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public class CyberCoreInstallObserver {
        public CyberPlayerManager.InstallListener mListener;
        public int mType;

        public CyberCoreInstallObserver(int i, CyberPlayerManager.InstallListener installListener) {
            this.mType = i;
            this.mListener = installListener;
        }
    }

    public static CyberCoreLoaderManager getInstance() {
        if (sInstance == null) {
            synchronized (CyberCoreLoaderManager.class) {
                if (sInstance == null) {
                    sInstance = new CyberCoreLoaderManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> addInstallOpts(Map<String, String> map) {
        if (Utils.isMainProcess() && map != null) {
            map.put(CyberCoreLoader.CYBER_MEDIA_DEX, CyberPlayerCoreInvoker.getCoreVersion());
            Map<String, String> libsVersion = CyberPlayerCoreInvoker.getLibsVersion(CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION);
            if (libsVersion != null) {
                map.putAll(libsVersion);
            }
        }
        return map;
    }

    @Keep
    public static String getLatestLoadedVersion(String str) {
        CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
        return cyberCfgManager.getPrefStr(LATEST_SUCCESS_LOADED_PREF_NAME + str, "");
    }

    public static Object getLibPath(int i) {
        if (mLibPathMap.isEmpty()) {
            CyberLog.i(TAG, "getLibPath failed: mLibPathMap is empty");
            return "";
        }
        return mLibPathMap.get(Integer.valueOf(i));
    }

    private boolean isCreateLoadTask(int i) {
        synchronized (this.mLock) {
            if (i != (this.sCurLoadingLibs & i)) {
                this.sCurLoadingLibs = i | this.sCurLoadingLibs;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeListener(int i) {
        Iterator<CyberCoreInstallObserver> it = this.mInstallObserversList.iterator();
        while (it.hasNext()) {
            if (it.next().mType == i) {
                it.remove();
            }
        }
        this.sCurLoadingLibs = (i ^ Integer.MAX_VALUE) & this.sCurLoadingLibs;
    }

    public void removeCyberCoreInstallObserver(CyberPlayerManager.InstallListener installListener) {
        synchronized (this.mLock) {
            if (this.mInstallObserversList != null) {
                CyberCoreInstallObserver cyberCoreInstallObserver = null;
                Iterator<CyberCoreInstallObserver> it = this.mInstallObserversList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CyberCoreInstallObserver next = it.next();
                    if (next.mListener == installListener) {
                        cyberCoreInstallObserver = next;
                        break;
                    }
                }
                if (cyberCoreInstallObserver != null) {
                    this.mInstallObserversList.remove(cyberCoreInstallObserver);
                }
            }
        }
    }

    public void addCyberCoreInstallObserver(int i, CyberPlayerManager.InstallListener installListener) {
        synchronized (this.mLock) {
            if (this.mInstallObserversList != null) {
                this.mInstallObserversList.add(0, new CyberCoreInstallObserver(i, installListener));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installTask(String str, int i, Map<String, String> map) {
        if (CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DpSessionDatasUploader.getInstance().init(this.mContext);
        DpInitKernelSession.getInstance().init();
        this.mInitDpTime = System.currentTimeMillis() - currentTimeMillis;
        CyberCoreLoader.getInstance().install(str, i, map, new CyberPlayerManager.InstallListener2() { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i2, int i3, String str2) {
                CyberCoreLoaderManager.this.uploadSession(i3, str2);
                Message obtainMessage = CyberCoreLoaderManager.this.mHandler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                obtainMessage.obj = str2;
                CyberCoreLoaderManager.this.mHandler.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
            public void onInstallInfo(int i2, int i3, Object obj) {
                Message obtainMessage = CyberCoreLoaderManager.this.mHandler.obtainMessage();
                switch (i2) {
                    case 100:
                    case 101:
                    case 102:
                        obtainMessage.what = 4;
                        obtainMessage.arg1 = i2;
                        obtainMessage.arg2 = i3;
                        obtainMessage.obj = obj;
                        CyberCoreLoaderManager.mLibPathMap.put(Integer.valueOf(i2), obtainMessage.obj);
                        CyberCoreLoaderManager.this.mHandler.sendMessage(obtainMessage);
                        return;
                    default:
                        return;
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i2, int i3) {
                Message obtainMessage = CyberCoreLoaderManager.this.mHandler.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                CyberCoreLoaderManager.this.mHandler.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i2, String str2) {
                boolean isMpReduceEnable = MediaPlayerReduceHelper.isMpReduceEnable();
                if (isMpReduceEnable) {
                    Message obtainMessage = CyberCoreLoaderManager.this.mHandler.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.arg1 = i2;
                    CyberCoreLoaderManager.this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
                }
                CyberCoreLoaderManager.this.uploadSession(0, "");
                if (Utils.isMainProcess() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_REMOTE_FORBIDDEN, false)) {
                    RemotePlayerFactory.getInstance().connectRemote(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), CyberCoreLoaderManager.this.addInstallOpts(CyberPlayerManager.getInstallOpts()), CyberPlayerManager.getPcdnType());
                }
                CyberCoreLoaderManager.this.saveSuccessLoadedVersion();
                if (!isMpReduceEnable) {
                    Message obtainMessage2 = CyberCoreLoaderManager.this.mHandler.obtainMessage();
                    obtainMessage2.what = 0;
                    obtainMessage2.arg1 = i2;
                    CyberCoreLoaderManager.this.mHandler.sendMessage(obtainMessage2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSuccessLoadedVersion() {
        if (Utils.isMainProcess()) {
            CyberCfgManager.getInstance().removePref("latest_success_loaded_cyber-media-dex");
            CyberCfgManager.getInstance().setPrefStr("latest_success_loaded_cyber-media-dex", CyberPlayerCoreInvoker.getCoreVersion());
            Map<String, String> libsVersion = CyberPlayerCoreInvoker.getLibsVersion(CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION);
            Map<String, String> libsVersion2 = CyberPlayerCoreInvoker.getLibsVersion(CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION);
            if (libsVersion != null && libsVersion2 != null) {
                for (Map.Entry<String, String> entry : libsVersion.entrySet()) {
                    CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
                    cyberCfgManager.removePref(LATEST_SUCCESS_LOADED_PREF_NAME + entry.getKey());
                    if (!TextUtils.isEmpty(libsVersion2.get(entry.getKey()))) {
                        CyberCfgManager cyberCfgManager2 = CyberCfgManager.getInstance();
                        cyberCfgManager2.setPrefStr(LATEST_SUCCESS_LOADED_PREF_NAME + entry.getKey(), libsVersion2.get(entry.getKey()));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadSession(int i, String str) {
        Object obj;
        Object obj2;
        HashMap hashMap = new HashMap();
        hashMap.put("loadcode", String.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("detail", str);
        }
        hashMap.put(LokiService.Constant.LOG_PROCESS_NAME, Utils.getProcessName());
        Map<String, String> libsVersion = CyberPlayerCoreInvoker.getLibsVersion(CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION);
        if (libsVersion != null) {
            hashMap.putAll(libsVersion);
        }
        String prefStr = CyberCfgManager.getInstance().getPrefStr(CyberCfgManager.SP_KEY_UPDATE_TYPE_BLACK, "");
        String prefStr2 = CyberCfgManager.getInstance().getPrefStr(CyberCfgManager.SP_KEY_UPDATE_VERSION_BLACK, "");
        if (!TextUtils.isEmpty(prefStr) && !TextUtils.isEmpty(prefStr2)) {
            hashMap.put("isallowupdate", "0");
            hashMap.put("updatetype", prefStr);
            hashMap.put("updateversion", prefStr2);
        }
        if (CyberCoreLoader.getInstance().getIsDowngradled()) {
            if (!CyberCoreLoader.getInstance().getIsDowngradled()) {
                obj2 = "0";
            } else {
                obj2 = "1";
            }
            hashMap.put("isdowngradled", obj2);
        }
        int downloadCount = CyberCoreLoader.getInstance().getDownloadCount();
        if (downloadCount > 0) {
            hashMap.put("download_count", String.valueOf(downloadCount));
            boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DOWNLOAD_ZIP_XCDN, true);
            if (!cfgBoolValue) {
                obj = "0";
            } else {
                obj = "1";
            }
            hashMap.put("cdn_type", obj);
            if (cfgBoolValue) {
                if (CyberCoreLoader.getInstance().getIsXCDNDownload()) {
                    hashMap.put("xcdn_degrade", "0");
                } else {
                    hashMap.put("xcdn_degrade", "1");
                    String xCDNFailInfo = CyberCoreLoader.getInstance().getXCDNFailInfo();
                    if (!TextUtils.isEmpty(xCDNFailInfo)) {
                        hashMap.put("xcdn_degrade_info", xCDNFailInfo);
                    }
                }
            }
        }
        if (i == 0) {
            long installTime = CyberCoreLoader.getInstance().getInstallTime(0);
            long installTime2 = CyberCoreLoader.getInstance().getInstallTime(1);
            long installTime3 = CyberCoreLoader.getInstance().getInstallTime(2);
            if (this.mStartLoadTime > 0) {
                hashMap.put("install_t_ms", String.valueOf(System.currentTimeMillis() - this.mStartLoadTime));
            }
            long j = this.mInitDpTime;
            if (j >= 0) {
                hashMap.put("init_dp_t_ms", String.valueOf(j));
            }
            if (installTime3 >= 0) {
                hashMap.put("init_cfg_t_ms", String.valueOf(installTime3));
            }
            if (installTime >= 0) {
                hashMap.put("loadcore_t_ms", String.valueOf(installTime));
            }
            if (installTime2 >= 0) {
                hashMap.put("loadlibs_t_ms", String.valueOf(installTime2));
            }
            hashMap.put(HiAnalyticsConstant.BI_KEY_INSTALL_TYPE, String.valueOf(CyberPlayerManager.getInstallType()));
        }
        this.mStartLoadTime = -1L;
        Utils.updateCyberVersionInfo();
        DpLibsInitSession.uploadSession(this.mContext, DpStatConstants.ACTION_LIB_LOAD_RESULT, hashMap);
    }

    public void load(final String str, final int i, final Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        if (this.mStartLoadTime == -1) {
            this.mStartLoadTime = System.currentTimeMillis();
            if (Utils.isMainProcess()) {
                UbcRemoteStat.getInstance().setMainProcTag(System.currentTimeMillis());
            }
        }
        this.mContext = CyberPlayerManager.getApplicationContext();
        synchronized (this.mLock) {
            if (CyberPlayerManager.isCoreLoaded(i)) {
                if (installListener != null) {
                    Message obtainMessage = this.mHandler.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = installListener;
                    this.mHandler.sendMessage(obtainMessage);
                }
                if (installListener != null) {
                    notifyLibPath();
                }
                return;
            }
            if (installListener != null) {
                this.mInstallObserversList.add(new CyberCoreInstallObserver(i, installListener));
            }
            if (isCreateLoadTask(i)) {
                this.mLoadServer.submit(new Runnable() { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CyberCoreLoaderManager.this.installTask(str, i, map);
                    }
                });
            }
        }
    }

    public void notifyLibPath() {
        try {
            for (Map.Entry<Integer, Object> entry : mLibPathMap.entrySet()) {
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = 4;
                obtainMessage.arg1 = entry.getKey().intValue();
                obtainMessage.obj = entry.getValue();
                this.mHandler.sendMessage(obtainMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
