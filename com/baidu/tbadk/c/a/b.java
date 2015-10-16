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
    private ArrayList<com.baidu.tbadk.c.a.a> anR;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public TextView alu;
        public HeadImageView anS;
        public TextView anT;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.c.a.a aVar) {
        if (this.anR != null && aVar != null) {
            this.anR.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anR == null) {
            return 0;
        }
        return this.anR.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dL */
    public com.baidu.tbadk.c.a.a getItem(int i) {
        if (this.anR != null && i < this.anR.size()) {
            return this.anR.get(i);
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
            aVar.anS.setImageResource(this.anR.get(i).Ae());
            aVar.alu.setText(this.anR.get(i).Af());
            aVar.anT.setText(i);
            return view;
        }
        return null;
    }
}
