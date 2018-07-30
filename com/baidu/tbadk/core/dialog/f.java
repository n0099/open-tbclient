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
    private ArrayList<g> alt = new ArrayList<>();
    private TbPageContext<?> mContext;

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.alt = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.alt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.alt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.alt.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.alu = (TextView) view.findViewById(d.g.text_tip);
            aVar2.alv = (TextView) view.findViewById(d.g.text_desc);
            aVar2.alw = (CheckBox) view.findViewById(d.g.checked_icon);
            aVar2.divider = view.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.alu.setText(gVar.xo());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.alv.setVisibility(8);
        } else {
            aVar.alv.setText(gVar.getDesc());
            aVar.alv.setVisibility(0);
        }
        aVar.alw.setChecked(gVar.isChecked());
        aVar.alw.setButtonDrawable(gVar.isChecked() ? am.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0140d.common_color_10022));
        if (cu(i)) {
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

    private boolean cu(int i) {
        return this.alt != null && i == this.alt.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView alu;
        TextView alv;
        CheckBox alw;
        View divider;

        private a() {
        }
    }
}
