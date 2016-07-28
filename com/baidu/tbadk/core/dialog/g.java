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
    private TbPageContext<?> DQ;
    private ArrayList<h> TD = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.DQ = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.TD = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.TD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.TD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.TD.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.DQ.getPageActivity()).inflate(u.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.TE = (TextView) view.findViewById(u.g.text_tip);
            aVar2.TF = (TextView) view.findViewById(u.g.text_desc);
            aVar2.TG = (CheckBox) view.findViewById(u.g.checked_icon);
            aVar2.TH = view.findViewById(u.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.TE.setText(hVar.sb());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.TF.setVisibility(8);
        } else {
            aVar.TF.setText(hVar.getDesc());
            aVar.TF.setVisibility(0);
        }
        aVar.TG.setChecked(hVar.isChecked());
        aVar.TG.setButtonDrawable(hVar.isChecked() ? av.getDrawable(u.f.icon_set_list_ok_s) : new ColorDrawable(u.d.common_color_10022));
        if (cc(i)) {
            aVar.TH.setVisibility(8);
            av.k(view, u.f.dialog_single_button_bg_selector);
        } else {
            aVar.TH.setVisibility(0);
            av.k(view, u.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.DQ.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
        this.DQ.getLayoutMode().w(view);
        return view;
    }

    private boolean cc(int i) {
        return this.TD != null && i == this.TD.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView TE;
        TextView TF;
        CheckBox TG;
        View TH;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
