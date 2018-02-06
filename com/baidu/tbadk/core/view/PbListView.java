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
    private TextView rz = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View aId = null;
    private View bcA = null;
    private int bcB = 0;
    private String bcC = null;
    private LinearLayout bcD = null;
    private int mTextColor = 0;
    private int bcE = d.C0140d.cp_cont_e;
    private int bcF = d.C0140d.cp_bg_line_b;
    private ImageView bcG = null;
    private LinearLayout bcH = null;
    private boolean bcI = true;
    private int bcJ = 0;

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
        this.aId = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.bcD = (LinearLayout) this.aId.findViewById(d.g.pb_more_view);
        this.rz = (TextView) this.aId.findViewById(d.g.pb_more_text);
        if (this.bcI) {
            this.bcD.setVisibility(0);
        } else {
            this.bcD.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aId.findViewById(d.g.progress);
        this.bcG = (ImageView) this.aId.findViewById(d.g.pb_more_view_top_line);
        this.bcA = this.aId.findViewById(d.g.empty_view);
        this.bcH = (LinearLayout) this.aId.findViewById(d.g.pb_more_top_extra_view);
        return this.aId;
    }

    public void bv(boolean z) {
        this.bcI = z;
    }

    public void gs(int i) {
        this.bcF = i;
    }

    public void Ec() {
        this.bcG.setVisibility(0);
    }

    public void Ed() {
        this.bcG.setVisibility(8);
    }

    public void Ee() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcG.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.bcG.setLayoutParams(layoutParams);
    }

    public void Ef() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcG.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1);
        this.bcG.setLayoutParams(layoutParams);
    }

    public void gt(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcG.getLayoutParams();
        layoutParams.height = i;
        this.bcG.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.rz.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, i));
    }

    public void Eg() {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(this.mContext.getText(d.j.loading));
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Eh() {
        this.mProgressBar.setVisibility(8);
        if (this.bcC != null) {
            this.rz.setText(this.bcC);
        } else {
            this.rz.setText(this.mContext.getText(d.j.pb_load_more));
        }
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Ei() {
        this.rz.setVisibility(0);
        this.bcD.setVisibility(0);
        Eh();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(this.mContext.getText(d.j.loading));
    }

    public void gu(int i) {
        aj.s(this.bcD, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bcD.getLayoutParams());
        layoutParams.height = i;
        this.bcD.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.bcC = str;
        this.rz.setText(str);
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void gv(int i) {
        this.bcE = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aId);
        }
    }

    public void gw(int i) {
        this.bcJ = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void gx(int i) {
        int color;
        boolean z = false;
        String charSequence = this.rz.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = aj.getColor(d.C0140d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = aj.getColor(d.C0140d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = aj.getColor(d.C0140d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more_new))) {
            color = aj.getColor(d.C0140d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_click_load_more)) ? aj.getColor(d.C0140d.cp_cont_d) : 0;
        }
        if (z && this.bcE != 0) {
            color = aj.getColor(this.bcE);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.rz.setTextColor(color);
        }
        aj.c(this.bcG, this.bcF);
        if (this.bcJ == 0) {
            aj.s(this.bcD, d.C0140d.cp_bg_line_d);
        } else if (this.bcJ > 0) {
            aj.s(this.bcD, this.bcJ);
        }
        if (this.bcB != 0) {
            aj.t(this.bcA, this.bcB);
        }
    }

    public void gy(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bcA.getLayoutParams());
        layoutParams.height = i;
        this.bcA.setLayoutParams(layoutParams);
        this.bcA.setVisibility(0);
    }

    public void Ej() {
        this.bcA.setVisibility(8);
    }

    public void Ek() {
        this.bcH.setVisibility(0);
        this.bcG.setVisibility(0);
        this.bcD.setVisibility(0);
        this.rz.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        Ej();
    }

    public void gz(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bcA.getLayoutParams());
        layoutParams.height = i;
        this.bcA.setLayoutParams(layoutParams);
        this.bcA.setVisibility(0);
        this.bcH.setVisibility(8);
        this.bcG.setVisibility(8);
        this.bcD.setVisibility(8);
        this.rz.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean El() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
