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
    private View Qx = null;
    private View akN = null;
    private String akO = null;
    private LinearLayout akP = null;
    private int mTextColor = 0;
    private int akQ = w.e.cp_bg_line_b;
    private ImageView akR = null;
    private LinearLayout akS = null;
    private boolean akT = true;
    private int akU = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (akV) with 'values()' method */
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
    public View le() {
        this.Qx = LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.akP = (LinearLayout) this.Qx.findViewById(w.h.pb_more_view);
        this.mTextView = (TextView) this.Qx.findViewById(w.h.pb_more_text);
        if (this.akT) {
            this.akP.setVisibility(0);
        } else {
            this.akP.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Qx.findViewById(w.h.progress);
        this.akR = (ImageView) this.Qx.findViewById(w.h.pb_more_view_top_line);
        this.akN = this.Qx.findViewById(w.h.empty_view);
        this.akS = (LinearLayout) this.Qx.findViewById(w.h.pb_more_top_extra_view);
        return this.Qx;
    }

    public void wh() {
        this.akR.setVisibility(0);
    }

    public void wi() {
        this.akR.setVisibility(8);
    }

    public void wj() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akR.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.akR.setLayoutParams(layoutParams);
    }

    public void wk() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akR.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
        this.akR.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void wl() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
        dj(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wm() {
        this.mProgressBar.setVisibility(8);
        if (this.akO != null) {
            this.mTextView.setText(this.akO);
        } else {
            this.mTextView.setText(this.mContext.getText(w.l.pb_load_more));
        }
        dj(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wn() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
    }

    public void dh(int i) {
        com.baidu.tbadk.core.util.aq.j(this.akP, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akP.getLayoutParams());
        layoutParams.height = i;
        this.akP.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.akO = str;
        this.mTextView.setText(str);
        dj(TbadkCoreApplication.m9getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.Qx);
        }
    }

    public void di(int i) {
        this.akU = i;
    }

    public void dj(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(w.l.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(w.l.loading))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(w.l.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10005);
        } else if (charSequence.equals(this.mContext.getText(w.l.list_no_more_new))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.aq.c(this.akR, this.akQ);
        if (this.akU == 0) {
            com.baidu.tbadk.core.util.aq.j(this.akP, w.e.cp_bg_line_d);
        } else if (this.akU > 0) {
            com.baidu.tbadk.core.util.aq.j(this.akP, this.akU);
        }
    }

    public void dk(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akN.getLayoutParams());
        layoutParams.height = i;
        this.akN.setLayoutParams(layoutParams);
        this.akN.setVisibility(0);
    }

    public void wo() {
        this.akN.setVisibility(8);
    }

    public void wp() {
        this.akS.setVisibility(0);
        this.akR.setVisibility(0);
        this.akP.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wo();
    }

    public void dl(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akN.getLayoutParams());
        layoutParams.height = i;
        this.akN.setLayoutParams(layoutParams);
        this.akN.setVisibility(0);
        this.akS.setVisibility(8);
        this.akR.setVisibility(8);
        this.akP.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wq() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
