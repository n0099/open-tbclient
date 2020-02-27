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
    private AlaDynamicGiftAnimationView.a alP;
    private d alS;
    private int alV;
    private int alY;
    private int alZ;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double alT = 100.0d;
    private int mRepeatCount = 1;
    private int alU = 0;
    private float alW = 1.0f;
    private int alX = 0;
    private boolean amb = false;
    private b ama = new b();

    public void setScreen(int i, int i2) {
        this.alV = i;
        this.mScreenHeight = i2;
        if (this.ama != null) {
            this.ama.setScreen(this.alV, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.alU = 0;
            this.amb = false;
            this.alX = 0;
            this.alS = cVar.afL.afK;
            this.mFrameCount = this.alS.frame_count;
            this.mRepeatCount = this.alS.repeatCount;
            this.mImageWidth = this.alS.width;
            this.mImageHeight = this.alS.height;
            this.alT = (1.0d / this.alS.frame_rate) * 1000.0d;
            this.alW = tX();
            this.alZ = (int) (this.alS.oppositeX * this.alV);
            this.alY = (int) (this.alS.oppositeY * this.mScreenHeight);
            if (this.ama != null) {
                this.ama.onDestroy();
                this.ama = null;
            }
            this.ama = new b();
            this.ama.setScreen(this.alV, this.mScreenHeight);
            this.ama.a(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (tY()) {
            if (this.mRepeatCount <= 1) {
                if (this.alP != null) {
                    this.alP.tW();
                    return;
                }
                return;
            }
            this.alU = 0;
            this.mRepeatCount--;
        }
        if (this.alP != null) {
            if (this.alU == 0 && !this.amb) {
                this.amb = true;
                this.alP.tV();
            } else {
                this.alP.bJ(this.alU);
            }
        }
        c bK = this.ama.bK(this.alU);
        if (bK == null || bK.bitmap == null || bK.bitmap.isRecycled()) {
            if (this.alX > 5) {
                if (this.alP != null) {
                    this.alP.tW();
                }
            } else if (this.alX > 1) {
                this.ama.ud();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.ama != null && this.ama.getHandler() != null) {
                this.ama.getHandler().sendMessage(obtain);
            }
            this.alX++;
            return;
        }
        this.alU++;
        float width = bK.amD * bK.bitmap.getWidth() * this.alW;
        float height = bK.amD * bK.bitmap.getHeight() * this.alW;
        canvas.save();
        if (this.alZ + width > this.alV) {
            this.alZ = (int) (this.alV - width);
        }
        if (this.alY + height > this.mScreenHeight) {
            this.alY = (int) (this.mScreenHeight - height);
        }
        if (this.alS.isBottomMargin()) {
            rectF = new RectF(this.alZ, (this.mScreenHeight - height) - this.alY, width + this.alZ, this.mScreenHeight - this.alY);
        } else {
            rectF = new RectF(this.alZ, this.alY, width + this.alZ, height + this.alY);
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
        bK.amE = true;
        this.ama.dz(bK.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.ama.getHandler().sendMessage(obtain2);
    }

    private float tX() {
        float f = this.alV > this.mScreenHeight ? (this.alV * 1.0f) / 1334.0f : (this.alV * 1.0f) / 750.0f;
        if (this.alV > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean tY() {
        return this.alU + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.ama != null) {
            this.ama.clearCache();
        }
    }

    public boolean tZ() {
        return this.ama.tZ();
    }

    public double ua() {
        return this.alT;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.alP = aVar;
    }
}
