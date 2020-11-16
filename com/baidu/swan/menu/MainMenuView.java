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
/* loaded from: classes5.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView eel;
    private d eem;
    private RecyclerView een;
    private d eeo;
    private List<List<i>> eep;
    private View eeq;
    private boolean eer;
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
        this.eel = new RecyclerView(context, attributeSet, i);
        this.eel.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eel.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.eel, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.een = new RecyclerView(context, attributeSet, i);
        this.een.setVisibility(8);
        this.een.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.een, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aBm() {
        return this.eep != null && this.eep.size() > 1;
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
        this.eep = list;
        this.eer = z;
        if (z && list.size() > 1) {
            mx(i);
        } else {
            my(i);
        }
    }

    private void mx(int i) {
        this.mDivider.setVisibility(0);
        this.een.setVisibility(0);
        if (this.eem == null) {
            this.eem = new d(getContext());
            this.eel.setAdapter(this.eem);
        }
        this.eem.b(this.eep.subList(0, 1), this.eer, i);
        if (this.eeo == null) {
            this.eeo = new d(getContext());
            this.een.setAdapter(this.eeo);
        }
        this.eeo.b(this.eep.subList(1, 2), this.eer, i);
    }

    private void my(int i) {
        this.mDivider.setVisibility(8);
        this.een.setVisibility(8);
        if (this.eem == null) {
            this.eem = new d(getContext());
            this.eel.setAdapter(this.eem);
        }
        this.eem.b(this.eep, this.eer, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.eel != null) {
            this.eel.scrollToPosition(0);
        }
        if (this.een != null) {
            this.eel.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZK() {
        if (this.eem != null) {
            this.eem.notifyDataSetChanged();
        }
        if (this.eeo != null) {
            this.eeo.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.eeq;
    }

    public void setCoverView(View view) {
        this.eeq = view;
    }
}
