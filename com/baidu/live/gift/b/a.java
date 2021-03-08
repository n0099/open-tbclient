package com.baidu.live.gift.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentItemView;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private List<aa.a> bfU;
    private int bfV = -1;

    public List<aa.a> getData() {
        return this.bfU;
    }

    public void setData(List<aa.a> list) {
        if (this.bfU == null) {
            this.bfU = new ArrayList();
        }
        this.bfU.clear();
        if (list != null) {
            this.bfU.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void cR(int i) {
        if (i != this.bfV) {
            this.bfV = i;
            notifyDataSetChanged();
        }
    }

    public void reset() {
        setData(null);
        cR(-1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bfU != null) {
            return this.bfU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dm */
    public aa.a getItem(int i) {
        if (getCount() > i) {
            return this.bfU.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0176a c0176a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_gift_panel_package_fragment_list_item, viewGroup, false);
            C0176a c0176a2 = new C0176a();
            c0176a2.bfW = (GiftPanelPackageFragmentItemView) view.findViewById(a.f.item);
            view.setTag(c0176a2);
            c0176a = c0176a2;
        } else {
            c0176a = (C0176a) view.getTag();
        }
        aa.a item = getItem(i);
        if (item != null) {
            c0176a.bfW.setSelected(this.bfV == i);
            c0176a.bfW.setData(item);
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0176a {
        private GiftPanelPackageFragmentItemView bfW;
    }
}
