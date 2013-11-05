package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.common.util.Validator;
/* loaded from: classes.dex */
public class ImageManager {
    public static final int DEFAULT_HIT_COUNT_REQUIRED = 1;
    public static final int DEFAULT_MAX_CACHEABLE_SIZE = 512;
    public static final int DEFAULT_MAX_MEMCACHE_SIZE = 20;
    public static final String DEFAULT_STORAGE_PATH = Environment.getExternalStorageDirectory().getPath() + "/baidu/.imagecache/";
    private static ImageManager d;
    private int c = DEFAULT_MAX_CACHEABLE_SIZE;

    /* renamed from: a  reason: collision with root package name */
    private MemoryBitmapCache f822a = new MemoryBitmapCache(20);
    private bm b = new bm(DEFAULT_STORAGE_PATH, 1, this.c, this.f822a);

    private ImageManager() {
    }

    public static ImageManager getInstance() {
        if (d == null) {
            d = new ImageManager();
        }
        return d;
    }

    public String getCachedFilePath(Uri uri) {
        Validator.notNull(uri, "uri");
        return this.b.c(Utils.md5(uri.toString()));
    }

    public void loadImage(Context context, Uri uri, AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        Validator.notNull(context, "context");
        Validator.notNull(uri, "uri");
        Validator.notNull(iAsyncImageLoaderListener, "listener");
        String md5 = Utils.md5(uri.toString());
        Bitmap a2 = this.f822a.a(md5);
        if (a2 == null && Utils.isUrl(uri)) {
            a2 = this.b.b(md5);
        }
        if (a2 != null) {
            iAsyncImageLoaderListener.onComplete(a2);
        } else {
            new AsyncImageLoader(context, new j(this, uri, md5, iAsyncImageLoaderListener)).execute(uri);
        }
    }

    public ImageManager setHitCountRequired(int i) {
        this.b.b(i);
        return this;
    }

    public ImageManager setMaxCachableSize(int i) {
        this.c = i;
        this.b.a(i);
        return this;
    }

    public ImageManager setMaxMemCacheSize(int i) {
        this.f822a.a(i);
        return this;
    }

    public ImageManager setMemCacheEvictPolicy(MemoryBitmapCache.IEvictPolicy iEvictPolicy) {
        this.f822a.a(iEvictPolicy);
        return this;
    }

    public ImageManager setStorageDir(String str) {
        this.b.a(str);
        return this;
    }
}
