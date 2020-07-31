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
/* loaded from: classes4.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<m> aJn;
    private Bitmap aJr;
    private g aJs;
    private Paint aPA;
    private ArrayList<PointF> aPB;
    private ArrayList<PointF> aPC;
    private a aPD;
    private boolean aPE;
    private float aPF;
    private float aPG;
    private float aPH;
    private float aPI;
    private PointF aPJ;
    private boolean aPK;
    private int aPL;
    private int aPM;
    private int aPN;
    private int mBackgroundColor;

    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.aPE = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPE = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPE = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.aPA = new Paint();
        this.aPA.setAntiAlias(true);
        this.aPA.setFilterBitmap(true);
        this.aPA.setDither(true);
        this.aPB = new ArrayList<>();
        this.aPC = new ArrayList<>();
        this.aJn = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aPH = dip2px;
        this.aPF = dip2px;
        float f = this.aPH / 2.0f;
        this.aPI = f;
        this.aPG = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.aPN = this.aPB.size();
                this.aPC.clear();
                a(pointF);
                break;
            case 1:
                this.aPE = false;
                Bm();
                this.aPB.addAll(this.aPC);
                Bn();
                break;
            case 2:
                if (!this.aPE) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.aPE = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aJr != null && !this.aJr.isRecycled()) {
            if (c(pointF)) {
                this.aPK = true;
                this.aPJ = pointF;
                this.aPC.add(pointF);
                if (this.aPD != null) {
                    this.aPD.d(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.aPK = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.aPK) {
            if (b(pointF, this.aPJ)) {
                d(this.aPJ, pointF);
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
            if (i2 >= this.aPB.size()) {
                break;
            }
            PointF pointF = this.aPB.get(i2);
            float f = pointF.x - this.aPG;
            float f2 = pointF.y - this.aPI;
            Bitmap cx = cx(i2);
            if (cx != null && !cx.isRecycled()) {
                canvas.drawBitmap(cx, f, f2, this.aPA);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.aPC.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.aPG;
            float f4 = next.y - this.aPI;
            if (this.aJr != null) {
                canvas.drawBitmap(this.aJr, f3, f4, this.aPA);
            }
        }
    }

    private Bitmap cx(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aJn.size()) {
                m mVar = this.aJn.get(i4);
                if (i3 < i && i <= mVar.zj() + i3) {
                    return mVar.aJr;
                }
                i3 += mVar.zj();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.aPF / width;
        float f2 = this.aPH / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aJr = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aPD = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Bl() {
        if (this.aPD != null && !ListUtils.isEmpty(this.aPB)) {
            this.aPD.d(0, 0L);
        }
        ListUtils.clear(this.aPB);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aPL = i;
        this.aPM = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.aPM) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.aPM && pointF.x > this.aPG && pointF.x < ((float) getWidth()) - this.aPG && pointF.y > this.aPI && pointF.y < ((float) getHeight()) - this.aPI;
    }

    public int getCurrentPointSize() {
        return this.aPB.size() + this.aPC.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.aPH;
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
                if (c(pointF3, pointF4) < this.aPH) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.aPM) {
                    this.aPC.add(pointF4);
                    this.aPJ = pointF4;
                    if (this.aPD != null) {
                        this.aPD.d(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.aPH) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.aPM) {
                this.aPC.add(pointF6);
                this.aPJ = pointF6;
                if (this.aPD != null) {
                    this.aPD.d(getCurrentPointSize(), getTotalPrice());
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
        return this.aPB;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aJn;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aJn) {
            j = mVar.aJs != null ? (mVar.zj() * JavaTypesHelper.toLong(mVar.aJs.getPrice(), 0L)) + j : j;
        }
        if (this.aPC.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aJs.getPrice(), 0L) * this.aPC.size());
        }
        return j;
    }

    public void bD(boolean z) {
        if (this.aJn != null) {
            if (z) {
                for (m mVar : this.aJn) {
                    if (mVar.aJr != null && !mVar.aJr.isRecycled()) {
                        mVar.aJr.recycle();
                        mVar.aJr = null;
                    }
                }
            } else {
                for (m mVar2 : this.aJn) {
                    if (mVar2.aJr != null && !mVar2.aJr.isRecycled() && mVar2.aJs != this.aJs) {
                        mVar2.aJr.recycle();
                        mVar2.aJr = null;
                    }
                }
            }
        }
        if (this.aJn != null) {
            this.aJn.clear();
        }
        Bn();
        Bl();
        postInvalidate();
    }

    public void Bm() {
        if (this.aJn != null && this.aPC != null && this.aPC.size() > 0) {
            this.aJn.add(getAlaGraffitiPointDesData());
        }
    }

    public void Bn() {
        if (this.aPC != null) {
            this.aPC.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aJr = this.aJr;
        mVar.aJs = this.aJs;
        mVar.eL(this.aJs != null ? this.aJs.getThumbnail_url() : "");
        mVar.setGiftId(this.aJs != null ? Integer.parseInt(this.aJs.yo()) : 0);
        mVar.ca(getCurrentPointSize() - this.aPN);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aJs = gVar;
    }

    public void Bo() {
        if (this.aJn != null && this.aJn.size() > 0) {
            for (int zj = this.aJn.get(this.aJn.size() - 1).zj(); zj > 0; zj--) {
                this.aPB.remove(this.aPB.size() - 1);
            }
            this.aJn.remove(this.aJn.size() - 1);
            postInvalidate();
            if (this.aPD != null) {
                this.aPD.d(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
