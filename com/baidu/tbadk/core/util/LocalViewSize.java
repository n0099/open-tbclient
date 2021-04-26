package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import d.a.c.e.p.l;
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

    private ImageSize countPicSize(ImageSize imageSize, int i2, int i3) {
        ImageSize imageSize2 = new ImageSize();
        int i4 = imageSize.height;
        int i5 = imageSize.width;
        if (i2 / i3 > i4 / i5) {
            imageSize2.height = i4;
            int i6 = (i4 * i3) / i2;
            imageSize2.width = i6;
            if (i6 == 0) {
                imageSize2.height = 324;
                imageSize2.width = 162;
            }
        } else {
            imageSize2.width = i5;
            imageSize2.height = (i5 * i2) / i3;
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
            return IdCardOcrCameraActivity.G;
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
        int i2 = msgBPicMaxSize.height;
        int i3 = msgBPicMaxSize.width;
        return i2 >= i3 ? i2 : i3;
    }

    public ImageSize getMsgBPicShowSize(ImageSize imageSize, int i2, int i3) {
        if (i2 <= imageSize.height / 2 && i3 <= imageSize.width / 2) {
            ImageSize imageSize2 = new ImageSize();
            imageSize2.height = i2;
            imageSize2.width = i3;
            return imageSize2;
        }
        return countPicSize(imageSize, i2, i3);
    }

    public ImageSize getMsgSPicMaxSize() {
        int k = l.k(this.mContext);
        int i2 = 240;
        if (k < 240) {
            i2 = k / 3;
        } else if (k <= 320) {
            i2 = 80;
        } else if (k <= 480) {
            i2 = 160;
        } else if (k > 720) {
            i2 = k / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i2;
        imageSize.width = i2;
        return imageSize;
    }

    public int getMsgSPicMaxSizeInt() {
        ImageSize msgSPicMaxSize = getMsgSPicMaxSize();
        int i2 = msgSPicMaxSize.height;
        int i3 = msgSPicMaxSize.width;
        return i2 >= i3 ? i2 : i3;
    }

    public ImageSize getMsgSPicShowSize(ImageSize imageSize, int i2, int i3) {
        if (i2 <= imageSize.height && i3 <= imageSize.width) {
            ImageSize imageSize2 = new ImageSize();
            int i4 = imageSize.height;
            int i5 = imageSize.width;
            if (i2 / i3 > i4 / i5) {
                imageSize2.height = i4;
                imageSize2.width = (i4 * i3) / i2;
            } else {
                imageSize2.width = i5;
                imageSize2.height = (i5 * i2) / i3;
            }
            return imageSize2;
        }
        return countPicSize(imageSize, i2, i3);
    }

    public ImageSize getMsgUpPicMaxSize() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = 600;
        imageSize.width = 600;
        return imageSize;
    }

    public int getMsgUpPicMaxSizeInt() {
        ImageSize msgUpPicMaxSize = getMsgUpPicMaxSize();
        int i2 = msgUpPicMaxSize.height;
        int i3 = msgUpPicMaxSize.width;
        return i2 >= i3 ? i2 : i3;
    }

    public void initial(Context context) {
        this.mContext = context;
    }
}
