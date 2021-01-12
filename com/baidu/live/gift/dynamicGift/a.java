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
/* loaded from: classes10.dex */
public class a {
    private int baA;
    private int baB;
    private AlaDynamicGiftAnimationView.a bap;
    private d bat;
    private int bax;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double bau = 100.0d;
    private int bav = 1;
    private int baw = 0;
    private float bay = 1.0f;
    private int baz = 0;
    private boolean baD = false;
    private b baC = new b();

    public void setScreen(int i, int i2) {
        this.bax = i;
        this.mScreenHeight = i2;
        if (this.baC != null) {
            this.baC.setScreen(this.bax, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.baw = 0;
            this.baD = false;
            this.baz = 0;
            this.bat = cVar.aSo.aSm;
            this.mFrameCount = this.bat.frame_count;
            this.bav = this.bat.repeatCount;
            this.mImageWidth = this.bat.width;
            this.mImageHeight = this.bat.height;
            this.bau = (1.0d / this.bat.frame_rate) * 1000.0d;
            this.bay = Fx();
            this.baB = (int) (this.bat.oppositeX * this.bax);
            this.baA = (int) (this.bat.oppositeY * this.mScreenHeight);
            if (this.baC != null) {
                this.baC.onDestroy();
                this.baC = null;
            }
            this.baC = new b();
            this.baC.setScreen(this.bax, this.mScreenHeight);
            this.baC.c(cVar);
        }
    }

    public void h(Canvas canvas) {
        RectF rectF;
        if (Fy()) {
            if (this.bav <= 1) {
                if (this.bap != null) {
                    this.bap.Fw();
                    return;
                }
                return;
            }
            this.baw = 0;
            this.bav--;
        }
        if (this.bap != null) {
            if (this.baw == 0 && !this.baD) {
                this.baD = true;
                this.bap.Fv();
            } else {
                this.bap.dc(this.baw);
            }
        }
        c dd = this.baC.dd(this.baw);
        if (dd == null || dd.bitmap == null || dd.bitmap.isRecycled()) {
            if (this.baz > 5) {
                if (this.bap != null) {
                    this.bap.Fw();
                }
            } else if (this.baz > 1) {
                this.baC.FD();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.baC != null && this.baC.getHandler() != null) {
                this.baC.getHandler().sendMessage(obtain);
            }
            this.baz++;
            return;
        }
        this.baw++;
        float width = dd.bbj * dd.bitmap.getWidth() * this.bay;
        float height = dd.bbj * dd.bitmap.getHeight() * this.bay;
        canvas.save();
        if (this.baB + width > this.bax) {
            this.baB = (int) (this.bax - width);
        }
        if (this.baA + height > this.mScreenHeight) {
            this.baA = (int) (this.mScreenHeight - height);
        }
        if (this.bat.isBottomMargin()) {
            rectF = new RectF(this.baB, (this.mScreenHeight - height) - this.baA, width + this.baB, this.mScreenHeight - this.baA);
        } else {
            rectF = new RectF(this.baB, this.baA, width + this.baB, height + this.baA);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!dd.bitmap.isRecycled()) {
                canvas.drawBitmap(dd.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        dd.bbk = true;
        this.baC.gf(dd.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.baC.getHandler().sendMessage(obtain2);
    }

    private float Fx() {
        float f = this.bax > this.mScreenHeight ? (this.bax * 1.0f) / 1334.0f : (this.bax * 1.0f) / 750.0f;
        if (this.bax > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean Fy() {
        return this.baw + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.baC != null) {
            this.baC.clearCache();
        }
    }

    public boolean Fz() {
        return this.baC.Fz();
    }

    public double FA() {
        return this.bau;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.bap = aVar;
    }
}
