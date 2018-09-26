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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<g> anX = new ArrayList<>();
    private TbPageContext<?> mContext;

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.anX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.anX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.anX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.anX.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.anY = (TextView) view.findViewById(e.g.text_tip);
            aVar2.anZ = (TextView) view.findViewById(e.g.text_desc);
            aVar2.aoa = (CheckBox) view.findViewById(e.g.checked_icon);
            aVar2.divider = view.findViewById(e.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.anY.setText(gVar.yu());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.anZ.setVisibility(8);
        } else {
            aVar.anZ.setText(gVar.getDesc());
            aVar.anZ.setVisibility(0);
        }
        aVar.aoa.setChecked(gVar.isChecked());
        aVar.aoa.setButtonDrawable(gVar.isChecked() ? al.getDrawable(e.f.icon_set_list_ok_s) : new ColorDrawable(e.d.common_color_10022));
        if (cE(i)) {
            aVar.divider.setVisibility(8);
            al.i(view, e.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            al.i(view, e.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean cE(int i) {
        return this.anX != null && i == this.anX.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView anY;
        TextView anZ;
        CheckBox aoa;
        View divider;

        private a() {
        }
    }
}
