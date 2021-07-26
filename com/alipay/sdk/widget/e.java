package com.alipay.sdk.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2060a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1920584097, "Lcom/alipay/sdk/widget/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1920584097, "Lcom/alipay/sdk/widget/e;");
                return;
            }
        }
        f2060a = Build.VERSION.SDK_INT >= 11;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Dialog a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, str3, onClickListener, str4, onClickListener2})) == null) {
            AlertDialog.Builder a2 = a(context, str, str3, onClickListener, str4, onClickListener2);
            a2.setTitle(str);
            a2.setMessage(str2);
            AlertDialog create = a2.create();
            create.setCanceledOnTouchOutside(false);
            create.setOnKeyListener(new f());
            try {
                create.show();
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(com.alipay.sdk.net.a.f1927a, th);
            }
            return create;
        }
        return (Dialog) invokeCommon.objValue;
    }

    public static AlertDialog.Builder a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, onClickListener, str3, onClickListener2})) == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (f2060a) {
                if (!TextUtils.isEmpty(str3) && onClickListener2 != null) {
                    builder.setPositiveButton(str3, onClickListener2);
                }
                if (!TextUtils.isEmpty(str2) && onClickListener != null) {
                    builder.setNegativeButton(str2, onClickListener);
                }
            } else {
                if (!TextUtils.isEmpty(str2) && onClickListener != null) {
                    builder.setPositiveButton(str2, onClickListener);
                }
                if (!TextUtils.isEmpty(str3) && onClickListener2 != null) {
                    builder.setNegativeButton(str3, onClickListener2);
                }
            }
            return builder;
        }
        return (AlertDialog.Builder) invokeCommon.objValue;
    }
}
