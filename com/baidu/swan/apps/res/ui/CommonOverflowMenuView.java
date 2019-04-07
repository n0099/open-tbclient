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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.b {
    private int aGr;
    private int aGs;
    private List<ImageView> aGt;
    private List<TextView> aGu;
    private HashMap<com.baidu.swan.apps.res.widget.a.b, ImageView> aGv;
    private LinearLayout aGw;
    private SwanAppScrollView aGx;
    private SparseArray<View> aGy;
    private Object aGz;
    private View mContentView;
    private int mDividerHeight;
    private ColorStateList mItemTextColor;
    private boolean mMenuLoaded;

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.aGr = a.e.aiapps_discovery_home_menu_item_selector;
        this.aGs = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.aGt = new ArrayList();
        this.aGu = new ArrayList();
        this.aGv = new HashMap<>();
        this.mMenuLoaded = false;
        this.aGy = new SparseArray<>();
        this.aGz = new Object();
        init(context);
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGr = a.e.aiapps_discovery_home_menu_item_selector;
        this.aGs = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.aGt = new ArrayList();
        this.aGu = new ArrayList();
        this.aGv = new HashMap<>();
        this.mMenuLoaded = false;
        this.aGy = new SparseArray<>();
        this.aGz = new Object();
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(a.g.aiapps_menu_scroll_view, (ViewGroup) this, true);
        this.aGw = (LinearLayout) this.mContentView.findViewById(a.f.menu_linear);
        this.aGx = (SwanAppScrollView) this.mContentView.findViewById(a.f.menu_scrollview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        GP();
    }

    public void setItemBackground(int i) {
        this.aGr = i;
    }

    public void setItemTextColor(int i) {
        this.mItemTextColor = getResources().getColorStateList(i);
    }

    public void setItemDivider(int i, int i2) {
        this.aGs = i;
        this.mDividerHeight = i2;
    }

    public void layoutMenu(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (!this.mMenuLoaded) {
            this.aGw.removeAllViews();
            this.aGy.clear();
            Context context = getContext();
            if (this.mDividerHeight < 0) {
                this.mDividerHeight = context.getResources().getDimensionPixelSize(a.d.aiapps_pulldown_divider_height);
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
                    this.aGw.addView(a);
                    this.aGy.append(next.getItemId(), a);
                    if (i2 < list.size() - 1) {
                        ImageView imageView = new ImageView(context);
                        this.aGt.add(imageView);
                        imageView.setBackgroundColor(getResources().getColor(this.aGs));
                        this.aGw.addView(imageView, layoutParams);
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
            View inflate = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item_checkbox, (ViewGroup) this.aGw, false);
            inflate.findViewById(a.f.item).setBackgroundResource(this.aGr);
            TextView textView = (TextView) inflate.findViewById(a.f.item_title);
            this.aGu.add(textView);
            textView.setText(bVar.getTitle());
            ((CheckBox) inflate.findViewById(a.f.checkbox_id)).setChecked(bVar.isChecked());
            textView.setTextColor(this.mItemTextColor);
            inflate.setEnabled(bVar.isEnabled());
            textView.setEnabled(bVar.isEnabled());
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item, (ViewGroup) this.aGw, false);
        inflate2.findViewById(a.f.item).setBackgroundResource(this.aGr);
        ImageView imageView = (ImageView) inflate2.findViewById(a.f.left_img);
        this.aGv.put(bVar, imageView);
        imageView.setImageDrawable(bVar.getIcon());
        TextView textView2 = (TextView) inflate2.findViewById(a.f.right_txt);
        this.aGu.add(textView2);
        textView2.setText(bVar.getTitle());
        textView2.setTextColor(this.mItemTextColor);
        inflate2.setEnabled(bVar.isEnabled());
        imageView.setEnabled(bVar.isEnabled());
        textView2.setEnabled(bVar.isEnabled());
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.a.b bVar) {
        b.a IA = bVar.IA();
        if (IA != null) {
            IA.b(bVar);
        }
    }

    public void setMaxHeightRes(int i) {
        this.aGx.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMaxHeightPixel(int i) {
        this.aGx.setMaxHeight(i);
    }

    public LinearLayout getLinearContent() {
        return this.aGw;
    }

    public ColorStateList getTextColor() {
        return this.mItemTextColor;
    }

    public int getItemBgRes() {
        return this.aGr;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.u.a.CR().a(this.aGz, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonOverflowMenuView.2
        });
        GP();
    }

    private void GP() {
        this.mItemTextColor = getResources().getColorStateList(a.c.aiapps_discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(a.e.aiapps_discovery_feedback_menu_bg));
        for (ImageView imageView : this.aGt) {
            imageView.setBackgroundColor(getResources().getColor(this.aGs));
        }
        for (TextView textView : this.aGu) {
            textView.setTextColor(this.mItemTextColor);
        }
        for (Map.Entry<com.baidu.swan.apps.res.widget.a.b, ImageView> entry : this.aGv.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().getIcon());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.u.a.CR().H(this.aGz);
    }
}
