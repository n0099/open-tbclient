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
/* loaded from: classes10.dex */
public class a {
    private AlaDynamicGiftAnimationView.a beY;
    private d bfc;
    private int bfg;
    private int bfi;
    private int bfj;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double bfd = 100.0d;
    private int bfe = 1;
    private int bff = 0;
    private float bfh = 1.0f;
    private int mDropCount = 0;
    private boolean bfl = false;
    private b bfk = new b();

    public void setScreen(int i, int i2) {
        this.bfg = i;
        this.mScreenHeight = i2;
        if (this.bfk != null) {
            this.bfk.setScreen(this.bfg, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.bff = 0;
            this.bfl = false;
            this.mDropCount = 0;
            this.bfc = cVar.aWS.aWQ;
            this.mFrameCount = this.bfc.frame_count;
            this.bfe = this.bfc.repeatCount;
            this.mImageWidth = this.bfc.width;
            this.mImageHeight = this.bfc.height;
            this.bfd = (1.0d / this.bfc.frame_rate) * 1000.0d;
            this.bfh = GQ();
            this.bfj = (int) (this.bfc.oppositeX * this.bfg);
            this.bfi = (int) (this.bfc.oppositeY * this.mScreenHeight);
            if (this.bfk != null) {
                this.bfk.onDestroy();
                this.bfk = null;
            }
            this.bfk = new b();
            this.bfk.setScreen(this.bfg, this.mScreenHeight);
            this.bfk.c(cVar);
        }
    }

    public void h(Canvas canvas) {
        RectF rectF;
        if (GR()) {
            if (this.bfe <= 1) {
                if (this.beY != null) {
                    this.beY.GP();
                    return;
                }
                return;
            }
            this.bff = 0;
            this.bfe--;
        }
        if (this.beY != null) {
            if (this.bff == 0 && !this.bfl) {
                this.bfl = true;
                this.beY.GO();
            } else {
                this.beY.di(this.bff);
            }
        }
        c dj = this.bfk.dj(this.bff);
        if (dj == null || dj.bitmap == null || dj.bitmap.isRecycled()) {
            if (this.mDropCount > 5) {
                if (this.beY != null) {
                    this.beY.GP();
                }
            } else if (this.mDropCount > 1) {
                this.bfk.GW();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.bfk != null && this.bfk.getHandler() != null) {
                this.bfk.getHandler().sendMessage(obtain);
            }
            this.mDropCount++;
            return;
        }
        this.bff++;
        float width = dj.bfS * dj.bitmap.getWidth() * this.bfh;
        float height = dj.bfS * dj.bitmap.getHeight() * this.bfh;
        canvas.save();
        if (this.bfj + width > this.bfg) {
            this.bfj = (int) (this.bfg - width);
        }
        if (this.bfi + height > this.mScreenHeight) {
            this.bfi = (int) (this.mScreenHeight - height);
        }
        if (this.bfc.isBottomMargin()) {
            rectF = new RectF(this.bfj, (this.mScreenHeight - height) - this.bfi, width + this.bfj, this.mScreenHeight - this.bfi);
        } else {
            rectF = new RectF(this.bfj, this.bfi, width + this.bfj, height + this.bfi);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!dj.bitmap.isRecycled()) {
                canvas.drawBitmap(dj.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        dj.bfT = true;
        this.bfk.gJ(dj.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.bfk.getHandler().sendMessage(obtain2);
    }

    private float GQ() {
        float f = this.bfg > this.mScreenHeight ? (this.bfg * 1.0f) / 1334.0f : (this.bfg * 1.0f) / 750.0f;
        if (this.bfg > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean GR() {
        return this.bff + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.bfk != null) {
            this.bfk.clearCache();
        }
    }

    public boolean GS() {
        return this.bfk.GS();
    }

    public double GT() {
        return this.bfd;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.beY = aVar;
    }
}
