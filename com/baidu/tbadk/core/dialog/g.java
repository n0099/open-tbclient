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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> Gd;
    private ArrayList<h> Wt = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.Gd = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.Wt = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Wt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Wt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.Wt.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.Gd.getPageActivity()).inflate(t.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.Wu = (TextView) view.findViewById(t.g.text_tip);
            aVar2.Wv = (TextView) view.findViewById(t.g.text_desc);
            aVar2.Ww = (CheckBox) view.findViewById(t.g.checked_icon);
            aVar2.Wx = view.findViewById(t.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Wu.setText(hVar.tg());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.Wv.setVisibility(8);
        } else {
            aVar.Wv.setText(hVar.getDesc());
            aVar.Wv.setVisibility(0);
        }
        aVar.Ww.setChecked(hVar.isChecked());
        aVar.Ww.setButtonDrawable(hVar.isChecked() ? av.getDrawable(t.f.icon_set_list_ok_s) : new ColorDrawable(t.d.common_color_10022));
        if (cp(i)) {
            aVar.Wx.setVisibility(8);
            av.k(view, t.f.dialog_single_button_bg_selector);
        } else {
            aVar.Wx.setVisibility(0);
            av.k(view, t.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.Gd.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gd.getLayoutMode().x(view);
        return view;
    }

    private boolean cp(int i) {
        return this.Wt != null && i == this.Wt.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView Wu;
        TextView Wv;
        CheckBox Ww;
        View Wx;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
