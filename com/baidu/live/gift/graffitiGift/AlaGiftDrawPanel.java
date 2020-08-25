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
/* loaded from: classes7.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    private Bitmap aOC;
    private g aOD;
    public List<m> aOy;
    private Paint aUO;
    private ArrayList<PointF> aUP;
    private ArrayList<PointF> aUQ;
    private a aUR;
    private boolean aUS;
    private float aUT;
    private float aUU;
    private float aUV;
    private float aUW;
    private PointF aUX;
    private boolean aUY;
    private int aUZ;
    private int aVa;
    private int aVb;
    private int mBackgroundColor;

    /* loaded from: classes7.dex */
    public interface a {
        void d(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.aUS = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUS = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUS = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.aUO = new Paint();
        this.aUO.setAntiAlias(true);
        this.aUO.setFilterBitmap(true);
        this.aUO.setDither(true);
        this.aUP = new ArrayList<>();
        this.aUQ = new ArrayList<>();
        this.aOy = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aUV = dip2px;
        this.aUT = dip2px;
        float f = this.aUV / 2.0f;
        this.aUW = f;
        this.aUU = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.aVb = this.aUP.size();
                this.aUQ.clear();
                a(pointF);
                break;
            case 1:
                this.aUS = false;
                GP();
                this.aUP.addAll(this.aUQ);
                GQ();
                break;
            case 2:
                if (!this.aUS) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.aUS = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aOC != null && !this.aOC.isRecycled()) {
            if (c(pointF)) {
                this.aUY = true;
                this.aUX = pointF;
                this.aUQ.add(pointF);
                if (this.aUR != null) {
                    this.aUR.d(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.aUY = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.aUY) {
            if (b(pointF, this.aUX)) {
                d(this.aUX, pointF);
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
            if (i2 >= this.aUP.size()) {
                break;
            }
            PointF pointF = this.aUP.get(i2);
            float f = pointF.x - this.aUU;
            float f2 = pointF.y - this.aUW;
            Bitmap en = en(i2);
            if (en != null && !en.isRecycled()) {
                canvas.drawBitmap(en, f, f2, this.aUO);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.aUQ.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.aUU;
            float f4 = next.y - this.aUW;
            if (this.aOC != null) {
                canvas.drawBitmap(this.aOC, f3, f4, this.aUO);
            }
        }
    }

    private Bitmap en(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aOy.size()) {
                m mVar = this.aOy.get(i4);
                if (i3 < i && i <= mVar.EM() + i3) {
                    return mVar.aOC;
                }
                i3 += mVar.EM();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.aUT / width;
        float f2 = this.aUV / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aOC = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aUR = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void GO() {
        if (this.aUR != null && !ListUtils.isEmpty(this.aUP)) {
            this.aUR.d(0, 0L);
        }
        ListUtils.clear(this.aUP);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aUZ = i;
        this.aVa = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.aVa) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.aVa && pointF.x > this.aUU && pointF.x < ((float) getWidth()) - this.aUU && pointF.y > this.aUW && pointF.y < ((float) getHeight()) - this.aUW;
    }

    public int getCurrentPointSize() {
        return this.aUP.size() + this.aUQ.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.aUV;
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
                if (c(pointF3, pointF4) < this.aUV) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.aVa) {
                    this.aUQ.add(pointF4);
                    this.aUX = pointF4;
                    if (this.aUR != null) {
                        this.aUR.d(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.aUV) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.aVa) {
                this.aUQ.add(pointF6);
                this.aUX = pointF6;
                if (this.aUR != null) {
                    this.aUR.d(getCurrentPointSize(), getTotalPrice());
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
        return this.aUP;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aOy;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aOy) {
            j = mVar.aOD != null ? (mVar.EM() * JavaTypesHelper.toLong(mVar.aOD.getPrice(), 0L)) + j : j;
        }
        if (this.aUQ.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aOD.getPrice(), 0L) * this.aUQ.size());
        }
        return j;
    }

    public void bI(boolean z) {
        if (this.aOy != null) {
            if (z) {
                for (m mVar : this.aOy) {
                    if (mVar.aOC != null && !mVar.aOC.isRecycled()) {
                        mVar.aOC.recycle();
                        mVar.aOC = null;
                    }
                }
            } else {
                for (m mVar2 : this.aOy) {
                    if (mVar2.aOC != null && !mVar2.aOC.isRecycled() && mVar2.aOD != this.aOD) {
                        mVar2.aOC.recycle();
                        mVar2.aOC = null;
                    }
                }
            }
        }
        if (this.aOy != null) {
            this.aOy.clear();
        }
        GQ();
        GO();
        postInvalidate();
    }

    public void GP() {
        if (this.aOy != null && this.aUQ != null && this.aUQ.size() > 0) {
            this.aOy.add(getAlaGraffitiPointDesData());
        }
    }

    public void GQ() {
        if (this.aUQ != null) {
            this.aUQ.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aOC = this.aOC;
        mVar.aOD = this.aOD;
        mVar.gf(this.aOD != null ? this.aOD.getThumbnail_url() : "");
        mVar.setGiftId(this.aOD != null ? Integer.parseInt(this.aOD.DR()) : 0);
        mVar.dN(getCurrentPointSize() - this.aVb);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aOD = gVar;
    }

    public void GR() {
        if (this.aOy != null && this.aOy.size() > 0) {
            for (int EM = this.aOy.get(this.aOy.size() - 1).EM(); EM > 0; EM--) {
                this.aUP.remove(this.aUP.size() - 1);
            }
            this.aOy.remove(this.aOy.size() - 1);
            postInvalidate();
            if (this.aUR != null) {
                this.aUR.d(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
