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
    public List<m> aAe;
    private Bitmap aAi;
    private g aAj;
    private Paint aFR;
    private ArrayList<PointF> aFS;
    private ArrayList<PointF> aFT;
    private a aFU;
    private boolean aFV;
    private float aFW;
    private float aFX;
    private float aFY;
    private float aFZ;
    private PointF aGa;
    private boolean aGb;
    private int aGc;
    private int aGd;
    private int aGe;
    private int mBackgroundColor;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.aFV = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFV = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFV = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.aFR = new Paint();
        this.aFR.setAntiAlias(true);
        this.aFR.setFilterBitmap(true);
        this.aFR.setDither(true);
        this.aFS = new ArrayList<>();
        this.aFT = new ArrayList<>();
        this.aAe = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aFY = dip2px;
        this.aFW = dip2px;
        float f = this.aFY / 2.0f;
        this.aFZ = f;
        this.aFX = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.aGe = this.aFS.size();
                this.aFT.clear();
                a(pointF);
                break;
            case 1:
                this.aFV = false;
                yW();
                this.aFS.addAll(this.aFT);
                yX();
                break;
            case 2:
                if (!this.aFV) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.aFV = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aAi != null && !this.aAi.isRecycled()) {
            if (c(pointF)) {
                this.aGb = true;
                this.aGa = pointF;
                this.aFT.add(pointF);
                if (this.aFU != null) {
                    this.aFU.c(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.aGb = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.aGb) {
            if (b(pointF, this.aGa)) {
                d(this.aGa, pointF);
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
            if (i2 >= this.aFS.size()) {
                break;
            }
            PointF pointF = this.aFS.get(i2);
            float f = pointF.x - this.aFX;
            float f2 = pointF.y - this.aFZ;
            Bitmap cc = cc(i2);
            if (cc != null && !cc.isRecycled()) {
                canvas.drawBitmap(cc, f, f2, this.aFR);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.aFT.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.aFX;
            float f4 = next.y - this.aFZ;
            if (this.aAi != null) {
                canvas.drawBitmap(this.aAi, f3, f4, this.aFR);
            }
        }
    }

    private Bitmap cc(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aAe.size()) {
                m mVar = this.aAe.get(i4);
                if (i3 < i && i <= mVar.wQ() + i3) {
                    return mVar.aAi;
                }
                i3 += mVar.wQ();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.aFW / width;
        float f2 = this.aFY / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aAi = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aFU = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void yV() {
        if (this.aFU != null && !ListUtils.isEmpty(this.aFS)) {
            this.aFU.c(0, 0L);
        }
        ListUtils.clear(this.aFS);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aGc = i;
        this.aGd = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.aGd) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.aGd && pointF.x > this.aFX && pointF.x < ((float) getWidth()) - this.aFX && pointF.y > this.aFZ && pointF.y < ((float) getHeight()) - this.aFZ;
    }

    public int getCurrentPointSize() {
        return this.aFS.size() + this.aFT.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.aFY;
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
                if (c(pointF3, pointF4) < this.aFY) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.aGd) {
                    this.aFT.add(pointF4);
                    this.aGa = pointF4;
                    if (this.aFU != null) {
                        this.aFU.c(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.aFY) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.aGd) {
                this.aFT.add(pointF6);
                this.aGa = pointF6;
                if (this.aFU != null) {
                    this.aFU.c(getCurrentPointSize(), getTotalPrice());
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
        return this.aFS;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aAe;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aAe) {
            j = mVar.aAj != null ? (mVar.wQ() * JavaTypesHelper.toLong(mVar.aAj.getPrice(), 0L)) + j : j;
        }
        if (this.aFT.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aAj.getPrice(), 0L) * this.aFT.size());
        }
        return j;
    }

    public void br(boolean z) {
        if (this.aAe != null) {
            if (z) {
                for (m mVar : this.aAe) {
                    if (mVar.aAi != null && !mVar.aAi.isRecycled()) {
                        mVar.aAi.recycle();
                        mVar.aAi = null;
                    }
                }
            } else {
                for (m mVar2 : this.aAe) {
                    if (mVar2.aAi != null && !mVar2.aAi.isRecycled() && mVar2.aAj != this.aAj) {
                        mVar2.aAi.recycle();
                        mVar2.aAi = null;
                    }
                }
            }
        }
        if (this.aAe != null) {
            this.aAe.clear();
        }
        yX();
        yV();
        postInvalidate();
    }

    public void yW() {
        if (this.aAe != null && this.aFT != null && this.aFT.size() > 0) {
            this.aAe.add(getAlaGraffitiPointDesData());
        }
    }

    public void yX() {
        if (this.aFT != null) {
            this.aFT.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aAi = this.aAi;
        mVar.aAj = this.aAj;
        mVar.dZ(this.aAj != null ? this.aAj.vX() : "");
        mVar.setGiftId(this.aAj != null ? Integer.parseInt(this.aAj.vU()) : 0);
        mVar.bF(getCurrentPointSize() - this.aGe);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aAj = gVar;
    }

    public void yY() {
        if (this.aAe != null && this.aAe.size() > 0) {
            for (int wQ = this.aAe.get(this.aAe.size() - 1).wQ(); wQ > 0; wQ--) {
                this.aFS.remove(this.aFS.size() - 1);
            }
            this.aAe.remove(this.aAe.size() - 1);
            postInvalidate();
            if (this.aFU != null) {
                this.aFU.c(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
