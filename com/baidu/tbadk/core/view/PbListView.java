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
    private View aGJ = null;
    private View baB = null;
    private int baC = 0;
    private String baD = null;
    private LinearLayout baE = null;
    private int mTextColor = 0;
    private int baF = d.C0108d.cp_cont_e;
    private int baG = d.C0108d.cp_bg_line_b;
    private ImageView baH = null;
    private LinearLayout baI = null;
    private boolean baJ = true;
    private int baK = 0;

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
        this.aGJ = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.baE = (LinearLayout) this.aGJ.findViewById(d.g.pb_more_view);
        this.rz = (TextView) this.aGJ.findViewById(d.g.pb_more_text);
        if (this.baJ) {
            this.baE.setVisibility(0);
        } else {
            this.baE.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aGJ.findViewById(d.g.progress);
        this.baH = (ImageView) this.aGJ.findViewById(d.g.pb_more_view_top_line);
        this.baB = this.aGJ.findViewById(d.g.empty_view);
        this.baI = (LinearLayout) this.aGJ.findViewById(d.g.pb_more_top_extra_view);
        return this.aGJ;
    }

    public void bq(boolean z) {
        this.baJ = z;
    }

    public void gt(int i) {
        this.baG = i;
    }

    public void DP() {
        this.baH.setVisibility(0);
    }

    public void DQ() {
        this.baH.setVisibility(8);
    }

    public void DR() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baH.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.baH.setLayoutParams(layoutParams);
    }

    public void DS() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baH.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1);
        this.baH.setLayoutParams(layoutParams);
    }

    public void gu(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baH.getLayoutParams();
        layoutParams.height = i;
        this.baH.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.rz.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, i));
    }

    public void DT() {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(this.mContext.getText(d.j.loading));
        gy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DU() {
        this.mProgressBar.setVisibility(8);
        if (this.baD != null) {
            this.rz.setText(this.baD);
        } else {
            this.rz.setText(this.mContext.getText(d.j.pb_load_more));
        }
        gy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DV() {
        this.rz.setVisibility(0);
        this.baE.setVisibility(0);
        DU();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(this.mContext.getText(d.j.loading));
    }

    public void gv(int i) {
        aj.s(this.baE, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baE.getLayoutParams());
        layoutParams.height = i;
        this.baE.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.baD = str;
        this.rz.setText(str);
        gy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void gw(int i) {
        this.baF = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aGJ);
        }
    }

    public void gx(int i) {
        this.baK = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void gy(int i) {
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
        if (z && this.baF != 0) {
            color = aj.getColor(this.baF);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.rz.setTextColor(color);
        }
        aj.c(this.baH, this.baG);
        if (this.baK == 0) {
            aj.s(this.baE, d.C0108d.cp_bg_line_d);
        } else if (this.baK > 0) {
            aj.s(this.baE, this.baK);
        }
        if (this.baC != 0) {
            aj.t(this.baB, this.baC);
        }
    }

    public void gz(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baB.getLayoutParams());
        layoutParams.height = i;
        this.baB.setLayoutParams(layoutParams);
        this.baB.setVisibility(0);
    }

    public void DW() {
        this.baB.setVisibility(8);
    }

    public void DX() {
        this.baI.setVisibility(0);
        this.baH.setVisibility(0);
        this.baE.setVisibility(0);
        this.rz.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        DW();
    }

    public void gA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.baB.getLayoutParams());
        layoutParams.height = i;
        this.baB.setLayoutParams(layoutParams);
        this.baB.setVisibility(0);
        this.baI.setVisibility(8);
        this.baH.setVisibility(8);
        this.baE.setVisibility(8);
        this.rz.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean DY() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
