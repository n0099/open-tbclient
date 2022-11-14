package com.baidu.searchbox.live.service;

import android.content.Context;
import androidx.core.util.Consumer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u0010J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/service/YYPluginProgressInvokeServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginProgressInvokeService;", "", "pkgName", "", ProgressInfo.JSON_KEY_CURRENT, "total", "", "onPluginDownLoadProgress", "(Ljava/lang/String;JJ)V", "errStr", "onPluginLoadedFailed", "(Ljava/lang/String;Ljava/lang/String;)V", "onPluginLoadedSuccess", "(Ljava/lang/String;)V", "onSubPluginLoadingEnd", "()V", "Landroid/content/Context;", "context", "Landroidx/core/util/Consumer;", "", "onDismiss", "onSubPluginLoadingStart", "(Landroid/content/Context;Landroidx/core/util/Consumer;)V", TbEnum.SystemMessage.KEY_EVENT_ID, "Lorg/json/JSONObject;", "json", "reportUbcReport", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "<init>", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class YYPluginProgressInvokeServiceImpl implements YYPluginProgressInvokeService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public YYPluginProgressInvokeServiceImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onSubPluginLoadingEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LiveYYPluginManager.getInstance().stopLoadingBySubPlugin();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onPluginDownLoadProgress(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            LiveYYPluginManager.getInstance().updatePluginLoadProgress(str, j, j2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onPluginLoadedFailed(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            LiveYYPluginManager.getInstance().onPluginLoadedState(str, false, str2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onSubPluginLoadingStart(Context context, Consumer<Boolean> consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, consumer) == null) {
            LiveYYPluginManager.getInstance().showLoadingBySubPlugin(consumer);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void reportUbcReport(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, jSONObject) == null) {
            LiveYYPluginManager.getInstance().reportUBCNotify(str, jSONObject);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService
    public void onPluginLoadedSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            LiveYYPluginManager.getInstance().onPluginLoadedState(str, true, null);
        }
    }
}
