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
    public List<m> ahu;
    private Bitmap ahy;
    private g ahz;
    private Paint ani;
    private ArrayList<PointF> anj;
    private ArrayList<PointF> ank;
    private a anl;
    private boolean anm;
    private float ann;
    private float ano;
    private float anp;
    private float anq;
    private PointF anr;
    private boolean ans;
    private int ant;
    private int anu;
    private int anv;
    private int mBackgroundColor;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.anm = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anm = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anm = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.ani = new Paint();
        this.ani.setAntiAlias(true);
        this.ani.setFilterBitmap(true);
        this.ani.setDither(true);
        this.anj = new ArrayList<>();
        this.ank = new ArrayList<>();
        this.ahu = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.anp = dip2px;
        this.ann = dip2px;
        float f = this.anp / 2.0f;
        this.anq = f;
        this.ano = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.anv = this.anj.size();
                this.ank.clear();
                a(pointF);
                break;
            case 1:
                this.anm = false;
                tF();
                this.anj.addAll(this.ank);
                uy();
                break;
            case 2:
                if (!this.anm) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.anm = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.ahy != null && !this.ahy.isRecycled()) {
            if (c(pointF)) {
                this.ans = true;
                this.anr = pointF;
                this.ank.add(pointF);
                if (this.anl != null) {
                    this.anl.c(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.ans = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.ans) {
            if (c(pointF, this.anr)) {
                e(this.anr, pointF);
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
            if (i2 >= this.anj.size()) {
                break;
            }
            PointF pointF = this.anj.get(i2);
            float f = pointF.x - this.ano;
            float f2 = pointF.y - this.anq;
            Bitmap bM = bM(i2);
            if (bM != null && !bM.isRecycled()) {
                canvas.drawBitmap(bM, f, f2, this.ani);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.ank.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.ano;
            float f4 = next.y - this.anq;
            if (this.ahy != null) {
                canvas.drawBitmap(this.ahy, f3, f4, this.ani);
            }
        }
    }

    private Bitmap bM(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.ahu.size()) {
                m mVar = this.ahu.get(i4);
                if (i3 < i && i <= mVar.st() + i3) {
                    return mVar.ahy;
                }
                i3 += mVar.st();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.ann / width;
        float f2 = this.anp / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.ahy = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.anl = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void ux() {
        if (this.anl != null && !ListUtils.isEmpty(this.anj)) {
            this.anl.c(0, 0L);
        }
        ListUtils.clear(this.anj);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.ant = i;
        this.anu = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.anu) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.anu && pointF.x > this.ano && pointF.x < ((float) getWidth()) - this.ano && pointF.y > this.anq && pointF.y < ((float) getHeight()) - this.anq;
    }

    public int getCurrentPointSize() {
        return this.anj.size() + this.ank.size();
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.anp;
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
                if (d(pointF3, pointF4) < this.anp) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.anu) {
                    this.ank.add(pointF4);
                    this.anr = pointF4;
                    if (this.anl != null) {
                        this.anl.c(getCurrentPointSize(), getTotalPrice());
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
            if (d(pointF5, pointF6) < this.anp) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.anu) {
                this.ank.add(pointF6);
                this.anr = pointF6;
                if (this.anl != null) {
                    this.anl.c(getCurrentPointSize(), getTotalPrice());
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
        return this.anj;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.ahu;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.ahu) {
            j = mVar.ahz != null ? (mVar.st() * JavaTypesHelper.toLong(mVar.ahz.getPrice(), 0L)) + j : j;
        }
        if (this.ank.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.ahz.getPrice(), 0L) * this.ank.size());
        }
        return j;
    }

    public void aK(boolean z) {
        if (this.ahu != null) {
            if (z) {
                for (m mVar : this.ahu) {
                    if (mVar.ahy != null && !mVar.ahy.isRecycled()) {
                        mVar.ahy.recycle();
                        mVar.ahy = null;
                    }
                }
            } else {
                for (m mVar2 : this.ahu) {
                    if (mVar2.ahy != null && !mVar2.ahy.isRecycled() && mVar2.ahz != this.ahz) {
                        mVar2.ahy.recycle();
                        mVar2.ahy = null;
                    }
                }
            }
        }
        if (this.ahu != null) {
            this.ahu.clear();
        }
        uy();
        ux();
        postInvalidate();
    }

    public void tF() {
        if (this.ahu != null && this.ank != null && this.ank.size() > 0) {
            this.ahu.add(getAlaGraffitiPointDesData());
        }
    }

    public void uy() {
        if (this.ank != null) {
            this.ank.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.ahy = this.ahy;
        mVar.ahz = this.ahz;
        mVar.dj(this.ahz != null ? this.ahz.rA() : "");
        mVar.setGiftId(this.ahz != null ? Integer.parseInt(this.ahz.rx()) : 0);
        mVar.bs(getCurrentPointSize() - this.anv);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.ahz = gVar;
    }

    public void uz() {
        if (this.ahu != null && this.ahu.size() > 0) {
            for (int st = this.ahu.get(this.ahu.size() - 1).st(); st > 0; st--) {
                this.anj.remove(this.anj.size() - 1);
            }
            this.ahu.remove(this.ahu.size() - 1);
            postInvalidate();
            if (this.anl != null) {
                this.anl.c(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
