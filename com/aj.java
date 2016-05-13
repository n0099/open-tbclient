package com;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache;
import com.baidu.cloudsdk.common.util.Utils;
/* loaded from: classes.dex */
public class aj implements AsyncImageLoader.IAsyncImageLoaderListener {
    final /* synthetic */ String b;
    final /* synthetic */ Uri cO;
    final /* synthetic */ ImageManager d;
    final /* synthetic */ AsyncImageLoader.IAsyncImageLoaderListener fgG;

    public aj(ImageManager imageManager, Uri uri, String str, AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        this.d = imageManager;
        this.cO = uri;
        this.b = str;
        this.fgG = iAsyncImageLoaderListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        MemoryBitmapCache memoryBitmapCache;
        a aVar;
        if (bitmap != null) {
            if (Utils.isUrl(this.cO)) {
                aVar = this.d.b;
                aVar.a(this.b, bitmap);
            } else {
                memoryBitmapCache = this.d.a;
                memoryBitmapCache.a(this.b, bitmap);
            }
        }
        this.fgG.onComplete(bitmap);
    }
}
