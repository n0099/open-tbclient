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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaGiftDrawPanel extends FrameLayout {
    private Paint acm;
    private ArrayList<PointF> acn;
    private a aco;
    private boolean acp;
    private Bitmap acq;
    private float acr;
    private float acs;
    private float act;
    private float acu;
    private PointF acv;
    private boolean acx;
    private int acy;
    private int acz;
    private int mBackgroundColor;

    /* loaded from: classes6.dex */
    public interface a {
        void bp(int i);
    }

    public AlaGiftDrawPanel(Context context) {
        super(context);
        this.acp = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acp = false;
        this.mBackgroundColor = 0;
        init();
    }

    public AlaGiftDrawPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acp = false;
        this.mBackgroundColor = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_draw_region_layout, this);
        this.acm = new Paint();
        this.acm.setAntiAlias(true);
        this.acm.setFilterBitmap(true);
        this.acm.setDither(true);
        this.acn = new ArrayList<>();
        float dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.act = dip2px;
        this.acr = dip2px;
        float f = this.act / 2.0f;
        this.acu = f;
        this.acs = f;
        this.mBackgroundColor = getResources().getColor(a.d.sdk_black_alpha50);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                a(pointF);
                break;
            case 1:
                this.acp = false;
                break;
            case 2:
                if (!this.acp) {
                    b(pointF);
                    break;
                }
                break;
            case 6:
                this.acp = true;
                break;
        }
        return true;
    }

    private void a(PointF pointF) {
        if (this.acq != null && !this.acq.isRecycled()) {
            if (c(pointF)) {
                this.acx = true;
                this.acv = pointF;
                this.acn.add(pointF);
                if (this.aco != null) {
                    this.aco.bp(this.acn.size());
                }
            } else {
                this.acx = false;
            }
            postInvalidate();
        }
    }

    private void b(PointF pointF) {
        if (this.acx) {
            if (c(pointF, this.acv)) {
                e(this.acv, pointF);
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.mBackgroundColor);
        Iterator<PointF> it = this.acn.iterator();
        while (it.hasNext()) {
            PointF next = it.next();
            float f = next.x - this.acs;
            float f2 = next.y - this.acu;
            if (this.acq != null) {
                canvas.drawBitmap(this.acq, f, f2, this.acm);
            }
        }
    }

    public void setGiftBitmp(Bitmap bitmap) {
        if (this.acq != null && !this.acq.isRecycled()) {
            this.acq.recycle();
            this.acq = null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = this.acr / width;
        float f2 = this.act / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        this.acq = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void setGiftDrawEventListener(a aVar) {
        this.aco = aVar;
    }

    public void setTipImageVisibility(int i) {
        findViewById(a.g.ala_gift_draw_tip_text).setVisibility(i);
    }

    public void rh() {
        if (this.aco != null && !ListUtils.isEmpty(this.acn)) {
            this.aco.bp(0);
        }
        ListUtils.clear(this.acn);
        postInvalidate();
    }

    public void setGiftCountRange(int i, int i2) {
        this.acy = i;
        this.acz = i2;
    }

    private boolean c(PointF pointF) {
        return this.acn.size() < this.acz && pointF.x > this.acs && pointF.x < ((float) getWidth()) - this.acs && pointF.y > this.acu && pointF.y < ((float) getHeight()) - this.acu;
    }

    private boolean c(PointF pointF, PointF pointF2) {
        return c(pointF) && d(pointF, pointF2) >= this.act;
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
        int i4;
        int i5 = (int) pointF.x;
        int i6 = (int) pointF.y;
        int i7 = (int) pointF2.x;
        int i8 = (int) pointF2.y;
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        if (i10 < 0) {
            i = -1;
            i2 = -i10;
        } else {
            i = 1;
            i2 = i10;
        }
        if (i9 < 0) {
            i3 = -1;
            i4 = -i9;
        } else {
            i3 = 1;
            i4 = i9;
        }
        int i11 = i2 << 1;
        int i12 = i4 << 1;
        if (i12 > i11) {
            int i13 = i11 - (i12 >> 1);
            int i14 = i5;
            PointF pointF3 = pointF;
            while (i14 != i7) {
                if (i13 >= 0) {
                    i6 += i;
                    i13 -= i12;
                }
                int i15 = i14 + i3;
                int i16 = i13 + i11;
                PointF pointF4 = new PointF(i15, i6);
                if (d(pointF3, pointF4) < this.act) {
                    pointF4 = pointF3;
                } else if (this.acn.size() < this.acz) {
                    this.acn.add(pointF4);
                    this.acv = pointF4;
                    if (this.aco != null) {
                        this.aco.bp(this.acn.size());
                    }
                } else {
                    return;
                }
                pointF3 = pointF4;
                i13 = i16;
                i14 = i15;
            }
            return;
        }
        int i17 = i12 - (i11 >> 1);
        int i18 = i6;
        int i19 = i5;
        PointF pointF5 = pointF;
        while (i18 != i8) {
            if (i17 >= 0) {
                i19 += i3;
                i17 -= i11;
            }
            int i20 = i18 + i;
            int i21 = i17 + i12;
            PointF pointF6 = new PointF(i19, i20);
            if (d(pointF5, pointF6) < this.act) {
                pointF6 = pointF5;
            } else if (this.acn.size() < this.acz) {
                this.acn.add(pointF6);
                this.acv = pointF6;
                if (this.aco != null) {
                    this.aco.bp(this.acn.size());
                }
            } else {
                return;
            }
            pointF5 = pointF6;
            i17 = i21;
            i18 = i20;
        }
    }

    public List<PointF> getPoints() {
        return this.acn;
    }
}
