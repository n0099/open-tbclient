package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private TbPageContext<?> LH;
    private ArrayList<m> Sk = new ArrayList<>();

    public k(TbPageContext<?> tbPageContext) {
        this.LH = tbPageContext;
    }

    public void setData(ArrayList<m> arrayList) {
        this.Sk = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Sk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Sk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        m mVar = this.Sk.get(i);
        if (mVar == null) {
            return null;
        }
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().a(this.LH.getPageActivity(), r.dialog_rich_bdlist_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.Sl = (TextView) view.findViewById(q.text_tip);
            lVar2.Sm = (TextView) view.findViewById(q.text_desc);
            lVar2.Sn = view.findViewById(q.checked_icon);
            lVar2.So = view.findViewById(q.line);
            lVar = lVar2;
        } else {
            lVar = (l) view.getTag();
        }
        lVar.Sl.setText(mVar.rS());
        if (StringUtils.isNull(mVar.qG())) {
            lVar.Sm.setVisibility(8);
        } else {
            lVar.Sm.setText(mVar.qG());
            lVar.Sm.setVisibility(0);
        }
        if (mVar.isChecked()) {
            lVar.Sn.setVisibility(0);
        } else {
            lVar.Sn.setVisibility(8);
        }
        if (bK(i)) {
            lVar.So.setVisibility(8);
            ay.i(view, p.dialog_single_button_bg_selector);
        } else {
            lVar.So.setVisibility(0);
            ay.i(view, p.dialg_alert_btn_bg);
        }
        view.setTag(lVar);
        this.LH.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.LH.getLayoutMode().j(view);
        return view;
    }

    private boolean bK(int i) {
        return this.Sk != null && i == this.Sk.size() + (-1);
    }
}
