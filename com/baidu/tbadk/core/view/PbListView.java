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
    private View adA = null;
    private View azo = null;
    private int azp = 0;
    private String azq = null;
    private LinearLayout azr = null;
    private int mTextColor = 0;
    private int azs = e.d.cp_cont_e;
    private int azt = e.d.cp_bg_line_b;
    private ImageView azu = null;
    private LinearLayout azv = null;
    private boolean azw = true;
    private int mSkinType = -1;
    private int azx = 0;

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
    public View ov() {
        this.adA = LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        this.azr = (LinearLayout) this.adA.findViewById(e.g.pb_more_view);
        this.mTextView = (TextView) this.adA.findViewById(e.g.pb_more_text);
        if (this.azw) {
            this.azr.setVisibility(0);
        } else {
            this.azr.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.adA.findViewById(e.g.progress);
        this.azu = (ImageView) this.adA.findViewById(e.g.pb_more_view_top_line);
        this.azo = this.adA.findViewById(e.g.empty_view);
        this.azv = (LinearLayout) this.adA.findViewById(e.g.pb_more_top_extra_view);
        return this.adA;
    }

    public void be(boolean z) {
        this.azw = z;
    }

    public void dH(int i) {
        this.azt = i;
    }

    public void BE() {
        this.azu.setVisibility(0);
    }

    public void BF() {
        this.azu.setVisibility(8);
    }

    public void BG() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azu.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.azu.setLayoutParams(layoutParams);
    }

    public void BH() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azu.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds1);
        this.azu.setLayoutParams(layoutParams);
    }

    public void dI(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azu.getLayoutParams();
        layoutParams.height = i;
        this.azu.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void BI() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
        dM(TbadkCoreApplication.getInst().getSkinType());
    }

    public void BJ() {
        this.mProgressBar.setVisibility(8);
        if (this.azq != null) {
            this.mTextView.setText(this.azq);
        } else {
            this.mTextView.setText(this.mContext.getText(e.j.pb_load_more));
        }
        dM(TbadkCoreApplication.getInst().getSkinType());
    }

    public void BK() {
        setText(this.mContext.getResources().getString(e.j.list_no_more));
        BJ();
    }

    public void BL() {
        this.mTextView.setVisibility(0);
        this.azr.setVisibility(0);
        BJ();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
    }

    public void dJ(int i) {
        al.i(this.azr, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.azr.getLayoutParams());
        layoutParams.height = i;
        this.azr.setLayoutParams(layoutParams);
    }

    public void BM() {
        this.adA.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setText(String str) {
        this.azq = str;
        this.mTextView.setText(str);
        dM(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dK(int i) {
        this.azs = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.adA);
        }
    }

    public void dL(int i) {
        this.azx = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dM(int i) {
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
        if (z && this.azs != 0) {
            color = al.getColor(i, this.azs);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.azu, this.azt, i);
        if (this.azx == 0) {
            al.d(this.azr, e.d.cp_bg_line_d, i);
        } else if (this.azx > 0) {
            al.d(this.azr, this.azx, i);
        }
        if (this.azp != 0) {
            al.e(this.azo, this.azp, i);
        }
    }

    public void dN(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.azo.getLayoutParams());
        layoutParams.height = i;
        this.azo.setLayoutParams(layoutParams);
        this.azo.setVisibility(0);
    }

    public void hideEmptyView() {
        this.azo.setVisibility(8);
    }

    public void BN() {
        this.azv.setVisibility(0);
        this.azu.setVisibility(0);
        this.azr.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void dO(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.azo.getLayoutParams());
        layoutParams.height = i;
        this.azo.setLayoutParams(layoutParams);
        this.azo.setVisibility(0);
        this.azv.setVisibility(8);
        this.azu.setVisibility(8);
        this.azr.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean BO() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
