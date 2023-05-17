package com.baidu.searchbox.account.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.result.BoxOneKeyLoginResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AccountLoginAgreeConfig {
    public boolean isFirstOneKeyLogin;
    public Spannable mAgreementText;
    public String mButtonText;
    public String mLoginScene;
    public String mTitle;

    /* loaded from: classes3.dex */
    public static class Builder {
        public boolean isFirstOneKeyLogin;
        public Spannable mAgreementText;
        public String mButtonText;
        public String mLoginScene;
        public String mTitle;

        public AccountLoginAgreeConfig build() {
            return new AccountLoginAgreeConfig(this);
        }

        public Builder setAgreementText(Spannable spannable) {
            this.mAgreementText = spannable;
            return this;
        }

        public Builder setButtonText(String str) {
            this.mButtonText = str;
            return this;
        }

        public Builder setFirstOneKeyLogin(boolean z) {
            this.isFirstOneKeyLogin = z;
            return this;
        }

        public Builder setLoginScene(String str) {
            this.mLoginScene = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }
    }

    public AccountLoginAgreeConfig(Builder builder) {
        this.mTitle = builder.mTitle;
        this.mAgreementText = builder.mAgreementText;
        this.mButtonText = builder.mButtonText;
        this.isFirstOneKeyLogin = builder.isFirstOneKeyLogin;
        this.mLoginScene = builder.mLoginScene;
    }

    public static Spannable generateAccountDialogAgreement1(Context context, BoxOneKeyLoginResult boxOneKeyLoginResult) {
        if (boxOneKeyLoginResult != null) {
            Resources resources = context.getResources();
            return (Spannable) Html.fromHtml(resources.getString(R.string.obfuscated_res_0x7f0f0084, AccountConstants.easyBrowserScheme + boxOneKeyLoginResult.getAgreeUrl(), boxOneKeyLoginResult.getAgreeText(), AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.PASS_ACCOUNT_AGREE, AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.BAIDU_PRIVACY));
        }
        return generateAccountDialogAgreement3(context);
    }

    public static Spannable generateAccountDialogAgreement2(Context context, BoxOneKeyLoginResult boxOneKeyLoginResult) {
        if (boxOneKeyLoginResult != null) {
            Resources resources = context.getResources();
            return (Spannable) Html.fromHtml(resources.getString(R.string.obfuscated_res_0x7f0f0085, AccountConstants.easyBrowserScheme + boxOneKeyLoginResult.getAgreeUrl(), boxOneKeyLoginResult.getAgreeText(), AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.PASS_ACCOUNT_AGREE, AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.BAIDU_PRIVACY));
        }
        return generateAccountDialogAgreement3(context);
    }

    public static Spannable generateAccountDialogAgreement3(Context context) {
        Resources resources = context.getResources();
        return (Spannable) Html.fromHtml(resources.getString(R.string.obfuscated_res_0x7f0f0086, AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.PASS_ACCOUNT_AGREE, AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.BAIDU_PRIVACY));
    }

    public static Builder getDefaulgBuilder() {
        return new Builder().setTitle(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0089)).setAgreementText(generateAccountDialogAgreement3(AppRuntime.getAppContext())).setButtonText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0087)).setFirstOneKeyLogin(false);
    }

    public Spannable getAgreementText() {
        return this.mAgreementText;
    }

    public String getButtonText() {
        return this.mButtonText;
    }

    public String getLoginScene() {
        return this.mLoginScene;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isFirstOneKeyLogin() {
        return this.isFirstOneKeyLogin;
    }
}
