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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<g> aQH = new ArrayList<>();
    private TbPageContext<?> aQq;

    public f(TbPageContext<?> tbPageContext) {
        this.aQq = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.aQH = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aQH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aQH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.aQH.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aQq.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.aQI = (TextView) view.findViewById(d.g.text_tip);
            aVar2.aQJ = (TextView) view.findViewById(d.g.text_desc);
            aVar2.aQK = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.aQI.setText(gVar.AR());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.aQJ.setVisibility(8);
        } else {
            aVar.aQJ.setText(gVar.getDesc());
            aVar.aQJ.setVisibility(0);
        }
        aVar.aQK.setChecked(gVar.isChecked());
        aVar.aQK.setButtonDrawable(gVar.isChecked() ? aj.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0108d.common_color_10022));
        if (fs(i)) {
            aVar.divider.setVisibility(8);
            aj.s(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            aj.s(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aQq.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aQq.getLayoutMode().aM(view);
        return view;
    }

    private boolean fs(int i) {
        return this.aQH != null && i == this.aQH.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQI;
        TextView aQJ;
        CheckBox aQK;
        View divider;

        private a() {
        }
    }
}
