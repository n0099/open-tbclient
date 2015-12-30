package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<g> YA = new ArrayList<>();
    private TbPageContext<?> mContext;

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.YA = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.YA.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.YA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.YA.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.YB = (TextView) view.findViewById(n.g.text_tip);
            aVar2.YC = (TextView) view.findViewById(n.g.text_desc);
            aVar2.YD = view.findViewById(n.g.checked_icon);
            aVar2.YE = view.findViewById(n.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.YB.setText(gVar.tp());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.YC.setVisibility(8);
        } else {
            aVar.YC.setText(gVar.getDesc());
            aVar.YC.setVisibility(0);
        }
        if (gVar.isChecked()) {
            aVar.YD.setVisibility(0);
        } else {
            aVar.YD.setVisibility(8);
        }
        if (bW(i)) {
            aVar.YE.setVisibility(8);
            as.i(view, n.f.dialog_single_button_bg_selector);
        } else {
            aVar.YE.setVisibility(0);
            as.i(view, n.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    private boolean bW(int i) {
        return this.YA != null && i == this.YA.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView YB;
        TextView YC;
        View YD;
        View YE;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
