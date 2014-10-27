package com.baidu.tbadk.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<a> QE = new ArrayList<>();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public ArrayList<a> qZ() {
        return this.QE;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(a aVar) {
        if (this.QE != null && aVar != null) {
            this.QE.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.QE == null) {
            return 0;
        }
        return this.QE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cC */
    public a getItem(int i) {
        if (this.QE != null && i < this.QE.size()) {
            return this.QE.get(i);
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
            cVar.QF.setImageResource(this.QE.get(i).qW());
            cVar.QG.setText(this.QE.get(i).qX());
            cVar.QH.setText(i);
            return view;
        }
        return null;
    }
}
