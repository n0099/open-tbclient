package com.baidu.live.gift.dynamicGift;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Message;
import com.baidu.live.gift.d;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView;
/* loaded from: classes4.dex */
public class a {
    private AlaDynamicGiftAnimationView.a aYQ;
    private d aYT;
    private int aYW;
    private int aYZ;
    private int aZa;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aYU = 100.0d;
    private int mRepeatCount = 1;
    private int aYV = 0;
    private float aYX = 1.0f;
    private int aYY = 0;
    private boolean aZc = false;
    private b aZb = new b();

    public void setScreen(int i, int i2) {
        this.aYW = i;
        this.mScreenHeight = i2;
        if (this.aZb != null) {
            this.aZb.setScreen(this.aYW, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aYV = 0;
            this.aZc = false;
            this.aYY = 0;
            this.aYT = cVar.aRQ.aRP;
            this.mFrameCount = this.aYT.frame_count;
            this.mRepeatCount = this.aYT.repeatCount;
            this.mImageWidth = this.aYT.width;
            this.mImageHeight = this.aYT.height;
            this.aYU = (1.0d / this.aYT.frame_rate) * 1000.0d;
            this.aYX = HM();
            this.aZa = (int) (this.aYT.oppositeX * this.aYW);
            this.aYZ = (int) (this.aYT.oppositeY * this.mScreenHeight);
            if (this.aZb != null) {
                this.aZb.onDestroy();
                this.aZb = null;
            }
            this.aZb = new b();
            this.aZb.setScreen(this.aYW, this.mScreenHeight);
            this.aZb.b(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (HN()) {
            if (this.mRepeatCount <= 1) {
                if (this.aYQ != null) {
                    this.aYQ.HL();
                    return;
                }
                return;
            }
            this.aYV = 0;
            this.mRepeatCount--;
        }
        if (this.aYQ != null) {
            if (this.aYV == 0 && !this.aZc) {
                this.aZc = true;
                this.aYQ.HK();
            } else {
                this.aYQ.es(this.aYV);
            }
        }
        c et = this.aZb.et(this.aYV);
        if (et == null || et.bitmap == null || et.bitmap.isRecycled()) {
            if (this.aYY > 5) {
                if (this.aYQ != null) {
                    this.aYQ.HL();
                }
            } else if (this.aYY > 1) {
                this.aZb.HS();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aZb != null && this.aZb.getHandler() != null) {
                this.aZb.getHandler().sendMessage(obtain);
            }
            this.aYY++;
            return;
        }
        this.aYV++;
        float width = et.aZG * et.bitmap.getWidth() * this.aYX;
        float height = et.aZG * et.bitmap.getHeight() * this.aYX;
        canvas.save();
        if (this.aZa + width > this.aYW) {
            this.aZa = (int) (this.aYW - width);
        }
        if (this.aYZ + height > this.mScreenHeight) {
            this.aYZ = (int) (this.mScreenHeight - height);
        }
        if (this.aYT.isBottomMargin()) {
            rectF = new RectF(this.aZa, (this.mScreenHeight - height) - this.aYZ, width + this.aZa, this.mScreenHeight - this.aYZ);
        } else {
            rectF = new RectF(this.aZa, this.aYZ, width + this.aZa, height + this.aYZ);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!et.bitmap.isRecycled()) {
                canvas.drawBitmap(et.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        et.aZH = true;
        this.aZb.gZ(et.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aZb.getHandler().sendMessage(obtain2);
    }

    private float HM() {
        float f = this.aYW > this.mScreenHeight ? (this.aYW * 1.0f) / 1334.0f : (this.aYW * 1.0f) / 750.0f;
        if (this.aYW > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean HN() {
        return this.aYV + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aZb != null) {
            this.aZb.clearCache();
        }
    }

    public boolean HO() {
        return this.aZb.HO();
    }

    public double HP() {
        return this.aYU;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aYQ = aVar;
    }
}
