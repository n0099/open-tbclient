package com.baidu.android.pushservice.x;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, int i, String str) {
        super(context, i, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.pushservice.x.g
    public String b() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!Utility.N(this.a) || (i = Build.VERSION.SDK_INT) < 26 || i > 29) {
                return super.b();
            }
            com.baidu.android.pushservice.a0.h.a(this.a, "com.baidu.android.pushservice.push.importance_low", "云推送静默", 1);
            return "com.baidu.android.pushservice.push.importance_low";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str2 = "";
            int i = (Utility.S(this.a) || (Utility.M(this.a) && Build.VERSION.SDK_INT <= 30)) ? R.layout.bd_push_notification_red_env_style_vivo : R.layout.bd_push_notification_red_env_style;
            try {
                JSONObject jSONObject = new JSONObject(this.b);
                str = jSONObject.optString("title");
                try {
                    str2 = jSONObject.optString("appname");
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = this.a.getResources().getString(R.string.bd_push_red_envelope);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = Utility.q(this.a);
            }
            if (Utility.R(this.a)) {
                RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), i);
                remoteViews.setTextViewText(R.id.bd_push_title, str);
                remoteViews.setTextViewText(R.id.bd_push_tv_app_name, str2);
                if (Utility.S(this.a)) {
                    remoteViews.setImageViewBitmap(R.id.bd_push_iv_bg, Utility.a(100, 100, "#FF9C34"));
                }
                return remoteViews;
            }
            return null;
        }
        return (RemoteViews) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.x.g
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Utility.F(this.a) : invokeV.booleanValue;
    }
}
