package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.face.IFaceResultData;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class e implements ICaptureResult {
    byte[] kP;
    byte[] kQ;
    private Bitmap kR;
    private Bitmap kS;
    int kT;
    int kU;
    IFaceResultData kV;
    long timestamp;

    private Bitmap a(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return createBitmap;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public IFaceResultData getFaceData() {
        return this.kV;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOriginPhoto() {
        if (this.kR == null && this.kP != null) {
            this.kR = a(this.kP, this.kT, this.kU);
        }
        return this.kR;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOutputPhoto() {
        if (this.kS == null && this.kQ != null) {
            this.kS = a(this.kQ, this.kT, this.kU);
        }
        return this.kS;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoHeight() {
        return this.kU;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoWidth() {
        return this.kT;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public void release() {
        if (this.kR != null && !this.kR.isRecycled()) {
            this.kR.recycle();
            this.kR = null;
        }
        if (this.kS == null || this.kS.isRecycled()) {
            return;
        }
        this.kS.recycle();
        this.kS = null;
    }
}
