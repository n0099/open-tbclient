package com.baidu.live.yuyingift.graffitigift;

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
import com.baidu.live.gift.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<l> aUn;
    private Bitmap aUr;
    private g aUs;
    private a bPv;
    private ArrayList<PointF> bbA;
    private boolean bbC;
    private float bbD;
    private float bbE;
    private float bbF;
    private float bbG;
    private PointF bbH;
    private boolean bbI;
    private int bbJ;
    private int bbK;
    private int bbL;
    private Paint bby;
    private ArrayList<PointF> bbz;
    private int mBackgroundColor;

    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.bbC = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbC = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbC = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_gift_draw_region_layout, this);
        this.bby = new Paint();
        this.bby.setAntiAlias(true);
        this.bby.setFilterBitmap(true);
        this.bby.setDither(true);
        this.bbz = new ArrayList<>();
        this.bbA = new ArrayList<>();
        this.aUn = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bbF = dip2px;
        this.bbD = dip2px;
        float f = this.bbF / 2.0f;
        this.bbG = f;
        this.bbE = f;
        this.mBackgroundColor = getResources().getColor(a.c.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.bbL = this.bbz.size();
                this.bbA.clear();
                a(pointF);
                break;
            case 1:
                this.bbC = false;
                Ix();
                this.bbz.addAll(this.bbA);
                Iy();
                break;
            case 2:
                if (!this.bbC) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.bbC = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aUr != null && !this.aUr.isRecycled()) {
            if (c(pointF)) {
                this.bbI = true;
                this.bbH = pointF;
                this.bbA.add(pointF);
                if (this.bPv != null) {
                    this.bPv.d(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.bbI = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.bbI) {
            if (b(pointF, this.bbH)) {
                d(this.bbH, pointF);
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
            if (i2 >= this.bbz.size()) {
                break;
            }
            PointF pointF = this.bbz.get(i2);
            float f = pointF.x - this.bbE;
            float f2 = pointF.y - this.bbG;
            Bitmap et = et(i2);
            if (et != null && !et.isRecycled()) {
                canvas.drawBitmap(et, f, f2, this.bby);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.bbA.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.bbE;
            float f4 = next.y - this.bbG;
            if (this.aUr != null) {
                canvas.drawBitmap(this.aUr, f3, f4, this.bby);
            }
        }
    }

    private Bitmap et(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aUn.size()) {
                l lVar = this.aUn.get(i4);
                if (i3 < i && i <= lVar.Gg() + i3) {
                    return lVar.aUr;
                }
                i3 += lVar.Gg();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.bbD / width;
        float f2 = this.bbF / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aUr = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.bPv = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.f.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Iw() {
        if (this.bPv != null && !ListUtils.isEmpty(this.bbz)) {
            this.bPv.d(0, 0L);
        }
        ListUtils.clear(this.bbz);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.bbJ = i;
        this.bbK = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.bbK) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.h.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.bbK && pointF.x > this.bbE && pointF.x < ((float) getWidth()) - this.bbE && pointF.y > this.bbG && pointF.y < ((float) getHeight()) - this.bbG;
    }

    public int getCurrentPointSize() {
        return this.bbz.size() + this.bbA.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.bbF;
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
                if (c(pointF3, pointF4) < this.bbF) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.bbK) {
                    this.bbA.add(pointF4);
                    this.bbH = pointF4;
                    if (this.bPv != null) {
                        this.bPv.d(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.bbF) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.bbK) {
                this.bbA.add(pointF6);
                this.bbH = pointF6;
                if (this.bPv != null) {
                    this.bPv.d(getCurrentPointSize(), getTotalPrice());
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
        return this.bbz;
    }

    public List<l> getGraffitiPointDesDatas() {
        return this.aUn;
    }

    public long getTotalPrice() {
        long j = 0;
        for (l lVar : this.aUn) {
            j = lVar.aUs != null ? (lVar.Gg() * JavaTypesHelper.toLong(lVar.aUs.getPrice(), 0L)) + j : j;
        }
        if (this.bbA.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aUs.getPrice(), 0L) * this.bbA.size());
        }
        return j;
    }

    public void bR(boolean z) {
        if (this.aUn != null) {
            if (z) {
                for (l lVar : this.aUn) {
                    if (lVar.aUr != null && !lVar.aUr.isRecycled()) {
                        lVar.aUr.recycle();
                        lVar.aUr = null;
                    }
                }
            } else {
                for (l lVar2 : this.aUn) {
                    if (lVar2.aUr != null && !lVar2.aUr.isRecycled() && lVar2.aUs != this.aUs) {
                        lVar2.aUr.recycle();
                        lVar2.aUr = null;
                    }
                }
            }
        }
        if (this.aUn != null) {
            this.aUn.clear();
        }
        Iy();
        Iw();
        postInvalidate();
    }

    public void Ix() {
        if (this.aUn != null && this.bbA != null && this.bbA.size() > 0) {
            this.aUn.add(getAlaGraffitiPointDesData());
        }
    }

    public void Iy() {
        if (this.bbA != null) {
            this.bbA.clear();
        }
    }

    private l getAlaGraffitiPointDesData() {
        l lVar = new l();
        lVar.aUr = this.aUr;
        lVar.aUs = this.aUs;
        lVar.gE(this.aUs != null ? this.aUs.getThumbnail_url() : "");
        lVar.setGiftId(this.aUs != null ? Integer.parseInt(this.aUs.Fk()) : 0);
        lVar.dS(getCurrentPointSize() - this.bbL);
        return lVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aUs = gVar;
    }

    public void Iz() {
        if (this.aUn != null && this.aUn.size() > 0) {
            for (int Gg = this.aUn.get(this.aUn.size() - 1).Gg(); Gg > 0; Gg--) {
                this.bbz.remove(this.bbz.size() - 1);
            }
            this.aUn.remove(this.aUn.size() - 1);
            postInvalidate();
            if (this.bPv != null) {
                this.bPv.d(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
