package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize aag = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize uB() {
        if (aag == null) {
            aag = new LocalViewSize();
        }
        return aag;
    }

    private LocalViewSize() {
    }

    public void G(Context context) {
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

    public int uC() {
        int I = com.baidu.adp.lib.util.k.I(this.mContext);
        if (I >= 1080) {
            return 1080;
        }
        return (I < 720 || I >= 1080) ? 480 : 720;
    }

    public ImageSize uD() {
        int i = 240;
        int I = com.baidu.adp.lib.util.k.I(this.mContext);
        if (I < 240) {
            i = I / 3;
        } else if (I <= 320) {
            i = 80;
        } else if (I <= 480) {
            i = 160;
        } else if (I > 720) {
            i = I / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize uE() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.k.J(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.k.I(this.mContext);
        return imageSize;
    }

    public int uF() {
        ImageSize uD = uD();
        return uD.height >= uD.width ? uD.height : uD.width;
    }
}
