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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public Bitmap q;
    public String r;
    public String s;
    public String t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, int i, String str) {
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
        this.j = false;
        this.k = false;
        this.o = "";
        this.p = "";
        this.r = "";
        this.s = "";
        this.t = "";
    }

    public final void a(RemoteViews remoteViews) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, remoteViews) == null) {
            if (!TextUtils.isEmpty(this.d)) {
                remoteViews.setViewVisibility(R.id.bd_push_txv_content_title, 0);
                remoteViews.setTextViewText(R.id.bd_push_txv_content_title, this.d);
                remoteViews.setTextColor(R.id.bd_push_txv_content_title, this.h);
            }
            if (this.q != null) {
                float applyDimension = TypedValue.applyDimension(1, 59.0f, this.a.getResources().getDisplayMetrics());
                Bitmap a = Utility.a(Utility.a(this.q, applyDimension, applyDimension), (int) (TypedValue.applyDimension(1, 10.0f, this.a.getResources().getDisplayMetrics()) - 5.0f), 1);
                this.q = a;
                remoteViews.setImageViewBitmap(R.id.bd_push_img_goods, a);
            }
            remoteViews.setTextViewText(R.id.bd_push_txv_goods_desc, this.t);
            if (!TextUtils.isEmpty(this.r)) {
                remoteViews.setViewVisibility(R.id.bd_push_txv_goods_price1, 0);
                remoteViews.setTextViewText(R.id.bd_push_txv_goods_price1, this.r);
            }
            if (TextUtils.isEmpty(this.s)) {
                return;
            }
            remoteViews.setViewVisibility(R.id.bd_push_lyt_goods_price2, 0);
            remoteViews.setTextViewText(R.id.bd_push_txv_goods_price2, this.s);
        }
    }

    public final void a(RemoteViews remoteViews, int i, int i2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{remoteViews, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (!TextUtils.isEmpty(this.n)) {
                remoteViews.setImageViewBitmap(i, Utility.a(Utility.a(-1, (int) TypedValue.applyDimension(1, 17.5f, this.a.getResources().getDisplayMetrics()), -1, "", this.n), (int) TypedValue.applyDimension(1, f, this.a.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, f2, this.a.getResources().getDisplayMetrics())));
            }
            if (TextUtils.isEmpty(this.m)) {
                return;
            }
            remoteViews.setTextColor(i2, Color.parseColor(this.m));
        }
    }

    public final void b(RemoteViews remoteViews) {
        Bitmap a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, remoteViews) == null) {
            if (!TextUtils.isEmpty(this.p) && (a = com.baidu.android.pushservice.q.a.a().a(this.p)) != null) {
                remoteViews.setViewVisibility(R.id.bd_push_img_bg, 0);
                remoteViews.setImageViewBitmap(R.id.bd_push_img_bg, a);
            } else if (TextUtils.isEmpty(this.o)) {
            } else {
                remoteViews.setInt(R.id.bd_push_container, "setBackgroundColor", Color.parseColor(this.o));
            }
        }
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews c() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                jSONObject = new JSONObject(this.b);
                optJSONObject = jSONObject.optJSONObject("goods");
            } catch (JSONException unused) {
            }
            if (optJSONObject == null) {
                return null;
            }
            this.t = optJSONObject.optString("title");
            String optString = optJSONObject.optString("img");
            if (!TextUtils.isEmpty(this.t) && !TextUtils.isEmpty(optString)) {
                this.r = optJSONObject.optString("sales_price");
                this.s = optJSONObject.optString("price");
                JSONArray optJSONArray = jSONObject.optJSONArray("button_list");
                JSONObject optJSONObject2 = jSONObject.optJSONObject(NotificationCompat.WearableExtender.KEY_BACKGROUND);
                if (optJSONObject2 != null) {
                    this.o = optJSONObject2.optString("color");
                    this.p = optJSONObject2.optString("url");
                }
                RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), (int) R.layout.bd_push_layout_customs_notification_goods_card);
                c(remoteViews);
                this.q = com.baidu.android.pushservice.q.a.a().a(optString);
                a(remoteViews);
                if (optJSONArray != null) {
                    try {
                        if (optJSONArray.length() > 0 && (jSONObject2 = optJSONArray.getJSONObject(0)) != null) {
                            JSONObject optJSONObject3 = jSONObject2.optJSONObject("title");
                            this.n = jSONObject2.optString("background_color", "");
                            if (optJSONObject3 != null) {
                                String optString2 = optJSONObject3.optString("txt");
                                this.l = optString2;
                                if (!TextUtils.isEmpty(optString2)) {
                                    this.k = true;
                                    remoteViews.setViewVisibility(R.id.bd_push_lyt_btn_bottom, 0);
                                    remoteViews.setTextViewText(R.id.bd_push_txv_btn_bottom_text, this.l);
                                    this.m = optJSONObject3.optString("color");
                                    a(remoteViews, R.id.bd_push_img_btn_bottom_bg, R.id.bd_push_txv_btn_bottom_text, 306.0f, 35.0f);
                                }
                            }
                        }
                    } catch (JSONException unused2) {
                    }
                }
                this.j = true;
                return remoteViews;
            }
            return null;
        }
        return (RemoteViews) invokeV.objValue;
    }

    public final void c(RemoteViews remoteViews) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, remoteViews) == null) {
            if (a()) {
                remoteViews.setViewVisibility(R.id.bd_push_lyt_head, 0);
                String q = Utility.q(this.a);
                if (!TextUtils.isEmpty(this.f)) {
                    q = q + "•" + this.f;
                }
                remoteViews.setTextViewText(R.id.bd_push_txv_app_name, q);
                remoteViews.setImageViewBitmap(R.id.bd_push_img_icon, Utility.o(this.a));
                int i = this.h;
                if (i != Integer.MIN_VALUE) {
                    remoteViews.setTextColor(R.id.bd_push_txv_app_name, i);
                }
                b(remoteViews);
            }
            if (g()) {
                return;
            }
            remoteViews.setViewPadding(R.id.bd_push_container_shape, 0, 0, 0, 0);
        }
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.j) {
                RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), (int) R.layout.bd_push_layout_customs_notification_goods_card);
                c(remoteViews);
                a(remoteViews);
                if (this.k) {
                    remoteViews.setViewVisibility(R.id.bd_push_lyt_btn_right, 0);
                    remoteViews.setTextViewText(R.id.bd_push_btn_right, this.l);
                    a(remoteViews, R.id.bd_push_img_btn_right_bg, R.id.bd_push_btn_right, 60.0f, 25.0f);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
