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
/* loaded from: classes3.dex */
public class a {
    private int aEB;
    private int aEC;
    private AlaDynamicGiftAnimationView.a aEs;
    private d aEv;
    private int aEy;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aEw = 100.0d;
    private int mRepeatCount = 1;
    private int aEx = 0;
    private float aEz = 1.0f;
    private int aEA = 0;
    private boolean aEE = false;
    private b aED = new b();

    public void setScreen(int i, int i2) {
        this.aEy = i;
        this.mScreenHeight = i2;
        if (this.aED != null) {
            this.aED.setScreen(this.aEy, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aEx = 0;
            this.aEE = false;
            this.aEA = 0;
            this.aEv = cVar.aym.ayl;
            this.mFrameCount = this.aEv.frame_count;
            this.mRepeatCount = this.aEv.repeatCount;
            this.mImageWidth = this.aEv.width;
            this.mImageHeight = this.aEv.height;
            this.aEw = (1.0d / this.aEv.frame_rate) * 1000.0d;
            this.aEz = yw();
            this.aEC = (int) (this.aEv.oppositeX * this.aEy);
            this.aEB = (int) (this.aEv.oppositeY * this.mScreenHeight);
            if (this.aED != null) {
                this.aED.onDestroy();
                this.aED = null;
            }
            this.aED = new b();
            this.aED.setScreen(this.aEy, this.mScreenHeight);
            this.aED.a(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (yx()) {
            if (this.mRepeatCount <= 1) {
                if (this.aEs != null) {
                    this.aEs.yv();
                    return;
                }
                return;
            }
            this.aEx = 0;
            this.mRepeatCount--;
        }
        if (this.aEs != null) {
            if (this.aEx == 0 && !this.aEE) {
                this.aEE = true;
                this.aEs.yu();
            } else {
                this.aEs.bZ(this.aEx);
            }
        }
        c ca = this.aED.ca(this.aEx);
        if (ca == null || ca.bitmap == null || ca.bitmap.isRecycled()) {
            if (this.aEA > 5) {
                if (this.aEs != null) {
                    this.aEs.yv();
                }
            } else if (this.aEA > 1) {
                this.aED.yC();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aED != null && this.aED.getHandler() != null) {
                this.aED.getHandler().sendMessage(obtain);
            }
            this.aEA++;
            return;
        }
        this.aEx++;
        float width = ca.aFg * ca.bitmap.getWidth() * this.aEz;
        float height = ca.aFg * ca.bitmap.getHeight() * this.aEz;
        canvas.save();
        if (this.aEC + width > this.aEy) {
            this.aEC = (int) (this.aEy - width);
        }
        if (this.aEB + height > this.mScreenHeight) {
            this.aEB = (int) (this.mScreenHeight - height);
        }
        if (this.aEv.isBottomMargin()) {
            rectF = new RectF(this.aEC, (this.mScreenHeight - height) - this.aEB, width + this.aEC, this.mScreenHeight - this.aEB);
        } else {
            rectF = new RectF(this.aEC, this.aEB, width + this.aEC, height + this.aEB);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!ca.bitmap.isRecycled()) {
                canvas.drawBitmap(ca.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        ca.aFh = true;
        this.aED.eq(ca.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aED.getHandler().sendMessage(obtain2);
    }

    private float yw() {
        float f = this.aEy > this.mScreenHeight ? (this.aEy * 1.0f) / 1334.0f : (this.aEy * 1.0f) / 750.0f;
        if (this.aEy > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean yx() {
        return this.aEx + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aED != null) {
            this.aED.clearCache();
        }
    }

    public boolean yy() {
        return this.aED.yy();
    }

    public double yz() {
        return this.aEw;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aEs = aVar;
    }
}
