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
    private TbPageContext<?> acd;
    private ArrayList<g> acx = new ArrayList<>();

    public f(TbPageContext<?> tbPageContext) {
        this.acd = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.acx = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.acx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.acx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.acx.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.acd.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.acy = (TextView) view.findViewById(d.g.text_tip);
            aVar2.acz = (TextView) view.findViewById(d.g.text_desc);
            aVar2.acA = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.acy.setText(gVar.tu());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.acz.setVisibility(8);
        } else {
            aVar.acz.setText(gVar.getDesc());
            aVar.acz.setVisibility(0);
        }
        aVar.acA.setChecked(gVar.isChecked());
        aVar.acA.setButtonDrawable(gVar.isChecked() ? aj.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0082d.common_color_10022));
        if (ct(i)) {
            aVar.divider.setVisibility(8);
            aj.j(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            aj.j(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.acd.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acd.getLayoutMode().t(view);
        return view;
    }

    private boolean ct(int i) {
        return this.acx != null && i == this.acx.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        CheckBox acA;
        TextView acy;
        TextView acz;
        View divider;

        private a() {
        }
    }
}
