package com.baidu.searchbox.live.nps;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.LiveYalogService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yalog.LiveYalogApi;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.mix.proxy.LiveMixShellManager;
import com.baidu.searchbox.live.nps.util.SchemeParamsParseUtils;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveNPSPluginManager {
    public static final String MEDIA_BUSINESS_PKG_NAME = "com.baidu.live.media.business";
    public static final String MULTI_PLUGIN_YALOG_SPACE = "multi_plugin";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String TAG = "LiveNPSPluginManager";
    public static final String YY_FIRST_NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public AppInfoService appService;
    public int pluginArchLaunchType;
    public ToastService toastService;
    public LiveYalogApi yalogApi;
    public LiveYalogService yalogService;

    @Deprecated
    public void checkArSdkLoadStatus(@NonNull Context context, @NonNull LiveNpsArStatusCallback liveNpsArStatusCallback) {
    }

    @Deprecated
    public void clearResourceFile(@NonNull Context context) {
    }

    @Deprecated
    public void startAdminListActivity(@NonNull Context context) {
    }

    @Deprecated
    public void startArSdkLoad(@NonNull Context context, @NonNull LiveNpsArLoadCallback liveNpsArLoadCallback) {
    }

    @Deprecated
    public void startFansListActivity(@NonNull Context context, @NonNull String str, int i) {
    }

    @Deprecated
    public void startForbiddenListActivity(@NonNull Context context) {
    }

    @Deprecated
    public void startGuardianListActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
    }

    @Deprecated
    public void startLiveExpActivity(@NonNull Context context, long j, int i) {
    }

    @Deprecated
    public void startLiveShowActivity(@NonNull Context context, @NonNull String str) {
    }

    @Deprecated
    public void startMasterActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
    }

    @Deprecated
    public void startMasterActivityV2(@NonNull Context context, @NonNull String str, @NonNull String str2) {
    }

    @Deprecated
    public void startPatronageActivity(@NonNull Context context) {
    }

    @Deprecated
    public void startPatronsActivity(@NonNull Context context, String str) {
    }

    @Deprecated
    public void startPayActivity(@NonNull Context context, @NonNull String str) {
    }

    @Deprecated
    public void startRealAuthActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
    }

    @Deprecated
    public void startShowMasterActivity(@NonNull Context context, String str) {
    }

    @Deprecated
    public void startYuYinActivity(@NonNull Context context, @NonNull String str, @NonNull String str2, Map<String, Object> map) {
    }

    @Deprecated
    public void startYuYinCreateLiveRoomActivity(@NonNull Context context, String str) {
    }

    /* loaded from: classes4.dex */
    public static class SingletonHolder {
        public static LiveNPSPluginManager instance = new LiveNPSPluginManager();
    }

    public LiveNPSPluginManager() {
        this.yalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
        this.yalogApi = null;
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        LiveYalogService liveYalogService = this.yalogService;
        if (liveYalogService != null) {
            this.yalogApi = liveYalogService.buildYalogApi("multi_plugin");
        }
    }

    private void dLog(String str) {
        NpsLoadChainLog.getInstance().dLog(str);
    }

    private boolean isYYFirstPlugin(String str) {
        return "com.baidu.searchbox.yylive.entrance".equals(str);
    }

    @Nullable
    public ClassLoader getPluginClassLoader(String str) {
        if (NPSManager.getInstance().getBundle(str) != null) {
            return NPSManager.getInstance().getBundle(str).getClassloader();
        }
        NpsLoadChainLog.getInstance().dLog("LiveNPSPluginManager getPluginClassLoader null");
        return null;
    }

    public int getPluginInstallVersion(String str) {
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(str);
        if (bundleInfo == null) {
            log("LiveNPSPluginManager getPluginInstallVersion 0");
            return 0;
        }
        log("LiveNPSPluginManager getPluginInstallVersion " + bundleInfo.getVersionCode());
        return bundleInfo.getVersionCode();
    }

    public void log(String str) {
        LiveYalogApi liveYalogApi = this.yalogApi;
        if (liveYalogApi != null) {
            liveYalogApi.d("", "", str);
        }
        NpsLoadChainLog.getInstance().dLog(str);
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        LiveMediaPluginManager.getInstance().setLoadingCallback(liveNpsLoadingCallback);
        LiveYYPluginManager.getInstance().setLoadingCallback(liveNpsLoadingCallback);
        LiveNPSPluginManagerOld.getInstance().setLoadingCallback(liveNpsLoadingCallback);
    }

    public void startYYActivity(Context context) {
        if (isSupportMixInHostPlugin()) {
            LiveYYPluginManager.getInstance().startYYActivity(context);
        } else {
            LiveNPSPluginManagerOld.getInstance().startYYActivity(context);
        }
    }

    public void updateStatInfo(YYStatInfo yYStatInfo) {
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().updateStatInfo(yYStatInfo);
        }
    }

    public static LiveNPSPluginManager getInstance() {
        return SingletonHolder.instance;
    }

    public void cancelLoading() {
        if (isSupportMixInHostPlugin()) {
            LiveYYPluginManager.getInstance().cancelLoading();
            LiveMediaPluginManager.getInstance().cancelLoading();
            return;
        }
        LiveNPSPluginManagerOld.getInstance().cancelLoading();
    }

    public void cancelStartYYLiveActivity() {
        if (isSupportMixInHostPlugin()) {
            LiveYYPluginManager.getInstance().cancelStartYYLiveActivity();
        } else {
            LiveNPSPluginManagerOld.getInstance().cancelStartYYLiveActivity();
        }
    }

    public IMixActivityInterface getMixActivityImpl() {
        return LiveMediaPluginManager.getInstance().getMixActivityImpl();
    }

    public boolean isSupportMixInHostPlugin() {
        return isSupportMixInHostPlugin(false);
    }

    private void startLiveMediaActivity(Context context, String str, String str2, String str3, Uri uri, boolean z) {
        String uri2;
        StringBuilder sb = new StringBuilder();
        sb.append("LiveNPSPluginManager startLiveMediaActivity roomId: ");
        sb.append(str);
        sb.append(" source: ");
        sb.append(str2);
        sb.append(" params: ");
        sb.append(str3);
        sb.append(" uri: ");
        if (uri == null) {
            uri2 = " ";
        } else {
            uri2 = uri.toString();
        }
        sb.append(uri2);
        log(sb.toString());
        String str4 = null;
        try {
            str4 = new JSONObject(str3).optString("playUrl");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> startNewFlow = FlowInfoHelper.startNewFlow(str, true);
        FlowInfoHelper.startSigleLineSlot(startNewFlow, "uscheme_patc", false);
        FlowInfoHelper.put(startNewFlow, "contains_url", Integer.valueOf(!TextUtils.isEmpty(str4) ? 1 : 0));
        FlowInfoHelper.put(startNewFlow, "scheme_url", str4);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("clickTime", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new Pair("clickFrom", "uscheme_patc"));
        Uri uriParam = SchemeParamsParseUtils.setUriParam(uri, arrayList, true);
        if (isSupportMixInHostPlugin(!NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.yylive.entrance"))) {
            LiveMixShellManager.INSTANCE.enterLiveRoom(context, str, str2, str3, uriParam);
        } else {
            LiveNPSPluginManagerOld.getInstance().startLiveMediaActivity(context, str, str2, str3, uriParam);
        }
    }

    public void dispatchHostEvent(@NonNull Context context, @NonNull String str, Map<String, Object> map) {
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().dispatchHostEvent(context, str, map);
            LiveYYPluginManager.getInstance().dispatchHostEvent(context, str, map);
            return;
        }
        LiveNPSPluginManagerOld.getInstance().dispatchHostEvent(context, str, map);
    }

    public void dispatchLiveMasterRouter(@NonNull Application application, String str, Map<String, Object> map) {
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().dispatchLiveMasterRouter(application, str, map);
        } else {
            LiveNPSPluginManagerOld.getInstance().dispatchLiveMasterRouter(application, str, map);
        }
    }

    public void startBjhMasterActivity(@NonNull Application application, String str, Uri uri) {
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().startBjhMasterActivity(application, str, uri);
        } else {
            LiveNPSPluginManagerOld.getInstance().startBjhMasterActivity(application, str, uri);
        }
    }

    public void startBjhMasterActivityNew(@NonNull Context context, String str, Uri uri) {
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().startBjhMasterActivityNew(context, str, uri);
        } else {
            LiveNPSPluginManagerOld.getInstance().startBjhMasterActivityNew(context, str, uri);
        }
    }

    public void dispatchYYLiveRouter(@NonNull Context context, @NonNull String str) {
        if (isSupportMixInHostPlugin()) {
            LiveYYPluginManager.getInstance().dispatchYYLiveRouter(context, str);
        } else {
            LiveNPSPluginManagerOld.getInstance().dispatchYYLiveRouter(context, str);
        }
    }

    @Deprecated
    public void getLiveResourceFileSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback) {
        if (iLiveFileSizeCallback != null) {
            iLiveFileSizeCallback.getFileSize(0L);
        }
    }

    public void getLiveRoomStatus(@NonNull String str, @NonNull LiveStatusDataCallback<String> liveStatusDataCallback) {
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().getLiveRoomStatus(str, liveStatusDataCallback);
        } else {
            LiveNPSPluginManagerOld.getInstance().getLiveRoomStatus(str, liveStatusDataCallback);
        }
    }

    @Deprecated
    public void getLiveSdkFileSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback) {
        if (iLiveFileSizeCallback != null) {
            iLiveFileSizeCallback.getFileSize(0L);
        }
    }

    @Nullable
    public Map<String, Object> getMediaLivePlayConfig(@Nullable String str, @Nullable Map<String, Object> map) {
        return LiveMediaPluginManager.getInstance().getMediaLivePlayConfig(str, map);
    }

    public void isInHistory(@NonNull String str, @NonNull LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().isInHistory(str, liveStatusDataCallback);
        } else {
            LiveNPSPluginManagerOld.getInstance().isInHistory(str, liveStatusDataCallback);
        }
    }

    public void realStartYYLiveActivity(Context context, String str) {
        log("LiveNPSPluginManager realStartYYLiveActivity " + str);
        LiveYYPluginManager.getInstance().startYYLiveActivity(context, str);
    }

    public void startAudioMasterActivity(@NonNull Application application, String str) {
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().startAudioMasterActivity(application, str);
        } else {
            LiveNPSPluginManagerOld.getInstance().startAudioMasterActivity(application, str);
        }
    }

    public void startYYCustomerServiceActivity(@NonNull Context context, @NonNull String str) {
        if (isSupportMixInHostPlugin()) {
            LiveYYPluginManager.getInstance().startYYCustomerServiceActivity(context, str);
        } else {
            LiveNPSPluginManagerOld.getInstance().startYYCustomerServiceActivity(context, str);
        }
    }

    public void startYYFeedbackActivity(@NonNull Context context, @NonNull String str) {
        if (isSupportMixInHostPlugin()) {
            LiveYYPluginManager.getInstance().startYYFeedbackActivity(context, str);
        } else {
            LiveNPSPluginManagerOld.getInstance().startYYFeedbackActivity(context, str);
        }
    }

    public void startYYLiveActivity(Context context, String str) {
        if (isSupportMixInHostPlugin()) {
            LiveMixShellManager.INSTANCE.startYYLiveActivity(context, str);
        } else {
            LiveNPSPluginManagerOld.getInstance().startYYLiveActivity(context, str);
        }
    }

    public AssetManager getPluginAssets(String str) {
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null && appInfoService.getApplication() != null && this.appService.getApplication().getResources() != null && NPSManager.getInstance().getBundle(str) != null && NPSManager.getInstance().getBundle(str).getResources(this.appService.getApplication().getResources()) != null) {
            return NPSManager.getInstance().getBundle(str).getResources(this.appService.getApplication().getResources()).getAssets();
        }
        return null;
    }

    @Nullable
    public Resources getPluginResource(String str) {
        AppInfoService appInfoService;
        if (NPSManager.getInstance().getBundle(str) != null && (appInfoService = this.appService) != null && appInfoService.getApplication() != null) {
            return NPSManager.getInstance().getBundle(str).getResources(this.appService.getApplication().getResources());
        }
        NpsLoadChainLog.getInstance().dLog("LiveNPSPluginManager getPluginResource null");
        return null;
    }

    public boolean isLoaded(String str) {
        log("LiveNPSPluginManager isLoaded " + str);
        if (!"com.baidu.searchbox.livenps".equals(str) && !"com.baidu.live.media.business".equals(str)) {
            if (isYYFirstPlugin(str)) {
                log("LiveNPSPluginManager isLoaded " + LiveYYPluginManager.getInstance().isLoaded());
                return LiveYYPluginManager.getInstance().isLoaded();
            }
            return false;
        }
        log("LiveNPSPluginManager isLoaded " + LiveMediaPluginManager.getInstance().isLoaded(str));
        return LiveMediaPluginManager.getInstance().isLoaded(str);
    }

    public boolean isSupportMixInHostPlugin(boolean z) {
        log("LiveNPSPluginManager isSupportMixInHostPlugin pluginArchLaunchType " + this.pluginArchLaunchType);
        boolean z2 = true;
        if (this.pluginArchLaunchType == 0) {
            int pluginArchLaunchType = MultiPluginHelper.getPluginArchLaunchType(z);
            this.pluginArchLaunchType = pluginArchLaunchType;
            if (pluginArchLaunchType != 3) {
                z2 = false;
            }
            log("LiveNPSPluginManager isSupportMixInHostPlugin " + z2);
            return z2;
        } else if (!NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.livenps") && !NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.yylive.entrance")) {
            int pluginArchLaunchType2 = MultiPluginHelper.getPluginArchLaunchType(z);
            this.pluginArchLaunchType = pluginArchLaunchType2;
            if (pluginArchLaunchType2 != 3) {
                z2 = false;
            }
            log("LiveNPSPluginManager isSupportMixInHostPlugin " + z2);
            return z2;
        } else {
            log("LiveNPSPluginManager isSupportMixInHostPlugin " + NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.livenps") + "   " + NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.yylive.entrance"));
            if (this.pluginArchLaunchType == 3) {
                return true;
            }
            return false;
        }
    }

    public void loadPlugin(Context context, String str, String str2, boolean z, Map<String, String> map, PluginLoadCallback pluginLoadCallback) {
        log("LiveNPSPluginManager loadPlugin " + str + GlideException.IndentedAppendable.INDENT + str2);
        if (!"com.baidu.searchbox.livenps".equals(str) && !"com.baidu.live.media.business".equals(str)) {
            if (isYYFirstPlugin(str)) {
                LiveYYPluginManager.getInstance().loadPlugin(context, str, str2, z, pluginLoadCallback, null);
                return;
            }
            return;
        }
        LiveMediaPluginManager.getInstance().loadPlugin(context, str, str2, pluginLoadCallback);
    }

    public void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        iLiveDiskClearCacheCallback.notifyCompletion(0L);
        ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback2 = new ILiveDiskClearCacheCallback() { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.1
            @Override // com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback
            public void notifyCompletion(long j2) {
            }
        };
        if (isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback2);
            LiveYYPluginManager.getInstance().onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback2);
            return;
        }
        LiveNPSPluginManagerOld.getInstance().onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback2);
    }

    public void startLiveMediaActivity(Context context, String str, String str2, String str3, Uri uri) {
        startLiveMediaActivity(context, str, str2, str3, uri, false);
    }
}
