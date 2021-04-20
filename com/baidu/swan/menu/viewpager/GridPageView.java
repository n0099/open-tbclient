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
import d.b.g0.i.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class GridPageView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public AutoGridView f12664e;

    /* renamed from: f  reason: collision with root package name */
    public SlideableGridView.a f12665f;

    /* renamed from: g  reason: collision with root package name */
    public int f12666g;

    /* loaded from: classes3.dex */
    public class AutoGridView extends GridView {

        /* renamed from: e  reason: collision with root package name */
        public int f12667e;

        /* renamed from: f  reason: collision with root package name */
        public int f12668f;

        public AutoGridView(Context context) {
            super(context);
            this.f12668f = 5;
        }

        public final void a() {
            if (getAdapter() != null) {
                ArrayList<Integer> arrayList = new ArrayList();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i2 < getChildCount()) {
                    int i4 = 0;
                    for (int i5 = i2; i5 < this.f12668f + i2; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt != null && childAt.getHeight() > i4) {
                            i4 = childAt.getHeight();
                        }
                    }
                    if (i4 > 0) {
                        for (int i6 = i2; i6 < this.f12668f + i2; i6++) {
                            View childAt2 = getChildAt(i6);
                            if (childAt2 != null && childAt2.getHeight() != i4) {
                                childAt2.setMinimumHeight(i4);
                            }
                        }
                        arrayList.add(Integer.valueOf(i4));
                    }
                    i3++;
                    i2 += this.f12668f;
                }
                for (Integer num : arrayList) {
                    i += num.intValue();
                }
                getLayoutParams().height = i + ((i3 - 1) * getVerticalSpacing());
            }
        }

        @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            a();
        }

        @Override // android.view.View
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (this.f12667e != firstVisiblePosition) {
                this.f12667e = firstVisiblePosition;
                a();
            }
            super.onScrollChanged(i, i2, i3, i4);
        }

        @Override // android.widget.GridView
        public void setNumColumns(int i) {
            this.f12668f = i;
            super.setNumColumns(i);
            setSelection(this.f12667e);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (GridPageView.this.f12665f != null) {
                GridPageView.this.f12665f.e(GridPageView.this.f12666g, i, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public Context f12671e;

        public b(Context context) {
            this.f12671e = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (GridPageView.this.f12665f == null) {
                return 0;
            }
            return GridPageView.this.f12665f.d(GridPageView.this.f12666g);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return GridPageView.this.f12665f.b(GridPageView.this.f12666g, i, view, viewGroup);
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
        this.f12664e = null;
        d(context);
    }

    public void c(int i, int i2) {
        this.f12664e.setNumColumns(i);
        this.f12666g = i2;
        ((b) this.f12664e.getAdapter()).notifyDataSetChanged();
    }

    public final void d(Context context) {
        AutoGridView autoGridView = new AutoGridView(context);
        this.f12664e = autoGridView;
        autoGridView.setNumColumns(5);
        this.f12664e.setFocusableInTouchMode(false);
        this.f12664e.setStretchMode(2);
        this.f12664e.setVerticalSpacing((int) getResources().getDimension(g.common_grid_row_margin));
        this.f12664e.setSelector(new ColorDrawable(0));
        this.f12664e.setAdapter((ListAdapter) new b(context));
        this.f12664e.setOnItemClickListener(new a());
        addView(this.f12664e);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setGridItemAdapter(SlideableGridView.a aVar) {
        this.f12665f = aVar;
    }

    public GridPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12664e = null;
        d(context);
    }

    public GridPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12664e = null;
        d(context);
    }
}
