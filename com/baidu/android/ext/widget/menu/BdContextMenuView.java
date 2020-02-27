package com.baidu.android.ext.widget.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import java.util.List;
/* loaded from: classes13.dex */
public class BdContextMenuView extends FrameLayout implements BdMenu.OnMenuSetChangedListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "BdContextMenuView";
    private Context mContext;
    public boolean mLayoutInCenter;
    private ListViewAdapter mListAdapter;
    private ListView mListView;
    private boolean mMenuLoaded;

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public void layoutMenu(List<BdMenuItem> list) {
        if (!this.mMenuLoaded) {
            if (this.mListAdapter == null) {
                this.mListAdapter = new ListViewAdapter(this.mContext, list);
                this.mListView.setAdapter((ListAdapter) this.mListAdapter);
            } else {
                this.mListAdapter.setData(list);
            }
            this.mMenuLoaded = true;
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.mMenuLoaded = false;
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    private void init() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.mContext.getResources().getDrawable(R.drawable.context_menu_bg));
        this.mListView = new ListView(this.mContext);
        this.mListView.setCacheColorHint(0);
        this.mListView.setDivider(getResources().getDrawable(R.color.context_menu_divider_color));
        this.mListView.setDividerHeight(1);
        this.mListView.setSelector(new ColorDrawable(0));
        addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.android.ext.widget.menu.BdContextMenuView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BdContextMenuView.this.mListAdapter.onItemClicked(i);
            }
        });
    }

    public void setLayoutInCenter(boolean z) {
        this.mLayoutInCenter = z;
    }

    /* loaded from: classes13.dex */
    private class ListViewAdapter extends BaseAdapter {
        private Context mContext;
        private List<BdMenuItem> mDataList;

        /* loaded from: classes13.dex */
        public class ViewHolder {
            public ImageView mListIcon;
            public TextView mListName;

            public ViewHolder() {
            }
        }

        public ListViewAdapter(Context context, List<BdMenuItem> list) {
            this.mDataList = list;
            this.mContext = context;
        }

        public void setData(List<BdMenuItem> list) {
            this.mDataList = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mDataList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.mDataList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            View view2;
            if (view == null) {
                view2 = LayoutInflater.from(this.mContext).inflate(R.layout.menu_item_view, (ViewGroup) null);
                ViewHolder viewHolder2 = new ViewHolder();
                viewHolder2.mListIcon = (ImageView) view2.findViewById(R.id.item_icon);
                viewHolder2.mListName = (TextView) view2.findViewById(R.id.item_title);
                viewHolder2.mListName.setTextColor(this.mContext.getResources().getColor(R.color.context_menu_item_title_color));
                setBackgroundSelector(view2, i);
                view2.setTag(viewHolder2);
                viewHolder = viewHolder2;
            } else {
                viewHolder = (ViewHolder) view.getTag();
                view2 = view;
            }
            BdMenuItem bdMenuItem = this.mDataList.get(i);
            viewHolder.mListName.setText(bdMenuItem.getTitle());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.mListName.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewHolder.mListIcon.getLayoutParams();
            if (bdMenuItem.getIcon() != null) {
                viewHolder.mListIcon.setVisibility(0);
                viewHolder.mListIcon.setImageDrawable(bdMenuItem.getIcon());
                layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelSize(R.dimen.context_menu_item_title_left_margin));
                viewHolder.mListName.setLayoutParams(layoutParams);
            } else {
                viewHolder.mListIcon.setVisibility(8);
                layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelSize(R.dimen.context_menu_item_icon_left_margin));
                viewHolder.mListName.setLayoutParams(layoutParams);
            }
            if (BdContextMenuView.this.mLayoutInCenter) {
                ((LinearLayout) view2).setGravity(17);
                layoutParams.width = -2;
                if (bdMenuItem.getIcon() != null) {
                    layoutParams2.setMarginStart(0);
                    viewHolder.mListIcon.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.setMarginStart(0);
                    viewHolder.mListName.setLayoutParams(layoutParams);
                }
            }
            return view2;
        }

        public void onItemClicked(int i) {
            BdMenuItem bdMenuItem = this.mDataList.get(i);
            BdMenuItem.OnItemClickListener onClickListener = bdMenuItem.getOnClickListener();
            if (onClickListener != null) {
                onClickListener.onClick(bdMenuItem);
            }
        }

        private void setBackgroundSelector(View view, int i) {
            if (getCount() == 1) {
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.context_menu_round_corner_selector));
            } else if (i == 0) {
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.context_menu_top_corner_selector));
            } else if (i == getCount() - 1) {
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.context_menu_bottom_corner_selector));
            } else {
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.context_menu_no_corner_selector));
            }
        }
    }
}
