package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize apK = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize yQ() {
        if (apK == null) {
            apK = new LocalViewSize();
        }
        return apK;
    }

    private LocalViewSize() {
    }

    public void ag(Context context) {
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

    public int yR() {
        int ah = com.baidu.adp.lib.util.l.ah(this.mContext);
        if (ah >= 1080) {
            return 1080;
        }
        if (ah < 720 || ah >= 1080) {
            return com.baidu.sapi2.biometrics.liveness.camera.a.d;
        }
        return 720;
    }

    public ImageSize yS() {
        int i = 240;
        int ah = com.baidu.adp.lib.util.l.ah(this.mContext);
        if (ah < 240) {
            i = ah / 3;
        } else if (ah <= 320) {
            i = 80;
        } else if (ah <= 480) {
            i = 160;
        } else if (ah > 720) {
            i = ah / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize yT() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.l.aj(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.l.ah(this.mContext);
        return imageSize;
    }

    public int yU() {
        ImageSize yS = yS();
        return yS.height >= yS.width ? yS.height : yS.width;
    }
}
