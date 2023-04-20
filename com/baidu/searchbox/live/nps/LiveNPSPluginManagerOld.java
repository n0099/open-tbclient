package com.baidu.searchbox.live.nps;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleConfig;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveLoadStatusCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.interfaces.yy.YYStaticConfig;
import com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.jd1;
import com.baidu.tieba.ld1;
import com.baidu.tieba.md1;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveNPSPluginManagerOld {
    public static final String AUDIO_CREATE_LIVE_ROOM_H5 = "AUDIO_CREATE_LIVE_ROOM_H5";
    public static final String LIVE_SHOW_ADMIN_LIST = "LIVE_SHOW_ADMIN_LIST";
    public static final String LIVE_SHOW_CHECK_AR = "LIVE_SHOW_CHECK_AR";
    public static final String LIVE_SHOW_CREATE_ROOM = "LIVE_SHOW_CREATE_ROOM";
    public static final String LIVE_SHOW_ENTER_LIVE_ROOM = "LIVE_SHOW_ENTER_LIVE_ROOM";
    public static final String LIVE_SHOW_FANS_LIST = "LIVE_SHOW_FANS_LIST";
    public static final String LIVE_SHOW_FORBIDDEN_LIST = "LIVE_SHOW_FORBIDDEN_LIST";
    public static final String LIVE_SHOW_GUARD_LIST = "LIVE_SHOW_GUARD_LIST";
    public static final String LIVE_SHOW_LIVE_EXP = "LIVE_SHOW_LIVE_EXP";
    public static final String LIVE_SHOW_LOAD_AR = "LIVE_SHOW_LOAD_AR";
    public static final String LIVE_SHOW_REAL_AUTH = "LIVE_SHOW_REAL_AUTH";
    public static final String LIVE_SHOW_START_PATRONAGE = "LIVE_SHOW_START_PATRONAGE";
    public static final String LIVE_SHOW_START_PATRONS = "LIVE_SHOW_START_PATRONS";
    public static final String LIVE_SHOW_START_PAY = "LIVE_SHOW_START_PAY";
    public static final String LOAD_FROM_NPS_DOWNLOAD = "nps_download";
    public static final String LOAD_FROM_NPS_INSTALL = "nps_install";
    public static final String LOAD_FROM_NPS_LOAD = "nps_load";
    public static final String MEDIA_BJH_CREATE_LIVE_ROOM = "MEDIA_BJH_CREATE_LIVE_ROOM";
    public static final String MEDIA_ENTER_LIVE_ROOM = "MEDIA_ENTER_LIVE_ROOM";
    public static final String MEDIA_MASTER_ROUTER = "MEDIA_MASTER_ROUTER";
    public static final int MIX_ENTRANCE_INNER_VERSION = 507500003;
    public static final int MIX_NEW_ARCH_PLUGIN_VERSION = 508000000;
    public static final String NEW_CLEAR_RESOURCE_FILE = "NEW_CLEAR_RESOURCE_FILE";
    public static final String NEW_CREATE_LIVE_ROOM = "NEW_CREATE_LIVE_ROOM";
    public static final String NEW_GET_LIVE_ROOM_STATUS = "NEW_GET_LIVE_ROOM_STATUS";
    public static final String NEW_GET_LIVE_SDK_FILE_SIZE = "NEW_GET_LIVE_SDK_FILE_SIZE";
    public static final String NEW_GET_RESOURCE_FILE_SIZE = "NEW_GET_RESOURCE_FILE_SIZE";
    public static final String NEW_IS_HISTORY = "NEW_IS_HISTORY";
    public static final String NEW_ON_DISK_CLEAR_CACHE_CHANGE = "NEW_ON_DISK_CLEAR_CACHE_CHANGE";
    public static final String NPS_PLUGIN_IMPL_CLASS_NAME = "com.baidu.searchbox.live.LiveNPSPluginImpl";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String[] NPS_PLUGIN_SUB_PKG_GROUP = {YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1, YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2, "com.baidu.searchbox.yylive.extlib", LiveMediaPluginManager.BJH_PLUGIN_PKG_NAME, "com.baidu.searchbox.yylive.createlive", "com.baidu.searchbox.yylive.game", LiveYYPluginManager.YY_NPS_YYLIB_PKG_NAME, "com.baidu.searchbox.yylive.audiolive", "com.baidu.searchbox.yylive.friends"};
    public static final String PAGE_SLOT_PAGE_PLUGIN_INSTALL = "plugin_install";
    public static final String PAGE_SLOT_PAGE_PLUGIN_LOAD = "plugin_load";
    public static final String TAG = "LiveNPSPluginManagerOld";
    public static final String UBC_ID_CANCEL_JOIN_LIVE = "4417";
    public static final String UBC_ID_PLUGIN_END = "3185";
    public static final String UBC_ID_PLUGIN_PAGE_FLOW = "3121";
    public static final String UBC_ID_PLUGIN_START = "3186";
    public static final String YU_YIN_CREATE_LIVE_ROOM = "YU_YIN_CREATE_LIVE_ROOM";
    public static final String YU_YIN_ENTER_LIVE_ROOM = "YU_YIN_ENTER_LIVE_ROOM";
    public static final String YY_CUSTOMER_SERVICE = "YY_CUSTOMER_SERVICE";
    public static final String YY_ENTER_LIVE_ROOM = "YY_ENTER_LIVE_ROOM";
    public static final String YY_FEED_BACK = "YY_FEED_BACK";
    public static final String YY_LIVE_ROUTER = "YY_LIVE_ROUTER";
    public static final String YY_NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static final String YY_TEST_ENTER_LIVE_ROOM = "YY_TEST_ENTER_LIVE_ROOM";
    public AppInfoService appService;
    public boolean fromDownLoad;
    public Handler handler;
    public boolean isLoadingCanceled;
    public LiveNpsLoadingCallback loadingCallback;
    public PluginLoadCallback mCurrentCallback;
    public ILiveNPSPlugin mLiveNPSPlugin;
    public Handler mMainHandler;
    public Flow pageFlow;
    public ToastService toastService;
    public UBCManager ubcManager;

    /* loaded from: classes2.dex */
    public interface PluginLoadCallback {
        void onResult(int i, String str, Object obj, String str2);
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static LiveNPSPluginManagerOld instance = new LiveNPSPluginManagerOld();
    }

    private void checkHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadUpdatePackage() {
        NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.searchbox.livenps", new jd1() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.32
            @Override // com.baidu.tieba.jd1
            public void onProgress(long j, long j2) {
            }

            @Override // com.baidu.tieba.jd1
            public void onResult(int i, String str) {
            }
        }, new ld1() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.33
            @Override // com.baidu.tieba.ld1
            public void checkAuthorization(IBundleInfo iBundleInfo, int i, md1 md1Var) {
                if (md1Var != null) {
                    md1Var.onResult(1);
                }
            }
        }, 1);
    }

    public static LiveNPSPluginManagerOld getInstance() {
        return SingletonHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginInstallVersion() {
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps");
        if (bundleInfo == null) {
            return 0;
        }
        return bundleInfo.getVersionCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null) {
            return appInfoService.isDebug();
        }
        return false;
    }

    private void npsLoadChainInitMedia() {
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-Media");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
    }

    private void npsLoadChainInitOther() {
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-Other");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
    }

    private void npsLoadChainInitStart() {
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-StartLive");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
    }

    private void showLoading() {
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingStart();
        }
    }

    public void cancelLoading() {
        this.isLoadingCanceled = true;
        if (this.mLiveNPSPlugin != null) {
            try {
                if (getPluginInstallVersion() >= 500000000) {
                    this.mLiveNPSPlugin.getYYLiveEntry().cancelLoad();
                }
            } catch (AbstractMethodError e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelStartYYLiveActivity() {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin != null) {
            try {
                iLiveNPSPlugin.getYYLiveEntry().cancelStartYYLiveActivity();
            } catch (AbstractMethodError e) {
                e.printStackTrace();
            }
        }
    }

    public BundleInfo getInstalledPluginInfo() {
        return NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps");
    }

    public LiveNPSPluginManagerOld() {
        this.handler = new Handler(Looper.getMainLooper());
        this.fromDownLoad = false;
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.isLoadingCanceled = false;
    }

    private void logPluginVersionCode() {
        BundleInfo bundleInfo;
        if (NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.livenps") == 43 && (bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps")) != null) {
            Log.d("NPS", "NPS Installed live plugin version code " + bundleInfo.getVersionCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLog(String str) {
        NpsLoadChainLog.getInstance().dLog(str);
    }

    public static String getParamsStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf <= 0) {
            return null;
        }
        return str.substring(indexOf + 1);
    }

    public static Map<String, String> paramsJsonToMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof String) {
                hashMap.put(next, (String) opt);
            } else {
                hashMap.put(next, opt.toString());
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Type inference failed for r3v6. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public String parserYYSchemaUrl(String str) {
        HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
        boolean containsKey = stringToMap.containsKey("params");
        Map map = stringToMap;
        if (containsKey) {
            try {
                map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
            } catch (Exception unused) {
                map = null;
            }
        }
        if (map != null) {
            return map.get("url");
        }
        return "";
    }

    private void stopLoading(int i) {
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingEnd(i);
        }
    }

    public void clearResourceFile(@NonNull final Context context) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "NEW_CLEAR_RESOURCE_FILE", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.40
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin.clearLiveResourceSize(context);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.clearLiveResourceSize(context);
        }
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        this.loadingCallback = liveNpsLoadingCallback;
    }

    public void startAdminListActivity(@NonNull final Context context) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_ADMIN_LIST", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.18
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry().openAdminListPage(context);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().openAdminListPage(context);
        }
    }

    public void startForbiddenListActivity(@NonNull final Context context) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_FORBIDDEN_LIST", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.19
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry().openForbiddenListPage(context);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().openForbiddenListPage(context);
        }
    }

    public void startPatronageActivity(@NonNull final Context context) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_START_PATRONAGE", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.12
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry().enterPatronagePage(context);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterPatronagePage(context);
        }
    }

    public void startYYActivity(final Context context) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "YY_TEST_ENTER_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.26
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getYYLiveEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getYYLiveEntry().startYYActivity(context);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getYYLiveEntry() != null) {
            this.mLiveNPSPlugin.getYYLiveEntry().startYYActivity(context);
        }
    }

    public void dispatchLiveMasterRouter(@NonNull final Application application, final String str, final Map<String, Object> map) {
        npsLoadChainInitStart();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "MEDIA_MASTER_ROUTER", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.5
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveBjhEntry().dispatchLiveMasterRouter(application, str, map);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
            this.mLiveNPSPlugin.getLiveBjhEntry().dispatchLiveMasterRouter(application, str, map);
        }
    }

    public void startBjhMasterActivity(@NonNull final Application application, final String str, final Uri uri) {
        npsLoadChainInitStart();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "MEDIA_BJH_CREATE_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.3
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
            this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
        }
    }

    public void startFansListActivity(@NonNull final Context context, @NonNull final String str, final int i) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_FANS_LIST", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.14
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(context, str, i);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(context, str, i);
        }
    }

    public void startGuardianListActivity(@NonNull final Context context, @NonNull final String str, @NonNull final String str2) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_GUARD_LIST", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.15
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str3, Object obj, String str4) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(context, str, str2);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(context, str, str2);
        }
    }

    public void startLiveExpActivity(@NonNull final Context context, final long j, final int i) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_LIVE_EXP", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.16
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(context, j, i);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(context, j, i);
        }
    }

    public void startMasterActivity(@NonNull final Context context, @NonNull final String str, @NonNull String str2) {
        npsLoadChainInitStart();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "NEW_CREATE_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.7
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str3, Object obj, String str4) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin.startMasterActivity(context, str);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.startMasterActivity(context, str);
        }
    }

    public void startMasterActivityV2(@NonNull final Context context, @NonNull final String str, @NonNull final String str2) {
        npsLoadChainInitStart();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "NEW_CREATE_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.8
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str3, Object obj, String str4) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin.startMasterActivity(context, str, str2);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.startMasterActivity(context, str, str2);
        }
    }

    public void startRealAuthActivity(@NonNull final Context context, @NonNull final String str, @NonNull final String str2) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_REAL_AUTH", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.20
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str3, Object obj, String str4) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry().openRealAuthPage(context, str, str2);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().openRealAuthPage(context, str, str2);
        }
    }

    private int compareVersion(int i, int i2) {
        return (i / 1000) - (i2 / 1000);
    }

    public void checkArSdkLoadStatus(@NonNull Context context, @NonNull final LiveNpsArStatusCallback liveNpsArStatusCallback) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_CHECK_AR", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.23
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                liveNpsArStatusCallback.onArSdkStatus(LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry().isArSdkLoaded());
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            liveNpsArStatusCallback.onArSdkStatus(this.mLiveNPSPlugin.getLiveShowMasterEntry().isArSdkLoaded());
        }
    }

    public void getLiveResourceFileSize(@NonNull final Context context, @NonNull final ILiveFileSizeCallback iLiveFileSizeCallback) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "NEW_GET_RESOURCE_FILE_SIZE", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.39
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveResourceSize(context, iLiveFileSizeCallback);
                            return;
                        } catch (Exception e) {
                            iLiveFileSizeCallback.getFileSize(0L);
                            e.printStackTrace();
                            return;
                        }
                    }
                    iLiveFileSizeCallback.getFileSize(0L);
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.getLiveResourceSize(context, iLiveFileSizeCallback);
        }
    }

    public void getLiveRoomStatus(@NonNull final String str, @NonNull final LiveStatusDataCallback<String> liveStatusDataCallback) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "NEW_GET_LIVE_ROOM_STATUS", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.9
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
        }
    }

    public void getLiveSdkFileSize(@NonNull final Context context, @NonNull final ILiveFileSizeCallback iLiveFileSizeCallback) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "NEW_GET_LIVE_SDK_FILE_SIZE", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.38
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveSdkSize(context, iLiveFileSizeCallback);
                            return;
                        } catch (Exception e) {
                            iLiveFileSizeCallback.getFileSize(0L);
                            e.printStackTrace();
                            return;
                        }
                    }
                    iLiveFileSizeCallback.getFileSize(0L);
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.getLiveSdkSize(context, iLiveFileSizeCallback);
        }
    }

    public void isInHistory(@NonNull final String str, @NonNull final LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "NEW_IS_HISTORY", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.6
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
        }
    }

    public void startArSdkLoad(@NonNull Context context, @NonNull final LiveNpsArLoadCallback liveNpsArLoadCallback) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "LIVE_SHOW_LOAD_AR", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.24
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.24.1
                                    @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                    public void onProgress(int i2, int i3) {
                                        liveNpsArLoadCallback.onProgress(i2, i3);
                                    }

                                    @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                    public void onResult(boolean z, String str3) {
                                        liveNpsArLoadCallback.onResult(z, str3);
                                    }
                                });
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.25
                @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                public void onProgress(int i, int i2) {
                    liveNpsArLoadCallback.onProgress(i, i2);
                }

                @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                public void onResult(boolean z, String str) {
                    liveNpsArLoadCallback.onResult(z, str);
                }
            });
        }
    }

    public void startLiveShowActivity(@NonNull final Context context, @NonNull final String str) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_ENTER_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.10
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(context, str);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(context, str);
        }
    }

    public void startPatronsActivity(@NonNull final Context context, final String str) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_START_PATRONS", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.13
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry().enterPatrons(context, str);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterPatrons(context, str);
        }
    }

    public void startPayActivity(@NonNull final Context context, @NonNull final String str) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_START_PAY", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.11
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowEntry().enterPayPage(context, str);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterPayPage(context, str);
        }
    }

    public void startShowMasterActivity(@NonNull final Context context, final String str) {
        npsLoadChainInitStart();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "LIVE_SHOW_CREATE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.17
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(context, str);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(context, str);
        }
    }

    public void startYuYinCreateLiveRoomActivity(@NonNull final Context context, final String str) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "YU_YIN_CREATE_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.22
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveYuYinEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(context, str);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
            this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(context, str);
        }
    }

    public static String bundleToJsonStr(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return "";
    }

    public static HashMap<String, String> stringToMap(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str3 : str.split("&")) {
            String[] split = str3.split("=");
            try {
                String decode = URLDecoder.decode(split[0], "UTF-8");
                if (split.length > 1) {
                    str2 = URLDecoder.decode(split[1], "UTF-8");
                } else {
                    str2 = "";
                }
                hashMap.put(decode, str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkEntranceUpdate() {
        boolean z;
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
        if (bundleGroup != null) {
            BundleInfo bundleByType = bundleGroup.getBundleByType(3);
            BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
            boolean z2 = false;
            if (bundleByType == null) {
                if (bundleByType2 == null) {
                    z = false;
                } else {
                    z = bundleByType2.getVersionCode() < 508000000 ? true : true;
                }
                z2 = true;
                if (bundleByType != null && bundleByType.getVersionCode() < 508000000) {
                    z = true;
                    z2 = true;
                }
                if (!z2) {
                    if (z) {
                        NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.searchbox.yylive.entrance", new jd1() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.43
                            @Override // com.baidu.tieba.jd1
                            public void onProgress(long j, long j2) {
                            }

                            @Override // com.baidu.tieba.jd1
                            public void onResult(int i, String str) {
                            }
                        }, new ld1() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.44
                            @Override // com.baidu.tieba.ld1
                            public void checkAuthorization(IBundleInfo iBundleInfo, int i, md1 md1Var) {
                                if (md1Var != null) {
                                    md1Var.onResult(1);
                                }
                            }
                        }, 1);
                        return;
                    } else {
                        NPSPackageManager.getInstance().downloadBundle("com.baidu.searchbox.yylive.entrance", new jd1() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.45
                            @Override // com.baidu.tieba.jd1
                            public void onProgress(long j, long j2) {
                            }

                            @Override // com.baidu.tieba.jd1
                            public void onResult(int i, String str) {
                            }
                        });
                        return;
                    }
                }
                return;
            }
            z = false;
            if (bundleByType != null) {
                z = true;
                z2 = true;
            }
            if (!z2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkYYEntranceIsLoaded(final Context context, final String str) {
        if (getPluginInstallVersion() >= 500500000) {
            boolean isLoaded = this.mLiveNPSPlugin.getYYLiveEntry().isLoaded();
            dLog("checkYYEntranceIsLoaded，url = " + str + ",  isLoaded = " + isLoaded);
            if (!isLoaded) {
                this.mLiveNPSPlugin.getYYLiveEntry().loadPlugin(context, new LiveLoadStatusCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.28
                    @Override // com.baidu.searchbox.live.interfaces.callback.LiveLoadStatusCallback
                    public void onResult(boolean z) {
                        LiveNPSPluginManagerOld liveNPSPluginManagerOld = LiveNPSPluginManagerOld.this;
                        liveNPSPluginManagerOld.dLog("checkYYEntranceIsLoaded loadPlugin，是否成功 = " + z);
                        LiveNPSPluginManagerOld.this.realJumpToYYLiveActivity(context, str);
                    }
                });
                return;
            } else {
                realJumpToYYLiveActivity(context, str);
                return;
            }
        }
        this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logCancelJoinLive(String str, boolean z) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            if ("download".equals(str)) {
                str2 = "entrance_download";
            } else if ("install".equals(str)) {
                str2 = "entrance_install";
            } else if ("load".equals(str)) {
                str2 = "entrance_load";
            } else {
                str2 = "";
            }
            jSONObject.put("type", str2);
            jSONObject.put("value", "suc");
            if (z) {
                jSONObject.put("page", "yyshow");
            } else {
                jSONObject.put("page", "media");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UBCManager uBCManager = this.ubcManager;
        if (uBCManager != null) {
            uBCManager.onEvent("4417", jSONObject);
        }
    }

    public void startAudioMasterActivity(@NonNull final Application application, String str) {
        npsLoadChainInitStart();
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enter_outlive_commonwebview", "1");
            jSONObject.put("enter_outlive_weburl", "https://live.baidu.com/m/media/multipage/cb_start_broad/index.html?app_type=tieba&params=" + str);
            jSONObject.put("navigationBar", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "AUDIO_CREATE_LIVE_ROOM_H5", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.2
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                                if (LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(application, null, null, jSONObject.toString(), null);
                                }
                            } else {
                                LiveNPSPluginManagerOld.this.logCancelJoinLive(str3, false);
                                if (LiveNPSPluginManagerOld.this.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "cancel startLiveMediaActivity");
                                }
                            }
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveMediaEntry() != null) {
            this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(application, null, null, jSONObject.toString(), null);
        }
    }

    private void loadNPSPluginImpl(final boolean z, final String str, final PluginLoadCallback pluginLoadCallback) {
        final int i;
        BundleInfo bundleByType;
        Flow flow;
        boolean z2 = false;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.34
            @Override // java.lang.Runnable
            public void run() {
                BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
                if (bundleGroup == null) {
                    NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.yylive.entrance");
                    return;
                }
                BundleInfo bundleByType2 = bundleGroup.getBundleByType(3);
                if (bundleByType2 == null || bundleByType2.getVersionCode() < 507500003) {
                    BundleConfig bundleConfig = new BundleConfig();
                    bundleConfig.skipDownloadedBundle = true;
                    NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.yylive.entrance", 0, false, bundleConfig);
                }
            }
        }, "nps-preparebundle", 0);
        this.mCurrentCallback = pluginLoadCallback;
        Log.d(TAG, "NPS load from=" + str);
        new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.35
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i2, final String str2, final Object obj) {
                boolean z3;
                String str3;
                String str4;
                if (LiveNPSPluginManagerOld.this.ubcManager != null && LiveNPSPluginManagerOld.this.pageFlow != null) {
                    LiveNPSPluginManagerOld.this.ubcManager.flowEndSlot(LiveNPSPluginManagerOld.this.pageFlow, "plugin_load");
                }
                LiveNPSPluginManagerOld liveNPSPluginManagerOld = LiveNPSPluginManagerOld.this;
                int pluginInstallVersion = liveNPSPluginManagerOld.getPluginInstallVersion();
                boolean z4 = true;
                if (i2 == 14) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                String str5 = "load code" + i2;
                if (LiveNPSPluginManagerOld.this.fromDownLoad) {
                    str3 = "nps_download";
                } else {
                    str3 = "nps_install";
                }
                liveNPSPluginManagerOld.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, z3, str5, str3, str);
                if (i2 != 14) {
                    z4 = false;
                }
                LiveNPSPluginManagerOld.this.dLog("LiveNps加载结束~ invokeSucc = " + z4);
                NpsLoadChainLog.getInstance().endLoadClazzLiveNps(z4, i2);
                if (pluginLoadCallback != null) {
                    if (LiveNPSPluginManagerOld.this.fromDownLoad) {
                        str4 = "download";
                    } else {
                        str4 = "install";
                    }
                    final String str6 = str4;
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        LiveNPSPluginManagerOld.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.35.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveNPSPluginManagerOld.this.mCurrentCallback != null) {
                                    LiveNPSPluginManagerOld.this.mCurrentCallback.onResult(i2, str2, obj, str6);
                                    LiveNPSPluginManagerOld.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (LiveNPSPluginManagerOld.this.mCurrentCallback != null) {
                        LiveNPSPluginManagerOld.this.mCurrentCallback.onResult(i2, str2, obj, str6);
                        LiveNPSPluginManagerOld.this.mCurrentCallback = null;
                    }
                }
            }
        };
        final IInvokeCallback iInvokeCallback = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.36
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i2, final String str2, final Object obj) {
                boolean z3;
                boolean z4;
                if (i2 == 14) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                LiveNPSPluginManagerOld liveNPSPluginManagerOld = LiveNPSPluginManagerOld.this;
                liveNPSPluginManagerOld.dLog("LiveNps加载结束~ invokeSucc = " + z3);
                NpsLoadChainLog.getInstance().endLoadClazzLiveNps(z3, i2);
                if (LiveNPSPluginManagerOld.this.ubcManager != null && LiveNPSPluginManagerOld.this.pageFlow != null) {
                    LiveNPSPluginManagerOld.this.ubcManager.flowEndSlot(LiveNPSPluginManagerOld.this.pageFlow, "plugin_load");
                }
                LiveNPSPluginManagerOld liveNPSPluginManagerOld2 = LiveNPSPluginManagerOld.this;
                int pluginInstallVersion = liveNPSPluginManagerOld2.getPluginInstallVersion();
                if (i2 == 14) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                liveNPSPluginManagerOld2.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, z4, "load code" + i2, "nps_load", str);
                if (pluginLoadCallback != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        LiveNPSPluginManagerOld.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.36.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveNPSPluginManagerOld.this.mCurrentCallback != null) {
                                    LiveNPSPluginManagerOld.this.mCurrentCallback.onResult(i2, str2, obj, "load");
                                    LiveNPSPluginManagerOld.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (LiveNPSPluginManagerOld.this.mCurrentCallback != null) {
                        LiveNPSPluginManagerOld.this.mCurrentCallback.onResult(i2, str2, obj, "load");
                        LiveNPSPluginManagerOld.this.mCurrentCallback = null;
                    }
                }
            }
        };
        this.fromDownLoad = false;
        this.isLoadingCanceled = false;
        logPluginLoad("com.baidu.searchbox.livenps", str);
        if (isAvailable()) {
            this.fromDownLoad = false;
            UBCManager uBCManager = this.ubcManager;
            if (uBCManager != null && (flow = this.pageFlow) != null) {
                uBCManager.flowStartSlot(flow, "plugin_load", null);
            }
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
            if (bundleGroup != null && (bundleByType = bundleGroup.getBundleByType(2)) != null) {
                i = bundleByType.getVersionCode();
            } else {
                i = 0;
            }
            Log.d(TAG, "start load Class t=" + System.currentTimeMillis());
            if (NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(2) != null) {
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.37
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z3;
                        LiveNPSPluginManagerOld.this.dLog("开始安装LiveNps");
                        NpsLoadChainLog.getInstance().startInstallLiveNps();
                        BundleConfig bundleConfig = new BundleConfig();
                        if (i >= 508000000) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        bundleConfig.skipDownloadedBundle = z3;
                        bundleConfig.skipPresetBundle = true;
                        int prepareBundle = NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.livenps", 0, false, bundleConfig);
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                        npsLoadChainLog.setPluginVersion(LiveNPSPluginManagerOld.this.getPluginInstallVersion() + "");
                        LiveNPSPluginManagerOld.this.dLog("LiveNps安装结束~成功");
                        NpsLoadChainLog.getInstance().endInstallLiveNps(true, prepareBundle);
                        LiveNPSPluginManagerOld.this.dLog("开始加载LiveNps");
                        NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                        NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, 0, iInvokeCallback, false, bundleConfig);
                        LiveNPSPluginManagerOld.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.37.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass37 anonymousClass37 = AnonymousClass37.this;
                                if (!z) {
                                    return;
                                }
                                LiveNPSPluginManagerOld.this.downloadUpdatePackage();
                                LiveNPSPluginManagerOld.this.checkEntranceUpdate();
                            }
                        });
                    }
                }, "nps-preparebundle", 0);
                return;
            }
            dLog("开始加载LiveNps");
            NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
            BundleConfig bundleConfig = new BundleConfig();
            if (i >= 508000000) {
                z2 = true;
            }
            bundleConfig.skipDownloadedBundle = z2;
            bundleConfig.skipPresetBundle = true;
            NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, 0, iInvokeCallback, false, bundleConfig);
            if (z) {
                downloadUpdatePackage();
                checkEntranceUpdate();
                return;
            }
            return;
        }
        PluginLoadCallback pluginLoadCallback2 = this.mCurrentCallback;
        if (pluginLoadCallback2 != null) {
            pluginLoadCallback2.onResult(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT, "old arch can not install", null, "download");
            this.mCurrentCallback = null;
        }
        showNormalToast(R.string.obfuscated_res_0x7f0f0af3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginEnd(String str, int i, boolean z, String str2, String str3, String str4) {
        if (this.ubcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "live");
                jSONObject.put("type", "end_load");
                jSONObject.put("source", str3);
                if (z) {
                    jSONObject.put("value", "suc");
                } else {
                    jSONObject.put("value", a.g0);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkg", str);
                jSONObject2.put("ver", i);
                jSONObject2.put("useFrom", str4);
                jSONObject2.put("reason", str2);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.ubcManager.onEvent("3185", jSONObject);
        }
    }

    private void logPluginLoad(String str, String str2) {
        if (this.ubcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "live");
                jSONObject.put("type", "start_load");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkg", str);
                jSONObject2.put("useFrom", str2);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.ubcManager.onEvent("3186", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(final int i, final int i2) {
        ToastService toastService;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.42
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveNPSPluginManagerOld.this.appService != null && LiveNPSPluginManagerOld.this.toastService != null) {
                        LiveNPSPluginManagerOld.this.toastService.showNormal(LiveNPSPluginManagerOld.this.appService.getApplication(), LiveNPSPluginManagerOld.this.appService.getApplication().getResources().getString(i), i2);
                    }
                }
            });
            return;
        }
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null && (toastService = this.toastService) != null) {
            toastService.showNormal(appInfoService.getApplication(), this.appService.getApplication().getResources().getString(i), i2);
        }
    }

    /* JADX DEBUG: Type inference failed for r5v6. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    private String parseEntry(String str) {
        HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
        boolean containsKey = stringToMap.containsKey("params");
        Map map = stringToMap;
        if (containsKey) {
            try {
                map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
            } catch (Exception unused) {
                map = null;
            }
        }
        String str2 = "";
        if (map == null) {
            return "";
        }
        String str3 = map.get("tab");
        String str4 = map.get("tag");
        String str5 = map.get("source");
        StringBuilder sb = new StringBuilder();
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        sb.append("-");
        if (str4 != null) {
            str2 = str4;
        }
        sb.append(str2);
        sb.append("-");
        sb.append(str5);
        return sb.toString();
    }

    /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, String> parseYYLiveParamMap(String str) {
        HashMap hashMap = new HashMap();
        HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
        boolean containsKey = stringToMap.containsKey("params");
        Map map = stringToMap;
        if (containsKey) {
            try {
                map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
            } catch (Exception unused) {
                map = null;
            }
        }
        if (map != null) {
            String str2 = map.get("sid");
            String str3 = map.get(YyLiveRoomConfig.KEY_SSID);
            String str4 = map.get("anchorUid");
            String str5 = map.get("templateId");
            String str6 = map.get(YyLiveRoomConfig.KEY_STREAMINFO);
            if (str.contains("isMix=1")) {
                hashMap.put("PreJoinChannelType", "mix");
            } else {
                hashMap.put("PreJoinChannelType", "startYYLive");
            }
            hashMap.put("PreJoinChannelSid", str2);
            hashMap.put("PreJoinChannelSsid", str3);
            hashMap.put("PreJoinChannelTemplateId", str5);
            hashMap.put("PreJoinChannelAnchorId", str4);
            hashMap.put("PreJoinChannelStreamInfo", str6);
        }
        return hashMap;
    }

    /* JADX DEBUG: Type inference failed for r0v9. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void realJumpToYYLiveActivity(Context context, String str) {
        if (str.contains("&isMix=")) {
            HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
            boolean containsKey = stringToMap.containsKey("params");
            Map map = stringToMap;
            if (containsKey) {
                try {
                    map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
                } catch (Exception unused) {
                    map = null;
                }
            }
            if (map != null) {
                String str2 = map.get("roomId");
                String str3 = map.get("source");
                if (!map.containsKey("roomType")) {
                    map.put("roomType", "3");
                }
                startLiveMediaActivity(context, str2, str3, bundleToJsonStr(map), Uri.parse(str), true);
                return;
            }
            this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
            return;
        }
        this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
    }

    public void startYYCustomerServiceActivity(@NonNull final Context context, @NonNull final String str) {
        Log.d(TAG, "startYYCustomerServiceActivity t=" + System.currentTimeMillis());
        checkHandler();
        dLog("startYYCustomerServiceActivity--进入YY客服页面，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-CustomerService");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "YY_CUSTOMER_SERVICE", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.30
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(final int i, String str2, final Object obj, String str3) {
                    LiveNPSPluginManagerOld.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.30.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i == 14) {
                                try {
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getYYLiveEntry().startYYCustomerServiceActivity(context, str);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                    });
                }
            });
        } else {
            iLiveNPSPlugin.getYYLiveEntry().startYYCustomerServiceActivity(context, str);
        }
    }

    public void startYYFeedbackActivity(@NonNull final Context context, @NonNull final String str) {
        Log.d(TAG, "startYYFeedbackActivity t=" + System.currentTimeMillis());
        checkHandler();
        dLog("startYYFeedbackActivity--进入YY反馈页面，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-Feedback");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "YY_FEED_BACK", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.29
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(final int i, String str2, final Object obj, String str3) {
                    LiveNPSPluginManagerOld.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i == 14) {
                                try {
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getYYLiveEntry().startYYFeedbackActivity(context, str);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                    });
                }
            });
        } else {
            iLiveNPSPlugin.getYYLiveEntry().startYYFeedbackActivity(context, str);
        }
    }

    private void startLiveMediaActivity(final Context context, final String str, final String str2, final String str3, final Uri uri, boolean z) {
        if (!z) {
            npsLoadChainInitMedia();
        }
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "MEDIA_ENTER_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.1
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str4, Object obj, String str5) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                                if (LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(context, str, str2, str3, uri);
                                }
                            } else {
                                LiveNPSPluginManagerOld.this.logCancelJoinLive(str5, false);
                                if (LiveNPSPluginManagerOld.this.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "cancel startLiveMediaActivity");
                                }
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveMediaEntry() != null) {
            this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(context, str, str2, str3, uri);
        }
        if (isDebug()) {
            logPluginVersionCode();
        }
    }

    public void dispatchHostEvent(@NonNull Context context, @NonNull String str, Map<String, Object> map) {
        if (this.mLiveNPSPlugin != null) {
            if (map != null && !TextUtils.isEmpty(str) && context != null) {
                this.mLiveNPSPlugin.dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                this.mLiveNPSPlugin.getLiveMediaEntry().dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getYYLiveEntry() != null) {
                this.mLiveNPSPlugin.getYYLiveEntry().dispatchHostEvent(context, str, map);
            }
            if (getPluginInstallVersion() >= 503500000 && this.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                this.mLiveNPSPlugin.getLiveBjhEntry().dispatchHostEvent(context, str, map);
            }
        }
    }

    public void dispatchYYLiveRouter(@NonNull final Context context, @NonNull final String str) {
        if (YYStaticConfig.conf == null) {
            YYStaticConfig.conf = new HashMap<>();
        }
        YYStaticConfig.conf.put("hostSchemeParseBegin", Long.valueOf(System.currentTimeMillis()));
        checkHandler();
        dLog("dispatchYYLiveRouter--YY万能路由，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-Router");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        if (this.mLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "YY_LIVE_ROUTER", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.31
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(final int i, String str2, final Object obj, final String str3) {
                    LiveNPSPluginManagerOld.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.31.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (YYStaticConfig.conf == null) {
                                YYStaticConfig.conf = new HashMap<>();
                            }
                            if ("download".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "download");
                            } else if ("install".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "install");
                            } else if ("load".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "load");
                            }
                            AnonymousClass31 anonymousClass31 = AnonymousClass31.this;
                            String parserYYSchemaUrl = LiveNPSPluginManagerOld.this.parserYYSchemaUrl(str);
                            YYStaticConfig.conf.put("PreJoinChannelType", "Schema");
                            YYStaticConfig.conf.put("PreJoinChannelSchemaUrl", parserYYSchemaUrl);
                            LiveNPSPluginManagerOld liveNPSPluginManagerOld = LiveNPSPluginManagerOld.this;
                            liveNPSPluginManagerOld.dLog("schemaUrl = " + parserYYSchemaUrl);
                            if (i == 14) {
                                try {
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getYYLiveEntry().dispatchYYLiveRouter(context, str);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                    });
                }
            });
            return;
        }
        if (YYStaticConfig.conf == null) {
            YYStaticConfig.conf = new HashMap<>();
        }
        YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "direct");
        if (this.mLiveNPSPlugin.getYYLiveEntry() != null && !this.mLiveNPSPlugin.getYYLiveEntry().isLoaded()) {
            String parserYYSchemaUrl = parserYYSchemaUrl(str);
            YYStaticConfig.conf.put("PreJoinChannelType", "Schema");
            YYStaticConfig.conf.put("PreJoinChannelSchemaUrl", parserYYSchemaUrl);
            dLog("not load, schemaUrl = " + parserYYSchemaUrl);
        }
        this.mLiveNPSPlugin.getYYLiveEntry().dispatchYYLiveRouter(context, str);
    }

    public void startYYLiveActivity(final Context context, final String str) {
        Log.d(TAG, "startYYLiveActivity t=" + System.currentTimeMillis());
        if (YYStaticConfig.conf == null) {
            YYStaticConfig.conf = new HashMap<>();
        }
        YYStaticConfig.conf.put("hostJoinLiveBegin", Long.valueOf(System.currentTimeMillis()));
        UBCManager uBCManager = this.ubcManager;
        if (uBCManager != null) {
            this.pageFlow = uBCManager.beginFlow("3121");
        }
        dLog("startYYLiveActivity--进入YY直播间，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry(parseEntry(str));
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        if (this.mLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "YY_ENTER_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.27
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                    LiveNPSPluginManagerOld liveNPSPluginManagerOld = LiveNPSPluginManagerOld.this;
                    liveNPSPluginManagerOld.dLog("startYYLiveActivity.PluginLoadCallback.onResult()，retCode = " + i + ", retMsg = " + str2 + ", retObject = " + obj + ", loadType = " + str3);
                    if (i == 14) {
                        try {
                            if (YYStaticConfig.conf == null) {
                                YYStaticConfig.conf = new HashMap<>();
                            }
                            if ("download".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "download");
                            } else if ("install".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "install");
                            } else if ("load".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "load");
                            }
                            Map<? extends String, ? extends Object> parseYYLiveParamMap = LiveNPSPluginManagerOld.this.parseYYLiveParamMap(str);
                            LiveNPSPluginManagerOld liveNPSPluginManagerOld2 = LiveNPSPluginManagerOld.this;
                            liveNPSPluginManagerOld2.dLog("parseYYLiveParamMap " + parseYYLiveParamMap);
                            YYStaticConfig.conf.putAll(parseYYLiveParamMap);
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                                if (LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getYYLiveEntry() != null) {
                                    if (LiveNPSPluginManagerOld.this.pageFlow != null) {
                                        YYStatInfo yYStatInfo = new YYStatInfo();
                                        yYStatInfo.flowObj = LiveNPSPluginManagerOld.this.pageFlow;
                                        yYStatInfo.isColdLaunch = true;
                                        yYStatInfo.loadType = str3;
                                        LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getYYLiveEntry().updateStatInfo(yYStatInfo);
                                        LiveNPSPluginManagerOld.this.pageFlow = null;
                                    }
                                    LiveNPSPluginManagerOld.this.checkYYEntranceIsLoaded(context, str);
                                    return;
                                }
                                return;
                            }
                            LiveNPSPluginManagerOld.this.logCancelJoinLive(str3, true);
                            if (LiveNPSPluginManagerOld.this.isDebug()) {
                                Log.w(LiveNPSPluginManagerOld.TAG, "cancel startYYLiveActivity");
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
            return;
        }
        if (YYStaticConfig.conf == null) {
            YYStaticConfig.conf = new HashMap<>();
        }
        YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "direct");
        if (this.mLiveNPSPlugin.getYYLiveEntry() != null) {
            if (this.pageFlow != null) {
                YYStatInfo yYStatInfo = new YYStatInfo();
                yYStatInfo.flowObj = this.pageFlow;
                yYStatInfo.isColdLaunch = false;
                yYStatInfo.loadType = "launch";
                try {
                    this.mLiveNPSPlugin.getYYLiveEntry().updateStatInfo(yYStatInfo);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.pageFlow = null;
            }
            if (!this.mLiveNPSPlugin.getYYLiveEntry().isLoaded()) {
                Map<String, String> parseYYLiveParamMap = parseYYLiveParamMap(str);
                dLog("not load parseYYLiveParamMap " + parseYYLiveParamMap);
                YYStaticConfig.conf.putAll(parseYYLiveParamMap);
            }
            checkYYEntranceIsLoaded(context, str);
        }
    }

    public boolean isAvailable() {
        int bundleStatus = NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.livenps");
        if (bundleStatus != 43) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
            }
            return false;
        }
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
        if (bundleGroup == null) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: top plugin is null");
            }
            return false;
        }
        BundleInfo bundleByType = bundleGroup.getBundleByType(3);
        BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
        if (bundleByType2 != null) {
            bundleByType = bundleByType2;
        }
        if (bundleByType == null) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: top plugin has no update");
            }
            return true;
        }
        int length = NPS_PLUGIN_SUB_PKG_GROUP.length;
        BundleInfoGroup[] bundleInfoGroupArr = new BundleInfoGroup[length];
        boolean z = true;
        for (int i = 0; i < length; i++) {
            bundleInfoGroupArr[i] = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_SUB_PKG_GROUP[i]);
            if (bundleInfoGroupArr[i] != null) {
                z = false;
            }
        }
        if (z) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: sec plugin not exist");
            }
            return true;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bundleInfoGroupArr[i2] != null) {
                BundleInfo bundleByType3 = bundleInfoGroupArr[i2].getBundleByType(3);
                if (bundleByType3 != null && compareVersion(bundleByType.getVersionCode(), bundleByType3.getVersionCode()) < 0) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: installed " + bundleByType3.getPackageName() + " plugin too high");
                    }
                    return false;
                }
                BundleInfo bundleByType4 = bundleInfoGroupArr[i2].getBundleByType(1);
                BundleInfo bundleByType5 = bundleInfoGroupArr[i2].getBundleByType(2);
                if (bundleByType4 != null && bundleByType4.needForceUpdate() && compareVersion(bundleByType.getVersionCode(), bundleByType4.getVersionCode()) < 0) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: sec " + bundleByType4.getPackageName() + " plugin force update1");
                    }
                    return false;
                } else if (bundleByType4 == null && bundleByType5 != null && bundleByType5.needForceUpdate() && compareVersion(bundleByType.getVersionCode(), bundleByType5.getVersionCode()) < 0) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: sec " + bundleByType5.getPackageName() + " plugin force update2");
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void onDiskClearCacheChange(final long j, final int i, final int i2, final ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Log.d(TAG, "start DiskClearCacheChange t=" + System.currentTimeMillis());
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "NEW_ON_DISK_CLEAR_CACHE_CHANGE", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.41
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i3, String str, Object obj, String str2) {
                    Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                    if (i3 == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            });
            return;
        }
        try {
            iLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void startBjhMasterActivityNew(@NonNull final Context context, final String str, final Uri uri) {
        if (getPluginInstallVersion() >= 506000000) {
            npsLoadChainInitStart();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "MEDIA_BJH_CREATE_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.4
                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        if (i == 14) {
                            try {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                    LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivityNew(context, str, uri);
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                            LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                        if (LiveNPSPluginManagerOld.this.isDebug()) {
                            Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                        }
                    }
                });
                return;
            } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
                this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivityNew(context, str, uri);
                return;
            } else {
                return;
            }
        }
        startBjhMasterActivity((Application) context.getApplicationContext(), str, uri);
    }

    public void startLiveMediaActivity(Context context, String str, String str2, String str3, Uri uri) {
        startLiveMediaActivity(context, str, str2, str3, uri, false);
    }

    public void startYuYinActivity(@NonNull final Context context, @NonNull final String str, @NonNull final String str2, final Map<String, Object> map) {
        npsLoadChainInitOther();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "YU_YIN_ENTER_LIVE_ROOM", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.21
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                public void onResult(int i, String str3, Object obj, String str4) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManagerOld.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveNPSPluginManagerOld.this.isLoadingCanceled && LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveYuYinEntry() != null) {
                                LiveNPSPluginManagerOld.this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinLiveActivity(context, str, str2, map);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManagerOld.this.isLoadingCanceled) {
                        LiveNPSPluginManagerOld.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveNPSPluginManagerOld.this.isDebug()) {
                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
            this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinLiveActivity(context, str, str2, map);
        }
    }
}
