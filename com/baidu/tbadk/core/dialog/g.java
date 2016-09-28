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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> Gd;
    private ArrayList<h> WD = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.Gd = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.WD = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.WD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.WD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.WD.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.Gd.getPageActivity()).inflate(r.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.WE = (TextView) view.findViewById(r.g.text_tip);
            aVar2.WF = (TextView) view.findViewById(r.g.text_desc);
            aVar2.WG = (CheckBox) view.findViewById(r.g.checked_icon);
            aVar2.WH = view.findViewById(r.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.WE.setText(hVar.tv());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.WF.setVisibility(8);
        } else {
            aVar.WF.setText(hVar.getDesc());
            aVar.WF.setVisibility(0);
        }
        aVar.WG.setChecked(hVar.isChecked());
        aVar.WG.setButtonDrawable(hVar.isChecked() ? av.getDrawable(r.f.icon_set_list_ok_s) : new ColorDrawable(r.d.common_color_10022));
        if (cp(i)) {
            aVar.WH.setVisibility(8);
            av.k(view, r.f.dialog_single_button_bg_selector);
        } else {
            aVar.WH.setVisibility(0);
            av.k(view, r.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.Gd.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gd.getLayoutMode().x(view);
        return view;
    }

    private boolean cp(int i) {
        return this.WD != null && i == this.WD.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView WE;
        TextView WF;
        CheckBox WG;
        View WH;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
