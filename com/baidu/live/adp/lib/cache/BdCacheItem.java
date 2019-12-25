package com.baidu.live.adp.lib.cache;
/* loaded from: classes2.dex */
public class BdCacheItem<T> {
    public long lastHitTime;
    public String nameSpace;
    public long saveTime;
    public long timeToExpire;
    public String uniqueKey;
    public T value;
}
