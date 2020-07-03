package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.face.IFaceResultData;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements ICaptureResult {
    byte[] kg;
    byte[] kh;
    private Bitmap ki;
    private Bitmap kj;
    int kk;
    int kl;
    IFaceResultData km;
    long timestamp;

    private Bitmap a(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return createBitmap;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public IFaceResultData getFaceData() {
        return this.km;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOriginPhoto() {
        if (this.ki == null && this.kg != null) {
            this.ki = a(this.kg, this.kk, this.kl);
        }
        return this.ki;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOutputPhoto() {
        if (this.kj == null && this.kh != null) {
            this.kj = a(this.kh, this.kk, this.kl);
        }
        return this.kj;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoHeight() {
        return this.kl;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoWidth() {
        return this.kk;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public void release() {
        if (this.ki != null && !this.ki.isRecycled()) {
            this.ki.recycle();
            this.ki = null;
        }
        if (this.kj == null || this.kj.isRecycled()) {
            return;
        }
        this.kj.recycle();
        this.kj = null;
    }
}
