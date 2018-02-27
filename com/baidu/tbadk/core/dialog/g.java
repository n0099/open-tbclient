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
public class g extends BaseAdapter {
    private TbPageContext<?> aRG;
    private ArrayList<h> aRX = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.aRG = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.aRX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aRX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aRX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.aRX.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.aRY = (TextView) view.findViewById(d.g.text_tip);
            aVar2.aRZ = (TextView) view.findViewById(d.g.text_desc);
            aVar2.aSa = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.aRY.setText(hVar.Bd());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.aRZ.setVisibility(8);
        } else {
            aVar.aRZ.setText(hVar.getDesc());
            aVar.aRZ.setVisibility(0);
        }
        aVar.aSa.setChecked(hVar.isChecked());
        aVar.aSa.setButtonDrawable(hVar.isChecked() ? aj.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0141d.common_color_10022));
        if (fq(i)) {
            aVar.divider.setVisibility(8);
            aj.s(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            aj.s(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aRG.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aRG.getLayoutMode().aM(view);
        return view;
    }

    private boolean fq(int i) {
        return this.aRX != null && i == this.aRX.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aRY;
        TextView aRZ;
        CheckBox aSa;
        View divider;

        private a() {
        }
    }
}
