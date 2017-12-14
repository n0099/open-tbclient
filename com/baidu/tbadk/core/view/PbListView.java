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
    private TextView abT = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Se = null;
    private View amz = null;
    private int amA = 0;
    private String amB = null;
    private LinearLayout amC = null;
    private int mTextColor = 0;
    private int amD = d.C0096d.cp_cont_e;
    private int amE = d.C0096d.cp_bg_line_b;
    private ImageView amF = null;
    private LinearLayout amG = null;
    private boolean amH = true;
    private int amI = 0;

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
        this.Se = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.amC = (LinearLayout) this.Se.findViewById(d.g.pb_more_view);
        this.abT = (TextView) this.Se.findViewById(d.g.pb_more_text);
        if (this.amH) {
            this.amC.setVisibility(0);
        } else {
            this.amC.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Se.findViewById(d.g.progress);
        this.amF = (ImageView) this.Se.findViewById(d.g.pb_more_view_top_line);
        this.amz = this.Se.findViewById(d.g.empty_view);
        this.amG = (LinearLayout) this.Se.findViewById(d.g.pb_more_top_extra_view);
        return this.Se;
    }

    public void aK(boolean z) {
        this.amH = z;
    }

    public void du(int i) {
        this.amE = i;
    }

    public void wr() {
        this.amF.setVisibility(0);
    }

    public void ws() {
        this.amF.setVisibility(8);
    }

    public void wt() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amF.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.amF.setLayoutParams(layoutParams);
    }

    public void wu() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amF.getLayoutParams();
        layoutParams.height = l.f(this.mContext, d.e.ds1);
        this.amF.setLayoutParams(layoutParams);
    }

    public void dv(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amF.getLayoutParams();
        layoutParams.height = i;
        this.amF.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.abT.setTextSize(0, l.f(this.mContext, i));
    }

    public void wv() {
        this.mProgressBar.setVisibility(0);
        this.abT.setText(this.mContext.getText(d.j.loading));
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ww() {
        this.mProgressBar.setVisibility(8);
        if (this.amB != null) {
            this.abT.setText(this.amB);
        } else {
            this.abT.setText(this.mContext.getText(d.j.pb_load_more));
        }
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wx() {
        this.abT.setVisibility(0);
        this.amC.setVisibility(0);
        ww();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.abT.setText(this.mContext.getText(d.j.loading));
    }

    public void dw(int i) {
        aj.j(this.amC, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amC.getLayoutParams());
        layoutParams.height = i;
        this.amC.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.amB = str;
        this.abT.setText(str);
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dx(int i) {
        this.amD = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Se);
        }
    }

    public void dy(int i) {
        this.amI = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dz(int i) {
        int color;
        boolean z = false;
        String charSequence = this.abT.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = aj.getColor(d.C0096d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = aj.getColor(d.C0096d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = aj.getColor(d.C0096d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more_new))) {
            color = aj.getColor(d.C0096d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_click_load_more)) ? aj.getColor(d.C0096d.cp_cont_d) : 0;
        }
        if (z && this.amD != 0) {
            color = aj.getColor(this.amD);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.abT.setTextColor(color);
        }
        aj.c(this.amF, this.amE);
        if (this.amI == 0) {
            aj.j(this.amC, d.C0096d.cp_bg_line_d);
        } else if (this.amI > 0) {
            aj.j(this.amC, this.amI);
        }
        if (this.amA != 0) {
            aj.k(this.amz, this.amA);
        }
    }

    public void dA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amz.getLayoutParams());
        layoutParams.height = i;
        this.amz.setLayoutParams(layoutParams);
        this.amz.setVisibility(0);
    }

    public void dB(int i) {
        this.amA = i;
    }

    public void wy() {
        this.amz.setVisibility(8);
    }

    public void wz() {
        this.amG.setVisibility(0);
        this.amF.setVisibility(0);
        this.amC.setVisibility(0);
        this.abT.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wy();
    }

    public void dC(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amz.getLayoutParams());
        layoutParams.height = i;
        this.amz.setLayoutParams(layoutParams);
        this.amz.setVisibility(0);
        this.amG.setVisibility(8);
        this.amF.setVisibility(8);
        this.amC.setVisibility(8);
        this.abT.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wA() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
