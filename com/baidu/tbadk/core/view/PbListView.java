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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View aaV = null;
    private View awg = null;
    private int awh = 0;
    private String awi = null;
    private LinearLayout awj = null;
    private int mTextColor = 0;
    private int awk = d.C0140d.cp_cont_e;
    private int awl = d.C0140d.cp_bg_line_b;
    private ImageView awm = null;
    private LinearLayout awn = null;
    private boolean awo = true;
    private int mSkinType = -1;
    private int awp = 0;

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
    public View np() {
        this.aaV = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.awj = (LinearLayout) this.aaV.findViewById(d.g.pb_more_view);
        this.mTextView = (TextView) this.aaV.findViewById(d.g.pb_more_text);
        if (this.awo) {
            this.awj.setVisibility(0);
        } else {
            this.awj.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aaV.findViewById(d.g.progress);
        this.awm = (ImageView) this.aaV.findViewById(d.g.pb_more_view_top_line);
        this.awg = this.aaV.findViewById(d.g.empty_view);
        this.awn = (LinearLayout) this.aaV.findViewById(d.g.pb_more_top_extra_view);
        return this.aaV;
    }

    public void aR(boolean z) {
        this.awo = z;
    }

    public void dx(int i) {
        this.awl = i;
    }

    public void At() {
        this.awm.setVisibility(0);
    }

    public void Au() {
        this.awm.setVisibility(8);
    }

    public void Av() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awm.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.awm.setLayoutParams(layoutParams);
    }

    public void Aw() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awm.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds1);
        this.awm.setLayoutParams(layoutParams);
    }

    public void dy(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awm.getLayoutParams();
        layoutParams.height = i;
        this.awm.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void Ax() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.j.loading));
        dC(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Ay() {
        this.mProgressBar.setVisibility(8);
        if (this.awi != null) {
            this.mTextView.setText(this.awi);
        } else {
            this.mTextView.setText(this.mContext.getText(d.j.pb_load_more));
        }
        dC(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Az() {
        setText(this.mContext.getResources().getString(d.j.list_no_more));
        Ay();
    }

    public void AA() {
        this.mTextView.setVisibility(0);
        this.awj.setVisibility(0);
        Ay();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.j.loading));
    }

    public void dz(int i) {
        am.i(this.awj, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awj.getLayoutParams());
        layoutParams.height = i;
        this.awj.setLayoutParams(layoutParams);
    }

    public void AB() {
        this.aaV.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setText(String str) {
        this.awi = str;
        this.mTextView.setText(str);
        dC(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dA(int i) {
        this.awk = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aaV);
        }
    }

    public void dB(int i) {
        this.awp = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dC(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = am.getColor(i, d.C0140d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = am.getColor(i, d.C0140d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more))) {
            color = am.getColor(i, d.C0140d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more_new))) {
            color = am.getColor(i, d.C0140d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_click_load_more)) ? am.getColor(i, d.C0140d.cp_cont_d) : 0;
        }
        if (z && this.awk != 0) {
            color = am.getColor(i, this.awk);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        am.b(this.awm, this.awl, i);
        if (this.awp == 0) {
            am.d(this.awj, d.C0140d.cp_bg_line_d, i);
        } else if (this.awp > 0) {
            am.d(this.awj, this.awp, i);
        }
        if (this.awh != 0) {
            am.e(this.awg, this.awh, i);
        }
    }

    public void dD(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awg.getLayoutParams());
        layoutParams.height = i;
        this.awg.setLayoutParams(layoutParams);
        this.awg.setVisibility(0);
    }

    public void AC() {
        this.awg.setVisibility(8);
    }

    public void AD() {
        this.awn.setVisibility(0);
        this.awm.setVisibility(0);
        this.awj.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        AC();
    }

    public void dE(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awg.getLayoutParams());
        layoutParams.height = i;
        this.awg.setLayoutParams(layoutParams);
        this.awg.setVisibility(0);
        this.awn.setVisibility(8);
        this.awm.setVisibility(8);
        this.awj.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean AE() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
