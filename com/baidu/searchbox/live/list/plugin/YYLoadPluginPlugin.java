package com.baidu.searchbox.live.list.plugin;

import android.content.Context;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.searchbox.live.action.YYPluginEvent;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.component.service.LiveItemModelListService;
import com.baidu.searchbox.live.eventbus.MixEventBus;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0003R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/YYLoadPluginPlugin;", "", "onCreate", "()V", MissionEvent.MESSAGE_DESTROY, "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/baidu/searchbox/live/component/service/LiveItemModelListService;", "itemModelListService", "Lcom/baidu/searchbox/live/component/service/LiveItemModelListService;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "mPluginLoadCallback", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getMixUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class YYLoadPluginPlugin {
    public final Context context;
    public LiveItemModelListService itemModelListService;
    public PluginLoadCallback mPluginLoadCallback;
    public final MiniUniqueId mixUniqueId;

    public YYLoadPluginPlugin(Context context, MiniUniqueId miniUniqueId) {
        this.context = context;
        this.mixUniqueId = miniUniqueId;
    }

    public final Context getContext() {
        return this.context;
    }

    public final MiniUniqueId getMixUniqueId() {
        return this.mixUniqueId;
    }

    public final void onDestroy() {
        this.mPluginLoadCallback = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCreate() {
        boolean z;
        LiveContainer.LiveItemModel liveItemModel;
        JSONObject originJson;
        LiveItemModelListService liveItemModelListService = (LiveItemModelListService) ServiceLocator.Companion.getGlobalService(LiveItemModelListService.class);
        this.itemModelListService = liveItemModelListService;
        if (liveItemModelListService != null) {
            List<LiveContainer.LiveItemModel> liveItemModels = liveItemModelListService.getLiveItemModels();
            if ((!liveItemModels.isEmpty()) && liveItemModelListService.getCurrentPosition() == 0 && (liveItemModel = liveItemModels.get(0)) != null && (originJson = liveItemModel.getOriginJson()) != null && originJson.optInt("isMix") == 1) {
                z = true;
                if (!z) {
                    NpsLoadChainLog.getInstance().initAndStart();
                    NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(npsLoadChainLog, "NpsLoadChainLog.getInstance()");
                    npsLoadChainLog.setEntry("YY-SwipeMixLiveEntry");
                    NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(npsLoadChainLog2, "NpsLoadChainLog.getInstance()");
                    PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
                    npsLoadChainLog2.setPluginVersion((pluginMgrService == null || (r3 = String.valueOf(pluginMgrService.getPluginVersionCode("com.baidu.searchbox.yylive.entrance"))) == null) ? "" : "");
                }
                if (!MiniPluginManager.INSTANCE.isYYPluginAvailable()) {
                    ListLogKt.log("YYLoadPluginPlugin", "not need load plugin");
                    MixEventBus mixEventBus = MixEventBus.getInstance();
                    YYPluginEvent.LoadYYPluginRes loadYYPluginRes = new YYPluginEvent.LoadYYPluginRes(1);
                    loadYYPluginRes.setUniqueId(this.mixUniqueId.getId());
                    mixEventBus.post(loadYYPluginRes);
                    return;
                }
                ListLogKt.log("YYLoadPluginPlugin", "need load plugin");
                PluginLoadCallback pluginLoadCallback = new PluginLoadCallback() { // from class: com.baidu.searchbox.live.list.plugin.YYLoadPluginPlugin$onCreate$3
                    @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                    public void onResult(boolean z2, int i, String str) {
                        ListLogKt.log("YYLoadPluginPlugin", "LiveEntryManager loadPlugin result: " + z2);
                        if (z2) {
                            MixEventBus mixEventBus2 = MixEventBus.getInstance();
                            YYPluginEvent.LoadYYPluginRes loadYYPluginRes2 = new YYPluginEvent.LoadYYPluginRes(2);
                            loadYYPluginRes2.setUniqueId(YYLoadPluginPlugin.this.getMixUniqueId().getId());
                            mixEventBus2.post(loadYYPluginRes2);
                        }
                    }
                };
                this.mPluginLoadCallback = pluginLoadCallback;
                if (pluginLoadCallback != null) {
                    MiniPluginManager.INSTANCE.loadYYPlugin(pluginLoadCallback, false, true);
                    return;
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
        if (!MiniPluginManager.INSTANCE.isYYPluginAvailable()) {
        }
    }
}
