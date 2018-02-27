package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView ry = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View aHS = null;
    private View bco = null;
    private int bcp = 0;
    private String bcq = null;
    private LinearLayout bcr = null;
    private int mTextColor = 0;
    private int bcs = d.C0141d.cp_cont_e;
    private int bct = d.C0141d.cp_bg_line_b;
    private ImageView bcu = null;
    private LinearLayout bcv = null;
    private boolean bcw = true;
    private int bcx = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View st() {
        this.aHS = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.bcr = (LinearLayout) this.aHS.findViewById(d.g.pb_more_view);
        this.ry = (TextView) this.aHS.findViewById(d.g.pb_more_text);
        if (this.bcw) {
            this.bcr.setVisibility(0);
        } else {
            this.bcr.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aHS.findViewById(d.g.progress);
        this.bcu = (ImageView) this.aHS.findViewById(d.g.pb_more_view_top_line);
        this.bco = this.aHS.findViewById(d.g.empty_view);
        this.bcv = (LinearLayout) this.aHS.findViewById(d.g.pb_more_top_extra_view);
        return this.aHS;
    }

    public void bv(boolean z) {
        this.bcw = z;
    }

    public void gs(int i) {
        this.bct = i;
    }

    public void Eb() {
        this.bcu.setVisibility(0);
    }

    public void Ec() {
        this.bcu.setVisibility(8);
    }

    public void Ed() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcu.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.bcu.setLayoutParams(layoutParams);
    }

    public void Ee() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcu.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1);
        this.bcu.setLayoutParams(layoutParams);
    }

    public void gt(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcu.getLayoutParams();
        layoutParams.height = i;
        this.bcu.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.ry.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, i));
    }

    public void Ef() {
        this.mProgressBar.setVisibility(0);
        this.ry.setText(this.mContext.getText(d.j.loading));
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Eg() {
        this.mProgressBar.setVisibility(8);
        if (this.bcq != null) {
            this.ry.setText(this.bcq);
        } else {
            this.ry.setText(this.mContext.getText(d.j.pb_load_more));
        }
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Eh() {
        this.ry.setVisibility(0);
        this.bcr.setVisibility(0);
        Eg();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.ry.setText(this.mContext.getText(d.j.loading));
    }

    public void gu(int i) {
        aj.s(this.bcr, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bcr.getLayoutParams());
        layoutParams.height = i;
        this.bcr.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.bcq = str;
        this.ry.setText(str);
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void gv(int i) {
        this.bcs = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aHS);
        }
    }

    public void gw(int i) {
        this.bcx = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void gx(int i) {
        int color;
        boolean z = false;
        String charSequence = this.ry.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = aj.getColor(d.C0141d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = aj.getColor(d.C0141d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = aj.getColor(d.C0141d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more_new))) {
            color = aj.getColor(d.C0141d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_click_load_more)) ? aj.getColor(d.C0141d.cp_cont_d) : 0;
        }
        if (z && this.bcs != 0) {
            color = aj.getColor(this.bcs);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.ry.setTextColor(color);
        }
        aj.c(this.bcu, this.bct);
        if (this.bcx == 0) {
            aj.s(this.bcr, d.C0141d.cp_bg_line_d);
        } else if (this.bcx > 0) {
            aj.s(this.bcr, this.bcx);
        }
        if (this.bcp != 0) {
            aj.t(this.bco, this.bcp);
        }
    }

    public void gy(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bco.getLayoutParams());
        layoutParams.height = i;
        this.bco.setLayoutParams(layoutParams);
        this.bco.setVisibility(0);
    }

    public void Ei() {
        this.bco.setVisibility(8);
    }

    public void Ej() {
        this.bcv.setVisibility(0);
        this.bcu.setVisibility(0);
        this.bcr.setVisibility(0);
        this.ry.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        Ei();
    }

    public void gz(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bco.getLayoutParams());
        layoutParams.height = i;
        this.bco.setLayoutParams(layoutParams);
        this.bco.setVisibility(0);
        this.bcv.setVisibility(8);
        this.bcu.setVisibility(8);
        this.bcr.setVisibility(8);
        this.ry.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean Ek() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
