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
    private int bcF;
    private int bcG;
    private List<ImageView> bcH;
    private List<TextView> bcI;
    private HashMap<com.baidu.swan.apps.res.widget.a.b, ImageView> bcJ;
    private LinearLayout bcK;
    private SwanAppScrollView bcL;
    private SparseArray<View> bcM;
    private Object bcN;
    private View mContentView;
    private int mDividerHeight;
    private ColorStateList mItemTextColor;
    private boolean mMenuLoaded;

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.bcF = a.e.aiapps_discovery_home_menu_item_selector;
        this.bcG = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.bcH = new ArrayList();
        this.bcI = new ArrayList();
        this.bcJ = new HashMap<>();
        this.mMenuLoaded = false;
        this.bcM = new SparseArray<>();
        this.bcN = new Object();
        init(context);
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcF = a.e.aiapps_discovery_home_menu_item_selector;
        this.bcG = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.bcH = new ArrayList();
        this.bcI = new ArrayList();
        this.bcJ = new HashMap<>();
        this.mMenuLoaded = false;
        this.bcM = new SparseArray<>();
        this.bcN = new Object();
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(a.g.aiapps_menu_scroll_view, (ViewGroup) this, true);
        this.bcK = (LinearLayout) this.mContentView.findViewById(a.f.menu_linear);
        this.bcL = (SwanAppScrollView) this.mContentView.findViewById(a.f.menu_scrollview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        updateUI();
    }

    public void setItemBackground(int i) {
        this.bcF = i;
    }

    public void setItemTextColor(int i) {
        this.mItemTextColor = getResources().getColorStateList(i);
    }

    public void setItemDivider(int i, int i2) {
        this.bcG = i;
        this.mDividerHeight = i2;
    }

    public void layoutMenu(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (!this.mMenuLoaded) {
            this.bcK.removeAllViews();
            this.bcM.clear();
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
                    this.bcK.addView(a);
                    this.bcM.append(next.getItemId(), a);
                    if (i2 < list.size() - 1) {
                        ImageView imageView = new ImageView(context);
                        this.bcH.add(imageView);
                        imageView.setBackgroundColor(getResources().getColor(this.bcG));
                        this.bcK.addView(imageView, layoutParams);
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
            View inflate = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item_checkbox, (ViewGroup) this.bcK, false);
            inflate.findViewById(a.f.item).setBackgroundResource(this.bcF);
            TextView textView = (TextView) inflate.findViewById(a.f.item_title);
            this.bcI.add(textView);
            textView.setText(bVar.getTitle());
            ((CheckBox) inflate.findViewById(a.f.checkbox_id)).setChecked(bVar.isChecked());
            textView.setTextColor(this.mItemTextColor);
            inflate.setEnabled(bVar.isEnabled());
            textView.setEnabled(bVar.isEnabled());
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item, (ViewGroup) this.bcK, false);
        inflate2.findViewById(a.f.item).setBackgroundResource(this.bcF);
        ImageView imageView = (ImageView) inflate2.findViewById(a.f.left_img);
        this.bcJ.put(bVar, imageView);
        imageView.setImageDrawable(bVar.getIcon());
        TextView textView2 = (TextView) inflate2.findViewById(a.f.right_txt);
        this.bcI.add(textView2);
        textView2.setText(bVar.getTitle());
        textView2.setTextColor(this.mItemTextColor);
        inflate2.setEnabled(bVar.isEnabled());
        imageView.setEnabled(bVar.isEnabled());
        textView2.setEnabled(bVar.isEnabled());
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.a.b bVar) {
        b.a QF = bVar.QF();
        if (QF != null) {
            QF.c(bVar);
        }
    }

    public void setMaxHeightRes(int i) {
        this.bcL.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMaxHeightPixel(int i) {
        this.bcL.setMaxHeight(i);
    }

    public LinearLayout getLinearContent() {
        return this.bcK;
    }

    public ColorStateList getTextColor() {
        return this.mItemTextColor;
    }

    public int getItemBgRes() {
        return this.bcF;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.u.a.JD().a(this.bcN, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonOverflowMenuView.2
        });
        updateUI();
    }

    private void updateUI() {
        this.mItemTextColor = getResources().getColorStateList(a.c.aiapps_discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(a.e.aiapps_discovery_feedback_menu_bg));
        for (ImageView imageView : this.bcH) {
            imageView.setBackgroundColor(getResources().getColor(this.bcG));
        }
        for (TextView textView : this.bcI) {
            textView.setTextColor(this.mItemTextColor);
        }
        for (Map.Entry<com.baidu.swan.apps.res.widget.a.b, ImageView> entry : this.bcJ.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().getIcon());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.u.a.JD().F(this.bcN);
    }
}
