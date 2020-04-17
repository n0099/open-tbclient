package com.baidu.swan.pms.a;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes11.dex */
public interface c<T> extends e {
    void H(T t);

    void I(T t);

    void J(T t);

    void K(T t);

    String L(T t);

    void Z(T t);

    com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException;

    void a(T t, com.baidu.swan.pms.model.a aVar);

    Map<String, Object> aBE();
}
