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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private ArrayList<h> adv = new ArrayList<>();
    private TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.adv = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.adv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.adv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.adv.get(i);
        if (hVar == null) {
            return null;
        }
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.adw = (TextView) view2.findViewById(d.g.text_tip);
            aVar2.adx = (TextView) view2.findViewById(d.g.text_desc);
            aVar2.ady = (CheckBox) view2.findViewById(d.g.checked_icon);
            aVar2.divider = view2.findViewById(d.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view2.getTag();
        }
        aVar.adw.setText(hVar.tL());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.adx.setVisibility(8);
        } else {
            aVar.adx.setText(hVar.getDesc());
            aVar.adx.setVisibility(0);
        }
        aVar.ady.setChecked(hVar.isChecked());
        aVar.ady.setButtonDrawable(hVar.isChecked() ? ak.getDrawable(d.f.icon_set_list_ok_s) : new ColorDrawable(d.C0126d.common_color_10022));
        if (cp(i)) {
            aVar.divider.setVisibility(8);
            ak.i(view2, d.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            ak.i(view2, d.f.dialg_alert_btn_bg);
        }
        view2.setTag(aVar);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().u(view2);
        return view2;
    }

    private boolean cp(int i) {
        return this.adv != null && i == this.adv.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView adw;
        TextView adx;
        CheckBox ady;
        View divider;

        private a() {
        }
    }
}
