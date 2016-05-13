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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> Do;
    private ArrayList<h> SE = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.Do = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.SE = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.SE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.SE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.SE.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.SF = (TextView) view.findViewById(t.g.text_tip);
            aVar2.SG = (TextView) view.findViewById(t.g.text_desc);
            aVar2.SH = (CheckBox) view.findViewById(t.g.checked_icon);
            aVar2.SI = view.findViewById(t.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.SF.setText(hVar.se());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.SG.setVisibility(8);
        } else {
            aVar.SG.setText(hVar.getDesc());
            aVar.SG.setVisibility(0);
        }
        aVar.SH.setChecked(hVar.isChecked());
        aVar.SH.setButtonDrawable(hVar.isChecked() ? at.getDrawable(t.f.icon_set_list_ok_s) : new ColorDrawable(t.d.transparent));
        if (cb(i)) {
            aVar.SI.setVisibility(8);
            at.k(view, t.f.dialog_single_button_bg_selector);
        } else {
            aVar.SI.setVisibility(0);
            at.k(view, t.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.Do.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.Do.getLayoutMode().x(view);
        return view;
    }

    private boolean cb(int i) {
        return this.SE != null && i == this.SE.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView SF;
        TextView SG;
        CheckBox SH;
        View SI;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
