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
    final /* synthetic */ ImageManager d;
    final /* synthetic */ AsyncImageLoader.IAsyncImageLoaderListener eOK;
    final /* synthetic */ Uri mP;

    public aj(ImageManager imageManager, Uri uri, String str, AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        this.d = imageManager;
        this.mP = uri;
        this.b = str;
        this.eOK = iAsyncImageLoaderListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
    public void onComplete(Bitmap bitmap) {
        MemoryBitmapCache memoryBitmapCache;
        a aVar;
        if (bitmap != null) {
            if (Utils.isUrl(this.mP)) {
                aVar = this.d.b;
                aVar.a(this.b, bitmap);
            } else {
                memoryBitmapCache = this.d.a;
                memoryBitmapCache.a(this.b, bitmap);
            }
        }
        this.eOK.onComplete(bitmap);
    }
}
