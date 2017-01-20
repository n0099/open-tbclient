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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView Vt = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View LW = null;
    private View afv = null;
    private String afw = null;
    private LinearLayout afx = null;
    private int mTextColor = 0;
    private int afy = r.e.cp_bg_line_b;
    private ImageView afz = null;
    private LinearLayout afA = null;
    private int afB = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (afC) with 'values()' method */
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
    public View kg() {
        this.LW = LayoutInflater.from(this.mContext).inflate(r.j.new_pb_list_more, (ViewGroup) null);
        this.afx = (LinearLayout) this.LW.findViewById(r.h.pb_more_view);
        this.Vt = (TextView) this.LW.findViewById(r.h.pb_more_text);
        this.mProgressBar = (ProgressBar) this.LW.findViewById(r.h.progress);
        this.afz = (ImageView) this.LW.findViewById(r.h.pb_more_view_top_line);
        this.afv = this.LW.findViewById(r.h.empty_view);
        this.afA = (LinearLayout) this.LW.findViewById(r.h.pb_more_top_extra_view);
        return this.LW;
    }

    public void wd() {
        this.afz.setVisibility(0);
    }

    public void we() {
        this.afz.setVisibility(8);
    }

    public void wf() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afz.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.afz.setLayoutParams(layoutParams);
    }

    public void wg() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afz.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds1);
        this.afz.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.Vt.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    public LinearLayout wh() {
        return this.afA;
    }

    public void wi() {
        if (this.afA.getVisibility() != 0) {
            this.afA.setVisibility(0);
        }
    }

    public void wj() {
        if (8 != this.afA.getVisibility()) {
            this.afA.setVisibility(8);
        }
    }

    public void wk() {
        this.mProgressBar.setVisibility(0);
        this.Vt.setText(this.mContext.getText(r.l.loading));
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wl() {
        this.mProgressBar.setVisibility(8);
        if (this.afw != null) {
            this.Vt.setText(this.afw);
        } else {
            this.Vt.setText(this.mContext.getText(r.l.pb_load_more));
        }
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wm() {
        this.Vt.setVisibility(0);
        this.afx.setVisibility(0);
        wl();
    }

    public void wn() {
        this.mProgressBar.setVisibility(0);
        this.Vt.setText(this.mContext.getText(r.l.loading));
    }

    public void dj(int i) {
        com.baidu.tbadk.core.util.ap.j(this.afx, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afx.getLayoutParams());
        layoutParams.height = i;
        this.afx.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.afw = str;
        this.Vt.setText(str);
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
            this.mOnClickListener.onClick(this.LW);
        }
    }

    public void dk(int i) {
        this.afB = i;
    }

    public void dl(int i) {
        String charSequence = this.Vt.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(r.l.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(r.l.loading))) {
            i2 = com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(r.l.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10005);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.Vt.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.ap.c(this.afz, this.afy);
        if (this.afB == 0) {
            com.baidu.tbadk.core.util.ap.j(this.afx, r.e.cp_bg_line_d);
        } else if (this.afB > 0) {
            com.baidu.tbadk.core.util.ap.j(this.afx, this.afB);
        }
    }

    public void dm(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afv.getLayoutParams());
        layoutParams.height = i;
        this.afv.setLayoutParams(layoutParams);
        this.afv.setVisibility(0);
    }

    public void wo() {
        this.afv.setVisibility(8);
    }

    public void wp() {
        this.afA.setVisibility(0);
        this.afz.setVisibility(0);
        this.afx.setVisibility(0);
        this.Vt.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wo();
    }

    public void dn(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afv.getLayoutParams());
        layoutParams.height = i;
        this.afv.setLayoutParams(layoutParams);
        this.afv.setVisibility(0);
        this.afA.setVisibility(8);
        this.afz.setVisibility(8);
        this.afx.setVisibility(8);
        this.Vt.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wq() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
