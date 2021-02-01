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
/* loaded from: classes11.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<l> aXp;
    private Bitmap aXt;
    private g aXu;
    private ArrayList<PointF> bfA;
    private ArrayList<PointF> bfB;
    private a bfC;
    private boolean bfD;
    private float bfE;
    private float bfF;
    private float bfG;
    private float bfH;
    private PointF bfI;
    private boolean bfJ;
    private int bfK;
    private int bfL;
    private int bfM;
    private Paint bfz;
    private int mBackgroundColor;

    /* loaded from: classes11.dex */
    public interface a {
        void h(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.bfD = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfD = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfD = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_gift_draw_region_layout, this);
        this.bfz = new Paint();
        this.bfz.setAntiAlias(true);
        this.bfz.setFilterBitmap(true);
        this.bfz.setDither(true);
        this.bfA = new ArrayList<>();
        this.bfB = new ArrayList<>();
        this.aXp = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bfG = dip2px;
        this.bfE = dip2px;
        float f = this.bfG / 2.0f;
        this.bfH = f;
        this.bfF = f;
        this.mBackgroundColor = getResources().getColor(a.c.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.bfM = this.bfA.size();
                this.bfB.clear();
                a(pointF);
                break;
            case 1:
                this.bfD = false;
                Ht();
                this.bfA.addAll(this.bfB);
                Hu();
                break;
            case 2:
                if (!this.bfD) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.bfD = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aXt != null && !this.aXt.isRecycled()) {
            if (c(pointF)) {
                this.bfJ = true;
                this.bfI = pointF;
                this.bfB.add(pointF);
                if (this.bfC != null) {
                    this.bfC.h(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.bfJ = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.bfJ) {
            if (c(pointF, this.bfI)) {
                e(this.bfI, pointF);
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
            if (i2 >= this.bfA.size()) {
                break;
            }
            PointF pointF = this.bfA.get(i2);
            float f = pointF.x - this.bfF;
            float f2 = pointF.y - this.bfH;
            Bitmap dm = dm(i2);
            if (dm != null && !dm.isRecycled()) {
                canvas.drawBitmap(dm, f, f2, this.bfz);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.bfB.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.bfF;
            float f4 = next.y - this.bfH;
            if (this.aXt != null) {
                canvas.drawBitmap(this.aXt, f3, f4, this.bfz);
            }
        }
    }

    private Bitmap dm(int i) {
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.aXp.size()) {
                l lVar = this.aXp.get(i4);
                if (i2 < i && i <= lVar.ER() + i2) {
                    return lVar.aXt;
                }
                i2 += lVar.ER();
                i3 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.bfE / width;
        float f2 = this.bfG / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aXt = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.bfC = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.f.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Hs() {
        if (this.bfC != null && !ListUtils.isEmpty(this.bfA)) {
            this.bfC.h(0, 0L);
        }
        ListUtils.clear(this.bfA);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.bfK = i;
        this.bfL = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.bfL) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.h.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.bfL && pointF.x > this.bfF && pointF.x < ((float) getWidth()) - this.bfF && pointF.y > this.bfH && pointF.y < ((float) getHeight()) - this.bfH;
    }

    public int getCurrentPointSize() {
        return this.bfA.size() + this.bfB.size();
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.bfG;
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
                if (d(pointF3, pointF4) >= this.bfG) {
                    if (getCurrentPointSize() < this.bfL) {
                        this.bfB.add(pointF4);
                        this.bfI = pointF4;
                        if (this.bfC != null) {
                            this.bfC.h(getCurrentPointSize(), getTotalPrice());
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
            if (d(pointF5, pointF6) >= this.bfG) {
                if (getCurrentPointSize() < this.bfL) {
                    this.bfB.add(pointF6);
                    this.bfI = pointF6;
                    if (this.bfC != null) {
                        this.bfC.h(getCurrentPointSize(), getTotalPrice());
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
        return this.bfA;
    }

    public List<l> getGraffitiPointDesDatas() {
        return this.aXp;
    }

    private long getTotalPrice() {
        long j = 0;
        for (l lVar : this.aXp) {
            j = lVar.aXu != null ? (lVar.ER() * JavaTypesHelper.toLong(lVar.aXu.getPrice(), 0L)) + j : j;
        }
        if (this.bfB.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aXu.getPrice(), 0L) * this.bfB.size());
        }
        return j;
    }

    public void ca(boolean z) {
        if (this.aXp != null) {
            if (z) {
                for (l lVar : this.aXp) {
                    if (lVar.aXt != null && !lVar.aXt.isRecycled()) {
                        lVar.aXt.recycle();
                        lVar.aXt = null;
                    }
                }
            } else {
                for (l lVar2 : this.aXp) {
                    if (lVar2.aXt != null && !lVar2.aXt.isRecycled() && lVar2.aXu != this.aXu) {
                        lVar2.aXt.recycle();
                        lVar2.aXt = null;
                    }
                }
            }
        }
        if (this.aXp != null) {
            this.aXp.clear();
        }
        Hu();
        Hs();
        postInvalidate();
    }

    public void Ht() {
        if (this.aXp != null && this.bfB != null && this.bfB.size() > 0) {
            this.aXp.add(getAlaGraffitiPointDesData());
        }
    }

    public void Hu() {
        if (this.bfB != null) {
            this.bfB.clear();
        }
    }

    private l getAlaGraffitiPointDesData() {
        l lVar = new l();
        lVar.aXt = this.aXt;
        lVar.aXu = this.aXu;
        lVar.fT(this.aXu != null ? this.aXu.getThumbnail_url() : "");
        lVar.setGiftId(this.aXu != null ? Integer.parseInt(this.aXu.DR()) : 0);
        lVar.cJ(getCurrentPointSize() - this.bfM);
        return lVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aXu = gVar;
    }

    public void Hv() {
        if (this.aXp != null && this.aXp.size() > 0) {
            for (int ER = this.aXp.get(this.aXp.size() - 1).ER(); ER > 0; ER--) {
                this.bfA.remove(this.bfA.size() - 1);
            }
            this.aXp.remove(this.aXp.size() - 1);
            postInvalidate();
            if (this.bfC != null) {
                this.bfC.h(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
