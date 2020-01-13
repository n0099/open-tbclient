package com.baidu.swan.pms.a;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes10.dex */
public interface c<T> extends e {
    void E(T t);

    void F(T t);

    void G(T t);

    void H(T t);

    String I(T t);

    void W(T t);

    com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException;

    void a(T t, com.baidu.swan.pms.model.a aVar);

    Map<String, Object> arb();
}
