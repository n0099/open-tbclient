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
    private List<aa.a> bbl;
    private int bbm = -1;

    public List<aa.a> getData() {
        return this.bbl;
    }

    public void setData(List<aa.a> list) {
        if (this.bbl == null) {
            this.bbl = new ArrayList();
        }
        this.bbl.clear();
        if (list != null) {
            this.bbl.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void cL(int i) {
        if (i != this.bbm) {
            this.bbm = i;
            notifyDataSetChanged();
        }
    }

    public void reset() {
        setData(null);
        cL(-1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbl != null) {
            return this.bbl.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dg */
    public aa.a getItem(int i) {
        if (getCount() > i) {
            return this.bbl.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0169a c0169a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_gift_panel_package_fragment_list_item, viewGroup, false);
            C0169a c0169a2 = new C0169a();
            c0169a2.bbn = (GiftPanelPackageFragmentItemView) view.findViewById(a.f.item);
            view.setTag(c0169a2);
            c0169a = c0169a2;
        } else {
            c0169a = (C0169a) view.getTag();
        }
        aa.a item = getItem(i);
        if (item != null) {
            c0169a.bbn.setSelected(this.bbm == i);
            c0169a.bbn.setData(item);
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0169a {
        private GiftPanelPackageFragmentItemView bbn;
    }
}
