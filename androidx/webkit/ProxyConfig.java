package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class ProxyConfig {
    public static final String BYPASS_RULE_REMOVE_IMPLICIT = "<-loopback>";
    public static final String BYPASS_RULE_SIMPLE_NAMES = "<local>";
    public static final String DIRECT = "direct://";
    public static final String MATCH_ALL_SCHEMES = "*";
    public static final String MATCH_HTTP = "http";
    public static final String MATCH_HTTPS = "https";
    public List<String> mBypassRules;
    public List<ProxyRule> mProxyRules;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ProxyScheme {
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public List<String> mBypassRules;
        public List<ProxyRule> mProxyRules;

        public Builder() {
            this.mProxyRules = new ArrayList();
            this.mBypassRules = new ArrayList();
        }

        @NonNull
        private List<String> bypassRules() {
            return this.mBypassRules;
        }

        @NonNull
        private List<ProxyRule> proxyRules() {
            return this.mProxyRules;
        }

        @NonNull
        public Builder addDirect() {
            return addDirect("*");
        }

        @NonNull
        public ProxyConfig build() {
            return new ProxyConfig(proxyRules(), bypassRules());
        }

        @NonNull
        public Builder bypassSimpleHostnames() {
            return addBypassRule(ProxyConfig.BYPASS_RULE_SIMPLE_NAMES);
        }

        @NonNull
        public Builder removeImplicitRules() {
            return addBypassRule(ProxyConfig.BYPASS_RULE_REMOVE_IMPLICIT);
        }

        public Builder(@NonNull ProxyConfig proxyConfig) {
            this.mProxyRules = proxyConfig.getProxyRules();
            this.mBypassRules = proxyConfig.getBypassRules();
        }

        @NonNull
        public Builder addBypassRule(@NonNull String str) {
            this.mBypassRules.add(str);
            return this;
        }

        @NonNull
        public Builder addDirect(@NonNull String str) {
            this.mProxyRules.add(new ProxyRule(str, ProxyConfig.DIRECT));
            return this;
        }

        @NonNull
        public Builder addProxyRule(@NonNull String str) {
            this.mProxyRules.add(new ProxyRule(str));
            return this;
        }

        @NonNull
        public Builder addProxyRule(@NonNull String str, @NonNull String str2) {
            this.mProxyRules.add(new ProxyRule(str2, str));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class ProxyRule {
        public String mSchemeFilter;
        public String mUrl;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProxyRule(@NonNull String str) {
            this("*", str);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProxyRule(@NonNull String str, @NonNull String str2) {
            this.mSchemeFilter = str;
            this.mUrl = str2;
        }

        @NonNull
        public String getSchemeFilter() {
            return this.mSchemeFilter;
        }

        @NonNull
        public String getUrl() {
            return this.mUrl;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ProxyConfig(List<ProxyRule> list, List<String> list2) {
        this.mProxyRules = list;
        this.mBypassRules = list2;
    }

    @NonNull
    public List<String> getBypassRules() {
        return Collections.unmodifiableList(this.mBypassRules);
    }

    @NonNull
    public List<ProxyRule> getProxyRules() {
        return Collections.unmodifiableList(this.mProxyRules);
    }
}
