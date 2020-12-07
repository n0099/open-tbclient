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
import com.baidu.live.gift.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<l> aXs;
    private Bitmap aXw;
    private g aXx;
    private ArrayList<PointF> bfA;
    private a bfB;
    private boolean bfC;
    private float bfD;
    private float bfE;
    private float bfF;
    private float bfG;
    private PointF bfH;
    private boolean bfI;
    private int bfJ;
    private int bfK;
    private int bfL;
    private Paint bfy;
    private ArrayList<PointF> bfz;
    private int mBackgroundColor;

    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.bfC = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfC = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfC = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_gift_draw_region_layout, this);
        this.bfy = new Paint();
        this.bfy.setAntiAlias(true);
        this.bfy.setFilterBitmap(true);
        this.bfy.setDither(true);
        this.bfz = new ArrayList<>();
        this.bfA = new ArrayList<>();
        this.aXs = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bfF = dip2px;
        this.bfD = dip2px;
        float f = this.bfF / 2.0f;
        this.bfG = f;
        this.bfE = f;
        this.mBackgroundColor = getResources().getColor(a.c.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.bfL = this.bfz.size();
                this.bfA.clear();
                a(pointF);
                break;
            case 1:
                this.bfC = false;
                Kx();
                this.bfz.addAll(this.bfA);
                Ky();
                break;
            case 2:
                if (!this.bfC) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.bfC = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aXw != null && !this.aXw.isRecycled()) {
            if (c(pointF)) {
                this.bfI = true;
                this.bfH = pointF;
                this.bfA.add(pointF);
                if (this.bfB != null) {
                    this.bfB.d(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.bfI = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.bfI) {
            if (b(pointF, this.bfH)) {
                d(this.bfH, pointF);
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
            if (i2 >= this.bfz.size()) {
                break;
            }
            PointF pointF = this.bfz.get(i2);
            float f = pointF.x - this.bfE;
            float f2 = pointF.y - this.bfG;
            Bitmap eP = eP(i2);
            if (eP != null && !eP.isRecycled()) {
                canvas.drawBitmap(eP, f, f2, this.bfy);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.bfA.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.bfE;
            float f4 = next.y - this.bfG;
            if (this.aXw != null) {
                canvas.drawBitmap(this.aXw, f3, f4, this.bfy);
            }
        }
    }

    private Bitmap eP(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aXs.size()) {
                l lVar = this.aXs.get(i4);
                if (i3 < i && i <= lVar.HV() + i3) {
                    return lVar.aXw;
                }
                i3 += lVar.HV();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.bfD / width;
        float f2 = this.bfF / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aXw = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.bfB = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.f.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Kw() {
        if (this.bfB != null && !ListUtils.isEmpty(this.bfz)) {
            this.bfB.d(0, 0L);
        }
        ListUtils.clear(this.bfz);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.bfJ = i;
        this.bfK = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.bfK) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.h.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.bfK && pointF.x > this.bfE && pointF.x < ((float) getWidth()) - this.bfE && pointF.y > this.bfG && pointF.y < ((float) getHeight()) - this.bfG;
    }

    public int getCurrentPointSize() {
        return this.bfz.size() + this.bfA.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.bfF;
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
                if (c(pointF3, pointF4) < this.bfF) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.bfK) {
                    this.bfA.add(pointF4);
                    this.bfH = pointF4;
                    if (this.bfB != null) {
                        this.bfB.d(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.bfF) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.bfK) {
                this.bfA.add(pointF6);
                this.bfH = pointF6;
                if (this.bfB != null) {
                    this.bfB.d(getCurrentPointSize(), getTotalPrice());
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
        return this.bfz;
    }

    public List<l> getGraffitiPointDesDatas() {
        return this.aXs;
    }

    private long getTotalPrice() {
        long j = 0;
        for (l lVar : this.aXs) {
            j = lVar.aXx != null ? (lVar.HV() * JavaTypesHelper.toLong(lVar.aXx.getPrice(), 0L)) + j : j;
        }
        if (this.bfA.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aXx.getPrice(), 0L) * this.bfA.size());
        }
        return j;
    }

    public void ca(boolean z) {
        if (this.aXs != null) {
            if (z) {
                for (l lVar : this.aXs) {
                    if (lVar.aXw != null && !lVar.aXw.isRecycled()) {
                        lVar.aXw.recycle();
                        lVar.aXw = null;
                    }
                }
            } else {
                for (l lVar2 : this.aXs) {
                    if (lVar2.aXw != null && !lVar2.aXw.isRecycled() && lVar2.aXx != this.aXx) {
                        lVar2.aXw.recycle();
                        lVar2.aXw = null;
                    }
                }
            }
        }
        if (this.aXs != null) {
            this.aXs.clear();
        }
        Ky();
        Kw();
        postInvalidate();
    }

    public void Kx() {
        if (this.aXs != null && this.bfA != null && this.bfA.size() > 0) {
            this.aXs.add(getAlaGraffitiPointDesData());
        }
    }

    public void Ky() {
        if (this.bfA != null) {
            this.bfA.clear();
        }
    }

    private l getAlaGraffitiPointDesData() {
        l lVar = new l();
        lVar.aXw = this.aXw;
        lVar.aXx = this.aXx;
        lVar.gZ(this.aXx != null ? this.aXx.getThumbnail_url() : "");
        lVar.setGiftId(this.aXx != null ? Integer.parseInt(this.aXx.GX()) : 0);
        lVar.em(getCurrentPointSize() - this.bfL);
        return lVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aXx = gVar;
    }

    public void Kz() {
        if (this.aXs != null && this.aXs.size() > 0) {
            for (int HV = this.aXs.get(this.aXs.size() - 1).HV(); HV > 0; HV--) {
                this.bfz.remove(this.bfz.size() - 1);
            }
            this.aXs.remove(this.aXs.size() - 1);
            postInvalidate();
            if (this.bfB != null) {
                this.bfB.d(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
