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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView abi = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rh = null;
    private View alL = null;
    private int alM = 0;
    private String alN = null;
    private LinearLayout alO = null;
    private int mTextColor = 0;
    private int alP = d.e.cp_cont_e;
    private int alQ = d.e.cp_bg_line_b;
    private ImageView alR = null;
    private LinearLayout alS = null;
    private boolean alT = true;
    private int alU = 0;

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
    public View ld() {
        this.Rh = LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.alO = (LinearLayout) this.Rh.findViewById(d.h.pb_more_view);
        this.abi = (TextView) this.Rh.findViewById(d.h.pb_more_text);
        if (this.alT) {
            this.alO.setVisibility(0);
        } else {
            this.alO.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Rh.findViewById(d.h.progress);
        this.alR = (ImageView) this.Rh.findViewById(d.h.pb_more_view_top_line);
        this.alL = this.Rh.findViewById(d.h.empty_view);
        this.alS = (LinearLayout) this.Rh.findViewById(d.h.pb_more_top_extra_view);
        return this.Rh;
    }

    public void dt(int i) {
        this.alQ = i;
    }

    public void wi() {
        this.alR.setVisibility(0);
    }

    public void wj() {
        this.alR.setVisibility(8);
    }

    public void wk() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alR.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.alR.setLayoutParams(layoutParams);
    }

    public void wl() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alR.getLayoutParams();
        layoutParams.height = l.f(this.mContext, d.f.ds1);
        this.alR.setLayoutParams(layoutParams);
    }

    public void du(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alR.getLayoutParams();
        layoutParams.height = i;
        this.alR.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.abi.setTextSize(0, l.f(this.mContext, i));
    }

    public void wm() {
        this.mProgressBar.setVisibility(0);
        this.abi.setText(this.mContext.getText(d.l.loading));
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wn() {
        this.mProgressBar.setVisibility(8);
        if (this.alN != null) {
            this.abi.setText(this.alN);
        } else {
            this.abi.setText(this.mContext.getText(d.l.pb_load_more));
        }
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wo() {
        setText(this.mContext.getResources().getString(d.l.list_no_more));
        wn();
    }

    public void wp() {
        this.abi.setVisibility(0);
        this.alO.setVisibility(0);
        wn();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.abi.setText(this.mContext.getText(d.l.loading));
    }

    public void dv(int i) {
        aj.j(this.alO, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alO.getLayoutParams());
        layoutParams.height = i;
        this.alO.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.alN = str;
        this.abi.setText(str);
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dw(int i) {
        this.alP = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rh);
        }
    }

    public void dx(int i) {
        this.alU = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dy(int i) {
        int color;
        boolean z = false;
        String charSequence = this.abi.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.l.pb_load_more))) {
            color = aj.getColor(d.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.l.loading))) {
            color = aj.getColor(d.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.l.list_no_more)) || charSequence.equals(this.mContext.getText(d.l.list_has_no_more))) {
            color = aj.getColor(d.e.common_color_10005);
            z = true;
        } else {
            color = charSequence.equals(this.mContext.getText(d.l.list_no_more_new)) ? aj.getColor(d.e.cp_cont_e) : 0;
        }
        if (z && this.alP != 0) {
            color = aj.getColor(this.alP);
        }
        if (this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.abi.setTextColor(color);
        }
        aj.c(this.alR, this.alQ);
        if (this.alU == 0) {
            aj.j(this.alO, d.e.cp_bg_line_d);
        } else if (this.alU > 0) {
            aj.j(this.alO, this.alU);
        }
        if (this.alM != 0) {
            aj.k(this.alL, this.alM);
        }
    }

    public void dz(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alL.getLayoutParams());
        layoutParams.height = i;
        this.alL.setLayoutParams(layoutParams);
        this.alL.setVisibility(0);
    }

    public void dA(int i) {
        this.alM = i;
    }

    public void wq() {
        this.alL.setVisibility(8);
    }

    public void wr() {
        this.alS.setVisibility(0);
        this.alR.setVisibility(0);
        this.alO.setVisibility(0);
        this.abi.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wq();
    }

    public void dB(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alL.getLayoutParams());
        layoutParams.height = i;
        this.alL.setLayoutParams(layoutParams);
        this.alL.setVisibility(0);
        this.alS.setVisibility(8);
        this.alR.setVisibility(8);
        this.alO.setVisibility(8);
        this.abi.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean ws() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
