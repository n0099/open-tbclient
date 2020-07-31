package com.baidu.swan.pms.a;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes19.dex */
public interface c<T> extends e {
    void L(T t);

    void M(T t);

    void N(T t);

    void O(T t);

    String P(T t);

    com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException;

    void a(T t, com.baidu.swan.pms.model.a aVar);

    Map<String, Object> aKO();

    void ae(T t);
}
