package com.baidu.searchbox.account.component;

import android.graphics.drawable.Drawable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AccountOperationConfig {
    public Drawable mCommonBtnBackgroud;
    public String mCommonBtnText;
    public int mInfoTextColor;
    public int mInfoTextNightColor;
    public boolean mIsSupportGuest;
    public int mLoginBtnTextColor;
    public int mLoginBtnTextNightColor;
    public String mLoginSrc;
    public Drawable mOneKeyBtnBackgroud;
    public String mOneKeyBtnText;
    public int mOtherBtnTextColor;
    public int mOtherBtnTextNightColor;

    /* loaded from: classes3.dex */
    public static class Builder {
        public Drawable mCommonBtnBackgroud;
        public String mCommonBtnText;
        public int mInfoTextColor;
        public int mInfoTextNightColor;
        public boolean mIsSupportGuest;
        public int mLoginBtnTextColor;
        public int mLoginBtnTextNightColor;
        public String mLoginSrc;
        public Drawable mOneKeyBtnBackgroud;
        public String mOneKeyBtnText;
        public int mOtherBtnTextColor;
        public int mOtherBtnTextNightColor;

        public AccountOperationConfig build() {
            return new AccountOperationConfig(this);
        }

        public Builder setCommonBtnBackgroud(Drawable drawable) {
            this.mCommonBtnBackgroud = drawable;
            return this;
        }

        public Builder setCommonBtnText(String str) {
            this.mCommonBtnText = str;
            return this;
        }

        public Builder setLoginSrc(String str) {
            this.mLoginSrc = str;
            return this;
        }

        public Builder setOneKeyBtnBackgroud(Drawable drawable) {
            this.mOneKeyBtnBackgroud = drawable;
            return this;
        }

        public Builder setOneKeyBtnText(String str) {
            this.mOneKeyBtnText = str;
            return this;
        }

        public Builder setSupportGuest(boolean z) {
            this.mIsSupportGuest = z;
            return this;
        }

        public Builder setInfoTextColor(int i, int i2) {
            this.mInfoTextColor = i;
            this.mInfoTextNightColor = i2;
            return this;
        }

        public Builder setLoginBtnTextColor(int i, int i2) {
            this.mLoginBtnTextColor = i;
            this.mLoginBtnTextNightColor = i2;
            return this;
        }

        public Builder setOtherLoginBtnTextColor(int i, int i2) {
            this.mOtherBtnTextColor = i;
            this.mOtherBtnTextNightColor = i2;
            return this;
        }
    }

    public AccountOperationConfig(Builder builder) {
        this.mInfoTextColor = builder.mInfoTextColor;
        this.mInfoTextNightColor = builder.mInfoTextNightColor;
        this.mLoginBtnTextColor = builder.mLoginBtnTextColor;
        this.mLoginBtnTextNightColor = builder.mLoginBtnTextNightColor;
        this.mOtherBtnTextColor = builder.mOtherBtnTextColor;
        this.mOtherBtnTextNightColor = builder.mOtherBtnTextNightColor;
        this.mOneKeyBtnBackgroud = builder.mOneKeyBtnBackgroud;
        this.mCommonBtnBackgroud = builder.mCommonBtnBackgroud;
        this.mCommonBtnText = builder.mCommonBtnText;
        this.mOneKeyBtnText = builder.mOneKeyBtnText;
        this.mLoginSrc = builder.mLoginSrc;
        this.mIsSupportGuest = builder.mIsSupportGuest;
    }

    public static Builder getDefaultBuilder() {
        try {
            return new Builder().setInfoTextColor(-16777216, -16777216).setLoginBtnTextColor(-16777216, -16777216).setOtherLoginBtnTextColor(-16777216, -16777216).setOneKeyBtnText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0079)).setCommonBtnText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0076)).setOneKeyBtnBackgroud(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800bc)).setCommonBtnBackgroud(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800bc)).setLoginSrc(AccountConstants.LOGIN_TYPE_NATIVE_SRC_HOMEPAGE).setSupportGuest(false);
        } catch (Throwable unused) {
            return new Builder();
        }
    }
}
