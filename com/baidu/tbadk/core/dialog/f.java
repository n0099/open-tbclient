package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<g> Xh = new ArrayList<>();
    private TbPageContext<?> mContext;

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.Xh = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Xh.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Xh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.Xh.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.Xi = (TextView) view.findViewById(i.f.text_tip);
            aVar2.Xj = (TextView) view.findViewById(i.f.text_desc);
            aVar2.Xk = view.findViewById(i.f.checked_icon);
            aVar2.Xl = view.findViewById(i.f.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Xi.setText(gVar.sX());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.Xj.setVisibility(8);
        } else {
            aVar.Xj.setText(gVar.getDesc());
            aVar.Xj.setVisibility(0);
        }
        if (gVar.isChecked()) {
            aVar.Xk.setVisibility(0);
        } else {
            aVar.Xk.setVisibility(8);
        }
        if (bV(i)) {
            aVar.Xl.setVisibility(8);
            an.i(view, i.e.dialog_single_button_bg_selector);
        } else {
            aVar.Xl.setVisibility(0);
            an.i(view, i.e.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    private boolean bV(int i) {
        return this.Xh != null && i == this.Xh.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView Xi;
        TextView Xj;
        View Xk;
        View Xl;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
