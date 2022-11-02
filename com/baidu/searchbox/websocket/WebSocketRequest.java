package com.baidu.searchbox.websocket;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #:\u0002$#B\u0011\b\u0012\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b!\u0010\u0015R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketRequest;", "", "connectionLostTimeout", "Ljava/lang/Integer;", "getConnectionLostTimeout", "()Ljava/lang/Integer;", "setConnectionLostTimeout", "(Ljava/lang/Integer;)V", "", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "method", "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "", WebSocketRequest.PARAM_KEY_PROTOCOLS, "Ljava/util/List;", "getProtocols", "()Ljava/util/List;", "setProtocols", "(Ljava/util/List;)V", "url", "getUrl", "Lcom/baidu/searchbox/websocket/WebSocketRequest$Builder;", "builder", "<init>", "(Lcom/baidu/searchbox/websocket/WebSocketRequest$Builder;)V", "Companion", "Builder", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class WebSocketRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String PARAM_KEY_HEADER = "header";
    public static final String PARAM_KEY_METHOD = "method";
    public static final String PARAM_KEY_PROTOCOLS = "protocols";
    public static final String PARAM_KEY_URL = "url";
    public transient /* synthetic */ FieldHolder $fh;
    public Integer connectionLostTimeout;
    public Map<String, String> headers;
    public String method;
    public List<String> protocols;
    public final String url;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-701240079, "Lcom/baidu/searchbox/websocket/WebSocketRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-701240079, "Lcom/baidu/searchbox/websocket/WebSocketRequest;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\f\u0018\u0000B\u0007¢\u0006\u0004\b(\u0010)J\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001d¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketRequest$Builder;", "", "key", "value", "", "addHeader", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "build", "()Lcom/baidu/searchbox/websocket/WebSocketRequest;", "", "connectionLostTimeout", "Ljava/lang/Integer;", "getConnectionLostTimeout", "()Ljava/lang/Integer;", "setConnectionLostTimeout", "(Ljava/lang/Integer;)V", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "method", "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "", WebSocketRequest.PARAM_KEY_PROTOCOLS, "Ljava/util/List;", "getProtocols", "()Ljava/util/List;", "setProtocols", "(Ljava/util/List;)V", "url", "getUrl", "setUrl", "<init>", "()V", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer connectionLostTimeout;
        public Map<String, String> headers;
        public String method;
        public List<String> protocols;
        public String url;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.method = "GET";
        }

        public final WebSocketRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new WebSocketRequest(this, null);
            }
            return (WebSocketRequest) invokeV.objValue;
        }

        public final Integer getConnectionLostTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.connectionLostTimeout;
            }
            return (Integer) invokeV.objValue;
        }

        public final Map<String, String> getHeaders() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.headers;
            }
            return (Map) invokeV.objValue;
        }

        public final String getMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.method;
            }
            return (String) invokeV.objValue;
        }

        public final List<String> getProtocols() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.protocols;
            }
            return (List) invokeV.objValue;
        }

        public final String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public final void addHeader(String key, String value) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, key, value) == null) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                if (this.headers == null) {
                    this.headers = new HashMap();
                }
                Map<String, String> map = this.headers;
                if (map != null) {
                    map.put(key, value);
                }
            }
        }

        public final void setConnectionLostTimeout(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
                this.connectionLostTimeout = num;
            }
        }

        public final void setHeaders(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map) == null) {
                this.headers = map;
            }
        }

        public final void setMethod(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.method = str;
            }
        }

        public final void setProtocols(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
                this.protocols = list;
            }
        }

        public final void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.url = str;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketRequest$Companion;", "Lkotlin/Function1;", "Lcom/baidu/searchbox/websocket/WebSocketRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "build", "(Lkotlin/Function1;)Lcom/baidu/searchbox/websocket/WebSocketRequest;", "Lorg/json/JSONObject;", "params", "fromJSON", "(Lorg/json/JSONObject;)Lcom/baidu/searchbox/websocket/WebSocketRequest;", "", "PARAM_KEY_HEADER", "Ljava/lang/String;", "PARAM_KEY_METHOD", "PARAM_KEY_PROTOCOLS", "PARAM_KEY_URL", "<init>", "()V", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebSocketRequest build(Function1<? super Builder, Unit> block) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, block)) == null) {
                Intrinsics.checkNotNullParameter(block, "block");
                Builder builder = new Builder();
                block.invoke(builder);
                return builder.build();
            }
            return (WebSocketRequest) invokeL.objValue;
        }

        /* JADX WARN: Type inference failed for: r7v10, types: [T, org.json.JSONArray] */
        /* JADX WARN: Type inference failed for: r7v2, types: [T, org.json.JSONArray] */
        public final WebSocketRequest fromJSON(JSONObject params) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                Companion companion = WebSocketRequest.Companion;
                Builder builder = new Builder();
                builder.setUrl(params.getString("url"));
                if (params.has("method")) {
                    String string = params.getString("method");
                    Intrinsics.checkNotNullExpressionValue(string, "params.getString(PARAM_KEY_METHOD)");
                    builder.setMethod(string);
                }
                if (params.has("header")) {
                    JSONObject jSONObject = params.getJSONObject("header");
                    Iterator<String> keys = jSONObject.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "headers.keys()");
                    while (keys.hasNext()) {
                        String key = keys.next();
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        String string2 = jSONObject.getString(key);
                        Intrinsics.checkNotNullExpressionValue(string2, "headers.getString(key)");
                        builder.addHeader(key, string2);
                    }
                }
                if (params.has(WebSocketRequest.PARAM_KEY_PROTOCOLS)) {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? jSONArray = params.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                    objectRef.element = jSONArray;
                    if (((JSONArray) jSONArray).length() == 0) {
                        ?? jSONArray2 = new JSONArray();
                        objectRef.element = jSONArray2;
                        ((JSONArray) jSONArray2).put("");
                    }
                    builder.setProtocols(SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, ((JSONArray) objectRef.element).length())), new WebSocketRequest$Companion$fromJSON$1$2(objectRef))));
                }
                return builder.build();
            }
            return (WebSocketRequest) invokeL.objValue;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebSocketRequest(Builder builder) {
        this(r0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String url = builder.getUrl();
        Intrinsics.checkNotNull(url);
        this.method = builder.getMethod();
        this.headers = builder.getHeaders();
        this.protocols = builder.getProtocols();
        this.connectionLostTimeout = builder.getConnectionLostTimeout();
    }

    public /* synthetic */ WebSocketRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public WebSocketRequest(String url) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.method = "GET";
    }

    public final Integer getConnectionLostTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.connectionLostTimeout;
        }
        return (Integer) invokeV.objValue;
    }

    public final Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.headers;
        }
        return (Map) invokeV.objValue;
    }

    public final String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.method;
        }
        return (String) invokeV.objValue;
    }

    public final List<String> getProtocols() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.protocols;
        }
        return (List) invokeV.objValue;
    }

    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public final void setConnectionLostTimeout(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, num) == null) {
            this.connectionLostTimeout = num;
        }
    }

    public final void setHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
            this.headers = map;
        }
    }

    public final void setMethod(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.method = str;
        }
    }

    public final void setProtocols(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.protocols = list;
        }
    }
}
