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
    private AlaDynamicGiftAnimationView.a aVF;
    private d aVI;
    private int aVL;
    private int aVO;
    private int aVP;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aVJ = 100.0d;
    private int mRepeatCount = 1;
    private int aVK = 0;
    private float aVM = 1.0f;
    private int aVN = 0;
    private boolean aVR = false;
    private b aVQ = new b();

    public void setScreen(int i, int i2) {
        this.aVL = i;
        this.mScreenHeight = i2;
        if (this.aVQ != null) {
            this.aVQ.setScreen(this.aVL, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aVK = 0;
            this.aVR = false;
            this.aVN = 0;
            this.aVI = cVar.aOF.aOE;
            this.mFrameCount = this.aVI.frame_count;
            this.mRepeatCount = this.aVI.repeatCount;
            this.mImageWidth = this.aVI.width;
            this.mImageHeight = this.aVI.height;
            this.aVJ = (1.0d / this.aVI.frame_rate) * 1000.0d;
            this.aVM = GQ();
            this.aVP = (int) (this.aVI.oppositeX * this.aVL);
            this.aVO = (int) (this.aVI.oppositeY * this.mScreenHeight);
            if (this.aVQ != null) {
                this.aVQ.onDestroy();
                this.aVQ = null;
            }
            this.aVQ = new b();
            this.aVQ.setScreen(this.aVL, this.mScreenHeight);
            this.aVQ.b(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (GR()) {
            if (this.mRepeatCount <= 1) {
                if (this.aVF != null) {
                    this.aVF.GP();
                    return;
                }
                return;
            }
            this.aVK = 0;
            this.mRepeatCount--;
        }
        if (this.aVF != null) {
            if (this.aVK == 0 && !this.aVR) {
                this.aVR = true;
                this.aVF.GO();
            } else {
                this.aVF.en(this.aVK);
            }
        }
        c eo = this.aVQ.eo(this.aVK);
        if (eo == null || eo.bitmap == null || eo.bitmap.isRecycled()) {
            if (this.aVN > 5) {
                if (this.aVF != null) {
                    this.aVF.GP();
                }
            } else if (this.aVN > 1) {
                this.aVQ.GW();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aVQ != null && this.aVQ.getHandler() != null) {
                this.aVQ.getHandler().sendMessage(obtain);
            }
            this.aVN++;
            return;
        }
        this.aVK++;
        float width = eo.aWv * eo.bitmap.getWidth() * this.aVM;
        float height = eo.aWv * eo.bitmap.getHeight() * this.aVM;
        canvas.save();
        if (this.aVP + width > this.aVL) {
            this.aVP = (int) (this.aVL - width);
        }
        if (this.aVO + height > this.mScreenHeight) {
            this.aVO = (int) (this.mScreenHeight - height);
        }
        if (this.aVI.isBottomMargin()) {
            rectF = new RectF(this.aVP, (this.mScreenHeight - height) - this.aVO, width + this.aVP, this.mScreenHeight - this.aVO);
        } else {
            rectF = new RectF(this.aVP, this.aVO, width + this.aVP, height + this.aVO);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!eo.bitmap.isRecycled()) {
                canvas.drawBitmap(eo.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        eo.aWw = true;
        this.aVQ.gL(eo.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aVQ.getHandler().sendMessage(obtain2);
    }

    private float GQ() {
        float f = this.aVL > this.mScreenHeight ? (this.aVL * 1.0f) / 1334.0f : (this.aVL * 1.0f) / 750.0f;
        if (this.aVL > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean GR() {
        return this.aVK + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aVQ != null) {
            this.aVQ.clearCache();
        }
    }

    public boolean GS() {
        return this.aVQ.GS();
    }

    public double GT() {
        return this.aVJ;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aVF = aVar;
    }
}
