package com.baidu.searchbox.live.service;

import android.content.Context;
import androidx.core.util.Consumer;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u0010J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/service/YYPluginProgressInvokeServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginProgressInvokeService;", "", "pkgName", "", ProgressInfo.JSON_KEY_CURRENT, "total", "", "onPluginDownLoadProgress", "(Ljava/lang/String;JJ)V", "errStr", "onPluginLoadedFailed", "(Ljava/lang/String;Ljava/lang/String;)V", "onPluginLoadedSuccess", "(Ljava/lang/String;)V", "onSubPluginLoadingEnd", "()V", "Landroid/content/Context;", "context", "Landroidx/core/util/Consumer;", "", "onDismiss", "onSubPluginLoadingStart", "(Landroid/content/Context;Landroidx/core/util/Consumer;)V", "eventId", "Lorg/json/JSONObject;", "json", "reportUbcReport", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "<init>", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class YYPluginProgressInvokeServiceImpl implements YYPluginProgressInvokeService {
    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onSubPluginLoadingEnd() {
        LiveYYPluginManager.getInstance().stopLoadingBySubPlugin();
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onPluginDownLoadProgress(String str, long j, long j2) {
        LiveYYPluginManager.getInstance().updatePluginLoadProgress(str, j, j2);
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onPluginLoadedFailed(String str, String str2) {
        LiveYYPluginManager.getInstance().onPluginLoadedState(str, false, str2);
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onSubPluginLoadingStart(Context context, Consumer<Boolean> consumer) {
        LiveYYPluginManager.getInstance().showLoadingBySubPlugin(consumer);
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void reportUbcReport(String str, JSONObject jSONObject) {
        LiveYYPluginManager.getInstance().reportUBCNotify(str, jSONObject);
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onPluginLoadedSuccess(String str) {
        LiveYYPluginManager.getInstance().onPluginLoadedState(str, true, null);
    }
}
