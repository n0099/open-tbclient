package com.baidu.android.pushservice.richmedia;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaListActivity f739a;
    private Context b;
    private ArrayList c;

    public i(MediaListActivity mediaListActivity, Context context, ArrayList arrayList) {
        this.f739a = mediaListActivity;
        this.b = context;
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        LayoutInflater from = LayoutInflater.from(this.b.getApplicationContext());
        i2 = this.f739a.e;
        View inflate = from.inflate(i2, (ViewGroup) null);
        inflate.setBackgroundColor(-7829368);
        i3 = this.f739a.g;
        i4 = this.f739a.h;
        i5 = this.f739a.i;
        i6 = this.f739a.j;
        ((TextView) inflate.findViewById(i4)).setText(((HashMap) this.c.get(i)).get("title").toString());
        ((TextView) inflate.findViewById(i5)).setText(((HashMap) this.c.get(i)).get("fromtext").toString());
        ((TextView) inflate.findViewById(i6)).setText(((HashMap) this.c.get(i)).get("timetext").toString());
        ((ImageView) inflate.findViewById(i3)).setImageDrawable((Drawable) ((HashMap) this.c.get(i)).get("img"));
        return inflate;
    }
}
