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
    private AlaDynamicGiftAnimationView.a aZU;
    private d aZX;
    private int baa;
    private int bad;
    private int bae;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double aZY = 100.0d;
    private int mRepeatCount = 1;
    private int aZZ = 0;
    private float bab = 1.0f;
    private int bac = 0;
    private boolean bag = false;
    private b baf = new b();

    public void setScreen(int i, int i2) {
        this.baa = i;
        this.mScreenHeight = i2;
        if (this.baf != null) {
            this.baf.setScreen(this.baa, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.aZZ = 0;
            this.bag = false;
            this.bac = 0;
            this.aZX = cVar.aSt.aSs;
            this.mFrameCount = this.aZX.frame_count;
            this.mRepeatCount = this.aZX.repeatCount;
            this.mImageWidth = this.aZX.width;
            this.mImageHeight = this.aZX.height;
            this.aZY = (1.0d / this.aZX.frame_rate) * 1000.0d;
            this.bab = HZ();
            this.bae = (int) (this.aZX.oppositeX * this.baa);
            this.bad = (int) (this.aZX.oppositeY * this.mScreenHeight);
            if (this.baf != null) {
                this.baf.onDestroy();
                this.baf = null;
            }
            this.baf = new b();
            this.baf.setScreen(this.baa, this.mScreenHeight);
            this.baf.c(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (Ia()) {
            if (this.mRepeatCount <= 1) {
                if (this.aZU != null) {
                    this.aZU.HY();
                    return;
                }
                return;
            }
            this.aZZ = 0;
            this.mRepeatCount--;
        }
        if (this.aZU != null) {
            if (this.aZZ == 0 && !this.bag) {
                this.bag = true;
                this.aZU.HX();
            } else {
                this.aZU.ep(this.aZZ);
            }
        }
        c eq = this.baf.eq(this.aZZ);
        if (eq == null || eq.bitmap == null || eq.bitmap.isRecycled()) {
            if (this.bac > 5) {
                if (this.aZU != null) {
                    this.aZU.HY();
                }
            } else if (this.bac > 1) {
                this.baf.If();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.baf != null && this.baf.getHandler() != null) {
                this.baf.getHandler().sendMessage(obtain);
            }
            this.bac++;
            return;
        }
        this.aZZ++;
        float width = eq.baL * eq.bitmap.getWidth() * this.bab;
        float height = eq.baL * eq.bitmap.getHeight() * this.bab;
        canvas.save();
        if (this.bae + width > this.baa) {
            this.bae = (int) (this.baa - width);
        }
        if (this.bad + height > this.mScreenHeight) {
            this.bad = (int) (this.mScreenHeight - height);
        }
        if (this.aZX.isBottomMargin()) {
            rectF = new RectF(this.bae, (this.mScreenHeight - height) - this.bad, width + this.bae, this.mScreenHeight - this.bad);
        } else {
            rectF = new RectF(this.bae, this.bad, width + this.bae, height + this.bad);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!eq.bitmap.isRecycled()) {
                canvas.drawBitmap(eq.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        eq.baM = true;
        this.baf.hl(eq.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.baf.getHandler().sendMessage(obtain2);
    }

    private float HZ() {
        float f = this.baa > this.mScreenHeight ? (this.baa * 1.0f) / 1334.0f : (this.baa * 1.0f) / 750.0f;
        if (this.baa > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean Ia() {
        return this.aZZ + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.baf != null) {
            this.baf.clearCache();
        }
    }

    public boolean Ib() {
        return this.baf.Ib();
    }

    public double Ic() {
        return this.aZY;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aZU = aVar;
    }
}
