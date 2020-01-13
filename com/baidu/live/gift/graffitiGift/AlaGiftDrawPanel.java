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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<m> afn;
    private Bitmap afr;
    private g afs;
    private Paint akV;
    private ArrayList<PointF> akW;
    private ArrayList<PointF> akX;
    private a akY;
    private boolean akZ;
    private float ala;
    private float alb;
    private float alc;
    private float ald;
    private PointF ale;
    private boolean alf;
    private int alg;
    private int alh;
    private int ali;
    private int mBackgroundColor;

    /* loaded from: classes2.dex */
    public interface a {
        void c(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.akZ = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akZ = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akZ = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.akV = new Paint();
        this.akV.setAntiAlias(true);
        this.akV.setFilterBitmap(true);
        this.akV.setDither(true);
        this.akW = new ArrayList<>();
        this.akX = new ArrayList<>();
        this.afn = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.alc = dip2px;
        this.ala = dip2px;
        float f = this.alc / 2.0f;
        this.ald = f;
        this.alb = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.ali = this.akW.size();
                this.akX.clear();
                a(pointF);
                break;
            case 1:
                this.akZ = false;
                st();
                this.akW.addAll(this.akX);
                tg();
                break;
            case 2:
                if (!this.akZ) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.akZ = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.afr != null && !this.afr.isRecycled()) {
            if (c(pointF)) {
                this.alf = true;
                this.ale = pointF;
                this.akX.add(pointF);
                if (this.akY != null) {
                    this.akY.c(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.alf = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.alf) {
            if (c(pointF, this.ale)) {
                e(this.ale, pointF);
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
            if (i2 >= this.akW.size()) {
                break;
            }
            PointF pointF = this.akW.get(i2);
            float f = pointF.x - this.alb;
            float f2 = pointF.y - this.ald;
            Bitmap bF = bF(i2);
            if (bF != null && !bF.isRecycled()) {
                canvas.drawBitmap(bF, f, f2, this.akV);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.akX.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.alb;
            float f4 = next.y - this.ald;
            if (this.afr != null) {
                canvas.drawBitmap(this.afr, f3, f4, this.akV);
            }
        }
    }

    private Bitmap bF(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.afn.size()) {
                m mVar = this.afn.get(i4);
                if (i3 < i && i <= mVar.rs() + i3) {
                    return mVar.afr;
                }
                i3 += mVar.rs();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.ala / width;
        float f2 = this.alc / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.afr = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.akY = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void tf() {
        if (this.akY != null && !ListUtils.isEmpty(this.akW)) {
            this.akY.c(0, 0L);
        }
        ListUtils.clear(this.akW);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.alg = i;
        this.alh = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.alh) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.alh && pointF.x > this.alb && pointF.x < ((float) getWidth()) - this.alb && pointF.y > this.ald && pointF.y < ((float) getHeight()) - this.ald;
    }

    public int getCurrentPointSize() {
        return this.akW.size() + this.akX.size();
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.alc;
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
                if (d(pointF3, pointF4) < this.alc) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.alh) {
                    this.akX.add(pointF4);
                    this.ale = pointF4;
                    if (this.akY != null) {
                        this.akY.c(getCurrentPointSize(), getTotalPrice());
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
            if (d(pointF5, pointF6) < this.alc) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.alh) {
                this.akX.add(pointF6);
                this.ale = pointF6;
                if (this.akY != null) {
                    this.akY.c(getCurrentPointSize(), getTotalPrice());
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
        return this.akW;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.afn;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.afn) {
            j = mVar.afs != null ? (mVar.rs() * JavaTypesHelper.toLong(mVar.afs.getPrice(), 0L)) + j : j;
        }
        if (this.akX.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.afs.getPrice(), 0L) * this.akX.size());
        }
        return j;
    }

    public void aH(boolean z) {
        if (this.afn != null) {
            if (z) {
                for (m mVar : this.afn) {
                    if (mVar.afr != null && !mVar.afr.isRecycled()) {
                        mVar.afr.recycle();
                        mVar.afr = null;
                    }
                }
            } else {
                for (m mVar2 : this.afn) {
                    if (mVar2.afr != null && !mVar2.afr.isRecycled() && mVar2.afs != this.afs) {
                        mVar2.afr.recycle();
                        mVar2.afr = null;
                    }
                }
            }
        }
        if (this.afn != null) {
            this.afn.clear();
        }
        tg();
        tf();
        postInvalidate();
    }

    public void st() {
        if (this.afn != null && this.akX != null && this.akX.size() > 0) {
            this.afn.add(getAlaGraffitiPointDesData());
        }
    }

    public void tg() {
        if (this.akX != null) {
            this.akX.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.afr = this.afr;
        mVar.afs = this.afs;
        mVar.da(this.afs != null ? this.afs.qH() : "");
        mVar.setGiftId(this.afs != null ? Integer.parseInt(this.afs.qE()) : 0);
        mVar.bl(getCurrentPointSize() - this.ali);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.afs = gVar;
    }

    public void th() {
        if (this.afn != null && this.afn.size() > 0) {
            for (int rs = this.afn.get(this.afn.size() - 1).rs(); rs > 0; rs--) {
                this.akW.remove(this.akW.size() - 1);
            }
            this.afn.remove(this.afn.size() - 1);
            postInvalidate();
            if (this.akY != null) {
                this.akY.c(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
