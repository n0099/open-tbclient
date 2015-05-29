package com.baidu.tbadk.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<a> aiy;
    private Context mContext;

    public Context getContext() {
        return this.mContext;
    }

    public void a(a aVar) {
        if (this.aiy != null && aVar != null) {
            this.aiy.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aiy == null) {
            return 0;
        }
        return this.aiy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ds */
    public a getItem(int i) {
        if (this.aiy != null && i < this.aiy.size()) {
            return this.aiy.get(i);
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
            cVar.aiz.setImageResource(this.aiy.get(i).yV());
            cVar.aiA.setText(this.aiy.get(i).yW());
            cVar.aiB.setText(i);
            return view;
        }
        return null;
    }
}
