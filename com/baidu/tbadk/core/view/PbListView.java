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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View aix = null;
    private View aDW = null;
    private int aDX = 0;
    private String aDY = null;
    private LinearLayout aDZ = null;
    private int mTextColor = 0;
    private int aEa = e.d.cp_cont_e;
    private int aEb = e.d.cp_bg_line_b;
    private ImageView aEc = null;
    private LinearLayout aEd = null;
    private boolean aEe = true;
    private int mSkinType = -1;
    private int aEf = 0;

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
    public View oG() {
        this.aix = LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        this.aDZ = (LinearLayout) this.aix.findViewById(e.g.pb_more_view);
        this.mTextView = (TextView) this.aix.findViewById(e.g.pb_more_text);
        if (this.aEe) {
            this.aDZ.setVisibility(0);
        } else {
            this.aDZ.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aix.findViewById(e.g.progress);
        this.aEc = (ImageView) this.aix.findViewById(e.g.pb_more_view_top_line);
        this.aDW = this.aix.findViewById(e.g.empty_view);
        this.aEd = (LinearLayout) this.aix.findViewById(e.g.pb_more_top_extra_view);
        return this.aix;
    }

    public void bo(boolean z) {
        this.aEe = z;
    }

    public void dR(int i) {
        this.aEb = i;
    }

    public void DK() {
        this.aEc.setVisibility(0);
    }

    public void DL() {
        this.aEc.setVisibility(8);
    }

    public void DM() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEc.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.aEc.setLayoutParams(layoutParams);
    }

    public void DN() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEc.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds1);
        this.aEc.setLayoutParams(layoutParams);
    }

    public void dS(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEc.getLayoutParams();
        layoutParams.height = i;
        this.aEc.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void DO() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
        dW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DP() {
        this.mProgressBar.setVisibility(8);
        if (this.aDY != null) {
            this.mTextView.setText(this.aDY);
        } else {
            this.mTextView.setText(this.mContext.getText(e.j.pb_load_more));
        }
        dW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DQ() {
        setText(this.mContext.getResources().getString(e.j.list_no_more));
        DP();
    }

    public void DR() {
        this.mTextView.setVisibility(0);
        this.aDZ.setVisibility(0);
        DP();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
    }

    public void dT(int i) {
        al.i(this.aDZ, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aDZ.getLayoutParams());
        layoutParams.height = i;
        this.aDZ.setLayoutParams(layoutParams);
    }

    public void DS() {
        this.aix.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setText(String str) {
        this.aDY = str;
        this.mTextView.setText(str);
        dW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dU(int i) {
        this.aEa = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aix);
        }
    }

    public void dV(int i) {
        this.aEf = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dW(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(e.j.pb_load_more))) {
            color = al.getColor(i, e.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(e.j.loading))) {
            color = al.getColor(i, e.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(e.j.list_no_more)) || charSequence.equals(this.mContext.getText(e.j.list_has_no_more)) || charSequence.equals(this.mContext.getText(e.j.sub_pb_list_no_more))) {
            color = al.getColor(i, e.d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(e.j.list_no_more_new))) {
            color = al.getColor(i, e.d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(e.j.list_click_load_more)) ? al.getColor(i, e.d.cp_cont_d) : 0;
        }
        if (z && this.aEa != 0) {
            color = al.getColor(i, this.aEa);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.aEc, this.aEb, i);
        if (this.aEf == 0) {
            al.d(this.aDZ, e.d.cp_bg_line_d, i);
        } else if (this.aEf > 0) {
            al.d(this.aDZ, this.aEf, i);
        }
        if (this.aDX != 0) {
            al.e(this.aDW, this.aDX, i);
        }
    }

    public void dX(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aDW.getLayoutParams());
        layoutParams.height = i;
        this.aDW.setLayoutParams(layoutParams);
        this.aDW.setVisibility(0);
    }

    public void hideEmptyView() {
        this.aDW.setVisibility(8);
    }

    public void DT() {
        this.aEd.setVisibility(0);
        this.aEc.setVisibility(0);
        this.aDZ.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void dY(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aDW.getLayoutParams());
        layoutParams.height = i;
        this.aDW.setLayoutParams(layoutParams);
        this.aDW.setVisibility(0);
        this.aEd.setVisibility(8);
        this.aEc.setVisibility(8);
        this.aDZ.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean DU() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
