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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private ArrayList<m> eIM = new ArrayList<>();
    private TbPageContext<?> eIc;

    public l(TbPageContext<?> tbPageContext) {
        this.eIc = tbPageContext;
    }

    public void setData(ArrayList<m> arrayList) {
        this.eIM = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eIM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eIM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        m mVar = this.eIM.get(i);
        if (mVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.mTipView = (TextView) view.findViewById(R.id.text_tip);
            aVar2.mDescView = (TextView) view.findViewById(R.id.text_desc);
            aVar2.eIN = (CheckBox) view.findViewById(R.id.checked_icon);
            aVar2.eIO = view.findViewById(R.id.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mTipView.setText(mVar.bpt());
        if (StringUtils.isNull(mVar.getDesc())) {
            aVar.mDescView.setVisibility(8);
        } else {
            aVar.mDescView.setText(mVar.getDesc());
            aVar.mDescView.setVisibility(0);
        }
        aVar.eIN.setChecked(mVar.isChecked());
        aVar.eIN.setButtonDrawable(mVar.isChecked() ? ap.getDrawable(R.drawable.icon_set_list_ok_s) : new ColorDrawable(R.color.common_color_10022));
        if (oJ(i)) {
            aVar.eIO.setVisibility(8);
            ap.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
        } else {
            aVar.eIO.setVisibility(0);
            ap.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.eIc.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eIc.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean oJ(int i) {
        return this.eIM != null && i == this.eIM.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        CheckBox eIN;
        View eIO;
        TextView mDescView;
        TextView mTipView;

        private a() {
        }
    }
}
