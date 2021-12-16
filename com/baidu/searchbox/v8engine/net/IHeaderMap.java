package com.baidu.searchbox.v8engine.net;

import java.util.Map;
/* loaded from: classes10.dex */
public interface IHeaderMap {
    void addHeader(String str, String str2);

    String getHeaderValue(String str);

    Map<String, String> getTransformedHeaderMap();

    boolean hasHeader(String str);

    void removeHeader(String str);
}
