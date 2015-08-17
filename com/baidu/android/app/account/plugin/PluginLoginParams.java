package com.baidu.android.app.account.plugin;
/* loaded from: classes.dex */
public final class PluginLoginParams {
    public static final int ANIM_LOGIN_LEFT_RIGHT = 10;
    public static final int ANIM_LOGIN_TOP_BOTTOM = 11;
    public static final int BOX_ONEKEY_LOGIN = 2;
    public static final int BOX_SMS_LOGIN = 1;
    public static final int BOX_USERNAME_PASSWORD_LOGIN = 0;
    public static final String INTENT_EXTRA_KEY_LOGIN_MODE = "intent_extra_key_login_mode";
    public static final String INTENT_EXTRA_KEY_LOGIN_SRC = "intent_extra_key_login_src";
    public static final String INTENT_EXTRA_KEY_OAUTH_OPTIONS = "intent_extra_key_oauth_options";
    public static final String PLUGIN_NAME_UNKNOWN = "plugin_name_unknown";
    final int mIntentFlags;
    final int mLoginMode;
    public final int mLoginPageAnim;
    final String mLoginSrc;
    public final String mOauth;
    private String mPluginName;

    private PluginLoginParams(Builder builder) {
        this.mPluginName = builder.mPluginName;
        this.mLoginMode = builder.mLoginMode;
        this.mLoginSrc = builder.mLoginSrc;
        this.mLoginPageAnim = builder.mLoginPageAnim;
        this.mIntentFlags = builder.mIntentFlags;
        this.mOauth = builder.mOauth;
    }

    /* synthetic */ PluginLoginParams(Builder builder, PluginLoginParams pluginLoginParams) {
        this(builder);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private int mLoginPageAnim;
        private String mLoginSrc;
        private String mOauth;
        private String mPluginName;
        private int mLoginMode = 0;
        private int mIntentFlags = 0;

        public Builder setLoginMode(int i) {
            this.mLoginMode = i;
            return this;
        }

        public Builder setOauthParam(String str) {
            this.mOauth = str;
            return this;
        }

        public Builder setLoginSrc(String str) {
            this.mLoginSrc = str;
            return this;
        }

        public Builder setPluginName(String str) {
            this.mPluginName = str;
            return this;
        }

        public Builder setLoginAnim(int i) {
            this.mLoginPageAnim = i;
            return this;
        }

        public PluginLoginParams build() {
            return new PluginLoginParams(this, null);
        }
    }
}
