package com.baidu.android.imsdk;

import android.util.LruCache;
/* loaded from: classes2.dex */
public class ChatObjectCache {
    public static ChatObjectCache mInstance;
    public LruCache<ChatObject, Object> mCache;

    public ChatObjectCache() {
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

    public Object get(ChatObject chatObject) {
        if (chatObject == null) {
            return null;
        }
        return this.mCache.get(chatObject);
    }

    public boolean put(ChatObject chatObject, Object obj) {
        if (chatObject == null) {
            return false;
        }
        this.mCache.put(chatObject, obj);
        return true;
    }

    public Object remove(ChatObject chatObject) {
        return this.mCache.remove(chatObject);
    }

    public void removeAll() {
        this.mCache.evictAll();
    }
}
