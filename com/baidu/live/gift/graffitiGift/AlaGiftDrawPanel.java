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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<m> aeE;
    private Bitmap aeI;
    private g aeJ;
    private Paint akj;
    private ArrayList<PointF> akk;
    private ArrayList<PointF> akl;
    private a akm;
    private boolean akn;
    private float ako;
    private float akp;
    private float akq;
    private float akr;
    private PointF aks;
    private boolean akt;
    private int aku;
    private int akv;
    private int akw;
    private int mBackgroundColor;

    /* loaded from: classes2.dex */
    public interface a {
        void c(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.akn = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akn = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akn = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.akj = new Paint();
        this.akj.setAntiAlias(true);
        this.akj.setFilterBitmap(true);
        this.akj.setDither(true);
        this.akk = new ArrayList<>();
        this.akl = new ArrayList<>();
        this.aeE = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.akq = dip2px;
        this.ako = dip2px;
        float f = this.akq / 2.0f;
        this.akr = f;
        this.akp = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.akw = this.akk.size();
                this.akl.clear();
                a(pointF);
                break;
            case 1:
                this.akn = false;
                sd();
                this.akk.addAll(this.akl);
                sQ();
                break;
            case 2:
                if (!this.akn) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.akn = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aeI != null && !this.aeI.isRecycled()) {
            if (c(pointF)) {
                this.akt = true;
                this.aks = pointF;
                this.akl.add(pointF);
                if (this.akm != null) {
                    this.akm.c(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.akt = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.akt) {
            if (c(pointF, this.aks)) {
                e(this.aks, pointF);
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
            if (i2 >= this.akk.size()) {
                break;
            }
            PointF pointF = this.akk.get(i2);
            float f = pointF.x - this.akp;
            float f2 = pointF.y - this.akr;
            Bitmap bF = bF(i2);
            if (bF != null && !bF.isRecycled()) {
                canvas.drawBitmap(bF, f, f2, this.akj);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.akl.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.akp;
            float f4 = next.y - this.akr;
            if (this.aeI != null) {
                canvas.drawBitmap(this.aeI, f3, f4, this.akj);
            }
        }
    }

    private Bitmap bF(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aeE.size()) {
                m mVar = this.aeE.get(i4);
                if (i3 < i && i <= mVar.rg() + i3) {
                    return mVar.aeI;
                }
                i3 += mVar.rg();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.ako / width;
        float f2 = this.akq / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aeI = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.akm = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void sP() {
        if (this.akm != null && !ListUtils.isEmpty(this.akk)) {
            this.akm.c(0, 0L);
        }
        ListUtils.clear(this.akk);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aku = i;
        this.akv = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.akv) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.akv && pointF.x > this.akp && pointF.x < ((float) getWidth()) - this.akp && pointF.y > this.akr && pointF.y < ((float) getHeight()) - this.akr;
    }

    public int getCurrentPointSize() {
        return this.akk.size() + this.akl.size();
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.akq;
    }

    private float d(PointF pointF, PointF pointF2) {
        float f = pointF2.x - pointF.x;
        float f2 = pointF2.y - pointF.y;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private void e(PointF pointF, PointF pointF2) {
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
                if (d(pointF3, pointF4) < this.akq) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.akv) {
                    this.akl.add(pointF4);
                    this.aks = pointF4;
                    if (this.akm != null) {
                        this.akm.c(getCurrentPointSize(), getTotalPrice());
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
            if (d(pointF5, pointF6) < this.akq) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.akv) {
                this.akl.add(pointF6);
                this.aks = pointF6;
                if (this.akm != null) {
                    this.akm.c(getCurrentPointSize(), getTotalPrice());
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
        return this.akk;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aeE;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aeE) {
            j = mVar.aeJ != null ? (mVar.rg() * JavaTypesHelper.toLong(mVar.aeJ.getPrice(), 0L)) + j : j;
        }
        if (this.akl.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aeJ.getPrice(), 0L) * this.akl.size());
        }
        return j;
    }

    public void aF(boolean z) {
        if (this.aeE != null) {
            if (z) {
                for (m mVar : this.aeE) {
                    if (mVar.aeI != null && !mVar.aeI.isRecycled()) {
                        mVar.aeI.recycle();
                        mVar.aeI = null;
                    }
                }
            } else {
                for (m mVar2 : this.aeE) {
                    if (mVar2.aeI != null && !mVar2.aeI.isRecycled() && mVar2.aeJ != this.aeJ) {
                        mVar2.aeI.recycle();
                        mVar2.aeI = null;
                    }
                }
            }
        }
        if (this.aeE != null) {
            this.aeE.clear();
        }
        sQ();
        sP();
        postInvalidate();
    }

    public void sd() {
        if (this.aeE != null && this.akl != null && this.akl.size() > 0) {
            this.aeE.add(getAlaGraffitiPointDesData());
        }
    }

    public void sQ() {
        if (this.akl != null) {
            this.akl.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aeI = this.aeI;
        mVar.aeJ = this.aeJ;
        mVar.cY(this.aeJ != null ? this.aeJ.qA() : "");
        mVar.setGiftId(this.aeJ != null ? Integer.parseInt(this.aeJ.qx()) : 0);
        mVar.bl(getCurrentPointSize() - this.akw);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aeJ = gVar;
    }

    public void sR() {
        if (this.aeE != null && this.aeE.size() > 0) {
            for (int rg = this.aeE.get(this.aeE.size() - 1).rg(); rg > 0; rg--) {
                this.akk.remove(this.akk.size() - 1);
            }
            this.aeE.remove(this.aeE.size() - 1);
            postInvalidate();
            if (this.akm != null) {
                this.akm.c(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
