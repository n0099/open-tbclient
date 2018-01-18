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
    private View aGH = null;
    private View baA = null;
    private int baB = 0;
    private String baC = null;
    private LinearLayout baD = null;
    private int mTextColor = 0;
    private int baE = d.C0107d.cp_cont_e;
    private int baF = d.C0107d.cp_bg_line_b;
    private ImageView baG = null;
    private LinearLayout baH = null;
    private boolean baI = true;
    private int baJ = 0;

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
    public View su() {
        this.aGH = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.baD = (LinearLayout) this.aGH.findViewById(d.g.pb_more_view);
        this.rz = (TextView) this.aGH.findViewById(d.g.pb_more_text);
        if (this.baI) {
            this.baD.setVisibility(0);
        } else {
            this.baD.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aGH.findViewById(d.g.progress);
        this.baG = (ImageView) this.aGH.findViewById(d.g.pb_more_view_top_line);
        this.baA = this.aGH.findViewById(d.g.empty_view);
        this.baH = (LinearLayout) this.aGH.findViewById(d.g.pb_more_top_extra_view);
        return this.aGH;
    }

    public void bq(boolean z) {
        this.baI = z;
    }

    public void gq(int i) {
        this.baF = i;
    }

    public void DG() {
        this.baG.setVisibility(0);
    }

    public void DH() {
        this.baG.setVisibility(8);
    }

    public void DI() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baG.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.baG.setLayoutParams(layoutParams);
    }

    public void DJ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baG.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1);
        this.baG.setLayoutParams(layoutParams);
    }

    public void gr(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baG.getLayoutParams();
        layoutParams.height = i;
        this.baG.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.rz.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, i));
    }

    public void DK() {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(this.mContext.getText(d.j.loading));
        gv(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DL() {
        this.mProgressBar.setVisibility(8);
        if (this.baC != null) {
            this.rz.setText(this.baC);
        } else {
            this.rz.setText(this.mContext.getText(d.j.pb_load_more));
        }
        gv(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DM() {
        this.rz.setVisibility(0);
        this.baD.setVisibility(0);
        DL();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(this.mContext.getText(d.j.loading));
    }

    public void gs(int i) {
        aj.s(this.baD, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baD.getLayoutParams());
        layoutParams.height = i;
        this.baD.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.baC = str;
        this.rz.setText(str);
        gv(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void gt(int i) {
        this.baE = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aGH);
        }
    }

    public void gu(int i) {
        this.baJ = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void gv(int i) {
        int color;
        boolean z = false;
        String charSequence = this.rz.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = aj.getColor(d.C0107d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = aj.getColor(d.C0107d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = aj.getColor(d.C0107d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more_new))) {
            color = aj.getColor(d.C0107d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_click_load_more)) ? aj.getColor(d.C0107d.cp_cont_d) : 0;
        }
        if (z && this.baE != 0) {
            color = aj.getColor(this.baE);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.rz.setTextColor(color);
        }
        aj.c(this.baG, this.baF);
        if (this.baJ == 0) {
            aj.s(this.baD, d.C0107d.cp_bg_line_d);
        } else if (this.baJ > 0) {
            aj.s(this.baD, this.baJ);
        }
        if (this.baB != 0) {
            aj.t(this.baA, this.baB);
        }
    }

    public void gw(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baA.getLayoutParams());
        layoutParams.height = i;
        this.baA.setLayoutParams(layoutParams);
        this.baA.setVisibility(0);
    }

    public void DN() {
        this.baA.setVisibility(8);
    }

    public void DO() {
        this.baH.setVisibility(0);
        this.baG.setVisibility(0);
        this.baD.setVisibility(0);
        this.rz.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        DN();
    }

    public void gx(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baA.getLayoutParams());
        layoutParams.height = i;
        this.baA.setLayoutParams(layoutParams);
        this.baA.setVisibility(0);
        this.baH.setVisibility(8);
        this.baG.setVisibility(8);
        this.baD.setVisibility(8);
        this.rz.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean DP() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
