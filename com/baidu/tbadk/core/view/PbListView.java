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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Tl = null;
    private View anJ = null;
    private int anK = 0;
    private String anL = null;
    private LinearLayout anM = null;
    private int mTextColor = 0;
    private int anN = d.C0126d.cp_cont_e;
    private int anO = d.C0126d.cp_bg_line_b;
    private ImageView anP = null;
    private LinearLayout anQ = null;
    private boolean anR = true;
    private int mSkinType = -1;
    private int anS = 0;

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
    public View kA() {
        this.Tl = LayoutInflater.from(this.mContext).inflate(d.i.new_pb_list_more, (ViewGroup) null);
        this.anM = (LinearLayout) this.Tl.findViewById(d.g.pb_more_view);
        this.mTextView = (TextView) this.Tl.findViewById(d.g.pb_more_text);
        if (this.anR) {
            this.anM.setVisibility(0);
        } else {
            this.anM.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.Tl.findViewById(d.g.progress);
        this.anP = (ImageView) this.Tl.findViewById(d.g.pb_more_view_top_line);
        this.anJ = this.Tl.findViewById(d.g.empty_view);
        this.anQ = (LinearLayout) this.Tl.findViewById(d.g.pb_more_top_extra_view);
        return this.Tl;
    }

    public void aN(boolean z) {
        this.anR = z;
    }

    public void ds(int i) {
        this.anO = i;
    }

    public void wN() {
        this.anP.setVisibility(0);
    }

    public void wO() {
        this.anP.setVisibility(8);
    }

    public void wP() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anP.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.anP.setLayoutParams(layoutParams);
    }

    public void wQ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anP.getLayoutParams();
        layoutParams.height = l.e(this.mContext, d.e.ds1);
        this.anP.setLayoutParams(layoutParams);
    }

    public void dt(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anP.getLayoutParams();
        layoutParams.height = i;
        this.anP.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, l.e(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void wR() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.k.loading));
        dw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wS() {
        this.mProgressBar.setVisibility(8);
        if (this.anL != null) {
            this.mTextView.setText(this.anL);
        } else {
            this.mTextView.setText(this.mContext.getText(d.k.pb_load_more));
        }
        dw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void wT() {
        setText(this.mContext.getResources().getString(d.k.list_no_more));
        wS();
    }

    public void wU() {
        this.mTextView.setVisibility(0);
        this.anM.setVisibility(0);
        wS();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.k.loading));
    }

    public void setBackground(int i) {
        ak.i(this.anM, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.anM.getLayoutParams());
        layoutParams.height = i;
        this.anM.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.anL = str;
        this.mTextView.setText(str);
        dw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void du(int i) {
        this.anN = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Tl);
        }
    }

    public void dv(int i) {
        this.anS = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dw(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.k.pb_load_more))) {
            color = ak.getColor(i, d.C0126d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.k.loading))) {
            color = ak.getColor(i, d.C0126d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.k.list_no_more)) || charSequence.equals(this.mContext.getText(d.k.list_has_no_more))) {
            color = ak.getColor(i, d.C0126d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.k.list_no_more_new))) {
            color = ak.getColor(i, d.C0126d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.k.list_click_load_more)) ? ak.getColor(i, d.C0126d.cp_cont_d) : 0;
        }
        if (z && this.anN != 0) {
            color = ak.getColor(i, this.anN);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        ak.b(this.anP, this.anO, i);
        if (this.anS == 0) {
            ak.d(this.anM, d.C0126d.cp_bg_line_d, i);
        } else if (this.anS > 0) {
            ak.d(this.anM, this.anS, i);
        }
        if (this.anK != 0) {
            ak.e(this.anJ, this.anK, i);
        }
    }

    public void dx(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.anJ.getLayoutParams());
        layoutParams.height = i;
        this.anJ.setLayoutParams(layoutParams);
        this.anJ.setVisibility(0);
    }

    public void wV() {
        this.anJ.setVisibility(8);
    }

    public void wW() {
        this.anQ.setVisibility(0);
        this.anP.setVisibility(0);
        this.anM.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wV();
    }

    public void dy(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.anJ.getLayoutParams());
        layoutParams.height = i;
        this.anJ.setLayoutParams(layoutParams);
        this.anJ.setVisibility(0);
        this.anQ.setVisibility(8);
        this.anP.setVisibility(8);
        this.anM.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wX() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
