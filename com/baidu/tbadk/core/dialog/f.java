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
    private ArrayList<g> XX = new ArrayList<>();
    private TbPageContext<?> mContext;

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.XX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.XX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.XX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.XX.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.XY = (TextView) view.findViewById(n.f.text_tip);
            aVar2.XZ = (TextView) view.findViewById(n.f.text_desc);
            aVar2.Ya = view.findViewById(n.f.checked_icon);
            aVar2.Yb = view.findViewById(n.f.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.XY.setText(gVar.tF());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.XZ.setVisibility(8);
        } else {
            aVar.XZ.setText(gVar.getDesc());
            aVar.XZ.setVisibility(0);
        }
        if (gVar.isChecked()) {
            aVar.Ya.setVisibility(0);
        } else {
            aVar.Ya.setVisibility(8);
        }
        if (cd(i)) {
            aVar.Yb.setVisibility(8);
            as.i(view, n.e.dialog_single_button_bg_selector);
        } else {
            aVar.Yb.setVisibility(0);
            as.i(view, n.e.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    private boolean cd(int i) {
        return this.XX != null && i == this.XX.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView XY;
        TextView XZ;
        View Ya;
        View Yb;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
