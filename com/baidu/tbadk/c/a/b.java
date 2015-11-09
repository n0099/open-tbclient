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
    private ArrayList<com.baidu.tbadk.c.a.a> anW;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public TextView alz;
        public HeadImageView anX;
        public TextView anY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.c.a.a aVar) {
        if (this.anW != null && aVar != null) {
            this.anW.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anW == null) {
            return 0;
        }
        return this.anW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dL */
    public com.baidu.tbadk.c.a.a getItem(int i) {
        if (this.anW != null && i < this.anW.size()) {
            return this.anW.get(i);
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
            aVar.anX.setImageResource(this.anW.get(i).Ag());
            aVar.alz.setText(this.anW.get(i).Ah());
            aVar.anY.setText(i);
            return view;
        }
        return null;
    }
}
