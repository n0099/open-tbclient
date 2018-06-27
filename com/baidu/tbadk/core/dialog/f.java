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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<g> alT = new ArrayList<>();
    private TbPageContext<?> mContext;

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.alT = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.alT.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.alT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.alT.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.alU = (TextView) view.findViewById(d.g.text_tip);
            aVar2.alV = (TextView) view.findViewById(d.g.text_desc);
            aVar2.alW = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.alU.setText(gVar.xw());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.alV.setVisibility(8);
        } else {
            aVar.alV.setText(gVar.getDesc());
            aVar.alV.setVisibility(0);
        }
        aVar.alW.setChecked(gVar.isChecked());
        aVar.alW.setButtonDrawable(gVar.isChecked() ? am.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0142d.common_color_10022));
        if (cs(i)) {
            aVar.divider.setVisibility(8);
            am.i(view, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            am.i(view, d.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean cs(int i) {
        return this.alT != null && i == this.alT.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView alU;
        TextView alV;
        CheckBox alW;
        View divider;

        private a() {
        }
    }
}
