package com.baidu.searchbox.live.interfaces.yy.plugin;

import android.content.Context;
import androidx.core.util.Consumer;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginProgressInvokeService;", "Lkotlin/Any;", "", "pkgName", "", ProgressInfo.JSON_KEY_CURRENT, "total", "", "onPluginDownLoadProgress", "(Ljava/lang/String;JJ)V", "errStr", "onPluginLoadedFailed", "(Ljava/lang/String;Ljava/lang/String;)V", "onPluginLoadedSuccess", "(Ljava/lang/String;)V", "onSubPluginLoadingEnd", "()V", "Landroid/content/Context;", "context", "Landroidx/core/util/Consumer;", "", "onDismiss", "onSubPluginLoadingStart", "(Landroid/content/Context;Landroidx/core/util/Consumer;)V", "eventId", "Lorg/json/JSONObject;", "json", "reportUbcReport", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface YYPluginProgressInvokeService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void onPluginDownLoadProgress(String str, long j, long j2);

    void onPluginLoadedFailed(String str, String str2);

    void onPluginLoadedSuccess(String str);

    void onSubPluginLoadingEnd();

    void onSubPluginLoadingStart(Context context, Consumer<Boolean> consumer);

    void reportUbcReport(String str, JSONObject jSONObject);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginProgressInvokeService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "", "SUB_PLUGIN_PROGRESS", "Ljava/lang/String;", "getSUB_PLUGIN_PROGRESS", "()Ljava/lang/String;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.YY.YY_MULTI_PLUGIN_PROGRESS);
        public static final String SUB_PLUGIN_PROGRESS = SUB_PLUGIN_PROGRESS;
        public static final String SUB_PLUGIN_PROGRESS = SUB_PLUGIN_PROGRESS;

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }

        public final String getSUB_PLUGIN_PROGRESS() {
            return SUB_PLUGIN_PROGRESS;
        }
    }
}
