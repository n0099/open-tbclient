package com.baidu.live.adp.lib.image.loader;

import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoader;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderBuilder;
/* loaded from: classes3.dex */
public class ImageLoaderManager {
    private IImageLoader mImageLoader;
    private IImageLoaderBuilder mImageLoaderBuilder;

    public static ImageLoaderManager getInstance() {
        return InstanceHolder.sInst;
    }

    private ImageLoaderManager() {
    }

    public void init(IImageLoaderBuilder iImageLoaderBuilder) {
        this.mImageLoaderBuilder = iImageLoaderBuilder;
        build();
    }

    public IImageLoader buildImageLoader() {
        if (this.mImageLoader != null) {
            return this.mImageLoader;
        }
        build();
        return this.mImageLoader;
    }

    private void build() {
        if (this.mImageLoaderBuilder == null) {
            throw new RuntimeException("ImageLoaderBuild must not be null! should invoke ImageLoaderManager.init() first~");
        }
        this.mImageLoader = this.mImageLoaderBuilder.build();
    }

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        private static final ImageLoaderManager sInst = new ImageLoaderManager();
    }
}
