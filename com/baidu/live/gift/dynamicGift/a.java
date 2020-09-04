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
/* loaded from: classes7.dex */
public class a {
    private int aTA;
    private AlaDynamicGiftAnimationView.a aTq;
    private d aTt;
    private int aTw;
    private int aTz;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aTu = 100.0d;
    private int mRepeatCount = 1;
    private int aTv = 0;
    private float aTx = 1.0f;
    private int aTy = 0;
    private boolean aTC = false;
    private b aTB = new b();

    public void setScreen(int i, int i2) {
        this.aTw = i;
        this.mScreenHeight = i2;
        if (this.aTB != null) {
            this.aTB.setScreen(this.aTw, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aTv = 0;
            this.aTC = false;
            this.aTy = 0;
            this.aTt = cVar.aMN.aMM;
            this.mFrameCount = this.aTt.frame_count;
            this.mRepeatCount = this.aTt.repeatCount;
            this.mImageWidth = this.aTt.width;
            this.mImageHeight = this.aTt.height;
            this.aTu = (1.0d / this.aTt.frame_rate) * 1000.0d;
            this.aTx = Gq();
            this.aTA = (int) (this.aTt.oppositeX * this.aTw);
            this.aTz = (int) (this.aTt.oppositeY * this.mScreenHeight);
            if (this.aTB != null) {
                this.aTB.onDestroy();
                this.aTB = null;
            }
            this.aTB = new b();
            this.aTB.setScreen(this.aTw, this.mScreenHeight);
            this.aTB.b(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (Gr()) {
            if (this.mRepeatCount <= 1) {
                if (this.aTq != null) {
                    this.aTq.Gp();
                    return;
                }
                return;
            }
            this.aTv = 0;
            this.mRepeatCount--;
        }
        if (this.aTq != null) {
            if (this.aTv == 0 && !this.aTC) {
                this.aTC = true;
                this.aTq.Go();
            } else {
                this.aTq.ej(this.aTv);
            }
        }
        c ek = this.aTB.ek(this.aTv);
        if (ek == null || ek.bitmap == null || ek.bitmap.isRecycled()) {
            if (this.aTy > 5) {
                if (this.aTq != null) {
                    this.aTq.Gp();
                }
            } else if (this.aTy > 1) {
                this.aTB.Gw();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aTB != null && this.aTB.getHandler() != null) {
                this.aTB.getHandler().sendMessage(obtain);
            }
            this.aTy++;
            return;
        }
        this.aTv++;
        float width = ek.aUg * ek.bitmap.getWidth() * this.aTx;
        float height = ek.aUg * ek.bitmap.getHeight() * this.aTx;
        canvas.save();
        if (this.aTA + width > this.aTw) {
            this.aTA = (int) (this.aTw - width);
        }
        if (this.aTz + height > this.mScreenHeight) {
            this.aTz = (int) (this.mScreenHeight - height);
        }
        if (this.aTt.isBottomMargin()) {
            rectF = new RectF(this.aTA, (this.mScreenHeight - height) - this.aTz, width + this.aTA, this.mScreenHeight - this.aTz);
        } else {
            rectF = new RectF(this.aTA, this.aTz, width + this.aTA, height + this.aTz);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!ek.bitmap.isRecycled()) {
                canvas.drawBitmap(ek.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        ek.aUh = true;
        this.aTB.gB(ek.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aTB.getHandler().sendMessage(obtain2);
    }

    private float Gq() {
        float f = this.aTw > this.mScreenHeight ? (this.aTw * 1.0f) / 1334.0f : (this.aTw * 1.0f) / 750.0f;
        if (this.aTw > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean Gr() {
        return this.aTv + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aTB != null) {
            this.aTB.clearCache();
        }
    }

    public boolean Gs() {
        return this.aTB.Gs();
    }

    public double Gt() {
        return this.aTu;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aTq = aVar;
    }
}
