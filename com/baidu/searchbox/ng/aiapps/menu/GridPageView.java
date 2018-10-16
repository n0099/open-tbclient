package com.baidu.searchbox.ng.aiapps.menu;

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
import com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView;
/* loaded from: classes2.dex */
public class GridPageView extends FrameLayout {
    private SlideableGridView.GridItemAdapter mGridItemAdapter;
    private GridView mGridView;
    private int mPageIndex;

    public GridPageView(Context context) {
        super(context);
        this.mGridView = null;
        init(context);
    }

    public GridPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGridView = null;
        init(context);
    }

    public GridPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGridView = null;
        init(context);
    }

    public void setGridItemAdapter(SlideableGridView.GridItemAdapter gridItemAdapter) {
        this.mGridItemAdapter = gridItemAdapter;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void configItem(int i, int i2) {
        this.mGridView.setNumColumns(i);
        this.mPageIndex = i2;
        ((ItemAdapter) this.mGridView.getAdapter()).notifyDataSetChanged();
    }

    private void init(Context context) {
        this.mGridView = new GridView(context);
        this.mGridView.setNumColumns(5);
        this.mGridView.setFocusableInTouchMode(false);
        this.mGridView.setStretchMode(2);
        this.mGridView.setVerticalSpacing((int) getResources().getDimension(R.dimen.common_grid_row_margin));
        this.mGridView.setSelector(new ColorDrawable(0));
        this.mGridView.setAdapter((ListAdapter) new ItemAdapter(context));
        this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.searchbox.ng.aiapps.menu.GridPageView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (GridPageView.this.mGridItemAdapter != null) {
                    GridPageView.this.mGridItemAdapter.onGridItemClick(GridPageView.this.mPageIndex, i, view);
                }
            }
        });
        addView(this.mGridView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ItemAdapter extends BaseAdapter {
        private Context mContext;

        public ItemAdapter(Context context) {
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (GridPageView.this.mGridItemAdapter == null) {
                return 0;
            }
            return GridPageView.this.mGridItemAdapter.getPageGridItemCount(GridPageView.this.mPageIndex);
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
            return GridPageView.this.mGridItemAdapter.getGridItemView(GridPageView.this.mPageIndex, i, view, viewGroup);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (dataSetObserver != null) {
                super.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }
}
