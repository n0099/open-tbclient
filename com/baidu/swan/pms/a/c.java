package com.baidu.swan.pms.a;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes3.dex */
public interface c<T> extends e {
    void S(T t);

    void T(T t);

    void U(T t);

    void V(T t);

    String W(T t);

    com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException;

    void a(T t, com.baidu.swan.pms.model.a aVar);

    void am(T t);

    Map<String, Object> bct();
}
