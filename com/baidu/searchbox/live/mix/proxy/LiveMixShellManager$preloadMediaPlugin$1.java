package com.baidu.searchbox.live.mix.proxy;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/live/mix/proxy/LiveMixShellManager$preloadMediaPlugin$1", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "", "isSucc", "", "retCode", "", "retMsg", "", "onResult", "(ZILjava/lang/String;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class LiveMixShellManager$preloadMediaPlugin$1 implements PluginLoadCallback {
    @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
    public void onResult(boolean z, int i, String str) {
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.dLog("LiveMixShellManager preloadMediaPlugin result " + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
    }
}
