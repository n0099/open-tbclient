package com.baidu.sapi2.views.logindialog.callback;

import android.text.SpannableStringBuilder;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.view.LoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class QuickLoginDialogCallback implements IQuickLoginDialogCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public QuickLoginDialogCallback() {
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

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowAgreement(TextView textView, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, spannableStringBuilder) == null) {
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowAgreementWithOperator(TextView textView, String str, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, str, spannableStringBuilder) == null) {
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowDialog(ColorType colorType, LinearLayout linearLayout, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, colorType, linearLayout, textView) == null) {
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowLoading(ColorType colorType, LoadingView loadingView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, colorType, loadingView) == null) {
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowLogin(ColorType colorType, QuickLoginType quickLoginType, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, colorType, quickLoginType, textView) == null) {
        }
    }
}
