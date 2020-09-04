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
    public List<m> aOA;
    private Bitmap aOE;
    private g aOF;
    private Paint aUQ;
    private ArrayList<PointF> aUR;
    private ArrayList<PointF> aUS;
    private a aUT;
    private boolean aUU;
    private float aUV;
    private float aUW;
    private float aUX;
    private float aUY;
    private PointF aUZ;
    private boolean aVa;
    private int aVb;
    private int aVc;
    private int aVd;
    private int mBackgroundColor;

    /* loaded from: classes7.dex */
    public interface a {
        void d(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.aUU = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUU = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUU = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.aUQ = new Paint();
        this.aUQ.setAntiAlias(true);
        this.aUQ.setFilterBitmap(true);
        this.aUQ.setDither(true);
        this.aUR = new ArrayList<>();
        this.aUS = new ArrayList<>();
        this.aOA = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aUX = dip2px;
        this.aUV = dip2px;
        float f = this.aUX / 2.0f;
        this.aUY = f;
        this.aUW = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.aVd = this.aUR.size();
                this.aUS.clear();
                a(pointF);
                break;
            case 1:
                this.aUU = false;
                GP();
                this.aUR.addAll(this.aUS);
                GQ();
                break;
            case 2:
                if (!this.aUU) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.aUU = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aOE != null && !this.aOE.isRecycled()) {
            if (c(pointF)) {
                this.aVa = true;
                this.aUZ = pointF;
                this.aUS.add(pointF);
                if (this.aUT != null) {
                    this.aUT.d(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.aVa = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.aVa) {
            if (b(pointF, this.aUZ)) {
                d(this.aUZ, pointF);
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
            if (i2 >= this.aUR.size()) {
                break;
            }
            PointF pointF = this.aUR.get(i2);
            float f = pointF.x - this.aUW;
            float f2 = pointF.y - this.aUY;
            Bitmap en = en(i2);
            if (en != null && !en.isRecycled()) {
                canvas.drawBitmap(en, f, f2, this.aUQ);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.aUS.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.aUW;
            float f4 = next.y - this.aUY;
            if (this.aOE != null) {
                canvas.drawBitmap(this.aOE, f3, f4, this.aUQ);
            }
        }
    }

    private Bitmap en(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aOA.size()) {
                m mVar = this.aOA.get(i4);
                if (i3 < i && i <= mVar.EM() + i3) {
                    return mVar.aOE;
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
        float f = this.aUV / width;
        float f2 = this.aUX / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aOE = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aUT = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void GO() {
        if (this.aUT != null && !ListUtils.isEmpty(this.aUR)) {
            this.aUT.d(0, 0L);
        }
        ListUtils.clear(this.aUR);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aVb = i;
        this.aVc = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.aVc) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.aVc && pointF.x > this.aUW && pointF.x < ((float) getWidth()) - this.aUW && pointF.y > this.aUY && pointF.y < ((float) getHeight()) - this.aUY;
    }

    public int getCurrentPointSize() {
        return this.aUR.size() + this.aUS.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.aUX;
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
                if (c(pointF3, pointF4) < this.aUX) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.aVc) {
                    this.aUS.add(pointF4);
                    this.aUZ = pointF4;
                    if (this.aUT != null) {
                        this.aUT.d(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.aUX) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.aVc) {
                this.aUS.add(pointF6);
                this.aUZ = pointF6;
                if (this.aUT != null) {
                    this.aUT.d(getCurrentPointSize(), getTotalPrice());
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
        return this.aUR;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aOA;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aOA) {
            j = mVar.aOF != null ? (mVar.EM() * JavaTypesHelper.toLong(mVar.aOF.getPrice(), 0L)) + j : j;
        }
        if (this.aUS.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aOF.getPrice(), 0L) * this.aUS.size());
        }
        return j;
    }

    public void bI(boolean z) {
        if (this.aOA != null) {
            if (z) {
                for (m mVar : this.aOA) {
                    if (mVar.aOE != null && !mVar.aOE.isRecycled()) {
                        mVar.aOE.recycle();
                        mVar.aOE = null;
                    }
                }
            } else {
                for (m mVar2 : this.aOA) {
                    if (mVar2.aOE != null && !mVar2.aOE.isRecycled() && mVar2.aOF != this.aOF) {
                        mVar2.aOE.recycle();
                        mVar2.aOE = null;
                    }
                }
            }
        }
        if (this.aOA != null) {
            this.aOA.clear();
        }
        GQ();
        GO();
        postInvalidate();
    }

    public void GP() {
        if (this.aOA != null && this.aUS != null && this.aUS.size() > 0) {
            this.aOA.add(getAlaGraffitiPointDesData());
        }
    }

    public void GQ() {
        if (this.aUS != null) {
            this.aUS.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aOE = this.aOE;
        mVar.aOF = this.aOF;
        mVar.gg(this.aOF != null ? this.aOF.getThumbnail_url() : "");
        mVar.setGiftId(this.aOF != null ? Integer.parseInt(this.aOF.DR()) : 0);
        mVar.dN(getCurrentPointSize() - this.aVd);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aOF = gVar;
    }

    public void GR() {
        if (this.aOA != null && this.aOA.size() > 0) {
            for (int EM = this.aOA.get(this.aOA.size() - 1).EM(); EM > 0; EM--) {
                this.aUR.remove(this.aUR.size() - 1);
            }
            this.aOA.remove(this.aOA.size() - 1);
            postInvalidate();
            if (this.aUT != null) {
                this.aUT.d(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
