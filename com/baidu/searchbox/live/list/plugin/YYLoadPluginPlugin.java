package com.baidu.searchbox.live.list.plugin;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0003R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/YYLoadPluginPlugin;", "", "onCreate", "()V", MissionEvent.MESSAGE_DESTROY, "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/baidu/searchbox/live/component/service/LiveItemModelListService;", "itemModelListService", "Lcom/baidu/searchbox/live/component/service/LiveItemModelListService;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "mPluginLoadCallback", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getMixUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class YYLoadPluginPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public LiveItemModelListService itemModelListService;
    public PluginLoadCallback mPluginLoadCallback;
    public final MiniUniqueId mixUniqueId;

    public YYLoadPluginPlugin(Context context, MiniUniqueId miniUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, miniUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context;
        this.mixUniqueId = miniUniqueId;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.context : (Context) invokeV.objValue;
    }

    public final MiniUniqueId getMixUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mixUniqueId : (MiniUniqueId) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCreate() {
        boolean z;
        LiveContainer.LiveItemModel liveItemModel;
        JSONObject originJson;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
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
                PluginLoadCallback pluginLoadCallback = new PluginLoadCallback(this) { // from class: com.baidu.searchbox.live.list.plugin.YYLoadPluginPlugin$onCreate$3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLoadPluginPlugin this$0;

                    /* JADX DEBUG: Incorrect args count in method signature: ()V */
                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                    public void onResult(boolean z2, int i, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i), str}) == null) {
                            ListLogKt.log("YYLoadPluginPlugin", "LiveEntryManager loadPlugin result: " + z2);
                            if (z2) {
                                MixEventBus mixEventBus2 = MixEventBus.getInstance();
                                YYPluginEvent.LoadYYPluginRes loadYYPluginRes2 = new YYPluginEvent.LoadYYPluginRes(2);
                                loadYYPluginRes2.setUniqueId(this.this$0.getMixUniqueId().getId());
                                mixEventBus2.post(loadYYPluginRes2);
                            }
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

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mPluginLoadCallback = null;
        }
    }
}
