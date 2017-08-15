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
    private ArrayList<f> acH = new ArrayList<>();
    private TbPageContext<?> acr;

    public e(TbPageContext<?> tbPageContext) {
        this.acr = tbPageContext;
    }

    public void setData(ArrayList<f> arrayList) {
        this.acH = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.acH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.acH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        f fVar = this.acH.get(i);
        if (fVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.acI = (TextView) view.findViewById(d.h.text_tip);
            aVar2.acJ = (TextView) view.findViewById(d.h.text_desc);
            aVar2.acK = (CheckBox) view.findViewById(d.h.checked_icon);
            aVar2.acL = view.findViewById(d.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.acI.setText(fVar.tA());
        if (StringUtils.isNull(fVar.getDesc())) {
            aVar.acJ.setVisibility(8);
        } else {
            aVar.acJ.setText(fVar.getDesc());
            aVar.acJ.setVisibility(0);
        }
        aVar.acK.setChecked(fVar.isChecked());
        aVar.acK.setButtonDrawable(fVar.isChecked() ? ai.getDrawable(d.g.icon_set_list_ok_s) : new ColorDrawable(d.e.common_color_10022));
        if (ct(i)) {
            aVar.acL.setVisibility(8);
            ai.j(view, d.g.dialog_single_button_bg_selector);
        } else {
            aVar.acL.setVisibility(0);
            ai.j(view, d.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.acr.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acr.getLayoutMode().t(view);
        return view;
    }

    private boolean ct(int i) {
        return this.acH != null && i == this.acH.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView acI;
        TextView acJ;
        CheckBox acK;
        View acL;

        private a() {
        }
    }
}
