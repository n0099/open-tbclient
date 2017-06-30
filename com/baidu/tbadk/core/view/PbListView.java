package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Qr = null;
    private View alB = null;
    private String alC = null;
    private LinearLayout alD = null;
    private int mTextColor = 0;
    private int alE = w.e.cp_bg_line_b;
    private ImageView alF = null;
    private LinearLayout alG = null;
    private boolean alH = true;
    private int alI = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (alJ) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static IconType[] valuesCustom() {
            IconType[] valuesCustom = values();
            int length = valuesCustom.length;
            IconType[] iconTypeArr = new IconType[length];
            System.arraycopy(valuesCustom, 0, iconTypeArr, 0, length);
            return iconTypeArr;
        }
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lc() {
        this.Qr = LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.alD = (LinearLayout) this.Qr.findViewById(w.h.pb_more_view);
        this.mTextView = (TextView) this.Qr.findViewById(w.h.pb_more_text);
        if (this.alH) {
            this.alD.setVisibility(0);
        } else {
            this.alD.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Qr.findViewById(w.h.progress);
        this.alF = (ImageView) this.Qr.findViewById(w.h.pb_more_view_top_line);
        this.alB = this.Qr.findViewById(w.h.empty_view);
        this.alG = (LinearLayout) this.Qr.findViewById(w.h.pb_more_top_extra_view);
        return this.Qr;
    }

    public void wz() {
        this.alF.setVisibility(0);
    }

    public void wA() {
        this.alF.setVisibility(8);
    }

    public void wB() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alF.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.alF.setLayoutParams(layoutParams);
    }

    public void wC() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alF.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
        this.alF.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void wD() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wE() {
        this.mProgressBar.setVisibility(8);
        if (this.alC != null) {
            this.mTextView.setText(this.alC);
        } else {
            this.mTextView.setText(this.mContext.getText(w.l.pb_load_more));
        }
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wF() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
    }

    public void dj(int i) {
        com.baidu.tbadk.core.util.as.j(this.alD, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alD.getLayoutParams());
        layoutParams.height = i;
        this.alD.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.alC = str;
        this.mTextView.setText(str);
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Qr);
        }
    }

    public void dk(int i) {
        this.alI = i;
    }

    public void dl(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(w.l.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.as.getColor(w.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(w.l.loading))) {
            i2 = com.baidu.tbadk.core.util.as.getColor(w.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(w.l.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.as.getColor(w.e.common_color_10005);
        } else if (charSequence.equals(this.mContext.getText(w.l.list_no_more_new))) {
            i2 = com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_e);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.as.c(this.alF, this.alE);
        if (this.alI == 0) {
            com.baidu.tbadk.core.util.as.j(this.alD, w.e.cp_bg_line_d);
        } else if (this.alI > 0) {
            com.baidu.tbadk.core.util.as.j(this.alD, this.alI);
        }
    }

    public void dm(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alB.getLayoutParams());
        layoutParams.height = i;
        this.alB.setLayoutParams(layoutParams);
        this.alB.setVisibility(0);
    }

    public void wG() {
        this.alB.setVisibility(8);
    }

    public void wH() {
        this.alG.setVisibility(0);
        this.alF.setVisibility(0);
        this.alD.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wG();
    }

    public void dn(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alB.getLayoutParams());
        layoutParams.height = i;
        this.alB.setLayoutParams(layoutParams);
        this.alB.setVisibility(0);
        this.alG.setVisibility(8);
        this.alF.setVisibility(8);
        this.alD.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wI() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
