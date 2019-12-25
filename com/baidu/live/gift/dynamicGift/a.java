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
/* loaded from: classes2.dex */
public class a {
    private AlaDynamicGiftAnimationView.a aiX;
    private d ajc;
    private int ajf;
    private int aji;
    private int ajj;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private final int aja = 24;
    private final int ajb = 5;
    private double ajd = 100.0d;
    private int mRepeatCount = 1;
    private int aje = 0;
    private float ajg = 1.0f;
    private int ajh = 0;
    private boolean ajl = false;
    private b ajk = new b();

    public void setScreen(int i, int i2) {
        this.ajf = i;
        this.mScreenHeight = i2;
        if (this.ajk != null) {
            this.ajk.setScreen(this.ajf, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aje = 0;
            this.ajl = false;
            this.ajh = 0;
            this.ajc = cVar.adu.adt;
            this.mFrameCount = this.ajc.frame_count;
            this.mRepeatCount = this.ajc.repeatCount;
            this.mImageWidth = this.ajc.width;
            this.mImageHeight = this.ajc.height;
            this.ajd = (1.0d / this.ajc.frame_rate) * 1000.0d;
            this.ajg = sv();
            this.ajj = (int) (this.ajc.oppositeX * this.ajf);
            this.aji = (int) (this.ajc.oppositeY * this.mScreenHeight);
            if (this.ajk != null) {
                this.ajk.onDestroy();
                this.ajk = null;
            }
            this.ajk = new b();
            this.ajk.setScreen(this.ajf, this.mScreenHeight);
            this.ajk.a(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (sw()) {
            if (this.mRepeatCount <= 1) {
                if (this.aiX != null) {
                    this.aiX.su();
                    return;
                }
                return;
            }
            this.aje = 0;
            this.mRepeatCount--;
        }
        if (this.aiX != null) {
            if (this.aje == 0 && !this.ajl) {
                this.ajl = true;
                this.aiX.st();
            } else {
                this.aiX.bC(this.aje);
            }
        }
        c bD = this.ajk.bD(this.aje);
        if (bD == null || bD.bitmap == null || bD.bitmap.isRecycled()) {
            if (this.ajh > 5) {
                if (this.aiX != null) {
                    this.aiX.su();
                }
            } else if (this.ajh > 1) {
                this.ajk.sB();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.ajk != null && this.ajk.getHandler() != null) {
                this.ajk.getHandler().sendMessage(obtain);
            }
            this.ajh++;
            return;
        }
        this.aje++;
        float width = bD.ajI * bD.bitmap.getWidth() * this.ajg;
        float height = bD.ajI * bD.bitmap.getHeight() * this.ajg;
        canvas.save();
        if (this.ajj + width > this.ajf) {
            this.ajj = (int) (this.ajf - width);
        }
        if (this.aji + height > this.mScreenHeight) {
            this.aji = (int) (this.mScreenHeight - height);
        }
        if (this.ajc.isBottomMargin()) {
            rectF = new RectF(this.ajj, (this.mScreenHeight - height) - this.aji, width + this.ajj, this.mScreenHeight - this.aji);
        } else {
            rectF = new RectF(this.ajj, this.aji, width + this.ajj, height + this.aji);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!bD.bitmap.isRecycled()) {
                canvas.drawBitmap(bD.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        bD.ajJ = true;
        this.ajk.dn(bD.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.ajk.getHandler().sendMessage(obtain2);
    }

    private float sv() {
        float f = this.ajf > this.mScreenHeight ? (this.ajf * 1.0f) / 1334.0f : (this.ajf * 1.0f) / 750.0f;
        if (this.ajf > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean sw() {
        return this.aje + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.ajk != null) {
            this.ajk.clearCache();
        }
    }

    public boolean sx() {
        return this.ajk.sx();
    }

    public double sy() {
        return this.ajd;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aiX = aVar;
    }
}
