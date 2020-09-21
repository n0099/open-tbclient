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
/* loaded from: classes23.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView dFE;
    private d dFF;
    private RecyclerView dFG;
    private d dFH;
    private List<List<i>> dFI;
    private View dFJ;
    private boolean dFK;
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
        this.dFE = new RecyclerView(context, attributeSet, i);
        this.dFE.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dFE.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.dFE, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.dFG = new RecyclerView(context, attributeSet, i);
        this.dFG.setVisibility(8);
        this.dFG.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.dFG, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean auP() {
        return this.dFI != null && this.dFI.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        setMode();
        setMenuHeader(view);
        a(list, z, i);
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

    private void a(List<List<i>> list, boolean z, int i) {
        this.dFI = list;
        this.dFK = z;
        if (z && list.size() > 1) {
            lJ(i);
        } else {
            lK(i);
        }
    }

    private void lJ(int i) {
        this.mDivider.setVisibility(0);
        this.dFG.setVisibility(0);
        if (this.dFF == null) {
            this.dFF = new d(getContext());
            this.dFE.setAdapter(this.dFF);
        }
        this.dFF.b(this.dFI.subList(0, 1), this.dFK, i);
        if (this.dFH == null) {
            this.dFH = new d(getContext());
            this.dFG.setAdapter(this.dFH);
        }
        this.dFH.b(this.dFI.subList(1, 2), this.dFK, i);
    }

    private void lK(int i) {
        this.mDivider.setVisibility(8);
        this.dFG.setVisibility(8);
        if (this.dFF == null) {
            this.dFF = new d(getContext());
            this.dFE.setAdapter(this.dFF);
        }
        this.dFF.b(this.dFI, this.dFK, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dFE != null) {
            this.dFE.scrollToPosition(0);
        }
        if (this.dFG != null) {
            this.dFE.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aTp() {
        if (this.dFF != null) {
            this.dFF.notifyDataSetChanged();
        }
        if (this.dFH != null) {
            this.dFH.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.dFJ;
    }

    public void setCoverView(View view) {
        this.dFJ = view;
    }
}
