package com.baidu.searchbox.account.params;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.result.BoxLoginHistoryModel;
/* loaded from: classes3.dex */
public final class LoginParams {
    public static final int ANIM_LOGIN_LEFT_RIGHT = 10;
    public static final int ANIM_LOGIN_TOP_BOTTOM = 11;
    public boolean isAcceptBrowserModeAgreement;
    public BoxLoginHistoryModel loginHistoryModel;
    public int loginStyle;
    public String mAutoLoginUrl;
    public final String mCustomLoginCss;
    public final Drawable mFunctionIconDrawable;
    public boolean mHistoryFailJumpPass;
    public final int mIntentFlags;
    public boolean mIsCanceledOnTouchOutside;
    public final CharSequence mLoginDialogTitle;
    public int mLoginMode;
    public final int mLoginPageAnim;
    public UserAccountActionItem mLoginSrc;
    public final String mLoginSrcToPass;
    public int mLoginViewType;
    public final boolean mNeedTouchGuide;
    @Deprecated
    public final boolean mNeedUserSettingForLogin;
    @NightMode
    public int mNightMode;
    public final boolean mNoSupportGuestLogin;
    public final String mNormalAccountSubTitle;
    public final String mNormalAccountTitle;
    public final String mOauth;
    public boolean mOneKeyLoginOpenVerficationPage;
    public boolean mOnekeyFailJumpPass;
    public String mPluginName;
    public String mShareLoginApp;
    public final String mShareLoginDialogBgUrl;
    public final String mShareLoginDialogTitle;
    public String mShareLoginDisplayname;
    public boolean mShowKeyBoard;
    public boolean mSupportAnim;
    public final boolean mThirdLogin;
    public final boolean mVoiceLogin;

    /* loaded from: classes3.dex */
    public @interface NightMode {
        public static final int HOST_NIGHT_MODE = 0;
        public static final int OBSCURATION_NIGHT_MODE = 1;
    }

