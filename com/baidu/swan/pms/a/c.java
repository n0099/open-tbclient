package com.baidu.swan.pms.a;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes24.dex */
public interface c<T> extends e {
    void N(T t);

    void O(T t);

    void P(T t);

    void Q(T t);

    String R(T t);

    com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException;

    void a(T t, com.baidu.swan.pms.model.a aVar);

    Map<String, Object> aUb();

    void af(T t);
}
