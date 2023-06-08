package com.baidu.tbadk.core.dialog.yun;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.to9;
import com.baidu.tieba.z55;
import com.baidu.tieba.zq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YunDialogDispatcher implements to9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public YunDialogDispatcher() {
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

    @Override // com.baidu.tieba.to9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString("dialogName");
            zq8 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "准备展示通用路由云弹窗：" + optString);
            if (!TextUtils.isEmpty(optString)) {
                z55.p(context, optString, jSONObject);
            }
        }
    }
}
