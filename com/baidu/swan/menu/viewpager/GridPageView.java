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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GridPageView extends FrameLayout {
    public AutoGridView a;
    public SlideableGridView.a b;
    public int c;

    /* loaded from: classes4.dex */
    public class AutoGridView extends GridView {
        public int a;
        public int b;

        public AutoGridView(Context context) {
            super(context);
            this.b = 5;
        }

        public final void a() {
            if (getAdapter() != null) {
                ArrayList<Integer> arrayList = new ArrayList();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i2 < getChildCount()) {
                    int i4 = 0;
                    for (int i5 = i2; i5 < this.b + i2; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt != null && childAt.getHeight() > i4) {
                            i4 = childAt.getHeight();
                        }
                    }
                    if (i4 > 0) {
                        for (int i6 = i2; i6 < this.b + i2; i6++) {
                            View childAt2 = getChildAt(i6);
                            if (childAt2 != null && childAt2.getHeight() != i4) {
                                childAt2.setMinimumHeight(i4);
                            }
                        }
                        arrayList.add(Integer.valueOf(i4));
                    }
                    i3++;
                    i2 += this.b;
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
            if (this.a != firstVisiblePosition) {
                this.a = firstVisiblePosition;
                a();
            }
            super.onScrollChanged(i, i2, i3, i4);
        }

        @Override // android.widget.GridView
        public void setNumColumns(int i) {
            this.b = i;
            super.setNumColumns(i);
            setSelection(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            GridPageView gridPageView = GridPageView.this;
            SlideableGridView.a aVar = gridPageView.b;
            if (aVar != null) {
                aVar.e(gridPageView.c, i, view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public Context a;

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public b(Context context) {
            this.a = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            GridPageView gridPageView = GridPageView.this;
            SlideableGridView.a aVar = gridPageView.b;
            if (aVar == null) {
                return 0;
            }
            return aVar.d(gridPageView.c);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            GridPageView gridPageView = GridPageView.this;
            return gridPageView.b.b(gridPageView.c, i, view2, viewGroup);
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
        this.a = null;
        b(context);
    }

    public void setGridItemAdapter(SlideableGridView.a aVar) {
        this.b = aVar;
    }

    public GridPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        b(context);
    }

    public void a(int i, int i2) {
        this.a.setNumColumns(i);
        this.c = i2;
        ((b) this.a.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public GridPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        b(context);
    }

    public final void b(Context context) {
        AutoGridView autoGridView = new AutoGridView(context);
        this.a = autoGridView;
        autoGridView.setNumColumns(5);
        this.a.setFocusableInTouchMode(false);
        this.a.setStretchMode(2);
        this.a.setVerticalSpacing((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07024e));
        this.a.setSelector(new ColorDrawable(0));
        this.a.setAdapter((ListAdapter) new b(context));
        this.a.setOnItemClickListener(new a());
        addView(this.a);
    }
}
