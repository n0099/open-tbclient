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
    private Bitmap aFA;
    private g aFB;
    public List<m> aFw;
    private ArrayList<PointF> aLA;
    private ArrayList<PointF> aLB;
    private a aLC;
    private boolean aLD;
    private float aLE;
    private float aLF;
    private float aLG;
    private float aLH;
    private PointF aLI;
    private boolean aLJ;
    private int aLK;
    private int aLL;
    private int aLM;
    private Paint aLz;
    private int mBackgroundColor;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.aLD = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLD = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLD = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.aLz = new Paint();
        this.aLz.setAntiAlias(true);
        this.aLz.setFilterBitmap(true);
        this.aLz.setDither(true);
        this.aLA = new ArrayList<>();
        this.aLB = new ArrayList<>();
        this.aFw = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aLG = dip2px;
        this.aLE = dip2px;
        float f = this.aLG / 2.0f;
        this.aLH = f;
        this.aLF = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.aLM = this.aLA.size();
                this.aLB.clear();
                a(pointF);
                break;
            case 1:
                this.aLD = false;
                Ak();
                this.aLA.addAll(this.aLB);
                Al();
                break;
            case 2:
                if (!this.aLD) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.aLD = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aFA != null && !this.aFA.isRecycled()) {
            if (c(pointF)) {
                this.aLJ = true;
                this.aLI = pointF;
                this.aLB.add(pointF);
                if (this.aLC != null) {
                    this.aLC.c(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.aLJ = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.aLJ) {
            if (b(pointF, this.aLI)) {
                d(this.aLI, pointF);
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
            if (i2 >= this.aLA.size()) {
                break;
            }
            PointF pointF = this.aLA.get(i2);
            float f = pointF.x - this.aLF;
            float f2 = pointF.y - this.aLH;
            Bitmap cl = cl(i2);
            if (cl != null && !cl.isRecycled()) {
                canvas.drawBitmap(cl, f, f2, this.aLz);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.aLB.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.aLF;
            float f4 = next.y - this.aLH;
            if (this.aFA != null) {
                canvas.drawBitmap(this.aFA, f3, f4, this.aLz);
            }
        }
    }

    private Bitmap cl(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aFw.size()) {
                m mVar = this.aFw.get(i4);
                if (i3 < i && i <= mVar.yh() + i3) {
                    return mVar.aFA;
                }
                i3 += mVar.yh();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.aLE / width;
        float f2 = this.aLG / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aFA = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aLC = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Aj() {
        if (this.aLC != null && !ListUtils.isEmpty(this.aLA)) {
            this.aLC.c(0, 0L);
        }
        ListUtils.clear(this.aLA);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.aLK = i;
        this.aLL = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.aLL) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.aLL && pointF.x > this.aLF && pointF.x < ((float) getWidth()) - this.aLF && pointF.y > this.aLH && pointF.y < ((float) getHeight()) - this.aLH;
    }

    public int getCurrentPointSize() {
        return this.aLA.size() + this.aLB.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.aLG;
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
                if (c(pointF3, pointF4) < this.aLG) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.aLL) {
                    this.aLB.add(pointF4);
                    this.aLI = pointF4;
                    if (this.aLC != null) {
                        this.aLC.c(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.aLG) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.aLL) {
                this.aLB.add(pointF6);
                this.aLI = pointF6;
                if (this.aLC != null) {
                    this.aLC.c(getCurrentPointSize(), getTotalPrice());
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
        return this.aLA;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aFw;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aFw) {
            j = mVar.aFB != null ? (mVar.yh() * JavaTypesHelper.toLong(mVar.aFB.getPrice(), 0L)) + j : j;
        }
        if (this.aLB.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aFB.getPrice(), 0L) * this.aLB.size());
        }
        return j;
    }

    public void bA(boolean z) {
        if (this.aFw != null) {
            if (z) {
                for (m mVar : this.aFw) {
                    if (mVar.aFA != null && !mVar.aFA.isRecycled()) {
                        mVar.aFA.recycle();
                        mVar.aFA = null;
                    }
                }
            } else {
                for (m mVar2 : this.aFw) {
                    if (mVar2.aFA != null && !mVar2.aFA.isRecycled() && mVar2.aFB != this.aFB) {
                        mVar2.aFA.recycle();
                        mVar2.aFA = null;
                    }
                }
            }
        }
        if (this.aFw != null) {
            this.aFw.clear();
        }
        Al();
        Aj();
        postInvalidate();
    }

    public void Ak() {
        if (this.aFw != null && this.aLB != null && this.aLB.size() > 0) {
            this.aFw.add(getAlaGraffitiPointDesData());
        }
    }

    public void Al() {
        if (this.aLB != null) {
            this.aLB.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aFA = this.aFA;
        mVar.aFB = this.aFB;
        mVar.eG(this.aFB != null ? this.aFB.xo() : "");
        mVar.setGiftId(this.aFB != null ? Integer.parseInt(this.aFB.xl()) : 0);
        mVar.bO(getCurrentPointSize() - this.aLM);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aFB = gVar;
    }

    public void Am() {
        if (this.aFw != null && this.aFw.size() > 0) {
            for (int yh = this.aFw.get(this.aFw.size() - 1).yh(); yh > 0; yh--) {
                this.aLA.remove(this.aLA.size() - 1);
            }
            this.aFw.remove(this.aFw.size() - 1);
            postInvalidate();
            if (this.aLC != null) {
                this.aLC.c(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
