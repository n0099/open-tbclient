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
    private ArrayList<m> aIL = new ArrayList<>();
    private TbPageContext<?> mContext;

    public l(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<m> arrayList) {
        this.aIL = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aIL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aIL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        m mVar = this.aIL.get(i);
        if (mVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.bOT = (TextView) view.findViewById(R.id.text_tip);
            aVar2.bOU = (TextView) view.findViewById(R.id.text_desc);
            aVar2.bOV = (CheckBox) view.findViewById(R.id.checked_icon);
            aVar2.divider = view.findViewById(R.id.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.bOT.setText(mVar.ahi());
        if (StringUtils.isNull(mVar.getDesc())) {
            aVar.bOU.setVisibility(8);
        } else {
            aVar.bOU.setText(mVar.getDesc());
            aVar.bOU.setVisibility(0);
        }
        aVar.bOV.setChecked(mVar.isChecked());
        aVar.bOV.setButtonDrawable(mVar.isChecked() ? am.getDrawable(R.drawable.icon_set_list_ok_s) : new ColorDrawable(R.color.common_color_10022));
        if (hL(i)) {
            aVar.divider.setVisibility(8);
            am.k(view, R.drawable.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            am.k(view, R.drawable.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean hL(int i) {
        return this.aIL != null && i == this.aIL.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView bOT;
        TextView bOU;
        CheckBox bOV;
        View divider;

        private a() {
        }
    }
}
