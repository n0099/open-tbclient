package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.face.IFaceResultData;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements ICaptureResult {
    byte[] le;
    byte[] lf;
    private Bitmap lg;
    private Bitmap lh;
    int li;
    int lj;
    IFaceResultData lk;
    long timestamp;

    private Bitmap a(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return createBitmap;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public IFaceResultData getFaceData() {
        return this.lk;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOriginPhoto() {
        if (this.lg == null && this.le != null) {
            this.lg = a(this.le, this.li, this.lj);
        }
        return this.lg;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOutputPhoto() {
        if (this.lh == null && this.lf != null) {
            this.lh = a(this.lf, this.li, this.lj);
        }
        return this.lh;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoHeight() {
        return this.lj;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public int getPhotoWidth() {
        return this.li;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public void release() {
        if (this.lg != null && !this.lg.isRecycled()) {
            this.lg.recycle();
            this.lg = null;
        }
        if (this.lh == null || this.lh.isRecycled()) {
            return;
        }
        this.lh.recycle();
        this.lh = null;
    }
}
