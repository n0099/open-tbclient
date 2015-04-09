package com.baidu.tbadk.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<a> ahx;
    private Context mContext;

    public Context getContext() {
        return this.mContext;
    }

    public void a(a aVar) {
        if (this.ahx != null && aVar != null) {
            this.ahx.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ahx == null) {
            return 0;
        }
        return this.ahx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: di */
    public a getItem(int i) {
        if (this.ahx != null && i < this.ahx.size()) {
            return this.ahx.get(i);
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
            cVar.ahy.setImageResource(this.ahx.get(i).yi());
            cVar.ahz.setText(this.ahx.get(i).yj());
            cVar.ahA.setText(i);
            return view;
        }
        return null;
    }
}
