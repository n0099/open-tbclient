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
    private TbPageContext<?> aca;
    private ArrayList<g> acu = new ArrayList<>();

    public f(TbPageContext<?> tbPageContext) {
        this.aca = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.acu = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.acu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.acu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.acu.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aca.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.acv = (TextView) view.findViewById(d.g.text_tip);
            aVar2.acw = (TextView) view.findViewById(d.g.text_desc);
            aVar2.acx = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.acv.setText(gVar.tr());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.acw.setVisibility(8);
        } else {
            aVar.acw.setText(gVar.getDesc());
            aVar.acw.setVisibility(0);
        }
        aVar.acx.setChecked(gVar.isChecked());
        aVar.acx.setButtonDrawable(gVar.isChecked() ? aj.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0095d.common_color_10022));
        if (ct(i)) {
            aVar.divider.setVisibility(8);
            aj.j(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            aj.j(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aca.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aca.getLayoutMode().t(view);
        return view;
    }

    private boolean ct(int i) {
        return this.acu != null && i == this.acu.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView acv;
        TextView acw;
        CheckBox acx;
        View divider;

        private a() {
        }
    }
}
