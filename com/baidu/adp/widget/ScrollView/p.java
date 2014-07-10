package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.c implements b {
    private boolean a;

    public p(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void a_() {
        a(this.a);
        if (this.a) {
            this.a = false;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.ListView.f
    public void e() {
        this.a = true;
        super.e();
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.ListView.f
    public void f() {
        this.a = false;
        super.f();
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void b_() {
        this.a = false;
        super.b(true);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a(String str, String str2, String str3) {
        View a = super.a(str, str2, str3);
        l();
        return a;
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public View getRealView() {
        return b();
    }

    public void l() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        View realView = getRealView();
        if (realView != null) {
            View findViewById = realView.findViewById(com.baidu.adp.d.pull_content);
            if (findViewById != null && (layoutParams2 = findViewById.getLayoutParams()) != null && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
                ((LinearLayout.LayoutParams) layoutParams2).topMargin = 0;
            }
            TextView d = d();
            if (d != null && (layoutParams = d.getLayoutParams()) != null && (layoutParams instanceof LinearLayout.LayoutParams)) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 0;
            }
        }
    }
}
