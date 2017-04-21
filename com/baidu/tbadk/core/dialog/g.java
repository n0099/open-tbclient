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
    private TbPageContext<?> aaY;
    private ArrayList<h> abo = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.aaY = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.abo = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.abo.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.abo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.abo.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.abp = (TextView) view.findViewById(w.h.text_tip);
            aVar2.abq = (TextView) view.findViewById(w.h.text_desc);
            aVar2.abr = (CheckBox) view.findViewById(w.h.checked_icon);
            aVar2.abt = view.findViewById(w.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.abp.setText(hVar.tZ());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.abq.setVisibility(8);
        } else {
            aVar.abq.setText(hVar.getDesc());
            aVar.abq.setVisibility(0);
        }
        aVar.abr.setChecked(hVar.isChecked());
        aVar.abr.setButtonDrawable(hVar.isChecked() ? aq.getDrawable(w.g.icon_set_list_ok_s) : new ColorDrawable(w.e.common_color_10022));
        if (cq(i)) {
            aVar.abt.setVisibility(8);
            aq.j(view, w.g.dialog_single_button_bg_selector);
        } else {
            aVar.abt.setVisibility(0);
            aq.j(view, w.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aaY.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaY.getLayoutMode().t(view);
        return view;
    }

    private boolean cq(int i) {
        return this.abo != null && i == this.abo.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView abp;
        TextView abq;
        CheckBox abr;
        View abt;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
