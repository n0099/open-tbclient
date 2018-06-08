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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View abp = null;
    private View avR = null;
    private int avS = 0;
    private String avT = null;
    private LinearLayout avU = null;
    private int mTextColor = 0;
    private int avV = d.C0141d.cp_cont_e;
    private int avW = d.C0141d.cp_bg_line_b;
    private ImageView avX = null;
    private LinearLayout avY = null;
    private boolean avZ = true;
    private int mSkinType = -1;
    private int awa = 0;

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
    public View nn() {
        this.abp = LayoutInflater.from(this.mContext).inflate(d.i.new_pb_list_more, (ViewGroup) null);
        this.avU = (LinearLayout) this.abp.findViewById(d.g.pb_more_view);
        this.mTextView = (TextView) this.abp.findViewById(d.g.pb_more_text);
        if (this.avZ) {
            this.avU.setVisibility(0);
        } else {
            this.avU.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.abp.findViewById(d.g.progress);
        this.avX = (ImageView) this.abp.findViewById(d.g.pb_more_view_top_line);
        this.avR = this.abp.findViewById(d.g.empty_view);
        this.avY = (LinearLayout) this.abp.findViewById(d.g.pb_more_top_extra_view);
        return this.abp;
    }

    public void aR(boolean z) {
        this.avZ = z;
    }

    public void du(int i) {
        this.avW = i;
    }

    public void An() {
        this.avX.setVisibility(0);
    }

    public void Ao() {
        this.avX.setVisibility(8);
    }

    public void Ap() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avX.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.avX.setLayoutParams(layoutParams);
    }

    public void Aq() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avX.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1);
        this.avX.setLayoutParams(layoutParams);
    }

    public void dv(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avX.getLayoutParams();
        layoutParams.height = i;
        this.avX.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void Ar() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.k.loading));
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void As() {
        this.mProgressBar.setVisibility(8);
        if (this.avT != null) {
            this.mTextView.setText(this.avT);
        } else {
            this.mTextView.setText(this.mContext.getText(d.k.pb_load_more));
        }
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void At() {
        setText(this.mContext.getResources().getString(d.k.list_no_more));
        As();
    }

    public void Au() {
        this.mTextView.setVisibility(0);
        this.avU.setVisibility(0);
        As();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.k.loading));
    }

    public void setBackground(int i) {
        al.i(this.avU, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.avU.getLayoutParams());
        layoutParams.height = i;
        this.avU.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.avT = str;
        this.mTextView.setText(str);
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dw(int i) {
        this.avV = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.abp);
        }
    }

    public void dx(int i) {
        this.awa = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dy(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.k.pb_load_more))) {
            color = al.getColor(i, d.C0141d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.k.loading))) {
            color = al.getColor(i, d.C0141d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.k.list_no_more)) || charSequence.equals(this.mContext.getText(d.k.list_has_no_more))) {
            color = al.getColor(i, d.C0141d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.k.list_no_more_new))) {
            color = al.getColor(i, d.C0141d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.k.list_click_load_more)) ? al.getColor(i, d.C0141d.cp_cont_d) : 0;
        }
        if (z && this.avV != 0) {
            color = al.getColor(i, this.avV);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.avX, this.avW, i);
        if (this.awa == 0) {
            al.d(this.avU, d.C0141d.cp_bg_line_d, i);
        } else if (this.awa > 0) {
            al.d(this.avU, this.awa, i);
        }
        if (this.avS != 0) {
            al.e(this.avR, this.avS, i);
        }
    }

    public void dz(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.avR.getLayoutParams());
        layoutParams.height = i;
        this.avR.setLayoutParams(layoutParams);
        this.avR.setVisibility(0);
    }

    public void Av() {
        this.avR.setVisibility(8);
    }

    public void Aw() {
        this.avY.setVisibility(0);
        this.avX.setVisibility(0);
        this.avU.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        Av();
    }

    public void dA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.avR.getLayoutParams());
        layoutParams.height = i;
        this.avR.setLayoutParams(layoutParams);
        this.avR.setVisibility(0);
        this.avY.setVisibility(8);
        this.avX.setVisibility(8);
        this.avU.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean Ax() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
