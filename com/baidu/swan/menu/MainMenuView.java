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
    private RecyclerView eab;
    private d eac;
    private RecyclerView ead;
    private d eae;
    private List<List<i>> eaf;
    private View eag;
    private boolean eah;
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
        this.eab = new RecyclerView(context, attributeSet, i);
        this.eab.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eab.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.eab, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.ead = new RecyclerView(context, attributeSet, i);
        this.ead.setVisibility(8);
        this.ead.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.ead, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean azu() {
        return this.eaf != null && this.eaf.size() > 1;
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
        this.eaf = list;
        this.eah = z;
        if (z && list.size() > 1) {
            mr(i);
        } else {
            ms(i);
        }
    }

    private void mr(int i) {
        this.mDivider.setVisibility(0);
        this.ead.setVisibility(0);
        if (this.eac == null) {
            this.eac = new d(getContext());
            this.eab.setAdapter(this.eac);
        }
        this.eac.b(this.eaf.subList(0, 1), this.eah, i);
        if (this.eae == null) {
            this.eae = new d(getContext());
            this.ead.setAdapter(this.eae);
        }
        this.eae.b(this.eaf.subList(1, 2), this.eah, i);
    }

    private void ms(int i) {
        this.mDivider.setVisibility(8);
        this.ead.setVisibility(8);
        if (this.eac == null) {
            this.eac = new d(getContext());
            this.eab.setAdapter(this.eac);
        }
        this.eac.b(this.eaf, this.eah, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.eab != null) {
            this.eab.scrollToPosition(0);
        }
        if (this.ead != null) {
            this.eab.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aXR() {
        if (this.eac != null) {
            this.eac.notifyDataSetChanged();
        }
        if (this.eae != null) {
            this.eae.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.eag;
    }

    public void setCoverView(View view) {
        this.eag = view;
    }
}
