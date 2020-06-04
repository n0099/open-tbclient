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
    private AlaDynamicGiftAnimationView.a aKa;
    private d aKd;
    private int aKg;
    private int aKj;
    private int aKk;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aKe = 100.0d;
    private int mRepeatCount = 1;
    private int aKf = 0;
    private float aKh = 1.0f;
    private int aKi = 0;
    private boolean aKm = false;
    private b aKl = new b();

    public void setScreen(int i, int i2) {
        this.aKg = i;
        this.mScreenHeight = i2;
        if (this.aKl != null) {
            this.aKl.setScreen(this.aKg, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aKf = 0;
            this.aKm = false;
            this.aKi = 0;
            this.aKd = cVar.aDK.aDJ;
            this.mFrameCount = this.aKd.frame_count;
            this.mRepeatCount = this.aKd.repeatCount;
            this.mImageWidth = this.aKd.width;
            this.mImageHeight = this.aKd.height;
            this.aKe = (1.0d / this.aKd.frame_rate) * 1000.0d;
            this.aKh = zL();
            this.aKk = (int) (this.aKd.oppositeX * this.aKg);
            this.aKj = (int) (this.aKd.oppositeY * this.mScreenHeight);
            if (this.aKl != null) {
                this.aKl.onDestroy();
                this.aKl = null;
            }
            this.aKl = new b();
            this.aKl.setScreen(this.aKg, this.mScreenHeight);
            this.aKl.b(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (zM()) {
            if (this.mRepeatCount <= 1) {
                if (this.aKa != null) {
                    this.aKa.zK();
                    return;
                }
                return;
            }
            this.aKf = 0;
            this.mRepeatCount--;
        }
        if (this.aKa != null) {
            if (this.aKf == 0 && !this.aKm) {
                this.aKm = true;
                this.aKa.zJ();
            } else {
                this.aKa.ci(this.aKf);
            }
        }
        c cj = this.aKl.cj(this.aKf);
        if (cj == null || cj.bitmap == null || cj.bitmap.isRecycled()) {
            if (this.aKi > 5) {
                if (this.aKa != null) {
                    this.aKa.zK();
                }
            } else if (this.aKi > 1) {
                this.aKl.zR();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aKl != null && this.aKl.getHandler() != null) {
                this.aKl.getHandler().sendMessage(obtain);
            }
            this.aKi++;
            return;
        }
        this.aKf++;
        float width = cj.aKP * cj.bitmap.getWidth() * this.aKh;
        float height = cj.aKP * cj.bitmap.getHeight() * this.aKh;
        canvas.save();
        if (this.aKk + width > this.aKg) {
            this.aKk = (int) (this.aKg - width);
        }
        if (this.aKj + height > this.mScreenHeight) {
            this.aKj = (int) (this.mScreenHeight - height);
        }
        if (this.aKd.isBottomMargin()) {
            rectF = new RectF(this.aKk, (this.mScreenHeight - height) - this.aKj, width + this.aKk, this.mScreenHeight - this.aKj);
        } else {
            rectF = new RectF(this.aKk, this.aKj, width + this.aKk, height + this.aKj);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!cj.bitmap.isRecycled()) {
                canvas.drawBitmap(cj.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        cj.aKQ = true;
        this.aKl.fa(cj.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aKl.getHandler().sendMessage(obtain2);
    }

    private float zL() {
        float f = this.aKg > this.mScreenHeight ? (this.aKg * 1.0f) / 1334.0f : (this.aKg * 1.0f) / 750.0f;
        if (this.aKg > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean zM() {
        return this.aKf + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aKl != null) {
            this.aKl.clearCache();
        }
    }

    public boolean zN() {
        return this.aKl.zN();
    }

    public double zO() {
        return this.aKe;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aKa = aVar;
    }
}
