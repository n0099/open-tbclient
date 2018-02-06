package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize aVU = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize Cs() {
        if (aVU == null) {
            aVU = new LocalViewSize();
        }
        return aVU;
    }

    private LocalViewSize() {
    }

    public void an(Context context) {
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

    public int Ct() {
        int ao = com.baidu.adp.lib.util.l.ao(this.mContext);
        if (ao >= 1080) {
            return 1080;
        }
        if (ao < 720 || ao >= 1080) {
            return com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        return 720;
    }

    public ImageSize Cu() {
        int i = 240;
        int ao = com.baidu.adp.lib.util.l.ao(this.mContext);
        if (ao < 240) {
            i = ao / 3;
        } else if (ao <= 320) {
            i = 80;
        } else if (ao <= 480) {
            i = 160;
        } else if (ao > 720) {
            i = ao / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize Cv() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.l.aq(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.l.ao(this.mContext);
        return imageSize;
    }

    public int Cw() {
        ImageSize Cu = Cu();
        return Cu.height >= Cu.width ? Cu.height : Cu.width;
    }
}
