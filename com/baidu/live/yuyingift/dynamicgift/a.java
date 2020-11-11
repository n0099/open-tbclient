package com.baidu.live.yuyingift.dynamicgift;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Message;
import com.baidu.live.gift.d;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView;
/* loaded from: classes4.dex */
public class a {
    private AlaDynamicGiftAnimationView.a bQB;
    private d bbJ;
    private int bbM;
    private int bbP;
    private int bbQ;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double bbK = 100.0d;
    private int mRepeatCount = 1;
    private int bbL = 0;
    private float bbN = 1.0f;
    private int bbO = 0;
    private boolean bbS = false;
    private b bQD = new b();

    public void setScreen(int i, int i2) {
        this.bbM = i;
        this.mScreenHeight = i2;
        if (this.bQD != null) {
            this.bQD.setScreen(this.bbM, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.bbL = 0;
            this.bbS = false;
            this.bbO = 0;
            this.bbJ = cVar.aUe.aUd;
            this.mFrameCount = this.bbJ.frame_count;
            this.mRepeatCount = this.bbJ.repeatCount;
            this.mImageWidth = this.bbJ.width;
            this.mImageHeight = this.bbJ.height;
            this.bbK = (1.0d / this.bbJ.frame_rate) * 1000.0d;
            this.bbN = II();
            this.bbQ = (int) (this.bbJ.oppositeX * this.bbM);
            this.bbP = (int) (this.bbJ.oppositeY * this.mScreenHeight);
            if (this.bQD != null) {
                this.bQD.onDestroy();
                this.bQD = null;
            }
            this.bQD = new b();
            this.bQD.setScreen(this.bbM, this.mScreenHeight);
            this.bQD.c(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (IJ()) {
            if (this.mRepeatCount <= 1) {
                if (this.bQB != null) {
                    this.bQB.IH();
                    return;
                }
                return;
            }
            this.bbL = 0;
            this.mRepeatCount--;
        }
        if (this.bQB != null) {
            if (this.bbL == 0 && !this.bbS) {
                this.bbS = true;
                this.bQB.IG();
            } else {
                this.bQB.et(this.bbL);
            }
        }
        c gz = this.bQD.gz(this.bbL);
        if (gz == null || gz.bitmap == null || gz.bitmap.isRecycled()) {
            if (this.bbO > 5) {
                if (this.bQB != null) {
                    this.bQB.IH();
                }
            } else if (this.bbO > 1) {
                this.bQD.IO();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.bQD != null && this.bQD.getHandler() != null) {
                this.bQD.getHandler().sendMessage(obtain);
            }
            this.bbO++;
            return;
        }
        this.bbL++;
        float width = gz.bcw * gz.bitmap.getWidth() * this.bbN;
        float height = gz.bcw * gz.bitmap.getHeight() * this.bbN;
        canvas.save();
        if (this.bbQ + width > this.bbM) {
            this.bbQ = (int) (this.bbM - width);
        }
        if (this.bbP + height > this.mScreenHeight) {
            this.bbP = (int) (this.mScreenHeight - height);
        }
        if (this.bbJ.isBottomMargin()) {
            rectF = new RectF(this.bbQ, (this.mScreenHeight - height) - this.bbP, width + this.bbQ, this.mScreenHeight - this.bbP);
        } else {
            rectF = new RectF(this.bbQ, this.bbP, width + this.bbQ, height + this.bbP);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!gz.bitmap.isRecycled()) {
                canvas.drawBitmap(gz.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        gz.bcx = true;
        this.bQD.hr(gz.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.bQD.getHandler().sendMessage(obtain2);
    }

    private float II() {
        float f = this.bbM > this.mScreenHeight ? (this.bbM * 1.0f) / 1334.0f : (this.bbM * 1.0f) / 750.0f;
        if (this.bbM > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean IJ() {
        return this.bbL + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.bQD != null) {
            this.bQD.clearCache();
        }
    }

    public boolean IK() {
        return this.bQD.IK();
    }

    public double IL() {
        return this.bbK;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.bQB = aVar;
    }
}
