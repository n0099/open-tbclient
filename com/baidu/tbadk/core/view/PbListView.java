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
    private View aGK = null;
    private View baI = null;
    private int baJ = 0;
    private String baK = null;
    private LinearLayout baL = null;
    private int mTextColor = 0;
    private int baM = d.C0108d.cp_cont_e;
    private int baN = d.C0108d.cp_bg_line_b;
    private ImageView baO = null;
    private LinearLayout baP = null;
    private boolean baQ = true;
    private int baR = 0;

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
    public View sv() {
        this.aGK = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.baL = (LinearLayout) this.aGK.findViewById(d.g.pb_more_view);
        this.rz = (TextView) this.aGK.findViewById(d.g.pb_more_text);
        if (this.baQ) {
            this.baL.setVisibility(0);
        } else {
            this.baL.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aGK.findViewById(d.g.progress);
        this.baO = (ImageView) this.aGK.findViewById(d.g.pb_more_view_top_line);
        this.baI = this.aGK.findViewById(d.g.empty_view);
        this.baP = (LinearLayout) this.aGK.findViewById(d.g.pb_more_top_extra_view);
        return this.aGK;
    }

    public void br(boolean z) {
        this.baQ = z;
    }

    public void gq(int i) {
        this.baN = i;
    }

    public void DI() {
        this.baO.setVisibility(0);
    }

    public void DJ() {
        this.baO.setVisibility(8);
    }

    public void DK() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baO.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.baO.setLayoutParams(layoutParams);
    }

    public void DL() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baO.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1);
        this.baO.setLayoutParams(layoutParams);
    }

    public void gr(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baO.getLayoutParams();
        layoutParams.height = i;
        this.baO.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.rz.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, i));
    }

    public void DM() {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(this.mContext.getText(d.j.loading));
        gv(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DN() {
        this.mProgressBar.setVisibility(8);
        if (this.baK != null) {
            this.rz.setText(this.baK);
        } else {
            this.rz.setText(this.mContext.getText(d.j.pb_load_more));
        }
        gv(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DO() {
        this.rz.setVisibility(0);
        this.baL.setVisibility(0);
        DN();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(this.mContext.getText(d.j.loading));
    }

    public void gs(int i) {
        aj.s(this.baL, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baL.getLayoutParams());
        layoutParams.height = i;
        this.baL.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.baK = str;
        this.rz.setText(str);
        gv(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void gt(int i) {
        this.baM = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aGK);
        }
    }

    public void gu(int i) {
        this.baR = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void gv(int i) {
        int color;
        boolean z = false;
        String charSequence = this.rz.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = aj.getColor(d.C0108d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = aj.getColor(d.C0108d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = aj.getColor(d.C0108d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more_new))) {
            color = aj.getColor(d.C0108d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_click_load_more)) ? aj.getColor(d.C0108d.cp_cont_d) : 0;
        }
        if (z && this.baM != 0) {
            color = aj.getColor(this.baM);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.rz.setTextColor(color);
        }
        aj.c(this.baO, this.baN);
        if (this.baR == 0) {
            aj.s(this.baL, d.C0108d.cp_bg_line_d);
        } else if (this.baR > 0) {
            aj.s(this.baL, this.baR);
        }
        if (this.baJ != 0) {
            aj.t(this.baI, this.baJ);
        }
    }

    public void gw(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baI.getLayoutParams());
        layoutParams.height = i;
        this.baI.setLayoutParams(layoutParams);
        this.baI.setVisibility(0);
    }

    public void DP() {
        this.baI.setVisibility(8);
    }

    public void DQ() {
        this.baP.setVisibility(0);
        this.baO.setVisibility(0);
        this.baL.setVisibility(0);
        this.rz.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        DP();
    }

    public void gx(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baI.getLayoutParams());
        layoutParams.height = i;
        this.baI.setLayoutParams(layoutParams);
        this.baI.setVisibility(0);
        this.baP.setVisibility(8);
        this.baO.setVisibility(8);
        this.baL.setVisibility(8);
        this.rz.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean DR() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
