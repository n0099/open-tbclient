package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize agc = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize vc() {
        if (agc == null) {
            agc = new LocalViewSize();
        }
        return agc;
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

    public int vd() {
        int ae = com.baidu.adp.lib.util.k.ae(this.mContext);
        if (ae >= 1080) {
            return 1080;
        }
        return (ae < 720 || ae >= 1080) ? 480 : 720;
    }

    public ImageSize ve() {
        int i = 240;
        int ae = com.baidu.adp.lib.util.k.ae(this.mContext);
        if (ae < 240) {
            i = ae / 3;
        } else if (ae <= 320) {
            i = 80;
        } else if (ae <= 480) {
            i = 160;
        } else if (ae > 720) {
            i = ae / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize vf() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.k.af(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.k.ae(this.mContext);
        return imageSize;
    }

    public int vg() {
        ImageSize ve = ve();
        return ve.height >= ve.width ? ve.height : ve.width;
    }
}
