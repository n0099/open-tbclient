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
    private View QK = null;
    private View akX = null;
    private String akY = null;
    private LinearLayout akZ = null;
    private int mTextColor = 0;
    private int ala = w.e.cp_bg_line_b;
    private ImageView alb = null;
    private LinearLayout alc = null;
    private boolean ald = true;
    private int ale = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (alf) with 'values()' method */
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
        this.QK = LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.akZ = (LinearLayout) this.QK.findViewById(w.h.pb_more_view);
        this.mTextView = (TextView) this.QK.findViewById(w.h.pb_more_text);
        if (this.ald) {
            this.akZ.setVisibility(0);
        } else {
            this.akZ.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.QK.findViewById(w.h.progress);
        this.alb = (ImageView) this.QK.findViewById(w.h.pb_more_view_top_line);
        this.akX = this.QK.findViewById(w.h.empty_view);
        this.alc = (LinearLayout) this.QK.findViewById(w.h.pb_more_top_extra_view);
        return this.QK;
    }

    public void wk() {
        this.alb.setVisibility(0);
    }

    public void wl() {
        this.alb.setVisibility(8);
    }

    public void wm() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alb.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.alb.setLayoutParams(layoutParams);
    }

    public void wn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alb.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
        this.alb.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void wo() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
        di(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wp() {
        this.mProgressBar.setVisibility(8);
        if (this.akY != null) {
            this.mTextView.setText(this.akY);
        } else {
            this.mTextView.setText(this.mContext.getText(w.l.pb_load_more));
        }
        di(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wq() {
        this.mTextView.setVisibility(0);
        this.akZ.setVisibility(0);
        wp();
    }

    public void wr() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
    }

    public void dg(int i) {
        com.baidu.tbadk.core.util.aq.j(this.akZ, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akZ.getLayoutParams());
        layoutParams.height = i;
        this.akZ.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.akY = str;
        this.mTextView.setText(str);
        di(TbadkCoreApplication.m9getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.QK);
        }
    }

    public void dh(int i) {
        this.ale = i;
    }

    public void di(int i) {
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
        com.baidu.tbadk.core.util.aq.c(this.alb, this.ala);
        if (this.ale == 0) {
            com.baidu.tbadk.core.util.aq.j(this.akZ, w.e.cp_bg_line_d);
        } else if (this.ale > 0) {
            com.baidu.tbadk.core.util.aq.j(this.akZ, this.ale);
        }
    }

    public void dj(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akX.getLayoutParams());
        layoutParams.height = i;
        this.akX.setLayoutParams(layoutParams);
        this.akX.setVisibility(0);
    }

    public void ws() {
        this.akX.setVisibility(8);
    }

    public void wt() {
        this.alc.setVisibility(0);
        this.alb.setVisibility(0);
        this.akZ.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        ws();
    }

    public void dk(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akX.getLayoutParams());
        layoutParams.height = i;
        this.akX.setLayoutParams(layoutParams);
        this.akX.setVisibility(0);
        this.alc.setVisibility(8);
        this.alb.setVisibility(8);
        this.akZ.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wu() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
