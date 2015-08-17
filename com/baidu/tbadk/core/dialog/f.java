package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private TbPageContext<?> LS;
    private ArrayList<g> Xe = new ArrayList<>();

    public f(TbPageContext<?> tbPageContext) {
        this.LS = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.Xe = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Xe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Xe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.Xe.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.LS.getPageActivity()).inflate(i.g.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.Xf = (TextView) view.findViewById(i.f.text_tip);
            aVar2.Xg = (TextView) view.findViewById(i.f.text_desc);
            aVar2.Xh = view.findViewById(i.f.checked_icon);
            aVar2.Xi = view.findViewById(i.f.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Xf.setText(gVar.sY());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.Xg.setVisibility(8);
        } else {
            aVar.Xg.setText(gVar.getDesc());
            aVar.Xg.setVisibility(0);
        }
        if (gVar.isChecked()) {
            aVar.Xh.setVisibility(0);
        } else {
            aVar.Xh.setVisibility(8);
        }
        if (bS(i)) {
            aVar.Xi.setVisibility(8);
            al.i(view, i.e.dialog_single_button_bg_selector);
        } else {
            aVar.Xi.setVisibility(0);
            al.i(view, i.e.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.LS.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.LS.getLayoutMode().k(view);
        return view;
    }

    private boolean bS(int i) {
        return this.Xe != null && i == this.Xe.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView Xf;
        TextView Xg;
        View Xh;
        View Xi;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
