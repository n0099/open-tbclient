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
    private AlaDynamicGiftAnimationView.a aMG;
    private d aMJ;
    private int aMM;
    private int aMP;
    private int aMQ;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aMK = 100.0d;
    private int mRepeatCount = 1;
    private int aML = 0;
    private float aMN = 1.0f;
    private int aMO = 0;
    private boolean aMS = false;
    private b aMR = new b();

    public void setScreen(int i, int i2) {
        this.aMM = i;
        this.mScreenHeight = i2;
        if (this.aMR != null) {
            this.aMR.setScreen(this.aMM, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aML = 0;
            this.aMS = false;
            this.aMO = 0;
            this.aMJ = cVar.aGg.aGf;
            this.mFrameCount = this.aMJ.frame_count;
            this.mRepeatCount = this.aMJ.repeatCount;
            this.mImageWidth = this.aMJ.width;
            this.mImageHeight = this.aMJ.height;
            this.aMK = (1.0d / this.aMJ.frame_rate) * 1000.0d;
            this.aMN = Al();
            this.aMQ = (int) (this.aMJ.oppositeX * this.aMM);
            this.aMP = (int) (this.aMJ.oppositeY * this.mScreenHeight);
            if (this.aMR != null) {
                this.aMR.onDestroy();
                this.aMR = null;
            }
            this.aMR = new b();
            this.aMR.setScreen(this.aMM, this.mScreenHeight);
            this.aMR.b(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (Am()) {
            if (this.mRepeatCount <= 1) {
                if (this.aMG != null) {
                    this.aMG.Ak();
                    return;
                }
                return;
            }
            this.aML = 0;
            this.mRepeatCount--;
        }
        if (this.aMG != null) {
            if (this.aML == 0 && !this.aMS) {
                this.aMS = true;
                this.aMG.Aj();
            } else {
                this.aMG.co(this.aML);
            }
        }
        c cp = this.aMR.cp(this.aML);
        if (cp == null || cp.bitmap == null || cp.bitmap.isRecycled()) {
            if (this.aMO > 5) {
                if (this.aMG != null) {
                    this.aMG.Ak();
                }
            } else if (this.aMO > 1) {
                this.aMR.Ar();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aMR != null && this.aMR.getHandler() != null) {
                this.aMR.getHandler().sendMessage(obtain);
            }
            this.aMO++;
            return;
        }
        this.aML++;
        float width = cp.aNv * cp.bitmap.getWidth() * this.aMN;
        float height = cp.aNv * cp.bitmap.getHeight() * this.aMN;
        canvas.save();
        if (this.aMQ + width > this.aMM) {
            this.aMQ = (int) (this.aMM - width);
        }
        if (this.aMP + height > this.mScreenHeight) {
            this.aMP = (int) (this.mScreenHeight - height);
        }
        if (this.aMJ.isBottomMargin()) {
            rectF = new RectF(this.aMQ, (this.mScreenHeight - height) - this.aMP, width + this.aMQ, this.mScreenHeight - this.aMP);
        } else {
            rectF = new RectF(this.aMQ, this.aMP, width + this.aMQ, height + this.aMP);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!cp.bitmap.isRecycled()) {
                canvas.drawBitmap(cp.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        cp.aNw = true;
        this.aMR.fg(cp.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aMR.getHandler().sendMessage(obtain2);
    }

    private float Al() {
        float f = this.aMM > this.mScreenHeight ? (this.aMM * 1.0f) / 1334.0f : (this.aMM * 1.0f) / 750.0f;
        if (this.aMM > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean Am() {
        return this.aML + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aMR != null) {
            this.aMR.clearCache();
        }
    }

    public boolean An() {
        return this.aMR.An();
    }

    public double Ao() {
        return this.aMK;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aMG = aVar;
    }
}
