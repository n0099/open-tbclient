package com.baidu.tbadk.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<a> Xm;
    private Context mContext;

    public Context getContext() {
        return this.mContext;
    }

    public void a(a aVar) {
        if (this.Xm != null && aVar != null) {
            this.Xm.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xm == null) {
            return 0;
        }
        return this.Xm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dg */
    public a getItem(int i) {
        if (this.Xm != null && i < this.Xm.size()) {
            return this.Xm.get(i);
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
            cVar.Xn.setImageResource(this.Xm.get(i).uS());
            cVar.Xo.setText(this.Xm.get(i).uT());
            cVar.Xp.setText(i);
            return view;
        }
        return null;
    }
}
