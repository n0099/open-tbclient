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
    private TextView Wd = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View MJ = null;
    private View agj = null;
    private String agk = null;
    private LinearLayout agl = null;
    private int mTextColor = 0;
    private int agm = r.d.cp_bg_line_b;
    private ImageView agn = null;
    private LinearLayout ago = null;
    private int agp = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (agq) with 'values()' method */
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
    public View kk() {
        this.MJ = LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_more, (ViewGroup) null);
        this.agl = (LinearLayout) this.MJ.findViewById(r.g.pb_more_view);
        this.Wd = (TextView) this.MJ.findViewById(r.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.MJ.findViewById(r.g.progress);
        this.agn = (ImageView) this.MJ.findViewById(r.g.pb_more_view_top_line);
        this.agj = this.MJ.findViewById(r.g.empty_view);
        this.ago = (LinearLayout) this.MJ.findViewById(r.g.pb_more_top_extra_view);
        return this.MJ;
    }

    public void wi() {
        this.agn.setVisibility(0);
    }

    public void wj() {
        this.agn.setVisibility(8);
    }

    public void wk() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agn.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.agn.setLayoutParams(layoutParams);
    }

    public void wl() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agn.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds1);
        this.agn.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.Wd.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    public LinearLayout wm() {
        return this.ago;
    }

    public void wn() {
        if (this.ago.getVisibility() != 0) {
            this.ago.setVisibility(0);
        }
    }

    public void wo() {
        if (8 != this.ago.getVisibility()) {
            this.ago.setVisibility(8);
        }
    }

    public void wp() {
        this.mProgressBar.setVisibility(0);
        this.Wd.setText(this.mContext.getText(r.j.loading));
        dk(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wq() {
        this.mProgressBar.setVisibility(8);
        if (this.agk != null) {
            this.Wd.setText(this.agk);
        } else {
            this.Wd.setText(this.mContext.getText(r.j.pb_load_more));
        }
        dk(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wr() {
        this.Wd.setVisibility(0);
        this.agl.setVisibility(0);
        wq();
    }

    public void ws() {
        this.mProgressBar.setVisibility(0);
        this.Wd.setText(this.mContext.getText(r.j.loading));
    }

    public void di(int i) {
        com.baidu.tbadk.core.util.ar.k(this.agl, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agl.getLayoutParams());
        layoutParams.height = i;
        this.agl.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.agk = str;
        this.Wd.setText(str);
        dk(TbadkCoreApplication.m9getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.MJ);
        }
    }

    public void dj(int i) {
        this.agp = i;
    }

    public void dk(int i) {
        String charSequence = this.Wd.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(r.j.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(r.j.loading))) {
            i2 = com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(r.j.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10005);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.Wd.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.ar.c(this.agn, this.agm);
        if (this.agp == 0) {
            com.baidu.tbadk.core.util.ar.k(this.agl, r.d.cp_bg_line_d);
        } else if (this.agp > 0) {
            com.baidu.tbadk.core.util.ar.k(this.agl, this.agp);
        }
    }

    public void dl(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agj.getLayoutParams());
        layoutParams.height = i;
        this.agj.setLayoutParams(layoutParams);
        this.agj.setVisibility(0);
    }

    public void wt() {
        this.agj.setVisibility(8);
    }

    public void wu() {
        this.ago.setVisibility(0);
        this.agn.setVisibility(0);
        this.agl.setVisibility(0);
        this.Wd.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wt();
    }

    public void dm(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agj.getLayoutParams());
        layoutParams.height = i;
        this.agj.setLayoutParams(layoutParams);
        this.agj.setVisibility(0);
        this.ago.setVisibility(8);
        this.agn.setVisibility(8);
        this.agl.setVisibility(8);
        this.Wd.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wv() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
