package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FoundationFacadeUtils implements ICommonModuleObj {
    public static /* synthetic */ Interceptable $ic;
    public static volatile FoundationFacadeUtils sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomNotification mNotification;

    public FoundationFacadeUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNotification = new CustomNotification();
    }

    public static FoundationFacadeUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (FoundationFacadeUtils.class) {
                    if (sInstance == null) {
                        sInstance = new FoundationFacadeUtils();
                    }
                }
            }
            return sInstance;
        }
        return (FoundationFacadeUtils) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jSONObject)) == null) {
            if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str) || jSONObject == null) {
                return null;
            }
            return this.mNotification.getCustomNotification((Context) jSONObject.opt("context"), jSONObject.optString(AppConfigImp.KEY_CHANNELID), jSONObject.optString(ALaKeepAliveService.KEY_TICKER), (Bitmap) jSONObject.opt("icon"), jSONObject.optString("title"), jSONObject.optString("content"), jSONObject.optString("status"), jSONObject.optBoolean("autoCancel"), jSONObject.optInt("progress"), jSONObject.optInt("smallIcon"), jSONObject.optString("action"), (PendingIntent) jSONObject.opt("pendingIntent"));
        }
        return invokeLL.objValue;
    }
}
