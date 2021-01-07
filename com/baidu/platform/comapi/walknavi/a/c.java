package com.baidu.platform.comapi.walknavi.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4399a;
    public ArrayList<String> c;
    public LayoutInflater d;
    public boolean e;
    public String f;
    protected Activity g = (Activity) com.baidu.platform.comapi.walknavi.b.a().g();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f4400a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f4401b;
        public TextView c;
        public String d;
        public String e;
    }

    public void a(boolean z) {
        this.f4399a = z;
    }

    public c(ArrayList<String> arrayList) {
        if (this.g != null) {
            this.d = (LayoutInflater) this.g.getSystemService("layout_inflater");
        }
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        if (this.c == null || this.c.size() <= i || i < 0) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public void b(boolean z) {
        this.e = z;
    }

    @TargetApi(16)
    public void a(int i, View view, a aVar) {
        if (getCount() == 1) {
            aVar.f4400a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837771));
        } else if (i == 0) {
            if (this.e && this.f4399a) {
                aVar.f4400a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837773));
            } else {
                aVar.f4400a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837774));
            }
        } else if (i == getCount() - 1) {
            if (this.e && this.f4399a) {
                aVar.f4400a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837773));
            } else {
                aVar.f4400a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837772));
            }
        } else {
            aVar.f4400a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, 2130837773));
        }
    }

    public void b(String str) {
        this.f = str;
    }
}
