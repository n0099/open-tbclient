package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.a implements b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f596a;

    public r(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void a_() {
        a(this.f596a);
        if (this.f596a) {
            this.f596a = false;
        }
    }

    @Override // com.baidu.adp.widget.ListView.a, com.baidu.adp.widget.ListView.d
    public void e() {
        this.f596a = true;
        super.e();
    }

    @Override // com.baidu.adp.widget.ListView.a, com.baidu.adp.widget.ListView.d
    public void f() {
        this.f596a = false;
        super.f();
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void b_() {
        this.f596a = false;
        super.b(true);
    }

    @Override // com.baidu.adp.widget.ListView.a
    public View a(String str, String str2, String str3) {
        View a2 = super.a(str, str2, str3);
        l();
        return a2;
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
