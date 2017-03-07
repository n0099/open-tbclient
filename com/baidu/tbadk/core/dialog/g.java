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
    private TbPageContext<?> aaI;
    private ArrayList<h> aaY = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.aaI = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.aaY = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aaY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aaY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.aaY.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.aaZ = (TextView) view.findViewById(w.h.text_tip);
            aVar2.aba = (TextView) view.findViewById(w.h.text_desc);
            aVar2.abb = (CheckBox) view.findViewById(w.h.checked_icon);
            aVar2.abc = view.findViewById(w.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.aaZ.setText(hVar.tB());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.aba.setVisibility(8);
        } else {
            aVar.aba.setText(hVar.getDesc());
            aVar.aba.setVisibility(0);
        }
        aVar.abb.setChecked(hVar.isChecked());
        aVar.abb.setButtonDrawable(hVar.isChecked() ? aq.getDrawable(w.g.icon_set_list_ok_s) : new ColorDrawable(w.e.common_color_10022));
        if (cn(i)) {
            aVar.abc.setVisibility(8);
            aq.j(view, w.g.dialog_single_button_bg_selector);
        } else {
            aVar.abc.setVisibility(0);
            aq.j(view, w.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aaI.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaI.getLayoutMode().t(view);
        return view;
    }

    private boolean cn(int i) {
        return this.aaY != null && i == this.aaY.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aaZ;
        TextView aba;
        CheckBox abb;
        View abc;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
