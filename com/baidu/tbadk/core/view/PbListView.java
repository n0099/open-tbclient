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
    private View QE = null;
    private View amf = null;
    private String amg = null;
    private LinearLayout amh = null;
    private int mTextColor = 0;
    private int ami = d.e.cp_bg_line_b;
    private ImageView amj = null;
    private LinearLayout amk = null;
    private boolean aml = true;
    private int amm = 0;

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
    public View la() {
        this.QE = LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.amh = (LinearLayout) this.QE.findViewById(d.h.pb_more_view);
        this.mTextView = (TextView) this.QE.findViewById(d.h.pb_more_text);
        if (this.aml) {
            this.amh.setVisibility(0);
        } else {
            this.amh.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.QE.findViewById(d.h.progress);
        this.amj = (ImageView) this.QE.findViewById(d.h.pb_more_view_top_line);
        this.amf = this.QE.findViewById(d.h.empty_view);
        this.amk = (LinearLayout) this.QE.findViewById(d.h.pb_more_top_extra_view);
        return this.QE;
    }

    public void wJ() {
        this.amj.setVisibility(0);
    }

    public void wK() {
        this.amj.setVisibility(8);
    }

    public void wL() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amj.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.amj.setLayoutParams(layoutParams);
    }

    public void wM() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amj.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1);
        this.amj.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void wN() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.l.loading));
        dn(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wO() {
        this.mProgressBar.setVisibility(8);
        if (this.amg != null) {
            this.mTextView.setText(this.amg);
        } else {
            this.mTextView.setText(this.mContext.getText(d.l.pb_load_more));
        }
        dn(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wP() {
        this.mTextView.setVisibility(0);
        this.amh.setVisibility(0);
        wO();
    }

    public void wQ() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.l.loading));
    }

    public void dl(int i) {
        ai.j(this.amh, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amh.getLayoutParams());
        layoutParams.height = i;
        this.amh.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.amg = str;
        this.mTextView.setText(str);
        dn(TbadkCoreApplication.getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.QE);
        }
    }

    public void dm(int i) {
        this.amm = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dn(int i) {
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
        ai.c(this.amj, this.ami);
        if (this.amm == 0) {
            ai.j(this.amh, d.e.cp_bg_line_d);
        } else if (this.amm > 0) {
            ai.j(this.amh, this.amm);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m10do(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amf.getLayoutParams());
        layoutParams.height = i;
        this.amf.setLayoutParams(layoutParams);
        this.amf.setVisibility(0);
    }

    public void wR() {
        this.amf.setVisibility(8);
    }

    public void wS() {
        this.amk.setVisibility(0);
        this.amj.setVisibility(0);
        this.amh.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wR();
    }

    public void dp(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.amf.getLayoutParams());
        layoutParams.height = i;
        this.amf.setLayoutParams(layoutParams);
        this.amf.setVisibility(0);
        this.amk.setVisibility(8);
        this.amj.setVisibility(8);
        this.amh.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wT() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
