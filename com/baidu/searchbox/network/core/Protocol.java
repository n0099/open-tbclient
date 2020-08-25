package com.baidu.searchbox.network.core;

import com.baidu.mobstat.Config;
/* loaded from: classes14.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2(Config.EVENT_NATIVE_VIEW_HIERARCHY),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic"),
    UNKNOWN("unknown");
    
    private final String protocol;

    Protocol(String str) {
        this.protocol = str;
    }

    public static Protocol get(String str) {
        if (str.equals(HTTP_1_0.protocol)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.protocol)) {
            return HTTP_1_1;
        }
        if (str.equals(H2_PRIOR_KNOWLEDGE.protocol)) {
            return H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals(HTTP_2.protocol)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.protocol)) {
            return SPDY_3;
        }
        if (str.equals(QUIC.protocol)) {
            return QUIC;
        }
        return UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
