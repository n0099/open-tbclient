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
/* loaded from: classes4.dex */
public class a {
    private AlaDynamicGiftAnimationView.a bUb;
    private int bdA;
    private int bdD;
    private int bdE;
    private d bdx;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double bdy = 100.0d;
    private int mRepeatCount = 1;
    private int bdz = 0;
    private float bdB = 1.0f;
    private int bdC = 0;
    private boolean bdG = false;
    private b bUd = new b();

    public void setScreen(int i, int i2) {
        this.bdA = i;
        this.mScreenHeight = i2;
        if (this.bUd != null) {
            this.bUd.setScreen(this.bdA, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.bdz = 0;
            this.bdG = false;
            this.bdC = 0;
            this.bdx = cVar.aVv.aVu;
            this.mFrameCount = this.bdx.frame_count;
            this.mRepeatCount = this.bdx.repeatCount;
            this.mImageWidth = this.bdx.width;
            this.mImageHeight = this.bdx.height;
            this.bdy = (1.0d / this.bdx.frame_rate) * 1000.0d;
            this.bdB = JQ();
            this.bdE = (int) (this.bdx.oppositeX * this.bdA);
            this.bdD = (int) (this.bdx.oppositeY * this.mScreenHeight);
            if (this.bUd != null) {
                this.bUd.onDestroy();
                this.bUd = null;
            }
            this.bUd = new b();
            this.bUd.setScreen(this.bdA, this.mScreenHeight);
            this.bUd.c(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (JR()) {
            if (this.mRepeatCount <= 1) {
                if (this.bUb != null) {
                    this.bUb.JP();
                    return;
                }
                return;
            }
            this.bdz = 0;
            this.mRepeatCount--;
        }
        if (this.bUb != null) {
            if (this.bdz == 0 && !this.bdG) {
                this.bdG = true;
                this.bUb.JO();
            } else {
                this.bUb.eK(this.bdz);
            }
        }
        c gT = this.bUd.gT(this.bdz);
        if (gT == null || gT.bitmap == null || gT.bitmap.isRecycled()) {
            if (this.bdC > 5) {
                if (this.bUb != null) {
                    this.bUb.JP();
                }
            } else if (this.bdC > 1) {
                this.bUd.JW();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.bUd != null && this.bUd.getHandler() != null) {
                this.bUd.getHandler().sendMessage(obtain);
            }
            this.bdC++;
            return;
        }
        this.bdz++;
        float width = gT.ben * gT.bitmap.getWidth() * this.bdB;
        float height = gT.ben * gT.bitmap.getHeight() * this.bdB;
        canvas.save();
        if (this.bdE + width > this.bdA) {
            this.bdE = (int) (this.bdA - width);
        }
        if (this.bdD + height > this.mScreenHeight) {
            this.bdD = (int) (this.mScreenHeight - height);
        }
        if (this.bdx.isBottomMargin()) {
            rectF = new RectF(this.bdE, (this.mScreenHeight - height) - this.bdD, width + this.bdE, this.mScreenHeight - this.bdD);
        } else {
            rectF = new RectF(this.bdE, this.bdD, width + this.bdE, height + this.bdD);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!gT.bitmap.isRecycled()) {
                canvas.drawBitmap(gT.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        gT.beo = true;
        this.bUd.hG(gT.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.bUd.getHandler().sendMessage(obtain2);
    }

    private float JQ() {
        float f = this.bdA > this.mScreenHeight ? (this.bdA * 1.0f) / 1334.0f : (this.bdA * 1.0f) / 750.0f;
        if (this.bdA > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean JR() {
        return this.bdz + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.bUd != null) {
            this.bUd.clearCache();
        }
    }

    public boolean JS() {
        return this.bUd.JS();
    }

    public double JT() {
        return this.bdy;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.bUb = aVar;
    }
}
