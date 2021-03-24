package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.rtc.PeerConnectionClient;
import d.b.b.e.p.l;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class LocalViewSize {
    public static LocalViewSize sInstance;
    public Context mContext = null;

    /* loaded from: classes3.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    private ImageSize countPicSize(ImageSize imageSize, int i, int i2) {
        ImageSize imageSize2 = new ImageSize();
        int i3 = imageSize.height;
        int i4 = imageSize.width;
        if (i / i2 > i3 / i4) {
            imageSize2.height = i3;
            int i5 = (i3 * i2) / i;
            imageSize2.width = i5;
            if (i5 == 0) {
                imageSize2.height = 324;
                imageSize2.width = 162;
            }
        } else {
            imageSize2.width = i4;
            imageSize2.height = (i4 * i) / i2;
        }
        return imageSize2;
    }

    public static LocalViewSize getInstance() {
        if (sInstance == null) {
            sInstance = new LocalViewSize();
        }
        return sInstance;
    }

    public int getEquipmentWidth() {
        int k = l.k(this.mContext);
        if (k >= 1080) {
            return 1080;
        }
        if (k < 720 || k >= 1080) {
            return 480;
        }
        return PeerConnectionClient.HD_VIDEO_HEIGHT;
    }

    public int getGroupHeaderSize() {
        return 600;
    }

    public ImageSize getMsgBPicMaxSize() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = l.i(this.mContext);
        imageSize.width = l.k(this.mContext);
        return imageSize;
    }

    public int getMsgBPicMaxSizeInt() {
        ImageSize msgBPicMaxSize = getMsgBPicMaxSize();
        int i = msgBPicMaxSize.height;
        int i2 = msgBPicMaxSize.width;
        return i >= i2 ? i : i2;
    }

    public ImageSize getMsgBPicShowSize(ImageSize imageSize, int i, int i2) {
        if (i <= imageSize.height / 2 && i2 <= imageSize.width / 2) {
            ImageSize imageSize2 = new ImageSize();
            imageSize2.height = i;
            imageSize2.width = i2;
            return imageSize2;
        }
        return countPicSize(imageSize, i, i2);
    }

    public ImageSize getMsgSPicMaxSize() {
        int k = l.k(this.mContext);
        int i = 240;
        if (k < 240) {
            i = k / 3;
        } else if (k <= 320) {
            i = 80;
        } else if (k <= 480) {
            i = 160;
        } else if (k > 720) {
            i = k / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public int getMsgSPicMaxSizeInt() {
        ImageSize msgSPicMaxSize = getMsgSPicMaxSize();
        int i = msgSPicMaxSize.height;
        int i2 = msgSPicMaxSize.width;
        return i >= i2 ? i : i2;
    }

    public ImageSize getMsgSPicShowSize(ImageSize imageSize, int i, int i2) {
        if (i <= imageSize.height && i2 <= imageSize.width) {
            ImageSize imageSize2 = new ImageSize();
            int i3 = imageSize.height;
            int i4 = imageSize.width;
            if (i / i2 > i3 / i4) {
                imageSize2.height = i3;
                imageSize2.width = (i3 * i2) / i;
            } else {
                imageSize2.width = i4;
                imageSize2.height = (i4 * i) / i2;
            }
            return imageSize2;
        }
        return countPicSize(imageSize, i, i2);
    }

    public ImageSize getMsgUpPicMaxSize() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = 600;
        imageSize.width = 600;
        return imageSize;
    }

    public int getMsgUpPicMaxSizeInt() {
        ImageSize msgUpPicMaxSize = getMsgUpPicMaxSize();
        int i = msgUpPicMaxSize.height;
        int i2 = msgUpPicMaxSize.width;
        return i >= i2 ? i : i2;
    }

    public void initial(Context context) {
        this.mContext = context;
    }
}
