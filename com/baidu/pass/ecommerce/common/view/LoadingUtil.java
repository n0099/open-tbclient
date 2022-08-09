package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LoadingUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Toast mToast;
    public transient /* synthetic */ FieldHolder $fh;

    public LoadingUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void cancel() {
        Toast toast;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (toast = mToast) == null) {
            return;
        }
        toast.cancel();
    }

    public static View createView(Context context, String str) {
        InterceptResult invokeLL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            LayoutInflater from = LayoutInflater.from(context);
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null && (confignation.isDarkMode || confignation.isNightMode)) {
                inflate = from.inflate(R.layout.obfuscated_res_0x7f0d04d9, (ViewGroup) null);
            } else {
                inflate = from.inflate(R.layout.obfuscated_res_0x7f0d04d8, (ViewGroup) null);
            }
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d3c)).setText(str);
            return inflate;
        }
        return (View) invokeLL.objValue;
    }

    public static void show(String str) {
        SapiConfiguration confignation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || (confignation = SapiAccountManager.getInstance().getConfignation()) == null) {
            return;
        }
        Toast toast = mToast;
        if (toast != null) {
            toast.cancel();
        }
        Context context = confignation.getContext();
        Toast toast2 = new Toast(context);
        mToast = toast2;
        toast2.setGravity(17, 0, 0);
        mToast.setDuration(1);
        mToast.setView(createView(context, str));
        mToast.show();
    }
}
