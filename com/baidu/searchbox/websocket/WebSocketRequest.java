package com.baidu.searchbox.websocket;

import com.baidu.ubc.UBC;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.n;
import kotlin.e;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import kotlin.sequences.d;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class WebSocketRequest {
    public static final Companion Companion = new Companion(null);
    public static final String PARAM_KEY_HEADER = "header";
    public static final String PARAM_KEY_METHOD = "method";
    public static final String PARAM_KEY_PROTOCOLS = "protocols";
    public static final String PARAM_KEY_URL = "url";
    private Integer connectionLostTimeout;
    private Map<String, String> headers;
    private String method;
    private List<String> protocols;
    private final String url;

    public /* synthetic */ WebSocketRequest(Builder builder, o oVar) {
        this(builder);
    }

    public WebSocketRequest(String str) {
        p.k(str, "url");
        this.url = str;
        this.method = "GET";
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        p.k(str, "<set-?>");
        this.method = str;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public final List<String> getProtocols() {
        return this.protocols;
    }

    public final void setProtocols(List<String> list) {
        this.protocols = list;
    }

    public final Integer getConnectionLostTimeout() {
        return this.connectionLostTimeout;
    }

    public final void setConnectionLostTimeout(Integer num) {
        this.connectionLostTimeout = num;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private WebSocketRequest(Builder builder) {
        this(r0);
        String url = builder.getUrl();
        if (url == null) {
            p.cCt();
        }
        this.method = builder.getMethod();
        this.headers = builder.getHeaders();
        this.protocols = builder.getProtocols();
        this.connectionLostTimeout = builder.getConnectionLostTimeout();
    }

    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final WebSocketRequest build(b<? super Builder, e> bVar) {
            p.k(bVar, "block");
            Builder builder = new Builder();
            bVar.invoke(builder);
            return builder.build();
        }

        /* JADX WARN: Type inference failed for: r0v12, types: [T, org.json.JSONArray] */
        /* JADX WARN: Type inference failed for: r0v15, types: [T, org.json.JSONArray] */
        public final WebSocketRequest fromJSON(JSONObject jSONObject) {
            p.k(jSONObject, "params");
            Companion companion = WebSocketRequest.Companion;
            Builder builder = new Builder();
            builder.setUrl(jSONObject.getString("url"));
            if (jSONObject.has("method")) {
                String string = jSONObject.getString("method");
                p.j(string, "params.getString(PARAM_KEY_METHOD)");
                builder.setMethod(string);
            }
            if (jSONObject.has(WebSocketRequest.PARAM_KEY_HEADER)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
                Iterator<String> keys = jSONObject2.keys();
                p.j(keys, "headers.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    p.j(next, "key");
                    String string2 = jSONObject2.getString(next);
                    p.j(string2, "headers.getString(key)");
                    builder.addHeader(next, string2);
                }
            }
            if (jSONObject.has(WebSocketRequest.PARAM_KEY_PROTOCOLS)) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = jSONObject.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                if (((JSONArray) objectRef.element) == null || ((JSONArray) objectRef.element).length() == 0) {
                    objectRef.element = new JSONArray();
                    ((JSONArray) objectRef.element).put("");
                }
                builder.setProtocols(d.b(d.c(n.d(kotlin.b.d.cJ(0, ((JSONArray) objectRef.element).length())), new WebSocketRequest$Companion$fromJSON$1$2(objectRef))));
            }
            return builder.build();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private Integer connectionLostTimeout;
        private Map<String, String> headers;
        private String method = "GET";
        private List<String> protocols;
        private String url;

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final String getMethod() {
            return this.method;
        }

        public final void setMethod(String str) {
            p.k(str, "<set-?>");
            this.method = str;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final void setHeaders(Map<String, String> map) {
            this.headers = map;
        }

        public final List<String> getProtocols() {
            return this.protocols;
        }

        public final void setProtocols(List<String> list) {
            this.protocols = list;
        }

        public final Integer getConnectionLostTimeout() {
            return this.connectionLostTimeout;
        }

        public final void setConnectionLostTimeout(Integer num) {
            this.connectionLostTimeout = num;
        }

        public final void addHeader(String str, String str2) {
            p.k(str, "key");
            p.k(str2, UBC.CONTENT_KEY_VALUE);
            Builder builder = this;
            if (builder.headers == null) {
                builder.headers = new HashMap();
            }
            Map<String, String> map = builder.headers;
            if (map != null) {
                map.put(str, str2);
            }
        }

        public final WebSocketRequest build() {
            return new WebSocketRequest(this, null);
        }
    }
}
