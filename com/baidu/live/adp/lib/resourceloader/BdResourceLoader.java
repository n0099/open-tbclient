package com.baidu.live.adp.lib.resourceloader;

import android.graphics.Bitmap;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.image.loader.ImageLoaderManager;
import com.baidu.live.adp.lib.image.loader.interfaces.GenerateImageAddressImpl;
import com.baidu.live.adp.lib.image.loader.interfaces.IGenerateImageAddress;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoader;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener;
import com.baidu.live.adp.widget.imageview.BdImage;
/* loaded from: classes6.dex */
public class BdResourceLoader {
    private static BdResourceLoader sInstance;
    private IImageLoader mImageLoader = ImageLoaderManager.getInstance().buildImageLoader();
    private IGenerateImageAddress mGenImgAddress = new GenerateImageAddressImpl();

    public static BdResourceLoader getInstance() {
        if (sInstance == null) {
            synchronized (BdResourceLoader.class) {
                if (sInstance == null) {
                    sInstance = new BdResourceLoader();
                }
            }
        }
        return sInstance;
    }

    private BdResourceLoader() {
    }

    public <T> Object loadResource(String str, int i, BdResourceCallback<T> bdResourceCallback, BdUniqueId bdUniqueId) {
        return realLoadResource(str, i, bdResourceCallback);
    }

    private Object realLoadResource(String str, int i, final BdResourceCallback bdResourceCallback) {
        String realGenerateAddress = realGenerateAddress(str, i);
        if (i == 39) {
            this.mImageLoader.loadBlurImage(realGenerateAddress, genCacheKey(str, i), new IImageLoaderListener() { // from class: com.baidu.live.adp.lib.resourceloader.BdResourceLoader.1
                @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                public void onLoadComplete(String str2, Bitmap bitmap) {
                    if (bdResourceCallback != null) {
                        if (bitmap != null) {
                        }
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bdResourceCallback.onLoaded(new BdImage(bitmap, false), str2, -1);
                        }
                    }
                }
            });
            return null;
        }
        this.mImageLoader.loadImage(realGenerateAddress, new IImageLoaderListener() { // from class: com.baidu.live.adp.lib.resourceloader.BdResourceLoader.2
            @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
            public void onLoadComplete(String str2, Bitmap bitmap) {
                if (bdResourceCallback != null) {
                    if (bitmap != null) {
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bdResourceCallback.onLoaded(new BdImage(bitmap, false), str2, -1);
                    }
                }
            }
        });
        return null;
    }

    public <T> void cancelLoad(String str, int i, BdResourceCallback<T> bdResourceCallback) {
        this.mImageLoader.cancelLoad(str);
    }

    public Object loadResourceFromMemery(String str, int i, Object... objArr) {
        return null;
    }

    public String generateAddress(String str, int i) {
        return realGenerateAddress(str, i);
    }

    private String realGenerateAddress(String str, int i) {
        return this.mGenImgAddress.generateUrl(str, i);
    }

    public String genCacheKey(String str, int i) {
        if (str == null) {
            str = "";
        }
        return str + "|||" + i;
    }
}
