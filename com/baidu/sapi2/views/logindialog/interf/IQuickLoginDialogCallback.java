package com.baidu.sapi2.views.logindialog.interf;

import android.text.SpannableStringBuilder;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.view.LoadingView;
/* loaded from: classes2.dex */
public interface IQuickLoginDialogCallback extends NoProguard {
    void onDismiss();

    void onLoginFailure(QuickLoginResult quickLoginResult);

    void onLoginSuccess(QuickLoginResult quickLoginResult);

    void onPreShowAgreement(TextView textView, SpannableStringBuilder spannableStringBuilder);

    void onPreShowAgreementWithOperator(TextView textView, String str, SpannableStringBuilder spannableStringBuilder);

    void onPreShowDialog(ColorType colorType, LinearLayout linearLayout, TextView textView);

    void onPreShowLoading(ColorType colorType, LoadingView loadingView);

    void onPreShowLogin(ColorType colorType, QuickLoginType quickLoginType, TextView textView);
}
