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
    private TextView abE = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Ry = null;
    private View amg = null;
    private int amh = 0;
    private String ami = null;
    private LinearLayout amj = null;
    private int mTextColor = 0;
    private int amk = d.C0080d.cp_cont_e;
    private int aml = d.C0080d.cp_bg_line_b;
    private ImageView amm = null;
    private LinearLayout amn = null;
    private boolean amo = true;
    private int amp = 0;

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
        this.Ry = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.amj = (LinearLayout) this.Ry.findViewById(d.g.pb_more_view);
        this.abE = (TextView) this.Ry.findViewById(d.g.pb_more_text);
        if (this.amo) {
            this.amj.setVisibility(0);
        } else {
            this.amj.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Ry.findViewById(d.g.progress);
        this.amm = (ImageView) this.Ry.findViewById(d.g.pb_more_view_top_line);
        this.amg = this.Ry.findViewById(d.g.empty_view);
        this.amn = (LinearLayout) this.Ry.findViewById(d.g.pb_more_top_extra_view);
        return this.Ry;
    }

    public void dt(int i) {
        this.aml = i;
    }

    public void wp() {
        this.amm.setVisibility(0);
    }

    public void wq() {
        this.amm.setVisibility(8);
    }

    public void wr() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amm.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.amm.setLayoutParams(layoutParams);
    }

    public void ws() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amm.getLayoutParams();
        layoutParams.height = l.f(this.mContext, d.e.ds1);
        this.amm.setLayoutParams(layoutParams);
    }

    public void du(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amm.getLayoutParams();
        layoutParams.height = i;
        this.amm.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.abE.setTextSize(0, l.f(this.mContext, i));
    }

    public void wt() {
        this.mProgressBar.setVisibility(0);
        this.abE.setText(this.mContext.getText(d.j.loading));
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wu() {
        this.mProgressBar.setVisibility(8);
        if (this.ami != null) {
            this.abE.setText(this.ami);
        } else {
            this.abE.setText(this.mContext.getText(d.j.pb_load_more));
        }
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wv() {
        setText(this.mContext.getResources().getString(d.j.list_no_more));
        wu();
    }

    public void ww() {
        this.abE.setVisibility(0);
        this.amj.setVisibility(0);
        wu();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.abE.setText(this.mContext.getText(d.j.loading));
    }

    public void dv(int i) {
        aj.j(this.amj, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amj.getLayoutParams());
        layoutParams.height = i;
        this.amj.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.ami = str;
        this.abE.setText(str);
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dw(int i) {
        this.amk = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Ry);
        }
    }

    public void dx(int i) {
        this.amp = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dy(int i) {
        int color;
        boolean z = false;
        String charSequence = this.abE.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = aj.getColor(d.C0080d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = aj.getColor(d.C0080d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = aj.getColor(d.C0080d.common_color_10005);
            z = true;
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_no_more_new)) ? aj.getColor(d.C0080d.cp_cont_e) : 0;
        }
        if (z && this.amk != 0) {
            color = aj.getColor(this.amk);
        }
        if (this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.abE.setTextColor(color);
        }
        aj.c(this.amm, this.aml);
        if (this.amp == 0) {
            aj.j(this.amj, d.C0080d.cp_bg_line_d);
        } else if (this.amp > 0) {
            aj.j(this.amj, this.amp);
        }
        if (this.amh != 0) {
            aj.k(this.amg, this.amh);
        }
    }

    public void dz(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amg.getLayoutParams());
        layoutParams.height = i;
        this.amg.setLayoutParams(layoutParams);
        this.amg.setVisibility(0);
    }

    public void dA(int i) {
        this.amh = i;
    }

    public void wx() {
        this.amg.setVisibility(8);
    }

    public void wy() {
        this.amn.setVisibility(0);
        this.amm.setVisibility(0);
        this.amj.setVisibility(0);
        this.abE.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wx();
    }

    public void dB(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amg.getLayoutParams());
        layoutParams.height = i;
        this.amg.setLayoutParams(layoutParams);
        this.amg.setVisibility(0);
        this.amn.setVisibility(8);
        this.amm.setVisibility(8);
        this.amj.setVisibility(8);
        this.abE.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wz() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
