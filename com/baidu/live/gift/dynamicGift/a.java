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
    private AlaDynamicGiftAnimationView.a ban;
    private d baq;
    private int bau;
    private int bax;
    private int bay;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double bas = 100.0d;
    private int mRepeatCount = 1;
    private int bat = 0;
    private float bav = 1.0f;
    private int baw = 0;
    private boolean baA = false;
    private b baz = new b();

    public void setScreen(int i, int i2) {
        this.bau = i;
        this.mScreenHeight = i2;
        if (this.baz != null) {
            this.baz.setScreen(this.bau, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.bat = 0;
            this.baA = false;
            this.baw = 0;
            this.baq = cVar.aSL.aSK;
            this.mFrameCount = this.baq.frame_count;
            this.mRepeatCount = this.baq.repeatCount;
            this.mImageWidth = this.baq.width;
            this.mImageHeight = this.baq.height;
            this.bas = (1.0d / this.baq.frame_rate) * 1000.0d;
            this.bav = Ih();
            this.bay = (int) (this.baq.oppositeX * this.bau);
            this.bax = (int) (this.baq.oppositeY * this.mScreenHeight);
            if (this.baz != null) {
                this.baz.onDestroy();
                this.baz = null;
            }
            this.baz = new b();
            this.baz.setScreen(this.bau, this.mScreenHeight);
            this.baz.c(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (Ii()) {
            if (this.mRepeatCount <= 1) {
                if (this.ban != null) {
                    this.ban.Ig();
                    return;
                }
                return;
            }
            this.bat = 0;
            this.mRepeatCount--;
        }
        if (this.ban != null) {
            if (this.bat == 0 && !this.baA) {
                this.baA = true;
                this.ban.If();
            } else {
                this.ban.et(this.bat);
            }
        }
        c eu = this.baz.eu(this.bat);
        if (eu == null || eu.bitmap == null || eu.bitmap.isRecycled()) {
            if (this.baw > 5) {
                if (this.ban != null) {
                    this.ban.Ig();
                }
            } else if (this.baw > 1) {
                this.baz.In();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.baz != null && this.baz.getHandler() != null) {
                this.baz.getHandler().sendMessage(obtain);
            }
            this.baw++;
            return;
        }
        this.bat++;
        float width = eu.bbe * eu.bitmap.getWidth() * this.bav;
        float height = eu.bbe * eu.bitmap.getHeight() * this.bav;
        canvas.save();
        if (this.bay + width > this.bau) {
            this.bay = (int) (this.bau - width);
        }
        if (this.bax + height > this.mScreenHeight) {
            this.bax = (int) (this.mScreenHeight - height);
        }
        if (this.baq.isBottomMargin()) {
            rectF = new RectF(this.bay, (this.mScreenHeight - height) - this.bax, width + this.bay, this.mScreenHeight - this.bax);
        } else {
            rectF = new RectF(this.bay, this.bax, width + this.bay, height + this.bax);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!eu.bitmap.isRecycled()) {
                canvas.drawBitmap(eu.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        eu.bbf = true;
        this.baz.hk(eu.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.baz.getHandler().sendMessage(obtain2);
    }

    private float Ih() {
        float f = this.bau > this.mScreenHeight ? (this.bau * 1.0f) / 1334.0f : (this.bau * 1.0f) / 750.0f;
        if (this.bau > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean Ii() {
        return this.bat + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.baz != null) {
            this.baz.clearCache();
        }
    }

    public boolean Ij() {
        return this.baz.Ij();
    }

    public double Ik() {
        return this.bas;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.ban = aVar;
    }
}
