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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View aaW = null;
    private View awd = null;
    private int awe = 0;
    private String awf = null;
    private LinearLayout awg = null;
    private int mTextColor = 0;
    private int awh = f.d.cp_cont_e;
    private int awi = f.d.cp_bg_line_b;
    private ImageView awj = null;
    private LinearLayout awk = null;
    private boolean awl = true;
    private int mSkinType = -1;
    private int awm = 0;

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
        this.aaW = LayoutInflater.from(this.mContext).inflate(f.h.new_pb_list_more, (ViewGroup) null);
        this.awg = (LinearLayout) this.aaW.findViewById(f.g.pb_more_view);
        this.mTextView = (TextView) this.aaW.findViewById(f.g.pb_more_text);
        if (this.awl) {
            this.awg.setVisibility(0);
        } else {
            this.awg.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.aaW.findViewById(f.g.progress);
        this.awj = (ImageView) this.aaW.findViewById(f.g.pb_more_view_top_line);
        this.awd = this.aaW.findViewById(f.g.empty_view);
        this.awk = (LinearLayout) this.aaW.findViewById(f.g.pb_more_top_extra_view);
        return this.aaW;
    }

    public void aS(boolean z) {
        this.awl = z;
    }

    public void dw(int i) {
        this.awi = i;
    }

    public void Ar() {
        this.awj.setVisibility(0);
    }

    public void As() {
        this.awj.setVisibility(8);
    }

    public void At() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awj.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.awj.setLayoutParams(layoutParams);
    }

    public void Au() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awj.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds1);
        this.awj.setLayoutParams(layoutParams);
    }

    public void dx(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awj.getLayoutParams();
        layoutParams.height = i;
        this.awj.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void Av() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(f.j.loading));
        dB(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Aw() {
        this.mProgressBar.setVisibility(8);
        if (this.awf != null) {
            this.mTextView.setText(this.awf);
        } else {
            this.mTextView.setText(this.mContext.getText(f.j.pb_load_more));
        }
        dB(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Ax() {
        setText(this.mContext.getResources().getString(f.j.list_no_more));
        Aw();
    }

    public void Ay() {
        this.mTextView.setVisibility(0);
        this.awg.setVisibility(0);
        Aw();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(f.j.loading));
    }

    public void dy(int i) {
        am.i(this.awg, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awg.getLayoutParams());
        layoutParams.height = i;
        this.awg.setLayoutParams(layoutParams);
    }

    public void Az() {
        this.aaW.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setText(String str) {
        this.awf = str;
        this.mTextView.setText(str);
        dB(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dz(int i) {
        this.awh = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aaW);
        }
    }

    public void dA(int i) {
        this.awm = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dB(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(f.j.pb_load_more))) {
            color = am.getColor(i, f.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(f.j.loading))) {
            color = am.getColor(i, f.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(f.j.list_no_more)) || charSequence.equals(this.mContext.getText(f.j.list_has_no_more))) {
            color = am.getColor(i, f.d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(f.j.list_no_more_new))) {
            color = am.getColor(i, f.d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(f.j.list_click_load_more)) ? am.getColor(i, f.d.cp_cont_d) : 0;
        }
        if (z && this.awh != 0) {
            color = am.getColor(i, this.awh);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        am.b(this.awj, this.awi, i);
        if (this.awm == 0) {
            am.d(this.awg, f.d.cp_bg_line_d, i);
        } else if (this.awm > 0) {
            am.d(this.awg, this.awm, i);
        }
        if (this.awe != 0) {
            am.e(this.awd, this.awe, i);
        }
    }

    public void dC(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awd.getLayoutParams());
        layoutParams.height = i;
        this.awd.setLayoutParams(layoutParams);
        this.awd.setVisibility(0);
    }

    public void hideEmptyView() {
        this.awd.setVisibility(8);
    }

    public void AA() {
        this.awk.setVisibility(0);
        this.awj.setVisibility(0);
        this.awg.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void dD(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awd.getLayoutParams());
        layoutParams.height = i;
        this.awd.setLayoutParams(layoutParams);
        this.awd.setVisibility(0);
        this.awk.setVisibility(8);
        this.awj.setVisibility(8);
        this.awg.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean AB() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
