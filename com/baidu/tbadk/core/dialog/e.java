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
public class e extends BaseAdapter {
    private ArrayList<f> abP = new ArrayList<>();
    private TbPageContext<?> abz;

    public e(TbPageContext<?> tbPageContext) {
        this.abz = tbPageContext;
    }

    public void setData(ArrayList<f> arrayList) {
        this.abP = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.abP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.abP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        f fVar = this.abP.get(i);
        if (fVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.abQ = (TextView) view.findViewById(d.h.text_tip);
            aVar2.abR = (TextView) view.findViewById(d.h.text_desc);
            aVar2.abS = (CheckBox) view.findViewById(d.h.checked_icon);
            aVar2.abT = view.findViewById(d.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.abQ.setText(fVar.tr());
        if (StringUtils.isNull(fVar.getDesc())) {
            aVar.abR.setVisibility(8);
        } else {
            aVar.abR.setText(fVar.getDesc());
            aVar.abR.setVisibility(0);
        }
        aVar.abS.setChecked(fVar.isChecked());
        aVar.abS.setButtonDrawable(fVar.isChecked() ? aj.getDrawable(d.g.icon_set_list_ok_s) : new ColorDrawable(d.e.common_color_10022));
        if (ct(i)) {
            aVar.abT.setVisibility(8);
            aj.j(view, d.g.dialog_single_button_bg_selector);
        } else {
            aVar.abT.setVisibility(0);
            aj.j(view, d.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.abz.getLayoutMode().ai(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abz.getLayoutMode().t(view);
        return view;
    }

    private boolean ct(int i) {
        return this.abP != null && i == this.abP.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView abQ;
        TextView abR;
        CheckBox abS;
        View abT;

        private a() {
        }
    }
}
