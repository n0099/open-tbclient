package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import java.util.List;
/* loaded from: classes.dex */
public class UserPhotoLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private com.baidu.adp.lib.d.b<HeadImageView> a;
    private aa b;
    private z c;
    private Context d;
    private List<MetaData> e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j;

    public void setAutoChangeStyle(boolean z) {
        this.i = z;
    }

    public int getNormalShowCount() {
        return this.j;
    }

    public void setNormalShowCount(int i) {
        this.j = i;
    }

    public int getItemSize() {
        return this.f;
    }

    public void setItemSize(int i) {
        this.f = i;
    }

    public UserPhotoLayout(Context context) {
        this(context, null);
    }

    public UserPhotoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.f = 0;
        this.h = 5;
        this.i = true;
        this.j = 6;
        this.d = context;
        this.h = com.baidu.adp.lib.util.j.a(this.d, this.h);
        this.f = (int) this.d.getResources().getDimension(com.baidu.tieba.t.ds60);
        if (this.d instanceof ab) {
            ab abVar = (ab) this.d;
            this.a = abVar.c();
            if (abVar.a() != null && this.b == null) {
                this.b = new aa(abVar.b());
                abVar.a().setRecyclerListener(this.b);
            }
        }
        setOnHierarchyChangeListener(new x(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new y(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new y(this, getChildCount() - 1, null));
    }

    public void a(List<MetaData> list, boolean z) {
        a();
        this.e = list;
        if (this.e == null) {
            requestLayout();
            invalidate();
            return;
        }
        this.g = this.e.size();
        if (this.g > this.j) {
            this.g = this.j;
        }
        for (int i = 0; i < this.g; i++) {
            HeadImageView a = a(this.d);
            a.setAutoChangeStyle(this.i);
            a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(a);
            a.a(this.e.get(i).getPortrait(), 12, false);
            a.setDefaultResource(com.baidu.tieba.u.photo);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (this.g == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension((this.g * this.f) + ((this.g - 1) * this.h), this.f);
        while (true) {
            int i4 = i3;
            if (i4 < this.g) {
                measureChild((HeadImageView) getChildAt(i4), this.f, this.f);
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g != 0) {
            for (int i5 = 0; i5 < this.g; i5++) {
                ((HeadImageView) getChildAt(i5)).layout((this.h * i5) + (this.f * i5), 0, (this.h * i5) + (this.f * (i5 + 1)), this.f);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.e != null && this.e.size() > 0) {
            this.g = getChildCount();
            if (this.g != 0) {
                long drawingTime = getDrawingTime();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.g) {
                        drawChild(canvas, (HeadImageView) getChildAt(i2), drawingTime);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setOnChildClickListener(z zVar) {
        this.c = zVar;
    }

    public void a() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null && (view instanceof UserPhotoLayout)) {
            a();
        }
    }

    private HeadImageView a(Context context) {
        HeadImageView headImageView = null;
        if (this.a != null) {
            headImageView = this.a.a();
        }
        if (headImageView == null || headImageView.getParent() != null) {
            return new HeadImageView(context);
        }
        return headImageView;
    }
}
