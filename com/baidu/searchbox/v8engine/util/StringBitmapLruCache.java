package com.baidu.searchbox.v8engine.util;

import android.support.v4.util.LruCache;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.searchbox.v8engine.bean.ImageBean;
/* loaded from: classes2.dex */
public class StringBitmapLruCache extends LruCache<String, ImageBean.ImageBitmapBean> {
    public static final boolean DEBUG = false;
    public static int halfLruCacheMaxSize = 0;
    public static int BYTE_COUNT = 1024;
    public static int RULER_COUNT = 5;
    public static String TAG = "StringBitmapLruCache";

    public StringBitmapLruCache(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.util.LruCache
    public int sizeOf(String str, ImageBean.ImageBitmapBean imageBitmapBean) {
        return imageBitmapBean.getBitmapByteCount() / BYTE_COUNT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.util.LruCache
    public void entryRemoved(boolean z, String str, ImageBean.ImageBitmapBean imageBitmapBean, ImageBean.ImageBitmapBean imageBitmapBean2) {
        super.entryRemoved(z, (boolean) str, imageBitmapBean, imageBitmapBean2);
        if (WebGLImageLoader.sReferenceMap.get(str) == null) {
            imageBitmapBean.reset();
            V8Engine.notifyGCFree(imageBitmapBean.getEnginePtr(), imageBitmapBean.getBitmapByteCount());
        }
    }

    public boolean putIfMatchLruRuler(String str, ImageBean.ImageBitmapBean imageBitmapBean, int i) {
        if (halfLruCacheMaxSize == 0) {
            halfLruCacheMaxSize = maxSize() / 2;
        }
        if (i < RULER_COUNT || imageBitmapBean.getKByteCount() >= halfLruCacheMaxSize || get(str) != null) {
            return false;
        }
        put(str, imageBitmapBean);
        return true;
    }
}
