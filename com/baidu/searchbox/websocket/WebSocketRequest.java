package com.baidu.searchbox.websocket;

import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteHelper;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #:\u0002$#B\u0011\b\u0012\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b!\u0010\u0015R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketRequest;", "", "connectionLostTimeout", "Ljava/lang/Integer;", "getConnectionLostTimeout", "()Ljava/lang/Integer;", "setConnectionLostTimeout", "(Ljava/lang/Integer;)V", "", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "method", "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "", WebSocketRequest.PARAM_KEY_PROTOCOLS, "Ljava/util/List;", "getProtocols", "()Ljava/util/List;", "setProtocols", "(Ljava/util/List;)V", "url", "getUrl", "Lcom/baidu/searchbox/websocket/WebSocketRequest$Builder;", "builder", "<init>", "(Lcom/baidu/searchbox/websocket/WebSocketRequest$Builder;)V", "Companion", "Builder", "lib-websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class WebSocketRequest {
    public static final Companion Companion = new Companion(null);
    public static final String PARAM_KEY_HEADER = "header";
    public static final String PARAM_KEY_METHOD = "method";
    public static final String PARAM_KEY_PROTOCOLS = "protocols";
    public static final String PARAM_KEY_URL = "url";
    public Integer connectionLostTimeout;
    public Map<String, String> headers;
    public String method;
    public List<String> protocols;
    public final String url;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\f\u0018\u0000B\u0007¢\u0006\u0004\b(\u0010)J\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001d¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketRequest$Builder;", "", "key", "value", "", "addHeader", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "build", "()Lcom/baidu/searchbox/websocket/WebSocketRequest;", "", "connectionLostTimeout", "Ljava/lang/Integer;", "getConnectionLostTimeout", "()Ljava/lang/Integer;", "setConnectionLostTimeout", "(Ljava/lang/Integer;)V", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "method", "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "", WebSocketRequest.PARAM_KEY_PROTOCOLS, "Ljava/util/List;", "getProtocols", "()Ljava/util/List;", "setProtocols", "(Ljava/util/List;)V", "url", "getUrl", "setUrl", "<init>", "()V", "lib-websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Builder {
        public Integer connectionLostTimeout;
        public Map<String, String> headers;
        public String method = "GET";
        public List<String> protocols;
        public String url;

        public final void addHeader(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            Map<String, String> map = this.headers;
            if (map != null) {
                map.put(str, str2);
            }
        }

        public final WebSocketRequest build() {
            return new WebSocketRequest(this, null);
        }

        public final Integer getConnectionLostTimeout() {
            return this.connectionLostTimeout;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getMethod() {
            return this.method;
        }

        public final List<String> getProtocols() {
            return this.protocols;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setConnectionLostTimeout(Integer num) {
            this.connectionLostTimeout = num;
        }

        public final void setHeaders(Map<String, String> map) {
            this.headers = map;
        }

        public final void setMethod(String str) {
            this.method = str;
        }

        public final void setProtocols(List<String> list) {
            this.protocols = list;
        }

        public final void setUrl(String str) {
            this.url = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\b¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketRequest$Companion;", "Lkotlin/Function1;", "Lcom/baidu/searchbox/websocket/WebSocketRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "build", "(Lkotlin/Function1;)Lcom/baidu/searchbox/websocket/WebSocketRequest;", "Lorg/json/JSONObject;", "params", "fromJSON", "(Lorg/json/JSONObject;)Lcom/baidu/searchbox/websocket/WebSocketRequest;", "", "PARAM_KEY_HEADER", "Ljava/lang/String;", "PARAM_KEY_METHOD", "PARAM_KEY_PROTOCOLS", "PARAM_KEY_URL", "<init>", "()V", "lib-websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final WebSocketRequest build(Function1<? super Builder, Unit> function1) {
            Builder builder = new Builder();
            function1.invoke(builder);
            return builder.build();
        }

        /* JADX WARN: Type inference failed for: r7v2, types: [T, org.json.JSONArray] */
        /* JADX WARN: Type inference failed for: r7v3, types: [T, org.json.JSONArray] */
        public final WebSocketRequest fromJSON(JSONObject jSONObject) {
            Companion companion = WebSocketRequest.Companion;
            Builder builder = new Builder();
            builder.setUrl(jSONObject.getString("url"));
            if (jSONObject.has("method")) {
                String string = jSONObject.getString("method");
                Intrinsics.checkExpressionValueIsNotNull(string, "params.getString(PARAM_KEY_METHOD)");
                builder.setMethod(string);
            }
            if (jSONObject.has("header")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("header");
                Iterator<String> keys = jSONObject2.keys();
                Intrinsics.checkExpressionValueIsNotNull(keys, "headers.keys()");
                while (keys.hasNext()) {
                    String key = keys.next();
                    Intrinsics.checkExpressionValueIsNotNull(key, "key");
                    String string2 = jSONObject2.getString(key);
                    Intrinsics.checkExpressionValueIsNotNull(string2, "headers.getString(key)");
                    builder.addHeader(key, string2);
                }
            }
            if (jSONObject.has(WebSocketRequest.PARAM_KEY_PROTOCOLS)) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? jSONArray = jSONObject.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                objectRef.element = jSONArray;
                if (((JSONArray) jSONArray) == null || ((JSONArray) jSONArray).length() == 0) {
                    ?? jSONArray2 = new JSONArray();
                    objectRef.element = jSONArray2;
                    ((JSONArray) jSONArray2).put("");
                }
                builder.setProtocols(SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, ((JSONArray) objectRef.element).length())), new WebSocketRequest$Companion$fromJSON$1$2(objectRef))));
            }
            return builder.build();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ WebSocketRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final Integer getConnectionLostTimeout() {
        return this.connectionLostTimeout;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getMethod() {
        return this.method;
    }

    public final List<String> getProtocols() {
        return this.protocols;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setConnectionLostTimeout(Integer num) {
        this.connectionLostTimeout = num;
    }

    public final void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final void setProtocols(List<String> list) {
        this.protocols = list;
    }

    public WebSocketRequest(String str) {
        this.url = str;
        this.method = "GET";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebSocketRequest(Builder builder) {
        this(r0);
        String url = builder.getUrl();
        if (url == null) {
            Intrinsics.throwNpe();
        }
        this.method = builder.getMethod();
        this.headers = builder.getHeaders();
        this.protocols = builder.getProtocols();
        this.connectionLostTimeout = builder.getConnectionLostTimeout();
    }
}
