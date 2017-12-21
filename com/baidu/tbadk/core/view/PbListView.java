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
    private TextView abW = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sf = null;
    private View amC = null;
    private int amD = 0;
    private String amE = null;
    private LinearLayout amF = null;
    private int mTextColor = 0;
    private int amG = d.C0095d.cp_cont_e;
    private int amH = d.C0095d.cp_bg_line_b;
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
        this.Sf = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.amF = (LinearLayout) this.Sf.findViewById(d.g.pb_more_view);
        this.abW = (TextView) this.Sf.findViewById(d.g.pb_more_text);
        if (this.amK) {
            this.amF.setVisibility(0);
        } else {
            this.amF.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Sf.findViewById(d.g.progress);
        this.amI = (ImageView) this.Sf.findViewById(d.g.pb_more_view_top_line);
        this.amC = this.Sf.findViewById(d.g.empty_view);
        this.amJ = (LinearLayout) this.Sf.findViewById(d.g.pb_more_top_extra_view);
        return this.Sf;
    }

    public void aK(boolean z) {
        this.amK = z;
    }

    public void du(int i) {
        this.amH = i;
    }

    public void wr() {
        this.amI.setVisibility(0);
    }

    public void ws() {
        this.amI.setVisibility(8);
    }

    public void wt() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amI.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.amI.setLayoutParams(layoutParams);
    }

    public void wu() {
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
        this.abW.setTextSize(0, l.f(this.mContext, i));
    }

    public void wv() {
        this.mProgressBar.setVisibility(0);
        this.abW.setText(this.mContext.getText(d.j.loading));
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ww() {
        this.mProgressBar.setVisibility(8);
        if (this.amE != null) {
            this.abW.setText(this.amE);
        } else {
            this.abW.setText(this.mContext.getText(d.j.pb_load_more));
        }
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wx() {
        this.abW.setVisibility(0);
        this.amF.setVisibility(0);
        ww();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.abW.setText(this.mContext.getText(d.j.loading));
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
        this.abW.setText(str);
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
            this.mOnClickListener.onClick(this.Sf);
        }
    }

    public void dy(int i) {
        this.amL = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dz(int i) {
        int color;
        boolean z = false;
        String charSequence = this.abW.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = aj.getColor(d.C0095d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = aj.getColor(d.C0095d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = aj.getColor(d.C0095d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more_new))) {
            color = aj.getColor(d.C0095d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_click_load_more)) ? aj.getColor(d.C0095d.cp_cont_d) : 0;
        }
        if (z && this.amG != 0) {
            color = aj.getColor(this.amG);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.abW.setTextColor(color);
        }
        aj.c(this.amI, this.amH);
        if (this.amL == 0) {
            aj.j(this.amF, d.C0095d.cp_bg_line_d);
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

    public void wy() {
        this.amC.setVisibility(8);
    }

    public void wz() {
        this.amJ.setVisibility(0);
        this.amI.setVisibility(0);
        this.amF.setVisibility(0);
        this.abW.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wy();
    }

    public void dC(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amC.getLayoutParams());
        layoutParams.height = i;
        this.amC.setLayoutParams(layoutParams);
        this.amC.setVisibility(0);
        this.amJ.setVisibility(8);
        this.amI.setVisibility(8);
        this.amF.setVisibility(8);
        this.abW.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wA() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
