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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sf = null;
    private View anz = null;
    private String anA = null;
    private LinearLayout anB = null;
    private int mTextColor = 0;
    private int anC = d.e.cp_bg_line_b;
    private ImageView anD = null;
    private LinearLayout anE = null;
    private boolean anF = true;
    private int anG = 0;

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
    public View lk() {
        this.Sf = LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.anB = (LinearLayout) this.Sf.findViewById(d.h.pb_more_view);
        this.mTextView = (TextView) this.Sf.findViewById(d.h.pb_more_text);
        if (this.anF) {
            this.anB.setVisibility(0);
        } else {
            this.anB.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Sf.findViewById(d.h.progress);
        this.anD = (ImageView) this.Sf.findViewById(d.h.pb_more_view_top_line);
        this.anz = this.Sf.findViewById(d.h.empty_view);
        this.anE = (LinearLayout) this.Sf.findViewById(d.h.pb_more_top_extra_view);
        return this.Sf;
    }

    public void wS() {
        this.anD.setVisibility(0);
    }

    public void wT() {
        this.anD.setVisibility(8);
    }

    public void wU() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anD.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.anD.setLayoutParams(layoutParams);
    }

    public void wV() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anD.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1);
        this.anD.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void wW() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.l.loading));
        dp(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wX() {
        this.mProgressBar.setVisibility(8);
        if (this.anA != null) {
            this.mTextView.setText(this.anA);
        } else {
            this.mTextView.setText(this.mContext.getText(d.l.pb_load_more));
        }
        dp(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wY() {
        this.mTextView.setVisibility(0);
        this.anB.setVisibility(0);
        wX();
    }

    public void wZ() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.l.loading));
    }

    public void dn(int i) {
        ai.j(this.anB, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.anB.getLayoutParams());
        layoutParams.height = i;
        this.anB.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.anA = str;
        this.mTextView.setText(str);
        dp(TbadkCoreApplication.getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.Sf);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m10do(int i) {
        this.anG = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dp(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(d.l.pb_load_more))) {
            i2 = ai.getColor(d.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.l.loading))) {
            i2 = ai.getColor(d.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.l.list_no_more))) {
            i2 = ai.getColor(d.e.common_color_10005);
        } else if (charSequence.equals(this.mContext.getText(d.l.list_no_more_new))) {
            i2 = ai.getColor(d.e.cp_cont_e);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        ai.c(this.anD, this.anC);
        if (this.anG == 0) {
            ai.j(this.anB, d.e.cp_bg_line_d);
        } else if (this.anG > 0) {
            ai.j(this.anB, this.anG);
        }
    }

    public void dq(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.anz.getLayoutParams());
        layoutParams.height = i;
        this.anz.setLayoutParams(layoutParams);
        this.anz.setVisibility(0);
    }

    public void xa() {
        this.anz.setVisibility(8);
    }

    public void xb() {
        this.anE.setVisibility(0);
        this.anD.setVisibility(0);
        this.anB.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        xa();
    }

    public void dr(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.anz.getLayoutParams());
        layoutParams.height = i;
        this.anz.setLayoutParams(layoutParams);
        this.anz.setVisibility(0);
        this.anE.setVisibility(8);
        this.anD.setVisibility(8);
        this.anB.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean xc() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
