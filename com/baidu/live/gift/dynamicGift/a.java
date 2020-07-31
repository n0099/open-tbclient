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
    private AlaDynamicGiftAnimationView.a aOb;
    private d aOe;
    private int aOh;
    private int aOk;
    private int aOl;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aOf = 100.0d;
    private int mRepeatCount = 1;
    private int aOg = 0;
    private float aOi = 1.0f;
    private int aOj = 0;
    private boolean aOn = false;
    private b aOm = new b();

    public void setScreen(int i, int i2) {
        this.aOh = i;
        this.mScreenHeight = i2;
        if (this.aOm != null) {
            this.aOm.setScreen(this.aOh, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aOg = 0;
            this.aOn = false;
            this.aOj = 0;
            this.aOe = cVar.aHB.aHA;
            this.mFrameCount = this.aOe.frame_count;
            this.mRepeatCount = this.aOe.repeatCount;
            this.mImageWidth = this.aOe.width;
            this.mImageHeight = this.aOe.height;
            this.aOf = (1.0d / this.aOe.frame_rate) * 1000.0d;
            this.aOi = AN();
            this.aOl = (int) (this.aOe.oppositeX * this.aOh);
            this.aOk = (int) (this.aOe.oppositeY * this.mScreenHeight);
            if (this.aOm != null) {
                this.aOm.onDestroy();
                this.aOm = null;
            }
            this.aOm = new b();
            this.aOm.setScreen(this.aOh, this.mScreenHeight);
            this.aOm.b(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (AO()) {
            if (this.mRepeatCount <= 1) {
                if (this.aOb != null) {
                    this.aOb.AM();
                    return;
                }
                return;
            }
            this.aOg = 0;
            this.mRepeatCount--;
        }
        if (this.aOb != null) {
            if (this.aOg == 0 && !this.aOn) {
                this.aOn = true;
                this.aOb.AL();
            } else {
                this.aOb.cu(this.aOg);
            }
        }
        c cv = this.aOm.cv(this.aOg);
        if (cv == null || cv.bitmap == null || cv.bitmap.isRecycled()) {
            if (this.aOj > 5) {
                if (this.aOb != null) {
                    this.aOb.AM();
                }
            } else if (this.aOj > 1) {
                this.aOm.AT();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aOm != null && this.aOm.getHandler() != null) {
                this.aOm.getHandler().sendMessage(obtain);
            }
            this.aOj++;
            return;
        }
        this.aOg++;
        float width = cv.aOQ * cv.bitmap.getWidth() * this.aOi;
        float height = cv.aOQ * cv.bitmap.getHeight() * this.aOi;
        canvas.save();
        if (this.aOl + width > this.aOh) {
            this.aOl = (int) (this.aOh - width);
        }
        if (this.aOk + height > this.mScreenHeight) {
            this.aOk = (int) (this.mScreenHeight - height);
        }
        if (this.aOe.isBottomMargin()) {
            rectF = new RectF(this.aOl, (this.mScreenHeight - height) - this.aOk, width + this.aOl, this.mScreenHeight - this.aOk);
        } else {
            rectF = new RectF(this.aOl, this.aOk, width + this.aOl, height + this.aOk);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!cv.bitmap.isRecycled()) {
                canvas.drawBitmap(cv.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        cv.aOR = true;
        this.aOm.ff(cv.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aOm.getHandler().sendMessage(obtain2);
    }

    private float AN() {
        float f = this.aOh > this.mScreenHeight ? (this.aOh * 1.0f) / 1334.0f : (this.aOh * 1.0f) / 750.0f;
        if (this.aOh > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean AO() {
        return this.aOg + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aOm != null) {
            this.aOm.clearCache();
        }
    }

    public boolean AP() {
        return this.aOm.AP();
    }

    public double AQ() {
        return this.aOf;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aOb = aVar;
    }
}
