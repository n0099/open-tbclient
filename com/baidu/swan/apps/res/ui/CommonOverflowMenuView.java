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
/* loaded from: classes10.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.b {
    private SwanAppScrollView bGD;
    private HashMap<com.baidu.swan.apps.res.widget.a.b, ImageView> mBdMenuItemIconMap;
    private List<TextView> mBdMenuItemTexList;
    private SparseArray<View> mChildView;
    private View mContentView;
    private int mDividerHeight;
    private List<ImageView> mDividerList;
    private int mDividerRes;
    private int mItemBgRes;
    private ColorStateList mItemTextColor;
    private LinearLayout mLinearContent;
    private boolean mMenuLoaded;
    private Object mNightModeRegister;

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.mItemBgRes = a.e.aiapps_discovery_home_menu_item_selector;
        this.mDividerRes = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.mDividerList = new ArrayList();
        this.mBdMenuItemTexList = new ArrayList();
        this.mBdMenuItemIconMap = new HashMap<>();
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        this.mNightModeRegister = new Object();
        init(context);
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemBgRes = a.e.aiapps_discovery_home_menu_item_selector;
        this.mDividerRes = a.c.aiapps_home_menu_separator_color;
        this.mDividerHeight = 1;
        this.mDividerList = new ArrayList();
        this.mBdMenuItemTexList = new ArrayList();
        this.mBdMenuItemIconMap = new HashMap<>();
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        this.mNightModeRegister = new Object();
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(a.g.aiapps_menu_scroll_view, (ViewGroup) this, true);
        this.mLinearContent = (LinearLayout) this.mContentView.findViewById(a.f.menu_linear);
        this.bGD = (SwanAppScrollView) this.mContentView.findViewById(a.f.menu_scrollview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        updateUI();
    }

    public void setItemBackground(int i) {
        this.mItemBgRes = i;
    }

    public void setItemTextColor(int i) {
        this.mItemTextColor = getResources().getColorStateList(i);
    }

    public void setItemDivider(int i, int i2) {
        this.mDividerRes = i;
        this.mDividerHeight = i2;
    }

    public void layoutMenu(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (!this.mMenuLoaded) {
            this.mLinearContent.removeAllViews();
            this.mChildView.clear();
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
                    this.mLinearContent.addView(a);
                    this.mChildView.append(next.getItemId(), a);
                    if (i2 < list.size() - 1) {
                        ImageView imageView = new ImageView(context);
                        this.mDividerList.add(imageView);
                        imageView.setBackgroundColor(getResources().getColor(this.mDividerRes));
                        this.mLinearContent.addView(imageView, layoutParams);
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
            View inflate = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item_checkbox, (ViewGroup) this.mLinearContent, false);
            inflate.findViewById(a.f.item).setBackgroundResource(this.mItemBgRes);
            TextView textView = (TextView) inflate.findViewById(a.f.item_title);
            this.mBdMenuItemTexList.add(textView);
            textView.setText(bVar.getTitle());
            ((CheckBox) inflate.findViewById(a.f.checkbox_id)).setChecked(bVar.isChecked());
            textView.setTextColor(this.mItemTextColor);
            inflate.setEnabled(bVar.isEnabled());
            textView.setEnabled(bVar.isEnabled());
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(a.g.aiapps_pulldown_item, (ViewGroup) this.mLinearContent, false);
        inflate2.findViewById(a.f.item).setBackgroundResource(this.mItemBgRes);
        ImageView imageView = (ImageView) inflate2.findViewById(a.f.left_img);
        this.mBdMenuItemIconMap.put(bVar, imageView);
        imageView.setImageDrawable(bVar.getIcon());
        TextView textView2 = (TextView) inflate2.findViewById(a.f.right_txt);
        this.mBdMenuItemTexList.add(textView2);
        textView2.setText(bVar.getTitle());
        textView2.setTextColor(this.mItemTextColor);
        inflate2.setEnabled(bVar.isEnabled());
        imageView.setEnabled(bVar.isEnabled());
        textView2.setEnabled(bVar.isEnabled());
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.a.b bVar) {
        b.a aaf = bVar.aaf();
        if (aaf != null) {
            aaf.c(bVar);
        }
    }

    public void setMaxHeightRes(int i) {
        this.bGD.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMaxHeightPixel(int i) {
        this.bGD.setMaxHeight(i);
    }

    public LinearLayout getLinearContent() {
        return this.mLinearContent;
    }

    public ColorStateList getTextColor() {
        return this.mItemTextColor;
    }

    public int getItemBgRes() {
        return this.mItemBgRes;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.w.a.Sc().a(this.mNightModeRegister, new com.baidu.swan.apps.am.a() { // from class: com.baidu.swan.apps.res.ui.CommonOverflowMenuView.2
        });
        updateUI();
    }

    private void updateUI() {
        this.mItemTextColor = getResources().getColorStateList(a.c.aiapps_discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(a.e.aiapps_discovery_feedback_menu_bg));
        for (ImageView imageView : this.mDividerList) {
            imageView.setBackgroundColor(getResources().getColor(this.mDividerRes));
        }
        for (TextView textView : this.mBdMenuItemTexList) {
            textView.setTextColor(this.mItemTextColor);
        }
        for (Map.Entry<com.baidu.swan.apps.res.widget.a.b, ImageView> entry : this.mBdMenuItemIconMap.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().getIcon());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.w.a.Sc().unsubscribeNightModeChangedEvent(this.mNightModeRegister);
    }
}
