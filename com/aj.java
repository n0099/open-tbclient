package com;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache;
import com.baidu.cloudsdk.common.util.Utils;
/* loaded from: classes.dex */
public class aj implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ Uri a;
    final /* synthetic */ String b;
    final /* synthetic */ AsyncImageLoader.IAsyncImageLoaderListener cWX;
    final /* synthetic */ ImageManager d;

    public aj(ImageManager imageManager, Uri uri, String str, AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        this.d = imageManager;
        this.a = uri;
        this.b = str;
        this.cWX = iAsyncImageLoaderListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        MemoryBitmapCache memoryBitmapCache;
        a aVar;
        if (bitmap != null) {
            if (Utils.isUrl(this.a)) {
                aVar = this.d.b;
                aVar.a(this.b, bitmap);
            } else {
                memoryBitmapCache = this.d.a;
                memoryBitmapCache.a(this.b, bitmap);
            }
        }
        this.cWX.onComplete(bitmap);
    }
}
