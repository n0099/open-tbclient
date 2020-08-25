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
/* loaded from: classes7.dex */
public class a {
    private AlaDynamicGiftAnimationView.a aTo;
    private d aTr;
    private int aTu;
    private int aTx;
    private int aTy;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aTs = 100.0d;
    private int mRepeatCount = 1;
    private int aTt = 0;
    private float aTv = 1.0f;
    private int aTw = 0;
    private boolean aTA = false;
    private b aTz = new b();

    public void setScreen(int i, int i2) {
        this.aTu = i;
        this.mScreenHeight = i2;
        if (this.aTz != null) {
            this.aTz.setScreen(this.aTu, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aTt = 0;
            this.aTA = false;
            this.aTw = 0;
            this.aTr = cVar.aML.aMK;
            this.mFrameCount = this.aTr.frame_count;
            this.mRepeatCount = this.aTr.repeatCount;
            this.mImageWidth = this.aTr.width;
            this.mImageHeight = this.aTr.height;
            this.aTs = (1.0d / this.aTr.frame_rate) * 1000.0d;
            this.aTv = Gq();
            this.aTy = (int) (this.aTr.oppositeX * this.aTu);
            this.aTx = (int) (this.aTr.oppositeY * this.mScreenHeight);
            if (this.aTz != null) {
                this.aTz.onDestroy();
                this.aTz = null;
            }
            this.aTz = new b();
            this.aTz.setScreen(this.aTu, this.mScreenHeight);
            this.aTz.b(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (Gr()) {
            if (this.mRepeatCount <= 1) {
                if (this.aTo != null) {
                    this.aTo.Gp();
                    return;
                }
                return;
            }
            this.aTt = 0;
            this.mRepeatCount--;
        }
        if (this.aTo != null) {
            if (this.aTt == 0 && !this.aTA) {
                this.aTA = true;
                this.aTo.Go();
            } else {
                this.aTo.ej(this.aTt);
            }
        }
        c ek = this.aTz.ek(this.aTt);
        if (ek == null || ek.bitmap == null || ek.bitmap.isRecycled()) {
            if (this.aTw > 5) {
                if (this.aTo != null) {
                    this.aTo.Gp();
                }
            } else if (this.aTw > 1) {
                this.aTz.Gw();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aTz != null && this.aTz.getHandler() != null) {
                this.aTz.getHandler().sendMessage(obtain);
            }
            this.aTw++;
            return;
        }
        this.aTt++;
        float width = ek.aUe * ek.bitmap.getWidth() * this.aTv;
        float height = ek.aUe * ek.bitmap.getHeight() * this.aTv;
        canvas.save();
        if (this.aTy + width > this.aTu) {
            this.aTy = (int) (this.aTu - width);
        }
        if (this.aTx + height > this.mScreenHeight) {
            this.aTx = (int) (this.mScreenHeight - height);
        }
        if (this.aTr.isBottomMargin()) {
            rectF = new RectF(this.aTy, (this.mScreenHeight - height) - this.aTx, width + this.aTy, this.mScreenHeight - this.aTx);
        } else {
            rectF = new RectF(this.aTy, this.aTx, width + this.aTy, height + this.aTx);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!ek.bitmap.isRecycled()) {
                canvas.drawBitmap(ek.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        ek.aUf = true;
        this.aTz.gA(ek.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aTz.getHandler().sendMessage(obtain2);
    }

    private float Gq() {
        float f = this.aTu > this.mScreenHeight ? (this.aTu * 1.0f) / 1334.0f : (this.aTu * 1.0f) / 750.0f;
        if (this.aTu > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean Gr() {
        return this.aTt + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aTz != null) {
            this.aTz.clearCache();
        }
    }

    public boolean Gs() {
        return this.aTz.Gs();
    }

    public double Gt() {
        return this.aTs;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aTo = aVar;
    }
}
