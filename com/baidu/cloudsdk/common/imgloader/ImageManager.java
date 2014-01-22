package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.common.util.Validator;
import com.bg;
import com.j;
/* loaded from: classes.dex */
public class ImageManager {
    public static final int DEFAULT_HIT_COUNT_REQUIRED = 1;
    public static final int DEFAULT_MAX_MEMCACHE_SIZE = 20;
    public static final String DEFAULT_STORAGE_PATH = Environment.getExternalStorageDirectory().getPath() + "/baidu/.imagecache/";
    private static ImageManager d;
    private int c = 19656;
    private MemoryBitmapCache a = new MemoryBitmapCache(20);
    private bg b = new bg(DEFAULT_STORAGE_PATH, 1, this.c, this.a);

    private ImageManager() {
    }

    public static void clean() {
        if (d != null) {
            d.a.a();
            d = null;
        }
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
        Bitmap a = this.a.a(md5);
        if (a == null && Utils.isUrl(uri)) {
            a = this.b.b(md5);
        }
        if (a != null) {
            iAsyncImageLoaderListener.onComplete(a);
        } else {
            new AsyncImageLoader(context, this.c, new j(this, uri, md5, iAsyncImageLoaderListener)).execute(uri);
        }
    }

    public ImageManager setHitCountRequired(int i) {
        this.b.b(i);
        return this;
    }

    public ImageManager setMaxMemCacheSize(int i) {
        this.a.a(i);
        return this;
    }

    public ImageManager setMaxNumOfPixels(int i) {
        this.c = i;
        this.b.a(i);
        return this;
    }

    public ImageManager setMemCacheEvictPolicy(MemoryBitmapCache.IEvictPolicy iEvictPolicy) {
        this.a.a(iEvictPolicy);
        return this;
    }

    public ImageManager setStorageDir(String str) {
        this.b.a(str);
        return this;
    }
}
