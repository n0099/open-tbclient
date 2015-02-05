package com.baidu.tbadk.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<a> Xj;
    private Context mContext;

    public Context getContext() {
        return this.mContext;
    }

    public void a(a aVar) {
        if (this.Xj != null && aVar != null) {
            this.Xj.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xj == null) {
            return 0;
        }
        return this.Xj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dg */
    public a getItem(int i) {
        if (this.Xj != null && i < this.Xj.size()) {
            return this.Xj.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            c cVar = (c) view.getTag();
            cVar.Xk.setImageResource(this.Xj.get(i).uM());
            cVar.Xl.setText(this.Xj.get(i).uN());
            cVar.Xm.setText(i);
            return view;
        }
        return null;
    }
}
