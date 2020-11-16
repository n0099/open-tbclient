package com.baidu.searchbox.v8engine;

import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
@NotProguard
/* loaded from: classes6.dex */
public class JavaBoundObjectManager {
    public static final String TAG = "JavaBoundObjectManager";
    private Map<Long, Object> mJavaBoundObjectMap = new HashMap();

    void putJavaBoundObject(long j, Object obj) {
        this.mJavaBoundObjectMap.put(Long.valueOf(j), obj);
    }

    Object getJavaBoundObject(long j) {
        return this.mJavaBoundObjectMap.get(Long.valueOf(j));
    }

    void removeJavaBoundObject(long j) {
        this.mJavaBoundObjectMap.remove(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.mJavaBoundObjectMap.clear();
    }
}
