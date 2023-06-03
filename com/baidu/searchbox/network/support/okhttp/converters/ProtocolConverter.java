package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.searchbox.network.outback.core.Protocol;
import java.io.IOException;
/* loaded from: classes4.dex */
public class ProtocolConverter {
    public static Protocol fromOks(okhttp3.Protocol protocol) {
        return Protocol.get(protocol.toString());
    }

    public static okhttp3.Protocol toOks(Protocol protocol) throws IOException {
        return okhttp3.Protocol.get(protocol.toString());
    }
}
