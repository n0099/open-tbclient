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
    private TextView abu = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rh = null;
    private View amR = null;
    private String amS = null;
    private LinearLayout amT = null;
    private int mTextColor = 0;
    private int amU = d.e.cp_bg_line_b;
    private ImageView amV = null;
    private LinearLayout amW = null;
    private boolean amX = true;
    private int amY = 0;

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
    public View lb() {
        this.Rh = LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.amT = (LinearLayout) this.Rh.findViewById(d.h.pb_more_view);
        this.abu = (TextView) this.Rh.findViewById(d.h.pb_more_text);
        if (this.amX) {
            this.amT.setVisibility(0);
        } else {
            this.amT.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Rh.findViewById(d.h.progress);
        this.amV = (ImageView) this.Rh.findViewById(d.h.pb_more_view_top_line);
        this.amR = this.Rh.findViewById(d.h.empty_view);
        this.amW = (LinearLayout) this.Rh.findViewById(d.h.pb_more_top_extra_view);
        return this.Rh;
    }

    public void wR() {
        this.amV.setVisibility(0);
    }

    public void wS() {
        this.amV.setVisibility(8);
    }

    public void wT() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amV.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.amV.setLayoutParams(layoutParams);
    }

    public void wU() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amV.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds1);
        this.amV.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.abu.setTextSize(0, com.baidu.adp.lib.util.k.f(this.mContext, i));
    }

    public void wV() {
        this.mProgressBar.setVisibility(0);
        this.abu.setText(this.mContext.getText(d.l.loading));
        dq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wW() {
        this.mProgressBar.setVisibility(8);
        if (this.amS != null) {
            this.abu.setText(this.amS);
        } else {
            this.abu.setText(this.mContext.getText(d.l.pb_load_more));
        }
        dq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wX() {
        this.abu.setVisibility(0);
        this.amT.setVisibility(0);
        wW();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.abu.setText(this.mContext.getText(d.l.loading));
    }

    /* renamed from: do  reason: not valid java name */
    public void m10do(int i) {
        aj.j(this.amT, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amT.getLayoutParams());
        layoutParams.height = i;
        this.amT.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.amS = str;
        this.abu.setText(str);
        dq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rh);
        }
    }

    public void dp(int i) {
        this.amY = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dq(int i) {
        String charSequence = this.abu.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(d.l.pb_load_more))) {
            i2 = aj.getColor(d.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.l.loading))) {
            i2 = aj.getColor(d.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.l.list_no_more))) {
            i2 = aj.getColor(d.e.common_color_10005);
        } else if (charSequence.equals(this.mContext.getText(d.l.list_no_more_new))) {
            i2 = aj.getColor(d.e.cp_cont_e);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.abu.setTextColor(i2);
        }
        aj.c(this.amV, this.amU);
        if (this.amY == 0) {
            aj.j(this.amT, d.e.cp_bg_line_d);
        } else if (this.amY > 0) {
            aj.j(this.amT, this.amY);
        }
    }

    public void dr(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amR.getLayoutParams());
        layoutParams.height = i;
        this.amR.setLayoutParams(layoutParams);
        this.amR.setVisibility(0);
    }

    public void wY() {
        this.amR.setVisibility(8);
    }

    public void wZ() {
        this.amW.setVisibility(0);
        this.amV.setVisibility(0);
        this.amT.setVisibility(0);
        this.abu.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wY();
    }

    public void ds(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amR.getLayoutParams());
        layoutParams.height = i;
        this.amR.setLayoutParams(layoutParams);
        this.amR.setVisibility(0);
        this.amW.setVisibility(8);
        this.amV.setVisibility(8);
        this.amT.setVisibility(8);
        this.abu.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean xa() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
