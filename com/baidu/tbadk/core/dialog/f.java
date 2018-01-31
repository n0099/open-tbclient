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
    private ArrayList<g> aQJ = new ArrayList<>();
    private TbPageContext<?> aQs;

    public f(TbPageContext<?> tbPageContext) {
        this.aQs = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.aQJ = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aQJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aQJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.aQJ.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aQs.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.aQK = (TextView) view.findViewById(d.g.text_tip);
            aVar2.aQL = (TextView) view.findViewById(d.g.text_desc);
            aVar2.aQM = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.aQK.setText(gVar.AK());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.aQL.setVisibility(8);
        } else {
            aVar.aQL.setText(gVar.getDesc());
            aVar.aQL.setVisibility(0);
        }
        aVar.aQM.setChecked(gVar.isChecked());
        aVar.aQM.setButtonDrawable(gVar.isChecked() ? aj.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0108d.common_color_10022));
        if (fq(i)) {
            aVar.divider.setVisibility(8);
            aj.s(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            aj.s(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aQs.getLayoutMode().aN(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aQs.getLayoutMode().aM(view);
        return view;
    }

    private boolean fq(int i) {
        return this.aQJ != null && i == this.aQJ.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQK;
        TextView aQL;
        CheckBox aQM;
        View divider;

        private a() {
        }
    }
}
