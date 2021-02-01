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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private List<aa.a> ber;
    private int bes = -1;

    public List<aa.a> getData() {
        return this.ber;
    }

    public void setData(List<aa.a> list) {
        if (this.ber == null) {
            this.ber = new ArrayList();
        }
        this.ber.clear();
        if (list != null) {
            this.ber.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void cQ(int i) {
        if (i != this.bes) {
            this.bes = i;
            notifyDataSetChanged();
        }
    }

    public void reset() {
        setData(null);
        cQ(-1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ber != null) {
            return this.ber.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dl */
    public aa.a getItem(int i) {
        if (getCount() > i) {
            return this.ber.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0170a c0170a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_gift_panel_package_fragment_list_item, viewGroup, false);
            C0170a c0170a2 = new C0170a();
            c0170a2.beu = (GiftPanelPackageFragmentItemView) view.findViewById(a.f.item);
            view.setTag(c0170a2);
            c0170a = c0170a2;
        } else {
            c0170a = (C0170a) view.getTag();
        }
        aa.a item = getItem(i);
        if (item != null) {
            c0170a.beu.setSelected(this.bes == i);
            c0170a.beu.setData(item);
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0170a {
        private GiftPanelPackageFragmentItemView beu;
    }
}
