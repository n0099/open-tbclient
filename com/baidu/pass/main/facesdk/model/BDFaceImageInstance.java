package com.baidu.pass.main.facesdk.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
/* loaded from: classes2.dex */
public class BDFaceImageInstance {
    public byte[] data;
    public int height;
    public BDFaceSDKCommon.BDFaceImageType imageType;
    public long index;
    public int width;

    public BDFaceImageInstance(long j) {
        this.index = 0L;
        this.index = j;
    }

    private native int create(byte[] bArr, int i2, int i3, int i4, float f2, int i5);

    private native int createInt(int[] iArr, int i2, int i3, int i4, float f2, int i5);

    public native int destory();

    public native String getBase64();

    public native BDFaceImageInstance getImage();

    public native String getSec(Context context);

    public BDFaceImageInstance(byte[] bArr, int i2, int i3, int i4) {
        this.index = 0L;
        this.height = i2;
        this.width = i3;
        this.data = bArr;
        this.imageType = BDFaceSDKCommon.BDFaceImageType.values()[i4];
    }

    public BDFaceImageInstance(byte[] bArr, int i2, int i3, BDFaceSDKCommon.BDFaceImageType bDFaceImageType, float f2, int i4) {
        this.index = 0L;
        if (bArr == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        create(bArr, i2, i3, bDFaceImageType.ordinal(), f2, i4);
    }

    public BDFaceImageInstance(Bitmap bitmap) {
        this.index = 0L;
        if (bitmap != null) {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            createInt(iArr, bitmap.getHeight(), bitmap.getWidth(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGRA.ordinal(), 0.0f, 0);
        }
    }
}
