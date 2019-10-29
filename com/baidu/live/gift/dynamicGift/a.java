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
/* loaded from: classes6.dex */
public class a {
    private int abA;
    private AlaDynamicGiftAnimationView.a abm;
    private d abr;
    private int abw;
    private int abz;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private final int abp = 24;
    private final int abq = 5;
    private double abt = 100.0d;
    private int abu = 1;
    private int abv = 0;
    private float abx = 1.0f;
    private int aby = 0;
    private boolean abC = false;
    private b abB = new b();

    public void setScreen(int i, int i2) {
        this.abw = i;
        this.mScreenHeight = i2;
        if (this.abB != null) {
            this.abB.setScreen(this.abw, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.abv = 0;
            this.abC = false;
            this.aby = 0;
            this.abr = cVar.Wm.Wl;
            this.mFrameCount = this.abr.frame_count;
            this.abu = this.abr.repeatCount;
            this.mImageWidth = this.abr.width;
            this.mImageHeight = this.abr.height;
            this.abt = (1.0d / this.abr.frame_rate) * 1000.0d;
            this.abx = qL();
            this.abA = (int) (this.abr.oppositeX * this.abw);
            this.abz = (int) (this.abr.oppositeY * this.mScreenHeight);
            if (this.abB != null) {
                this.abB.onDestroy();
                this.abB = null;
            }
            this.abB = new b();
            this.abB.setScreen(this.abw, this.mScreenHeight);
            this.abB.a(cVar);
        }
    }

    public void f(Canvas canvas) {
        RectF rectF;
        if (qM()) {
            if (this.abu <= 1) {
                if (this.abm != null) {
                    this.abm.qK();
                    return;
                }
                return;
            }
            this.abv = 0;
            this.abu--;
        }
        if (this.abm != null) {
            if (this.abv == 0 && !this.abC) {
                this.abC = true;
                this.abm.qJ();
            } else {
                this.abm.bq(this.abv);
            }
        }
        c br = this.abB.br(this.abv);
        if (br == null || br.bitmap == null || br.bitmap.isRecycled()) {
            if (this.aby > 5) {
                if (this.abm != null) {
                    this.abm.qK();
                }
            } else if (this.aby > 1) {
                this.abB.qR();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.abB != null && this.abB.getHandler() != null) {
                this.abB.getHandler().sendMessage(obtain);
            }
            this.aby++;
            return;
        }
        this.abv++;
        float width = br.acb * br.bitmap.getWidth() * this.abx;
        float height = br.acb * br.bitmap.getHeight() * this.abx;
        canvas.save();
        if (this.abA + width > this.abw) {
            this.abA = (int) (this.abw - width);
        }
        if (this.abz + height > this.mScreenHeight) {
            this.abz = (int) (this.mScreenHeight - height);
        }
        if (this.abr.isBottomMargin()) {
            rectF = new RectF(this.abA, (this.mScreenHeight - height) - this.abz, width + this.abA, this.mScreenHeight - this.abz);
        } else {
            rectF = new RectF(this.abA, this.abz, width + this.abA, height + this.abz);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!br.bitmap.isRecycled()) {
                canvas.drawBitmap(br.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        br.acc = true;
        this.abB.cv(br.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.abB.getHandler().sendMessage(obtain2);
    }

    private float qL() {
        float f = this.abw > this.mScreenHeight ? (this.abw * 1.0f) / 1334.0f : (this.abw * 1.0f) / 750.0f;
        if (this.abw > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean qM() {
        return this.abv + 1 >= this.mFrameCount;
    }

    public void release() {
        this.abB.clearCache();
    }

    public boolean qN() {
        return this.abB.qN();
    }

    public double qO() {
        return this.abt;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.abm = aVar;
    }
}
