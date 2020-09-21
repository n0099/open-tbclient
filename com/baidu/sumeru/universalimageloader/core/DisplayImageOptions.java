package com.baidu.sumeru.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.baidu.sumeru.universalimageloader.core.assist.ImageScaleType;
import com.baidu.sumeru.universalimageloader.core.display.BitmapDisplayer;
import com.baidu.sumeru.universalimageloader.core.process.BitmapProcessor;
/* loaded from: classes9.dex */
public final class DisplayImageOptions {
    private final boolean cacheInMemory;
    private final boolean cacheOnDisc;
    private final boolean considerExifParams;
    private final BitmapFactory.Options decodingOptions;
    private final int delayBeforeLoading;
    private final BitmapDisplayer displayer;
    private final Object extraForDownloader;
    private final Handler handler;
    private final Drawable imageForEmptyUri;
    private final Drawable imageOnFail;
    private final Drawable imageOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final ImageScaleType imageScaleType;
    private final boolean isSyncLoading;
    private final BitmapProcessor postProcessor;
    private final BitmapProcessor preProcessor;
    private final boolean resetViewBeforeLoading;

    private DisplayImageOptions(Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisc = builder.cacheOnDisc;
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }

    public boolean shouldShowImageOnLoading() {
        return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
    }

    public boolean shouldShowImageForEmptyUri() {
        return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
    }

    public boolean shouldShowImageOnFail() {
        return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
    }

    public boolean shouldPreProcess() {
        return this.preProcessor != null;
    }

    public boolean shouldPostProcess() {
        return this.postProcessor != null;
    }

    public boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    public Drawable getImageOnLoading(Resources resources) {
        return this.imageResOnLoading != 0 ? resources.getDrawable(this.imageResOnLoading) : this.imageOnLoading;
    }

    public Drawable getImageForEmptyUri(Resources resources) {
        return this.imageResForEmptyUri != 0 ? resources.getDrawable(this.imageResForEmptyUri) : this.imageForEmptyUri;
    }

    public Drawable getImageOnFail(Resources resources) {
        return this.imageResOnFail != 0 ? resources.getDrawable(this.imageResOnFail) : this.imageOnFail;
    }

    public boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public boolean isCacheOnDisc() {
        return this.cacheOnDisc;
    }

    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    public BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    public BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public Handler getHandler() {
        if (this.isSyncLoading) {
            return null;
        }
        if (this.handler == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("ImageLoader.displayImage(...) must be invoked from the main thread or from Looper thread");
            }
            return new Handler();
        }
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private Drawable imageOnLoading = null;
        private Drawable imageForEmptyUri = null;
        private Drawable imageOnFail = null;
        private boolean resetViewBeforeLoading = false;
        private boolean cacheInMemory = false;
        private boolean cacheOnDisc = false;
        private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        private int delayBeforeLoading = 0;
        private boolean considerExifParams = false;
        private Object extraForDownloader = null;
        private BitmapProcessor preProcessor = null;
        private BitmapProcessor postProcessor = null;
        private BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
        private Handler handler = null;
        private boolean isSyncLoading = false;

        public Builder() {
            this.decodingOptions.inPurgeable = true;
            this.decodingOptions.inInputShareable = true;
        }

        @Deprecated
        public Builder showStubImage(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        public Builder showImageOnLoading(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }

        public Builder showImageForEmptyUri(int i) {
            this.imageResForEmptyUri = i;
            return this;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        public Builder showImageOnFail(int i) {
            this.imageResOnFail = i;
            return this;
        }

        public Builder showImageOnFail(Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        public Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        public Builder resetViewBeforeLoading(boolean z) {
            this.resetViewBeforeLoading = z;
            return this;
        }

        public Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        public Builder cacheInMemory(boolean z) {
            this.cacheInMemory = z;
            return this;
        }

        public Builder cacheOnDisc() {
            this.cacheOnDisc = true;
            return this;
        }

        public Builder cacheOnDisc(boolean z) {
            this.cacheOnDisc = z;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        public Builder bitmapConfig(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.decodingOptions.inPreferredConfig = config;
            return this;
        }

        public Builder decodingOptions(BitmapFactory.Options options) {
            if (options == null) {
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            this.decodingOptions = options;
            return this;
        }

        public Builder delayBeforeLoading(int i) {
            this.delayBeforeLoading = i;
            return this;
        }

        public Builder extraForDownloader(Object obj) {
            this.extraForDownloader = obj;
            return this;
        }

        public Builder considerExifParams(boolean z) {
            this.considerExifParams = z;
            return this;
        }

        public Builder preProcessor(BitmapProcessor bitmapProcessor) {
            this.preProcessor = bitmapProcessor;
            return this;
        }

        public Builder postProcessor(BitmapProcessor bitmapProcessor) {
            this.postProcessor = bitmapProcessor;
            return this;
        }

        public Builder displayer(BitmapDisplayer bitmapDisplayer) {
            if (bitmapDisplayer == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.displayer = bitmapDisplayer;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder syncLoading(boolean z) {
            this.isSyncLoading = z;
            return this;
        }

        public Builder handler(Handler handler) {
            this.handler = handler;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions displayImageOptions) {
            this.imageResOnLoading = displayImageOptions.imageResOnLoading;
            this.imageResForEmptyUri = displayImageOptions.imageResForEmptyUri;
            this.imageResOnFail = displayImageOptions.imageResOnFail;
            this.imageOnLoading = displayImageOptions.imageOnLoading;
            this.imageForEmptyUri = displayImageOptions.imageForEmptyUri;
            this.imageOnFail = displayImageOptions.imageOnFail;
            this.resetViewBeforeLoading = displayImageOptions.resetViewBeforeLoading;
            this.cacheInMemory = displayImageOptions.cacheInMemory;
            this.cacheOnDisc = displayImageOptions.cacheOnDisc;
            this.imageScaleType = displayImageOptions.imageScaleType;
            this.decodingOptions = displayImageOptions.decodingOptions;
            this.delayBeforeLoading = displayImageOptions.delayBeforeLoading;
            this.considerExifParams = displayImageOptions.considerExifParams;
            this.extraForDownloader = displayImageOptions.extraForDownloader;
            this.preProcessor = displayImageOptions.preProcessor;
            this.postProcessor = displayImageOptions.postProcessor;
            this.displayer = displayImageOptions.displayer;
            this.handler = displayImageOptions.handler;
            this.isSyncLoading = displayImageOptions.isSyncLoading;
            return this;
        }

        public DisplayImageOptions build() {
            return new DisplayImageOptions(this);
        }
    }

    public static DisplayImageOptions createSimple() {
        return new Builder().build();
    }
}
