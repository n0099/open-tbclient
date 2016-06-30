package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize WE = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize tr() {
        if (WE == null) {
            WE = new LocalViewSize();
        }
        return WE;
    }

    private LocalViewSize() {
    }

    public void y(Context context) {
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

    public int ts() {
        int A = com.baidu.adp.lib.util.k.A(this.mContext);
        if (A >= 1080) {
            return 1080;
        }
        return (A < 720 || A >= 1080) ? 480 : 720;
    }

    public ImageSize tt() {
        int i = 240;
        int A = com.baidu.adp.lib.util.k.A(this.mContext);
        if (A < 240) {
            i = A / 3;
        } else if (A <= 320) {
            i = 80;
        } else if (A <= 480) {
            i = 160;
        } else if (A > 720) {
            i = A / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize tu() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.k.B(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.k.A(this.mContext);
        return imageSize;
    }

    public int tv() {
        ImageSize tt = tt();
        return tt.height >= tt.width ? tt.height : tt.width;
    }
}
