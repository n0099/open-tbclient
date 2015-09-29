package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<g> Xf = new ArrayList<>();
    private TbPageContext<?> mContext;

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.Xf = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Xf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Xf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.Xf.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.Xg = (TextView) view.findViewById(i.f.text_tip);
            aVar2.Xh = (TextView) view.findViewById(i.f.text_desc);
            aVar2.Xi = view.findViewById(i.f.checked_icon);
            aVar2.Xj = view.findViewById(i.f.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Xg.setText(gVar.ta());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.Xh.setVisibility(8);
        } else {
            aVar.Xh.setText(gVar.getDesc());
            aVar.Xh.setVisibility(0);
        }
        if (gVar.isChecked()) {
            aVar.Xi.setVisibility(0);
        } else {
            aVar.Xi.setVisibility(8);
        }
        if (bV(i)) {
            aVar.Xj.setVisibility(8);
            am.i(view, i.e.dialog_single_button_bg_selector);
        } else {
            aVar.Xj.setVisibility(0);
            am.i(view, i.e.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    private boolean bV(int i) {
        return this.Xf != null && i == this.Xf.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView Xg;
        TextView Xh;
        View Xi;
        View Xj;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
