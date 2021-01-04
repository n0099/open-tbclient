package com.baidu.live.adp.lib.image.loader.interfaces;
/* loaded from: classes11.dex */
public interface IImageLoader {
    void cancelLoad(String str);

    void loadBlurImage(String str, String str2, IImageLoaderListener iImageLoaderListener);

    void loadImage(String str, IImageLoaderListener iImageLoaderListener);
}
