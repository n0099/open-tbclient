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
    private Bitmap aQD;
    private g aQE;
    public List<m> aQz;
    private Paint aXj;
    private ArrayList<PointF> aXk;
    private ArrayList<PointF> aXl;
    private a aXm;
    private boolean aXn;
    private float aXo;
    private float aXp;
    private float aXq;
    private float aXr;
    private PointF aXs;
    private boolean aXt;
    private int aXu;
    private int aXv;
    private int aXw;
    private int mBackgroundColor;

    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.aXn = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXn = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXn = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.aXj = new Paint();
        this.aXj.setAntiAlias(true);
        this.aXj.setFilterBitmap(true);
        this.aXj.setDither(true);
        this.aXk = new ArrayList<>();
        this.aXl = new ArrayList<>();
        this.aQz = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aXq = dip2px;
        this.aXo = dip2px;
        float f = this.aXq / 2.0f;
        this.aXr = f;
        this.aXp = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.aXw = this.aXk.size();
                this.aXl.clear();
                a(pointF);
                break;
            case 1:
                this.aXn = false;
                Hp();
                this.aXk.addAll(this.aXl);
                Hq();
                break;
            case 2:
                if (!this.aXn) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.aXn = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aQD != null && !this.aQD.isRecycled()) {
            if (c(pointF)) {
                this.aXt = true;
                this.aXs = pointF;
                this.aXl.add(pointF);
                if (this.aXm != null) {
                    this.aXm.d(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.aXt = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.aXt) {
            if (b(pointF, this.aXs)) {
                d(this.aXs, pointF);
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
            if (i2 >= this.aXk.size()) {
                break;
            }
            PointF pointF = this.aXk.get(i2);
            float f = pointF.x - this.aXp;
            float f2 = pointF.y - this.aXr;
            Bitmap er = er(i2);
            if (er != null && !er.isRecycled()) {
                canvas.drawBitmap(er, f, f2, this.aXj);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.aXl.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.aXp;
            float f4 = next.y - this.aXr;
            if (this.aQD != null) {
                canvas.drawBitmap(this.aQD, f3, f4, this.aXj);
            }
        }
    }

    private Bitmap er(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aQz.size()) {
                m mVar = this.aQz.get(i4);
                if (i3 < i && i <= mVar.Fd() + i3) {
                    return mVar.aQD;
                }
                i3 += mVar.Fd();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.aXo / width;
        float f2 = this.aXq / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aQD = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aXm = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Ho() {
        if (this.aXm != null && !ListUtils.isEmpty(this.aXk)) {
            this.aXm.d(0, 0L);
        }
        ListUtils.clear(this.aXk);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aXu = i;
        this.aXv = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.aXv) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.aXv && pointF.x > this.aXp && pointF.x < ((float) getWidth()) - this.aXp && pointF.y > this.aXr && pointF.y < ((float) getHeight()) - this.aXr;
    }

    public int getCurrentPointSize() {
        return this.aXk.size() + this.aXl.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.aXq;
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
                if (c(pointF3, pointF4) < this.aXq) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.aXv) {
                    this.aXl.add(pointF4);
                    this.aXs = pointF4;
                    if (this.aXm != null) {
                        this.aXm.d(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.aXq) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.aXv) {
                this.aXl.add(pointF6);
                this.aXs = pointF6;
                if (this.aXm != null) {
                    this.aXm.d(getCurrentPointSize(), getTotalPrice());
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
        return this.aXk;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aQz;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aQz) {
            j = mVar.aQE != null ? (mVar.Fd() * JavaTypesHelper.toLong(mVar.aQE.getPrice(), 0L)) + j : j;
        }
        if (this.aXl.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aQE.getPrice(), 0L) * this.aXl.size());
        }
        return j;
    }

    public void bJ(boolean z) {
        if (this.aQz != null) {
            if (z) {
                for (m mVar : this.aQz) {
                    if (mVar.aQD != null && !mVar.aQD.isRecycled()) {
                        mVar.aQD.recycle();
                        mVar.aQD = null;
                    }
                }
            } else {
                for (m mVar2 : this.aQz) {
                    if (mVar2.aQD != null && !mVar2.aQD.isRecycled() && mVar2.aQE != this.aQE) {
                        mVar2.aQD.recycle();
                        mVar2.aQD = null;
                    }
                }
            }
        }
        if (this.aQz != null) {
            this.aQz.clear();
        }
        Hq();
        Ho();
        postInvalidate();
    }

    public void Hp() {
        if (this.aQz != null && this.aXl != null && this.aXl.size() > 0) {
            this.aQz.add(getAlaGraffitiPointDesData());
        }
    }

    public void Hq() {
        if (this.aXl != null) {
            this.aXl.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aQD = this.aQD;
        mVar.aQE = this.aQE;
        mVar.gm(this.aQE != null ? this.aQE.getThumbnail_url() : "");
        mVar.setGiftId(this.aQE != null ? Integer.parseInt(this.aQE.Eh()) : 0);
        mVar.dR(getCurrentPointSize() - this.aXw);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aQE = gVar;
    }

    public void Hr() {
        if (this.aQz != null && this.aQz.size() > 0) {
            for (int Fd = this.aQz.get(this.aQz.size() - 1).Fd(); Fd > 0; Fd--) {
                this.aXk.remove(this.aXk.size() - 1);
            }
            this.aQz.remove(this.aQz.size() - 1);
            postInvalidate();
            if (this.aXm != null) {
                this.aXm.d(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
