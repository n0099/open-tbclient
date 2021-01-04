package com.baidu.swan.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.menu.f;
import java.util.List;
/* loaded from: classes5.dex */
public class MainMenuView extends BaseMenuView {
    private View dDI;
    private RecyclerView eur;
    private MenuContentAdapter eus;
    private RecyclerView eut;
    private MenuContentAdapter euu;
    private List<List<h>> euv;
    private View euw;
    private boolean eux;
    private LinearLayout mContentView;
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
        this.eur = new RecyclerView(context, attributeSet, i);
        this.eur.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eur.setPadding(0, (int) this.mContext.getResources().getDimension(f.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.eur, layoutParams);
        this.dDI = new View(context);
        this.dDI.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.dDI, layoutParams2);
        this.eut = new RecyclerView(context, attributeSet, i);
        this.eut.setVisibility(8);
        this.eut.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.eut, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aFO() {
        return this.euv != null && this.euv.size() > 1;
    }

    public void a(List<List<h>> list, View view, boolean z, int i) {
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

    private void a(List<List<h>> list, boolean z, int i) {
        this.euv = list;
        this.eux = z;
        if (z && list.size() > 1) {
            nd(i);
        } else {
            ne(i);
        }
    }

    private void nd(int i) {
        this.dDI.setVisibility(0);
        this.eut.setVisibility(0);
        if (this.eus == null) {
            this.eus = new MenuContentAdapter(getContext());
            this.eur.setAdapter(this.eus);
        }
        this.eus.b(this.euv.subList(0, 1), this.eux, i);
        if (this.euu == null) {
            this.euu = new MenuContentAdapter(getContext());
            this.eut.setAdapter(this.euu);
        }
        this.euu.b(this.euv.subList(1, 2), this.eux, i);
    }

    private void ne(int i) {
        this.dDI.setVisibility(8);
        this.eut.setVisibility(8);
        if (this.eus == null) {
            this.eus = new MenuContentAdapter(getContext());
            this.eur.setAdapter(this.eus);
        }
        this.eus.b(this.euv, this.eux, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.eur != null) {
            this.eur.scrollToPosition(0);
        }
        if (this.eut != null) {
            this.eur.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfi() {
        if (this.eus != null) {
            this.eus.notifyDataSetChanged();
        }
        if (this.euu != null) {
            this.euu.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.euw;
    }

    public void setCoverView(View view) {
        this.euw = view;
    }
}
