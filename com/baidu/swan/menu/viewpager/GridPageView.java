package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import d.a.l0.k.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class GridPageView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public AutoGridView f11818e;

    /* renamed from: f  reason: collision with root package name */
    public SlideableGridView.a f11819f;

    /* renamed from: g  reason: collision with root package name */
    public int f11820g;

    /* loaded from: classes3.dex */
    public class AutoGridView extends GridView {

        /* renamed from: e  reason: collision with root package name */
        public int f11821e;

        /* renamed from: f  reason: collision with root package name */
        public int f11822f;

        public AutoGridView(Context context) {
            super(context);
            this.f11822f = 5;
        }

        public final void a() {
            if (getAdapter() != null) {
                ArrayList<Integer> arrayList = new ArrayList();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i3 < getChildCount()) {
                    int i5 = 0;
                    for (int i6 = i3; i6 < this.f11822f + i3; i6++) {
                        View childAt = getChildAt(i6);
                        if (childAt != null && childAt.getHeight() > i5) {
                            i5 = childAt.getHeight();
                        }
                    }
                    if (i5 > 0) {
                        for (int i7 = i3; i7 < this.f11822f + i3; i7++) {
                            View childAt2 = getChildAt(i7);
                            if (childAt2 != null && childAt2.getHeight() != i5) {
                                childAt2.setMinimumHeight(i5);
                            }
                        }
                        arrayList.add(Integer.valueOf(i5));
                    }
                    i4++;
                    i3 += this.f11822f;
                }
                for (Integer num : arrayList) {
                    i2 += num.intValue();
                }
                getLayoutParams().height = i2 + ((i4 - 1) * getVerticalSpacing());
            }
        }

        @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            a();
        }

        @Override // android.view.View
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (this.f11821e != firstVisiblePosition) {
                this.f11821e = firstVisiblePosition;
                a();
            }
            super.onScrollChanged(i2, i3, i4, i5);
        }

        @Override // android.widget.GridView
        public void setNumColumns(int i2) {
            this.f11822f = i2;
            super.setNumColumns(i2);
            setSelection(this.f11821e);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            GridPageView gridPageView = GridPageView.this;
            SlideableGridView.a aVar = gridPageView.f11819f;
            if (aVar != null) {
                aVar.e(gridPageView.f11820g, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public Context f11825e;

        public b(Context context) {
            this.f11825e = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            GridPageView gridPageView = GridPageView.this;
            SlideableGridView.a aVar = gridPageView.f11819f;
            if (aVar == null) {
                return 0;
            }
            return aVar.d(gridPageView.f11820g);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            GridPageView gridPageView = GridPageView.this;
            return gridPageView.f11819f.b(gridPageView.f11820g, i2, view, viewGroup);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (dataSetObserver != null) {
                super.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public GridPageView(Context context) {
        super(context);
        this.f11818e = null;
        b(context);
    }

    public void a(int i2, int i3) {
        this.f11818e.setNumColumns(i2);
        this.f11820g = i3;
        ((b) this.f11818e.getAdapter()).notifyDataSetChanged();
    }

    public final void b(Context context) {
        AutoGridView autoGridView = new AutoGridView(context);
        this.f11818e = autoGridView;
        autoGridView.setNumColumns(5);
        this.f11818e.setFocusableInTouchMode(false);
        this.f11818e.setStretchMode(2);
        this.f11818e.setVerticalSpacing((int) getResources().getDimension(g.common_grid_row_margin));
        this.f11818e.setSelector(new ColorDrawable(0));
        this.f11818e.setAdapter((ListAdapter) new b(context));
        this.f11818e.setOnItemClickListener(new a());
        addView(this.f11818e);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setGridItemAdapter(SlideableGridView.a aVar) {
        this.f11819f = aVar;
    }

    public GridPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11818e = null;
        b(context);
    }

    public GridPageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11818e = null;
        b(context);
    }
}
