package com.baidu.android.app.account.plugin;
/* loaded from: classes.dex */
public final class PluginLogoutParams {
    public static final String PLUGIN_NAME_UNKNOWN = "plugin_name_unknown";
    public final String mLogoutSrc;

    private PluginLogoutParams(Builder builder) {
        this.mLogoutSrc = builder.mLogoutSrc;
    }

    /* synthetic */ PluginLogoutParams(Builder builder, PluginLogoutParams pluginLogoutParams) {
        this(builder);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String mLogoutSrc;
        private String mPluginName;

        public Builder setLogoutSrc(String str) {
            this.mLogoutSrc = str;
            return this;
        }

        public Builder setPluginName(String str) {
            this.mPluginName = str;
            return this;
        }

        public PluginLogoutParams build() {
            return new PluginLogoutParams(this, null);
        }
    }
}
