package com.baidu.searchbox.ng.ai.apps.network;

import okhttp3.MediaType;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes2.dex */
public interface NetworkDef {
    public static final String CONTENT_TYPE_LOWERCASE = "content-type";
    public static final String IP_LOOPBACK = "127.0.0.1";
    public static final String LOCALHOST = "localhost";

    /* loaded from: classes2.dex */
    public interface ContentType {
        public static final MediaType JSON = MediaType.parse("application/json");
        public static final MediaType FORM_ENCODED = MediaType.parse(URLEncodedUtils.CONTENT_TYPE);
    }

    /* loaded from: classes2.dex */
    public interface DataType {
        public static final String JSON = "json";
        public static final String STR = "string";
    }

    /* loaded from: classes2.dex */
    public interface Http {
        public static final String BODY = "body";
        public static final String HEADER = "header";
        public static final String METHOD = "method";
        public static final String URL = "url";

        /* loaded from: classes2.dex */
        public interface Method {
            public static final String CONNECT = "CONNECT";
            public static final String DELETE = "DELETE";
            public static final String GET = "GET";
            public static final String HEAD = "HEAD";
            public static final String OPTIONS = "OPTIONS";
            public static final String POST = "POST";
            public static final String PUT = "PUT";
            public static final String TRACE = "TRACE";
        }
    }
}
