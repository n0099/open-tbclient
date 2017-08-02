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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private TbPageContext<?> aaS;
    private ArrayList<f> abi = new ArrayList<>();

    public e(TbPageContext<?> tbPageContext) {
        this.aaS = tbPageContext;
    }

    public void setData(ArrayList<f> arrayList) {
        this.abi = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.abi.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.abi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        f fVar = this.abi.get(i);
        if (fVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.abj = (TextView) view.findViewById(d.h.text_tip);
            aVar2.abk = (TextView) view.findViewById(d.h.text_desc);
            aVar2.abl = (CheckBox) view.findViewById(d.h.checked_icon);
            aVar2.abm = view.findViewById(d.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.abj.setText(fVar.tq());
        if (StringUtils.isNull(fVar.getDesc())) {
            aVar.abk.setVisibility(8);
        } else {
            aVar.abk.setText(fVar.getDesc());
            aVar.abk.setVisibility(0);
        }
        aVar.abl.setChecked(fVar.isChecked());
        aVar.abl.setButtonDrawable(fVar.isChecked() ? ai.getDrawable(d.g.icon_set_list_ok_s) : new ColorDrawable(d.e.common_color_10022));
        if (cr(i)) {
            aVar.abm.setVisibility(8);
            ai.j(view, d.g.dialog_single_button_bg_selector);
        } else {
            aVar.abm.setVisibility(0);
            ai.j(view, d.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aaS.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aaS.getLayoutMode().t(view);
        return view;
    }

    private boolean cr(int i) {
        return this.abi != null && i == this.abi.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView abj;
        TextView abk;
        CheckBox abl;
        View abm;

        private a() {
        }
    }
}
