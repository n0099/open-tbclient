package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> MR;
    private ArrayList<h> YX = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.MR = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.YX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.YX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.YX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.YX.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.YY = (TextView) view.findViewById(t.g.text_tip);
            aVar2.YZ = (TextView) view.findViewById(t.g.text_desc);
            aVar2.Za = view.findViewById(t.g.checked_icon);
            aVar2.Zb = view.findViewById(t.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.YY.setText(hVar.ut());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.YZ.setVisibility(8);
        } else {
            aVar.YZ.setText(hVar.getDesc());
            aVar.YZ.setVisibility(0);
        }
        if (hVar.isChecked()) {
            aVar.Za.setVisibility(0);
        } else {
            aVar.Za.setVisibility(8);
        }
        if (cp(i)) {
            aVar.Zb.setVisibility(8);
            ar.k(view, t.f.dialog_single_button_bg_selector);
        } else {
            aVar.Zb.setVisibility(0);
            ar.k(view, t.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.MR.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.MR.getLayoutMode().x(view);
        return view;
    }

    private boolean cp(int i) {
        return this.YX != null && i == this.YX.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView YY;
        TextView YZ;
        View Za;
        View Zb;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
