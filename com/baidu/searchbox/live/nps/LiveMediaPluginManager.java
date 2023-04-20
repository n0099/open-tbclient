package com.baidu.searchbox.live.nps;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.live.goback.IYYGobackController;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.FloatingService;
import com.baidu.searchbox.live.interfaces.service.LiveYalogService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.smallwindow.IYYSmallWindowController;
import com.baidu.searchbox.live.interfaces.storage.IYYStorageController;
import com.baidu.searchbox.live.interfaces.yalog.LiveYalogApi;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.mix.proxy.LiveMixShellManager;
import com.baidu.searchbox.live.recommendmore.ILiveRecMoreController;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.tieba.R;
import com.baidu.tieba.jd1;
import com.baidu.tieba.ld1;
import com.baidu.tieba.md1;
import com.baidu.ubc.UBCManager;
import com.bumptech.glide.load.engine.GlideException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveMediaPluginManager {
    public static final String AUDIO_CREATE_LIVE_ROOM_H5 = "AUDIO_CREATE_LIVE_ROOM_H5";
    public static final int LIVE_PLUGIN_SUPPORT_GET_PLAY_CONFIG_MIM_VERSION = 601500000;
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
    public static final String MEDIA_BUSINESS_PKG_NAME = "com.baidu.live.media.business";
    public static final String MEDIA_ENTER_LIVE_ROOM = "MEDIA_ENTER_LIVE_ROOM";
    public static final String MEDIA_MASTER_ROUTER = "MEDIA_MASTER_ROUTER";
    public static final String NEW_CLEAR_RESOURCE_FILE = "NEW_CLEAR_RESOURCE_FILE";
    public static final String NEW_CREATE_LIVE_ROOM = "NEW_CREATE_LIVE_ROOM";
    public static final String NEW_GET_LIVE_ROOM_STATUS = "NEW_GET_LIVE_ROOM_STATUS";
    public static final String NEW_GET_LIVE_SDK_FILE_SIZE = "NEW_GET_LIVE_SDK_FILE_SIZE";
    public static final String NEW_GET_RESOURCE_FILE_SIZE = "NEW_GET_RESOURCE_FILE_SIZE";
    public static final String NEW_IS_HISTORY = "NEW_IS_HISTORY";
    public static final String NEW_ON_DISK_CLEAR_CACHE_CHANGE = "NEW_ON_DISK_CLEAR_CACHE_CHANGE";
    public static final String NPS_PLUGIN_IMPL_CLASS_NAME = "com.baidu.searchbox.live.LiveNPSPluginImpl";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String PAGE_SLOT_PAGE_PLUGIN_INSTALL = "plugin_install";
    public static final String PAGE_SLOT_PAGE_PLUGIN_LOAD = "plugin_load";
    public static final String TAG = "LIVE_PLUGIN";
    public static final String UBC_ID_PLUGIN_END = "3185";
    public static final String UBC_ID_PLUGIN_START = "3186";
    public static final String USE_FROM_FETCH_RECOM = "reccom";
    public static final String USE_FROM_MIX_LOAD_PLUGIN = "mixLoadPlugin";
    public static final String USE_FROM_START_LIVE_PAGE = "startLiveActivity";
    public static final String YU_YIN_CREATE_LIVE_ROOM = "YU_YIN_CREATE_LIVE_ROOM";
    public static final String YU_YIN_ENTER_LIVE_ROOM = "YU_YIN_ENTER_LIVE_ROOM";
    public static final String YY_CUSTOMER_SERVICE = "YY_CUSTOMER_SERVICE";
    public static final String YY_ENTER_LIVE_ROOM = "YY_ENTER_LIVE_ROOM";
    public static final String YY_FEED_BACK = "YY_FEED_BACK";
    public static final String YY_LIVE_ROUTER = "YY_LIVE_ROUTER";
    public static final String YY_TEST_ENTER_LIVE_ROOM = "YY_TEST_ENTER_LIVE_ROOM";
    public AppInfoService appService;
    public boolean fromDownLoad;
    public Handler handler;
    public boolean isLoadingCanceled;
    public LiveNpsLoadingCallback loadingCallback;
    public PluginLoadCallback mCurrentCallback;
    public Handler mHandler;
    public HashMap<String, Object> mLaunchInfo;
    public ILiveNPSPlugin mLiveNPSPlugin;
    public volatile boolean mLiveNpsPreload;
    public ToastService toastService;
    public UBCManager ubcManager;
    public LiveYalogApi yalogApi;
    public LiveYalogService yalogService;
    public static final String BJH_PLUGIN_PKG_NAME = "com.baidu.searchbox.bjhlivenps";
    public static final String[] NPS_PLUGIN_SUB_PKG_GROUP = {BJH_PLUGIN_PKG_NAME, "com.baidu.live.media.business"};

    /* loaded from: classes2.dex */
    public interface PluginLoadCallback {
        void onResult(int i, String str, Object obj, String str2);
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static final LiveMediaPluginManager INSTANCE = new LiveMediaPluginManager();
    }

    public static LiveMediaPluginManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null) {
            return appInfoService.isDebug();
        }
        return false;
    }

    private void preDownloadMediaBusinessPlugin() {
        if (isDebug()) {
            dLog("preDownloadMediaBusinessPlugin 预加载媒体二级插件");
            Log.d(TAG, "preDownloadYYPluginForCreateLive: + com.baidu.live.media.business start Download");
        }
        NPSPackageManager.getInstance().downloadBundle("com.baidu.live.media.business", new jd1() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.10
            @Override // com.baidu.tieba.jd1
            public void onProgress(long j, long j2) {
                if (LiveMediaPluginManager.this.isDebug()) {
                    LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                    liveMediaPluginManager.dLog("preDownloadMediaBusinessPlugin 媒体二级插件进度 total = " + j2 + ", current = " + j);
                    Log.d(LiveMediaPluginManager.TAG, "preDownloadYYPluginForCreateLive: + com.baidu.live.media.business is Downloading, cur=" + j + " total=" + j2);
                }
            }

            @Override // com.baidu.tieba.jd1
            public void onResult(int i, String str) {
                if (LiveMediaPluginManager.this.isDebug()) {
                    if (i == 2) {
                        LiveMediaPluginManager.this.dLog("preDownloadMediaBusinessPlugin 媒体二级插件加载【成功】");
                        Log.d(LiveMediaPluginManager.TAG, "preDownloadYYPluginForCreateLive: + com.baidu.live.media.business Download succeed");
                        return;
                    }
                    LiveMediaPluginManager.this.dLog("preDownloadMediaBusinessPlugin 媒体二级插件加载【~失败~】");
                    Log.d(LiveMediaPluginManager.TAG, "preDownloadYYPluginForCreateLive: + com.baidu.live.media.business Download failed, code=" + i + " msg=" + str);
                }
            }
        });
    }

    private void showLoading() {
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingStart();
        }
    }

    public void cancelLoading() {
        this.isLoadingCanceled = true;
    }

    public int getPluginInstallVersion() {
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps");
        if (bundleInfo == null) {
            return 0;
        }
        return bundleInfo.getVersionCode();
    }

    public IYYStorageController getStorageOptInfoHelperInterface() {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null) {
            return this.mLiveNPSPlugin.getLiveMediaEntry().getStorageOptInfoHelperInterface();
        }
        return null;
    }

    public IYYGobackController getYYGobackController() {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null) {
            return this.mLiveNPSPlugin.getLiveMediaEntry().getYYGobackController();
        }
        return null;
    }

    public LiveMediaPluginManager() {
        this.fromDownLoad = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.mLiveNpsPreload = false;
        this.isLoadingCanceled = false;
        this.yalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
        this.yalogApi = null;
        this.handler = new Handler(Looper.getMainLooper());
        LiveYalogService liveYalogService = this.yalogService;
        if (liveYalogService != null) {
            this.yalogApi = liveYalogService.buildYalogApi("live_plugin");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadUpdatePackage() {
        NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.searchbox.livenps", new jd1() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.17
            @Override // com.baidu.tieba.jd1
            public void onProgress(long j, long j2) {
            }

            @Override // com.baidu.tieba.jd1
            public void onResult(int i, String str) {
            }
        }, new ld1() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.18
            @Override // com.baidu.tieba.ld1
            public void checkAuthorization(IBundleInfo iBundleInfo, int i, md1 md1Var) {
                if (md1Var != null) {
                    md1Var.onResult(1);
                }
            }
        }, 1);
        BundleInfo bundleByType = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(3);
        BundleInfo bundleByType2 = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(1);
        if (bundleByType != null && bundleByType2 != null && bundleByType.getVersionCode() < 505500000 && bundleByType2.getVersionCode() >= 505500000) {
            pluginYaLog("downloadUpdatePackage and need preDownloadMediaBusinessPlugin");
            preDownloadMediaBusinessPlugin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLog(String str) {
        if (isDebug()) {
            Log.e("David990099", str);
        }
    }

    private void pluginYaLog(String str) {
        LiveYalogApi liveYalogApi = this.yalogApi;
        if (liveYalogApi != null) {
            liveYalogApi.w("3036", "load-livenps-plugin", str);
        }
        if (isDebug()) {
            Log.e("load-livenps-plugin", "LiveMediaPluginManager load-livenps-plugin msg = " + str);
        }
    }

    private void preLoadLiveNps(final long j) {
        dLog("LiveMediaPluginManager preLoadLiveNps " + j);
        NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.11
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(int i, String str, Object obj) {
                LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                liveMediaPluginManager.dLog("preLoadLiveNps onResult code = " + i + ", msg = " + str + ", clazz = " + obj + ", time = " + (System.currentTimeMillis() - j));
                if (i != 14) {
                    return;
                }
                LiveMediaPluginManager.this.mLiveNpsPreload = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading(int i) {
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingEnd(i);
        }
    }

    public int getInstallPluginVersion(String str) {
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(str);
        if (bundleInfo == null) {
            return 0;
        }
        return bundleInfo.getVersionCode();
    }

    public ILiveRecMoreController getRecMoreController(Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null) {
            return this.mLiveNPSPlugin.getLiveMediaEntry().getRecMoreController(context);
        }
        return null;
    }

    public void onYYJoinChannelSuc(String str) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null) {
            this.mLiveNPSPlugin.getLiveMediaEntry().onYYJoinChannelSuc(str);
        }
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        this.loadingCallback = liveNpsLoadingCallback;
    }

    private int compareVersion(int i, int i2) {
        return (i / 1000) - (i2 / 1000);
    }

    public void getLiveRoomStatus(@NonNull final String str, @NonNull final LiveStatusDataCallback<String> liveStatusDataCallback) {
        dLog("LiveMediaPluginManager getLiveRoomStatus " + str);
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, false, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.4
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveMediaPluginManager.this.isDebug()) {
                        Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                    }
                }
            }, "getLiveRoomStatus", LiveNpsRuntime.getApplication());
        } else {
            iLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
        }
    }

    public Map<String, Object> getMediaLivePlayConfig(String str, Map<String, Object> map) {
        if (this.mLiveNPSPlugin != null && getInstallPluginVersion("com.baidu.searchbox.livenps") >= 601500000) {
            return this.mLiveNPSPlugin.getPlayConfig(str, map);
        }
        return null;
    }

    public void dispatchHostEvent(Context context, String str, Map<String, Object> map) {
        dLog("LiveMediaPluginManager dispatchHostEvent " + str);
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin != null) {
            iLiveNPSPlugin.dispatchHostEvent(context, str, map);
            if (this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                this.mLiveNPSPlugin.getLiveMediaEntry().dispatchHostEvent(context, str, map);
            }
        }
    }

    public void dispatchLiveMasterRouter(@NonNull final Application application, final String str, final Map<String, Object> map) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, false, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.9
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveMediaPluginManager.this.isLoadingCanceled && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveBjhEntry().dispatchLiveMasterRouter(application, str, map);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveMediaPluginManager.this.isLoadingCanceled) {
                        LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveMediaPluginManager.this.isDebug()) {
                        Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                    }
                }
            }, "dispatchLiveMasterRouter", application);
        } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
            this.mLiveNPSPlugin.getLiveBjhEntry().dispatchLiveMasterRouter(application, str, map);
        }
    }

    private void loadLiveNpsPlugin(Context context, String str, String str2, final com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback) {
        dLog("LiveMediaPluginManager loadLiveNpsPlugin " + this.mLiveNPSPlugin);
        if (this.mLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, true, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.2
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str3, Object obj, String str4) {
                    LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                    liveMediaPluginManager.dLog("LiveMediaPluginManager loadLiveNpsPluginonResult " + i + GlideException.IndentedAppendable.INDENT + str3 + GlideException.IndentedAppendable.INDENT + obj + GlideException.IndentedAppendable.INDENT + str4);
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (pluginLoadCallback != null) {
                                pluginLoadCallback.onResult(true, i, str3);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            LiveMediaPluginManager liveMediaPluginManager2 = LiveMediaPluginManager.this;
                            liveMediaPluginManager2.dLog("LiveMediaPluginManager loadLiveNpsPluginException " + e.getMessage());
                            return;
                        }
                    }
                    com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback2 = pluginLoadCallback;
                    if (pluginLoadCallback2 != null) {
                        pluginLoadCallback2.onResult(false, i, str3);
                    }
                }
            }, str2, str, context);
        } else if (pluginLoadCallback != null) {
            pluginLoadCallback.onResult(true, 14, "");
        }
    }

    public void setSmallWindowSwitch(final boolean z, final Activity activity, final FloatingService.OnPermissionResultListener onPermissionResultListener, final FloatingService.OnPermissionCancelListener onPermissionCancelListener) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, false, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.19
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                    liveMediaPluginManager.dLog("LiveMediaPluginManager smallWindowSwitch loadPluginonResult " + i + GlideException.IndentedAppendable.INDENT + str + GlideException.IndentedAppendable.INDENT + obj + GlideException.IndentedAppendable.INDENT + str2);
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveMediaPluginManager.this.mLiveNPSPlugin != null && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry() != null && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() != null) {
                                LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().setSmallWindowSwitch(z, activity, onPermissionResultListener, onPermissionCancelListener);
                            }
                        } catch (Exception e) {
                            LiveMediaPluginManager liveMediaPluginManager2 = LiveMediaPluginManager.this;
                            liveMediaPluginManager2.dLog("LiveMediaPluginManager smallWindowSwitch loadPluginException " + e.getMessage());
                        }
                    }
                }
            }, "setSmallWindowSwitch", activity);
        } else if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null && this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() != null) {
            this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().setSmallWindowSwitch(z, activity, onPermissionResultListener, onPermissionCancelListener);
        }
    }

    private void loadNPSPluginImpl(boolean z, boolean z2, PluginLoadCallback pluginLoadCallback, String str, Context context) {
        loadNPSPluginImpl(z, z2, pluginLoadCallback, str, "", "", context);
    }

    private void loadNPSPluginImpl(boolean z, boolean z2, PluginLoadCallback pluginLoadCallback, String str, String str2, Context context) {
        loadNPSPluginImpl(z, z2, pluginLoadCallback, str, "", str2, context);
    }

    private void loadNPSPluginImpl(boolean z, final boolean z2, final PluginLoadCallback pluginLoadCallback, String str, final String str2, String str3, Context context) {
        this.mCurrentCallback = pluginLoadCallback;
        Log.d(TAG, "NPS load from=" + str2);
        final IInvokeCallback iInvokeCallback = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.12
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i, final String str4, final Object obj) {
                boolean z3;
                String str5;
                String str6;
                LiveMixShellManager.INSTANCE.enterFlowEndSlot("plugin_load");
                LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                int pluginInstallVersion = liveMediaPluginManager.getPluginInstallVersion();
                boolean z4 = true;
                if (i == 14) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                String str7 = "load code" + i;
                if (LiveMediaPluginManager.this.fromDownLoad) {
                    str5 = "nps_download";
                } else {
                    str5 = "nps_install";
                }
                liveMediaPluginManager.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, z3, str7, str5, str2);
                LiveMediaPluginManager liveMediaPluginManager2 = LiveMediaPluginManager.this;
                StringBuilder sb = new StringBuilder();
                sb.append("LiveNps加载结束~proxyInstallCallback invokeSucc = ");
                if (i != 14) {
                    z4 = false;
                }
                sb.append(z4);
                liveMediaPluginManager2.dLog(sb.toString());
                if (pluginLoadCallback != null) {
                    if (LiveMediaPluginManager.this.fromDownLoad) {
                        str6 = "download";
                    } else {
                        str6 = "install";
                    }
                    final String str8 = str6;
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        LiveMediaPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveMediaPluginManager.this.mCurrentCallback != null) {
                                    LiveMediaPluginManager.this.mCurrentCallback.onResult(i, str4, obj, str8);
                                    LiveMediaPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (LiveMediaPluginManager.this.mCurrentCallback != null) {
                        LiveMediaPluginManager.this.mCurrentCallback.onResult(i, str4, obj, str8);
                        LiveMediaPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        final IInvokeCallback iInvokeCallback2 = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.13
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i, final String str4, final Object obj) {
                boolean z3;
                boolean z4;
                LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                StringBuilder sb = new StringBuilder();
                sb.append("LiveNps加载结束~ proxyLoadCallback invokeSucc = ");
                if (i == 14) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                sb.append(z3);
                liveMediaPluginManager.dLog(sb.toString());
                LiveMixShellManager.INSTANCE.enterFlowEndSlot("plugin_load");
                LiveMediaPluginManager liveMediaPluginManager2 = LiveMediaPluginManager.this;
                int pluginInstallVersion = liveMediaPluginManager2.getPluginInstallVersion();
                if (i == 14) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                liveMediaPluginManager2.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, z4, "load code" + i, "nps_load", str2);
                if (pluginLoadCallback != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        LiveMediaPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveMediaPluginManager.this.mCurrentCallback != null) {
                                    LiveMediaPluginManager.this.mCurrentCallback.onResult(i, str4, obj, "load");
                                    LiveMediaPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (LiveMediaPluginManager.this.mCurrentCallback != null) {
                        LiveMediaPluginManager.this.mCurrentCallback.onResult(i, str4, obj, "load");
                        LiveMediaPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        this.fromDownLoad = false;
        this.isLoadingCanceled = false;
        logPluginLoad("com.baidu.searchbox.livenps", str2);
        if (isAvailable()) {
            this.fromDownLoad = false;
            LiveMixShellManager.INSTANCE.enterFlowStartSlot("plugin_load", null);
            Log.d(TAG, "start load Class t=" + System.currentTimeMillis());
            if (NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(2) != null) {
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.14
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveMediaPluginManager.this.dLog("isAvailable，开始安装LiveNps");
                        if (NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.livenps") != 41) {
                            iInvokeCallback2.onResult(-58, "NPS prepareBundle failed", null);
                        } else {
                            LiveMediaPluginManager.this.dLog("isAvailable，LiveNps安装结束~成功");
                            LiveMediaPluginManager.this.dLog("isAvailable，开始加载LiveNps");
                            NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, iInvokeCallback2);
                        }
                        LiveMediaPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                if (!z2) {
                                    return;
                                }
                                LiveMediaPluginManager.this.downloadUpdatePackage();
                            }
                        });
                    }
                }, "nps-preparebundle", 0);
                return;
            }
            dLog("isAvailable，直接加载LiveNps");
            NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, iInvokeCallback2);
            if (z2) {
                downloadUpdatePackage();
                return;
            }
            return;
        }
        if (z2) {
            showLoading();
        }
        LiveMixShellManager.INSTANCE.enterFlowStartSlot("plugin_install", null);
        this.fromDownLoad = false;
        Log.d(TAG, "start install bundle t=" + System.currentTimeMillis());
        dLog("not available，下载LiveNps插件 = com.baidu.searchbox.livenps");
        NPSPackageManager.getInstance().installBundle("com.baidu.searchbox.livenps", new IInstallCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.15
            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onProgress(long j, long j2) {
                LiveMediaPluginManager.this.fromDownLoad = true;
                if (LiveMediaPluginManager.this.loadingCallback != null && !LiveMediaPluginManager.this.isLoadingCanceled) {
                    LiveMediaPluginManager.this.loadingCallback.onLoadingProgress(j, j2);
                }
                LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                liveMediaPluginManager.dLog("not available，downloadSize = " + j + ", totalSIze = " + j2);
                if (j < j2) {
                    return;
                }
                LiveMediaPluginManager.this.dLog("not available，LiveNps下载结束，开始安装");
            }

            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onResult(int i, String str4) {
                if (!LiveMediaPluginManager.this.isLoadingCanceled && i != 34) {
                    LiveMediaPluginManager.this.stopLoading(i);
                }
                if (i != 13) {
                    if (i != 3 || NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.livenps") != 43 || LiveMediaPluginManager.this.getPluginInstallVersion() < 508000000) {
                        LiveMediaPluginManager.this.dLog("not available，LiveNps安装结束~失败");
                        if (z2) {
                            if (i == 34) {
                                if (LiveMediaPluginManager.this.loadingCallback == null) {
                                    LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d1, 0);
                                }
                            } else {
                                LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                            }
                        }
                        LiveMixShellManager.INSTANCE.enterFlowEnd();
                        if (LiveMediaPluginManager.this.isDebug()) {
                            Log.w(LiveMediaPluginManager.TAG, "install live nps plugin error=" + i);
                        }
                        LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                        int pluginInstallVersion = liveMediaPluginManager.getPluginInstallVersion();
                        liveMediaPluginManager.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, false, "install code" + i, "nps_install", str2);
                        return;
                    }
                    LiveMediaPluginManager.this.dLog("not available，LiveNps安装结束~成功~3");
                    LiveMixShellManager.INSTANCE.enterFlowEndSlot("plugin_install");
                    LiveMixShellManager.INSTANCE.enterFlowStartSlot("plugin_load", null);
                    LiveMediaPluginManager.this.dLog("not available，开始加载LiveNps~3");
                    NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, iInvokeCallback);
                    return;
                }
                LiveMediaPluginManager.this.dLog("not available，LiveNps安装结束~成功~43");
                LiveMixShellManager.INSTANCE.enterFlowEndSlot("plugin_install");
                LiveMixShellManager.INSTANCE.enterFlowStartSlot("plugin_load", null);
                Log.d(LiveMediaPluginManager.TAG, "start load Class t=" + System.currentTimeMillis());
                LiveMediaPluginManager.this.dLog("not available，开始加载LiveNps~43");
                NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, iInvokeCallback);
            }
        });
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
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.22
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveMediaPluginManager.this.appService != null && LiveMediaPluginManager.this.toastService != null) {
                        LiveMediaPluginManager.this.toastService.showNormal(LiveMediaPluginManager.this.appService.getApplication(), LiveMediaPluginManager.this.appService.getApplication().getResources().getString(i), i2);
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

    public void isInHistory(@NonNull final String str, @NonNull final LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        dLog("LiveMediaPluginManager isInHistory " + str + GlideException.IndentedAppendable.INDENT + this.mLiveNPSPlugin);
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, false, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.3
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveMediaPluginManager.this.mLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
                            return;
                        } catch (Exception e) {
                            LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                            liveMediaPluginManager.dLog("LiveMediaPluginManager isInHistoryException " + e.getMessage());
                            return;
                        }
                    }
                    LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    if (LiveMediaPluginManager.this.isDebug()) {
                        Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                    }
                }
            }, "isInHistory", LiveNpsRuntime.getApplication());
        } else {
            iLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
        }
    }

    public void onChangeToSmallWindow(final Map<String, String> map, final IYYSmallWindowController.IPlayController iPlayController) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, false, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.20
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                    liveMediaPluginManager.dLog("LiveMediaPluginManager onChangeToSmallWindow loadPluginonResult " + i + GlideException.IndentedAppendable.INDENT + str + GlideException.IndentedAppendable.INDENT + obj + GlideException.IndentedAppendable.INDENT + str2);
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveMediaPluginManager.this.mLiveNPSPlugin != null && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry() != null && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() != null) {
                                LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().onChangeToSmallWindow(map, iPlayController);
                            }
                        } catch (Exception e) {
                            LiveMediaPluginManager liveMediaPluginManager2 = LiveMediaPluginManager.this;
                            liveMediaPluginManager2.dLog("LiveMediaPluginManager onChangeToSmallWindow loadPluginException " + e.getMessage());
                        }
                    }
                }
            }, "onChangeToSmallWindow", LiveNpsRuntime.getApplication());
        } else if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null && this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() != null) {
            this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().onChangeToSmallWindow(map, iPlayController);
        }
    }

    public void closeSmallWindow() {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, false, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.21
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                    liveMediaPluginManager.dLog("LiveMediaPluginManager closeSmallWindow loadPluginonResult " + i + GlideException.IndentedAppendable.INDENT + str + GlideException.IndentedAppendable.INDENT + obj + GlideException.IndentedAppendable.INDENT + str2);
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveMediaPluginManager.this.mLiveNPSPlugin != null && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry() != null && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() != null) {
                                LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().closeSmallWindow();
                            }
                        } catch (Exception e) {
                            LiveMediaPluginManager liveMediaPluginManager2 = LiveMediaPluginManager.this;
                            liveMediaPluginManager2.dLog("LiveMediaPluginManager closeSmallWindow loadPluginException " + e.getMessage());
                        }
                    }
                }
            }, "closeSmallWindow", LiveNpsRuntime.getApplication());
        } else if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null && this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() != null) {
            this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().closeSmallWindow();
        }
    }

    public IMixActivityInterface getMixActivityImpl() {
        dLog("LiveMediaPluginManager getMixActivityImpl");
        try {
            if (this.mLiveNPSPlugin != null && this.mLiveNPSPlugin.getLiveMediaEntry() != null && this.mLiveNPSPlugin.getLiveMediaEntry().getMixShellEntry() != null) {
                return this.mLiveNPSPlugin.getLiveMediaEntry().getMixShellEntry().genFakeActivityImpl();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean isAvailable() {
        boolean z;
        dLog("LiveMediaPluginManager isAvailable ");
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
        if (bundleGroup == null) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: top plugin is null");
            }
            return false;
        }
        int i = 3;
        BundleInfo bundleByType = bundleGroup.getBundleByType(3);
        BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
        if (bundleByType2 != null) {
            bundleByType = bundleByType2;
        }
        if (bundleByType != null && bundleByType.getVersionCode() < 508000000) {
            return false;
        }
        if (bundleByType != null && bundleByType.getVersionCode() < 507500000) {
            z = false;
        } else {
            z = true;
        }
        int bundleStatus = NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.livenps", z);
        pluginYaLog("isAvailable() isMultiBundleEnable = " + z + ", status = " + bundleStatus);
        if (bundleStatus != 43) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
            }
            return false;
        } else if (bundleByType == null) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: top plugin has no update");
            }
            return true;
        } else if (z) {
            Log.d(TAG, "isAvailable: multiBundleEnable=true, skip business check");
            return true;
        } else {
            int length = NPS_PLUGIN_SUB_PKG_GROUP.length;
            BundleInfoGroup[] bundleInfoGroupArr = new BundleInfoGroup[length];
            boolean z2 = true;
            for (int i2 = 0; i2 < length; i2++) {
                bundleInfoGroupArr[i2] = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_SUB_PKG_GROUP[i2]);
                if (bundleInfoGroupArr[i2] != null) {
                    z2 = false;
                }
            }
            if (z2) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: sec plugin not exist");
                }
                return true;
            }
            int i3 = 0;
            while (i3 < length) {
                if (bundleInfoGroupArr[i3] != null) {
                    BundleInfo bundleByType3 = bundleInfoGroupArr[i3].getBundleByType(i);
                    int versionCode = bundleByType.getVersionCode();
                    if (bundleByType3 != null && compareVersion(versionCode, bundleByType3.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: installed " + bundleByType3.getPackageName() + " plugin too high");
                        }
                        pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", vesion too hign");
                        return false;
                    }
                    BundleInfo bundleByType4 = bundleInfoGroupArr[i3].getBundleByType(1);
                    BundleInfo bundleByType5 = bundleInfoGroupArr[i3].getBundleByType(2);
                    if (bundleByType4 != null && bundleByType4.needForceUpdate() && compareVersion(bundleByType.getVersionCode(), bundleByType4.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec " + bundleByType4.getPackageName() + " plugin force update1");
                        }
                        if (bundleByType3 != null) {
                            pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", plugin force update1");
                        }
                        return false;
                    } else if (bundleByType4 == null && bundleByType5 != null && bundleByType5.needForceUpdate() && compareVersion(bundleByType.getVersionCode(), bundleByType5.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec " + bundleByType5.getPackageName() + " plugin force update2");
                        }
                        if (bundleByType3 != null) {
                            pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", plugin force update2");
                        }
                        return false;
                    }
                }
                i3++;
                i = 3;
            }
            return true;
        }
    }

    public boolean isLoaded(String str) {
        dLog("LiveMediaPluginManager isLoaded" + str);
        if ("com.baidu.searchbox.livenps".equals(str)) {
            dLog("LiveMediaPluginManager isLoaded-1  " + this.mLiveNPSPlugin);
            if (this.mLiveNPSPlugin == null) {
                return false;
            }
            return true;
        }
        Object obj = "";
        if ("com.baidu.live.media.business".equals(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("LiveMediaPluginManager isLoaded-2 ");
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null) {
                obj = Boolean.valueOf(this.mLiveNPSPlugin.getLiveMediaEntry().isLoaded());
            }
            sb.append(obj);
            dLog(sb.toString());
            ILiveNPSPlugin iLiveNPSPlugin2 = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin2 == null || iLiveNPSPlugin2.getLiveMediaEntry() == null) {
                return false;
            }
            return this.mLiveNPSPlugin.getLiveMediaEntry().isLoaded();
        }
        if (BJH_PLUGIN_PKG_NAME.equals(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("LiveMediaPluginManager isLoaded-3 ");
            ILiveNPSPlugin iLiveNPSPlugin3 = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin3 != null && iLiveNPSPlugin3.getLiveBjhEntry() != null) {
                obj = Boolean.valueOf(this.mLiveNPSPlugin.getLiveBjhEntry().isLoaded());
            }
            sb2.append(obj);
            dLog(sb2.toString());
            ILiveNPSPlugin iLiveNPSPlugin4 = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin4 != null && iLiveNPSPlugin4.getLiveBjhEntry() != null) {
                return this.mLiveNPSPlugin.getLiveBjhEntry().isLoaded();
            }
        }
        return false;
    }

    public void loadPlugin(final Context context, String str, String str2, final com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback) {
        String str3;
        dLog("LiveMediaPluginManager loadPlugin " + str);
        if (TextUtils.isEmpty(str2)) {
            str3 = USE_FROM_MIX_LOAD_PLUGIN;
        } else {
            str3 = str2;
        }
        if ("com.baidu.searchbox.livenps".equals(str)) {
            loadLiveNpsPlugin(context, str2, str3, pluginLoadCallback);
        } else if ("com.baidu.live.media.business".equals(str)) {
            dLog("LiveMediaPluginManager loadPlugin " + this.mLiveNPSPlugin);
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadLiveNpsPlugin(context, str2, str3, new com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.1
                    @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                    public void onResult(boolean z, int i, @Nullable String str4) {
                        LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.this;
                        liveMediaPluginManager.dLog("LiveMediaPluginManager 一级onResult " + i + GlideException.IndentedAppendable.INDENT + str4 + GlideException.IndentedAppendable.INDENT);
                        if (z && LiveMediaPluginManager.this.mLiveNPSPlugin != null && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                            LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().loadMediaPlugin(context, pluginLoadCallback);
                            return;
                        }
                        com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback2 = pluginLoadCallback;
                        if (pluginLoadCallback2 != null) {
                            pluginLoadCallback2.onResult(false, i, "LiveNps 加载失败");
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveMediaEntry() != null) {
                if (this.mLiveNPSPlugin.getLiveMediaEntry().isLoaded()) {
                    if (pluginLoadCallback != null) {
                        pluginLoadCallback.onResult(true, 14, "");
                        return;
                    }
                    return;
                }
                this.mLiveNPSPlugin.getLiveMediaEntry().loadMediaPlugin(context, pluginLoadCallback);
            } else if (pluginLoadCallback != null) {
                pluginLoadCallback.onResult(false, 0, "MediaEntry 加载失败");
            }
        }
    }

    public void onDiskClearCacheChange(final long j, final int i, final int i2, final ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        dLog("LiveMediaPluginManager onDiskClearCacheChange " + this.mLiveNPSPlugin);
        if (NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps") == null) {
            return;
        }
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, false, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.16
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i3, String str, Object obj, String str2) {
                    if (i3 == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveMediaPluginManager.this.mLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, "onDiskClearCacheChange", LiveNpsRuntime.getApplication());
            return;
        }
        try {
            iLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void prepareBundle() {
        boolean isAvailable = isAvailable();
        dLog("插件预加载 LiveMediaPluginManager isAvailable = " + isAvailable);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            pluginYaLog("Idle task prepareBundle, topPlugin isAvailable = " + isAvailable);
            if (isAvailable) {
                if (NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(2) != null) {
                    dLog("插件预加载 LiveMediaPluginManager 开始静默安装，升级插件");
                    int prepareBundle = NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.livenps");
                    long currentTimeMillis2 = System.currentTimeMillis();
                    dLog("插件预加载 LiveMediaPluginManager 静默安装结束，耗时 = " + (currentTimeMillis2 - currentTimeMillis) + " 毫秒");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Idle task prepareBundle, installPlugin retCode = ");
                    sb.append(prepareBundle);
                    pluginYaLog(sb.toString());
                }
                dLog("prepareBundle livenps准备预加载");
                preLoadLiveNps(System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        dLog("插件预加载 LiveMediaPluginManager 整体耗时 = " + (currentTimeMillis3 - currentTimeMillis) + " 毫秒");
    }

    public void sendLog(final int i, @NonNull final Context context, @NonNull final String str) {
        dLog("LiveMediaPluginManager sendLog " + i + " " + str);
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, true, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.5
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().sendLog(i, context, str);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, "sendYaLog", context);
        } else {
            iLiveNPSPlugin.getLiveMediaEntry().sendLog(i, context, str);
        }
    }

    public void startBjhMasterActivity(@NonNull final Application application, final String str, final Uri uri) {
        dLog("LiveMediaPluginManager startBjhMasterActivity " + str);
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, true, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.7
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveMediaPluginManager.this.isLoadingCanceled) {
                        LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveMediaPluginManager.this.isDebug()) {
                        Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                    }
                }
            }, "startBjhMasterActivity", application);
        } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
            this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
        }
    }

    public void startBjhMasterActivityNew(@NonNull final Context context, final String str, final Uri uri) {
        if (getPluginInstallVersion() >= 506000000) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, true, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.8
                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        if (i == 14) {
                            try {
                                LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!LiveMediaPluginManager.this.isLoadingCanceled && LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                    LiveMediaPluginManager.this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivityNew(context, str, uri);
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        if (!LiveMediaPluginManager.this.isLoadingCanceled) {
                            LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                        if (LiveMediaPluginManager.this.isDebug()) {
                            Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                        }
                    }
                }, "startBjhMasterActivityNew", context);
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

    public void startAudioMasterActivity(@NonNull final Application application, String str) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enter_outlive_commonwebview", "1");
            jSONObject.put("enter_outlive_weburl", "https://live.baidu.com/m/media/multipage/cb_start_broad/index.html?app_type=tieba&params=" + str);
            jSONObject.put("navigationBar", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.mLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, true, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.6
                @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveMediaPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveMediaPluginManager.this.isLoadingCanceled) {
                                LiveMixShellManager.INSTANCE.enterLiveRoom(application, null, null, jSONObject.toString(), null);
                            } else {
                                MultiPluginHelper.logCancelJoinLive(str3, false, LiveMediaPluginManager.this.ubcManager);
                                if (LiveMediaPluginManager.this.isDebug()) {
                                    Log.w(LiveMediaPluginManager.TAG, "cancel startLiveMediaActivity");
                                }
                            }
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveMediaPluginManager.this.isLoadingCanceled) {
                        LiveMediaPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                    if (LiveMediaPluginManager.this.isDebug()) {
                        Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                    }
                }
            }, "startAudioMasterActivity", application);
        } else {
            LiveMixShellManager.INSTANCE.enterLiveRoom(application, null, null, jSONObject.toString(), null);
        }
    }

    public void updateStatInfo(YYStatInfo yYStatInfo) {
        if (yYStatInfo != null && this.mLiveNPSPlugin != null) {
            HashMap<String, Object> popFlow = FlowInfoHelper.popFlow(yYStatInfo.roomId);
            if (popFlow != null) {
                if (yYStatInfo.statInfo == null) {
                    yYStatInfo.statInfo = popFlow;
                } else {
                    for (String str : popFlow.keySet()) {
                        if (!TextUtils.isEmpty(str) && popFlow.get(str) != null) {
                            yYStatInfo.statInfo.put(str, popFlow.get(str));
                        }
                    }
                }
            }
            this.mLiveNPSPlugin.getLiveMediaEntry().updateStatInfo(yYStatInfo);
            MediaLivePluginLogger.Companion.getInstance().updateLaunchFlowObj(yYStatInfo.flowObj);
            MediaLivePlayLogger.Companion.getInstance().updateLaunchInfo(yYStatInfo.statInfo);
        }
    }
}
