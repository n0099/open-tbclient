package com.baidu.searchbox.live.service;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.searchbox.live.host2live.publish.ILive2PublishHostInterface;
import com.baidu.searchbox.live.host2live.publish.ILiveMasterActInterface;
import com.baidu.searchbox.live.host2live.publish.ILiveMasterInterfaceCallBack;
import com.baidu.searchbox.live.host2live.video.ILiveActInterface;
import com.baidu.searchbox.live.host2live.video.ILiveToListInvokeAbility;
import com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService;
import com.baidu.searchbox.live.interfaces.entry.ILiveYYMixEntry;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.live.nps.LiveNpsLoadHelper;
import com.baidu.searchbox.live.nps.LiveNpsRuntime;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bR\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$JE\u0010(\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010&2\b\u0010%\u001a\u0004\u0018\u00010\u00022\u0018\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u0004\u0018\u0001012\u0006\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u000206H\u0016¢\u0006\u0004\b9\u00108J\u0017\u0010:\u001a\u0002062\u0006\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b:\u0010;J/\u0010:\u001a\u0002062\u0006\u0010*\u001a\u00020\u00022\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&H\u0016¢\u0006\u0004\b:\u0010=J\u000f\u0010>\u001a\u000206H\u0016¢\u0006\u0004\b>\u00108J!\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\bA\u0010BJ;\u0010F\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u000206H\u0016¢\u0006\u0004\bF\u0010GJC\u0010F\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010E\u001a\u0002062\u0006\u0010H\u001a\u0002062\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bF\u0010IJ[\u0010F\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010E\u001a\u0002062\u0006\u0010H\u001a\u0002062\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bF\u0010JJ1\u0010F\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u000206H\u0016¢\u0006\u0004\bF\u0010KJ\u001f\u0010M\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?2\u0006\u0010L\u001a\u00020\u0002H\u0016¢\u0006\u0004\bM\u0010BJ\u0019\u0010P\u001a\u00020\u00062\b\u0010O\u001a\u0004\u0018\u00010NH\u0016¢\u0006\u0004\bP\u0010Q¨\u0006S"}, d2 = {"Lcom/baidu/searchbox/live/service/PluginInvokeServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "", "source", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "checkAndLoadPluginInsertVideo", "(Ljava/lang/String;Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;)V", "checkAndLoadYYPluginInsertVideo", "Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterInterfaceCallBack;", "checkLiveMasterPluginAndLoad", "(Ljava/lang/String;Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterInterfaceCallBack;)V", "checkPreLoadLiveNpsUpdate", "()V", "", "createYYMixLiveImpl", "()Ljava/lang/Object;", "createYYMixLiveSingletonManagerImpl", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "genFakeActivityImpl", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Landroid/app/Activity;", "activity", "Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "invokeAbility", "Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "getLiveActInterface", "(Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;)Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "Lcom/baidu/searchbox/live/host2live/publish/ILive2PublishHostInterface;", "live2LivePublish", "Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterActInterface;", "getLiveMasterProxyInterfaceImpl", "(Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/publish/ILive2PublishHostInterface;)Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterActInterface;", "", "getLiveNpsPluginWillLoadVersion", "()I", "key", "", "params", "getMediaLivePlayConfig", "(Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;", "pkgName", "Landroid/content/res/AssetManager;", "getPluginAssets", "(Ljava/lang/String;)Landroid/content/res/AssetManager;", "Ljava/lang/ClassLoader;", "getPluginClassLoader", "(Ljava/lang/String;)Ljava/lang/ClassLoader;", "Landroid/content/res/Resources;", "getPluginResource", "(Ljava/lang/String;)Landroid/content/res/Resources;", "getPluginVersionCode", "(Ljava/lang/String;)I", "", "isLiveMasterPluginSupportPublish", "()Z", "isLivePluginSupportInsertVideo", "isPluginLoaded", "(Ljava/lang/String;)Z", "loadParams", "(Ljava/lang/String;Ljava/util/Map;)Z", "isYYLivePluginSupportInsertVideo", "Landroid/content/Context;", "context", "jumpToOuterWebView", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "loadCallback", "needYYLoading", "loadPlugin", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;Z)V", "showYYPage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;Z)V", "url", "realJumpYY", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "stat", "updateStatInfo", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;)V", "<init>", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class PluginInvokeServiceImpl implements PluginInvokeService {
    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void checkAndLoadPluginInsertVideo(String str, IVideoInsertLiveService.LoadResultCallback loadResultCallback) {
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void checkAndLoadYYPluginInsertVideo(String str, IVideoInsertLiveService.LoadResultCallback loadResultCallback) {
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void checkLiveMasterPluginAndLoad(String str, ILiveMasterInterfaceCallBack iLiveMasterInterfaceCallBack) {
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void checkPreLoadLiveNpsUpdate() {
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public ILiveActInterface getLiveActInterface(Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility) {
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public ILiveMasterActInterface getLiveMasterProxyInterfaceImpl(Activity activity, ILive2PublishHostInterface iLive2PublishHostInterface) {
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public boolean isLiveMasterPluginSupportPublish() {
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public boolean isLivePluginSupportInsertVideo() {
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public boolean isYYLivePluginSupportInsertVideo() {
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public Object createYYMixLiveImpl() {
        LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(liveYYPluginManager, "LiveYYPluginManager.getInstance()");
        ILiveYYMixEntry liveYYMixEntry = liveYYPluginManager.getLiveYYMixEntry();
        if (liveYYMixEntry != null) {
            return liveYYMixEntry.createYYMixLiveImpl();
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public Object createYYMixLiveSingletonManagerImpl() {
        LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(liveYYPluginManager, "LiveYYPluginManager.getInstance()");
        ILiveYYMixEntry liveYYMixEntry = liveYYPluginManager.getLiveYYMixEntry();
        if (liveYYMixEntry != null) {
            return liveYYMixEntry.createYYMixLiveSingletonManagerImpl();
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public IMixActivityInterface genFakeActivityImpl() {
        LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(liveNPSPluginManager, "LiveNPSPluginManager.getInstance()");
        return liveNPSPluginManager.getMixActivityImpl();
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public int getLiveNpsPluginWillLoadVersion() {
        return LiveNpsLoadHelper.INSTANCE.getLiveNpsPluginWillLoadVersion();
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public Map<String, Object> getMediaLivePlayConfig(String str, Map<String, ? extends Object> map) {
        return LiveNPSPluginManager.getInstance().getMediaLivePlayConfig(str, map);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public boolean isPluginLoaded(String str, Map<String, String> map) {
        return LiveNPSPluginManager.getInstance().isLoaded(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void jumpToOuterWebView(Context context, String str) {
        LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.getInstance();
        if (str == null) {
            str = "";
        }
        liveNPSPluginManager.dispatchHostEvent(context, "startOuterWebViewActivity", MapsKt__MapsJVMKt.mapOf(new Pair("url", str)));
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void realJumpYY(Context context, String str) {
        LiveNPSPluginManager.getInstance().realStartYYLiveActivity(context, str);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public AssetManager getPluginAssets(String str) {
        return LiveNPSPluginManager.getInstance().getPluginAssets(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public ClassLoader getPluginClassLoader(String str) {
        return LiveNPSPluginManager.getInstance().getPluginClassLoader(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public Resources getPluginResource(String str) {
        return LiveNPSPluginManager.getInstance().getPluginResource(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public int getPluginVersionCode(String str) {
        return LiveNPSPluginManager.getInstance().getPluginInstallVersion(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public boolean isPluginLoaded(String str) {
        return LiveNPSPluginManager.getInstance().isLoaded(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void updateStatInfo(YYStatInfo yYStatInfo) {
        LiveNPSPluginManager.getInstance().updateStatInfo(yYStatInfo);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void loadPlugin(Context context, String str, String str2, PluginLoadCallback pluginLoadCallback, boolean z) {
        LiveNPSPluginManager.getInstance().loadPlugin(context, str, str2, z, null, pluginLoadCallback);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void loadPlugin(Context context, String str, String str2, boolean z, boolean z2, PluginLoadCallback pluginLoadCallback) {
        LiveNPSPluginManager.getInstance().loadPlugin(context, str, str2, z, null, pluginLoadCallback);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void loadPlugin(Context context, String str, String str2, boolean z, boolean z2, Map<String, String> map, PluginLoadCallback pluginLoadCallback) {
        LiveNPSPluginManager.getInstance().loadPlugin(null, str, str2, z, map, pluginLoadCallback);
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void loadPlugin(String str, String str2, PluginLoadCallback pluginLoadCallback, boolean z) {
        LiveNPSPluginManager.getInstance().loadPlugin(LiveNpsRuntime.getApplication(), str, str2, z, null, pluginLoadCallback);
    }
}
