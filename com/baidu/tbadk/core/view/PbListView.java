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
    private View ano = null;
    private View aIP = null;
    private int aIQ = 0;
    private String aIR = null;
    private LinearLayout aIS = null;
    private int mTextColor = 0;
    private int aIT = e.d.cp_cont_e;
    private int aIU = e.d.cp_bg_line_b;
    private ImageView aIV = null;
    private LinearLayout aIW = null;
    private boolean aIX = true;
    private int mSkinType = -1;
    private int aIY = 0;

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
    public View oH() {
        this.ano = LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        this.aIS = (LinearLayout) this.ano.findViewById(e.g.pb_more_view);
        this.mTextView = (TextView) this.ano.findViewById(e.g.pb_more_text);
        if (this.aIX) {
            this.aIS.setVisibility(0);
        } else {
            this.aIS.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.ano.findViewById(e.g.progress);
        this.aIV = (ImageView) this.ano.findViewById(e.g.pb_more_view_top_line);
        this.aIP = this.ano.findViewById(e.g.empty_view);
        this.aIW = (LinearLayout) this.ano.findViewById(e.g.pb_more_top_extra_view);
        return this.ano;
    }

    public void bH(boolean z) {
        this.aIX = z;
    }

    public void et(int i) {
        this.aIU = i;
    }

    public void Fl() {
        this.aIV.setVisibility(0);
    }

    public void Fm() {
        this.aIV.setVisibility(8);
    }

    public void Fn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIV.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.aIV.setLayoutParams(layoutParams);
    }

    public void Fo() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIV.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1);
        this.aIV.setLayoutParams(layoutParams);
    }

    public void eu(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIV.getLayoutParams();
        layoutParams.height = i;
        this.aIV.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void Fp() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Fq() {
        this.mProgressBar.setVisibility(8);
        if (this.aIR != null) {
            this.mTextView.setText(this.aIR);
        } else {
            this.mTextView.setText(this.mContext.getText(e.j.pb_load_more));
        }
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Fr() {
        setText(this.mContext.getResources().getString(e.j.list_no_more));
        Fq();
    }

    public void Fs() {
        this.mTextView.setVisibility(0);
        this.aIS.setVisibility(0);
        Fq();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
    }

    public void ev(int i) {
        al.i(this.aIS, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aIS.getLayoutParams());
        layoutParams.height = i;
        this.aIS.setLayoutParams(layoutParams);
    }

    public void Ft() {
        this.ano.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setText(String str) {
        this.aIR = str;
        this.mTextView.setText(str);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void ew(int i) {
        this.aIT = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.ano);
        }
    }

    public void ex(int i) {
        this.aIY = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void ey(int i) {
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
        if (z && this.aIT != 0) {
            color = al.getColor(i, this.aIT);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.aIV, this.aIU, i);
        if (this.aIY == 0) {
            al.d(this.aIS, e.d.cp_bg_line_d, i);
        } else if (this.aIY > 0) {
            al.d(this.aIS, this.aIY, i);
        }
        if (this.aIQ != 0) {
            al.e(this.aIP, this.aIQ, i);
        }
    }

    public void ez(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aIP.getLayoutParams());
        layoutParams.height = i;
        this.aIP.setLayoutParams(layoutParams);
        this.aIP.setVisibility(0);
    }

    public void hideEmptyView() {
        this.aIP.setVisibility(8);
    }

    public void Fu() {
        this.aIW.setVisibility(0);
        this.aIV.setVisibility(0);
        this.aIS.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void eA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aIP.getLayoutParams());
        layoutParams.height = i;
        this.aIP.setLayoutParams(layoutParams);
        this.aIP.setVisibility(0);
        this.aIW.setVisibility(8);
        this.aIV.setVisibility(8);
        this.aIS.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean Fv() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
