package com.baidu.tbadk.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.b.a.a> anF;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public HeadImageView anG;
        public TextView anH;
        public TextView anI;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.b.a.a aVar) {
        if (this.anF != null && aVar != null) {
            this.anF.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anF == null) {
            return 0;
        }
        return this.anF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dC */
    public com.baidu.tbadk.b.a.a getItem(int i) {
        if (this.anF != null && i < this.anF.size()) {
            return this.anF.get(i);
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
            aVar.anG.setImageResource(this.anF.get(i).Ag());
            aVar.anH.setText(this.anF.get(i).Ah());
            aVar.anI.setText(i);
            return view;
        }
        return null;
    }
}
