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
/* loaded from: classes8.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.b {
    private int dxb;
    private int dxc;
    private ColorStateList dxd;
    private List<ImageView> dxe;
    private List<TextView> dxf;
    private HashMap<com.baidu.swan.apps.res.widget.a.b, ImageView> dxg;
    private LinearLayout dxh;
    private SwanAppScrollView dxi;
    private SparseArray<View> dxj;
    private Object dxk;
    private View mContentView;
    private int mDividerHeight;
    private boolean mMenuLoaded;

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.dxb = a.e.aiapps_discovery_home_menu_item_selector;
        this.dxc = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.dxe = new ArrayList();
        this.dxf = new ArrayList();
        this.dxg = new HashMap<>();
        this.mMenuLoaded = false;
        this.dxj = new SparseArray<>();
        this.dxk = new Object();
        init(context);
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxb = a.e.aiapps_discovery_home_menu_item_selector;
        this.dxc = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.dxe = new ArrayList();
        this.dxf = new ArrayList();
        this.dxg = new HashMap<>();
        this.mMenuLoaded = false;
        this.dxj = new SparseArray<>();
        this.dxk = new Object();
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(a.g.aiapps_menu_scroll_view, (ViewGroup) this, true);
        this.dxh = (LinearLayout) this.mContentView.findViewById(a.f.menu_linear);
        this.dxi = (SwanAppScrollView) this.mContentView.findViewById(a.f.menu_scrollview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        updateUI();
    }

    public void setItemBackground(int i) {
        this.dxb = i;
    }

    public void setItemTextColor(int i) {
        this.dxd = getResources().getColorStateList(i);
    }

    public void setItemDivider(int i, int i2) {
        this.dxc = i;
        this.mDividerHeight = i2;
    }

    public void layoutMenu(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (!this.mMenuLoaded) {
            this.dxh.removeAllViews();
            this.dxj.clear();
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
                    this.dxh.addView(a2);
                    this.dxj.append(next.getItemId(), a2);
                    if (i2 < list.size() - 1) {
                        ImageView imageView = new ImageView(context);
                        this.dxe.add(imageView);
                        imageView.setBackgroundColor(getResources().getColor(this.dxc));
                        this.dxh.addView(imageView, layoutParams);
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
            View inflate = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item_checkbox, (ViewGroup) this.dxh, false);
            inflate.findViewById(a.f.item).setBackgroundResource(this.dxb);
            TextView textView = (TextView) inflate.findViewById(a.f.item_title);
            this.dxf.add(textView);
            textView.setText(bVar.getTitle());
            ((CheckBox) inflate.findViewById(a.f.checkbox_id)).setChecked(bVar.isChecked());
            textView.setTextColor(this.dxd);
            inflate.setEnabled(bVar.isEnabled());
            textView.setEnabled(bVar.isEnabled());
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item, (ViewGroup) this.dxh, false);
        inflate2.findViewById(a.f.item).setBackgroundResource(this.dxb);
        ImageView imageView = (ImageView) inflate2.findViewById(a.f.left_img);
        this.dxg.put(bVar, imageView);
        imageView.setImageDrawable(bVar.getIcon());
        TextView textView2 = (TextView) inflate2.findViewById(a.f.right_txt);
        this.dxf.add(textView2);
        textView2.setText(bVar.getTitle());
        textView2.setTextColor(this.dxd);
        inflate2.setEnabled(bVar.isEnabled());
        imageView.setEnabled(bVar.isEnabled());
        textView2.setEnabled(bVar.isEnabled());
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.a.b bVar) {
        b.a aIm = bVar.aIm();
        if (aIm != null) {
            aIm.b(bVar);
        }
    }

    public void setMaxHeightRes(int i) {
        this.dxi.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMaxHeightPixel(int i) {
        this.dxi.setMaxHeight(i);
    }

    public LinearLayout getLinearContent() {
        return this.dxh;
    }

    public ColorStateList getTextColor() {
        return this.dxd;
    }

    public int getItemBgRes() {
        return this.dxb;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.t.a.axv().a(this.dxk, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonOverflowMenuView.2
        });
        updateUI();
    }

    private void updateUI() {
        this.dxd = getResources().getColorStateList(a.c.aiapps_discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(a.e.aiapps_discovery_feedback_menu_bg));
        for (ImageView imageView : this.dxe) {
            imageView.setBackgroundColor(getResources().getColor(this.dxc));
        }
        for (TextView textView : this.dxf) {
            textView.setTextColor(this.dxd);
        }
        for (Map.Entry<com.baidu.swan.apps.res.widget.a.b, ImageView> entry : this.dxg.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().getIcon());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.t.a.axv().Q(this.dxk);
    }
}
