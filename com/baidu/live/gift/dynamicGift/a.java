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
    private AlaDynamicGiftAnimationView.a ama;
    private d amd;
    private int amg;
    private int amj;
    private int amk;
    private int mFrameCount;
    private int mImageHeight;
    private int mImageWidth;
    private int mScreenHeight;
    private double ame = 100.0d;
    private int mRepeatCount = 1;
    private int amf = 0;
    private float amh = 1.0f;
    private int ami = 0;
    private boolean amm = false;
    private b aml = new b();

    public void setScreen(int i, int i2) {
        this.amg = i;
        this.mScreenHeight = i2;
        if (this.aml != null) {
            this.aml.setScreen(this.amg, this.mScreenHeight);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        if (cVar != null) {
            this.amf = 0;
            this.amm = false;
            this.ami = 0;
            this.amd = cVar.afV.afU;
            this.mFrameCount = this.amd.frame_count;
            this.mRepeatCount = this.amd.repeatCount;
            this.mImageWidth = this.amd.width;
            this.mImageHeight = this.amd.height;
            this.ame = (1.0d / this.amd.frame_rate) * 1000.0d;
            this.amh = uc();
            this.amk = (int) (this.amd.oppositeX * this.amg);
            this.amj = (int) (this.amd.oppositeY * this.mScreenHeight);
            if (this.aml != null) {
                this.aml.onDestroy();
                this.aml = null;
            }
            this.aml = new b();
            this.aml.setScreen(this.amg, this.mScreenHeight);
            this.aml.a(cVar);
        }
    }

    public void g(Canvas canvas) {
        RectF rectF;
        if (ud()) {
            if (this.mRepeatCount <= 1) {
                if (this.ama != null) {
                    this.ama.ub();
                    return;
                }
                return;
            }
            this.amf = 0;
            this.mRepeatCount--;
        }
        if (this.ama != null) {
            if (this.amf == 0 && !this.amm) {
                this.amm = true;
                this.ama.ua();
            } else {
                this.ama.bJ(this.amf);
            }
        }
        c bK = this.aml.bK(this.amf);
        if (bK == null || bK.bitmap == null || bK.bitmap.isRecycled()) {
            if (this.ami > 5) {
                if (this.ama != null) {
                    this.ama.ub();
                }
            } else if (this.ami > 1) {
                this.aml.ui();
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (this.aml != null && this.aml.getHandler() != null) {
                this.aml.getHandler().sendMessage(obtain);
            }
            this.ami++;
            return;
        }
        this.amf++;
        float width = bK.amO * bK.bitmap.getWidth() * this.amh;
        float height = bK.amO * bK.bitmap.getHeight() * this.amh;
        canvas.save();
        if (this.amk + width > this.amg) {
            this.amk = (int) (this.amg - width);
        }
        if (this.amj + height > this.mScreenHeight) {
            this.amj = (int) (this.mScreenHeight - height);
        }
        if (this.amd.isBottomMargin()) {
            rectF = new RectF(this.amk, (this.mScreenHeight - height) - this.amj, width + this.amk, this.mScreenHeight - this.amj);
        } else {
            rectF = new RectF(this.amk, this.amj, width + this.amk, height + this.amj);
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
        bK.amP = true;
        this.aml.dy(bK.filePath);
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.aml.getHandler().sendMessage(obtain2);
    }

    private float uc() {
        float f = this.amg > this.mScreenHeight ? (this.amg * 1.0f) / 1334.0f : (this.amg * 1.0f) / 750.0f;
        if (this.amg > this.mScreenHeight) {
            float f2 = (this.mScreenHeight * 1.0f) / 750.0f;
        } else {
            float f3 = (this.mScreenHeight * 1.0f) / 1334.0f;
        }
        return f;
    }

    private boolean ud() {
        return this.amf + 1 >= this.mFrameCount;
    }

    public void release() {
        if (this.aml != null) {
            this.aml.clearCache();
        }
    }

    public boolean ue() {
        return this.aml.ue();
    }

    public double uf() {
        return this.ame;
    }

    public void a(AlaDynamicGiftAnimationView.a aVar) {
        this.ama = aVar;
    }
}
