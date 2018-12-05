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
    private View amM = null;
    private View aIm = null;
    private int aIn = 0;
    private String aIo = null;
    private LinearLayout aIp = null;
    private int mTextColor = 0;
    private int aIq = e.d.cp_cont_e;
    private int aIr = e.d.cp_bg_line_b;
    private ImageView aIs = null;
    private LinearLayout aIt = null;
    private boolean aIu = true;
    private int mSkinType = -1;
    private int aIv = 0;

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
    public View oD() {
        this.amM = LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        this.aIp = (LinearLayout) this.amM.findViewById(e.g.pb_more_view);
        this.mTextView = (TextView) this.amM.findViewById(e.g.pb_more_text);
        if (this.aIu) {
            this.aIp.setVisibility(0);
        } else {
            this.aIp.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.amM.findViewById(e.g.progress);
        this.aIs = (ImageView) this.amM.findViewById(e.g.pb_more_view_top_line);
        this.aIm = this.amM.findViewById(e.g.empty_view);
        this.aIt = (LinearLayout) this.amM.findViewById(e.g.pb_more_top_extra_view);
        return this.amM;
    }

    public void bG(boolean z) {
        this.aIu = z;
    }

    public void et(int i) {
        this.aIr = i;
    }

    public void EY() {
        this.aIs.setVisibility(0);
    }

    public void EZ() {
        this.aIs.setVisibility(8);
    }

    public void Fa() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIs.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.aIs.setLayoutParams(layoutParams);
    }

    public void Fb() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIs.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1);
        this.aIs.setLayoutParams(layoutParams);
    }

    public void eu(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIs.getLayoutParams();
        layoutParams.height = i;
        this.aIs.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void Fc() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Fd() {
        this.mProgressBar.setVisibility(8);
        if (this.aIo != null) {
            this.mTextView.setText(this.aIo);
        } else {
            this.mTextView.setText(this.mContext.getText(e.j.pb_load_more));
        }
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Fe() {
        setText(this.mContext.getResources().getString(e.j.list_no_more));
        Fd();
    }

    public void Ff() {
        this.mTextView.setVisibility(0);
        this.aIp.setVisibility(0);
        Fd();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(e.j.loading));
    }

    public void ev(int i) {
        al.i(this.aIp, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aIp.getLayoutParams());
        layoutParams.height = i;
        this.aIp.setLayoutParams(layoutParams);
    }

    public void Fg() {
        this.amM.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setText(String str) {
        this.aIo = str;
        this.mTextView.setText(str);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void ew(int i) {
        this.aIq = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.amM);
        }
    }

    public void ex(int i) {
        this.aIv = i;
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
        if (z && this.aIq != 0) {
            color = al.getColor(i, this.aIq);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.aIs, this.aIr, i);
        if (this.aIv == 0) {
            al.d(this.aIp, e.d.cp_bg_line_d, i);
        } else if (this.aIv > 0) {
            al.d(this.aIp, this.aIv, i);
        }
        if (this.aIn != 0) {
            al.e(this.aIm, this.aIn, i);
        }
    }

    public void ez(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aIm.getLayoutParams());
        layoutParams.height = i;
        this.aIm.setLayoutParams(layoutParams);
        this.aIm.setVisibility(0);
    }

    public void hideEmptyView() {
        this.aIm.setVisibility(8);
    }

    public void Fh() {
        this.aIt.setVisibility(0);
        this.aIs.setVisibility(0);
        this.aIp.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void eA(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aIm.getLayoutParams());
        layoutParams.height = i;
        this.aIm.setLayoutParams(layoutParams);
        this.aIm.setVisibility(0);
        this.aIt.setVisibility(8);
        this.aIs.setVisibility(8);
        this.aIp.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean Fi() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
