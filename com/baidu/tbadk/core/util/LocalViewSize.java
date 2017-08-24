package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize agL = null;
    private Context mContext = null;

    /* loaded from: classes.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize vf() {
        if (agL == null) {
            agL = new LocalViewSize();
        }
        return agL;
    }

    private LocalViewSize() {
    }

    public void ae(Context context) {
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

    public int vg() {
        int ag = com.baidu.adp.lib.util.k.ag(this.mContext);
        if (ag >= 1080) {
            return 1080;
        }
        return (ag < 720 || ag >= 1080) ? 480 : 720;
    }

    public ImageSize vh() {
        int i = 240;
        int ag = com.baidu.adp.lib.util.k.ag(this.mContext);
        if (ag < 240) {
            i = ag / 3;
        } else if (ag <= 320) {
            i = 80;
        } else if (ag <= 480) {
            i = 160;
        } else if (ag > 720) {
            i = ag / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize vi() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.k.ah(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.k.ag(this.mContext);
        return imageSize;
    }

    public int vj() {
        ImageSize vh = vh();
        return vh.height >= vh.width ? vh.height : vh.width;
    }
}
