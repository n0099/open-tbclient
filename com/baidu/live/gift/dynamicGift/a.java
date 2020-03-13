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
    private AlaDynamicGiftAnimationView.a alQ;
    private d alT;
    private int alW;
    private int alZ;
    private int ama;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double alU = 100.0d;
    private int mRepeatCount = 1;
    private int alV = 0;
    private float alX = 1.0f;
    private int alY = 0;
    private boolean amc = false;
    private b amb = new b();

    public void setScreen(int i, int i2) {
        this.alW = i;
        this.mScreenHeight = i2;
        if (this.amb != null) {
            this.amb.setScreen(this.alW, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.alV = 0;
            this.amc = false;
            this.alY = 0;
            this.alT = cVar.afL.afK;
            this.mFrameCount = this.alT.frame_count;
            this.mRepeatCount = this.alT.repeatCount;
            this.mImageWidth = this.alT.width;
            this.mImageHeight = this.alT.height;
            this.alU = (1.0d / this.alT.frame_rate) * 1000.0d;
            this.alX = tX();
            this.ama = (int) (this.alT.oppositeX * this.alW);
            this.alZ = (int) (this.alT.oppositeY * this.mScreenHeight);
            if (this.amb != null) {
                this.amb.onDestroy();
                this.amb = null;
            }
            this.amb = new b();
            this.amb.setScreen(this.alW, this.mScreenHeight);
            this.amb.a(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (tY()) {
            if (this.mRepeatCount <= 1) {
                if (this.alQ != null) {
                    this.alQ.tW();
                    return;
                }
                return;
            }
            this.alV = 0;
            this.mRepeatCount--;
        }
        if (this.alQ != null) {
            if (this.alV == 0 && !this.amc) {
                this.amc = true;
                this.alQ.tV();
            } else {
                this.alQ.bJ(this.alV);
            }
        }
        c bK = this.amb.bK(this.alV);
        if (bK == null || bK.bitmap == null || bK.bitmap.isRecycled()) {
            if (this.alY > 5) {
                if (this.alQ != null) {
                    this.alQ.tW();
                }
            } else if (this.alY > 1) {
                this.amb.ud();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.amb != null && this.amb.getHandler() != null) {
                this.amb.getHandler().sendMessage(obtain);
            }
            this.alY++;
            return;
        }
        this.alV++;
        float width = bK.amE * bK.bitmap.getWidth() * this.alX;
        float height = bK.amE * bK.bitmap.getHeight() * this.alX;
        canvas.save();
        if (this.ama + width > this.alW) {
            this.ama = (int) (this.alW - width);
        }
        if (this.alZ + height > this.mScreenHeight) {
            this.alZ = (int) (this.mScreenHeight - height);
        }
        if (this.alT.isBottomMargin()) {
            rectF = new RectF(this.ama, (this.mScreenHeight - height) - this.alZ, width + this.ama, this.mScreenHeight - this.alZ);
        } else {
            rectF = new RectF(this.ama, this.alZ, width + this.ama, height + this.alZ);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!bK.bitmap.isRecycled()) {
                canvas.drawBitmap(bK.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        bK.amF = true;
        this.amb.dz(bK.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.amb.getHandler().sendMessage(obtain2);
    }

    private float tX() {
        float f = this.alW > this.mScreenHeight ? (this.alW * 1.0f) / 1334.0f : (this.alW * 1.0f) / 750.0f;
        if (this.alW > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean tY() {
        return this.alV + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.amb != null) {
            this.amb.clearCache();
        }
    }

    public boolean tZ() {
        return this.amb.tZ();
    }

    public double ua() {
        return this.alU;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.alQ = aVar;
    }
}
