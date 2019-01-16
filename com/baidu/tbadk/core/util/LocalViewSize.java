package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.location.BDLocation;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize aBo = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize Dp() {
        if (aBo == null) {
            aBo = new LocalViewSize();
        }
        return aBo;
    }

    private LocalViewSize() {
    }

    public void aN(Context context) {
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
                imageSize2.width = BDLocation.TypeServerDecryptError;
            }
        } else {
            imageSize2.width = imageSize.width;
            imageSize2.height = (imageSize2.width * i) / i2;
        }
        return imageSize2;
    }

    public int Dq() {
        int aO = com.baidu.adp.lib.util.l.aO(this.mContext);
        if (aO >= 1080) {
            return 1080;
        }
        return (aO < 720 || aO >= 1080) ? 480 : 720;
    }

    public ImageSize Dr() {
        int i = 240;
        int aO = com.baidu.adp.lib.util.l.aO(this.mContext);
        if (aO < 240) {
            i = aO / 3;
        } else if (aO <= 320) {
            i = 80;
        } else if (aO <= 480) {
            i = 160;
        } else if (aO > 720) {
            i = aO / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize Ds() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.l.aQ(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.l.aO(this.mContext);
        return imageSize;
    }

    public int Dt() {
        ImageSize Dr = Dr();
        return Dr.height >= Dr.width ? Dr.height : Dr.width;
    }
}
