package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes.dex */
public interface k<T> {
    void clearAndClose(String str);

    e fb();

    T get(String str, String str2);

    l.b<T> k(String str, String str2);

    void remove(String str, String str2);

    void set(String str, String str2, T t, long j);

    void startup(String str);
}
