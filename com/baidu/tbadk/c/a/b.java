package com.baidu.tbadk.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.c.a.a> apr;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public TextView amV;
        public HeadImageView aps;
        public TextView apt;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.c.a.a aVar) {
        if (this.apr != null && aVar != null) {
            this.apr.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.apr == null) {
            return 0;
        }
        return this.apr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dK */
    public com.baidu.tbadk.c.a.a getItem(int i) {
        if (this.apr != null && i < this.apr.size()) {
            return this.apr.get(i);
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
            a aVar = (a) view.getTag();
            aVar.aps.setImageResource(this.apr.get(i).At());
            aVar.amV.setText(this.apr.get(i).Au());
            aVar.apt.setText(i);
            return view;
        }
        return null;
    }
}
