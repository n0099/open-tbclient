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
    private ArrayList<g> aQG = new ArrayList<>();
    private TbPageContext<?> aQp;

    public f(TbPageContext<?> tbPageContext) {
        this.aQp = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.aQG = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aQG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aQG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.aQG.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aQp.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.aQH = (TextView) view.findViewById(d.g.text_tip);
            aVar2.aQI = (TextView) view.findViewById(d.g.text_desc);
            aVar2.aQJ = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.aQH.setText(gVar.AJ());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.aQI.setVisibility(8);
        } else {
            aVar.aQI.setText(gVar.getDesc());
            aVar.aQI.setVisibility(0);
        }
        aVar.aQJ.setChecked(gVar.isChecked());
        aVar.aQJ.setButtonDrawable(gVar.isChecked() ? aj.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0107d.common_color_10022));
        if (fq(i)) {
            aVar.divider.setVisibility(8);
            aj.s(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            aj.s(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aQp.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aQp.getLayoutMode().aM(view);
        return view;
    }

    private boolean fq(int i) {
        return this.aQG != null && i == this.aQG.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQH;
        TextView aQI;
        CheckBox aQJ;
        View divider;

        private a() {
        }
    }
}
