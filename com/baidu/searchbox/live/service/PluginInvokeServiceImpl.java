package com.baidu.searchbox.live.service;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.searchbox.live.interfaces.entry.ILiveYYMixEntry;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.live.nps.LiveNpsLoadHelper;
import com.baidu.searchbox.live.nps.LiveNpsRuntime;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJE\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010#J/\u0010\"\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u000f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\"\u0010%J!\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b(\u0010)J;\u0010.\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020!H\u0016¢\u0006\u0004\b.\u0010/JC\u0010.\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020!2\u0006\u00100\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b.\u00101J[\u0010.\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020!2\u0006\u00100\u001a\u00020!2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00112\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b.\u00102J1\u0010.\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020!H\u0016¢\u0006\u0004\b.\u00103J\u001f\u00105\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u00104\u001a\u00020\u000fH\u0016¢\u0006\u0004\b5\u0010)J\u0019\u00108\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/live/service/PluginInvokeServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "", "checkPreLoadLiveNpsUpdate", "()V", "", "createYYMixLiveImpl", "()Ljava/lang/Object;", "createYYMixLiveSingletonManagerImpl", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "genFakeActivityImpl", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "", "getLiveNpsPluginWillLoadVersion", "()I", "", "key", "", "params", "getMediaLivePlayConfig", "(Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;", "pkgName", "Landroid/content/res/AssetManager;", "getPluginAssets", "(Ljava/lang/String;)Landroid/content/res/AssetManager;", "Ljava/lang/ClassLoader;", "getPluginClassLoader", "(Ljava/lang/String;)Ljava/lang/ClassLoader;", "Landroid/content/res/Resources;", "getPluginResource", "(Ljava/lang/String;)Landroid/content/res/Resources;", "getPluginVersionCode", "(Ljava/lang/String;)I", "", "isPluginLoaded", "(Ljava/lang/String;)Z", "loadParams", "(Ljava/lang/String;Ljava/util/Map;)Z", "Landroid/content/Context;", "context", "jumpToOuterWebView", "(Landroid/content/Context;Ljava/lang/String;)V", "source", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "loadCallback", "needYYLoading", "loadPlugin", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;Z)V", "showYYPage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;Z)V", "url", "realJumpYY", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "stat", "updateStatInfo", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;)V", "<init>", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PluginInvokeServiceImpl implements PluginInvokeService {
    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void checkPreLoadLiveNpsUpdate() {
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
