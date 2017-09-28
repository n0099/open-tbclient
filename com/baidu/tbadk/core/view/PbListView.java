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
    private TextView abv = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rt = null;
    private View alX = null;
    private int alY = 0;
    private String alZ = null;
    private LinearLayout ama = null;
    private int mTextColor = 0;
    private int amb = d.e.cp_cont_e;
    private int amc = d.e.cp_bg_line_b;
    private ImageView amd = null;
    private LinearLayout ame = null;
    private boolean amf = true;
    private int amg = 0;

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
    public View ld() {
        this.Rt = LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.ama = (LinearLayout) this.Rt.findViewById(d.h.pb_more_view);
        this.abv = (TextView) this.Rt.findViewById(d.h.pb_more_text);
        if (this.amf) {
            this.ama.setVisibility(0);
        } else {
            this.ama.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Rt.findViewById(d.h.progress);
        this.amd = (ImageView) this.Rt.findViewById(d.h.pb_more_view_top_line);
        this.alX = this.Rt.findViewById(d.h.empty_view);
        this.ame = (LinearLayout) this.Rt.findViewById(d.h.pb_more_top_extra_view);
        return this.Rt;
    }

    public void du(int i) {
        this.amc = i;
    }

    public void wp() {
        this.amd.setVisibility(0);
    }

    public void wq() {
        this.amd.setVisibility(8);
    }

    public void wr() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amd.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.amd.setLayoutParams(layoutParams);
    }

    public void ws() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amd.getLayoutParams();
        layoutParams.height = l.f(this.mContext, d.f.ds1);
        this.amd.setLayoutParams(layoutParams);
    }

    public void dv(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amd.getLayoutParams();
        layoutParams.height = i;
        this.amd.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.abv.setTextSize(0, l.f(this.mContext, i));
    }

    public void wt() {
        this.mProgressBar.setVisibility(0);
        this.abv.setText(this.mContext.getText(d.l.loading));
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wu() {
        this.mProgressBar.setVisibility(8);
        if (this.alZ != null) {
            this.abv.setText(this.alZ);
        } else {
            this.abv.setText(this.mContext.getText(d.l.pb_load_more));
        }
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wv() {
        setText(this.mContext.getResources().getString(d.l.list_no_more));
        wu();
    }

    public void ww() {
        this.abv.setVisibility(0);
        this.ama.setVisibility(0);
        wu();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.abv.setText(this.mContext.getText(d.l.loading));
    }

    public void dw(int i) {
        aj.j(this.ama, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ama.getLayoutParams());
        layoutParams.height = i;
        this.ama.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.alZ = str;
        this.abv.setText(str);
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dx(int i) {
        this.amb = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rt);
        }
    }

    public void dy(int i) {
        this.amg = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dz(int i) {
        int color;
        boolean z = false;
        String charSequence = this.abv.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.l.pb_load_more))) {
            color = aj.getColor(d.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.l.loading))) {
            color = aj.getColor(d.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.l.list_no_more)) || charSequence.equals(this.mContext.getText(d.l.list_has_no_more))) {
            color = aj.getColor(d.e.common_color_10005);
            z = true;
        } else {
            color = charSequence.equals(this.mContext.getText(d.l.list_no_more_new)) ? aj.getColor(d.e.cp_cont_e) : 0;
        }
        if (z && this.amb != 0) {
            color = aj.getColor(this.amb);
        }
        if (this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.abv.setTextColor(color);
        }
        aj.c(this.amd, this.amc);
        if (this.amg == 0) {
            aj.j(this.ama, d.e.cp_bg_line_d);
        } else if (this.amg > 0) {
            aj.j(this.ama, this.amg);
        }
        if (this.alY != 0) {
            aj.k(this.alX, this.alY);
        }
    }

    public void dA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alX.getLayoutParams());
        layoutParams.height = i;
        this.alX.setLayoutParams(layoutParams);
        this.alX.setVisibility(0);
    }

    public void dB(int i) {
        this.alY = i;
    }

    public void wx() {
        this.alX.setVisibility(8);
    }

    public void wy() {
        this.ame.setVisibility(0);
        this.amd.setVisibility(0);
        this.ama.setVisibility(0);
        this.abv.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wx();
    }

    public void dC(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alX.getLayoutParams());
        layoutParams.height = i;
        this.alX.setLayoutParams(layoutParams);
        this.alX.setVisibility(0);
        this.ame.setVisibility(8);
        this.amd.setVisibility(8);
        this.ama.setVisibility(8);
        this.abv.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wz() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
