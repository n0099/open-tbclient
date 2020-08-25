package com.baidu.tbadk.core.util;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocalViewSize {
    private static LocalViewSize ejM = null;
    private Context mContext = null;

    /* loaded from: classes2.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize biN() {
        if (ejM == null) {
            ejM = new LocalViewSize();
        }
        return ejM;
    }

    private LocalViewSize() {
    }

    public void initial(Context context) {
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

    public int getEquipmentWidth() {
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        if (equipmentWidth >= 1080) {
            return 1080;
        }
        return (equipmentWidth < 720 || equipmentWidth >= 1080) ? 480 : 720;
    }

    public ImageSize biO() {
        int i = 240;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        if (equipmentWidth < 240) {
            i = equipmentWidth / 3;
        } else if (equipmentWidth <= 320) {
            i = 80;
        } else if (equipmentWidth <= 480) {
            i = 160;
        } else if (equipmentWidth > 720) {
            i = equipmentWidth / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize biP() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext);
        imageSize.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        return imageSize;
    }

    public int getMsgSPicMaxSizeInt() {
        ImageSize biO = biO();
        return biO.height >= biO.width ? biO.height : biO.width;
    }
}
