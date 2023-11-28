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
import com.baidu.tieba.R;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import com.huawei.hms.framework.common.ExceptionCode;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public interface PluginLoadCallback {
        void onResult(int i, String str, Object obj, String str2);
    }

    /* loaded from: classes4.dex */
    public static class SingletonHolder {
        public static YYLiveNPSPluginManager instance = new YYLiveNPSPluginManager();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading(int i) {
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = this.loadingCallback;
        if (liveYYNpsLoadingCallback != null) {
            liveYYNpsLoadingCallback.onLoadingEnd(i);
        }
    }

    public void clearLiveResourceSize(@NonNull final Context context) {
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "_clearRes", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.10
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i, String str, final Object obj, String str2) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i == 14) {
                                try {
                                    YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    YYLiveNPSPluginManager.this.impl.clearLiveResourceSize(context);
                                    return;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    return;
                                }
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
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

    public void setLoadingCallback(LiveYYNpsLoadingCallback liveYYNpsLoadingCallback) {
        this.loadingCallback = liveYYNpsLoadingCallback;
    }

    public void startYYActivity(final Context context) {
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "_yyTest", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.1
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i, String str, final Object obj, String str2) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i == 14) {
                                try {
                                    YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    YYLiveNPSPluginManager.this.impl.startYYActivity(context);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
                        }
                    });
                }
            });
        } else {
            iYYLiveNPSPlugin.startYYActivity(context);
        }
    }

    private int compareVersion(int i, int i2) {
        return (i / ExceptionCode.CRASH_EXCEPTION) - (i2 / ExceptionCode.CRASH_EXCEPTION);
    }

    public void dispatchYYLiveRouter(final Context context, final String str) {
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, DI.ROUTER_NAME, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.12
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i, String str2, final Object obj, String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i == 14) {
                                try {
                                    YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    YYLiveNPSPluginManager.this.impl.dispatchYYLiveRouter(context, str);
                                    return;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    return;
                                }
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
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
                public void onResult(final int i, String str2, final Object obj, String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i == 14) {
                                try {
                                    YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    YYLiveNPSPluginManager.this.impl.dispatchYYRawLiveRouter(context, str);
                                    return;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    return;
                                }
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
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
                public void onResult(final int i, String str, final Object obj, String str2) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i == 14) {
                                try {
                                    YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    YYLiveNPSPluginManager.this.impl.getLiveResourceSize(context, iLiveFileSizeCallback);
                                    return;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    return;
                                }
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
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

    public void startYYCustomerServiceActivity(@NonNull final Context context, @NonNull final String str) {
        Log.d(TAG, "startYYFeedbackActivity t=" + System.currentTimeMillis());
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, "_customerService", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.4
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i, String str2, final Object obj, String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i == 14) {
                                try {
                                    YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    YYLiveNPSPluginManager.this.impl.startYYCustomerServiceActivity(context, str);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
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
                public void onResult(final int i, String str2, final Object obj, String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i == 14) {
                                try {
                                    YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    YYLiveNPSPluginManager.this.impl.startYYFeedbackActivity(context, str);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
                        }
                    });
                }
            });
        } else {
            iYYLiveNPSPlugin.startYYFeedbackActivity(context, str);
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

    private void checkHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    public static YYLiveNPSPluginManager getInstance() {
        return SingletonHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginDownloadVersion() {
        BundleInfo bundleByType;
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
        if (bundleGroup == null || (bundleByType = bundleGroup.getBundleByType(2)) == null) {
            return 0;
        }
        return bundleByType.getVersionCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginInstallVersion() {
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance");
        if (bundleInfo == null) {
            return 0;
        }
        return bundleInfo.getVersionCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginUpdateVersion() {
        BundleInfo bundleByType;
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
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

    private void showLoading() {
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = this.loadingCallback;
        if (liveYYNpsLoadingCallback != null) {
            liveYYNpsLoadingCallback.onLoadingStart();
        }
    }

    public void cancelLoading() {
        this.isLoadingCanceled = true;
    }

    private String getEntry(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("params");
        if (TextUtils.isEmpty(queryParameter)) {
            String queryParameter2 = parse.getQueryParameter("source");
            String queryParameter3 = parse.getQueryParameter("tab");
            String queryParameter4 = parse.getQueryParameter("tag");
            if (!TextUtils.isEmpty(queryParameter3) || !TextUtils.isEmpty(queryParameter4)) {
                return queryParameter3 + "-" + queryParameter4 + "-" + queryParameter2;
            }
            return queryParameter2;
        }
        try {
            return new JSONObject(queryParameter).optString("source");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void loadNPSPluginImpl(final boolean z, final String str, final PluginLoadCallback pluginLoadCallback) {
        Flow flow;
        Flow flow2;
        this.mCurrentCallback = pluginLoadCallback;
        IInvokeCallback iInvokeCallback = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.5
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i, final String str2, final Object obj) {
                boolean z2;
                if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                    YYLiveNPSPluginManager.this.ubcManager.flowEndSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_load");
                }
                YYLiveNPSPluginManager yYLiveNPSPluginManager = YYLiveNPSPluginManager.this;
                int pluginInstallVersion = yYLiveNPSPluginManager.getPluginInstallVersion();
                if (i == 14) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                yYLiveNPSPluginManager.logPluginEnd("com.baidu.searchbox.yylive.entrance", pluginInstallVersion, z2, "load code" + i, "nps_load", str);
                if (pluginLoadCallback != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        YYLiveNPSPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (YYLiveNPSPluginManager.this.mCurrentCallback != null) {
                                    YYLiveNPSPluginManager.this.mCurrentCallback.onResult(i, str2, obj, "load");
                                    YYLiveNPSPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (YYLiveNPSPluginManager.this.mCurrentCallback != null) {
                        YYLiveNPSPluginManager.this.mCurrentCallback.onResult(i, str2, obj, "load");
                        YYLiveNPSPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        final IInvokeCallback iInvokeCallback2 = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.6
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i, final String str2, final Object obj) {
                String str3;
                boolean z2;
                String str4;
                if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                    YYLiveNPSPluginManager.this.ubcManager.flowEndSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_load");
                }
                if (YYLiveNPSPluginManager.this.fromDownLoad) {
                    str3 = "download";
                } else {
                    str3 = "install";
                }
                final String str5 = str3;
                YYLiveNPSPluginManager yYLiveNPSPluginManager = YYLiveNPSPluginManager.this;
                int pluginInstallVersion = yYLiveNPSPluginManager.getPluginInstallVersion();
                if (i == 14) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                String str6 = "load code" + i;
                if (YYLiveNPSPluginManager.this.fromDownLoad) {
                    str4 = "nps_download";
                } else {
                    str4 = "nps_install";
                }
                yYLiveNPSPluginManager.logPluginEnd("com.baidu.searchbox.yylive.entrance", pluginInstallVersion, z2, str6, str4, str);
                if (pluginLoadCallback != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        YYLiveNPSPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (YYLiveNPSPluginManager.this.mCurrentCallback != null) {
                                    YYLiveNPSPluginManager.this.mCurrentCallback.onResult(i, str2, obj, str5);
                                    YYLiveNPSPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (YYLiveNPSPluginManager.this.mCurrentCallback != null) {
                        YYLiveNPSPluginManager.this.mCurrentCallback.onResult(i, str2, obj, str5);
                        YYLiveNPSPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        logPluginLoad("com.baidu.searchbox.yylive.entrance", str);
        if (isAvailable()) {
            this.fromDownLoad = false;
            UBCManager uBCManager = this.ubcManager;
            if (uBCManager != null && (flow2 = this.pageFlow) != null) {
                uBCManager.flowStartSlot(flow2, "plugin_load", null);
            }
            NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback);
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
        NPSPackageManager.getInstance().installBundle("com.baidu.searchbox.yylive.entrance", new IInstallCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.7
            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onProgress(long j, long j2) {
                YYLiveNPSPluginManager.this.fromDownLoad = true;
                if (YYLiveNPSPluginManager.this.loadingCallback != null && !YYLiveNPSPluginManager.this.isLoadingCanceled) {
                    YYLiveNPSPluginManager.this.loadingCallback.onLoadingProgress(j, j2);
                }
            }

            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onResult(int i, String str2) {
                if (!YYLiveNPSPluginManager.this.isLoadingCanceled && i != 34) {
                    YYLiveNPSPluginManager.this.stopLoading(i);
                }
                if (i == 13) {
                    if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                        YYLiveNPSPluginManager.this.ubcManager.flowEndSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_install");
                        YYLiveNPSPluginManager.this.ubcManager.flowStartSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_load", null);
                    }
                    NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback2);
                } else if (i == 3 && NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance") == 43) {
                    if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                        YYLiveNPSPluginManager.this.ubcManager.flowEndSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_install");
                        YYLiveNPSPluginManager.this.ubcManager.flowStartSlot(YYLiveNPSPluginManager.this.pageFlow, "plugin_load", null);
                    }
                    NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback2);
                } else {
                    if (z) {
                        if (i == 34) {
                            if (YYLiveNPSPluginManager.this.loadingCallback == null) {
                                YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c23, 0);
                            }
                        } else {
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
                        }
                    }
                    if (YYLiveNPSPluginManager.this.isDebug()) {
                        Log.w(YYLiveNPSPluginManager.TAG, "install live nps plugin error=" + i);
                    }
                    int pluginUpdateVersion = YYLiveNPSPluginManager.this.getPluginUpdateVersion();
                    if (pluginUpdateVersion == 0) {
                        pluginUpdateVersion = YYLiveNPSPluginManager.this.getPluginDownloadVersion();
                    }
                    int i2 = pluginUpdateVersion;
                    if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                        YYLiveNPSPluginManager.this.ubcManager.flowEnd(YYLiveNPSPluginManager.this.pageFlow);
                        YYLiveNPSPluginManager.this.pageFlow = null;
                    }
                    YYLiveNPSPluginManager yYLiveNPSPluginManager = YYLiveNPSPluginManager.this;
                    yYLiveNPSPluginManager.logPluginEnd("com.baidu.searchbox.yylive.entrance", i2, false, "install code" + i, "nps_install", str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginEnd(String str, int i, boolean z, String str2, String str3, String str4) {
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
                jSONObject2.put("ver", i);
                jSONObject2.put("load_from", str3);
                jSONObject2.put("entry", str4);
                jSONObject2.put("reason", str2);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.ubcManager.onEvent("3037", jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(final int i, final int i2) {
        ToastService toastService;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.8
                @Override // java.lang.Runnable
                public void run() {
                    if (YYLiveNPSPluginManager.this.appService != null && YYLiveNPSPluginManager.this.toastService != null) {
                        YYLiveNPSPluginManager.this.toastService.showNormal(YYLiveNPSPluginManager.this.appService.getApplication(), YYLiveNPSPluginManager.this.appService.getApplication().getResources().getString(i), i2);
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

    public boolean isAvailable() {
        boolean z;
        BundleInfo bundleByType;
        BundleInfo bundleByType2;
        int bundleStatus = NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance");
        if (bundleStatus != 43) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
            }
            return false;
        }
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
        if (bundleGroup == null) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: top plugin is null");
            }
            return false;
        }
        BundleInfo bundleByType3 = bundleGroup.getBundleByType(3);
        if (bundleGroup.getBundleByType(2) == null && bundleGroup.getBundleByType(1) == null) {
            z = false;
        } else {
            z = true;
        }
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

    public void onDiskClearCacheChange(final long j, final int i, final int i2, final ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Log.d(TAG, "start DiskClearCacheChange t=" + System.currentTimeMillis());
        checkHandler();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, "_diskCleaner", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.9
                @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                public void onResult(final int i3, String str, final Object obj, String str2) {
                    Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i3 == 14) {
                                try {
                                    YYLiveNPSPluginManager.this.impl = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    YYLiveNPSPluginManager.this.impl.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
                                    return;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    return;
                                }
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
                        }
                    });
                }
            });
            return;
        }
        try {
            iYYLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
        } catch (Throwable th) {
            th.printStackTrace();
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
                public void onResult(final int i, String str2, final Object obj, final String str3) {
                    YYLiveNPSPluginManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i == 14) {
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
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            if (YYLiveNPSPluginManager.this.ubcManager != null && YYLiveNPSPluginManager.this.pageFlow != null) {
                                YYLiveNPSPluginManager.this.ubcManager.flowEnd(YYLiveNPSPluginManager.this.pageFlow);
                                YYLiveNPSPluginManager.this.pageFlow = null;
                            }
                            YYLiveNPSPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f0c22, 0);
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
}
