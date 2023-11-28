package com.baidu.android.pushservice.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-676453134, "Lcom/baidu/android/pushservice/x/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-676453134, "Lcom/baidu/android/pushservice/x/b;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i, String str) {
        super(context, i, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
    }

    public final RemoteViews a(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            RemoteViews remoteViews = new RemoteViews(this.c, i);
            if (a()) {
                if (TextUtils.isEmpty(this.f)) {
                    str = Utility.q(this.a);
                } else {
                    str = Utility.q(this.a) + "•" + this.f;
                }
                remoteViews.setTextViewText(R.id.bd_push_txv_app_name, str);
                int i2 = this.h;
                if (i2 != Integer.MIN_VALUE) {
                    remoteViews.setTextColor(R.id.bd_push_txv_app_name, i2);
                }
                remoteViews.setImageViewBitmap(R.id.bd_push_img_icon, Utility.o(this.a));
                if (!TextUtils.isEmpty(this.m)) {
                    remoteViews.setImageViewBitmap(R.id.bd_push_iv_bg, com.baidu.android.pushservice.q.a.a().a(this.m));
                } else if (!TextUtils.isEmpty(this.n)) {
                    remoteViews.setInt(R.id.bd_push_iv_bg, "setBackgroundColor", Color.parseColor(this.n));
                }
            } else {
                remoteViews.setViewVisibility(R.id.bd_push_lyt_notification_custom_head, 8);
            }
            if (!g()) {
                remoteViews.setViewPadding(R.id.bd_push_container, 0, 0, 0, 0);
            }
            if (TextUtils.isEmpty(this.d)) {
                remoteViews.setViewVisibility(R.id.bd_push_tv_title, 8);
            } else {
                remoteViews.setTextViewText(R.id.bd_push_tv_title, this.d);
                remoteViews.setTextColor(R.id.bd_push_tv_title, this.h);
            }
            if (TextUtils.isEmpty(this.e)) {
                remoteViews.setViewVisibility(R.id.bd_push_tv_content, 8);
            } else {
                remoteViews.setTextViewText(R.id.bd_push_tv_content, this.e);
                remoteViews.setTextColor(R.id.bd_push_tv_content, this.i);
            }
            if (!TextUtils.isEmpty(this.l)) {
                Bitmap a = com.baidu.android.pushservice.q.a.a().a(this.l);
                if (a != null) {
                    remoteViews.setImageViewBitmap(R.id.bd_push_iv_big_image, Utility.a(Utility.a(a, TypedValue.applyDimension(1, 306.0f, this.a.getResources().getDisplayMetrics()), TypedValue.applyDimension(1, 144.0f, this.a.getResources().getDisplayMetrics())), (int) TypedValue.applyDimension(1, 10.0f, this.a.getResources().getDisplayMetrics()), 0));
                } else {
                    remoteViews.setViewVisibility(R.id.bd_push_iv_big_image, 8);
                }
            }
            return remoteViews;
        }
        return (RemoteViews) invokeI.objValue;
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i();
            return a(R.layout.bd_push_notification_big_image);
        }
        return (RemoteViews) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a(R.layout.bd_push_notification_big_image_heads_up) : (RemoteViews) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.x.g
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || TextUtils.isEmpty(this.b)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            if (jSONObject.has("title") && a()) {
                String optString = jSONObject.getJSONObject("title").optString("color");
                this.j = optString;
                this.h = Color.parseColor(optString);
            }
            if (jSONObject.has("description") && a()) {
                String optString2 = jSONObject.getJSONObject("description").optString("color");
                this.k = optString2;
                this.i = Color.parseColor(optString2);
            }
            if (jSONObject.has(NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(NotificationCompat.WearableExtender.KEY_BACKGROUND);
                this.n = jSONObject2.optString("color");
                this.m = jSONObject2.optString("url");
            }
            this.l = jSONObject.optString("big_img");
        } catch (Exception unused) {
        }
    }
}
