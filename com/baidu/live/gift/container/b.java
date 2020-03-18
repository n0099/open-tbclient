package com.baidu.live.gift.container;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private List<com.baidu.live.data.e> ajv;
    private Context mContext;
    private int mType;

    public b(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    public void t(List<com.baidu.live.data.e> list) {
        this.ajv = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ajv == null) {
            return 1;
        }
        return this.ajv.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: bz */
    public com.baidu.live.data.e getItem(int i) {
        if (this.ajv == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.ajv.get(i);
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
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_gift_num_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.text = (TextView) view.findViewById(a.g.text);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.live.data.e item = getItem(i);
        if (getItemViewType(i) == 1) {
            aVar.text.setText(a.i.ala_custom_num);
        } else if (item != null) {
            switch (this.mType) {
                case 0:
                    aVar.text.setText((item.getNumber() <= 0 ? 1 : item.getNumber()) + (item.getName() == null ? "" : item.getName()));
                    break;
                case 1:
                    aVar.text.setText(item.getName() == null ? "" : item.getName());
                    break;
            }
        } else {
            aVar.text.setText("");
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        public TextView text;

        private a() {
        }
    }
}
