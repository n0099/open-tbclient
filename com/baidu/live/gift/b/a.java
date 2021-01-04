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
    private List<aa.a> bgb;
    private int bgc = -1;

    public List<aa.a> getData() {
        return this.bgb;
    }

    public void setData(List<aa.a> list) {
        if (this.bgb == null) {
            this.bgb = new ArrayList();
        }
        this.bgb.clear();
        if (list != null) {
            this.bgb.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void er(int i) {
        if (i != this.bgc) {
            this.bgc = i;
            notifyDataSetChanged();
        }
    }

    public void reset() {
        setData(null);
        er(-1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bgb != null) {
            return this.bgb.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eM */
    public aa.a getItem(int i) {
        if (getCount() > i) {
            return this.bgb.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0178a c0178a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_gift_panel_package_fragment_list_item, viewGroup, false);
            C0178a c0178a2 = new C0178a();
            c0178a2.bgd = (GiftPanelPackageFragmentItemView) view.findViewById(a.f.item);
            view.setTag(c0178a2);
            c0178a = c0178a2;
        } else {
            c0178a = (C0178a) view.getTag();
        }
        aa.a item = getItem(i);
        if (item != null) {
            c0178a.bgd.setSelected(this.bgc == i);
            c0178a.bgd.setData(item);
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0178a {
        private GiftPanelPackageFragmentItemView bgd;
    }
}
