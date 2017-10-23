package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize afn = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize uz() {
        if (afn == null) {
            afn = new LocalViewSize();
        }
        return afn;
    }

    private LocalViewSize() {
    }

    public void ac(Context context) {
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

    public int uA() {
        int ad = com.baidu.adp.lib.util.l.ad(this.mContext);
        if (ad >= 1080) {
            return 1080;
        }
        return (ad < 720 || ad >= 1080) ? 480 : 720;
    }

    public ImageSize uB() {
        int i = 240;
        int ad = com.baidu.adp.lib.util.l.ad(this.mContext);
        if (ad < 240) {
            i = ad / 3;
        } else if (ad <= 320) {
            i = 80;
        } else if (ad <= 480) {
            i = 160;
        } else if (ad > 720) {
            i = ad / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize uC() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.l.af(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.l.ad(this.mContext);
        return imageSize;
    }

    public int uD() {
        ImageSize uB = uB();
        return uB.height >= uB.width ? uB.height : uB.width;
    }
}
