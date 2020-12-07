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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<aa.a> bep;
    private int beq = -1;

    public List<aa.a> getData() {
        return this.bep;
    }

    public void setData(List<aa.a> list) {
        if (this.bep == null) {
            this.bep = new ArrayList();
        }
        this.bep.clear();
        if (list != null) {
            this.bep.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void et(int i) {
        if (i != this.beq) {
            this.beq = i;
            notifyDataSetChanged();
        }
    }

    public void reset() {
        setData(null);
        et(-1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bep != null) {
            return this.bep.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eO */
    public aa.a getItem(int i) {
        if (getCount() > i) {
            return this.bep.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0184a c0184a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_gift_panel_package_fragment_list_item, viewGroup, false);
            C0184a c0184a2 = new C0184a();
            c0184a2.ber = (GiftPanelPackageFragmentItemView) view.findViewById(a.f.item);
            view.setTag(c0184a2);
            c0184a = c0184a2;
        } else {
            c0184a = (C0184a) view.getTag();
        }
        aa.a item = getItem(i);
        if (item != null) {
            c0184a.ber.setSelected(this.beq == i);
            c0184a.ber.setData(item);
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0184a {
        private GiftPanelPackageFragmentItemView ber;
    }
}
