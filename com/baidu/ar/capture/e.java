package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.face.IFaceResultData;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements ICaptureResult {
    byte[] jO;
    byte[] jP;
    private Bitmap jQ;
    private Bitmap jR;
    int jS;
    int jT;
    IFaceResultData jU;
    long timestamp;

    private Bitmap a(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return createBitmap;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public IFaceResultData getFaceData() {
        return this.jU;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOriginPhoto() {
        if (this.jQ == null && this.jO != null) {
            this.jQ = a(this.jO, this.jS, this.jT);
        }
        return this.jQ;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOutputPhoto() {
        if (this.jR == null && this.jP != null) {
            this.jR = a(this.jP, this.jS, this.jT);
        }
        return this.jR;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoHeight() {
        return this.jT;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoWidth() {
        return this.jS;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public void release() {
        if (this.jQ != null && !this.jQ.isRecycled()) {
            this.jQ.recycle();
            this.jQ = null;
        }
        if (this.jR == null || this.jR.isRecycled()) {
            return;
        }
        this.jR.recycle();
        this.jR = null;
    }
}
