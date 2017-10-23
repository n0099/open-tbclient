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
    private ArrayList<f> abD = new ArrayList<>();
    private TbPageContext<?> abm;

    public e(TbPageContext<?> tbPageContext) {
        this.abm = tbPageContext;
    }

    public void setData(ArrayList<f> arrayList) {
        this.abD = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.abD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.abD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        f fVar = this.abD.get(i);
        if (fVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.abE = (TextView) view.findViewById(d.h.text_tip);
            aVar2.abF = (TextView) view.findViewById(d.h.text_desc);
            aVar2.abG = (CheckBox) view.findViewById(d.h.checked_icon);
            aVar2.abH = view.findViewById(d.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.abE.setText(fVar.tk());
        if (StringUtils.isNull(fVar.getDesc())) {
            aVar.abF.setVisibility(8);
        } else {
            aVar.abF.setText(fVar.getDesc());
            aVar.abF.setVisibility(0);
        }
        aVar.abG.setChecked(fVar.isChecked());
        aVar.abG.setButtonDrawable(fVar.isChecked() ? aj.getDrawable(d.g.icon_set_list_ok_s) : new ColorDrawable(d.e.common_color_10022));
        if (cs(i)) {
            aVar.abH.setVisibility(8);
            aj.j(view, d.g.dialog_single_button_bg_selector);
        } else {
            aVar.abH.setVisibility(0);
            aj.j(view, d.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.abm.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abm.getLayoutMode().t(view);
        return view;
    }

    private boolean cs(int i) {
        return this.abD != null && i == this.abD.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView abE;
        TextView abF;
        CheckBox abG;
        View abH;

        private a() {
        }
    }
}
