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
    private View Sd = null;
    private View any = null;
    private String anz = null;
    private LinearLayout anA = null;
    private int mTextColor = 0;
    private int anB = d.e.cp_bg_line_b;
    private ImageView anC = null;
    private LinearLayout anD = null;
    private boolean anE = true;
    private int anF = 0;

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
        this.Sd = LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.anA = (LinearLayout) this.Sd.findViewById(d.h.pb_more_view);
        this.mTextView = (TextView) this.Sd.findViewById(d.h.pb_more_text);
        if (this.anE) {
            this.anA.setVisibility(0);
        } else {
            this.anA.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Sd.findViewById(d.h.progress);
        this.anC = (ImageView) this.Sd.findViewById(d.h.pb_more_view_top_line);
        this.any = this.Sd.findViewById(d.h.empty_view);
        this.anD = (LinearLayout) this.Sd.findViewById(d.h.pb_more_top_extra_view);
        return this.Sd;
    }

    public void wS() {
        this.anC.setVisibility(0);
    }

    public void wT() {
        this.anC.setVisibility(8);
    }

    public void wU() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anC.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.anC.setLayoutParams(layoutParams);
    }

    public void wV() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anC.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1);
        this.anC.setLayoutParams(layoutParams);
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
        if (this.anz != null) {
            this.mTextView.setText(this.anz);
        } else {
            this.mTextView.setText(this.mContext.getText(d.l.pb_load_more));
        }
        dp(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wY() {
        this.mTextView.setVisibility(0);
        this.anA.setVisibility(0);
        wX();
    }

    public void wZ() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.l.loading));
    }

    public void dn(int i) {
        ai.j(this.anA, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.anA.getLayoutParams());
        layoutParams.height = i;
        this.anA.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.anz = str;
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
            this.mOnClickListener.onClick(this.Sd);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m10do(int i) {
        this.anF = i;
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
        ai.c(this.anC, this.anB);
        if (this.anF == 0) {
            ai.j(this.anA, d.e.cp_bg_line_d);
        } else if (this.anF > 0) {
            ai.j(this.anA, this.anF);
        }
    }

    public void dq(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.any.getLayoutParams());
        layoutParams.height = i;
        this.any.setLayoutParams(layoutParams);
        this.any.setVisibility(0);
    }

    public void xa() {
        this.any.setVisibility(8);
    }

    public void xb() {
        this.anD.setVisibility(0);
        this.anC.setVisibility(0);
        this.anA.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        xa();
    }

    public void dr(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.any.getLayoutParams());
        layoutParams.height = i;
        this.any.setLayoutParams(layoutParams);
        this.any.setVisibility(0);
        this.anD.setVisibility(8);
        this.anC.setVisibility(8);
        this.anA.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean xc() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
