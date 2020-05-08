package com.baidu.swan.pms.a;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes11.dex */
public abstract class b<T> implements c<T> {
    @Override // com.baidu.swan.pms.a.c
    public void L(T t) {
    }

    @Override // com.baidu.swan.pms.a.c
    public void K(T t) {
    }

    @Override // com.baidu.swan.pms.a.c
    public void J(T t) {
    }

    @Override // com.baidu.swan.pms.a.c
    public void I(T t) {
    }

    @Override // com.baidu.swan.pms.a.c
    public void a(T t, com.baidu.swan.pms.model.a aVar) {
    }

    @Override // com.baidu.swan.pms.a.c
    public void aa(T t) {
    }

    @Override // com.baidu.swan.pms.a.c
    public com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        return new com.baidu.swan.pms.model.a(2302, "业务层默认不处理下载流");
    }

    @Override // com.baidu.swan.pms.a.c
    public Map<String, Object> aBE() {
        HashMap hashMap = new HashMap();
        hashMap.put("queue_priority", Integer.valueOf(getPriority()));
        return hashMap;
    }

    protected int getPriority() {
        return 100;
    }
}
