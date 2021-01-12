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
    public List<l> aUk;
    private Bitmap aUo;
    private g aUp;
    private a bVL;
    private boolean bcA;
    private int bcB;
    private int bcC;
    private int bcD;
    private Paint bcq;
    private ArrayList<PointF> bcr;
    private ArrayList<PointF> bcs;
    private boolean bcu;
    private float bcv;
    private float bcw;
    private float bcx;
    private float bcy;
    private PointF bcz;
    private int mBackgroundColor;

    /* loaded from: classes10.dex */
    public interface a {
        void g(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.bcu = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcu = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcu = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_gift_draw_region_layout, this);
        this.bcq = new Paint();
        this.bcq.setAntiAlias(true);
        this.bcq.setFilterBitmap(true);
        this.bcq.setDither(true);
        this.bcr = new ArrayList<>();
        this.bcs = new ArrayList<>();
        this.aUk = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bcx = dip2px;
        this.bcv = dip2px;
        float f = this.bcx / 2.0f;
        this.bcy = f;
        this.bcw = f;
        this.mBackgroundColor = getResources().getColor(a.c.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.bcD = this.bcr.size();
                this.bcs.clear();
                a(pointF);
                break;
            case 1:
                this.bcu = false;
                Gd();
                this.bcr.addAll(this.bcs);
                Ge();
                break;
            case 2:
                if (!this.bcu) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.bcu = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aUo != null && !this.aUo.isRecycled()) {
            if (c(pointF)) {
                this.bcA = true;
                this.bcz = pointF;
                this.bcs.add(pointF);
                if (this.bVL != null) {
                    this.bVL.g(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.bcA = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.bcA) {
            if (c(pointF, this.bcz)) {
                e(this.bcz, pointF);
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
            if (i2 >= this.bcr.size()) {
                break;
            }
            PointF pointF = this.bcr.get(i2);
            float f = pointF.x - this.bcw;
            float f2 = pointF.y - this.bcy;
            Bitmap dh = dh(i2);
            if (dh != null && !dh.isRecycled()) {
                canvas.drawBitmap(dh, f, f2, this.bcq);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.bcs.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.bcw;
            float f4 = next.y - this.bcy;
            if (this.aUo != null) {
                canvas.drawBitmap(this.aUo, f3, f4, this.bcq);
            }
        }
    }

    private Bitmap dh(int i) {
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.aUk.size()) {
                l lVar = this.aUk.get(i4);
                if (i2 < i && i <= lVar.DB() + i2) {
                    return lVar.aUo;
                }
                i2 += lVar.DB();
                i3 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.bcv / width;
        float f2 = this.bcx / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aUo = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.bVL = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.f.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Gc() {
        if (this.bVL != null && !ListUtils.isEmpty(this.bcr)) {
            this.bVL.g(0, 0L);
        }
        ListUtils.clear(this.bcr);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.bcB = i;
        this.bcC = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.bcC) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.h.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.bcC && pointF.x > this.bcw && pointF.x < ((float) getWidth()) - this.bcw && pointF.y > this.bcy && pointF.y < ((float) getHeight()) - this.bcy;
    }

    public int getCurrentPointSize() {
        return this.bcr.size() + this.bcs.size();
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.bcx;
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
                if (d(pointF3, pointF4) >= this.bcx) {
                    if (getCurrentPointSize() < this.bcC) {
                        this.bcs.add(pointF4);
                        this.bcz = pointF4;
                        if (this.bVL != null) {
                            this.bVL.g(getCurrentPointSize(), getTotalPrice());
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
            if (d(pointF5, pointF6) >= this.bcx) {
                if (getCurrentPointSize() < this.bcC) {
                    this.bcs.add(pointF6);
                    this.bcz = pointF6;
                    if (this.bVL != null) {
                        this.bVL.g(getCurrentPointSize(), getTotalPrice());
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
        return this.bcr;
    }

    public List<l> getGraffitiPointDesDatas() {
        return this.aUk;
    }

    public long getTotalPrice() {
        long j = 0;
        for (l lVar : this.aUk) {
            j = lVar.aUp != null ? (lVar.DB() * JavaTypesHelper.toLong(lVar.aUp.getPrice(), 0L)) + j : j;
        }
        if (this.bcs.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aUp.getPrice(), 0L) * this.bcs.size());
        }
        return j;
    }

    public void bV(boolean z) {
        if (this.aUk != null) {
            if (z) {
                for (l lVar : this.aUk) {
                    if (lVar.aUo != null && !lVar.aUo.isRecycled()) {
                        lVar.aUo.recycle();
                        lVar.aUo = null;
                    }
                }
            } else {
                for (l lVar2 : this.aUk) {
                    if (lVar2.aUo != null && !lVar2.aUo.isRecycled() && lVar2.aUp != this.aUp) {
                        lVar2.aUo.recycle();
                        lVar2.aUo = null;
                    }
                }
            }
        }
        if (this.aUk != null) {
            this.aUk.clear();
        }
        Ge();
        Gc();
        postInvalidate();
    }

    public void Gd() {
        if (this.aUk != null && this.bcs != null && this.bcs.size() > 0) {
            this.aUk.add(getAlaGraffitiPointDesData());
        }
    }

    public void Ge() {
        if (this.bcs != null) {
            this.bcs.clear();
        }
    }

    private l getAlaGraffitiPointDesData() {
        l lVar = new l();
        lVar.aUo = this.aUo;
        lVar.aUp = this.aUp;
        lVar.fy(this.aUp != null ? this.aUp.getThumbnail_url() : "");
        lVar.setGiftId(this.aUp != null ? Integer.parseInt(this.aUp.CC()) : 0);
        lVar.cE(getCurrentPointSize() - this.bcD);
        return lVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aUp = gVar;
    }

    public void Gf() {
        if (this.aUk != null && this.aUk.size() > 0) {
            for (int DB = this.aUk.get(this.aUk.size() - 1).DB(); DB > 0; DB--) {
                this.bcr.remove(this.bcr.size() - 1);
            }
            this.aUk.remove(this.aUk.size() - 1);
            postInvalidate();
            if (this.bVL != null) {
                this.bVL.g(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
