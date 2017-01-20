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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> Fp;
    private ArrayList<h> VL = new ArrayList<>();

    public g(TbPageContext<?> tbPageContext) {
        this.Fp = tbPageContext;
    }

    public void setData(ArrayList<h> arrayList) {
        this.VL = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.VL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.VL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        h hVar = this.VL.get(i);
        if (hVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.dialog_rich_bdlist_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.VM = (TextView) view.findViewById(r.h.text_tip);
            aVar2.VN = (TextView) view.findViewById(r.h.text_desc);
            aVar2.VO = (CheckBox) view.findViewById(r.h.checked_icon);
            aVar2.VP = view.findViewById(r.h.line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.VM.setText(hVar.te());
        if (StringUtils.isNull(hVar.getDesc())) {
            aVar.VN.setVisibility(8);
        } else {
            aVar.VN.setText(hVar.getDesc());
            aVar.VN.setVisibility(0);
        }
        aVar.VO.setChecked(hVar.isChecked());
        aVar.VO.setButtonDrawable(hVar.isChecked() ? ap.getDrawable(r.g.icon_set_list_ok_s) : new ColorDrawable(r.e.common_color_10022));
        if (cr(i)) {
            aVar.VP.setVisibility(8);
            ap.j(view, r.g.dialog_single_button_bg_selector);
        } else {
            aVar.VP.setVisibility(0);
            ap.j(view, r.g.dialg_alert_btn_bg);
        }
        view.setTag(aVar);
        this.Fp.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Fp.getLayoutMode().v(view);
        return view;
    }

    private boolean cr(int i) {
        return this.VL != null && i == this.VL.size() + (-1);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView VM;
        TextView VN;
        CheckBox VO;
        View VP;

        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }
    }
}
