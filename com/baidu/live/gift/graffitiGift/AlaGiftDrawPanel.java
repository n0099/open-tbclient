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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<m> aHS;
    private Bitmap aHW;
    private g aHX;
    private Paint aOf;
    private ArrayList<PointF> aOg;
    private ArrayList<PointF> aOh;
    private a aOi;
    private boolean aOj;
    private float aOk;
    private float aOl;
    private float aOm;
    private float aOn;
    private PointF aOo;
    private boolean aOp;
    private int aOq;
    private int aOr;
    private int aOs;
    private int mBackgroundColor;

    /* loaded from: classes3.dex */
    public interface a {
        void d(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.aOj = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOj = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOj = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.aOf = new Paint();
        this.aOf.setAntiAlias(true);
        this.aOf.setFilterBitmap(true);
        this.aOf.setDither(true);
        this.aOg = new ArrayList<>();
        this.aOh = new ArrayList<>();
        this.aHS = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aOm = dip2px;
        this.aOk = dip2px;
        float f = this.aOm / 2.0f;
        this.aOn = f;
        this.aOl = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.aOs = this.aOg.size();
                this.aOh.clear();
                a(pointF);
                break;
            case 1:
                this.aOj = false;
                AK();
                this.aOg.addAll(this.aOh);
                AL();
                break;
            case 2:
                if (!this.aOj) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.aOj = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aHW != null && !this.aHW.isRecycled()) {
            if (c(pointF)) {
                this.aOp = true;
                this.aOo = pointF;
                this.aOh.add(pointF);
                if (this.aOi != null) {
                    this.aOi.d(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.aOp = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.aOp) {
            if (b(pointF, this.aOo)) {
                d(this.aOo, pointF);
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
            if (i2 >= this.aOg.size()) {
                break;
            }
            PointF pointF = this.aOg.get(i2);
            float f = pointF.x - this.aOl;
            float f2 = pointF.y - this.aOn;
            Bitmap cr = cr(i2);
            if (cr != null && !cr.isRecycled()) {
                canvas.drawBitmap(cr, f, f2, this.aOf);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.aOh.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.aOl;
            float f4 = next.y - this.aOn;
            if (this.aHW != null) {
                canvas.drawBitmap(this.aHW, f3, f4, this.aOf);
            }
        }
    }

    private Bitmap cr(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aHS.size()) {
                m mVar = this.aHS.get(i4);
                if (i3 < i && i <= mVar.yH() + i3) {
                    return mVar.aHW;
                }
                i3 += mVar.yH();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.aOk / width;
        float f2 = this.aOm / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aHW = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aOi = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void AJ() {
        if (this.aOi != null && !ListUtils.isEmpty(this.aOg)) {
            this.aOi.d(0, 0L);
        }
        ListUtils.clear(this.aOg);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aOq = i;
        this.aOr = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.aOr) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.aOr && pointF.x > this.aOl && pointF.x < ((float) getWidth()) - this.aOl && pointF.y > this.aOn && pointF.y < ((float) getHeight()) - this.aOn;
    }

    public int getCurrentPointSize() {
        return this.aOg.size() + this.aOh.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.aOm;
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
                if (c(pointF3, pointF4) < this.aOm) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.aOr) {
                    this.aOh.add(pointF4);
                    this.aOo = pointF4;
                    if (this.aOi != null) {
                        this.aOi.d(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.aOm) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.aOr) {
                this.aOh.add(pointF6);
                this.aOo = pointF6;
                if (this.aOi != null) {
                    this.aOi.d(getCurrentPointSize(), getTotalPrice());
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
        return this.aOg;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aHS;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aHS) {
            j = mVar.aHX != null ? (mVar.yH() * JavaTypesHelper.toLong(mVar.aHX.getPrice(), 0L)) + j : j;
        }
        if (this.aOh.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aHX.getPrice(), 0L) * this.aOh.size());
        }
        return j;
    }

    public void bA(boolean z) {
        if (this.aHS != null) {
            if (z) {
                for (m mVar : this.aHS) {
                    if (mVar.aHW != null && !mVar.aHW.isRecycled()) {
                        mVar.aHW.recycle();
                        mVar.aHW = null;
                    }
                }
            } else {
                for (m mVar2 : this.aHS) {
                    if (mVar2.aHW != null && !mVar2.aHW.isRecycled() && mVar2.aHX != this.aHX) {
                        mVar2.aHW.recycle();
                        mVar2.aHW = null;
                    }
                }
            }
        }
        if (this.aHS != null) {
            this.aHS.clear();
        }
        AL();
        AJ();
        postInvalidate();
    }

    public void AK() {
        if (this.aHS != null && this.aOh != null && this.aOh.size() > 0) {
            this.aHS.add(getAlaGraffitiPointDesData());
        }
    }

    public void AL() {
        if (this.aOh != null) {
            this.aOh.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aHW = this.aHW;
        mVar.aHX = this.aHX;
        mVar.eM(this.aHX != null ? this.aHX.getThumbnail_url() : "");
        mVar.setGiftId(this.aHX != null ? Integer.parseInt(this.aHX.xM()) : 0);
        mVar.bU(getCurrentPointSize() - this.aOs);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aHX = gVar;
    }

    public void AM() {
        if (this.aHS != null && this.aHS.size() > 0) {
            for (int yH = this.aHS.get(this.aHS.size() - 1).yH(); yH > 0; yH--) {
                this.aOg.remove(this.aOg.size() - 1);
            }
            this.aHS.remove(this.aHS.size() - 1);
            postInvalidate();
            if (this.aOi != null) {
                this.aOi.d(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
