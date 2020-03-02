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
    private RecyclerView cyC;
    private d cyD;
    private RecyclerView cyE;
    private d cyF;
    private List<List<i>> cyG;
    private View cyH;
    private boolean cyI;
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
        this.cyC = new RecyclerView(context, attributeSet, i);
        this.cyC.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.cyC.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.cyC, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.cyE = new RecyclerView(context, attributeSet, i);
        this.cyE.setVisibility(8);
        this.cyE.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.cyE, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean asL() {
        return this.cyG != null && this.cyG.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        asM();
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
        this.cyG = list;
        this.cyI = z;
        if (z && list.size() > 1) {
            in(i);
        } else {
            io(i);
        }
    }

    private void in(int i) {
        this.mDivider.setVisibility(0);
        this.cyE.setVisibility(0);
        if (this.cyD == null) {
            this.cyD = new d(getContext());
            this.cyC.setAdapter(this.cyD);
        }
        this.cyD.b(this.cyG.subList(0, 1), this.cyI, i);
        if (this.cyF == null) {
            this.cyF = new d(getContext());
            this.cyE.setAdapter(this.cyF);
        }
        this.cyF.b(this.cyG.subList(1, 2), this.cyI, i);
    }

    private void io(int i) {
        this.mDivider.setVisibility(8);
        this.cyE.setVisibility(8);
        if (this.cyD == null) {
            this.cyD = new d(getContext());
            this.cyC.setAdapter(this.cyD);
        }
        this.cyD.b(this.cyG, this.cyI, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cyC != null) {
            this.cyC.scrollToPosition(0);
        }
        if (this.cyE != null) {
            this.cyC.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asN() {
        if (this.cyD != null) {
            this.cyD.notifyDataSetChanged();
        }
        if (this.cyF != null) {
            this.cyF.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.cyH;
    }

    public void setCoverView(View view) {
        this.cyH = view;
    }
}
