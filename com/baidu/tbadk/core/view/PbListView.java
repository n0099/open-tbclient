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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView abZ = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sh = null;
    private View amC = null;
    private int amD = 0;
    private String amE = null;
    private LinearLayout amF = null;
    private int mTextColor = 0;
    private int amG = d.C0082d.cp_cont_e;
    private int amH = d.C0082d.cp_bg_line_b;
    private ImageView amI = null;
    private LinearLayout amJ = null;
    private boolean amK = true;
    private int amL = 0;

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
    public View kX() {
        this.Sh = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.amF = (LinearLayout) this.Sh.findViewById(d.g.pb_more_view);
        this.abZ = (TextView) this.Sh.findViewById(d.g.pb_more_text);
        if (this.amK) {
            this.amF.setVisibility(0);
        } else {
            this.amF.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Sh.findViewById(d.g.progress);
        this.amI = (ImageView) this.Sh.findViewById(d.g.pb_more_view_top_line);
        this.amC = this.Sh.findViewById(d.g.empty_view);
        this.amJ = (LinearLayout) this.Sh.findViewById(d.g.pb_more_top_extra_view);
        return this.Sh;
    }

    public void du(int i) {
        this.amH = i;
    }

    public void wt() {
        this.amI.setVisibility(0);
    }

    public void wu() {
        this.amI.setVisibility(8);
    }

    public void wv() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amI.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.amI.setLayoutParams(layoutParams);
    }

    public void ww() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amI.getLayoutParams();
        layoutParams.height = l.f(this.mContext, d.e.ds1);
        this.amI.setLayoutParams(layoutParams);
    }

    public void dv(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amI.getLayoutParams();
        layoutParams.height = i;
        this.amI.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.abZ.setTextSize(0, l.f(this.mContext, i));
    }

    public void wx() {
        this.mProgressBar.setVisibility(0);
        this.abZ.setText(this.mContext.getText(d.j.loading));
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wy() {
        this.mProgressBar.setVisibility(8);
        if (this.amE != null) {
            this.abZ.setText(this.amE);
        } else {
            this.abZ.setText(this.mContext.getText(d.j.pb_load_more));
        }
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wz() {
        this.abZ.setVisibility(0);
        this.amF.setVisibility(0);
        wy();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.abZ.setText(this.mContext.getText(d.j.loading));
    }

    public void dw(int i) {
        aj.j(this.amF, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amF.getLayoutParams());
        layoutParams.height = i;
        this.amF.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.amE = str;
        this.abZ.setText(str);
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dx(int i) {
        this.amG = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Sh);
        }
    }

    public void dy(int i) {
        this.amL = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dz(int i) {
        int color;
        boolean z = false;
        String charSequence = this.abZ.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = aj.getColor(d.C0082d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = aj.getColor(d.C0082d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = aj.getColor(d.C0082d.common_color_10005);
            z = true;
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_no_more_new)) ? aj.getColor(d.C0082d.cp_cont_e) : 0;
        }
        if (z && this.amG != 0) {
            color = aj.getColor(this.amG);
        }
        if (this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.abZ.setTextColor(color);
        }
        aj.c(this.amI, this.amH);
        if (this.amL == 0) {
            aj.j(this.amF, d.C0082d.cp_bg_line_d);
        } else if (this.amL > 0) {
            aj.j(this.amF, this.amL);
        }
        if (this.amD != 0) {
            aj.k(this.amC, this.amD);
        }
    }

    public void dA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amC.getLayoutParams());
        layoutParams.height = i;
        this.amC.setLayoutParams(layoutParams);
        this.amC.setVisibility(0);
    }

    public void dB(int i) {
        this.amD = i;
    }

    public void wA() {
        this.amC.setVisibility(8);
    }

    public void wB() {
        this.amJ.setVisibility(0);
        this.amI.setVisibility(0);
        this.amF.setVisibility(0);
        this.abZ.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wA();
    }

    public void dC(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amC.getLayoutParams());
        layoutParams.height = i;
        this.amC.setLayoutParams(layoutParams);
        this.amC.setVisibility(0);
        this.amJ.setVisibility(8);
        this.amI.setVisibility(8);
        this.amF.setVisibility(8);
        this.abZ.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wC() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
