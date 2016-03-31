package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> MX;
    private ArrayList<h> Xq = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.MX = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.Xq = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Xq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Xq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.Xq.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.Xr = (TextView) view.findViewById(t.g.text_tip);
            aVar2.Xs = (TextView) view.findViewById(t.g.text_desc);
            aVar2.Xt = view.findViewById(t.g.checked_icon);
            aVar2.Xu = view.findViewById(t.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Xr.setText(hVar.uy());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.Xs.setVisibility(8);
        } else {
            aVar.Xs.setText(hVar.getDesc());
            aVar.Xs.setVisibility(0);
        }
        if (hVar.isChecked()) {
            aVar.Xt.setVisibility(0);
        } else {
            aVar.Xt.setVisibility(8);
        }
        if (cr(i)) {
            aVar.Xu.setVisibility(8);
            at.k(view, t.f.dialog_single_button_bg_selector);
        } else {
            aVar.Xu.setVisibility(0);
            at.k(view, t.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.MX.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.MX.getLayoutMode().x(view);
        return view;
    }

    private boolean cr(int i) {
        return this.Xq != null && i == this.Xq.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView Xr;
        TextView Xs;
        View Xt;
        View Xu;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
