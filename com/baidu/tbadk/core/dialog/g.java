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
    private ArrayList<h> aaI = new ArrayList<>();
    private TbPageContext<?> aas;

    public g(TbPageContext<?> tbPageContext) {
        this.aas = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.aaI = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aaI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aaI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.aaI.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aas.getPageActivity()).inflate(w.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.aaJ = (TextView) view.findViewById(w.h.text_tip);
            aVar2.aaK = (TextView) view.findViewById(w.h.text_desc);
            aVar2.aaL = (CheckBox) view.findViewById(w.h.checked_icon);
            aVar2.aaM = view.findViewById(w.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.aaJ.setText(hVar.tl());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.aaK.setVisibility(8);
        } else {
            aVar.aaK.setText(hVar.getDesc());
            aVar.aaK.setVisibility(0);
        }
        aVar.aaL.setChecked(hVar.isChecked());
        aVar.aaL.setButtonDrawable(hVar.isChecked() ? aq.getDrawable(w.g.icon_set_list_ok_s) : new ColorDrawable(w.e.common_color_10022));
        if (cp(i)) {
            aVar.aaM.setVisibility(8);
            aq.j(view, w.g.dialog_single_button_bg_selector);
        } else {
            aVar.aaM.setVisibility(0);
            aq.j(view, w.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aas.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aas.getLayoutMode().t(view);
        return view;
    }

    private boolean cp(int i) {
        return this.aaI != null && i == this.aaI.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aaJ;
        TextView aaK;
        CheckBox aaL;
        View aaM;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
