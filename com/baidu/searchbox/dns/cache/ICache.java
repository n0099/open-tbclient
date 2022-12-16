package com.baidu.searchbox.dns.cache;
/* loaded from: classes2.dex */
public interface ICache {
    void clear();

    String get(String str);

    boolean isEmpty();

    void put(String str, String str2);

    boolean remove(String str);
}
