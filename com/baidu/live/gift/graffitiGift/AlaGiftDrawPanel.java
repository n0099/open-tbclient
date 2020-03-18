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
    public List<m> ahE;
    private Bitmap ahI;
    private g ahJ;
    private float anA;
    private float anB;
    private PointF anC;
    private boolean anD;
    private int anE;
    private int anF;
    private int anG;
    private Paint ant;
    private ArrayList<PointF> anu;
    private ArrayList<PointF> anv;
    private a anw;
    private boolean anx;
    private float any;
    private float anz;
    private int mBackgroundColor;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.anx = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anx = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anx = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.ant = new Paint();
        this.ant.setAntiAlias(true);
        this.ant.setFilterBitmap(true);
        this.ant.setDither(true);
        this.anu = new ArrayList<>();
        this.anv = new ArrayList<>();
        this.ahE = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.anA = dip2px;
        this.any = dip2px;
        float f = this.anA / 2.0f;
        this.anB = f;
        this.anz = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.anG = this.anu.size();
                this.anv.clear();
                a(pointF);
                break;
            case 1:
                this.anx = false;
                tK();
                this.anu.addAll(this.anv);
                uD();
                break;
            case 2:
                if (!this.anx) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.anx = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.ahI != null && !this.ahI.isRecycled()) {
            if (c(pointF)) {
                this.anD = true;
                this.anC = pointF;
                this.anv.add(pointF);
                if (this.anw != null) {
                    this.anw.c(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.anD = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.anD) {
            if (c(pointF, this.anC)) {
                e(this.anC, pointF);
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
            if (i2 >= this.anu.size()) {
                break;
            }
            PointF pointF = this.anu.get(i2);
            float f = pointF.x - this.anz;
            float f2 = pointF.y - this.anB;
            Bitmap bM = bM(i2);
            if (bM != null && !bM.isRecycled()) {
                canvas.drawBitmap(bM, f, f2, this.ant);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.anv.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.anz;
            float f4 = next.y - this.anB;
            if (this.ahI != null) {
                canvas.drawBitmap(this.ahI, f3, f4, this.ant);
            }
        }
    }

    private Bitmap bM(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.ahE.size()) {
                m mVar = this.ahE.get(i4);
                if (i3 < i && i <= mVar.sy() + i3) {
                    return mVar.ahI;
                }
                i3 += mVar.sy();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.any / width;
        float f2 = this.anA / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.ahI = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.anw = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void uC() {
        if (this.anw != null && !ListUtils.isEmpty(this.anu)) {
            this.anw.c(0, 0L);
        }
        ListUtils.clear(this.anu);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.anE = i;
        this.anF = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.anF) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.anF && pointF.x > this.anz && pointF.x < ((float) getWidth()) - this.anz && pointF.y > this.anB && pointF.y < ((float) getHeight()) - this.anB;
    }

    public int getCurrentPointSize() {
        return this.anu.size() + this.anv.size();
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.anA;
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
                if (d(pointF3, pointF4) < this.anA) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.anF) {
                    this.anv.add(pointF4);
                    this.anC = pointF4;
                    if (this.anw != null) {
                        this.anw.c(getCurrentPointSize(), getTotalPrice());
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
            if (d(pointF5, pointF6) < this.anA) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.anF) {
                this.anv.add(pointF6);
                this.anC = pointF6;
                if (this.anw != null) {
                    this.anw.c(getCurrentPointSize(), getTotalPrice());
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
        return this.anu;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.ahE;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.ahE) {
            j = mVar.ahJ != null ? (mVar.sy() * JavaTypesHelper.toLong(mVar.ahJ.getPrice(), 0L)) + j : j;
        }
        if (this.anv.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.ahJ.getPrice(), 0L) * this.anv.size());
        }
        return j;
    }

    public void aK(boolean z) {
        if (this.ahE != null) {
            if (z) {
                for (m mVar : this.ahE) {
                    if (mVar.ahI != null && !mVar.ahI.isRecycled()) {
                        mVar.ahI.recycle();
                        mVar.ahI = null;
                    }
                }
            } else {
                for (m mVar2 : this.ahE) {
                    if (mVar2.ahI != null && !mVar2.ahI.isRecycled() && mVar2.ahJ != this.ahJ) {
                        mVar2.ahI.recycle();
                        mVar2.ahI = null;
                    }
                }
            }
        }
        if (this.ahE != null) {
            this.ahE.clear();
        }
        uD();
        uC();
        postInvalidate();
    }

    public void tK() {
        if (this.ahE != null && this.anv != null && this.anv.size() > 0) {
            this.ahE.add(getAlaGraffitiPointDesData());
        }
    }

    public void uD() {
        if (this.anv != null) {
            this.anv.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.ahI = this.ahI;
        mVar.ahJ = this.ahJ;
        mVar.di(this.ahJ != null ? this.ahJ.rF() : "");
        mVar.setGiftId(this.ahJ != null ? Integer.parseInt(this.ahJ.rC()) : 0);
        mVar.bs(getCurrentPointSize() - this.anG);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.ahJ = gVar;
    }

    public void uE() {
        if (this.ahE != null && this.ahE.size() > 0) {
            for (int sy = this.ahE.get(this.ahE.size() - 1).sy(); sy > 0; sy--) {
                this.anu.remove(this.anu.size() - 1);
            }
            this.ahE.remove(this.ahE.size() - 1);
            postInvalidate();
            if (this.anw != null) {
                this.anw.c(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
