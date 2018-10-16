package com.baidu.searchbox.ng.aiapps.menu;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.searchbox.ng.aiapps.menu.viewpager.AiAppMenuSlidableGridView;
import java.util.List;
/* loaded from: classes2.dex */
public class MainMenuView extends BaseMenuView {
    private static final float ITEM_SIZE_OF_ONE_SCREEN = 5.5f;
    private static final String SHARE_BROWSER_LANDING_SOURCE = "browserlanding";
    private static final String SHARE_BROWSER_RESULT_SOURCE = "browserresult";
    private AiAppMenuGridViewAdapter mAiAppMenuGridViewAdapter;
    private View mCoverView;
    private List<AiAppMenuItem> mItems;
    private AiAppMenuSlidableGridView mMenuContentView;
    private int mMenuStyle;
    private AiAppMenuMode mMode;
    private boolean mNightEnable;
    private OnAiAppMenuItemClickListener mOnAiAppMenuItemClickListener;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mNightEnable = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.mMenuContentView = new AiAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.mMenuContentView.setPadding(0, (int) this.mContext.getResources().getDimension(R.dimen.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.mMenuContentView, layoutParams);
        setContentView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.BaseMenuView
    public boolean isHighMenu() {
        return this.mItems != null && this.mItems.size() > 0 && this.mItems.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.aiapps.menu.BaseMenuView
    public void setMode(AiAppMenuMode aiAppMenuMode) {
        this.mMode = aiAppMenuMode;
        this.mMenuContentView.setMode(aiAppMenuMode);
        super.setMode(aiAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.mMenuContentView.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.mMenuStyle = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateMenuItems(List<AiAppMenuItem> list) {
        this.mItems = list;
        this.mMenuContentView.setGridViewPading(0, 0, 0, 0);
        this.mMenuContentView.setIndicatorColor(R.drawable.menu_indicator_normal, R.drawable.menu_indicator_selected);
        this.mMenuContentView.setBackground(null);
        if (this.mAiAppMenuGridViewAdapter == null) {
            this.mAiAppMenuGridViewAdapter = new AiAppMenuGridViewAdapter(this.mContext);
            this.mMenuContentView.setGridItemAdapter(this.mAiAppMenuGridViewAdapter);
        }
        this.mAiAppMenuGridViewAdapter.setMenuStyle(this.mMenuStyle);
        this.mAiAppMenuGridViewAdapter.setNightEnable(this.mNightEnable);
        this.mAiAppMenuGridViewAdapter.setData(list);
        this.mAiAppMenuGridViewAdapter.notifyDataChanged();
        this.mItems = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyDataChanged() {
        if (this.mAiAppMenuGridViewAdapter != null) {
            this.mAiAppMenuGridViewAdapter.notifyDataChanged();
        }
    }

    public void setDismissCallback(DismissCallback dismissCallback) {
    }

    public void onShow() {
    }

    public void setStatisticSource(String str) {
    }

    public void setMenuSource(String str) {
    }

    @Nullable
    public View getCoverView() {
        return this.mCoverView;
    }

    public void setCoverView(View view) {
        this.mCoverView = view;
    }
}
