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
/* loaded from: classes14.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView dDD;
    private d dDE;
    private RecyclerView dDF;
    private d dDG;
    private List<List<i>> dDH;
    private View dDI;
    private boolean dDJ;
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
        this.dDD = new RecyclerView(context, attributeSet, i);
        this.dDD.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dDD.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.dDD, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.dDF = new RecyclerView(context, attributeSet, i);
        this.dDF.setVisibility(8);
        this.dDF.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.dDF, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aug() {
        return this.dDH != null && this.dDH.size() > 1;
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
        this.dDH = list;
        this.dDJ = z;
        if (z && list.size() > 1) {
            ly(i);
        } else {
            lz(i);
        }
    }

    private void ly(int i) {
        this.mDivider.setVisibility(0);
        this.dDF.setVisibility(0);
        if (this.dDE == null) {
            this.dDE = new d(getContext());
            this.dDD.setAdapter(this.dDE);
        }
        this.dDE.b(this.dDH.subList(0, 1), this.dDJ, i);
        if (this.dDG == null) {
            this.dDG = new d(getContext());
            this.dDF.setAdapter(this.dDG);
        }
        this.dDG.b(this.dDH.subList(1, 2), this.dDJ, i);
    }

    private void lz(int i) {
        this.mDivider.setVisibility(8);
        this.dDF.setVisibility(8);
        if (this.dDE == null) {
            this.dDE = new d(getContext());
            this.dDD.setAdapter(this.dDE);
        }
        this.dDE.b(this.dDH, this.dDJ, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dDD != null) {
            this.dDD.scrollToPosition(0);
        }
        if (this.dDF != null) {
            this.dDD.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aSD() {
        if (this.dDE != null) {
            this.dDE.notifyDataSetChanged();
        }
        if (this.dDG != null) {
            this.dDG.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.dDI;
    }

    public void setCoverView(View view) {
        this.dDI = view;
    }
}
