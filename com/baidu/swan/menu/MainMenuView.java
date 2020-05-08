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
/* loaded from: classes11.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView cXQ;
    private d cXR;
    private RecyclerView cXS;
    private d cXT;
    private List<List<i>> cXU;
    private View cXV;
    private boolean cXW;
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
        this.cXQ = new RecyclerView(context, attributeSet, i);
        this.cXQ.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.cXQ.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.cXQ, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.cXS = new RecyclerView(context, attributeSet, i);
        this.cXS.setVisibility(8);
        this.cXS.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.cXS, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aAY() {
        return this.cXU != null && this.cXU.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        aAZ();
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
        this.cXU = list;
        this.cXW = z;
        if (z && list.size() > 1) {
            iu(i);
        } else {
            iv(i);
        }
    }

    private void iu(int i) {
        this.mDivider.setVisibility(0);
        this.cXS.setVisibility(0);
        if (this.cXR == null) {
            this.cXR = new d(getContext());
            this.cXQ.setAdapter(this.cXR);
        }
        this.cXR.b(this.cXU.subList(0, 1), this.cXW, i);
        if (this.cXT == null) {
            this.cXT = new d(getContext());
            this.cXS.setAdapter(this.cXT);
        }
        this.cXT.b(this.cXU.subList(1, 2), this.cXW, i);
    }

    private void iv(int i) {
        this.mDivider.setVisibility(8);
        this.cXS.setVisibility(8);
        if (this.cXR == null) {
            this.cXR = new d(getContext());
            this.cXQ.setAdapter(this.cXR);
        }
        this.cXR.b(this.cXU, this.cXW, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cXQ != null) {
            this.cXQ.scrollToPosition(0);
        }
        if (this.cXS != null) {
            this.cXQ.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aBa() {
        if (this.cXR != null) {
            this.cXR.notifyDataSetChanged();
        }
        if (this.cXT != null) {
            this.cXT.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.cXV;
    }

    public void setCoverView(View view) {
        this.cXV = view;
    }
}
