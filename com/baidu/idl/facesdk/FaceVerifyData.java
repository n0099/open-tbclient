package com.baidu.idl.facesdk;
/* loaded from: classes2.dex */
public class FaceVerifyData {
    public int cols;
    public byte[] mRegDigest;
    public int[] mRegImg;
    public int[] mRegLdmk;
    public int nPoints;
    public int rows;

    public FaceVerifyData() {
    }

    public FaceVerifyData(int[] iArr, int[] iArr2, byte[] bArr, int i2, int i3, int i4) {
        this.mRegImg = iArr;
        this.mRegLdmk = iArr2;
        this.mRegDigest = bArr;
        this.rows = i2;
        this.cols = i3;
        this.nPoints = i4;
    }
}
