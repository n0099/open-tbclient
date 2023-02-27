package com.baidu.android.pushservice.x;

import android.content.Context;
import android.graphics.Bitmap;
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
public class i extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, int i, String str) {
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
        String optString;
        Bitmap a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                optString = new JSONObject(this.b).optString("url");
            } catch (JSONException unused) {
            }
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), (int) R.layout.bd_push_layout_customs_notification_picture);
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
            }
            if (!TextUtils.isEmpty(optString) && (a = com.baidu.android.pushservice.q.a.a().a(optString)) != null) {
                remoteViews.setImageViewBitmap(R.id.bd_push_img_bg, a);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
