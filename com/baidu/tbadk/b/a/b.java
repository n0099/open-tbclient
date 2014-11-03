package com.baidu.tbadk.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<a> QI = new ArrayList<>();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public ArrayList<a> rb() {
        return this.QI;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(a aVar) {
        if (this.QI != null && aVar != null) {
            this.QI.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.QI == null) {
            return 0;
        }
        return this.QI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cC */
    public a getItem(int i) {
        if (this.QI != null && i < this.QI.size()) {
            return this.QI.get(i);
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
            cVar.QJ.setImageResource(this.QI.get(i).qY());
            cVar.QK.setText(this.QI.get(i).qZ());
            cVar.QL.setText(i);
            return view;
        }
        return null;
    }
}
