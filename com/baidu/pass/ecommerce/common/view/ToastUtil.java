package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ToastUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NONE_IMG = -1;
    public static Toast mToast;
    public transient /* synthetic */ FieldHolder $fh;

    public ToastUtil() {
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

    public static void createToast(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            Toast toast = new Toast(context);
            mToast = toast;
            toast.setGravity(17, 0, 0);
            mToast.setDuration(0);
        }
    }

    public static View createView(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, context, i2, str)) == null) {
            LayoutInflater from = LayoutInflater.from(context);
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null && (confignation.isDarkMode || confignation.isNightMode)) {
                inflate = from.inflate(R.layout.layout_sapi_sdk_common_night_toast, (ViewGroup) null);
            } else {
                inflate = from.inflate(R.layout.layout_sapi_sdk_common_toast, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.id.sapi_sdk_toast_msg_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.sapi_sdk_toast_msg_tv);
            if (-1 == i2) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(i2);
            }
            textView.setText(str);
            return inflate;
        }
        return (View) invokeLIL.objValue;
    }

    public static void show(String str) {
        SapiConfiguration confignation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || (confignation = SapiAccountManager.getInstance().getConfignation()) == null) {
            return;
        }
        Toast toast = mToast;
        if (toast != null) {
            toast.cancel();
        }
        Context context = confignation.getContext();
        createToast(context);
        mToast.setView(createView(context, -1, str));
        mToast.show();
    }

    public static void show(int i2, String str) {
        SapiConfiguration confignation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, null, i2, str) == null) || (confignation = SapiAccountManager.getInstance().getConfignation()) == null) {
            return;
        }
        Toast toast = mToast;
        if (toast != null) {
            toast.cancel();
        }
        Context context = confignation.getContext();
        createToast(context);
        mToast.setView(createView(context, i2, str));
        mToast.show();
    }
}
