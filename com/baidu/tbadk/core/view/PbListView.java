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
    private View abt = null;
    private View awA = null;
    private int awB = 0;
    private String awC = null;
    private LinearLayout awD = null;
    private int mTextColor = 0;
    private int awE = d.C0142d.cp_cont_e;
    private int awF = d.C0142d.cp_bg_line_b;
    private ImageView awG = null;
    private LinearLayout awH = null;
    private boolean awI = true;
    private int mSkinType = -1;
    private int awJ = 0;

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
        this.abt = LayoutInflater.from(this.mContext).inflate(d.i.new_pb_list_more, (ViewGroup) null);
        this.awD = (LinearLayout) this.abt.findViewById(d.g.pb_more_view);
        this.mTextView = (TextView) this.abt.findViewById(d.g.pb_more_text);
        if (this.awI) {
            this.awD.setVisibility(0);
        } else {
            this.awD.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.abt.findViewById(d.g.progress);
        this.awG = (ImageView) this.abt.findViewById(d.g.pb_more_view_top_line);
        this.awA = this.abt.findViewById(d.g.empty_view);
        this.awH = (LinearLayout) this.abt.findViewById(d.g.pb_more_top_extra_view);
        return this.abt;
    }

    public void aT(boolean z) {
        this.awI = z;
    }

    public void dv(int i) {
        this.awF = i;
    }

    public void AD() {
        this.awG.setVisibility(0);
    }

    public void AE() {
        this.awG.setVisibility(8);
    }

    public void AF() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awG.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.awG.setLayoutParams(layoutParams);
    }

    public void AG() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awG.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1);
        this.awG.setLayoutParams(layoutParams);
    }

    public void dw(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awG.getLayoutParams();
        layoutParams.height = i;
        this.awG.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void AH() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.k.loading));
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void AI() {
        this.mProgressBar.setVisibility(8);
        if (this.awC != null) {
            this.mTextView.setText(this.awC);
        } else {
            this.mTextView.setText(this.mContext.getText(d.k.pb_load_more));
        }
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void AJ() {
        setText(this.mContext.getResources().getString(d.k.list_no_more));
        AI();
    }

    public void AK() {
        this.mTextView.setVisibility(0);
        this.awD.setVisibility(0);
        AI();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.k.loading));
    }

    public void setBackground(int i) {
        am.i(this.awD, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awD.getLayoutParams());
        layoutParams.height = i;
        this.awD.setLayoutParams(layoutParams);
    }

    public void AL() {
        this.abt.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setText(String str) {
        this.awC = str;
        this.mTextView.setText(str);
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void dx(int i) {
        this.awE = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.abt);
        }
    }

    public void dy(int i) {
        this.awJ = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void dz(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.k.pb_load_more))) {
            color = am.getColor(i, d.C0142d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.k.loading))) {
            color = am.getColor(i, d.C0142d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.k.list_no_more)) || charSequence.equals(this.mContext.getText(d.k.list_has_no_more))) {
            color = am.getColor(i, d.C0142d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.k.list_no_more_new))) {
            color = am.getColor(i, d.C0142d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.k.list_click_load_more)) ? am.getColor(i, d.C0142d.cp_cont_d) : 0;
        }
        if (z && this.awE != 0) {
            color = am.getColor(i, this.awE);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        am.b(this.awG, this.awF, i);
        if (this.awJ == 0) {
            am.d(this.awD, d.C0142d.cp_bg_line_d, i);
        } else if (this.awJ > 0) {
            am.d(this.awD, this.awJ, i);
        }
        if (this.awB != 0) {
            am.e(this.awA, this.awB, i);
        }
    }

    public void dA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awA.getLayoutParams());
        layoutParams.height = i;
        this.awA.setLayoutParams(layoutParams);
        this.awA.setVisibility(0);
    }

    public void AM() {
        this.awA.setVisibility(8);
    }

    public void AN() {
        this.awH.setVisibility(0);
        this.awG.setVisibility(0);
        this.awD.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        AM();
    }

    public void dB(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awA.getLayoutParams());
        layoutParams.height = i;
        this.awA.setLayoutParams(layoutParams);
        this.awA.setVisibility(0);
        this.awH.setVisibility(8);
        this.awG.setVisibility(8);
        this.awD.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean AO() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
