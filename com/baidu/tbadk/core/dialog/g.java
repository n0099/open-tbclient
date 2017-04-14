package com.baidu.tbadk.core.dialog;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> aaX;
    private ArrayList<h> abn = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.aaX = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.abn = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.abn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.abn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.abn.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.abo = (TextView) view.findViewById(w.h.text_tip);
            aVar2.abp = (TextView) view.findViewById(w.h.text_desc);
            aVar2.abq = (CheckBox) view.findViewById(w.h.checked_icon);
            aVar2.abr = view.findViewById(w.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.abo.setText(hVar.tZ());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.abp.setVisibility(8);
        } else {
            aVar.abp.setText(hVar.getDesc());
            aVar.abp.setVisibility(0);
        }
        aVar.abq.setChecked(hVar.isChecked());
        aVar.abq.setButtonDrawable(hVar.isChecked() ? aq.getDrawable(w.g.icon_set_list_ok_s) : new ColorDrawable(w.e.common_color_10022));
        if (cq(i)) {
            aVar.abr.setVisibility(8);
            aq.j(view, w.g.dialog_single_button_bg_selector);
        } else {
            aVar.abr.setVisibility(0);
            aq.j(view, w.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aaX.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaX.getLayoutMode().t(view);
        return view;
    }

    private boolean cq(int i) {
        return this.abn != null && i == this.abn.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView abo;
        TextView abp;
        CheckBox abq;
        View abr;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
