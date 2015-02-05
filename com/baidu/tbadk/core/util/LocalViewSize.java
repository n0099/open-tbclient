package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize Iq = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize oM() {
        if (Iq == null) {
            Iq = new LocalViewSize();
        }
        return Iq;
    }

    private LocalViewSize() {
    }

    public void K(Context context) {
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

    public int oN() {
        int M = com.baidu.adp.lib.util.l.M(this.mContext);
        if (M >= 1080) {
            return 1080;
        }
        return (M < 720 || M >= 1080) ? 480 : 720;
    }

    public ImageSize getMsgSPicMaxSize() {
        int i = 240;
        int M = com.baidu.adp.lib.util.l.M(this.mContext);
        if (M < 240) {
            i = M / 3;
        } else if (M <= 320) {
            i = 80;
        } else if (M <= 480) {
            i = 160;
        } else if (M > 720) {
            i = M / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize oO() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.l.N(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.l.M(this.mContext);
        return imageSize;
    }

    public int oP() {
        ImageSize msgSPicMaxSize = getMsgSPicMaxSize();
        return msgSPicMaxSize.height >= msgSPicMaxSize.width ? msgSPicMaxSize.height : msgSPicMaxSize.width;
    }
}
