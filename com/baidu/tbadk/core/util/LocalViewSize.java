package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize Wo = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize tu() {
        if (Wo == null) {
            Wo = new LocalViewSize();
        }
        return Wo;
    }

    private LocalViewSize() {
    }

    public void z(Context context) {
        this.mContext = context;
    }

    public ImageSize a(ImageSize imageSize, int i, int i2) {
        if (i <= imageSize.height && i2 <= imageSize.width) {
            ImageSize imageSize2 = new ImageSize();
            if (i / i2 > imageSize.height / imageSize.width) {
                imageSize2.height = imageSize.height;
                imageSize2.width = (imageSize2.height * i2) / i;
                return imageSize2;
            }
            imageSize2.width = imageSize.width;
            imageSize2.height = (imageSize2.width * i) / i2;
            return imageSize2;
        }
        return b(imageSize, i, i2);
    }

    private ImageSize b(ImageSize imageSize, int i, int i2) {
        ImageSize imageSize2 = new ImageSize();
        if (i / i2 > imageSize.height / imageSize.width) {
            imageSize2.height = imageSize.height;
            imageSize2.width = (imageSize2.height * i2) / i;
            if (imageSize2.width == 0) {
                imageSize2.height = 324;
                imageSize2.width = 162;
            }
        } else {
            imageSize2.width = imageSize.width;
            imageSize2.height = (imageSize2.width * i) / i2;
        }
        return imageSize2;
    }

    public int tv() {
        int B = com.baidu.adp.lib.util.k.B(this.mContext);
        if (B >= 1080) {
            return 1080;
        }
        return (B < 720 || B >= 1080) ? 480 : 720;
    }

    public ImageSize tw() {
        int i = 240;
        int B = com.baidu.adp.lib.util.k.B(this.mContext);
        if (B < 240) {
            i = B / 3;
        } else if (B <= 320) {
            i = 80;
        } else if (B <= 480) {
            i = 160;
        } else if (B > 720) {
            i = B / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize tx() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.k.C(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.k.B(this.mContext);
        return imageSize;
    }

    public int ty() {
        ImageSize tw = tw();
        return tw.height >= tw.width ? tw.height : tw.width;
    }
}
