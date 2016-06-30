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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> Dp;
    private ArrayList<h> SV = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.Dp = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.SV = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.SV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.SV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.SV.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.Dp.getPageActivity()).inflate(u.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.SW = (TextView) view.findViewById(u.g.text_tip);
            aVar2.SX = (TextView) view.findViewById(u.g.text_desc);
            aVar2.SY = (CheckBox) view.findViewById(u.g.checked_icon);
            aVar2.SZ = view.findViewById(u.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.SW.setText(hVar.sc());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.SX.setVisibility(8);
        } else {
            aVar.SX.setText(hVar.getDesc());
            aVar.SX.setVisibility(0);
        }
        aVar.SY.setChecked(hVar.isChecked());
        aVar.SY.setButtonDrawable(hVar.isChecked() ? av.getDrawable(u.f.icon_set_list_ok_s) : new ColorDrawable(u.d.common_color_10022));
        if (cc(i)) {
            aVar.SZ.setVisibility(8);
            av.k(view, u.f.dialog_single_button_bg_selector);
        } else {
            aVar.SZ.setVisibility(0);
            av.k(view, u.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.Dp.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Dp.getLayoutMode().w(view);
        return view;
    }

    private boolean cc(int i) {
        return this.SV != null && i == this.SV.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView SW;
        TextView SX;
        CheckBox SY;
        View SZ;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
