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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<g> als = new ArrayList<>();
    private TbPageContext<?> mContext;

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.als = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.als.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.als.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.als.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.alt = (TextView) view.findViewById(f.g.text_tip);
            aVar2.alu = (TextView) view.findViewById(f.g.text_desc);
            aVar2.alv = (CheckBox) view.findViewById(f.g.checked_icon);
            aVar2.divider = view.findViewById(f.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.alt.setText(gVar.xn());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.alu.setVisibility(8);
        } else {
            aVar.alu.setText(gVar.getDesc());
            aVar.alu.setVisibility(0);
        }
        aVar.alv.setChecked(gVar.isChecked());
        aVar.alv.setButtonDrawable(gVar.isChecked() ? am.getDrawable(f.C0146f.icon_set_list_ok_s) : new ColorDrawable(f.d.common_color_10022));
        if (cu(i)) {
            aVar.divider.setVisibility(8);
            am.i(view, f.C0146f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            am.i(view, f.C0146f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean cu(int i) {
        return this.als != null && i == this.als.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView alt;
        TextView alu;
        CheckBox alv;
        View divider;

        private a() {
        }
    }
}
