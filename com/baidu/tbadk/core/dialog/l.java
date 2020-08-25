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
/* loaded from: classes2.dex */
public class l extends BaseAdapter {
    private ArrayList<m> efX = new ArrayList<>();
    private TbPageContext<?> efn;

    public l(TbPageContext<?> tbPageContext) {
        this.efn = tbPageContext;
    }

    public void setData(ArrayList<m> arrayList) {
        this.efX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.efX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.efX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        m mVar = this.efX.get(i);
        if (mVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.mTipView = (TextView) view.findViewById(R.id.text_tip);
            aVar2.mDescView = (TextView) view.findViewById(R.id.text_desc);
            aVar2.efY = (CheckBox) view.findViewById(R.id.checked_icon);
            aVar2.efZ = view.findViewById(R.id.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mTipView.setText(mVar.bhx());
        if (StringUtils.isNull(mVar.getDesc())) {
            aVar.mDescView.setVisibility(8);
        } else {
            aVar.mDescView.setText(mVar.getDesc());
            aVar.mDescView.setVisibility(0);
        }
        aVar.efY.setChecked(mVar.isChecked());
        aVar.efY.setButtonDrawable(mVar.isChecked() ? ap.getDrawable(R.drawable.icon_set_list_ok_s) : new ColorDrawable(R.color.common_color_10022));
        if (nF(i)) {
            aVar.efZ.setVisibility(8);
            ap.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
        } else {
            aVar.efZ.setVisibility(0);
            ap.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.efn.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.efn.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean nF(int i) {
        return this.efX != null && i == this.efX.size() + (-1);
    }

    /* loaded from: classes2.dex */
    private class a {
        CheckBox efY;
        View efZ;
        TextView mDescView;
        TextView mTipView;

        private a() {
        }
    }
}
