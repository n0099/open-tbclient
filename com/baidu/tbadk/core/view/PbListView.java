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
    private TextView Wb = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View MN = null;
    private View afQ = null;
    private String afR = null;
    private LinearLayout afS = null;
    private int mTextColor = 0;
    private int afT = t.d.cp_bg_line_b;
    private ImageView afU = null;
    private LinearLayout afV = null;
    private int afW = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (afX) with 'values()' method */
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
        this.MN = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_more, (ViewGroup) null);
        this.afS = (LinearLayout) this.MN.findViewById(t.g.pb_more_view);
        this.Wb = (TextView) this.MN.findViewById(t.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.MN.findViewById(t.g.progress);
        this.afU = (ImageView) this.MN.findViewById(t.g.pb_more_view_top_line);
        this.afQ = this.MN.findViewById(t.g.empty_view);
        this.afV = (LinearLayout) this.MN.findViewById(t.g.pb_more_top_extra_view);
        return this.MN;
    }

    public void we() {
        this.afU.setVisibility(0);
    }

    public void wf() {
        this.afU.setVisibility(8);
    }

    public void wg() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afU.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.afU.setLayoutParams(layoutParams);
    }

    public void wh() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afU.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds1);
        this.afU.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.Wb.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    public LinearLayout wi() {
        return this.afV;
    }

    public void wj() {
        if (this.afV.getVisibility() != 0) {
            this.afV.setVisibility(0);
        }
    }

    public void wk() {
        if (8 != this.afV.getVisibility()) {
            this.afV.setVisibility(8);
        }
    }

    public void wl() {
        this.mProgressBar.setVisibility(0);
        this.Wb.setText(this.mContext.getText(t.j.loading));
        dh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wm() {
        this.mProgressBar.setVisibility(8);
        if (this.afR != null) {
            this.Wb.setText(this.afR);
        } else {
            this.Wb.setText(this.mContext.getText(t.j.pb_load_more));
        }
        dh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wn() {
        this.mProgressBar.setVisibility(0);
        this.Wb.setText(this.mContext.getText(t.j.loading));
    }

    public void df(int i) {
        com.baidu.tbadk.core.util.av.k(this.afS, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afS.getLayoutParams());
        layoutParams.height = i;
        this.afS.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.afR = str;
        this.Wb.setText(str);
        dh(TbadkCoreApplication.m9getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.MN);
        }
    }

    public void dg(int i) {
        this.afW = i;
    }

    public void dh(int i) {
        String charSequence = this.Wb.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(t.j.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(t.j.loading))) {
            i2 = com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(t.j.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10005);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.Wb.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.av.c(this.afU, this.afT);
        if (this.afW == 0) {
            com.baidu.tbadk.core.util.av.k(this.afS, t.d.cp_bg_line_d);
        } else if (this.afW > 0) {
            com.baidu.tbadk.core.util.av.k(this.afS, this.afW);
        }
    }

    public void di(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afQ.getLayoutParams());
        layoutParams.height = i;
        this.afQ.setLayoutParams(layoutParams);
        this.afQ.setVisibility(0);
    }

    public void wo() {
        this.afQ.setVisibility(8);
    }

    public void wp() {
        this.afV.setVisibility(0);
        this.afU.setVisibility(0);
        this.afS.setVisibility(0);
        this.Wb.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wo();
    }

    public void dj(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afQ.getLayoutParams());
        layoutParams.height = i;
        this.afQ.setLayoutParams(layoutParams);
        this.afQ.setVisibility(0);
        this.afV.setVisibility(8);
        this.afU.setVisibility(8);
        this.afS.setVisibility(8);
        this.Wb.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }
}
