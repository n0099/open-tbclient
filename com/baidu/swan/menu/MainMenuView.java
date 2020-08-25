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
    private d dDA;
    private RecyclerView dDB;
    private d dDC;
    private List<List<i>> dDD;
    private View dDE;
    private boolean dDF;
    private RecyclerView dDz;
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
        this.dDz = new RecyclerView(context, attributeSet, i);
        this.dDz.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dDz.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.dDz, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.dDB = new RecyclerView(context, attributeSet, i);
        this.dDB.setVisibility(8);
        this.dDB.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.dDB, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aug() {
        return this.dDD != null && this.dDD.size() > 1;
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
        this.dDD = list;
        this.dDF = z;
        if (z && list.size() > 1) {
            ly(i);
        } else {
            lz(i);
        }
    }

    private void ly(int i) {
        this.mDivider.setVisibility(0);
        this.dDB.setVisibility(0);
        if (this.dDA == null) {
            this.dDA = new d(getContext());
            this.dDz.setAdapter(this.dDA);
        }
        this.dDA.b(this.dDD.subList(0, 1), this.dDF, i);
        if (this.dDC == null) {
            this.dDC = new d(getContext());
            this.dDB.setAdapter(this.dDC);
        }
        this.dDC.b(this.dDD.subList(1, 2), this.dDF, i);
    }

    private void lz(int i) {
        this.mDivider.setVisibility(8);
        this.dDB.setVisibility(8);
        if (this.dDA == null) {
            this.dDA = new d(getContext());
            this.dDz.setAdapter(this.dDA);
        }
        this.dDA.b(this.dDD, this.dDF, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dDz != null) {
            this.dDz.scrollToPosition(0);
        }
        if (this.dDB != null) {
            this.dDz.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aSD() {
        if (this.dDA != null) {
            this.dDA.notifyDataSetChanged();
        }
        if (this.dDC != null) {
            this.dDC.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.dDE;
    }

    public void setCoverView(View view) {
        this.dDE = view;
    }
}
