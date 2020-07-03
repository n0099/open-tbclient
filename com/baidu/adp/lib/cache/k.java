package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes.dex */
public interface k<T> {
    void clearAndClose(String str);

    T get(String str, String str2);

    e ks();

    l.b<T> r(String str, String str2);

    void remove(String str, String str2);

    void set(String str, String str2, T t, long j);

    void startup(String str);
}
