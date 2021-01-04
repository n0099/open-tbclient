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
/* loaded from: classes11.dex */
public class a {
    private AlaDynamicGiftAnimationView.b bZT;
    private d bfj;
    private int bfn;
    private int bfq;
    private int bfr;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double bfk = 100.0d;
    private int bfl = 1;
    private int bfm = 0;
    private float bfo = 1.0f;
    private int bfp = 0;
    private boolean bft = false;
    private b bZV = new b();

    public void setScreen(int i, int i2) {
        this.bfn = i;
        this.mScreenHeight = i2;
        if (this.bZV != null) {
            this.bZV.setScreen(this.bfn, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.bfm = 0;
            this.bft = false;
            this.bfp = 0;
            this.bfj = cVar.aXb.aWZ;
            this.mFrameCount = this.bfj.frame_count;
            this.bfl = this.bfj.repeatCount;
            this.mImageWidth = this.bfj.width;
            this.mImageHeight = this.bfj.height;
            this.bfk = (1.0d / this.bfj.frame_rate) * 1000.0d;
            this.bfo = Js();
            this.bfr = (int) (this.bfj.oppositeX * this.bfn);
            this.bfq = (int) (this.bfj.oppositeY * this.mScreenHeight);
            if (this.bZV != null) {
                this.bZV.onDestroy();
                this.bZV = null;
            }
            this.bZV = new b();
            this.bZV.setScreen(this.bfn, this.mScreenHeight);
            this.bZV.c(cVar);
        }
    }

    public void h(Canvas canvas) {
        RectF rectF;
        if (Jt()) {
            if (this.bfl <= 1) {
                if (this.bZT != null) {
                    this.bZT.Jr();
                    return;
                }
                return;
            }
            this.bfm = 0;
            this.bfl--;
        }
        if (this.bZT != null) {
            if (this.bfm == 0 && !this.bft) {
                this.bft = true;
                this.bZT.Jq();
            } else {
                this.bZT.eI(this.bfm);
            }
        }
        c gU = this.bZV.gU(this.bfm);
        if (gU == null || gU.bitmap == null || gU.bitmap.isRecycled()) {
            if (this.bfp > 5) {
                if (this.bZT != null) {
                    this.bZT.Jr();
                }
            } else if (this.bfp > 1) {
                this.bZV.Jy();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.bZV != null && this.bZV.getHandler() != null) {
                this.bZV.getHandler().sendMessage(obtain);
            }
            this.bfp++;
            return;
        }
        this.bfm++;
        float width = gU.bfZ * gU.bitmap.getWidth() * this.bfo;
        float height = gU.bfZ * gU.bitmap.getHeight() * this.bfo;
        canvas.save();
        if (this.bfr + width > this.bfn) {
            this.bfr = (int) (this.bfn - width);
        }
        if (this.bfq + height > this.mScreenHeight) {
            this.bfq = (int) (this.mScreenHeight - height);
        }
        if (this.bfj.isBottomMargin()) {
            rectF = new RectF(this.bfr, (this.mScreenHeight - height) - this.bfq, width + this.bfr, this.mScreenHeight - this.bfq);
        } else {
            rectF = new RectF(this.bfr, this.bfq, width + this.bfr, height + this.bfq);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!gU.bitmap.isRecycled()) {
                canvas.drawBitmap(gU.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        gU.bga = true;
        this.bZV.hr(gU.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.bZV.getHandler().sendMessage(obtain2);
    }

    private float Js() {
        float f = this.bfn > this.mScreenHeight ? (this.bfn * 1.0f) / 1334.0f : (this.bfn * 1.0f) / 750.0f;
        if (this.bfn > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean Jt() {
        return this.bfm + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.bZV != null) {
            this.bZV.clearCache();
        }
    }

    public boolean Ju() {
        return this.bZV.Ju();
    }

    public double Jv() {
        return this.bfk;
    }

    public void a(AlaDynamicGiftAnimationView.b bVar) {
        this.bZT = bVar;
    }
}
