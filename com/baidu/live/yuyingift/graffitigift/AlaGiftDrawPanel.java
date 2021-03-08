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
/* loaded from: classes10.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<l> aYP;
    private Bitmap aYT;
    private g aYU;
    private Paint bha;
    private ArrayList<PointF> bhb;
    private ArrayList<PointF> bhc;
    private boolean bhe;
    private float bhf;
    private float bhg;
    private float bhh;
    private float bhi;
    private PointF bhj;
    private boolean bhk;
    private int bhl;
    private int bhm;
    private int bhn;
    private a cbn;
    private int mBackgroundColor;

    /* loaded from: classes10.dex */
    public interface a {
        void h(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.bhe = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhe = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhe = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_gift_draw_region_layout, this);
        this.bha = new Paint();
        this.bha.setAntiAlias(true);
        this.bha.setFilterBitmap(true);
        this.bha.setDither(true);
        this.bhb = new ArrayList<>();
        this.bhc = new ArrayList<>();
        this.aYP = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bhh = dip2px;
        this.bhf = dip2px;
        float f = this.bhh / 2.0f;
        this.bhi = f;
        this.bhg = f;
        this.mBackgroundColor = getResources().getColor(a.c.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.bhn = this.bhb.size();
                this.bhc.clear();
                a(pointF);
                break;
            case 1:
                this.bhe = false;
                Hw();
                this.bhb.addAll(this.bhc);
                Hx();
                break;
            case 2:
                if (!this.bhe) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.bhe = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aYT != null && !this.aYT.isRecycled()) {
            if (c(pointF)) {
                this.bhk = true;
                this.bhj = pointF;
                this.bhc.add(pointF);
                if (this.cbn != null) {
                    this.cbn.h(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.bhk = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.bhk) {
            if (c(pointF, this.bhj)) {
                e(this.bhj, pointF);
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
            if (i2 >= this.bhb.size()) {
                break;
            }
            PointF pointF = this.bhb.get(i2);
            float f = pointF.x - this.bhg;
            float f2 = pointF.y - this.bhi;
            Bitmap dn = dn(i2);
            if (dn != null && !dn.isRecycled()) {
                canvas.drawBitmap(dn, f, f2, this.bha);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.bhc.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.bhg;
            float f4 = next.y - this.bhi;
            if (this.aYT != null) {
                canvas.drawBitmap(this.aYT, f3, f4, this.bha);
            }
        }
    }

    private Bitmap dn(int i) {
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.aYP.size()) {
                l lVar = this.aYP.get(i4);
                if (i2 < i && i <= lVar.EU() + i2) {
                    return lVar.aYT;
                }
                i2 += lVar.EU();
                i3 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.bhf / width;
        float f2 = this.bhh / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aYT = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.cbn = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.f.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Hv() {
        if (this.cbn != null && !ListUtils.isEmpty(this.bhb)) {
            this.cbn.h(0, 0L);
        }
        ListUtils.clear(this.bhb);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.bhl = i;
        this.bhm = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.bhm) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.h.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.bhm && pointF.x > this.bhg && pointF.x < ((float) getWidth()) - this.bhg && pointF.y > this.bhi && pointF.y < ((float) getHeight()) - this.bhi;
    }

    public int getCurrentPointSize() {
        return this.bhb.size() + this.bhc.size();
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.bhh;
    }

    private float d(PointF pointF, PointF pointF2) {
        float f = pointF2.x - pointF.x;
        float f2 = pointF2.y - pointF.y;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private void e(PointF pointF, PointF pointF2) {
        int i;
        int i2;
        int i3 = (int) pointF.x;
        int i4 = (int) pointF.y;
        int i5 = (int) pointF2.x;
        int i6 = (int) pointF2.y;
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        if (i8 < 0) {
            i8 = -i8;
            i = -1;
        } else {
            i = 1;
        }
        if (i7 < 0) {
            i7 = -i7;
            i2 = -1;
        } else {
            i2 = 1;
        }
        int i9 = i8 << 1;
        int i10 = i7 << 1;
        if (i10 > i9) {
            int i11 = i9 - (i10 >> 1);
            int i12 = i4;
            PointF pointF3 = pointF;
            while (i3 != i5) {
                if (i11 >= 0) {
                    i12 += i;
                    i11 -= i10;
                }
                i3 += i2;
                int i13 = i11 + i9;
                PointF pointF4 = new PointF(i3, i12);
                if (d(pointF3, pointF4) >= this.bhh) {
                    if (getCurrentPointSize() < this.bhm) {
                        this.bhc.add(pointF4);
                        this.bhj = pointF4;
                        if (this.cbn != null) {
                            this.cbn.h(getCurrentPointSize(), getTotalPrice());
                        }
                        pointF3 = pointF4;
                    } else {
                        return;
                    }
                }
                i11 = i13;
            }
            return;
        }
        int i14 = i10 - (i9 >> 1);
        int i15 = i4;
        int i16 = i3;
        PointF pointF5 = pointF;
        while (i15 != i6) {
            if (i14 >= 0) {
                i16 += i2;
                i14 -= i9;
            }
            i15 += i;
            int i17 = i14 + i10;
            PointF pointF6 = new PointF(i16, i15);
            if (d(pointF5, pointF6) >= this.bhh) {
                if (getCurrentPointSize() < this.bhm) {
                    this.bhc.add(pointF6);
                    this.bhj = pointF6;
                    if (this.cbn != null) {
                        this.cbn.h(getCurrentPointSize(), getTotalPrice());
                    }
                    pointF5 = pointF6;
                } else {
                    return;
                }
            }
            i14 = i17;
        }
    }

    public List<PointF> getPoints() {
        return this.bhb;
    }

    public List<l> getGraffitiPointDesDatas() {
        return this.aYP;
    }

    public long getTotalPrice() {
        long j = 0;
        for (l lVar : this.aYP) {
            j = lVar.aYU != null ? (lVar.EU() * JavaTypesHelper.toLong(lVar.aYU.getPrice(), 0L)) + j : j;
        }
        if (this.bhc.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aYU.getPrice(), 0L) * this.bhc.size());
        }
        return j;
    }

    public void ca(boolean z) {
        if (this.aYP != null) {
            if (z) {
                for (l lVar : this.aYP) {
                    if (lVar.aYT != null && !lVar.aYT.isRecycled()) {
                        lVar.aYT.recycle();
                        lVar.aYT = null;
                    }
                }
            } else {
                for (l lVar2 : this.aYP) {
                    if (lVar2.aYT != null && !lVar2.aYT.isRecycled() && lVar2.aYU != this.aYU) {
                        lVar2.aYT.recycle();
                        lVar2.aYT = null;
                    }
                }
            }
        }
        if (this.aYP != null) {
            this.aYP.clear();
        }
        Hx();
        Hv();
        postInvalidate();
    }

    public void Hw() {
        if (this.aYP != null && this.bhc != null && this.bhc.size() > 0) {
            this.aYP.add(getAlaGraffitiPointDesData());
        }
    }

    public void Hx() {
        if (this.bhc != null) {
            this.bhc.clear();
        }
    }

    private l getAlaGraffitiPointDesData() {
        l lVar = new l();
        lVar.aYT = this.aYT;
        lVar.aYU = this.aYU;
        lVar.fZ(this.aYU != null ? this.aYU.getThumbnail_url() : "");
        lVar.setGiftId(this.aYU != null ? Integer.parseInt(this.aYU.DU()) : 0);
        lVar.cK(getCurrentPointSize() - this.bhn);
        return lVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aYU = gVar;
    }

    public void Hy() {
        if (this.aYP != null && this.aYP.size() > 0) {
            for (int EU = this.aYP.get(this.aYP.size() - 1).EU(); EU > 0; EU--) {
                this.bhb.remove(this.bhb.size() - 1);
            }
            this.aYP.remove(this.aYP.size() - 1);
            postInvalidate();
            if (this.cbn != null) {
                this.cbn.h(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
