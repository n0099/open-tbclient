package com.baidu.tbadk.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<a> WH;
    private Context mContext;

    public Context getContext() {
        return this.mContext;
    }

    public void a(a aVar) {
        if (this.WH != null && aVar != null) {
            this.WH.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WH == null) {
            return 0;
        }
        return this.WH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cZ */
    public a getItem(int i) {
        if (this.WH != null && i < this.WH.size()) {
            return this.WH.get(i);
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
            cVar.WI.setImageResource(this.WH.get(i).uB());
            cVar.title.setText(this.WH.get(i).uC());
            cVar.WJ.setText(i);
            return view;
        }
        return null;
    }
}
