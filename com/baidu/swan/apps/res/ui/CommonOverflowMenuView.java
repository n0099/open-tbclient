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
/* loaded from: classes9.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.b {
    private int dvA;
    private int dvB;
    private ColorStateList dvC;
    private List<ImageView> dvD;
    private List<TextView> dvE;
    private HashMap<com.baidu.swan.apps.res.widget.a.b, ImageView> dvF;
    private LinearLayout dvG;
    private SwanAppScrollView dvH;
    private SparseArray<View> dvI;
    private Object dvJ;
    private View mContentView;
    private int mDividerHeight;
    private boolean mMenuLoaded;

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.dvA = a.e.aiapps_discovery_home_menu_item_selector;
        this.dvB = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.dvD = new ArrayList();
        this.dvE = new ArrayList();
        this.dvF = new HashMap<>();
        this.mMenuLoaded = false;
        this.dvI = new SparseArray<>();
        this.dvJ = new Object();
        init(context);
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvA = a.e.aiapps_discovery_home_menu_item_selector;
        this.dvB = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.dvD = new ArrayList();
        this.dvE = new ArrayList();
        this.dvF = new HashMap<>();
        this.mMenuLoaded = false;
        this.dvI = new SparseArray<>();
        this.dvJ = new Object();
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(a.g.aiapps_menu_scroll_view, (ViewGroup) this, true);
        this.dvG = (LinearLayout) this.mContentView.findViewById(a.f.menu_linear);
        this.dvH = (SwanAppScrollView) this.mContentView.findViewById(a.f.menu_scrollview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        updateUI();
    }

    public void setItemBackground(int i) {
        this.dvA = i;
    }

    public void setItemTextColor(int i) {
        this.dvC = getResources().getColorStateList(i);
    }

    public void setItemDivider(int i, int i2) {
        this.dvB = i;
        this.mDividerHeight = i2;
    }

    public void layoutMenu(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (!this.mMenuLoaded) {
            this.dvG.removeAllViews();
            this.dvI.clear();
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
                    View a2 = a(context, next);
                    if (next.isEnabled()) {
                        a2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.CommonOverflowMenuView.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                CommonOverflowMenuView.this.a(next);
                            }
                        });
                    }
                    this.dvG.addView(a2);
                    this.dvI.append(next.getItemId(), a2);
                    if (i2 < list.size() - 1) {
                        ImageView imageView = new ImageView(context);
                        this.dvD.add(imageView);
                        imageView.setBackgroundColor(getResources().getColor(this.dvB));
                        this.dvG.addView(imageView, layoutParams);
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
            View inflate = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item_checkbox, (ViewGroup) this.dvG, false);
            inflate.findViewById(a.f.item).setBackgroundResource(this.dvA);
            TextView textView = (TextView) inflate.findViewById(a.f.item_title);
            this.dvE.add(textView);
            textView.setText(bVar.getTitle());
            ((CheckBox) inflate.findViewById(a.f.checkbox_id)).setChecked(bVar.isChecked());
            textView.setTextColor(this.dvC);
            inflate.setEnabled(bVar.isEnabled());
            textView.setEnabled(bVar.isEnabled());
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item, (ViewGroup) this.dvG, false);
        inflate2.findViewById(a.f.item).setBackgroundResource(this.dvA);
        ImageView imageView = (ImageView) inflate2.findViewById(a.f.left_img);
        this.dvF.put(bVar, imageView);
        imageView.setImageDrawable(bVar.getIcon());
        TextView textView2 = (TextView) inflate2.findViewById(a.f.right_txt);
        this.dvE.add(textView2);
        textView2.setText(bVar.getTitle());
        textView2.setTextColor(this.dvC);
        inflate2.setEnabled(bVar.isEnabled());
        imageView.setEnabled(bVar.isEnabled());
        textView2.setEnabled(bVar.isEnabled());
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.a.b bVar) {
        b.a aIj = bVar.aIj();
        if (aIj != null) {
            aIj.b(bVar);
        }
    }

    public void setMaxHeightRes(int i) {
        this.dvH.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMaxHeightPixel(int i) {
        this.dvH.setMaxHeight(i);
    }

    public LinearLayout getLinearContent() {
        return this.dvG;
    }

    public ColorStateList getTextColor() {
        return this.dvC;
    }

    public int getItemBgRes() {
        return this.dvA;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.t.a.axs().a(this.dvJ, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonOverflowMenuView.2
        });
        updateUI();
    }

    private void updateUI() {
        this.dvC = getResources().getColorStateList(a.c.aiapps_discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(a.e.aiapps_discovery_feedback_menu_bg));
        for (ImageView imageView : this.dvD) {
            imageView.setBackgroundColor(getResources().getColor(this.dvB));
        }
        for (TextView textView : this.dvE) {
            textView.setTextColor(this.dvC);
        }
        for (Map.Entry<com.baidu.swan.apps.res.widget.a.b, ImageView> entry : this.dvF.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().getIcon());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.t.a.axs().O(this.dvJ);
    }
}
