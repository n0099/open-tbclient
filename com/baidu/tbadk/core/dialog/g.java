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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> Gf;
    private ArrayList<h> Wv = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.Gf = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.Wv = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Wv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Wv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.Wv.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.Ww = (TextView) view.findViewById(r.g.text_tip);
            aVar2.Wx = (TextView) view.findViewById(r.g.text_desc);
            aVar2.Wy = (CheckBox) view.findViewById(r.g.checked_icon);
            aVar2.Wz = view.findViewById(r.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Ww.setText(hVar.tk());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.Wx.setVisibility(8);
        } else {
            aVar.Wx.setText(hVar.getDesc());
            aVar.Wx.setVisibility(0);
        }
        aVar.Wy.setChecked(hVar.isChecked());
        aVar.Wy.setButtonDrawable(hVar.isChecked() ? ar.getDrawable(r.f.icon_set_list_ok_s) : new ColorDrawable(r.d.common_color_10022));
        if (cs(i)) {
            aVar.Wz.setVisibility(8);
            ar.k(view, r.f.dialog_single_button_bg_selector);
        } else {
            aVar.Wz.setVisibility(0);
            ar.k(view, r.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.Gf.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gf.getLayoutMode().x(view);
        return view;
    }

    private boolean cs(int i) {
        return this.Wv != null && i == this.Wv.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView Ww;
        TextView Wx;
        CheckBox Wy;
        View Wz;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
