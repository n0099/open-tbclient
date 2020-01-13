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
    private AlaDynamicGiftAnimationView.a ajH;
    private d ajM;
    private int ajP;
    private int ajS;
    private int ajT;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private final int ajK = 24;
    private final int ajL = 5;
    private double ajN = 100.0d;
    private int mRepeatCount = 1;
    private int ajO = 0;
    private float ajQ = 1.0f;
    private int ajR = 0;
    private boolean ajV = false;
    private b ajU = new b();

    public void setScreen(int i, int i2) {
        this.ajP = i;
        this.mScreenHeight = i2;
        if (this.ajU != null) {
            this.ajU.setScreen(this.ajP, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.ajO = 0;
            this.ajV = false;
            this.ajR = 0;
            this.ajM = cVar.adJ.adI;
            this.mFrameCount = this.ajM.frame_count;
            this.mRepeatCount = this.ajM.repeatCount;
            this.mImageWidth = this.ajM.width;
            this.mImageHeight = this.ajM.height;
            this.ajN = (1.0d / this.ajM.frame_rate) * 1000.0d;
            this.ajQ = sL();
            this.ajT = (int) (this.ajM.oppositeX * this.ajP);
            this.ajS = (int) (this.ajM.oppositeY * this.mScreenHeight);
            if (this.ajU != null) {
                this.ajU.onDestroy();
                this.ajU = null;
            }
            this.ajU = new b();
            this.ajU.setScreen(this.ajP, this.mScreenHeight);
            this.ajU.a(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (sM()) {
            if (this.mRepeatCount <= 1) {
                if (this.ajH != null) {
                    this.ajH.sK();
                    return;
                }
                return;
            }
            this.ajO = 0;
            this.mRepeatCount--;
        }
        if (this.ajH != null) {
            if (this.ajO == 0 && !this.ajV) {
                this.ajV = true;
                this.ajH.sJ();
            } else {
                this.ajH.bC(this.ajO);
            }
        }
        c bD = this.ajU.bD(this.ajO);
        if (bD == null || bD.bitmap == null || bD.bitmap.isRecycled()) {
            if (this.ajR > 5) {
                if (this.ajH != null) {
                    this.ajH.sK();
                }
            } else if (this.ajR > 1) {
                this.ajU.sR();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.ajU != null && this.ajU.getHandler() != null) {
                this.ajU.getHandler().sendMessage(obtain);
            }
            this.ajR++;
            return;
        }
        this.ajO++;
        float width = bD.aks * bD.bitmap.getWidth() * this.ajQ;
        float height = bD.aks * bD.bitmap.getHeight() * this.ajQ;
        canvas.save();
        if (this.ajT + width > this.ajP) {
            this.ajT = (int) (this.ajP - width);
        }
        if (this.ajS + height > this.mScreenHeight) {
            this.ajS = (int) (this.mScreenHeight - height);
        }
        if (this.ajM.isBottomMargin()) {
            rectF = new RectF(this.ajT, (this.mScreenHeight - height) - this.ajS, width + this.ajT, this.mScreenHeight - this.ajS);
        } else {
            rectF = new RectF(this.ajT, this.ajS, width + this.ajT, height + this.ajS);
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
        bD.akt = true;
        this.ajU.dp(bD.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.ajU.getHandler().sendMessage(obtain2);
    }

    private float sL() {
        float f = this.ajP > this.mScreenHeight ? (this.ajP * 1.0f) / 1334.0f : (this.ajP * 1.0f) / 750.0f;
        if (this.ajP > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean sM() {
        return this.ajO + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.ajU != null) {
            this.ajU.clearCache();
        }
    }

    public boolean sN() {
        return this.ajU.sN();
    }

    public double sO() {
        return this.ajN;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.ajH = aVar;
    }
}
