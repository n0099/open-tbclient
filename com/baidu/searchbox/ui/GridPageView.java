package com.baidu.searchbox.ui;

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
import com.baidu.searchbox.ui.SlideableGridView;
/* loaded from: classes4.dex */
public class GridPageView extends FrameLayout {
    public SlideableGridView.GridItemAdapter mGridItemAdapter;
    public GridView mGridView;
    public int mPageIndex;

    /* loaded from: classes4.dex */
    public class ItemAdapter extends BaseAdapter {
        public Context mContext;

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

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
        public View getView(int i, View view2, ViewGroup viewGroup) {
            return GridPageView.this.mGridItemAdapter.getGridItemView(GridPageView.this.mPageIndex, i, view2, viewGroup);
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
        this.mGridView = null;
        init(context);
    }

    public void setGridItemAdapter(SlideableGridView.GridItemAdapter gridItemAdapter) {
        this.mGridItemAdapter = gridItemAdapter;
    }

    public GridPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGridView = null;
        init(context);
    }

    public void configItem(int i, int i2) {
        this.mGridView.setNumColumns(i);
        this.mPageIndex = i2;
        ((ItemAdapter) this.mGridView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public GridPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGridView = null;
        init(context);
    }

    private void init(Context context) {
        GridView gridView = new GridView(context);
        this.mGridView = gridView;
        gridView.setNumColumns(5);
        this.mGridView.setFocusableInTouchMode(false);
        this.mGridView.setStretchMode(2);
        this.mGridView.setVerticalSpacing((int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070249));
        this.mGridView.setSelector(new ColorDrawable(0));
        this.mGridView.setAdapter((ListAdapter) new ItemAdapter(context));
        this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.searchbox.ui.GridPageView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (GridPageView.this.mGridItemAdapter != null) {
                    GridPageView.this.mGridItemAdapter.onGridItemClick(GridPageView.this.mPageIndex, i, view2);
                }
            }
        });
        addView(this.mGridView);
    }
}
