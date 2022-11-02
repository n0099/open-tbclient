package com.baidu.pass.biometrics.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.sofire.ac.FH;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes2.dex */
public final class PassBioGlobalUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PassBioGlobalUtils() {
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

    public static String getZid(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, str, i)) == null) {
            String gzfi = FH.gzfi(context, str, i);
            if (TextUtils.isEmpty(gzfi)) {
                return "NoZidYet";
            }
            return gzfi;
        }
        return (String) invokeLLI.objValue;
    }

    public static void toastWithText(Context context, CharSequence charSequence, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, context, charSequence, i) == null) {
            toast(context, charSequence, -1, i);
        }
    }

    public static void toast(Context context, CharSequence charSequence, int i, int i2) {
        View inflate;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65538, null, context, charSequence, i, i2) == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            if (TextUtils.isEmpty(charSequence) || (inflate = LayoutInflater.from(context).inflate(R.layout.pass_bio_toast_tips, (ViewGroup) null)) == null || (textView = (TextView) inflate.findViewById(R.id.rim_base_toast_message)) == null) {
                return;
            }
            textView.setText(charSequence);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.rim_base_toast_icon);
            if (imageView != null && i > 0) {
                imageView.setImageResource(i);
                imageView.setVisibility(0);
            }
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(i2);
            toast.setView(inflate);
            toast.show();
        }
    }
}
