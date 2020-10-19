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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    public List<m> aTK;
    private Bitmap aTO;
    private g aTP;
    private Paint baD;
    private ArrayList<PointF> baE;
    private ArrayList<PointF> baF;
    private a baG;
    private boolean baH;
    private float baI;
    private float baJ;
    private float baK;
    private float baL;
    private PointF baM;
    private boolean baN;
    private int baO;
    private int baP;
    private int baQ;
    private int mBackgroundColor;

    /* loaded from: classes4.dex */
    public interface a {
        void e(int i, long j);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.baH = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baH = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baH = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.baD = new Paint();
        this.baD.setAntiAlias(true);
        this.baD.setFilterBitmap(true);
        this.baD.setDither(true);
        this.baE = new ArrayList<>();
        this.baF = new ArrayList<>();
        this.aTK = new ArrayList();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.baK = dip2px;
        this.baI = dip2px;
        float f = this.baK / 2.0f;
        this.baL = f;
        this.baJ = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.baQ = this.baE.size();
                this.baF.clear();
                a(pointF);
                break;
            case 1:
                this.baH = false;
                Im();
                this.baE.addAll(this.baF);
                In();
                break;
            case 2:
                if (!this.baH) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.baH = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.aTO != null && !this.aTO.isRecycled()) {
            if (c(pointF)) {
                this.baN = true;
                this.baM = pointF;
                this.baF.add(pointF);
                if (this.baG != null) {
                    this.baG.e(getCurrentPointSize(), getTotalPrice());
                }
            } else {
                this.baN = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.baN) {
            if (b(pointF, this.baM)) {
                d(this.baM, pointF);
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
            if (i2 >= this.baE.size()) {
                break;
            }
            PointF pointF = this.baE.get(i2);
            float f = pointF.x - this.baJ;
            float f2 = pointF.y - this.baL;
            Bitmap ew = ew(i2);
            if (ew != null && !ew.isRecycled()) {
                canvas.drawBitmap(ew, f, f2, this.baD);
            }
            i = i2 + 1;
        }
        Iterator<PointF> it = this.baF.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f3 = next.x - this.baJ;
            float f4 = next.y - this.baL;
            if (this.aTO != null) {
                canvas.drawBitmap(this.aTO, f3, f4, this.baD);
            }
        }
    }

    private Bitmap ew(int i) {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int i4 = i2;
            if (i4 < this.aTK.size()) {
                m mVar = this.aTK.get(i4);
                if (i3 < i && i <= mVar.FZ() + i3) {
                    return mVar.aTO;
                }
                i3 += mVar.FZ();
                i2 = i4 + 1;
            } else {
                return null;
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.baI / width;
        float f2 = this.baK / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.aTO = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.baG = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void Il() {
        if (this.baG != null && !ListUtils.isEmpty(this.baE)) {
            this.baG.e(0, 0L);
        }
        ListUtils.clear(this.baE);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.baO = i;
        this.baP = i2;
    }

    private boolean c(PointF pointF) {
        if (getCurrentPointSize() >= this.baP) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.ala_gift_tip_max_size));
        }
        return getCurrentPointSize() < this.baP && pointF.x > this.baJ && pointF.x < ((float) getWidth()) - this.baJ && pointF.y > this.baL && pointF.y < ((float) getHeight()) - this.baL;
    }

    public int getCurrentPointSize() {
        return this.baE.size() + this.baF.size();
    }

    private boolean b(PointF pointF, PointF pointF2) {
        return c(pointF) && c(pointF, pointF2) >= this.baK;
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
                if (c(pointF3, pointF4) < this.baK) {
                    pointF4 = pointF3;
                } else if (getCurrentPointSize() < this.baP) {
                    this.baF.add(pointF4);
                    this.baM = pointF4;
                    if (this.baG != null) {
                        this.baG.e(getCurrentPointSize(), getTotalPrice());
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
            if (c(pointF5, pointF6) < this.baK) {
                pointF6 = pointF5;
            } else if (getCurrentPointSize() < this.baP) {
                this.baF.add(pointF6);
                this.baM = pointF6;
                if (this.baG != null) {
                    this.baG.e(getCurrentPointSize(), getTotalPrice());
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
        return this.baE;
    }

    public List<m> getGraffitiPointDesDatas() {
        return this.aTK;
    }

    private long getTotalPrice() {
        long j = 0;
        for (m mVar : this.aTK) {
            j = mVar.aTP != null ? (mVar.FZ() * JavaTypesHelper.toLong(mVar.aTP.getPrice(), 0L)) + j : j;
        }
        if (this.baF.size() > 0) {
            return j + (JavaTypesHelper.toLong(this.aTP.getPrice(), 0L) * this.baF.size());
        }
        return j;
    }

    public void bN(boolean z) {
        if (this.aTK != null) {
            if (z) {
                for (m mVar : this.aTK) {
                    if (mVar.aTO != null && !mVar.aTO.isRecycled()) {
                        mVar.aTO.recycle();
                        mVar.aTO = null;
                    }
                }
            } else {
                for (m mVar2 : this.aTK) {
                    if (mVar2.aTO != null && !mVar2.aTO.isRecycled() && mVar2.aTP != this.aTP) {
                        mVar2.aTO.recycle();
                        mVar2.aTO = null;
                    }
                }
            }
        }
        if (this.aTK != null) {
            this.aTK.clear();
        }
        In();
        Il();
        postInvalidate();
    }

    public void Im() {
        if (this.aTK != null && this.baF != null && this.baF.size() > 0) {
            this.aTK.add(getAlaGraffitiPointDesData());
        }
    }

    public void In() {
        if (this.baF != null) {
            this.baF.clear();
        }
    }

    private m getAlaGraffitiPointDesData() {
        m mVar = new m();
        mVar.aTO = this.aTO;
        mVar.aTP = this.aTP;
        mVar.gB(this.aTP != null ? this.aTP.getThumbnail_url() : "");
        mVar.setGiftId(this.aTP != null ? Integer.parseInt(this.aTP.Fd()) : 0);
        mVar.dW(getCurrentPointSize() - this.baQ);
        return mVar;
    }

    public void setAlaGiftItem(g gVar) {
        this.aTP = gVar;
    }

    public void Io() {
        if (this.aTK != null && this.aTK.size() > 0) {
            for (int FZ = this.aTK.get(this.aTK.size() - 1).FZ(); FZ > 0; FZ--) {
                this.baE.remove(this.baE.size() - 1);
            }
            this.aTK.remove(this.aTK.size() - 1);
            postInvalidate();
            if (this.baG != null) {
                this.baG.e(getCurrentPointSize(), getTotalPrice());
            }
        }
    }
}
