package com.baidu.searchbox.live.nps.yy;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import com.baidu.webkit.internal.ABTestConstants;
import d.a.v.c.b.a;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public class YYLiveNPSPluginManager {
    public static final String LOAD_FROM_NPS_DOWNLOAD = "nps_download";
    public static final String LOAD_FROM_NPS_INSTALL = "nps_install";
    public static final String LOAD_FROM_NPS_LOAD = "nps_load";
    public static final String NPS_PLUGIN_IMPL_CLASS_NAME = "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static final String NPS_PLUGIN_PKG_NAME2_1 = "com.baidu.searchbox.yylive.liveroom";
    public static final String NPS_PLUGIN_PKG_NAME2_2 = "com.baidu.searchbox.yylive.interaction";
    public static final String PAGE_SLOT_PAGE_PLUGIN_INSTALL = "plugin_install";
    public static final String PAGE_SLOT_PAGE_PLUGIN_LOAD = "plugin_load";
    public static final String TAG = "YY_PLUGIN";
    public static final String UBC_ID_PLUGIN_PAGE_FLOW = "3121";
    public AppInfoService appService;
    public boolean fromDownLoad;
    public Handler handler;
    public IYYLiveNPSPlugin impl;
    public boolean isLoadingCanceled;
    public LiveYYNpsLoadingCallback loadingCallback;
    public PluginLoadCallback mCurrentCallback;
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
        public static YYLiveNPSPluginManager instance = new YYLiveNPSPluginManager();
    }

    private void checkHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    private int compareVersion(int i2, int i3) {
        return (i2 / ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT) - (i3 / ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT);
    }

    private String getEntry(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("params");
        if (TextUtils.isEmpty(queryParameter)) {
            String queryParameter2 = parse.getQueryParameter("source");
            String queryParameter3 = parse.getQueryParameter("tab");
            String queryParameter4 = parse.getQueryParameter("tag");
            if (TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return queryParameter2;
            }
            return queryParameter3 + "-" + queryParameter4 + "-" + queryParameter2;
        }
        try {
            return new JSONObject(queryParameter).optString("source");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static YYLiveNPSPluginManager getInstance() {
        return SingletonHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginDownloadVersion() {
        BundleInfo bundleByType;
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_PKG_NAME);
        if (bundleGroup == null || (bundleByType = bundleGroup.getBundleByType(2)) == null) {
            return 0;
        }
        return bundleByType.getVersionCode();
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
    public int getPluginUpdateVersion() {
        BundleInfo bundleByType;
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_PKG_NAME);
        if (bundleGroup == null || (bundleByType = bundleGroup.getBundleByType(1)) == null) {
            return 0;
        }
        return bundleByType.getVersionCode();
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
        IInvokeCallback iInvokeCallback = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.5
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i2, final String str2, final Object obj) {
                if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                    YYLiveNPSPluginManager.this.ubcManager.flowEndSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_load");
                }
                YYLiveNPSPluginManager yYLiveNPSPluginManager = YYLiveNPSPluginManager.this;
                int pluginInstallVersion = yYLiveNPSPluginManager.getPluginInstallVersion();
                boolean z2 = i2 == 14;
                yYLiveNPSPluginManager.logPluginEnd(YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, pluginInstallVersion, z2, "load code" + i2, "nps_load", str);
                if (pluginLoadCallback != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        YYLiveNPSPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (YYLiveNPSPluginManager.this.mCurrentCallback != null) {
                                    YYLiveNPSPluginManager.this.mCurrentCallback.onResult(i2, str2, obj, "load");
                                    YYLiveNPSPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (YYLiveNPSPluginManager.this.mCurrentCallback != null) {
                        YYLiveNPSPluginManager.this.mCurrentCallback.onResult(i2, str2, obj, "load");
                        YYLiveNPSPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        final IInvokeCallback iInvokeCallback2 = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.6
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i2, final String str2, final Object obj) {
                if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                    YYLiveNPSPluginManager.this.ubcManager.flowEndSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_load");
                }
                final String str3 = YYLiveNPSPluginManager.this.fromDownLoad ? "download" : "install";
                YYLiveNPSPluginManager yYLiveNPSPluginManager = YYLiveNPSPluginManager.this;
                int pluginInstallVersion = yYLiveNPSPluginManager.getPluginInstallVersion();
                boolean z2 = i2 == 14;
                yYLiveNPSPluginManager.logPluginEnd(YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, pluginInstallVersion, z2, "load code" + i2, YYLiveNPSPluginManager.this.fromDownLoad ? "nps_download" : "nps_install", str);
                if (pluginLoadCallback != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        YYLiveNPSPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (YYLiveNPSPluginManager.this.mCurrentCallback != null) {
                                    YYLiveNPSPluginManager.this.mCurrentCallback.onResult(i2, str2, obj, str3);
                                    YYLiveNPSPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (YYLiveNPSPluginManager.this.mCurrentCallback != null) {
                        YYLiveNPSPluginManager.this.mCurrentCallback.onResult(i2, str2, obj, str3);
                        YYLiveNPSPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        logPluginLoad(NPS_PLUGIN_PKG_NAME, str);
        if (isAvailable()) {
            this.fromDownLoad = false;
            UBCManager uBCManager = this.ubcManager;
            if (uBCManager != null && (flow2 = this.pageFlow) != null) {
                uBCManager.flowStartSlot(flow2, "plugin_load", null);
            }
            NPSManager.getInstance().loadClazz(NPS_PLUGIN_PKG_NAME, NPS_PLUGIN_IMPL_CLASS_NAME, IYYLiveNPSPlugin.class, iInvokeCallback);
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
        Log.d(TAG, "start install bundle t=" + System.currentTimeMillis());
        this.fromDownLoad = false;
        NPSPackageManager.getInstance().installBundle(NPS_PLUGIN_PKG_NAME, new IInstallCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.7
            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onProgress(long j, long j2) {
                YYLiveNPSPluginManager.this.fromDownLoad = true;
                if (YYLiveNPSPluginManager.this.loadingCallback == null || YYLiveNPSPluginManager.this.isLoadingCanceled) {
                    return;
                }
                YYLiveNPSPluginManager.this.loadingCallback.onLoadingProgress(j, j2);
            }

            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onResult(int i2, String str2) {
                if (!YYLiveNPSPluginManager.this.isLoadingCanceled && i2 != 34) {
                    YYLiveNPSPluginManager.this.stopLoading(i2);
                }
                if (i2 == 13) {
                    if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                        YYLiveNPSPluginManager.this.ubcManager.flowEndSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_install");
                        YYLiveNPSPluginManager.this.ubcManager.flowStartSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_load", null);
                    }
                    NPSManager.getInstance().loadClazz(YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, YYLiveNPSPluginManager.NPS_PLUGIN_IMPL_CLASS_NAME, IYYLiveNPSPlugin.class, iInvokeCallback2);
                } else if (i2 == 3 && NPSPackageManager.getInstance().getBundleStatus(YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME) == 43) {
                    if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                        YYLiveNPSPluginManager.this.ubcManager.flowEndSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_install");
                        YYLiveNPSPluginManager.this.ubcManager.flowStartSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_load", null);
                    }
                    NPSManager.getInstance().loadClazz(YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, YYLiveNPSPluginManager.NPS_PLUGIN_IMPL_CLASS_NAME, IYYLiveNPSPlugin.class, iInvokeCallback2);
                } else {
                    if (z) {
                        if (i2 == 34) {
                            if (YYLiveNPSPluginManager.this.loadingCallback == null) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_installing, 0);
                            }
                        } else {
                            YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                        }
                    }
                    if (YYLiveNPSPluginManager.this.isDebug()) {
                        Log.w(YYLiveNPSPluginManager.TAG, "install live nps plugin error=" + i2);
                    }
                    int pluginUpdateVersion = YYLiveNPSPluginManager.this.getPluginUpdateVersion();
                    if (pluginUpdateVersion == 0) {
                        pluginUpdateVersion = YYLiveNPSPluginManager.this.getPluginDownloadVersion();
                    }
                    int i3 = pluginUpdateVersion;
                    if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                        YYLiveNPSPluginManager.this.ubcManager.flowEnd(YYLiveNPSPluginManager.this.pageFlow);
                        YYLiveNPSPluginManager.this.pageFlow = null;
                    }
                    YYLiveNPSPluginManager yYLiveNPSPluginManager = YYLiveNPSPluginManager.this;
                    yYLiveNPSPluginManager.logPluginEnd(YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, i3, false, "install code" + i2, "nps_install", str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginEnd(String str, int i2, boolean z, String str2, String str3, String str4) {
        if (this.ubcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "yy_live");
                jSONObject.put("type", "end_load");
                if (z) {
                    jSONObject.put("value", "suc");
                } else {
                    jSONObject.put("value", "fail");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkg", str);
                jSONObject2.put("ver", i2);
                jSONObject2.put("load_from", str3);
                jSONObject2.put("entry", str4);
                jSONObject2.put("reason", str2);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.ubcManager.onEvent("3036", jSONObject);
        }
    }

    private void logPluginLoad(String str, String str2) {
        if (this.ubcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "yy_live");
                jSONObject.put("type", "start_load");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkg", str);
                jSONObject2.put("entry", str2);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.ubcManager.onEvent("3037", jSONObject);
        }
    }

    private void showLoading() {
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = this.loadingCallback;
        if (liveYYNpsLoadingCallback != null) {
            liveYYNpsLoadingCallback.onLoadingStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(final int i2, final int i3) {
        ToastService toastService;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.8
                @Override // java.lang.Runnable
                public void run() {
                    if (YYLiveNPSPluginManager.this.appService == null || YYLiveNPSPluginManager.this.toastService == null) {
                        return;
                    }
                    YYLiveNPSPluginManager.this.toastService.showNormal(YYLiveNPSPluginManager.this.appService.getApplication(), YYLiveNPSPluginManager.this.appService.getApplication().getResources().getString(i2), i3);
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
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = this.loadingCallback;
        if (liveYYNpsLoadingCallback != null) {
            liveYYNpsLoadingCallback.onLoadingEnd(i2);
        }
    }

    public void cancelLoading() {
        this.isLoadingCanceled = true;
    }

    public void clearLiveResourceSize(@NonNull final Context context) {
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "_clearRes", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.10
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str, final Object obj, String str2) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i2 != 14) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                YYLiveNPSPluginManager.this.impl.clearLiveResourceSize(context);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            });
            return;
        }
        try {
            iYYLiveNPSPlugin.clearLiveResourceSize(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dispatchHostEvent(@NonNull Context context, @NonNull String str, @NonNull Map<String, Object> map) {
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin != null) {
            try {
                iYYLiveNPSPlugin.dispatchHostEvent(context, str, map);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void dispatchYYLiveRouter(final Context context, final String str) {
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, DI.ROUTER_NAME, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.12
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str2, final Object obj, String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i2 != 14) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                YYLiveNPSPluginManager.this.impl.dispatchYYLiveRouter(context, str);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            });
            return;
        }
        try {
            iYYLiveNPSPlugin.dispatchYYLiveRouter(context, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dispatchYYRawLiveRouter(final Context context, final String str) {
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, DI.ROUTER_NAME, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.13
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str2, final Object obj, String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i2 != 14) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                YYLiveNPSPluginManager.this.impl.dispatchYYRawLiveRouter(context, str);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            });
            return;
        }
        try {
            iYYLiveNPSPlugin.dispatchYYRawLiveRouter(context, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void getLiveResourceSize(@NonNull final Context context, final ILiveFileSizeCallback iLiveFileSizeCallback) {
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "_getSize", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.11
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str, final Object obj, String str2) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i2 != 14) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                YYLiveNPSPluginManager.this.impl.getLiveResourceSize(context, iLiveFileSizeCallback);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            });
            return;
        }
        try {
            iYYLiveNPSPlugin.getLiveResourceSize(context, iLiveFileSizeCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isAvailable() {
        BundleInfo bundleByType;
        BundleInfo bundleByType2;
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
        BundleInfo bundleByType3 = bundleGroup.getBundleByType(3);
        boolean z = (bundleGroup.getBundleByType(2) == null && bundleGroup.getBundleByType(1) == null) ? false : true;
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME2_1);
        BundleInfo bundleInfo2 = NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME2_2);
        if (!z) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: top plugin has no update");
            }
            return true;
        } else if (bundleByType3 == null) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: top plugin not install");
            }
            return false;
        } else if (bundleInfo == null && bundleInfo2 == null) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: sec plugin not exist");
            }
            return true;
        } else if (bundleInfo != null && compareVersion(bundleByType3.getVersionCode(), bundleInfo.getVersionCode()) < 0) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: installed sec1 plugin too high");
            }
            return false;
        } else if (bundleInfo2 != null && compareVersion(bundleByType3.getVersionCode(), bundleInfo2.getVersionCode()) < 0) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: installed sec2 plugin too high");
            }
            return false;
        } else {
            BundleInfoGroup bundleGroup2 = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_PKG_NAME2_1);
            if (bundleGroup2 != null) {
                BundleInfo bundleByType4 = bundleGroup2.getBundleByType(1);
                if (bundleByType4 != null && bundleByType4.needForceUpdate() && compareVersion(bundleByType3.getVersionCode(), bundleByType4.getVersionCode()) < 0) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: sec1 plugin force update1");
                    }
                    return false;
                } else if (bundleByType4 == null && (bundleByType2 = bundleGroup2.getBundleByType(2)) != null && bundleByType2.needForceUpdate() && compareVersion(bundleByType3.getVersionCode(), bundleByType2.getVersionCode()) < 0) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: sec1 plugin force update2");
                    }
                    return false;
                }
            }
            BundleInfoGroup bundleGroup3 = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_PKG_NAME2_2);
            if (bundleGroup3 != null) {
                BundleInfo bundleByType5 = bundleGroup3.getBundleByType(1);
                if (bundleByType5 != null && bundleByType5.needForceUpdate() && compareVersion(bundleByType3.getVersionCode(), bundleByType5.getVersionCode()) < 0) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: sec2 plugin force update1");
                    }
                    return false;
                } else if (bundleByType5 == null && (bundleByType = bundleGroup3.getBundleByType(2)) != null && bundleByType.needForceUpdate() && compareVersion(bundleByType3.getVersionCode(), bundleByType.getVersionCode()) < 0) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: sec2 plugin force update2");
                    }
                    return false;
                }
            }
            return true;
        }
    }

    public void onDiskClearCacheChange(final long j, final int i2, final int i3, final ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Log.d(TAG, "start DiskClearCacheChange t=" + System.currentTimeMillis());
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "_diskCleaner", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.9
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i4, String str, final Object obj, String str2) {
                    Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i4 != 14) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                YYLiveNPSPluginManager.this.impl.onDiskClearCacheChange(j, i2, i3, iLiveDiskClearCacheCallback);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            });
            return;
        }
        try {
            iYYLiveNPSPlugin.onDiskClearCacheChange(j, i2, i3, iLiveDiskClearCacheCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoadingCallback(LiveYYNpsLoadingCallback liveYYNpsLoadingCallback) {
        this.loadingCallback = liveYYNpsLoadingCallback;
    }

    public void startYYActivity(final Context context) {
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "_yyTest", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.1
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str, final Object obj, String str2) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i2 != 14) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                YYLiveNPSPluginManager.this.impl.startYYActivity(context);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            });
        } else {
            iYYLiveNPSPlugin.startYYActivity(context);
        }
    }

    public void startYYCustomerServiceActivity(@NonNull final Context context, @NonNull final String str) {
        Log.d(TAG, "startYYFeedbackActivity t=" + System.currentTimeMillis());
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "_customerService", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.4
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str2, final Object obj, String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i2 != 14) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                YYLiveNPSPluginManager.this.impl.startYYCustomerServiceActivity(context, str);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            });
        } else {
            iYYLiveNPSPlugin.startYYCustomerServiceActivity(context, str);
        }
    }

    public void startYYFeedbackActivity(@NonNull final Context context, @NonNull final String str) {
        Log.d(TAG, "startYYFeedbackActivity t=" + System.currentTimeMillis());
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "_feedback", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.3
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str2, final Object obj, String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i2 != 14) {
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                YYLiveNPSPluginManager.this.impl.startYYFeedbackActivity(context, str);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            });
        } else {
            iYYLiveNPSPlugin.startYYFeedbackActivity(context, str);
        }
    }

    public void startYYLiveActivity(@NonNull final Context context, @NonNull final String str) {
        UBCManager uBCManager = this.ubcManager;
        if (uBCManager != null) {
            this.pageFlow = uBCManager.beginFlow("3121");
        }
        String entry = getEntry(str);
        checkHandler();
        if (this.impl == null) {
            loadNPSPluginImpl(true, entry, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.2
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i2, String str2, final Object obj, final String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i2 != 14) {
                                if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                                    YYLiveNPSPluginManager.this.ubcManager.flowEnd(YYLiveNPSPluginManager.this.pageFlow);
                                    YYLiveNPSPluginManager.this.pageFlow = null;
                                }
                                YYLiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_yy_impl_load_fail, 0);
                                return;
                            }
                            try {
                                YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                if (YYLiveNPSPluginManager.this.pageFlow != null) {
                                    YYStatInfo yYStatInfo = new YYStatInfo();
                                    yYStatInfo.flowObj = YYLiveNPSPluginManager.this.pageFlow;
                                    yYStatInfo.isColdLaunch = true;
                                    yYStatInfo.loadType = str3;
                                    YYLiveNPSPluginManager.this.impl.updateStatInfo(yYStatInfo);
                                    YYLiveNPSPluginManager.this.pageFlow = null;
                                }
                                YYLiveNPSPluginManager.this.impl.startYYLiveActivity(context, str);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            });
            return;
        }
        if (this.pageFlow != null) {
            YYStatInfo yYStatInfo = new YYStatInfo();
            yYStatInfo.flowObj = this.pageFlow;
            yYStatInfo.isColdLaunch = false;
            yYStatInfo.loadType = "launch";
            try {
                this.impl.updateStatInfo(yYStatInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.pageFlow = null;
        }
        this.impl.startYYLiveActivity(context, str);
    }

    public YYLiveNPSPluginManager() {
        this.impl = null;
        this.handler = new Handler(Looper.getMainLooper());
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.isLoadingCanceled = false;
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.fromDownLoad = false;
    }
}
