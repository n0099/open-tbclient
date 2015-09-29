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
    private ArrayList<com.baidu.tbadk.c.a.a> anQ;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public TextView alt;
        public HeadImageView anR;
        public TextView anS;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.c.a.a aVar) {
        if (this.anQ != null && aVar != null) {
            this.anQ.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anQ == null) {
            return 0;
        }
        return this.anQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dL */
    public com.baidu.tbadk.c.a.a getItem(int i) {
        if (this.anQ != null && i < this.anQ.size()) {
            return this.anQ.get(i);
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
            aVar.anR.setImageResource(this.anQ.get(i).Ae());
            aVar.alt.setText(this.anQ.get(i).Af());
            aVar.anS.setText(i);
            return view;
        }
        return null;
    }
}
