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
    private d aEB;
    private int aEE;
    private int aEH;
    private int aEI;
    private AlaDynamicGiftAnimationView.a aEy;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aEC = 100.0d;
    private int mRepeatCount = 1;
    private int aED = 0;
    private float aEF = 1.0f;
    private int aEG = 0;
    private boolean aEK = false;
    private b aEJ = new b();

    public void setScreen(int i, int i2) {
        this.aEE = i;
        this.mScreenHeight = i2;
        if (this.aEJ != null) {
            this.aEJ.setScreen(this.aEE, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aED = 0;
            this.aEK = false;
            this.aEG = 0;
            this.aEB = cVar.ays.ayr;
            this.mFrameCount = this.aEB.frame_count;
            this.mRepeatCount = this.aEB.repeatCount;
            this.mImageWidth = this.aEB.width;
            this.mImageHeight = this.aEB.height;
            this.aEC = (1.0d / this.aEB.frame_rate) * 1000.0d;
            this.aEF = yv();
            this.aEI = (int) (this.aEB.oppositeX * this.aEE);
            this.aEH = (int) (this.aEB.oppositeY * this.mScreenHeight);
            if (this.aEJ != null) {
                this.aEJ.onDestroy();
                this.aEJ = null;
            }
            this.aEJ = new b();
            this.aEJ.setScreen(this.aEE, this.mScreenHeight);
            this.aEJ.a(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (yw()) {
            if (this.mRepeatCount <= 1) {
                if (this.aEy != null) {
                    this.aEy.yu();
                    return;
                }
                return;
            }
            this.aED = 0;
            this.mRepeatCount--;
        }
        if (this.aEy != null) {
            if (this.aED == 0 && !this.aEK) {
                this.aEK = true;
                this.aEy.yt();
            } else {
                this.aEy.bZ(this.aED);
            }
        }
        c ca = this.aEJ.ca(this.aED);
        if (ca == null || ca.bitmap == null || ca.bitmap.isRecycled()) {
            if (this.aEG > 5) {
                if (this.aEy != null) {
                    this.aEy.yu();
                }
            } else if (this.aEG > 1) {
                this.aEJ.yB();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aEJ != null && this.aEJ.getHandler() != null) {
                this.aEJ.getHandler().sendMessage(obtain);
            }
            this.aEG++;
            return;
        }
        this.aED++;
        float width = ca.aFm * ca.bitmap.getWidth() * this.aEF;
        float height = ca.aFm * ca.bitmap.getHeight() * this.aEF;
        canvas.save();
        if (this.aEI + width > this.aEE) {
            this.aEI = (int) (this.aEE - width);
        }
        if (this.aEH + height > this.mScreenHeight) {
            this.aEH = (int) (this.mScreenHeight - height);
        }
        if (this.aEB.isBottomMargin()) {
            rectF = new RectF(this.aEI, (this.mScreenHeight - height) - this.aEH, width + this.aEI, this.mScreenHeight - this.aEH);
        } else {
            rectF = new RectF(this.aEI, this.aEH, width + this.aEI, height + this.aEH);
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
        ca.aFn = true;
        this.aEJ.eq(ca.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aEJ.getHandler().sendMessage(obtain2);
    }

    private float yv() {
        float f = this.aEE > this.mScreenHeight ? (this.aEE * 1.0f) / 1334.0f : (this.aEE * 1.0f) / 750.0f;
        if (this.aEE > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean yw() {
        return this.aED + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aEJ != null) {
            this.aEJ.clearCache();
        }
    }

    public boolean yx() {
        return this.aEJ.yx();
    }

    public double yy() {
        return this.aEC;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aEy = aVar;
    }
}
