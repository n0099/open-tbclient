package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize DW = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize lV() {
        if (DW == null) {
            DW = new LocalViewSize();
        }
        return DW;
    }

    private LocalViewSize() {
    }

    public void l(Context context) {
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
        } else {
            imageSize2.width = imageSize.width;
            imageSize2.height = (imageSize2.width * i) / i2;
        }
        return imageSize2;
    }

    public int lW() {
        int n = com.baidu.adp.lib.util.m.n(this.mContext);
        if (n >= 1080) {
            return 1080;
        }
        return (n < 720 || n >= 1080) ? 480 : 720;
    }

    public ImageSize lX() {
        int i = 240;
        int n = com.baidu.adp.lib.util.m.n(this.mContext);
        if (n < 240) {
            i = n / 3;
        } else if (n <= 320) {
            i = 80;
        } else if (n <= 480) {
            i = 160;
        } else if (n > 720) {
            i = n / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize lY() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.m.o(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.m.n(this.mContext);
        return imageSize;
    }

    public int lZ() {
        ImageSize lX = lX();
        return lX.height >= lX.width ? lX.height : lX.width;
    }
}
