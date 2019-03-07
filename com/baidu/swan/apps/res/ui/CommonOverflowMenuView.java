package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.b {
    private int aGn;
    private int aGo;
    private List<ImageView> aGp;
    private List<TextView> aGq;
    private HashMap<com.baidu.swan.apps.res.widget.a.b, ImageView> aGr;
    private LinearLayout aGs;
    private SwanAppScrollView aGt;
    private SparseArray<View> aGu;
    private Object aGv;
    private View mContentView;
    private int mDividerHeight;
    private ColorStateList mItemTextColor;
    private boolean mMenuLoaded;

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.aGn = b.e.aiapps_discovery_home_menu_item_selector;
        this.aGo = b.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.aGp = new ArrayList();
        this.aGq = new ArrayList();
        this.aGr = new HashMap<>();
        this.mMenuLoaded = false;
        this.aGu = new SparseArray<>();
        this.aGv = new Object();
        init(context);
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGn = b.e.aiapps_discovery_home_menu_item_selector;
        this.aGo = b.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.aGp = new ArrayList();
        this.aGq = new ArrayList();
        this.aGr = new HashMap<>();
        this.mMenuLoaded = false;
        this.aGu = new SparseArray<>();
        this.aGv = new Object();
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(b.g.aiapps_menu_scroll_view, (ViewGroup) this, true);
        this.aGs = (LinearLayout) this.mContentView.findViewById(b.f.menu_linear);
        this.aGt = (SwanAppScrollView) this.mContentView.findViewById(b.f.menu_scrollview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        GR();
    }

    public void setItemBackground(int i) {
        this.aGn = i;
    }

    public void setItemTextColor(int i) {
        this.mItemTextColor = getResources().getColorStateList(i);
    }

    public void setItemDivider(int i, int i2) {
        this.aGo = i;
        this.mDividerHeight = i2;
    }

    public void layoutMenu(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (!this.mMenuLoaded) {
            this.aGs.removeAllViews();
            this.aGu.clear();
            Context context = getContext();
            if (this.mDividerHeight < 0) {
                this.mDividerHeight = context.getResources().getDimensionPixelSize(b.d.aiapps_pulldown_divider_height);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mDividerHeight);
            int i = 0;
            Iterator<com.baidu.swan.apps.res.widget.a.b> it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    final com.baidu.swan.apps.res.widget.a.b next = it.next();
                    View a = a(context, next);
                    if (next.isEnabled()) {
                        a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.CommonOverflowMenuView.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                CommonOverflowMenuView.this.a(next);
                            }
                        });
                    }
                    this.aGs.addView(a);
                    this.aGu.append(next.getItemId(), a);
                    if (i2 < list.size() - 1) {
                        ImageView imageView = new ImageView(context);
                        this.aGp.add(imageView);
                        imageView.setBackgroundColor(getResources().getColor(this.aGo));
                        this.aGs.addView(imageView, layoutParams);
                    }
                    i = i2 + 1;
                } else {
                    this.mMenuLoaded = true;
                    return;
                }
            }
        }
    }

    protected View a(Context context, com.baidu.swan.apps.res.widget.a.b bVar) {
        if (bVar instanceof com.baidu.swan.apps.res.widget.a.c) {
            View inflate = LayoutInflater.from(context).inflate(b.g.aiapps_pulldown_item_checkbox, (ViewGroup) this.aGs, false);
            inflate.findViewById(b.f.item).setBackgroundResource(this.aGn);
            TextView textView = (TextView) inflate.findViewById(b.f.item_title);
            this.aGq.add(textView);
            textView.setText(bVar.getTitle());
            ((CheckBox) inflate.findViewById(b.f.checkbox_id)).setChecked(bVar.isChecked());
            textView.setTextColor(this.mItemTextColor);
            inflate.setEnabled(bVar.isEnabled());
            textView.setEnabled(bVar.isEnabled());
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(b.g.aiapps_pulldown_item, (ViewGroup) this.aGs, false);
        inflate2.findViewById(b.f.item).setBackgroundResource(this.aGn);
        ImageView imageView = (ImageView) inflate2.findViewById(b.f.left_img);
        this.aGr.put(bVar, imageView);
        imageView.setImageDrawable(bVar.getIcon());
        TextView textView2 = (TextView) inflate2.findViewById(b.f.right_txt);
        this.aGq.add(textView2);
        textView2.setText(bVar.getTitle());
        textView2.setTextColor(this.mItemTextColor);
        inflate2.setEnabled(bVar.isEnabled());
        imageView.setEnabled(bVar.isEnabled());
        textView2.setEnabled(bVar.isEnabled());
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.a.b bVar) {
        b.a IC = bVar.IC();
        if (IC != null) {
            IC.b(bVar);
        }
    }

    public void setMaxHeightRes(int i) {
        this.aGt.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMaxHeightPixel(int i) {
        this.aGt.setMaxHeight(i);
    }

    public LinearLayout getLinearContent() {
        return this.aGs;
    }

    public ColorStateList getTextColor() {
        return this.mItemTextColor;
    }

    public int getItemBgRes() {
        return this.aGn;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.u.a.CT().a(this.aGv, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonOverflowMenuView.2
        });
        GR();
    }

    private void GR() {
        this.mItemTextColor = getResources().getColorStateList(b.c.aiapps_discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(b.e.aiapps_discovery_feedback_menu_bg));
        for (ImageView imageView : this.aGp) {
            imageView.setBackgroundColor(getResources().getColor(this.aGo));
        }
        for (TextView textView : this.aGq) {
            textView.setTextColor(this.mItemTextColor);
        }
        for (Map.Entry<com.baidu.swan.apps.res.widget.a.b, ImageView> entry : this.aGr.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().getIcon());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.u.a.CT().H(this.aGv);
    }
}
