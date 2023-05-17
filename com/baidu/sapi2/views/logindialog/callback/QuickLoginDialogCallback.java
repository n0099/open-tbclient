package com.baidu.sapi2.views.logindialog.callback;

import android.text.SpannableStringBuilder;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.view.LoadingView;
/* loaded from: classes3.dex */
public abstract class QuickLoginDialogCallback implements IQuickLoginDialogCallback {
    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onDismiss() {
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowAgreement(TextView textView, SpannableStringBuilder spannableStringBuilder) {
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowAgreementWithOperator(TextView textView, String str, SpannableStringBuilder spannableStringBuilder) {
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowDialog(ColorType colorType, LinearLayout linearLayout, TextView textView) {
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowLoading(ColorType colorType, LoadingView loadingView) {
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowLogin(ColorType colorType, QuickLoginType quickLoginType, TextView textView) {
    }
}
