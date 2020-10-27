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
import com.baidu.live.gift.m;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<m> aUG;
    private Bitmap aUK;
    private g aUL;
    private a bLx;
    private Paint bbQ;
    private ArrayList<PointF> bbR;
    private ArrayList<PointF> bbS;
    private boolean bbU;
    private float bbV;
    private float bbW;
    private float bbX;
    private float bbY;
    private PointF bbZ;
    private boolean bca;
    private int bcb;
    private int bcc;
    private int bcd;
    private int mBackgroundColor;

    /* loaded from: classes4.dex */
    public interface a {
        void e(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.bbU = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbU = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbU = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.bbQ = new Paint();
        this.bbQ.setAntiAlias(true);
        this.bbQ.setFilterBitmap(true);
        this.bbQ.setDither(true);
        this.bbR = new ArrayList<>();
        this.bbS = new ArrayList<>();
        this.aUG = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bbX = dip2px;
        this.bbV = dip2px;
        float f = this.bbX / 2.0f;
        this.bbY = f;
        this.bbW = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.bcd = this.bbR.size();
                this.bbS.clear();
                a(pointF);
                break;
            case 1:
                this.bbU = false;
                IF();
                this.bbR.addAll(this.bbS);
                IG();
                break;
            case 2:
                if (!this.bbU) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.bbU = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aUK != null && !this.aUK.isRecycled()) {
            if (c(pointF)) {
                this.bca = true;
                this.bbZ = pointF;
                this.bbS.add(pointF);
                if (this.bLx != null) {
                    this.bLx.e(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.bca = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.bca) {
            if (b(pointF, this.bbZ)) {
                d(this.bbZ, pointF);
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
            if (i2 >= this.bbR.size()) {
                break;
            }
            PointF pointF = this.bbR.get(i2);
            float f = pointF.x - this.bbW;
            float f2 = pointF.y - this.bbY;
            Bitmap ex = ex(i2);
            if (ex != null && !ex.isRecycled()) {
                canvas.drawBitmap(ex, f, f2, this.bbQ);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.bbS.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.bbW;
            float f4 = next.y - this.bbY;
            if (this.aUK != null) {
                canvas.drawBitmap(this.aUK, f3, f4, this.bbQ);
            }
        }
    }

    private Bitmap ex(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aUG.size()) {
                m mVar = this.aUG.get(i4);
                if (i3 < i && i <= mVar.Go() + i3) {
                    return mVar.aUK;
                }
                i3 += mVar.Go();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.bbV / width;
        float f2 = this.bbX / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aUK = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.bLx = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void IE() {
        if (this.bLx != null && !ListUtils.isEmpty(this.bbR)) {
            this.bLx.e(0, 0L);
        }
        ListUtils.clear(this.bbR);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.bcb = i;
        this.bcc = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.bcc) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.bcc && pointF.x > this.bbW && pointF.x < ((float) getWidth()) - this.bbW && pointF.y > this.bbY && pointF.y < ((float) getHeight()) - this.bbY;
    }

    public int getCurrentPointSize() {
        return this.bbR.size() + this.bbS.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.bbX;
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
                if (c(pointF3, pointF4) < this.bbX) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.bcc) {
                    this.bbS.add(pointF4);
                    this.bbZ = pointF4;
                    if (this.bLx != null) {
                        this.bLx.e(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.bbX) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.bcc) {
                this.bbS.add(pointF6);
                this.bbZ = pointF6;
                if (this.bLx != null) {
                    this.bLx.e(getCurrentPointSize(), getTotalPrice());
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
        return this.bbR;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aUG;
    }

    public long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aUG) {
            j = mVar.aUL != null ? (mVar.Go() * JavaTypesHelper.toLong(mVar.aUL.getPrice(), 0L)) + j : j;
        }
        if (this.bbS.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aUL.getPrice(), 0L) * this.bbS.size());
        }
        return j;
    }

    public void bO(boolean z) {
        if (this.aUG != null) {
            if (z) {
                for (m mVar : this.aUG) {
                    if (mVar.aUK != null && !mVar.aUK.isRecycled()) {
                        mVar.aUK.recycle();
                        mVar.aUK = null;
                    }
                }
            } else {
                for (m mVar2 : this.aUG) {
                    if (mVar2.aUK != null && !mVar2.aUK.isRecycled() && mVar2.aUL != this.aUL) {
                        mVar2.aUK.recycle();
                        mVar2.aUK = null;
                    }
                }
            }
        }
        if (this.aUG != null) {
            this.aUG.clear();
        }
        IG();
        IE();
        postInvalidate();
    }

    public void IF() {
        if (this.aUG != null && this.bbS != null && this.bbS.size() > 0) {
            this.aUG.add(getAlaGraffitiPointDesData());
        }
    }

    public void IG() {
        if (this.bbS != null) {
            this.bbS.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aUK = this.aUK;
        mVar.aUL = this.aUL;
        mVar.gF(this.aUL != null ? this.aUL.getThumbnail_url() : "");
        mVar.setGiftId(this.aUL != null ? Integer.parseInt(this.aUL.Fs()) : 0);
        mVar.dW(getCurrentPointSize() - this.bcd);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aUL = gVar;
    }

    public void IH() {
        if (this.aUG != null && this.aUG.size() > 0) {
            for (int Go = this.aUG.get(this.aUG.size() - 1).Go(); Go > 0; Go--) {
                this.bbR.remove(this.bbR.size() - 1);
            }
            this.aUG.remove(this.aUG.size() - 1);
            postInvalidate();
            if (this.bLx != null) {
                this.bLx.e(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
