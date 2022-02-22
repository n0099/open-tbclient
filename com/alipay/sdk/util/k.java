package com.alipay.sdk.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Cursor query = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
            if (query != null && query.getCount() > 0) {
                r0 = query.moveToFirst() ? query.getString(query.getColumnIndex("url")) : null;
                query.close();
            }
            return r0;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (EnvUtils.isSandBox()) {
                return com.alipay.sdk.cons.a.f31044b;
            }
            if (context == null) {
                return com.alipay.sdk.cons.a.a;
            }
            String str = com.alipay.sdk.cons.a.a;
            return TextUtils.isEmpty(str) ? com.alipay.sdk.cons.a.a : str;
        }
        return (String) invokeL.objValue;
    }
}
