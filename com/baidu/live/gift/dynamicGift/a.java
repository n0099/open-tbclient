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
/* loaded from: classes6.dex */
public class a {
    private AlaDynamicGiftAnimationView.a aaT;
    private d aaY;
    private int abd;
    private int abg;
    private int abh;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private final int aaW = 24;
    private final int aaX = 5;
    private double aaZ = 100.0d;
    private int aba = 1;
    private int abb = 0;
    private float abe = 1.0f;
    private int abf = 0;
    private boolean abj = false;
    private b abi = new b();

    public void setScreen(int i, int i2) {
        this.abd = i;
        this.mScreenHeight = i2;
        if (this.abi != null) {
            this.abi.setScreen(this.abd, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.abb = 0;
            this.abj = false;
            this.abf = 0;
            this.aaY = cVar.VT.VS;
            this.mFrameCount = this.aaY.frame_count;
            this.aba = this.aaY.repeatCount;
            this.mImageWidth = this.aaY.width;
            this.mImageHeight = this.aaY.height;
            this.aaZ = (1.0d / this.aaY.frame_rate) * 1000.0d;
            this.abe = qM();
            this.abh = (int) (this.aaY.oppositeX * this.abd);
            this.abg = (int) (this.aaY.oppositeY * this.mScreenHeight);
            if (this.abi != null) {
                this.abi.onDestroy();
                this.abi = null;
            }
            this.abi = new b();
            this.abi.setScreen(this.abd, this.mScreenHeight);
            this.abi.a(cVar);
        }
    }

    public void f(Canvas canvas) {
        RectF rectF;
        if (qN()) {
            if (this.aba <= 1) {
                if (this.aaT != null) {
                    this.aaT.qL();
                    return;
                }
                return;
            }
            this.abb = 0;
            this.aba--;
        }
        if (this.aaT != null) {
            if (this.abb == 0 && !this.abj) {
                this.abj = true;
                this.aaT.qK();
            } else {
                this.aaT.bq(this.abb);
            }
        }
        c br = this.abi.br(this.abb);
        if (br == null || br.bitmap == null || br.bitmap.isRecycled()) {
            if (this.abf > 5) {
                if (this.aaT != null) {
                    this.aaT.qL();
                }
            } else if (this.abf > 1) {
                this.abi.qS();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.abi != null && this.abi.getHandler() != null) {
                this.abi.getHandler().sendMessage(obtain);
            }
            this.abf++;
            return;
        }
        this.abb++;
        float width = br.abJ * br.bitmap.getWidth() * this.abe;
        float height = br.abJ * br.bitmap.getHeight() * this.abe;
        canvas.save();
        if (this.abh + width > this.abd) {
            this.abh = (int) (this.abd - width);
        }
        if (this.abg + height > this.mScreenHeight) {
            this.abg = (int) (this.mScreenHeight - height);
        }
        if (this.aaY.isBottomMargin()) {
            rectF = new RectF(this.abh, (this.mScreenHeight - height) - this.abg, width + this.abh, this.mScreenHeight - this.abg);
        } else {
            rectF = new RectF(this.abh, this.abg, width + this.abh, height + this.abg);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!br.bitmap.isRecycled()) {
                canvas.drawBitmap(br.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        br.abK = true;
        this.abi.cv(br.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.abi.getHandler().sendMessage(obtain2);
    }

    private float qM() {
        float f = this.abd > this.mScreenHeight ? (this.abd * 1.0f) / 1334.0f : (this.abd * 1.0f) / 750.0f;
        if (this.abd > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean qN() {
        return this.abb + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.abi != null) {
            this.abi.clearCache();
        }
    }

    public boolean qO() {
        return this.abi.qO();
    }

    public double qP() {
        return this.aaZ;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.aaT = aVar;
    }
}