    public LoginParams(Builder builder) {
        this.isAcceptBrowserModeAgreement = false;
        this.mShowKeyBoard = true;
        this.loginStyle = -1;
        this.mOnekeyFailJumpPass = true;
        this.mHistoryFailJumpPass = false;
        this.mIsCanceledOnTouchOutside = true;
        this.mLoginMode = builder.mLoginMode;
        this.mLoginSrc = builder.mLoginSrc;
        this.mLoginPageAnim = builder.mLoginPageAnim;
        this.mIntentFlags = builder.mIntentFlags;
        this.mOauth = builder.mOauth;
        this.mNeedUserSettingForLogin = builder.mNeedUserSettingForLogin;
        this.mNeedTouchGuide = builder.mNeedTouchGuide;
        this.mThirdLogin = builder.mThirdLogin;
        this.mVoiceLogin = builder.mVoiceLogin;
        this.mNoSupportGuestLogin = builder.mNoSupportGuestLogin;
        this.mLoginDialogTitle = builder.mLoginDialogTitle;
        this.mLoginSrcToPass = builder.mLoginSrcToPass;
        this.mShareLoginDialogTitle = builder.mShareLoginDialogTitle;
        this.mShareLoginDialogBgUrl = builder.mShareLoginDialogBgUrl;
        this.mShareLoginApp = builder.mShareLoginApp;
        this.mShareLoginDisplayname = builder.mShareLoginDisplayname;
        this.mCustomLoginCss = builder.mCustomLoginCss;
        this.mNormalAccountTitle = builder.mNormalAccountTitle;
        this.mNormalAccountSubTitle = builder.mNormalAccountSubTitle;
        this.mOneKeyLoginOpenVerficationPage = builder.mOneKeyLoginOpenVerficationPage;
        this.mFunctionIconDrawable = builder.mFunctionIconDrawable;
        this.mLoginViewType = builder.mLoginViewType;
        this.mPluginName = builder.mPluginName;
        this.mSupportAnim = builder.mSupportAnim;
        this.mNightMode = builder.mNightMode;
        this.isAcceptBrowserModeAgreement = builder.mIsAcceptBrowserModeAgreement;
        this.loginHistoryModel = builder.mLoginHistoryModel;
        this.mOnekeyFailJumpPass = builder.mOnekeyFailJumpPass;
        this.mIsCanceledOnTouchOutside = builder.mIsCanceledOnTouchOutside;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public Drawable mFunctionIconDrawable;
        public BoxLoginHistoryModel mLoginHistoryModel;
        public int mLoginPageAnim;
        public UserAccountActionItem mLoginSrc;
        @NightMode
        public int mNightMode;
        public String mOauth;
        public String mPluginName;
        public boolean mSupportAnim;
        public int mLoginMode = 0;
        public int mIntentFlags = 0;
        @Deprecated
        public boolean mNeedUserSettingForLogin = false;
        public boolean mNeedTouchGuide = false;
        public boolean mThirdLogin = true;
        public boolean mVoiceLogin = false;
        public boolean mNoSupportGuestLogin = false;
        public CharSequence mLoginDialogTitle = "登录百度帐号，精彩永相随";
        public String mLoginSrcToPass = null;
        public String mShareLoginDialogTitle = "点击帐号，一键登录";
        public String mShareLoginDialogBgUrl = "";
        public String mShareLoginApp = "";
        public String mShareLoginDisplayname = "";
        public String mCustomLoginCss = "";
        public String mNormalAccountTitle = "";
        public String mNormalAccountSubTitle = "";
        public boolean mOneKeyLoginOpenVerficationPage = true;
        public int mLoginViewType = -1;
        public boolean mIsAcceptBrowserModeAgreement = false;
        public boolean mOnekeyFailJumpPass = true;
        public boolean mIsCanceledOnTouchOutside = true;

        public Builder setCanceledOnTouchOutside(boolean z) {
            this.mIsCanceledOnTouchOutside = z;
            return this;
        }

        public Builder setCustomLoginCss(String str) {
            this.mCustomLoginCss = str;
            return this;
        }

        public Builder setFunctionIconDrawable(Drawable drawable) {
            this.mFunctionIconDrawable = drawable;
            return this;
        }

        public Builder setIntentFlags(int i) {
            this.mIntentFlags = i;
            return this;
        }

        public Builder setIsAcceptBrowserModeAgreement(boolean z) {
            this.mIsAcceptBrowserModeAgreement = z;
            return this;
        }

        public Builder setLoginAnim(int i) {
            this.mLoginPageAnim = i;
            return this;
        }

        public Builder setLoginDialogTitle(CharSequence charSequence) {
            this.mLoginDialogTitle = charSequence;
            return this;
        }

        public Builder setLoginHistoryModel(BoxLoginHistoryModel boxLoginHistoryModel) {
            this.mLoginHistoryModel = boxLoginHistoryModel;
            return this;
        }

        public Builder setLoginMode(int i) {
            this.mLoginMode = i;
            return this;
        }

        public Builder setLoginSrc(UserAccountActionItem userAccountActionItem) {
            this.mLoginSrc = userAccountActionItem;
            return this;
        }

        public Builder setLoginSrcToPass(String str) {
            this.mLoginSrcToPass = str;
            return this;
        }

        public Builder setLoginViewType(int i) {
            this.mLoginViewType = i;
            return this;
        }

        public Builder setNeedTouchGuideForLogin(boolean z) {
            this.mNeedTouchGuide = z;
            return this;
        }

        @Deprecated
        public Builder setNeedUserSettingForLogin(boolean z) {
            this.mNeedUserSettingForLogin = z;
            return this;
        }

        public Builder setNightMode(@NightMode int i) {
            this.mNightMode = i;
            return this;
        }

        public Builder setNoSupportGuestLogin(boolean z) {
            this.mNoSupportGuestLogin = z;
            return this;
        }

        public Builder setOauthParam(String str) {
            this.mOauth = str;
            return this;
        }

        public Builder setOnekeyFailJumpPass(boolean z) {
            this.mOnekeyFailJumpPass = z;
            return this;
        }

        public Builder setOnekeyLoginOpenVerficationPage(boolean z) {
            this.mOneKeyLoginOpenVerficationPage = z;
            return this;
        }

        public Builder setPluginName(String str) {
            this.mPluginName = str;
            return this;
        }

        public Builder setShareLoginApp(String str) {
            this.mShareLoginApp = str;
            return this;
        }

        public Builder setShareLoginDialogBgUrl(String str) {
            this.mShareLoginDialogBgUrl = str;
            return this;
        }

        public Builder setShareLoginDialogTitle(String str) {
            this.mShareLoginDialogTitle = str;
            return this;
        }

        public Builder setShareLoginDisplayname(String str) {
            this.mShareLoginDisplayname = str;
            return this;
        }

        public Builder setSupportAnim(boolean z) {
            this.mSupportAnim = z;
            return this;
        }

        public Builder setThirdLogin(boolean z) {
            this.mThirdLogin = z;
            return this;
        }

        public Builder setVoiceLogin(boolean z) {
            this.mVoiceLogin = z;
            return this;
        }

        public LoginParams build() {
            if (this.mLoginSrc == null) {
                this.mLoginSrc = new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "unknown");
            }
            if (!TextUtils.isEmpty(this.mPluginName)) {
                UserAccountActionItem userAccountActionItem = this.mLoginSrc;
                userAccountActionItem.setSrc(this.mPluginName + "_" + this.mLoginSrc.getSrc());
            }
            int i = this.mLoginPageAnim;
            if (i != 10 && i != 11) {
                this.mLoginPageAnim = 11;
            }
            return new LoginParams(this);
        }

        public Builder setLoginDialogTitle(String str) {
            this.mLoginDialogTitle = str;
            return this;
        }

        public Builder setNormalAccountTitle(String str, String str2) {
            this.mNormalAccountTitle = str;
            this.mNormalAccountSubTitle = str2;
            return this;
        }
    }

    public static LoginParams getDefaultParams() {
        return new Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS)).build();
    }

    public boolean isHistoryFailJumpPass() {
        return this.mHistoryFailJumpPass;
    }

    public boolean isOnekeyFailJumpPass() {
        return this.mOnekeyFailJumpPass;
    }
}
