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
    private TextView aaE = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View QZ = null;
    private View akN = null;
    private String akO = null;
    private LinearLayout akP = null;
    private int mTextColor = 0;
    private int akQ = w.e.cp_bg_line_b;
    private ImageView akR = null;
    private LinearLayout akS = null;
    private int akT = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (akU) with 'values()' method */
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
    public View la() {
        this.QZ = LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.akP = (LinearLayout) this.QZ.findViewById(w.h.pb_more_view);
        this.aaE = (TextView) this.QZ.findViewById(w.h.pb_more_text);
        this.mProgressBar = (ProgressBar) this.QZ.findViewById(w.h.progress);
        this.akR = (ImageView) this.QZ.findViewById(w.h.pb_more_view_top_line);
        this.akN = this.QZ.findViewById(w.h.empty_view);
        this.akS = (LinearLayout) this.QZ.findViewById(w.h.pb_more_top_extra_view);
        return this.QZ;
    }

    public void wA() {
        this.akR.setVisibility(0);
    }

    public void wB() {
        this.akR.setVisibility(8);
    }

    public void wC() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akR.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.akR.setLayoutParams(layoutParams);
    }

    public void wD() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akR.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
        this.akR.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.aaE.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public LinearLayout wE() {
        return this.akS;
    }

    public void wF() {
        if (this.akS.getVisibility() != 0) {
            this.akS.setVisibility(0);
        }
    }

    public void wG() {
        if (8 != this.akS.getVisibility()) {
            this.akS.setVisibility(8);
        }
    }

    public void wH() {
        this.mProgressBar.setVisibility(0);
        this.aaE.setText(this.mContext.getText(w.l.loading));
        dh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wI() {
        this.mProgressBar.setVisibility(8);
        if (this.akO != null) {
            this.aaE.setText(this.akO);
        } else {
            this.aaE.setText(this.mContext.getText(w.l.pb_load_more));
        }
        dh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wJ() {
        this.aaE.setVisibility(0);
        this.akP.setVisibility(0);
        wI();
    }

    public void wK() {
        this.mProgressBar.setVisibility(0);
        this.aaE.setText(this.mContext.getText(w.l.loading));
    }

    public void df(int i) {
        com.baidu.tbadk.core.util.aq.j(this.akP, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akP.getLayoutParams());
        layoutParams.height = i;
        this.akP.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.akO = str;
        this.aaE.setText(str);
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
            this.mOnClickListener.onClick(this.QZ);
        }
    }

    public void dg(int i) {
        this.akT = i;
    }

    public void dh(int i) {
        String charSequence = this.aaE.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(w.l.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(w.l.loading))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(w.l.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10005);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.aaE.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.aq.c(this.akR, this.akQ);
        if (this.akT == 0) {
            com.baidu.tbadk.core.util.aq.j(this.akP, w.e.cp_bg_line_d);
        } else if (this.akT > 0) {
            com.baidu.tbadk.core.util.aq.j(this.akP, this.akT);
        }
    }

    public void di(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akN.getLayoutParams());
        layoutParams.height = i;
        this.akN.setLayoutParams(layoutParams);
        this.akN.setVisibility(0);
    }

    public void wL() {
        this.akN.setVisibility(8);
    }

    public void wM() {
        this.akS.setVisibility(0);
        this.akR.setVisibility(0);
        this.akP.setVisibility(0);
        this.aaE.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wL();
    }

    public void dj(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.akN.getLayoutParams());
        layoutParams.height = i;
        this.akN.setLayoutParams(layoutParams);
        this.akN.setVisibility(0);
        this.akS.setVisibility(8);
        this.akR.setVisibility(8);
        this.akP.setVisibility(8);
        this.aaE.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wN() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
