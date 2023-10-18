package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q implements ICommonModuleObj {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q a;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomNotification b;

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new CustomNotification();
    }

    public static q a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (q.class) {
                    if (a == null) {
                        a = new q();
                    }
                }
            }
            return a;
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jSONObject)) == null) {
            if (ICommonModuleObj.KEY_NOTIFICATION.equals(str) && jSONObject != null) {
                Context context = (Context) jSONObject.opt("context");
                int optInt = jSONObject.optInt("version", 0);
                String optString = jSONObject.optString("channelId");
                String optString2 = jSONObject.optString("ticker");
                Bitmap bitmap = (Bitmap) jSONObject.opt("icon");
                String optString3 = jSONObject.optString("title");
                String optString4 = jSONObject.optString("content");
                String optString5 = jSONObject.optString("status");
                boolean optBoolean = jSONObject.optBoolean(RemoteMessageConst.Notification.AUTO_CANCEL);
                int optInt2 = jSONObject.optInt("progress");
                boolean optBoolean2 = jSONObject.optBoolean("indeterminate", false);
                int optInt3 = jSONObject.optInt("smallIcon");
                String optString6 = jSONObject.optString("action");
                PendingIntent pendingIntent = (PendingIntent) jSONObject.opt(BaseGmsClient.KEY_PENDING_INTENT);
                String optString7 = jSONObject.optString("action2");
                PendingIntent pendingIntent2 = (PendingIntent) jSONObject.opt("pendingIntent2");
                if (optInt == 1) {
                    return this.b.getNewNotification(context, optString2, optBoolean, bitmap, optString3, optString4, optInt2, optBoolean2, optString6, pendingIntent, optString7, pendingIntent2);
                }
                return this.b.getCustomNotification(context, optString, optString2, bitmap, optString3, optString4, optString5, optBoolean, optInt2, optInt3, optString6, pendingIntent);
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
