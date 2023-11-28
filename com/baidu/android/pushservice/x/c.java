package com.baidu.android.pushservice.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
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
public class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, int i, String str) {
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
    public RemoteViews c() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        String str;
        String str2;
        String str3;
        int i;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Bitmap a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.b);
                JSONArray optJSONArray = jSONObject2.optJSONArray("button_list");
                JSONObject optJSONObject3 = jSONObject2.optJSONObject("transaction");
                String str4 = "";
                if (optJSONObject3 != null) {
                    str = optJSONObject3.optString("title");
                    str2 = optJSONObject3.optString("desc");
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && optJSONArray != null && optJSONArray.length() != 0) {
                        jSONArray = optJSONObject3.optJSONArray("detail_list");
                    }
                    return null;
                }
                jSONArray = null;
                str = "";
                str2 = str;
                JSONObject optJSONObject4 = jSONObject2.optJSONObject(NotificationCompat.WearableExtender.KEY_BACKGROUND);
                if (optJSONObject4 != null) {
                    String optString = optJSONObject4.optString("color");
                    str4 = optJSONObject4.optString("url");
                    str3 = optString;
                } else {
                    str3 = "";
                }
                RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), (int) R.layout.bd_push_layout_customs_notification_pay_card);
                if (a()) {
                    remoteViews.setViewVisibility(R.id.bd_push_lyt_head, 0);
                    String q = Utility.q(this.a);
                    if (!TextUtils.isEmpty(this.f)) {
                        q = q + "•" + this.f;
                    }
                    remoteViews.setTextViewText(R.id.bd_push_txv_app_name, q);
                    remoteViews.setImageViewBitmap(R.id.bd_push_img_icon, Utility.o(this.a));
                    int i2 = this.h;
                    if (i2 != Integer.MIN_VALUE) {
                        remoteViews.setTextColor(R.id.bd_push_txv_app_name, i2);
                    }
                    if (!TextUtils.isEmpty(str4) && (a = com.baidu.android.pushservice.q.a.a().a(str4)) != null) {
                        remoteViews.setViewVisibility(R.id.bd_push_img_bg, 0);
                        remoteViews.setImageViewBitmap(R.id.bd_push_img_bg, a);
                    } else if (!TextUtils.isEmpty(str3)) {
                        remoteViews.setInt(R.id.bd_push_container, "setBackgroundColor", Color.parseColor(str3));
                    }
                }
                if (g()) {
                    i = 0;
                } else {
                    i = 0;
                    remoteViews.setViewPadding(R.id.bd_push_container_shape, 0, 0, 0, 0);
                }
                remoteViews.setTextViewText(R.id.bd_push_txt_title_name, str);
                remoteViews.setTextViewText(R.id.bd_push_txv_title_value, str2);
                if (jSONArray != null) {
                    try {
                        if (jSONArray.length() > 0) {
                            remoteViews.setViewVisibility(R.id.bd_push_lyt_detail1, i);
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                            remoteViews.setTextViewText(R.id.bd_push_txv_detail1_name, jSONObject3.optString("key"));
                            remoteViews.setTextViewText(R.id.bd_push_txv_detail1_value, jSONObject3.optString("value"));
                            if (jSONArray.length() >= 2) {
                                remoteViews.setViewVisibility(R.id.bd_push_lyt_detail2, i);
                                JSONObject jSONObject4 = jSONArray.getJSONObject(1);
                                remoteViews.setTextViewText(R.id.bd_push_txv_detail2_name, jSONObject4.optString("key"));
                                remoteViews.setTextViewText(R.id.bd_push_txv_detail2_value, jSONObject4.optString("value"));
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
                JSONObject jSONObject5 = optJSONArray.getJSONObject(i);
                if (jSONObject5 != null && (optJSONObject2 = jSONObject5.optJSONObject("title")) != null) {
                    String optString2 = optJSONObject2.optString("txt");
                    if (!TextUtils.isEmpty(optString2)) {
                        remoteViews.setViewVisibility(R.id.bd_push_lyt_button, i);
                        remoteViews.setViewVisibility(R.id.bd_push_btn_start, i);
                        remoteViews.setTextViewText(R.id.bd_push_btn_start, optString2);
                    }
                }
                if (optJSONArray.length() >= 2 && (jSONObject = optJSONArray.getJSONObject(1)) != null && (optJSONObject = jSONObject.optJSONObject("title")) != null) {
                    String optString3 = optJSONObject.optString("txt");
                    if (!TextUtils.isEmpty(optString3)) {
                        remoteViews.setViewVisibility(R.id.bd_push_btn_end, i);
                        remoteViews.setTextViewText(R.id.bd_push_btn_end, optString3);
                    }
                }
                return remoteViews;
            } catch (JSONException unused2) {
                return null;
            }
        }
        return (RemoteViews) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.x.g
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
