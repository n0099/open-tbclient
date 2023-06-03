package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.tieba.R;
import com.baidu.tieba.fv2;
import com.baidu.tieba.ib3;
import com.baidu.tieba.jb3;
import com.baidu.tieba.mh3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class CommonOverflowMenuView extends LinearLayout implements ib3.g {
    public int a;
    public int b;
    public ColorStateList c;
    public List<ImageView> d;
    public List<TextView> e;
    public HashMap<jb3, ImageView> f;
    public View g;
    public LinearLayout h;
    public SwanAppScrollView i;
    public Object j;

    /* loaded from: classes4.dex */
    public class a implements mh3 {
        public a() {
        }
    }

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.a = R.drawable.obfuscated_res_0x7f080166;
        this.b = R.color.obfuscated_res_0x7f060432;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new HashMap<>();
        new SparseArray();
        this.j = new Object();
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00c1, (ViewGroup) this, true);
        this.g = inflate;
        this.h = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0916fa);
        this.i = (SwanAppScrollView) this.g.findViewById(R.id.obfuscated_res_0x7f0916fd);
        setFocusable(true);
        setFocusableInTouchMode(true);
        b();
    }

    public void setItemBackground(int i) {
        this.a = i;
    }

    public void setItemTextColor(@ColorRes int i) {
        this.c = AppCompatResources.getColorStateList(getContext(), i);
    }

    public void setMaxHeightPixel(int i) {
        this.i.setMaxHeight(i);
    }

    public void setMaxHeightRes(int i) {
        this.i.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = R.drawable.obfuscated_res_0x7f080166;
        this.b = R.color.obfuscated_res_0x7f060432;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new HashMap<>();
        new SparseArray();
        this.j = new Object();
        a(context);
    }

    public void setItemDivider(int i, int i2) {
        this.b = i;
    }

    public final void b() {
        this.c = AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060414);
        setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080165));
        for (ImageView imageView : this.d) {
            imageView.setBackgroundColor(getResources().getColor(this.b));
        }
        for (TextView textView : this.e) {
            textView.setTextColor(this.c);
        }
        for (Map.Entry<jb3, ImageView> entry : this.f.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().b());
        }
    }

    public int getItemBgRes() {
        return this.a;
    }

    public LinearLayout getLinearContent() {
        return this.h;
    }

    public ColorStateList getTextColor() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fv2.M().f(this.j, new a());
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fv2.M().g(this.j);
    }
}
