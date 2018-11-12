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
    private View ajk = null;
    private View aEM = null;
    private int aEN = 0;
    private String aEO = null;
    private LinearLayout aEP = null;
    private int mTextColor = 0;
    private int aEQ = e.d.cp_cont_e;
    private int aER = e.d.cp_bg_line_b;
    private ImageView aES = null;
    private LinearLayout aET = null;
    private boolean aEU = true;
    private int mSkinType = -1;
    private int aEV = 0;

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
    public View oE() {
        this.ajk = LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        this.aEP = (LinearLayout) this.ajk.findViewById(e.g.pb_more_view);
        this.mTextView = (TextView) this.ajk.findViewById(e.g.pb_more_text);
        if (this.aEU) {
            this.aEP.setVisibility(0);
        } else {
            this.aEP.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.ajk.findViewById(e.g.progress);
        this.aES = (ImageView) this.ajk.findViewById(e.g.pb_more_view_top_line);
        this.aEM = this.ajk.findViewById(e.g.empty_view);
        this.aET = (LinearLayout) this.ajk.findViewById(e.g.pb_more_top_extra_view);
        return this.ajk;
    }

    public void bF(boolean z) {
        this.aEU = z;
    }

    public void ef(int i) {
        this.aER = i;
    }

    public void DU() {
        this.aES.setVisibility(0);
    }

    public void DV() {
        this.aES.setVisibility(8);
    }

    public void DW() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aES.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.aES.setLayoutParams(layoutParams);
    }

    public void DX() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aES.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds1);
        this.aES.setLayoutParams(layoutParams);
    }

    public void eg(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aES.getLayoutParams();
        layoutParams.height = i;
        this.aES.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void DY() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
        ek(TbadkCoreApplication.getInst().getSkinType());
    }

    public void DZ() {
        this.mProgressBar.setVisibility(8);
        if (this.aEO != null) {
            this.mTextView.setText(this.aEO);
        } else {
            this.mTextView.setText(this.mContext.getText(e.j.pb_load_more));
        }
        ek(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Ea() {
        setText(this.mContext.getResources().getString(e.j.list_no_more));
        DZ();
    }

    public void Eb() {
        this.mTextView.setVisibility(0);
        this.aEP.setVisibility(0);
        DZ();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
    }

    public void eh(int i) {
        al.i(this.aEP, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aEP.getLayoutParams());
        layoutParams.height = i;
        this.aEP.setLayoutParams(layoutParams);
    }

    public void Ec() {
        this.ajk.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setText(String str) {
        this.aEO = str;
        this.mTextView.setText(str);
        ek(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void ei(int i) {
        this.aEQ = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.ajk);
        }
    }

    public void ej(int i) {
        this.aEV = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void ek(int i) {
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
        if (z && this.aEQ != 0) {
            color = al.getColor(i, this.aEQ);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.aES, this.aER, i);
        if (this.aEV == 0) {
            al.d(this.aEP, e.d.cp_bg_line_d, i);
        } else if (this.aEV > 0) {
            al.d(this.aEP, this.aEV, i);
        }
        if (this.aEN != 0) {
            al.e(this.aEM, this.aEN, i);
        }
    }

    public void el(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aEM.getLayoutParams());
        layoutParams.height = i;
        this.aEM.setLayoutParams(layoutParams);
        this.aEM.setVisibility(0);
    }

    public void hideEmptyView() {
        this.aEM.setVisibility(8);
    }

    public void Ed() {
        this.aET.setVisibility(0);
        this.aES.setVisibility(0);
        this.aEP.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void em(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aEM.getLayoutParams());
        layoutParams.height = i;
        this.aEM.setLayoutParams(layoutParams);
        this.aEM.setVisibility(0);
        this.aET.setVisibility(8);
        this.aES.setVisibility(8);
        this.aEP.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean Ee() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
