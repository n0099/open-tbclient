package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize aeS = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize uO() {
        if (aeS == null) {
            aeS = new LocalViewSize();
        }
        return aeS;
    }

    private LocalViewSize() {
    }

    public void ad(Context context) {
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

    public int uP() {
        int af = com.baidu.adp.lib.util.k.af(this.mContext);
        if (af >= 1080) {
            return 1080;
        }
        return (af < 720 || af >= 1080) ? 480 : 720;
    }

    public ImageSize uQ() {
        int i = 240;
        int af = com.baidu.adp.lib.util.k.af(this.mContext);
        if (af < 240) {
            i = af / 3;
        } else if (af <= 320) {
            i = 80;
        } else if (af <= 480) {
            i = 160;
        } else if (af > 720) {
            i = af / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize uR() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.k.ag(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.k.af(this.mContext);
        return imageSize;
    }

    public int uS() {
        ImageSize uQ = uQ();
        return uQ.height >= uQ.width ? uQ.height : uQ.width;
    }
}
