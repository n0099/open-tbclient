package com.baidu.live.yuyingift.dynamicgift;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Message;
import com.baidu.live.gift.d;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView;
/* loaded from: classes10.dex */
public class a {
    private d bfc;
    private int bfg;
    private int bfi;
    private int bfj;
    private AlaDynamicGiftAnimationView.b caJ;
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
    private b caL = new b();

    public void setScreen(int i, int i2) {
        this.bfg = i;
        this.mScreenHeight = i2;
        if (this.caL != null) {
            this.caL.setScreen(this.bfg, this.mScreenHeight);
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
            if (this.caL != null) {
                this.caL.onDestroy();
                this.caL = null;
            }
            this.caL = new b();
            this.caL.setScreen(this.bfg, this.mScreenHeight);
            this.caL.c(cVar);
        }
    }

    public void h(Canvas canvas) {
        RectF rectF;
        if (GR()) {
            if (this.bfe <= 1) {
                if (this.caJ != null) {
                    this.caJ.GP();
                    return;
                }
                return;
            }
            this.bff = 0;
            this.bfe--;
        }
        if (this.caJ != null) {
            if (this.bff == 0 && !this.bfl) {
                this.bfl = true;
                this.caJ.GO();
            } else {
                this.caJ.di(this.bff);
            }
        }
        c fu = this.caL.fu(this.bff);
        if (fu == null || fu.bitmap == null || fu.bitmap.isRecycled()) {
            if (this.mDropCount > 5) {
                if (this.caJ != null) {
                    this.caJ.GP();
                }
            } else if (this.mDropCount > 1) {
                this.caL.GW();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.caL != null && this.caL.getHandler() != null) {
                this.caL.getHandler().sendMessage(obtain);
            }
            this.mDropCount++;
            return;
        }
        this.bff++;
        float width = fu.bfS * fu.bitmap.getWidth() * this.bfh;
        float height = fu.bfS * fu.bitmap.getHeight() * this.bfh;
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
            if (!fu.bitmap.isRecycled()) {
                canvas.drawBitmap(fu.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        fu.bfT = true;
        this.caL.gJ(fu.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.caL.getHandler().sendMessage(obtain2);
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
        if (this.caL != null) {
            this.caL.clearCache();
        }
    }

    public boolean GS() {
        return this.caL.GS();
    }

    public double GT() {
        return this.bfd;
    }

    public void a(AlaDynamicGiftAnimationView.b bVar) {
        this.caJ = bVar;
    }
}
