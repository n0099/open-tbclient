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
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import d.b.t.a.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class LiveNPSPluginManager {
    public static final String NPS_PLUGIN_IMPL_CLASS_NAME = "com.baidu.searchbox.live.LiveNPSPluginImpl";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String TAG = "com.baidu.searchbox.live.nps.LiveNPSPluginManager";
    public AppInfoService appService;
    public Handler handler;
    public boolean isLoadingCanceled;
    public LiveNpsLoadingCallback loadingCallback;
    public IInvokeCallback mCurrentCallback;
    public ILiveNPSPlugin mLiveNPSPlugin;
    public ToastService toastService;

    /* loaded from: classes3.dex */
    public static class SingletonHolder {
        public static LiveNPSPluginManager instance = new LiveNPSPluginManager();
    }

    public static LiveNPSPluginManager getInstance() {
        return SingletonHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null) {
            return appInfoService.isDebug();
        }
        return false;
    }

    private void loadNPSPluginImpl(final boolean z, final IInvokeCallback iInvokeCallback) {
        this.mCurrentCallback = iInvokeCallback;
        final IInvokeCallback iInvokeCallback2 = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.21
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i, final String str, final Object obj) {
                if (iInvokeCallback != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        LiveNPSPluginManager.this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.21.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveNPSPluginManager.this.mCurrentCallback != null) {
                                    LiveNPSPluginManager.this.mCurrentCallback.onResult(i, str, obj);
                                    LiveNPSPluginManager.this.mCurrentCallback = null;
                                }
                            }
                        });
                    } else if (LiveNPSPluginManager.this.mCurrentCallback != null) {
                        LiveNPSPluginManager.this.mCurrentCallback.onResult(i, str, obj);
                        LiveNPSPluginManager.this.mCurrentCallback = null;
                    }
                }
            }
        };
        if (isAvailable()) {
            NPSManager.getInstance().loadClazz(NPS_PLUGIN_PKG_NAME, NPS_PLUGIN_IMPL_CLASS_NAME, ILiveNPSPlugin.class, iInvokeCallback2);
            return;
        }
        this.isLoadingCanceled = false;
        if (z) {
            showLoading();
        }
        NPSPackageManager.getInstance().installBundle(NPS_PLUGIN_PKG_NAME, new IInstallCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.22
            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onProgress(long j, long j2) {
                if (LiveNPSPluginManager.this.loadingCallback == null || LiveNPSPluginManager.this.isLoadingCanceled) {
                    return;
                }
                LiveNPSPluginManager.this.loadingCallback.onLoadingProgress(j, j2);
            }

            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onResult(int i, String str) {
                if (!LiveNPSPluginManager.this.isLoadingCanceled && i != 34) {
                    LiveNPSPluginManager.this.stopLoading(i);
                }
                if (i == 13) {
                    NPSManager.getInstance().loadClazz(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, LiveNPSPluginManager.NPS_PLUGIN_IMPL_CLASS_NAME, ILiveNPSPlugin.class, iInvokeCallback2);
                    return;
                }
                if (z) {
                    if (i == 34) {
                        if (LiveNPSPluginManager.this.loadingCallback == null) {
                            LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_installing, 0);
                        }
                    } else {
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                }
                if (LiveNPSPluginManager.this.isDebug()) {
                    String str2 = LiveNPSPluginManager.TAG;
                    Log.w(str2, "install live nps plugin error=" + i);
                }
            }
        });
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
    public void showNormalToast(final int i, final int i2) {
        ToastService toastService;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.27
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveNPSPluginManager.this.appService == null || LiveNPSPluginManager.this.toastService == null) {
                        return;
                    }
                    LiveNPSPluginManager.this.toastService.showNormal(LiveNPSPluginManager.this.appService.getApplication(), LiveNPSPluginManager.this.appService.getApplication().getResources().getString(i), i2);
                }
            });
            return;
        }
        AppInfoService appInfoService = this.appService;
        if (appInfoService == null || (toastService = this.toastService) == null) {
            return;
        }
        toastService.showNormal(appInfoService.getApplication(), this.appService.getApplication().getResources().getString(i), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading(int i) {
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingEnd(i);
        }
    }

    public void cancelLoading() {
        this.isLoadingCanceled = true;
    }

    public void checkArSdkLoadStatus(@NonNull Context context, @NonNull final LiveNpsArStatusCallback liveNpsArStatusCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.18
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(false, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.25
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.clearLiveResourceSize(context);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i);
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
            if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                this.mLiveNPSPlugin.getLiveMediaEntry().dispatchHostEvent(context, str, map);
            }
        }
    }

    public BundleInfo getInstalledPluginInfo() {
        return NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME);
    }

    public void getLiveResourceFileSize(@NonNull final Context context, @NonNull final ILiveFileSizeCallback iLiveFileSizeCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.24
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    if (i == 14) {
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
                    LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(false, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.4
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(false, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.23
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    if (i == 14) {
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
                    LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.getLiveSdkSize(context, iLiveFileSizeCallback);
        }
    }

    public boolean isAvailable() {
        return NPSPackageManager.getInstance().getBundleStatus(NPS_PLUGIN_PKG_NAME) == 43;
    }

    public void isInHistory(@NonNull final String str, @NonNull final LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.3
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i);
                    }
                }
            });
        } else {
            iLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
        }
    }

    public void onDiskClearCacheChange(final long j, final int i, final int i2, final ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(false, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.26
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i3, String str, Object obj) {
                    if (i3 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            LiveNPSPluginManager.this.mLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
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

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        this.loadingCallback = liveNpsLoadingCallback;
    }

    public void startAdminListActivity(@NonNull final Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.13
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.19
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    if (i == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.19.1
                                @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                public void onProgress(int i2, int i3) {
                                    liveNpsArLoadCallback.onProgress(i2, i3);
                                }

                                @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                public void onResult(boolean z, String str2) {
                                    liveNpsArLoadCallback.onResult(z, str2);
                                }
                            });
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.20
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

    public void startBjhMasterActivity(@NonNull final Application application, final String str, final Uri uri) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.2
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
            this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
        }
    }

    public void startFansListActivity(@NonNull final Context context, @NonNull final String str, final int i) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.9
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i2, String str2, Object obj) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(context, str, i);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(context, str, i);
        }
    }

    public void startForbiddenListActivity(@NonNull final Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.14
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.10
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str3, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str4 = LiveNPSPluginManager.TAG;
                        Log.w(str4, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(context, str, str2);
        }
    }

    public void startLiveExpActivity(@NonNull final Context context, final long j, final int i) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.11
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i2, String str, Object obj) {
                    if (i2 == 14) {
                        try {
                            LiveNPSPluginManager.this.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                            if (LiveNPSPluginManager.this.isLoadingCanceled || LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                return;
                            }
                            LiveNPSPluginManager.this.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(context, j, i);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!LiveNPSPluginManager.this.isLoadingCanceled) {
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i2);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(context, j, i);
        }
    }

    public void startLiveMediaActivity(final Context context, final String str, final String str2, final String str3, final Uri uri) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.1
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str4, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str5 = LiveNPSPluginManager.TAG;
                        Log.w(str5, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.5
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(context, str);
        }
    }

    public void startPatronageActivity(@NonNull final Context context) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.7
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str2 = LiveNPSPluginManager.TAG;
                        Log.w(str2, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.8
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.6
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.15
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str3, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str4 = LiveNPSPluginManager.TAG;
                        Log.w(str4, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.12
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(context, str);
        }
    }

    public void startYuYinActivity(@NonNull final Context context, @NonNull final String str, @NonNull final String str2, final Map<String, Object> map) {
        ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
        if (iLiveNPSPlugin == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.16
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str3, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str4 = LiveNPSPluginManager.TAG;
                        Log.w(str4, "load live nps plugin error=" + i);
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
            loadNPSPluginImpl(true, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.17
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    if (i == 14) {
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
                        LiveNPSPluginManager.this.showNormalToast(a.liveshow_plugin_impl_load_fail, 0);
                    }
                    if (LiveNPSPluginManager.this.isDebug()) {
                        String str3 = LiveNPSPluginManager.TAG;
                        Log.w(str3, "load live nps plugin error=" + i);
                    }
                }
            });
        } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
            this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(context, str);
        }
    }

    public LiveNPSPluginManager() {
        this.handler = new Handler(Looper.getMainLooper());
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.isLoadingCanceled = false;
    }
}
