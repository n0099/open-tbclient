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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView Sm = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View KB = null;
    private View abW = null;
    private String abX = null;
    private LinearLayout abY = null;
    private int mTextColor = 0;
    private int abZ = t.d.cp_bg_line_b;
    private ImageView aca = null;
    private LinearLayout acb = null;
    private int acc = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (acd) with 'values()' method */
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
    public View jn() {
        this.KB = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_more, (ViewGroup) null);
        this.abY = (LinearLayout) this.KB.findViewById(t.g.pb_more_view);
        this.Sm = (TextView) this.KB.findViewById(t.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.KB.findViewById(t.g.progress);
        this.aca = (ImageView) this.KB.findViewById(t.g.pb_more_view_top_line);
        this.abW = this.KB.findViewById(t.g.empty_view);
        this.acb = (LinearLayout) this.KB.findViewById(t.g.pb_more_top_extra_view);
        return this.KB;
    }

    public void va() {
        this.aca.setVisibility(0);
    }

    public void vb() {
        this.aca.setVisibility(8);
    }

    public void vc() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aca.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.aca.setLayoutParams(layoutParams);
    }

    public void vd() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aca.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds1);
        this.aca.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.Sm.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, i));
    }

    public LinearLayout ve() {
        return this.acb;
    }

    public void vf() {
        if (this.acb.getVisibility() != 0) {
            this.acb.setVisibility(0);
        }
    }

    public void vg() {
        if (8 != this.acb.getVisibility()) {
            this.acb.setVisibility(8);
        }
    }

    public void vh() {
        this.mProgressBar.setVisibility(0);
        this.Sm.setText(this.mContext.getText(t.j.loading));
        cR(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void vi() {
        this.mProgressBar.setVisibility(8);
        if (this.abX != null) {
            this.Sm.setText(this.abX);
        } else {
            this.Sm.setText(this.mContext.getText(t.j.pb_load_more));
        }
        cR(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.Sm.setText(this.mContext.getText(t.j.loading));
    }

    public void cP(int i) {
        com.baidu.tbadk.core.util.at.k(this.abY, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.abY.getLayoutParams());
        layoutParams.height = i;
        this.abY.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.abX = str;
        this.Sm.setText(str);
        cR(TbadkCoreApplication.m11getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.KB);
        }
    }

    public void cQ(int i) {
        this.acc = i;
    }

    public void cR(int i) {
        String charSequence = this.Sm.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(t.j.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.at.getColor(t.d.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(t.j.loading))) {
            i2 = com.baidu.tbadk.core.util.at.getColor(t.d.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(t.j.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.at.getColor(t.d.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.Sm.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.at.c(this.aca, this.abZ);
        if (this.acc == 0) {
            com.baidu.tbadk.core.util.at.k(this.abY, t.d.cp_bg_line_d);
        } else if (this.acc > 0) {
            com.baidu.tbadk.core.util.at.k(this.abY, this.acc);
        }
    }

    public void cS(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.abW.getLayoutParams());
        layoutParams.height = i;
        this.abW.setLayoutParams(layoutParams);
        this.abW.setVisibility(0);
    }

    public void vj() {
        this.abW.setVisibility(8);
    }

    public void vk() {
        this.acb.setVisibility(0);
        this.aca.setVisibility(0);
        this.abY.setVisibility(0);
        this.Sm.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        vj();
    }

    public void cT(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.abW.getLayoutParams());
        layoutParams.height = i;
        this.abW.setLayoutParams(layoutParams);
        this.abW.setVisibility(0);
        this.acb.setVisibility(8);
        this.aca.setVisibility(8);
        this.abY.setVisibility(8);
        this.Sm.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }
}
