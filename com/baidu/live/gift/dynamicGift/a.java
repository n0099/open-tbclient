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
/* loaded from: classes11.dex */
public class a {
    private int bdD;
    private int bdF;
    private int bdG;
    private AlaDynamicGiftAnimationView.a bdw;
    private d bdz;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double bdA = 100.0d;
    private int bdB = 1;
    private int bdC = 0;
    private float bdE = 1.0f;
    private int mDropCount = 0;
    private boolean bdI = false;
    private b bdH = new b();

    public void setScreen(int i, int i2) {
        this.bdD = i;
        this.mScreenHeight = i2;
        if (this.bdH != null) {
            this.bdH.setScreen(this.bdD, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.bdC = 0;
            this.bdI = false;
            this.mDropCount = 0;
            this.bdz = cVar.aVs.aVq;
            this.mFrameCount = this.bdz.frame_count;
            this.bdB = this.bdz.repeatCount;
            this.mImageWidth = this.bdz.width;
            this.mImageHeight = this.bdz.height;
            this.bdA = (1.0d / this.bdz.frame_rate) * 1000.0d;
            this.bdE = GN();
            this.bdG = (int) (this.bdz.oppositeX * this.bdD);
            this.bdF = (int) (this.bdz.oppositeY * this.mScreenHeight);
            if (this.bdH != null) {
                this.bdH.onDestroy();
                this.bdH = null;
            }
            this.bdH = new b();
            this.bdH.setScreen(this.bdD, this.mScreenHeight);
            this.bdH.c(cVar);
        }
    }

    public void h(Canvas canvas) {
        RectF rectF;
        if (GO()) {
            if (this.bdB <= 1) {
                if (this.bdw != null) {
                    this.bdw.GM();
                    return;
                }
                return;
            }
            this.bdC = 0;
            this.bdB--;
        }
        if (this.bdw != null) {
            if (this.bdC == 0 && !this.bdI) {
                this.bdI = true;
                this.bdw.GL();
            } else {
                this.bdw.dh(this.bdC);
            }
        }
        c di = this.bdH.di(this.bdC);
        if (di == null || di.bitmap == null || di.bitmap.isRecycled()) {
            if (this.mDropCount > 5) {
                if (this.bdw != null) {
                    this.bdw.GM();
                }
            } else if (this.mDropCount > 1) {
                this.bdH.GT();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.bdH != null && this.bdH.getHandler() != null) {
                this.bdH.getHandler().sendMessage(obtain);
            }
            this.mDropCount++;
            return;
        }
        this.bdC++;
        float width = di.bep * di.bitmap.getWidth() * this.bdE;
        float height = di.bep * di.bitmap.getHeight() * this.bdE;
        canvas.save();
        if (this.bdG + width > this.bdD) {
            this.bdG = (int) (this.bdD - width);
        }
        if (this.bdF + height > this.mScreenHeight) {
            this.bdF = (int) (this.mScreenHeight - height);
        }
        if (this.bdz.isBottomMargin()) {
            rectF = new RectF(this.bdG, (this.mScreenHeight - height) - this.bdF, width + this.bdG, this.mScreenHeight - this.bdF);
        } else {
            rectF = new RectF(this.bdG, this.bdF, width + this.bdG, height + this.bdF);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!di.bitmap.isRecycled()) {
                canvas.drawBitmap(di.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        di.beq = true;
        this.bdH.gD(di.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.bdH.getHandler().sendMessage(obtain2);
    }

    private float GN() {
        float f = this.bdD > this.mScreenHeight ? (this.bdD * 1.0f) / 1334.0f : (this.bdD * 1.0f) / 750.0f;
        if (this.bdD > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean GO() {
        return this.bdC + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.bdH != null) {
            this.bdH.clearCache();
        }
    }

    public boolean GP() {
        return this.bdH.GP();
    }

    public double GQ() {
        return this.bdA;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.bdw = aVar;
    }
}
