package com.baidu.swan.pms.a;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes15.dex */
public interface c<T> extends e {
    void Q(T t);

    void R(T t);

    void S(T t);

    void T(T t);

    String U(T t);

    com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException;

    void a(T t, com.baidu.swan.pms.model.a aVar);

    Map<String, Object> aYD();

    void ai(T t);
}
