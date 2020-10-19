package com.baidu.android.imsdk;

import android.util.LruCache;
/* loaded from: classes5.dex */
public class ChatObjectCache {
    private static ChatObjectCache mInstance = null;
    private LruCache<ChatObject, Object> mCache;

    private ChatObjectCache() {
        this.mCache = null;
        this.mCache = new LruCache<>(100);
    }

    public static ChatObjectCache getInstance() {
        synchronized (ChatObject.class) {
            if (mInstance == null) {
                mInstance = new ChatObjectCache();
            }
        }
        return mInstance;
    }

    public boolean put(ChatObject chatObject, Object obj) {
        if (chatObject == null) {
            return false;
        }
        this.mCache.put(chatObject, obj);
        return true;
    }

    public Object get(ChatObject chatObject) {
        if (chatObject == null) {
            return null;
        }
        return this.mCache.get(chatObject);
    }

    public Object remove(ChatObject chatObject) {
        return this.mCache.remove(chatObject);
    }

    public void removeAll() {
        this.mCache.evictAll();
    }
}
