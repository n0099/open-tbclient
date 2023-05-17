package com.baidu.pass.main.facesdk.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
/* loaded from: classes3.dex */
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

    public BDFaceImageInstance(Bitmap bitmap) {
        this.index = 0L;
        if (bitmap != null) {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            createInt(iArr, bitmap.getHeight(), bitmap.getWidth(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGRA.ordinal(), 0.0f, 0);
        }
    }

    public BDFaceImageInstance(byte[] bArr, int i, int i2, int i3) {
        this.index = 0L;
        this.height = i;
        this.width = i2;
        this.data = bArr;
        this.imageType = BDFaceSDKCommon.BDFaceImageType.values()[i3];
    }

    public BDFaceImageInstance(byte[] bArr, int i, int i2, BDFaceSDKCommon.BDFaceImageType bDFaceImageType, float f, int i3) {
        this.index = 0L;
        if (bArr == null || i <= 0 || i2 <= 0) {
            return;
        }
        create(bArr, i, i2, bDFaceImageType.ordinal(), f, i3);
    }

    private native int create(byte[] bArr, int i, int i2, int i3, float f, int i4);

    private native int createInt(int[] iArr, int i, int i2, int i3, float f, int i4);

    public native int destory();

    public native String getBase64();

    public native BDFaceImageInstance getImage();

    public native String getSec(Context context, boolean z, int i);
}
