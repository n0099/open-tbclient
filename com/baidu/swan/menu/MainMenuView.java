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
    private RecyclerView elm;
    private d eln;
    private RecyclerView elo;
    private d elp;
    private List<List<i>> elq;
    private View elr;
    private boolean els;
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
        this.elm = new RecyclerView(context, attributeSet, i);
        this.elm.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.elm.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.elm, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.elo = new RecyclerView(context, attributeSet, i);
        this.elo.setVisibility(8);
        this.elo.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.elo, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aEv() {
        return this.elq != null && this.elq.size() > 1;
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
        this.elq = list;
        this.els = z;
        if (z && list.size() > 1) {
            mV(i);
        } else {
            mW(i);
        }
    }

    private void mV(int i) {
        this.mDivider.setVisibility(0);
        this.elo.setVisibility(0);
        if (this.eln == null) {
            this.eln = new d(getContext());
            this.elm.setAdapter(this.eln);
        }
        this.eln.b(this.elq.subList(0, 1), this.els, i);
        if (this.elp == null) {
            this.elp = new d(getContext());
            this.elo.setAdapter(this.elp);
        }
        this.elp.b(this.elq.subList(1, 2), this.els, i);
    }

    private void mW(int i) {
        this.mDivider.setVisibility(8);
        this.elo.setVisibility(8);
        if (this.eln == null) {
            this.eln = new d(getContext());
            this.elm.setAdapter(this.eln);
        }
        this.eln.b(this.elq, this.els, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.elm != null) {
            this.elm.scrollToPosition(0);
        }
        if (this.elo != null) {
            this.elm.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcP() {
        if (this.eln != null) {
            this.eln.notifyDataSetChanged();
        }
        if (this.elp != null) {
            this.elp.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.elr;
    }

    public void setCoverView(View view) {
        this.elr = view;
    }
}
