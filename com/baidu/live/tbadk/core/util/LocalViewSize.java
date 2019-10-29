package com.baidu.live.tbadk.core.util;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.location.BDLocation;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class LocalViewSize {
    private static LocalViewSize sInstance = null;
    private Context mContext = null;

    /* loaded from: classes6.dex */
    public static class ImageSize implements Serializable {
        public int height;
        public int width;
    }

    public static LocalViewSize getInstance() {
        if (sInstance == null) {
            sInstance = new LocalViewSize();
        }
        return sInstance;
    }

    private LocalViewSize() {
    }

    public void initial(Context context) {
        this.mContext = context;
    }

    public ImageSize getMsgUpPicMaxSize() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = 600;
        imageSize.width = 600;
        return imageSize;
    }

    public int getMsgUpPicMaxSizeInt() {
        ImageSize msgUpPicMaxSize = getMsgUpPicMaxSize();
        return msgUpPicMaxSize.height >= msgUpPicMaxSize.width ? msgUpPicMaxSize.height : msgUpPicMaxSize.width;
    }

    public int getMsgBPicMaxSizeInt() {
        ImageSize msgBPicMaxSize = getMsgBPicMaxSize();
        return msgBPicMaxSize.height >= msgBPicMaxSize.width ? msgBPicMaxSize.height : msgBPicMaxSize.width;
    }

    public ImageSize getMsgSPicShowSize(ImageSize imageSize, int i, int i2) {
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
        return countPicSize(imageSize, i, i2);
    }

    public ImageSize getMsgBPicShowSize(ImageSize imageSize, int i, int i2) {
        if (i > imageSize.height / 2 || i2 > imageSize.width / 2) {
            return countPicSize(imageSize, i, i2);
        }
        ImageSize imageSize2 = new ImageSize();
        imageSize2.height = i;
        imageSize2.width = i2;
        return imageSize2;
    }

    private ImageSize countPicSize(ImageSize imageSize, int i, int i2) {
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

    public int getEquipmentWidth() {
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
        if (equipmentWidth >= 1080) {
            return 1080;
        }
        if (equipmentWidth < 720 || equipmentWidth >= 1080) {
            return CameraInterface.DEFAULT_PREVIEW_HEIGHT;
        }
        return 720;
    }

    public ImageSize getMsgSPicMaxSize() {
        int i = 240;
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
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

    public ImageSize getMsgBPicMaxSize() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = BdUtilHelper.getEquipmentHeight(this.mContext);
        imageSize.width = BdUtilHelper.getEquipmentWidth(this.mContext);
        return imageSize;
    }

    public int getMsgSPicMaxSizeInt() {
        ImageSize msgSPicMaxSize = getMsgSPicMaxSize();
        return msgSPicMaxSize.height >= msgSPicMaxSize.width ? msgSPicMaxSize.height : msgSPicMaxSize.width;
    }

    public int getGroupHeaderSize() {
        return 600;
    }
}
