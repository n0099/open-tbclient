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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private TbPageContext<?> mContext;
    private ArrayList<g> mData = new ArrayList<>();

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<g> arrayList) {
        this.mData = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = this.mData.get(i);
        if (gVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.axH = (TextView) view.findViewById(e.g.text_tip);
            aVar2.axI = (TextView) view.findViewById(e.g.text_desc);
            aVar2.axJ = (CheckBox) view.findViewById(e.g.checked_icon);
            aVar2.divider = view.findViewById(e.g.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.axH.setText(gVar.getTip());
        if (StringUtils.isNull(gVar.getDesc())) {
            aVar.axI.setVisibility(8);
        } else {
            aVar.axI.setText(gVar.getDesc());
            aVar.axI.setVisibility(0);
        }
        aVar.axJ.setChecked(gVar.isChecked());
        aVar.axJ.setButtonDrawable(gVar.isChecked() ? al.getDrawable(e.f.icon_set_list_ok_s) : new ColorDrawable(e.d.common_color_10022));
        if (dq(i)) {
            aVar.divider.setVisibility(8);
            al.i(view, e.f.dialog_single_button_bg_selector);
        } else {
            aVar.divider.setVisibility(0);
            al.i(view, e.f.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    private boolean dq(int i) {
        return this.mData != null && i == this.mData.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView axH;
        TextView axI;
        CheckBox axJ;
        View divider;

        private a() {
        }
    }
}
