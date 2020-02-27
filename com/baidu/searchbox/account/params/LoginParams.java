package com.baidu.searchbox.account.params;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.data.UserAccountActionItem;
/* loaded from: classes12.dex */
public final class LoginParams {
    public static final int ANIM_LOGIN_LEFT_RIGHT = 10;
    public static final int ANIM_LOGIN_TOP_BOTTOM = 11;
    public final String mCustomLoginCss;
    final int mIntentFlags;
    public final String mLoginDialogTitle;
    public int mLoginMode;
    public final int mLoginPageAnim;
    public UserAccountActionItem mLoginSrc;
    public final String mLoginSrcToPass;
    public final boolean mNeedUserSettingForLogin;
    public final boolean mNoSupportGuestLogin;
    public final String mNormalAccountSubTitle;
    public final String mNormalAccountTitle;
    public final String mOauth;
    public final String mShareLoginDialogBgUrl;
    public final String mShareLoginDialogTitle;
    public final boolean mThirdLogin;
    public final boolean mVoiceLogin;

    private LoginParams(Builder builder) {
        this.mLoginMode = builder.mLoginMode;
        this.mLoginSrc = builder.mLoginSrc;
        this.mLoginPageAnim = builder.mLoginPageAnim;
        this.mIntentFlags = builder.mIntentFlags;
        this.mOauth = builder.mOauth;
        this.mNeedUserSettingForLogin = builder.mNeedUserSettingForLogin;
        this.mThirdLogin = builder.mThirdLogin;
        this.mVoiceLogin = builder.mVoiceLogin;
        this.mNoSupportGuestLogin = builder.mNoSupportGuestLogin;
        this.mLoginDialogTitle = builder.mLoginDialogTitle;
        this.mLoginSrcToPass = builder.mLoginSrcToPass;
        this.mShareLoginDialogTitle = builder.mShareLoginDialogTitle;
        this.mShareLoginDialogBgUrl = builder.mShareLoginDialogBgUrl;
        this.mCustomLoginCss = builder.mCustomLoginCss;
        this.mNormalAccountTitle = builder.mNormalAccountTitle;
        this.mNormalAccountSubTitle = builder.mNormalAccountSubTitle;
    }

    /* loaded from: classes12.dex */
    public static class Builder {
        private int mLoginPageAnim;
        private UserAccountActionItem mLoginSrc;
        private String mOauth;
        private int mLoginMode = 0;
        private int mIntentFlags = 0;
        private boolean mNeedUserSettingForLogin = false;
        public boolean mThirdLogin = true;
        public boolean mVoiceLogin = false;
        public boolean mNoSupportGuestLogin = false;
        public String mLoginDialogTitle = "登录一下，畅所欲言";
        public String mLoginSrcToPass = null;
        public String mShareLoginDialogTitle = "点击帐号，一键登录";
        public String mShareLoginDialogBgUrl = "";
        public String mCustomLoginCss = "";
        public String mNormalAccountTitle = "";
        public String mNormalAccountSubTitle = "";

        public Builder setNormalAccountTitle(String str, String str2) {
            this.mNormalAccountTitle = str;
            this.mNormalAccountSubTitle = str2;
            return this;
        }

        public Builder setCustomLoginCss(String str) {
            this.mCustomLoginCss = str;
            return this;
        }

        public Builder setLoginMode(int i) {
            this.mLoginMode = i;
            return this;
        }

        public Builder setNeedUserSettingForLogin(boolean z) {
            this.mNeedUserSettingForLogin = z;
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

        public Builder setNoSupportGuestLogin(boolean z) {
            this.mNoSupportGuestLogin = z;
            return this;
        }

        public Builder setOauthParam(String str) {
            this.mOauth = str;
            return this;
        }

        public Builder setLoginSrc(UserAccountActionItem userAccountActionItem) {
            this.mLoginSrc = userAccountActionItem;
            return this;
        }

        public Builder setLoginAnim(int i) {
            this.mLoginPageAnim = i;
            return this;
        }

        public Builder setIntentFlags(int i) {
            this.mIntentFlags = i;
            return this;
        }

        public Builder setLoginDialogTitle(String str) {
            this.mLoginDialogTitle = str;
            return this;
        }

        public Builder setLoginSrcToPass(String str) {
            this.mLoginSrcToPass = str;
            return this;
        }

        public Builder setShareLoginDialogTitle(String str) {
            this.mShareLoginDialogTitle = str;
            return this;
        }

        public Builder setShareLoginDialogBgUrl(String str) {
            this.mShareLoginDialogBgUrl = str;
            return this;
        }

        public LoginParams build() {
            if (this.mLoginSrc == null) {
                this.mLoginSrc = new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "unknown");
            }
            if (this.mLoginPageAnim != 10 && this.mLoginPageAnim != 11) {
                this.mLoginPageAnim = 11;
            }
            return new LoginParams(this);
        }
    }

    public static LoginParams getDefaultParams() {
        return new Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS)).build();
    }
}
