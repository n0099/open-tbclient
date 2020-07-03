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
import com.baidu.swan.menu.g;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class GridPageView extends FrameLayout {
    private AutoGridView doH;
    private SlideableGridView.a doI;
    private int mPageIndex;

    public GridPageView(Context context) {
        super(context);
        this.doH = null;
        init(context);
    }

    public GridPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.doH = null;
        init(context);
    }

    public GridPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doH = null;
        init(context);
    }

    public void setGridItemAdapter(SlideableGridView.a aVar) {
        this.doI = aVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void av(int i, int i2) {
        this.doH.setNumColumns(i);
        this.mPageIndex = i2;
        ((a) this.doH.getAdapter()).notifyDataSetChanged();
    }

    private void init(Context context) {
        this.doH = new AutoGridView(context);
        this.doH.setNumColumns(5);
        this.doH.setFocusableInTouchMode(false);
        this.doH.setStretchMode(2);
        this.doH.setVerticalSpacing((int) getResources().getDimension(g.b.common_grid_row_margin));
        this.doH.setSelector(new ColorDrawable(0));
        this.doH.setAdapter((ListAdapter) new a(context));
        this.doH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.menu.viewpager.GridPageView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (GridPageView.this.doI != null) {
                    GridPageView.this.doI.a(GridPageView.this.mPageIndex, i, view);
                }
            }
        });
        addView(this.doH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends BaseAdapter {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (GridPageView.this.doI == null) {
                return 0;
            }
            return GridPageView.this.doI.jm(GridPageView.this.mPageIndex);
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
            return GridPageView.this.doI.a(GridPageView.this.mPageIndex, i, view, viewGroup);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (dataSetObserver != null) {
                super.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class AutoGridView extends GridView {
        private int doK;
        private int doL;

        public AutoGridView(Context context) {
            super(context);
            this.doL = 5;
        }

        @Override // android.widget.GridView
        public void setNumColumns(int i) {
            this.doL = i;
            super.setNumColumns(i);
            setSelection(this.doK);
        }

        @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            aGh();
        }

        @Override // android.view.View
        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (this.doK != firstVisiblePosition) {
                this.doK = firstVisiblePosition;
                aGh();
            }
            super.onScrollChanged(i, i2, i3, i4);
        }

        private void aGh() {
            int i = 0;
            if (getAdapter() != null) {
                ArrayList<Integer> arrayList = new ArrayList();
                int i2 = 0;
                int i3 = 0;
                while (i2 < getChildCount()) {
                    int i4 = 0;
                    for (int i5 = i2; i5 < this.doL + i2; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt != null && childAt.getHeight() > i4) {
                            i4 = childAt.getHeight();
                        }
                    }
                    if (i4 > 0) {
                        for (int i6 = i2; i6 < this.doL + i2; i6++) {
                            View childAt2 = getChildAt(i6);
                            if (childAt2 != null && childAt2.getHeight() != i4) {
                                childAt2.setMinimumHeight(i4);
                            }
                        }
                        arrayList.add(Integer.valueOf(i4));
                    }
                    i3++;
                    i2 += this.doL;
                }
                for (Integer num : arrayList) {
                    i += num.intValue();
                }
                getLayoutParams().height = ((i3 - 1) * getVerticalSpacing()) + i;
            }
        }
    }
}
