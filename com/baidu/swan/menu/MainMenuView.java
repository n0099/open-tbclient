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
    private RecyclerView cyB;
    private d cyC;
    private RecyclerView cyD;
    private d cyE;
    private List<List<i>> cyF;
    private View cyG;
    private boolean cyH;
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
        this.cyB = new RecyclerView(context, attributeSet, i);
        this.cyB.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.cyB.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.cyB, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.cyD = new RecyclerView(context, attributeSet, i);
        this.cyD.setVisibility(8);
        this.cyD.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.cyD, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean asJ() {
        return this.cyF != null && this.cyF.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        asK();
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
        this.cyF = list;
        this.cyH = z;
        if (z && list.size() > 1) {
            in(i);
        } else {
            io(i);
        }
    }

    private void in(int i) {
        this.mDivider.setVisibility(0);
        this.cyD.setVisibility(0);
        if (this.cyC == null) {
            this.cyC = new d(getContext());
            this.cyB.setAdapter(this.cyC);
        }
        this.cyC.b(this.cyF.subList(0, 1), this.cyH, i);
        if (this.cyE == null) {
            this.cyE = new d(getContext());
            this.cyD.setAdapter(this.cyE);
        }
        this.cyE.b(this.cyF.subList(1, 2), this.cyH, i);
    }

    private void io(int i) {
        this.mDivider.setVisibility(8);
        this.cyD.setVisibility(8);
        if (this.cyC == null) {
            this.cyC = new d(getContext());
            this.cyB.setAdapter(this.cyC);
        }
        this.cyC.b(this.cyF, this.cyH, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cyB != null) {
            this.cyB.scrollToPosition(0);
        }
        if (this.cyD != null) {
            this.cyB.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asL() {
        if (this.cyC != null) {
            this.cyC.notifyDataSetChanged();
        }
        if (this.cyE != null) {
            this.cyE.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.cyG;
    }

    public void setCoverView(View view) {
        this.cyG = view;
    }
}
