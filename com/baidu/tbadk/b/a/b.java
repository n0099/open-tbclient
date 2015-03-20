package com.baidu.tbadk.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<a> ahp;
    private Context mContext;

    public Context getContext() {
        return this.mContext;
    }

    public void a(a aVar) {
        if (this.ahp != null && aVar != null) {
            this.ahp.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ahp == null) {
            return 0;
        }
        return this.ahp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: di */
    public a getItem(int i) {
        if (this.ahp != null && i < this.ahp.size()) {
            return this.ahp.get(i);
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
            cVar.ahq.setImageResource(this.ahp.get(i).yc());
            cVar.ahr.setText(this.ahp.get(i).yd());
            cVar.ahs.setText(i);
            return view;
        }
        return null;
    }
}
