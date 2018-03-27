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
    private View aHT = null;
    private View bcq = null;
    private int bcr = 0;
    private String bcs = null;
    private LinearLayout bct = null;
    private int mTextColor = 0;
    private int bcu = d.C0141d.cp_cont_e;
    private int bcv = d.C0141d.cp_bg_line_b;
    private ImageView bcw = null;
    private LinearLayout bcx = null;
    private boolean bcy = true;
    private int bcz = 0;

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
        this.aHT = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.bct = (LinearLayout) this.aHT.findViewById(d.g.pb_more_view);
        this.ry = (TextView) this.aHT.findViewById(d.g.pb_more_text);
        if (this.bcy) {
            this.bct.setVisibility(0);
        } else {
            this.bct.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aHT.findViewById(d.g.progress);
        this.bcw = (ImageView) this.aHT.findViewById(d.g.pb_more_view_top_line);
        this.bcq = this.aHT.findViewById(d.g.empty_view);
        this.bcx = (LinearLayout) this.aHT.findViewById(d.g.pb_more_top_extra_view);
        return this.aHT;
    }

    public void bv(boolean z) {
        this.bcy = z;
    }

    public void gs(int i) {
        this.bcv = i;
    }

    public void Ec() {
        this.bcw.setVisibility(0);
    }

    public void Ed() {
        this.bcw.setVisibility(8);
    }

    public void Ee() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcw.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.bcw.setLayoutParams(layoutParams);
    }

    public void Ef() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcw.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1);
        this.bcw.setLayoutParams(layoutParams);
    }

    public void gt(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcw.getLayoutParams();
        layoutParams.height = i;
        this.bcw.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.ry.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, i));
    }

    public void Eg() {
        this.mProgressBar.setVisibility(0);
        this.ry.setText(this.mContext.getText(d.j.loading));
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Eh() {
        this.mProgressBar.setVisibility(8);
        if (this.bcs != null) {
            this.ry.setText(this.bcs);
        } else {
            this.ry.setText(this.mContext.getText(d.j.pb_load_more));
        }
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Ei() {
        this.ry.setVisibility(0);
        this.bct.setVisibility(0);
        Eh();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.ry.setText(this.mContext.getText(d.j.loading));
    }

    public void gu(int i) {
        aj.s(this.bct, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bct.getLayoutParams());
        layoutParams.height = i;
        this.bct.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.bcs = str;
        this.ry.setText(str);
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void gv(int i) {
        this.bcu = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aHT);
        }
    }

    public void gw(int i) {
        this.bcz = i;
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
        if (z && this.bcu != 0) {
            color = aj.getColor(this.bcu);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.ry.setTextColor(color);
        }
        aj.c(this.bcw, this.bcv);
        if (this.bcz == 0) {
            aj.s(this.bct, d.C0141d.cp_bg_line_d);
        } else if (this.bcz > 0) {
            aj.s(this.bct, this.bcz);
        }
        if (this.bcr != 0) {
            aj.t(this.bcq, this.bcr);
        }
    }

    public void gy(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bcq.getLayoutParams());
        layoutParams.height = i;
        this.bcq.setLayoutParams(layoutParams);
        this.bcq.setVisibility(0);
    }

    public void Ej() {
        this.bcq.setVisibility(8);
    }

    public void Ek() {
        this.bcx.setVisibility(0);
        this.bcw.setVisibility(0);
        this.bct.setVisibility(0);
        this.ry.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        Ej();
    }

    public void gz(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bcq.getLayoutParams());
        layoutParams.height = i;
        this.bcq.setLayoutParams(layoutParams);
        this.bcq.setVisibility(0);
        this.bcx.setVisibility(8);
        this.bcw.setVisibility(8);
        this.bct.setVisibility(8);
        this.ry.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean El() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
