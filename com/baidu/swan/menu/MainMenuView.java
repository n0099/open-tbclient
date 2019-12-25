package com.baidu.swan.menu;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.swan.menu.g;
import java.util.List;
/* loaded from: classes9.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView cuq;
    private d cus;
    private RecyclerView cuu;
    private d cuv;
    private List<List<i>> cuw;
    private View cux;
    private boolean cuy;
    private LinearLayout mContentView;
    private View mDivider;
    private View mHeaderView;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mContentView = new LinearLayout(context, attributeSet, i);
        this.mContentView.setOrientation(1);
        this.cuq = new RecyclerView(context, attributeSet, i);
        this.cuq.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.cuq.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.cuq, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.cuu = new RecyclerView(context, attributeSet, i);
        this.cuu.setVisibility(8);
        this.cuu.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.cuu, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aqc() {
        return this.cuw != null && this.cuw.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        aqd();
        setMenuHeader(view);
        c(list, z, i);
    }

    private void setMenuHeader(View view) {
        if (view != null && view != this.mHeaderView) {
            if (this.mHeaderView != null) {
                this.mContentView.removeView(this.mHeaderView);
            }
            this.mHeaderView = view;
            this.mContentView.addView(this.mHeaderView, 0);
        }
    }

    private void c(List<List<i>> list, boolean z, int i) {
        this.cuw = list;
        this.cuy = z;
        if (z && list.size() > 1) {
            hW(i);
        } else {
            hX(i);
        }
    }

    private void hW(int i) {
        this.mDivider.setVisibility(0);
        this.cuu.setVisibility(0);
        if (this.cus == null) {
            this.cus = new d(getContext());
            this.cuq.setAdapter(this.cus);
        }
        this.cus.d(this.cuw.subList(0, 1), this.cuy, i);
        if (this.cuv == null) {
            this.cuv = new d(getContext());
            this.cuu.setAdapter(this.cuv);
        }
        this.cuv.d(this.cuw.subList(1, 2), this.cuy, i);
    }

    private void hX(int i) {
        this.mDivider.setVisibility(8);
        this.cuu.setVisibility(8);
        if (this.cus == null) {
            this.cus = new d(getContext());
            this.cuq.setAdapter(this.cus);
        }
        this.cus.d(this.cuw, this.cuy, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cuq != null) {
            this.cuq.scrollToPosition(0);
        }
        if (this.cuu != null) {
            this.cuq.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqe() {
        if (this.cus != null) {
            this.cus.notifyDataSetChanged();
        }
        if (this.cuv != null) {
            this.cuv.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.cux;
    }

    public void setCoverView(View view) {
        this.cux = view;
    }
}
