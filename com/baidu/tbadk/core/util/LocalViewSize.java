package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {
    private static LocalViewSize a = null;
    private Context b = null;

    /* loaded from: classes.dex */
    public class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize a() {
        if (a == null) {
            a = new LocalViewSize();
        }
        return a;
    }

    private LocalViewSize() {
    }

    public void a(Context context) {
        this.b = context;
    }

    public ImageSize a(ImageSize imageSize, int i, int i2) {
        if (i > imageSize.height || i2 > imageSize.width) {
            return b(imageSize, i, i2);
        }
        ImageSize imageSize2 = new ImageSize();
        imageSize2.height = i;
        imageSize2.width = i2;
        return imageSize2;
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

    public int b() {
        int b = com.baidu.adp.lib.util.k.b(this.b);
        if (b >= 1080) {
            return 1080;
        }
        return (b < 720 || b >= 1080) ? 480 : 720;
    }

    public ImageSize c() {
        int i = 240;
        int b = com.baidu.adp.lib.util.k.b(this.b);
        BdLog.i("=======getEquipmentWidth:" + b);
        if (b < 240) {
            i = b / 3;
        } else if (b <= 320) {
            i = 80;
        } else if (b <= 480) {
            i = 160;
        } else if (b > 720) {
            i = b / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize d() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.k.c(this.b);
        imageSize.width = com.baidu.adp.lib.util.k.b(this.b);
        return imageSize;
    }

    public int e() {
        ImageSize c = c();
        return c.height >= c.width ? c.height : c.width;
    }
}
