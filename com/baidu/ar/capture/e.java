package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.face.IFaceResultData;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class e implements ICaptureResult {
    public byte[] le;
    public byte[] lf;
    public Bitmap lg;
    public Bitmap lh;
    public int li;
    public int lj;
    public IFaceResultData lk;
    public long timestamp;

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
        byte[] bArr;
        if (this.lg == null && (bArr = this.le) != null) {
            this.lg = a(bArr, this.li, this.lj);
        }
        return this.lg;
    }

    @Override // com.baidu.ar.capture.ICaptureResult
    public Bitmap getOutputPhoto() {
        byte[] bArr;
        if (this.lh == null && (bArr = this.lf) != null) {
            this.lh = a(bArr, this.li, this.lj);
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
        Bitmap bitmap = this.lg;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.lg.recycle();
            this.lg = null;
        }
        Bitmap bitmap2 = this.lh;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.lh.recycle();
        this.lh = null;
    }
}
