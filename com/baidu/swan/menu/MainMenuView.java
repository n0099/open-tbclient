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
    private RecyclerView efS;
    private d efT;
    private RecyclerView efU;
    private d efV;
    private List<List<i>> efW;
    private View efX;
    private boolean efY;
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
        this.efS = new RecyclerView(context, attributeSet, i);
        this.efS.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.efS.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.efS, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.efU = new RecyclerView(context, attributeSet, i);
        this.efU.setVisibility(8);
        this.efU.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.efU, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aBU() {
        return this.efW != null && this.efW.size() > 1;
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
        this.efW = list;
        this.efY = z;
        if (z && list.size() > 1) {
            mB(i);
        } else {
            mC(i);
        }
    }

    private void mB(int i) {
        this.mDivider.setVisibility(0);
        this.efU.setVisibility(0);
        if (this.efT == null) {
            this.efT = new d(getContext());
            this.efS.setAdapter(this.efT);
        }
        this.efT.b(this.efW.subList(0, 1), this.efY, i);
        if (this.efV == null) {
            this.efV = new d(getContext());
            this.efU.setAdapter(this.efV);
        }
        this.efV.b(this.efW.subList(1, 2), this.efY, i);
    }

    private void mC(int i) {
        this.mDivider.setVisibility(8);
        this.efU.setVisibility(8);
        if (this.efT == null) {
            this.efT = new d(getContext());
            this.efS.setAdapter(this.efT);
        }
        this.efT.b(this.efW, this.efY, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.efS != null) {
            this.efS.scrollToPosition(0);
        }
        if (this.efU != null) {
            this.efS.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bar() {
        if (this.efT != null) {
            this.efT.notifyDataSetChanged();
        }
        if (this.efV != null) {
            this.efV.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.efX;
    }

    public void setCoverView(View view) {
        this.efX = view;
    }
}
