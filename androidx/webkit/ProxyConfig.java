package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class ProxyConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BYPASS_RULE_REMOVE_IMPLICIT = "<-loopback>";
    public static final String BYPASS_RULE_SIMPLE_NAMES = "<local>";
    public static final String DIRECT = "direct://";
    public static final String MATCH_ALL_SCHEMES = "*";
    public static final String MATCH_HTTP = "http";
    public static final String MATCH_HTTPS = "https";
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> mBypassRules;
    public List<ProxyRule> mProxyRules;

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> mBypassRules;
        public List<ProxyRule> mProxyRules;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mProxyRules = new ArrayList();
            this.mBypassRules = new ArrayList();
        }

        @NonNull
        private List<String> bypassRules() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.mBypassRules : (List) invokeV.objValue;
        }

        @NonNull
        private List<ProxyRule> proxyRules() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.mProxyRules : (List) invokeV.objValue;
        }

        @NonNull
        public Builder addBypassRule(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.mBypassRules.add(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder addDirect(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mProxyRules.add(new ProxyRule(str, ProxyConfig.DIRECT));
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder addProxyRule(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mProxyRules.add(new ProxyRule(str));
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public ProxyConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new ProxyConfig(proxyRules(), bypassRules()) : (ProxyConfig) invokeV.objValue;
        }

        @NonNull
        public Builder bypassSimpleHostnames() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? addBypassRule(ProxyConfig.BYPASS_RULE_SIMPLE_NAMES) : (Builder) invokeV.objValue;
        }

        @NonNull
        public Builder removeImplicitRules() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? addBypassRule(ProxyConfig.BYPASS_RULE_REMOVE_IMPLICIT) : (Builder) invokeV.objValue;
        }

        @NonNull
        public Builder addDirect() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? addDirect(ProxyConfig.MATCH_ALL_SCHEMES) : (Builder) invokeV.objValue;
        }

        @NonNull
        public Builder addProxyRule(@NonNull String str, @NonNull String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                this.mProxyRules.add(new ProxyRule(str2, str));
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder(@NonNull ProxyConfig proxyConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {proxyConfig};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mProxyRules = proxyConfig.getProxyRules();
            this.mBypassRules = proxyConfig.getBypassRules();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ProxyScheme {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ProxyConfig(List<ProxyRule> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProxyRules = list;
        this.mBypassRules = list2;
    }

    @NonNull
    public List<String> getBypassRules() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Collections.unmodifiableList(this.mBypassRules) : (List) invokeV.objValue;
    }

    @NonNull
    public List<ProxyRule> getProxyRules() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Collections.unmodifiableList(this.mProxyRules) : (List) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static final class ProxyRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mSchemeFilter;
        public String mUrl;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProxyRule(@NonNull String str, @NonNull String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mSchemeFilter = str;
            this.mUrl = str2;
        }

        @NonNull
        public String getSchemeFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSchemeFilter : (String) invokeV.objValue;
        }

        @NonNull
        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mUrl : (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProxyRule(@NonNull String str) {
            this(ProxyConfig.MATCH_ALL_SCHEMES, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }
}
