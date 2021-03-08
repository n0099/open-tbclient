package com.baidu.live.yuyingift.container;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.data.l;
import com.baidu.live.sdk.a;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private List<l> bbE;
    private Context mContext;
    private int mType;

    public b(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    public void J(List<l> list) {
        this.bbE = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbE == null) {
            return 1;
        }
        return this.bbE.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cU */
    public l getItem(int i) {
        if (this.bbE == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.bbE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == getCount() + (-1) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_gift_num_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.bbF = (TextView) view.findViewById(a.f.text);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        l item = getItem(i);
        if (getItemViewType(i) == 1) {
            aVar.bbF.setText(a.h.ala_custom_num);
        } else if (item != null) {
            switch (this.mType) {
                case 0:
                    aVar.bbF.setText((item.getNumber() <= 0 ? 1 : item.getNumber()) + (item.getName() == null ? "" : item.getName()));
                    break;
                case 1:
                    aVar.bbF.setText(item.getName() == null ? "" : item.getName());
                    break;
            }
        } else {
            aVar.bbF.setText("");
        }
        return view;
    }

    /* loaded from: classes10.dex */
    private class a {
        public TextView bbF;

        private a() {
        }
    }
}
