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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private ArrayList<k> aFH = new ArrayList<>();
    private TbPageContext<?> mContext;

    public j(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<k> arrayList) {
        this.aFH = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aFH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aFH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        k kVar = this.aFH.get(i);
        if (kVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.bFG = (TextView) view.findViewById(d.g.text_tip);
            aVar2.bFH = (TextView) view.findViewById(d.g.text_desc);
            aVar2.bFI = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.bFG.setText(kVar.abl());
        if (StringUtils.isNull(kVar.getDesc())) {
            aVar.bFH.setVisibility(8);
        } else {
            aVar.bFH.setText(kVar.getDesc());
            aVar.bFH.setVisibility(0);
        }
        aVar.bFI.setChecked(kVar.isChecked());
        aVar.bFI.setButtonDrawable(kVar.isChecked() ? al.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0236d.common_color_10022));
        if (gS(i)) {
            aVar.divider.setVisibility(8);
            al.k(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            al.k(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean gS(int i) {
        return this.aFH != null && i == this.aFH.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView bFG;
        TextView bFH;
        CheckBox bFI;
        View divider;

        private a() {
        }
    }
}
