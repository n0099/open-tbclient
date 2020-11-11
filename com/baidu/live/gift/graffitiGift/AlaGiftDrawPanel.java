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
    public List<l> aVY;
    private Bitmap aWc;
    private g aWd;
    private Paint bdj;
    private ArrayList<PointF> bdk;
    private ArrayList<PointF> bdl;
    private a bdm;
    private boolean bdn;
    private float bdo;
    private float bdp;
    private float bdq;
    private float bdr;
    private PointF bds;
    private boolean bdt;
    private int bdu;
    private int bdv;
    private int bdw;
    private int mBackgroundColor;

    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.bdn = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdn = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdn = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_gift_draw_region_layout, this);
        this.bdj = new Paint();
        this.bdj.setAntiAlias(true);
        this.bdj.setFilterBitmap(true);
        this.bdj.setDither(true);
        this.bdk = new ArrayList<>();
        this.bdl = new ArrayList<>();
        this.aVY = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bdq = dip2px;
        this.bdo = dip2px;
        float f = this.bdq / 2.0f;
        this.bdr = f;
        this.bdp = f;
        this.mBackgroundColor = getResources().getColor(a.c.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.bdw = this.bdk.size();
                this.bdl.clear();
                a(pointF);
                break;
            case 1:
                this.bdn = false;
                Jg();
                this.bdk.addAll(this.bdl);
                Jh();
                break;
            case 2:
                if (!this.bdn) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.bdn = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aWc != null && !this.aWc.isRecycled()) {
            if (c(pointF)) {
                this.bdt = true;
                this.bds = pointF;
                this.bdl.add(pointF);
                if (this.bdm != null) {
                    this.bdm.d(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.bdt = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.bdt) {
            if (b(pointF, this.bds)) {
                d(this.bds, pointF);
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
            if (i2 >= this.bdk.size()) {
                break;
            }
            PointF pointF = this.bdk.get(i2);
            float f = pointF.x - this.bdp;
            float f2 = pointF.y - this.bdr;
            Bitmap ex = ex(i2);
            if (ex != null && !ex.isRecycled()) {
                canvas.drawBitmap(ex, f, f2, this.bdj);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.bdl.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.bdp;
            float f4 = next.y - this.bdr;
            if (this.aWc != null) {
                canvas.drawBitmap(this.aWc, f3, f4, this.bdj);
            }
        }
    }

    private Bitmap ex(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aVY.size()) {
                l lVar = this.aVY.get(i4);
                if (i3 < i && i <= lVar.GP() + i3) {
                    return lVar.aWc;
                }
                i3 += lVar.GP();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.bdo / width;
        float f2 = this.bdq / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aWc = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.bdm = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.f.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Jf() {
        if (this.bdm != null && !ListUtils.isEmpty(this.bdk)) {
            this.bdm.d(0, 0L);
        }
        ListUtils.clear(this.bdk);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.bdu = i;
        this.bdv = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.bdv) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.h.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.bdv && pointF.x > this.bdp && pointF.x < ((float) getWidth()) - this.bdp && pointF.y > this.bdr && pointF.y < ((float) getHeight()) - this.bdr;
    }

    public int getCurrentPointSize() {
        return this.bdk.size() + this.bdl.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.bdq;
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
                if (c(pointF3, pointF4) < this.bdq) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.bdv) {
                    this.bdl.add(pointF4);
                    this.bds = pointF4;
                    if (this.bdm != null) {
                        this.bdm.d(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.bdq) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.bdv) {
                this.bdl.add(pointF6);
                this.bds = pointF6;
                if (this.bdm != null) {
                    this.bdm.d(getCurrentPointSize(), getTotalPrice());
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
        return this.bdk;
    }

    public List<l> getGraffitiPointDesDatas() {
        return this.aVY;
    }

    private long getTotalPrice() {
        long j = 0;
        for (l lVar : this.aVY) {
            j = lVar.aWd != null ? (lVar.GP() * JavaTypesHelper.toLong(lVar.aWd.getPrice(), 0L)) + j : j;
        }
        if (this.bdl.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aWd.getPrice(), 0L) * this.bdl.size());
        }
        return j;
    }

    public void bP(boolean z) {
        if (this.aVY != null) {
            if (z) {
                for (l lVar : this.aVY) {
                    if (lVar.aWc != null && !lVar.aWc.isRecycled()) {
                        lVar.aWc.recycle();
                        lVar.aWc = null;
                    }
                }
            } else {
                for (l lVar2 : this.aVY) {
                    if (lVar2.aWc != null && !lVar2.aWc.isRecycled() && lVar2.aWd != this.aWd) {
                        lVar2.aWc.recycle();
                        lVar2.aWc = null;
                    }
                }
            }
        }
        if (this.aVY != null) {
            this.aVY.clear();
        }
        Jh();
        Jf();
        postInvalidate();
    }

    public void Jg() {
        if (this.aVY != null && this.bdl != null && this.bdl.size() > 0) {
            this.aVY.add(getAlaGraffitiPointDesData());
        }
    }

    public void Jh() {
        if (this.bdl != null) {
            this.bdl.clear();
        }
    }

    private l getAlaGraffitiPointDesData() {
        l lVar = new l();
        lVar.aWc = this.aWc;
        lVar.aWd = this.aWd;
        lVar.gK(this.aWd != null ? this.aWd.getThumbnail_url() : "");
        lVar.setGiftId(this.aWd != null ? Integer.parseInt(this.aWd.FT()) : 0);
        lVar.dW(getCurrentPointSize() - this.bdw);
        return lVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aWd = gVar;
    }

    public void Ji() {
        if (this.aVY != null && this.aVY.size() > 0) {
            for (int GP = this.aVY.get(this.aVY.size() - 1).GP(); GP > 0; GP--) {
                this.bdk.remove(this.bdk.size() - 1);
            }
            this.aVY.remove(this.aVY.size() - 1);
            postInvalidate();
            if (this.bdm != null) {
                this.bdm.d(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
