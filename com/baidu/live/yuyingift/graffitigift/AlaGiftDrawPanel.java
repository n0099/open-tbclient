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
/* loaded from: classes11.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<l> aYX;
    private Bitmap aZb;
    private g aZc;
    private Paint bhh;
    private ArrayList<PointF> bhi;
    private ArrayList<PointF> bhj;
    private boolean bhl;
    private float bhm;
    private float bhn;
    private float bho;
    private float bhp;
    private PointF bhq;
    private boolean bhr;
    private int bhs;
    private int bht;
    private int bhu;
    private a cax;
    private int mBackgroundColor;

    /* loaded from: classes11.dex */
    public interface a {
        void g(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.bhl = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhl = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhl = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_gift_draw_region_layout, this);
        this.bhh = new Paint();
        this.bhh.setAntiAlias(true);
        this.bhh.setFilterBitmap(true);
        this.bhh.setDither(true);
        this.bhi = new ArrayList<>();
        this.bhj = new ArrayList<>();
        this.aYX = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bho = dip2px;
        this.bhm = dip2px;
        float f = this.bho / 2.0f;
        this.bhp = f;
        this.bhn = f;
        this.mBackgroundColor = getResources().getColor(a.c.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.bhu = this.bhi.size();
                this.bhj.clear();
                a(pointF);
                break;
            case 1:
                this.bhl = false;
                JY();
                this.bhi.addAll(this.bhj);
                JZ();
                break;
            case 2:
                if (!this.bhl) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.bhl = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aZb != null && !this.aZb.isRecycled()) {
            if (c(pointF)) {
                this.bhr = true;
                this.bhq = pointF;
                this.bhj.add(pointF);
                if (this.cax != null) {
                    this.cax.g(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.bhr = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.bhr) {
            if (c(pointF, this.bhq)) {
                e(this.bhq, pointF);
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
            if (i2 >= this.bhi.size()) {
                break;
            }
            PointF pointF = this.bhi.get(i2);
            float f = pointF.x - this.bhn;
            float f2 = pointF.y - this.bhp;
            Bitmap eN = eN(i2);
            if (eN != null && !eN.isRecycled()) {
                canvas.drawBitmap(eN, f, f2, this.bhh);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.bhj.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.bhn;
            float f4 = next.y - this.bhp;
            if (this.aZb != null) {
                canvas.drawBitmap(this.aZb, f3, f4, this.bhh);
            }
        }
    }

    private Bitmap eN(int i) {
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.aYX.size()) {
                l lVar = this.aYX.get(i4);
                if (i2 < i && i <= lVar.Hw() + i2) {
                    return lVar.aZb;
                }
                i2 += lVar.Hw();
                i3 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.bhm / width;
        float f2 = this.bho / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aZb = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.cax = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.f.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void JX() {
        if (this.cax != null && !ListUtils.isEmpty(this.bhi)) {
            this.cax.g(0, 0L);
        }
        ListUtils.clear(this.bhi);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.bhs = i;
        this.bht = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.bht) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.h.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.bht && pointF.x > this.bhn && pointF.x < ((float) getWidth()) - this.bhn && pointF.y > this.bhp && pointF.y < ((float) getHeight()) - this.bhp;
    }

    public int getCurrentPointSize() {
        return this.bhi.size() + this.bhj.size();
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.bho;
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
                if (d(pointF3, pointF4) >= this.bho) {
                    if (getCurrentPointSize() < this.bht) {
                        this.bhj.add(pointF4);
                        this.bhq = pointF4;
                        if (this.cax != null) {
                            this.cax.g(getCurrentPointSize(), getTotalPrice());
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
            if (d(pointF5, pointF6) >= this.bho) {
                if (getCurrentPointSize() < this.bht) {
                    this.bhj.add(pointF6);
                    this.bhq = pointF6;
                    if (this.cax != null) {
                        this.cax.g(getCurrentPointSize(), getTotalPrice());
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
        return this.bhi;
    }

    public List<l> getGraffitiPointDesDatas() {
        return this.aYX;
    }

    public long getTotalPrice() {
        long j = 0;
        for (l lVar : this.aYX) {
            j = lVar.aZc != null ? (lVar.Hw() * JavaTypesHelper.toLong(lVar.aZc.getPrice(), 0L)) + j : j;
        }
        if (this.bhj.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aZc.getPrice(), 0L) * this.bhj.size());
        }
        return j;
    }

    public void bZ(boolean z) {
        if (this.aYX != null) {
            if (z) {
                for (l lVar : this.aYX) {
                    if (lVar.aZb != null && !lVar.aZb.isRecycled()) {
                        lVar.aZb.recycle();
                        lVar.aZb = null;
                    }
                }
            } else {
                for (l lVar2 : this.aYX) {
                    if (lVar2.aZb != null && !lVar2.aZb.isRecycled() && lVar2.aZc != this.aZc) {
                        lVar2.aZb.recycle();
                        lVar2.aZb = null;
                    }
                }
            }
        }
        if (this.aYX != null) {
            this.aYX.clear();
        }
        JZ();
        JX();
        postInvalidate();
    }

    public void JY() {
        if (this.aYX != null && this.bhj != null && this.bhj.size() > 0) {
            this.aYX.add(getAlaGraffitiPointDesData());
        }
    }

    public void JZ() {
        if (this.bhj != null) {
            this.bhj.clear();
        }
    }

    private l getAlaGraffitiPointDesData() {
        l lVar = new l();
        lVar.aZb = this.aZb;
        lVar.aZc = this.aZc;
        lVar.gK(this.aZc != null ? this.aZc.getThumbnail_url() : "");
        lVar.setGiftId(this.aZc != null ? Integer.parseInt(this.aZc.Gx()) : 0);
        lVar.ek(getCurrentPointSize() - this.bhu);
        return lVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aZc = gVar;
    }

    public void Ka() {
        if (this.aYX != null && this.aYX.size() > 0) {
            for (int Hw = this.aYX.get(this.aYX.size() - 1).Hw(); Hw > 0; Hw--) {
                this.bhi.remove(this.bhi.size() - 1);
            }
            this.aYX.remove(this.aYX.size() - 1);
            postInvalidate();
            if (this.cax != null) {
                this.cax.g(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
