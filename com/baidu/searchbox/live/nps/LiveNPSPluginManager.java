package com.baidu.searchbox.live.nps;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import d.a.z.d.a.a;
import d.a.z.f.b;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveNPSPluginManager {
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
    public static final String NEW_CLEAR_RESOURCE_FILE = "NEW_CLEAR_RESOURCE_FILE";
    public static final String NEW_CREATE_LIVE_ROOM = "NEW_CREATE_LIVE_ROOM";
    public static final String NEW_GET_LIVE_ROOM_STATUS = "NEW_GET_LIVE_ROOM_STATUS";
    public static final String NEW_GET_LIVE_SDK_FILE_SIZE = "NEW_GET_LIVE_SDK_FILE_SIZE";
    public static final String NEW_GET_RESOURCE_FILE_SIZE = "NEW_GET_RESOURCE_FILE_SIZE";
    public static final String NEW_IS_HISTORY = "NEW_IS_HISTORY";
    public static final String NEW_ON_DISK_CLEAR_CACHE_CHANGE = "NEW_ON_DISK_CLEAR_CACHE_CHANGE";
    public static final String NPS_PLUGIN_IMPL_CLASS_NAME = "com.baidu.searchbox.live.LiveNPSPluginImpl";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String[] NPS_PLUGIN_SUB_PKG_GROUP = {YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1, YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2, "com.baidu.searchbox.yylive.extlib", "com.baidu.searchbox.bjhlivenps", "com.baidu.searchbox.yylive.createlive", "com.baidu.searchbox.yylive.game", "com.baidu.searchbox.yylive.yylib", "com.baidu.searchbox.yylive.audiolive", "com.baidu.searchbox.yylive.friends"};
    public static final String PAGE_SLOT_PAGE_PLUGIN_INSTALL = "plugin_install";
    public static final String PAGE_SLOT_PAGE_PLUGIN_LOAD = "plugin_load";
    public static final String TAG = "LiveNPSPluginManager";
    public static final String UBC_ID_PLUGIN_END = "3185";
    public static final String UBC_ID_PLUGIN_PAGE_FLOW = "3121";
    public static final String UBC_ID_PLUGIN_START = "3186";
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
    public ILiveNPSPlugin mLiveNPSPlugin;
    public Handler mMainHandler;
    public Flow pageFlow;
    public ToastService toastService;
    public UBCManager ubcManager;

    /* loaded from: classes2.dex */
    public interface PluginLoadCallback {
        void onResult(int i2, String str, Object obj, String str2);
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static LiveNPSPluginManager instance = new LiveNPSPluginManager();
    }

    private void checkHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    private int compareVersion(int i2, int i3) {
        return (i2 / 1000) - (i3 / 1000);
    }

    public static LiveNPSPluginManager getInstance() {
        return SingletonHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginInstallVersion() {
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME);
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

    private void loadNPSPluginImpl(final boolean z, final String str, final PluginLoadCallback pluginLoadCallback) {
        Flow flow;
        Flow flow2;
        this.mCurrentCallback = pluginLoadCallback;
        Log.d(TAG, "NPS load from=" + str);
        final IInvokeCallback iInvokeCallback = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.28
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i2, final String str2, final Object obj) {
                if (LiveNPSPluginManager.this.ubcManager != null && LiveNPSPluginManager.this.pageFlow != null) {
                    LiveNPSPluginManager.this.ubcManager.flowEndSlot(LiveNPSPluginManager.this.pageFlow, "plugin_load");
                }
                LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.this;
                int pluginInstallVersion = liveNPSPluginManager.getPluginInstallVersion();
                boolean z2 = i2 == 14;
                liveNPSPluginManager.logPluginEnd(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, pluginInstallVersion, z2, "load code" + i2, LiveNPSPluginManager.this.fromDownLoad ? "nps_download" : "nps_install", str);
                if (pluginLoadCallback != null) {
                    final String str3 = LiveNPSPluginManager.this.fromDownLoad ? "download" : "install";
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        LiveNPSPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.28.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveNPSPluginManager.this.mCurrentCallback != null) {
                                    LiveNPSPluginManager.this.mCurrentCallback.onResult(i2, str2, obj, str3);
                                    LiveNPSPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (LiveNPSPluginManager.this.mCurrentCallback != null) {
                        LiveNPSPluginManager.this.mCurrentCallback.onResult(i2, str2, obj, str3);
                        LiveNPSPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        IInvokeCallback iInvokeCallback2 = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.29
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i2, final String str2, final Object obj) {
                if (LiveNPSPluginManager.this.ubcManager != null && LiveNPSPluginManager.this.pageFlow != null) {
                    LiveNPSPluginManager.this.ubcManager.flowEndSlot(LiveNPSPluginManager.this.pageFlow, "plugin_load");
                }
                LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.this;
                int pluginInstallVersion = liveNPSPluginManager.getPluginInstallVersion();
                boolean z2 = i2 == 14;
                liveNPSPluginManager.logPluginEnd(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, pluginInstallVersion, z2, "load code" + i2, "nps_load", str);
                if (pluginLoadCallback != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        LiveNPSPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveNPSPluginManager.this.mCurrentCallback != null) {
                                    LiveNPSPluginManager.this.mCurrentCallback.onResult(i2, str2, obj, "load");
                                    LiveNPSPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (LiveNPSPluginManager.this.mCurrentCallback != null) {
                        LiveNPSPluginManager.this.mCurrentCallback.onResult(i2, str2, obj, "load");
                        LiveNPSPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        this.fromDownLoad = false;
        logPluginLoad(NPS_PLUGIN_PKG_NAME, str);
        if (isAvailable()) {
            this.fromDownLoad = false;
            UBCManager uBCManager = this.ubcManager;
            if (uBCManager != null && (flow2 = this.pageFlow) != null) {
                uBCManager.flowStartSlot(flow2, "plugin_load", null);
            }
            Log.d(TAG, "start load Class t=" + System.currentTimeMillis());
            NPSManager.getInstance().loadClazz(NPS_PLUGIN_PKG_NAME, NPS_PLUGIN_IMPL_CLASS_NAME, ILiveNPSPlugin.class, iInvokeCallback2);
            if (z) {
                NPSPackageManager.getInstance().downloadUpdatePackage(NPS_PLUGIN_PKG_NAME, new a() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.30
                    @Override // d.a.z.d.a.a
                    public void onProgress(long j, long j2) {
                    }

                    @Override // d.a.z.d.a.a
                    public void onResult(int i2, String str2) {
                    }
                }, new d.a.z.f.a() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.31
                    @Override // d.a.z.f.a
                    public void checkAuthorization(IBundleInfo iBundleInfo, int i2, b bVar) {
                        if (bVar != null) {
                            bVar.onResult(1);
                        }
                    }
                }, 1);
                return;
            }
            return;
        }
        this.isLoadingCanceled = false;
        if (z) {
            showLoading();
        }
        UBCManager uBCManager2 = this.ubcManager;
        if (uBCManager2 != null && (flow = this.pageFlow) != null) {
            uBCManager2.flowStartSlot(flow, "plugin_install", null);
        }
        this.fromDownLoad = false;
        Log.d(TAG, "start install bundle t=" + System.currentTimeMillis());
        NPSPackageManager.getInstance().installBundle(NPS_PLUGIN_PKG_NAME, new IInstallCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.32
            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onProgress(long j, long j2) {
                LiveNPSPluginManager.this.fromDownLoad = true;
                if (LiveNPSPluginManager.this.loadingCallback == null || LiveNPSPluginManager.this.isLoadingCanceled) {
                    return;
                }
                LiveNPSPluginManager.this.loadingCallback.onLoadingProgress(j, j2);
            }

            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onResult(int i2, String str2) {
                if (!LiveNPSPluginManager.this.isLoadingCanceled && i2 != 34) {
                    LiveNPSPluginManager.this.stopLoading(i2);
                }
                if (i2 == 13) {
                    if (LiveNPSPluginManager.this.ubcManager != null && LiveNPSPluginManager.this.pageFlow != null) {
                        LiveNPSPluginManager.this.ubcManager.flowEndSlot(LiveNPSPluginManager.this.pageFlow, "plugin_install");
                        LiveNPSPluginManager.this.ubcManager.flowStartSlot(LiveNPSPluginManager.this.pageFlow, "plugin_load", null);
                    }
                    Log.d(LiveNPSPluginManager.TAG, "start load Class t=" + System.currentTimeMillis());
                    NPSManager.getInstance().loadClazz(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, LiveNPSPluginManager.NPS_PLUGIN_IMPL_CLASS_NAME, ILiveNPSPlugin.class, iInvokeCallback);
                } else if (i2 == 3 && NPSPackageManager.getInstance().getBundleStatus(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME) == 43) {
                    if (LiveNPSPluginManager.this.ubcManager != null && LiveNPSPluginManager.this.pageFlow != null) {
                        LiveNPSPluginManager.this.ubcManager.flowEndSlot(LiveNPSPluginManager.this.pageFlow, "plugin_install");
                        LiveNPSPluginManager.this.ubcManager.flowStartSlot(LiveNPSPluginManager.this.pageFlow, "plugin_load", null);
                    }
                    NPSManager.getInstance().loadClazz(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, LiveNPSPluginManager.NPS_PLUGIN_IMPL_CLASS_NAME, ILiveNPSPlugin.class, iInvokeCallback);
                } else {
                    if (z) {
                        if (i2 == 34) {
                            if (LiveNPSPluginManager.this.loadingCallback == null) {
                                LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_installing, 0);
                            }
                        } else {
                            LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                        }
                    }
                    if (LiveNPSPluginManager.this.ubcManager != null && LiveNPSPluginManager.this.pageFlow != null) {
                        LiveNPSPluginManager.this.ubcManager.flowEnd(LiveNPSPluginManager.this.pageFlow);
                        LiveNPSPluginManager.this.pageFlow = null;
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "install live nps plugin error=" + i2);
                    }
                    LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.this;
                    int pluginInstallVersion = liveNPSPluginManager.getPluginInstallVersion();
                    liveNPSPluginManager.logPluginEnd(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, pluginInstallVersion, false, "install code" + i2, "nps_install", str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginEnd(String str, int i2, boolean z, String str2, String str3, String str4) {
        if (this.ubcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "live");
                jSONObject.put("type", "end_load");
                jSONObject.put("source", str3);
                if (z) {
                    jSONObject.put("value", "suc");
                } else {
                    jSONObject.put("value", com.baidu.pass.biometrics.face.liveness.b.b.g0);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkg", str);
                jSONObject2.put("ver", i2);
                jSONObject2.put("useFrom", str4);
                jSONObject2.put("reason", str2);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.ubcManager.onEvent(UBC_ID_PLUGIN_END, jSONObject);
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
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.ubcManager.onEvent(UBC_ID_PLUGIN_START, jSONObject);
        }
    }

    private void logPluginVersionCode() {
        BundleInfo bundleInfo;
        if (NPSPackageManager.getInstance().getBundleStatus(NPS_PLUGIN_PKG_NAME) != 43 || (bundleInfo = NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME)) == null) {
            return;
        }
        Log.d("NPS", "NPS Installed live plugin version code " + bundleInfo.getVersionCode());
    }

    private void showLoading() {
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(final int i2, final int i3) {
        ToastService toastService;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.37
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveNPSPluginManager.this.appService == null || LiveNPSPluginManager.this.toastService == null) {
                        return;
                    }
                    LiveNPSPluginManager.this.toastService.showNormal(LiveNPSPluginManager.this.appService.getApplication(), LiveNPSPluginManager.this.appService.getApplication().getResources().getString(i2), i3);
                }
            });
            return;
        }
        AppInfoService appInfoService = this.appService;
        if (appInfoService == null || (toastService = this.toastService) == null) {
            return;
        }
        toastService.showNormal(appInfoService.getApplication(), this.appService.getApplication().getResources().getString(i2), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading(int i2) {
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingEnd(i2);
        }
    }

    public void cancelLoading() {
        this.isLoadingCanceled = true;
    }

    public void checkArSdkLoadStatus(@NonNull Context context, @NonNull final LiveNpsArStatusCallback liveNpsArStatusCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_CHECK_AR, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.20
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                return;
                            }
                            liveNpsArStatusCallback.onArSdkStatus(LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry().isArSdkLoaded());
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            liveNpsArStatusCallback.onArSdkStatus(this.mLiveNPSPlugin.getLiveShowMasterEntry().isArSdkLoaded());
        }
    }

    public void clearResourceFile(@NonNull final Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, NEW_CLEAR_RESOURCE_FILE, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.35
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.clearLiveResourceSize(context);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.clearLiveResourceSize(context);
        }
    }

    public void dispatchHostEvent(@NonNull Context context, @NonNull String str, Map<String, Object> map) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin != null) {
            iLiveNPSPlugin.dispatchHostEvent(context, str, map);
            if (this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                this.mLiveNPSPlugin.getLiveMediaEntry().dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getYYLiveEntry() != null) {
                this.mLiveNPSPlugin.getYYLiveEntry().dispatchHostEvent(context, str, map);
            }
        }
    }

    public void dispatchYYLiveRouter(@NonNull final Context context, @NonNull final String str) {
        checkHandler();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, YY_LIVE_ROUTER, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.27
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str2, final Object obj, String str3) {
                    LiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.27.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i2 != 14) {
                                LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                                return;
                            }
                            try {
                                LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                LiveNPSPluginManager.this.mLiveNPSPlugin.getYYLiveEntry().dispatchYYLiveRouter(context, str);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            });
        } else {
            iLiveNPSPlugin.getYYLiveEntry().dispatchYYLiveRouter(context, str);
        }
    }

    public BundleInfo getInstalledPluginInfo() {
        return NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME);
    }

    public void getLiveResourceFileSize(@NonNull final Context context, @NonNull final ILiveFileSizeCallback iLiveFileSizeCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, NEW_GET_RESOURCE_FILE_SIZE, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.34
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveResourceSize(context, iLiveFileSizeCallback);
                            return;
                        } catch (Exception e2) {
                            iLiveFileSizeCallback.getFileSize(0L);
                            e2.printStackTrace();
                            return;
                        }
                    }
                    iLiveFileSizeCallback.getFileSize(0L);
                    LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.getLiveResourceSize(context, iLiveFileSizeCallback);
        }
    }

    public void getLiveRoomStatus(@NonNull final String str, @NonNull final LiveStatusDataCallback<String> liveStatusDataCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, NEW_GET_LIVE_ROOM_STATUS, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.6
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
        }
    }

    public void getLiveSdkFileSize(@NonNull final Context context, @NonNull final ILiveFileSizeCallback iLiveFileSizeCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, NEW_GET_LIVE_SDK_FILE_SIZE, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.33
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveSdkSize(context, iLiveFileSizeCallback);
                            return;
                        } catch (Exception e2) {
                            iLiveFileSizeCallback.getFileSize(0L);
                            e2.printStackTrace();
                            return;
                        }
                    }
                    iLiveFileSizeCallback.getFileSize(0L);
                    LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.getLiveSdkSize(context, iLiveFileSizeCallback);
        }
    }

    public boolean isAvailable() {
        int bundleStatus = NPSPackageManager.getInstance().getBundleStatus(NPS_PLUGIN_PKG_NAME);
        if (bundleStatus != 43) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
            }
            return false;
        }
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_PKG_NAME);
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
        for (int i2 = 0; i2 < length; i2++) {
            bundleInfoGroupArr[i2] = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_SUB_PKG_GROUP[i2]);
            if (bundleInfoGroupArr[i2] != null) {
                z = false;
            }
        }
        if (z) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: sec plugin not exist");
            }
            return true;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (bundleInfoGroupArr[i3] != null) {
                BundleInfo bundleByType3 = bundleInfoGroupArr[i3].getBundleByType(3);
                if (bundleByType3 != null && compareVersion(bundleByType.getVersionCode(), bundleByType3.getVersionCode()) < 0) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: installed " + bundleByType3.getPackageName() + " plugin too high");
                    }
                    return false;
                }
                BundleInfo bundleByType4 = bundleInfoGroupArr[i3].getBundleByType(1);
                BundleInfo bundleByType5 = bundleInfoGroupArr[i3].getBundleByType(2);
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

    public void isInHistory(@NonNull final String str, @NonNull final LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, NEW_IS_HISTORY, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.3
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
        }
    }

    public void onDiskClearCacheChange(final long j, final int i2, final int i3, final ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Log.d(TAG, "start DiskClearCacheChange t=" + System.currentTimeMillis());
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, NEW_ON_DISK_CLEAR_CACHE_CHANGE, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.36
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i4, String str, Object obj, String str2) {
                    Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                    if (i4 != 14) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                        return;
                    }
                    try {
                        LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                        LiveNPSPluginManager.this.mLiveNPSPlugin.onDiskClearCacheChange(j, i2, i3, iLiveDiskClearCacheCallback);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        try {
            iLiveNPSPlugin.onDiskClearCacheChange(j, i2, i3, iLiveDiskClearCacheCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        this.loadingCallback = liveNpsLoadingCallback;
    }

    public void startAdminListActivity(@NonNull final Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_ADMIN_LIST, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.15
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry().openAdminListPage(context);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().openAdminListPage(context);
        }
    }

    public void startArSdkLoad(@NonNull Context context, @NonNull final LiveNpsArLoadCallback liveNpsArLoadCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, LIVE_SHOW_LOAD_AR, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.21
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.21.1
                                @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                public void onProgress(int i3, int i4) {
                                    liveNpsArLoadCallback.onProgress(i3, i4);
                                }

                                @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                public void onResult(boolean z, String str3) {
                                    liveNpsArLoadCallback.onResult(z, str3);
                                }
                            });
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.22
                @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                public void onProgress(int i2, int i3) {
                    liveNpsArLoadCallback.onProgress(i2, i3);
                }

                @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                public void onResult(boolean z, String str) {
                    liveNpsArLoadCallback.onResult(z, str);
                }
            });
        }
    }

    public void startBjhMasterActivity(@NonNull final Application application, final String str, final Uri uri) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, MEDIA_BJH_CREATE_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.2
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveBjhEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
            this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
        }
    }

    public void startFansListActivity(@NonNull final Context context, @NonNull final String str, final int i2) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_FANS_LIST, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.11
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i3, String str2, Object obj, String str3) {
                    if (i3 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(context, str, i2);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i3);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(context, str, i2);
        }
    }

    public void startForbiddenListActivity(@NonNull final Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_FORBIDDEN_LIST, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.16
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry().openForbiddenListPage(context);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().openForbiddenListPage(context);
        }
    }

    public void startGuardianListActivity(@NonNull final Context context, @NonNull final String str, @NonNull final String str2) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_GUARD_LIST, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.12
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str3, Object obj, String str4) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(context, str, str2);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(context, str, str2);
        }
    }

    public void startLiveExpActivity(@NonNull final Context context, final long j, final int i2) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_LIVE_EXP, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.13
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i3, String str, Object obj, String str2) {
                    if (i3 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(context, j, i2);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i3);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(context, j, i2);
        }
    }

    public void startLiveMediaActivity(final Context context, final String str, final String str2, final String str3, final Uri uri) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, MEDIA_ENTER_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.1
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str4, Object obj, String str5) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(context, str, str2, str3, uri);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveMediaEntry() != null) {
            this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(context, str, str2, str3, uri);
        }
    }

    public void startLiveShowActivity(@NonNull final Context context, @NonNull final String str) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_ENTER_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.7
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(context, str);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(context, str);
        }
    }

    public void startMasterActivity(@NonNull final Context context, @NonNull final String str, @NonNull String str2) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, NEW_CREATE_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.4
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str3, Object obj, String str4) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.startMasterActivity(context, str);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.startMasterActivity(context, str);
        }
    }

    public void startMasterActivityV2(@NonNull final Context context, @NonNull final String str, @NonNull final String str2) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, NEW_CREATE_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.5
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str3, Object obj, String str4) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.startMasterActivity(context, str, str2);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.startMasterActivity(context, str, str2);
        }
    }

    public void startPatronageActivity(@NonNull final Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_START_PATRONAGE, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.9
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().enterPatronagePage(context);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterPatronagePage(context);
        }
    }

    public void startPatronsActivity(@NonNull final Context context, final String str) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_START_PATRONS, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.10
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().enterPatrons(context, str);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterPatrons(context, str);
        }
    }

    public void startPayActivity(@NonNull final Context context, @NonNull final String str) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_START_PAY, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.8
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().enterPayPage(context, str);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterPayPage(context, str);
        }
    }

    public void startRealAuthActivity(@NonNull final Context context, @NonNull final String str, @NonNull final String str2) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_REAL_AUTH, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.17
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str3, Object obj, String str4) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry().openRealAuthPage(context, str, str2);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().openRealAuthPage(context, str, str2);
        }
    }

    public void startShowMasterActivity(@NonNull final Context context, final String str) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, LIVE_SHOW_CREATE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.14
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(context, str);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(context, str);
        }
    }

    public void startYYActivity(final Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, YY_TEST_ENTER_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.23
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str, Object obj, String str2) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getYYLiveEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getYYLiveEntry().startYYActivity(context);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getYYLiveEntry() != null) {
            this.mLiveNPSPlugin.getYYLiveEntry().startYYActivity(context);
        }
    }

    public void startYYCustomerServiceActivity(@NonNull final Context context, @NonNull final String str) {
        Log.d(TAG, "startYYCustomerServiceActivity t=" + System.currentTimeMillis());
        checkHandler();
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, YY_CUSTOMER_SERVICE, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.26
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str2, final Object obj, String str3) {
                    LiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.26.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i2 != 14) {
                                LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                                return;
                            }
                            try {
                                LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                LiveNPSPluginManager.this.mLiveNPSPlugin.getYYLiveEntry().startYYCustomerServiceActivity(context, str);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
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
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, YY_FEED_BACK, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.25
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str2, final Object obj, String str3) {
                    LiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i2 != 14) {
                                LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                                return;
                            }
                            try {
                                LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                LiveNPSPluginManager.this.mLiveNPSPlugin.getYYLiveEntry().startYYFeedbackActivity(context, str);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            });
        } else {
            iLiveNPSPlugin.getYYLiveEntry().startYYFeedbackActivity(context, str);
        }
    }

    public void startYYLiveActivity(final Context context, final String str) {
        Log.d(TAG, "startYYLiveActivity t=" + System.currentTimeMillis());
        UBCManager uBCManager = this.ubcManager;
        if (uBCManager != null) {
            this.pageFlow = uBCManager.beginFlow("3121");
        }
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, YY_ENTER_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.24
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                    if (i2 != 14) {
                        if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                            LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                        }
                        if (LiveNPSPluginManager.this.isDebug()) {
                            Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            return;
                        }
                        return;
                    }
                    try {
                        LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                        if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getYYLiveEntry() == null) {
                            return;
                        }
                        if (LiveNPSPluginManager.this.pageFlow != null) {
                            YYStatInfo yYStatInfo = new YYStatInfo();
                            yYStatInfo.flowObj = LiveNPSPluginManager.this.pageFlow;
                            yYStatInfo.isColdLaunch = true;
                            yYStatInfo.loadType = str3;
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getYYLiveEntry().updateStatInfo(yYStatInfo);
                            LiveNPSPluginManager.this.pageFlow = null;
                        }
                        LiveNPSPluginManager.this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else if (iLiveNPSPlugin.getYYLiveEntry() != null) {
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
            this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
        }
    }

    public void startYuYinActivity(@NonNull final Context context, @NonNull final String str, @NonNull final String str2, final Map<String, Object> map) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, YU_YIN_ENTER_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.18
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str3, Object obj, String str4) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveYuYinEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinLiveActivity(context, str, str2, map);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
            this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinLiveActivity(context, str, str2, map);
        }
    }

    public void startYuYinCreateLiveRoomActivity(@NonNull final Context context, final String str) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, YU_YIN_CREATE_LIVE_ROOM, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.19
                @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                public void onResult(int i2, String str2, Object obj, String str3) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveYuYinEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(context, str);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(d.a.v.c.a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
            this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(context, str);
        }
    }

    public LiveNPSPluginManager() {
        this.handler = new Handler(Looper.getMainLooper());
        this.fromDownLoad = false;
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.isLoadingCanceled = false;
    }
}
