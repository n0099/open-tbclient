package com.baidu.platform.comapi.walknavi.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.a.c;
import com.baidu.platform.comapi.wnplatform.p.e;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public int f4394a;

    /* renamed from: b  reason: collision with root package name */
    public String f4395b;
    private String h;

    public b(ArrayList<String> arrayList) {
        super(arrayList);
        this.f4394a = -1;
    }

    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private int f4397b;

        public a(int i) {
            this.f4397b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (view != null && (tag = view.getTag()) != null && (tag instanceof c.a) && ((c.a) tag) != null) {
                String str = "";
                if (b.this.getItem(this.f4397b) != null) {
                    str = b.this.getItem(this.f4397b);
                }
                b.this.f4395b = str;
                b.this.h = "";
                b.this.f4394a = this.f4397b;
                e.a(str, b.this.f, true);
                b.this.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c.a aVar;
        String a2 = getItem(i);
        if (a2 == null) {
            return null;
        }
        if (view == null) {
            view = com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.array.Mask_X001, null);
            view.setClickable(false);
            c.a aVar2 = new c.a();
            aVar2.c = (TextView) view.findViewById(R.dimen.L_X05);
            aVar2.f4399a = view.findViewById(R.dimen.L_X04);
            aVar2.f4400b = (ImageView) view.findViewById(R.dimen.L_X06);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (c.a) view.getTag();
        }
        a(i, view, aVar);
        aVar.d = null;
        aVar.e = null;
        aVar.f4399a.setTag(aVar);
        aVar.f4399a.setOnClickListener(new a(i));
        aVar.c.setText(a2);
        a(a2, aVar, i);
        return view;
    }

    private void a(String str, c.a aVar, int i) {
        a(aVar);
        b(str, aVar, i);
    }

    public void a(c.a aVar) {
        if (!this.e) {
            aVar.c.setTextSize(1, 9.0f);
        }
    }

    public void a(String str) {
        this.h = str;
    }

    @TargetApi(16)
    private void b(String str, c.a aVar, int i) {
        if (this.f4394a == i) {
            if (getCount() == 1) {
                aVar.f4399a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837780));
            } else if (i == 0) {
                if (this.e) {
                    aVar.f4399a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837786));
                } else {
                    aVar.f4399a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837788));
                }
            } else if (i == getCount() - 1) {
                if (this.e) {
                    aVar.f4399a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837786));
                } else {
                    aVar.f4399a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837782));
                }
            } else {
                aVar.f4399a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837786));
            }
            aVar.c.setTextColor(-1);
            this.f4395b = getItem(this.f4394a);
            return;
        }
        aVar.c.setTextColor(-13488081);
    }

    public int a() {
        String str = this.h;
        for (int i = 0; i < getCount(); i++) {
            if (TextUtils.equals(str, getItem(i))) {
                this.f4394a = i;
            }
        }
        return this.f4394a;
    }
}
