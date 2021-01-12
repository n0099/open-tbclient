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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private TbPageContext<?> eSJ;
    private ArrayList<m> eTF = new ArrayList<>();

    public l(TbPageContext<?> tbPageContext) {
        this.eSJ = tbPageContext;
    }

    public void setData(ArrayList<m> arrayList) {
        this.eTF = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eTF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        m mVar = this.eTF.get(i);
        if (mVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.mTipView = (TextView) view.findViewById(R.id.text_tip);
            aVar2.mDescView = (TextView) view.findViewById(R.id.text_desc);
            aVar2.eTG = (CheckBox) view.findViewById(R.id.checked_icon);
            aVar2.bPy = view.findViewById(R.id.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mTipView.setText(mVar.bqz());
        if (StringUtils.isNull(mVar.getDesc())) {
            aVar.mDescView.setVisibility(8);
        } else {
            aVar.mDescView.setText(mVar.getDesc());
            aVar.mDescView.setVisibility(0);
        }
        aVar.eTG.setChecked(mVar.isChecked());
        aVar.eTG.setButtonDrawable(mVar.isChecked() ? ao.getDrawable(R.drawable.icon_set_list_ok_s) : new ColorDrawable(R.color.common_color_10022));
        if (nH(i)) {
            aVar.bPy.setVisibility(8);
            ao.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
        } else {
            aVar.bPy.setVisibility(0);
            ao.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.eSJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eSJ.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean nH(int i) {
        return this.eTF != null && i == this.eTF.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        View bPy;
        CheckBox eTG;
        TextView mDescView;
        TextView mTipView;

        private a() {
        }
    }
}
