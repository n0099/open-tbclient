package com.baidu.searchbox.yy.gameassist;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/yy/gameassist/GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1", "Lcom/baidu/searchbox/yy/gameassist/PluginLoadCallback;", "", "retCode", "", "retMsg", "", "onFailed", "(ILjava/lang/String;)V", "", "retObject", "loadType", "onResult", "(Ljava/lang/Object;Ljava/lang/String;)V", "lib-gameassist-host_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1 extends PluginLoadCallback {
    public final /* synthetic */ PluginLoadCallback $originCallback;

    public GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1(PluginLoadCallback pluginLoadCallback) {
        this.$originCallback = pluginLoadCallback;
    }

    @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
    public void onFailed(int i, String str) {
        super.onFailed(i, str);
        this.$originCallback.onFailed(i, str);
    }

    @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
    public void onResult(Object obj, String str) {
        YalogKt.yalog(GameAssistNPSPluginManager.TAG, "PluginLoadCallbackWrap, retObj = " + obj + ", loadType = " + str);
        if (obj instanceof IGameAssistPlugin) {
            GameAssistNPSPluginManager gameAssistNPSPluginManager = GameAssistNPSPluginManager.INSTANCE;
            GameAssistNPSPluginManager.pluginImpl = (IGameAssistPlugin) obj;
        }
        this.$originCallback.onResult(obj, str);
    }
}
