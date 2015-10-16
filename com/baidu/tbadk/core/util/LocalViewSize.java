package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize ZN = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize ub() {
        if (ZN == null) {
            ZN = new LocalViewSize();
        }
        return ZN;
    }

    private LocalViewSize() {
    }

    public void I(Context context) {
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

    public int uc() {
        int K = com.baidu.adp.lib.util.k.K(this.mContext);
        if (K >= 1080) {
            return 1080;
        }
        return (K < 720 || K >= 1080) ? 480 : 720;
    }

    public ImageSize getMsgSPicMaxSize() {
        int i = 240;
        int K = com.baidu.adp.lib.util.k.K(this.mContext);
        if (K < 240) {
            i = K / 3;
        } else if (K <= 320) {
            i = 80;
        } else if (K <= 480) {
            i = 160;
        } else if (K > 720) {
            i = K / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize ud() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.k.L(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.k.K(this.mContext);
        return imageSize;
    }

    public int ue() {
        ImageSize msgSPicMaxSize = getMsgSPicMaxSize();
        return msgSPicMaxSize.height >= msgSPicMaxSize.width ? msgSPicMaxSize.height : msgSPicMaxSize.width;
    }
}
