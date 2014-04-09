package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class NavigationBar extends RelativeLayout {
    public TextView a;
    private boolean b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private TextView f;
    private Activity g;
    private LayoutInflater h;
    private int i;
    private final View.OnClickListener j;

    /* loaded from: classes.dex */
    public enum ControlAlign {
        HORIZONTAL_LEFT,
        HORIZONTAL_CENTER,
        HORIZONTAL_RIGHT;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ControlAlign[] valuesCustom() {
            ControlAlign[] valuesCustom = values();
            int length = valuesCustom.length;
            ControlAlign[] controlAlignArr = new ControlAlign[length];
            System.arraycopy(valuesCustom, 0, controlAlignArr, 0, length);
            return controlAlignArr;
        }
    }

    /* loaded from: classes.dex */
    public enum ControlType {
        BACK_BUTTON;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ControlType[] valuesCustom() {
            ControlType[] valuesCustom = values();
            int length = valuesCustom.length;
            ControlType[] controlTypeArr = new ControlType[length];
            System.arraycopy(valuesCustom, 0, controlTypeArr, 0, length);
            return controlTypeArr;
        }
    }

    public NavigationBar(Context context) {
        super(context);
        this.b = true;
        this.i = 0;
        this.j = new j(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
        this.i = 0;
        this.j = new j(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = true;
        this.i = 0;
        this.j = new j(this);
        a(context);
    }

    private void a(Context context) {
        this.g = (Activity) context;
        this.h = (LayoutInflater) context.getSystemService("layout_inflater");
        View inflate = this.h.inflate(com.baidu.tbadk.k.widget_navigation_bar, (ViewGroup) this, true);
        this.c = (LinearLayout) inflate.findViewById(com.baidu.tbadk.j.leftBox);
        this.d = (LinearLayout) inflate.findViewById(com.baidu.tbadk.j.centerBox);
        this.e = (LinearLayout) inflate.findViewById(com.baidu.tbadk.j.rightBox);
        this.f = (TextView) inflate.findViewById(com.baidu.tbadk.j.navBottomLine);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setGravity(48);
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        setPadding(com.baidu.adp.lib.util.i.a(this.g, getResources().getDimension(com.baidu.tbadk.h.navi_padding_left)), com.baidu.adp.lib.util.i.a(this.g, getResources().getDimension(com.baidu.tbadk.h.navi_padding_top)), com.baidu.adp.lib.util.i.a(this.g, getResources().getDimension(com.baidu.tbadk.h.navi_padding_right)), com.baidu.adp.lib.util.i.a(this.g, getResources().getDimension(com.baidu.tbadk.h.navi_padding_bottom)));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.i = View.MeasureSpec.getSize(i);
        int measuredWidth = this.c.getMeasuredWidth() + getPaddingLeft();
        this.d.measure(((this.i - measuredWidth) - (this.e.getMeasuredWidth() + getPaddingRight())) + 1073741824, this.d.getMeasuredHeight() + 1073741824);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.d.layout(this.c.getMeasuredWidth() + getPaddingLeft(), this.d.getTop(), this.i - (this.e.getMeasuredWidth() + getPaddingRight()), this.d.getBottom());
    }

    public final TextView a(String str) {
        if (this.a == null) {
            this.a = (TextView) c(com.baidu.tbadk.k.widget_nb_item_title);
            a(ControlAlign.HORIZONTAL_CENTER).addView(this.a);
        }
        this.a.setText(str);
        return this.a;
    }

    public final TextView a(int i) {
        return a(this.g.getString(i));
    }

    public final View a(int i, View.OnClickListener onClickListener) {
        return a(ControlAlign.HORIZONTAL_CENTER, c(i), (View.OnClickListener) null);
    }

    public final View a(ControlAlign controlAlign, ControlType controlType) {
        return a(controlAlign, controlType, this.j);
    }

    public final View a(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        LinearLayout linearLayout = null;
        if (controlType == ControlType.BACK_BUTTON && (linearLayout = (LinearLayout) findViewById(com.baidu.tbadk.j.navigationBarGoBack)) == null && (linearLayout = (LinearLayout) c(com.baidu.tbadk.k.widget_nb_item_back)) != null) {
            a(controlAlign).addView(linearLayout);
            if (onClickListener != null) {
                linearLayout.setOnClickListener(onClickListener);
            }
        }
        return linearLayout;
    }

    public final TextView a(ControlAlign controlAlign, String str) {
        return a(controlAlign, str, (View.OnClickListener) null);
    }

    public final TextView a(ControlAlign controlAlign, View.OnClickListener onClickListener) {
        TextView textView = (TextView) c(com.baidu.tbadk.k.widget_nb_item_create_group);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(com.baidu.tbadk.h.navi_btn_margin_right);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            textView.setLayoutParams(layoutParams);
        }
        a(controlAlign).addView(textView);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
    }

    public void setSystemClickable(boolean z) {
        this.b = z;
    }

    public final TextView a(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) c(com.baidu.tbadk.k.widget_nb_item_textbtn);
        textView.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(com.baidu.tbadk.h.navi_btn_margin_right);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            textView.setLayoutParams(layoutParams);
        } else if (ControlAlign.HORIZONTAL_LEFT == controlAlign) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension2 = (int) getResources().getDimension(com.baidu.tbadk.h.navi_btn_margin_right);
            layoutParams2.setMargins(dimension2, dimension2, 0, dimension2);
            textView.setLayoutParams(layoutParams2);
        }
        a(controlAlign).addView(textView);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
    }

    public final View a(ControlAlign controlAlign, View view, View.OnClickListener onClickListener) {
        a(controlAlign).addView(view);
        if (onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
        if (controlAlign == ControlAlign.HORIZONTAL_CENTER) {
        }
        return view;
    }

    public final View a(ControlAlign controlAlign, int i, View.OnClickListener onClickListener) {
        return a(controlAlign, c(i), onClickListener);
    }

    private ViewGroup a(ControlAlign controlAlign) {
        if (controlAlign == ControlAlign.HORIZONTAL_LEFT) {
            return this.c;
        }
        if (controlAlign == ControlAlign.HORIZONTAL_RIGHT) {
            return this.e;
        }
        return this.d;
    }

    private View c(int i) {
        return this.h.inflate(i, (ViewGroup) this, false);
    }

    public void b(int i) {
        if (i == 1) {
            setBackgroundResource(com.baidu.tbadk.i.bg_bar_1);
            this.f.setBackgroundColor(getResources().getColor(com.baidu.tbadk.g.navi_line_1));
        } else {
            setBackgroundResource(com.baidu.tbadk.i.bg_bar);
            this.f.setBackgroundColor(getResources().getColor(com.baidu.tbadk.g.navi_line));
        }
        a();
        if (this.g instanceof com.baidu.tbadk.a) {
            com.baidu.tbadk.a aVar = (com.baidu.tbadk.a) this.g;
            aVar.getLayoutMode().a(i == 1);
            aVar.getLayoutMode().a(this);
        } else if (this.g instanceof com.baidu.tbadk.core.e) {
            com.baidu.tbadk.core.e eVar = (com.baidu.tbadk.core.e) this.g;
            eVar.b().a(i == 1);
            eVar.b().a(this);
        }
    }
}
