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
/* loaded from: classes11.dex */
public class a {
    private AlaDynamicGiftAnimationView.a bfg;
    private d bfj;
    private int bfn;
    private int bfq;
    private int bfr;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double bfk = 100.0d;
    private int bfl = 1;
    private int bfm = 0;
    private float bfo = 1.0f;
    private int bfp = 0;
    private boolean bft = false;
    private b bfs = new b();

    public void setScreen(int i, int i2) {
        this.bfn = i;
        this.mScreenHeight = i2;
        if (this.bfs != null) {
            this.bfs.setScreen(this.bfn, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.bfm = 0;
            this.bft = false;
            this.bfp = 0;
            this.bfj = cVar.aXb.aWZ;
            this.mFrameCount = this.bfj.frame_count;
            this.bfl = this.bfj.repeatCount;
            this.mImageWidth = this.bfj.width;
            this.mImageHeight = this.bfj.height;
            this.bfk = (1.0d / this.bfj.frame_rate) * 1000.0d;
            this.bfo = Js();
            this.bfr = (int) (this.bfj.oppositeX * this.bfn);
            this.bfq = (int) (this.bfj.oppositeY * this.mScreenHeight);
            if (this.bfs != null) {
                this.bfs.onDestroy();
                this.bfs = null;
            }
            this.bfs = new b();
            this.bfs.setScreen(this.bfn, this.mScreenHeight);
            this.bfs.c(cVar);
        }
    }

    public void h(Canvas canvas) {
        RectF rectF;
        if (Jt()) {
            if (this.bfl <= 1) {
                if (this.bfg != null) {
                    this.bfg.Jr();
                    return;
                }
                return;
            }
            this.bfm = 0;
            this.bfl--;
        }
        if (this.bfg != null) {
            if (this.bfm == 0 && !this.bft) {
                this.bft = true;
                this.bfg.Jq();
            } else {
                this.bfg.eI(this.bfm);
            }
        }
        c eJ = this.bfs.eJ(this.bfm);
        if (eJ == null || eJ.bitmap == null || eJ.bitmap.isRecycled()) {
            if (this.bfp > 5) {
                if (this.bfg != null) {
                    this.bfg.Jr();
                }
            } else if (this.bfp > 1) {
                this.bfs.Jy();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.bfs != null && this.bfs.getHandler() != null) {
                this.bfs.getHandler().sendMessage(obtain);
            }
            this.bfp++;
            return;
        }
        this.bfm++;
        float width = eJ.bfZ * eJ.bitmap.getWidth() * this.bfo;
        float height = eJ.bfZ * eJ.bitmap.getHeight() * this.bfo;
        canvas.save();
        if (this.bfr + width > this.bfn) {
            this.bfr = (int) (this.bfn - width);
        }
        if (this.bfq + height > this.mScreenHeight) {
            this.bfq = (int) (this.mScreenHeight - height);
        }
        if (this.bfj.isBottomMargin()) {
            rectF = new RectF(this.bfr, (this.mScreenHeight - height) - this.bfq, width + this.bfr, this.mScreenHeight - this.bfq);
        } else {
            rectF = new RectF(this.bfr, this.bfq, width + this.bfr, height + this.bfq);
        }
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        try {
            if (!eJ.bitmap.isRecycled()) {
                canvas.drawBitmap(eJ.bitmap, (Rect) null, rectF, paint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restore();
        eJ.bga = true;
        this.bfs.hr(eJ.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.bfs.getHandler().sendMessage(obtain2);
    }

    private float Js() {
        float f = this.bfn > this.mScreenHeight ? (this.bfn * 1.0f) / 1334.0f : (this.bfn * 1.0f) / 750.0f;
        if (this.bfn > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean Jt() {
        return this.bfm + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.bfs != null) {
            this.bfs.clearCache();
        }
    }

    public boolean Ju() {
        return this.bfs.Ju();
    }

    public double Jv() {
        return this.bfk;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.bfg = aVar;
    }
}
