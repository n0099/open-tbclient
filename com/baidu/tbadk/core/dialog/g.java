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
    private TbPageContext<?> aRI;
    private ArrayList<h> aRZ = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.aRI = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.aRZ = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aRZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aRZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.aRZ.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.aSa = (TextView) view.findViewById(d.g.text_tip);
            aVar2.aSb = (TextView) view.findViewById(d.g.text_desc);
            aVar2.aSc = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.aSa.setText(hVar.Be());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.aSb.setVisibility(8);
        } else {
            aVar.aSb.setText(hVar.getDesc());
            aVar.aSb.setVisibility(0);
        }
        aVar.aSc.setChecked(hVar.isChecked());
        aVar.aSc.setButtonDrawable(hVar.isChecked() ? aj.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0141d.common_color_10022));
        if (fq(i)) {
            aVar.divider.setVisibility(8);
            aj.s(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            aj.s(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.aRI.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aRI.getLayoutMode().aM(view);
        return view;
    }

    private boolean fq(int i) {
        return this.aRZ != null && i == this.aRZ.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aSa;
        TextView aSb;
        CheckBox aSc;
        View divider;

        private a() {
        }
    }
}
