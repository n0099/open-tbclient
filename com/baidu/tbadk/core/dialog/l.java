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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private ArrayList<m> bbH = new ArrayList<>();
    private TbPageContext<?> ceu;

    public l(TbPageContext<?> tbPageContext) {
        this.ceu = tbPageContext;
    }

    public void setData(ArrayList<m> arrayList) {
        this.bbH = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bbH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bbH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        m mVar = this.bbH.get(i);
        if (mVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.mTipView = (TextView) view.findViewById(R.id.text_tip);
            aVar2.mDescView = (TextView) view.findViewById(R.id.text_desc);
            aVar2.cfg = (CheckBox) view.findViewById(R.id.checked_icon);
            aVar2.cfh = view.findViewById(R.id.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mTipView.setText(mVar.ald());
        if (StringUtils.isNull(mVar.getDesc())) {
            aVar.mDescView.setVisibility(8);
        } else {
            aVar.mDescView.setText(mVar.getDesc());
            aVar.mDescView.setVisibility(0);
        }
        aVar.cfg.setChecked(mVar.isChecked());
        aVar.cfg.setButtonDrawable(mVar.isChecked() ? am.getDrawable(R.drawable.icon_set_list_ok_s) : new ColorDrawable(R.color.common_color_10022));
        if (m22if(i)) {
            aVar.cfh.setVisibility(8);
            am.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
        } else {
            aVar.cfh.setVisibility(0);
            am.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.ceu.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ceu.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m22if(int i) {
        return this.bbH != null && i == this.bbH.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        CheckBox cfg;
        View cfh;
        TextView mDescView;
        TextView mTipView;

        private a() {
        }
    }
}
