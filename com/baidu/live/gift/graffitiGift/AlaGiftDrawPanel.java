package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    private Bitmap aAc;
    private g aAd;
    private Paint aFL;
    private ArrayList<PointF> aFM;
    private ArrayList<PointF> aFN;
    private a aFO;
    private boolean aFP;
    private float aFQ;
    private float aFR;
    private float aFS;
    private float aFT;
    private PointF aFU;
    private boolean aFV;
    private int aFW;
    private int aFX;
    private int aFY;
    public List<m> azY;
    private int mBackgroundColor;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.aFP = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFP = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFP = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.aFL = new Paint();
        this.aFL.setAntiAlias(true);
        this.aFL.setFilterBitmap(true);
        this.aFL.setDither(true);
        this.aFM = new ArrayList<>();
        this.aFN = new ArrayList<>();
        this.azY = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aFS = dip2px;
        this.aFQ = dip2px;
        float f = this.aFS / 2.0f;
        this.aFT = f;
        this.aFR = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.aFY = this.aFM.size();
                this.aFN.clear();
                a(pointF);
                break;
            case 1:
                this.aFP = false;
                yX();
                this.aFM.addAll(this.aFN);
                yY();
                break;
            case 2:
                if (!this.aFP) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.aFP = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aAc != null && !this.aAc.isRecycled()) {
            if (c(pointF)) {
                this.aFV = true;
                this.aFU = pointF;
                this.aFN.add(pointF);
                if (this.aFO != null) {
                    this.aFO.c(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.aFV = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.aFV) {
            if (b(pointF, this.aFU)) {
                d(this.aFU, pointF);
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.mBackgroundColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aFM.size()) {
                break;
            }
            PointF pointF = this.aFM.get(i2);
            float f = pointF.x - this.aFR;
            float f2 = pointF.y - this.aFT;
            Bitmap cc = cc(i2);
            if (cc != null && !cc.isRecycled()) {
                canvas.drawBitmap(cc, f, f2, this.aFL);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.aFN.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.aFR;
            float f4 = next.y - this.aFT;
            if (this.aAc != null) {
                canvas.drawBitmap(this.aAc, f3, f4, this.aFL);
            }
        }
    }

    private Bitmap cc(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.azY.size()) {
                m mVar = this.azY.get(i4);
                if (i3 < i && i <= mVar.wR() + i3) {
                    return mVar.aAc;
                }
                i3 += mVar.wR();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.aFQ / width;
        float f2 = this.aFS / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aAc = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aFO = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void yW() {
        if (this.aFO != null && !ListUtils.isEmpty(this.aFM)) {
            this.aFO.c(0, 0L);
        }
        ListUtils.clear(this.aFM);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aFW = i;
        this.aFX = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.aFX) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.aFX && pointF.x > this.aFR && pointF.x < ((float) getWidth()) - this.aFR && pointF.y > this.aFT && pointF.y < ((float) getHeight()) - this.aFT;
    }

    public int getCurrentPointSize() {
        return this.aFM.size() + this.aFN.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.aFS;
    }

    private float c(PointF pointF, PointF pointF2) {
        float f = pointF2.x - pointF.x;
        float f2 = pointF2.y - pointF.y;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private void d(PointF pointF, PointF pointF2) {
        int i;
        int i2;
        int i3;
        int i4 = (int) pointF.x;
        int i5 = (int) pointF.y;
        int i6 = (int) pointF2.x;
        int i7 = (int) pointF2.y;
        int i8 = i6 - i4;
        int i9 = i7 - i5;
        if (i9 < 0) {
            i9 = -i9;
            i = -1;
        } else {
            i = 1;
        }
        if (i8 < 0) {
            i2 = -1;
            i3 = -i8;
        } else {
            i2 = 1;
            i3 = i8;
        }
        int i10 = i9 << 1;
        int i11 = i3 << 1;
        if (i11 > i10) {
            int i12 = i10 - (i11 >> 1);
            int i13 = i4;
            PointF pointF3 = pointF;
            while (i13 != i6) {
                if (i12 >= 0) {
                    i5 += i;
                    i12 -= i11;
                }
                int i14 = i13 + i2;
                int i15 = i12 + i10;
                PointF pointF4 = new PointF(i14, i5);
                if (c(pointF3, pointF4) < this.aFS) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.aFX) {
                    this.aFN.add(pointF4);
                    this.aFU = pointF4;
                    if (this.aFO != null) {
                        this.aFO.c(getCurrentPointSize(), getTotalPrice());
                    }
                } else {
                    return;
                }
                pointF3 = pointF4;
                i12 = i15;
                i13 = i14;
            }
            return;
        }
        int i16 = i11 - (i10 >> 1);
        int i17 = i5;
        int i18 = i4;
        PointF pointF5 = pointF;
        while (i17 != i7) {
            if (i16 >= 0) {
                i18 += i2;
                i16 -= i10;
            }
            int i19 = i17 + i;
            int i20 = i16 + i11;
            PointF pointF6 = new PointF(i18, i19);
            if (c(pointF5, pointF6) < this.aFS) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.aFX) {
                this.aFN.add(pointF6);
                this.aFU = pointF6;
                if (this.aFO != null) {
                    this.aFO.c(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                return;
            }
            pointF5 = pointF6;
            i16 = i20;
            i17 = i19;
        }
    }

    public List<PointF> getPoints() {
        return this.aFM;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.azY;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.azY) {
            j = mVar.aAd != null ? (mVar.wR() * JavaTypesHelper.toLong(mVar.aAd.getPrice(), 0L)) + j : j;
        }
        if (this.aFN.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aAd.getPrice(), 0L) * this.aFN.size());
        }
        return j;
    }

    public void br(boolean z) {
        if (this.azY != null) {
            if (z) {
                for (m mVar : this.azY) {
                    if (mVar.aAc != null && !mVar.aAc.isRecycled()) {
                        mVar.aAc.recycle();
                        mVar.aAc = null;
                    }
                }
            } else {
                for (m mVar2 : this.azY) {
                    if (mVar2.aAc != null && !mVar2.aAc.isRecycled() && mVar2.aAd != this.aAd) {
                        mVar2.aAc.recycle();
                        mVar2.aAc = null;
                    }
                }
            }
        }
        if (this.azY != null) {
            this.azY.clear();
        }
        yY();
        yW();
        postInvalidate();
    }

    public void yX() {
        if (this.azY != null && this.aFN != null && this.aFN.size() > 0) {
            this.azY.add(getAlaGraffitiPointDesData());
        }
    }

    public void yY() {
        if (this.aFN != null) {
            this.aFN.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aAc = this.aAc;
        mVar.aAd = this.aAd;
        mVar.dZ(this.aAd != null ? this.aAd.vY() : "");
        mVar.setGiftId(this.aAd != null ? Integer.parseInt(this.aAd.vV()) : 0);
        mVar.bF(getCurrentPointSize() - this.aFY);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aAd = gVar;
    }

    public void yZ() {
        if (this.azY != null && this.azY.size() > 0) {
            for (int wR = this.azY.get(this.azY.size() - 1).wR(); wR > 0; wR--) {
                this.aFM.remove(this.aFM.size() - 1);
            }
            this.azY.remove(this.azY.size() - 1);
            postInvalidate();
            if (this.aFO != null) {
                this.aFO.c(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
