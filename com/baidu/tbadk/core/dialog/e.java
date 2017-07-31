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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private ArrayList<f> acF = new ArrayList<>();
    private TbPageContext<?> acp;

    public e(TbPageContext<?> tbPageContext) {
        this.acp = tbPageContext;
    }

    public void setData(ArrayList<f> arrayList) {
        this.acF = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.acF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.acF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        f fVar = this.acF.get(i);
        if (fVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.acG = (TextView) view.findViewById(d.h.text_tip);
            aVar2.acH = (TextView) view.findViewById(d.h.text_desc);
            aVar2.acI = (CheckBox) view.findViewById(d.h.checked_icon);
            aVar2.acJ = view.findViewById(d.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.acG.setText(fVar.tA());
        if (StringUtils.isNull(fVar.getDesc())) {
            aVar.acH.setVisibility(8);
        } else {
            aVar.acH.setText(fVar.getDesc());
            aVar.acH.setVisibility(0);
        }
        aVar.acI.setChecked(fVar.isChecked());
        aVar.acI.setButtonDrawable(fVar.isChecked() ? ai.getDrawable(d.g.icon_set_list_ok_s) : new ColorDrawable(d.e.common_color_10022));
        if (ct(i)) {
            aVar.acJ.setVisibility(8);
            ai.j(view, d.g.dialog_single_button_bg_selector);
        } else {
            aVar.acJ.setVisibility(0);
            ai.j(view, d.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.acp.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acp.getLayoutMode().t(view);
        return view;
    }

    private boolean ct(int i) {
        return this.acF != null && i == this.acF.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView acG;
        TextView acH;
        CheckBox acI;
        View acJ;

        private a() {
        }
    }
}
