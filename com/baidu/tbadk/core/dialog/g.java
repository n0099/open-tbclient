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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private ArrayList<h> aaJ = new ArrayList<>();
    private TbPageContext<?> aat;

    public g(TbPageContext<?> tbPageContext) {
        this.aat = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.aaJ = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aaJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aaJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.aaJ.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.aaK = (TextView) view.findViewById(w.h.text_tip);
            aVar2.aaL = (TextView) view.findViewById(w.h.text_desc);
            aVar2.aaM = (CheckBox) view.findViewById(w.h.checked_icon);
            aVar2.aaN = view.findViewById(w.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.aaK.setText(hVar.tj());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.aaL.setVisibility(8);
        } else {
            aVar.aaL.setText(hVar.getDesc());
            aVar.aaL.setVisibility(0);
        }
        aVar.aaM.setChecked(hVar.isChecked());
        aVar.aaM.setButtonDrawable(hVar.isChecked() ? as.getDrawable(w.g.icon_set_list_ok_s) : new ColorDrawable(w.e.common_color_10022));
        if (cp(i)) {
            aVar.aaN.setVisibility(8);
            as.j(view, w.g.dialog_single_button_bg_selector);
        } else {
            aVar.aaN.setVisibility(0);
            as.j(view, w.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aat.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aat.getLayoutMode().t(view);
        return view;
    }

    private boolean cp(int i) {
        return this.aaJ != null && i == this.aaJ.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aaK;
        TextView aaL;
        CheckBox aaM;
        View aaN;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
