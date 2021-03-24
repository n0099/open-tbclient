package com.baidu.searchbox.v8engine;

import java.util.HashMap;
import java.util.Map;
@NotProguard
/* loaded from: classes3.dex */
public class JavaBoundObjectManager {
    public static final String TAG = "JavaBoundObjectManager";
    public Map<Long, Object> mJavaBoundObjectMap = new HashMap();

    public void clear() {
        this.mJavaBoundObjectMap.clear();
    }

    public Object getJavaBoundObject(long j) {
        return this.mJavaBoundObjectMap.get(Long.valueOf(j));
    }

    public void putJavaBoundObject(long j, Object obj) {
        this.mJavaBoundObjectMap.put(Long.valueOf(j), obj);
    }

    public void removeJavaBoundObject(long j) {
        this.mJavaBoundObjectMap.remove(Long.valueOf(j));
    }
}
