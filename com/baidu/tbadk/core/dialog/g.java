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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> Gf;
    private ArrayList<h> Xb = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.Gf = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.Xb = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Xb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Xb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.Xb.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.Xc = (TextView) view.findViewById(r.g.text_tip);
            aVar2.Xd = (TextView) view.findViewById(r.g.text_desc);
            aVar2.Xe = (CheckBox) view.findViewById(r.g.checked_icon);
            aVar2.Xf = view.findViewById(r.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Xc.setText(hVar.tz());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.Xd.setVisibility(8);
        } else {
            aVar.Xd.setText(hVar.getDesc());
            aVar.Xd.setVisibility(0);
        }
        aVar.Xe.setChecked(hVar.isChecked());
        aVar.Xe.setButtonDrawable(hVar.isChecked() ? at.getDrawable(r.f.icon_set_list_ok_s) : new ColorDrawable(r.d.common_color_10022));
        if (cq(i)) {
            aVar.Xf.setVisibility(8);
            at.k(view, r.f.dialog_single_button_bg_selector);
        } else {
            aVar.Xf.setVisibility(0);
            at.k(view, r.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.Gf.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gf.getLayoutMode().x(view);
        return view;
    }

    private boolean cq(int i) {
        return this.Xb != null && i == this.Xb.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView Xc;
        TextView Xd;
        CheckBox Xe;
        View Xf;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
