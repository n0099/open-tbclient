package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView WJ = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View MM = null;
    private View agQ = null;
    private String agR = null;
    private LinearLayout agS = null;
    private int mTextColor = 0;
    private int agT = r.d.cp_bg_line_b;
    private ImageView agU = null;
    private LinearLayout agV = null;
    private int agW = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (agX) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static IconType[] valuesCustom() {
            IconType[] valuesCustom = values();
            int length = valuesCustom.length;
            IconType[] iconTypeArr = new IconType[length];
            System.arraycopy(valuesCustom, 0, iconTypeArr, 0, length);
            return iconTypeArr;
        }
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.MM = LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_more, (ViewGroup) null);
        this.agS = (LinearLayout) this.MM.findViewById(r.g.pb_more_view);
        this.WJ = (TextView) this.MM.findViewById(r.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.MM.findViewById(r.g.progress);
        this.agU = (ImageView) this.MM.findViewById(r.g.pb_more_view_top_line);
        this.agQ = this.MM.findViewById(r.g.empty_view);
        this.agV = (LinearLayout) this.MM.findViewById(r.g.pb_more_top_extra_view);
        return this.MM;
    }

    public void wy() {
        this.agU.setVisibility(0);
    }

    public void wz() {
        this.agU.setVisibility(8);
    }

    public void wA() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agU.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.agU.setLayoutParams(layoutParams);
    }

    public void wB() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agU.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds1);
        this.agU.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.WJ.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    public LinearLayout wC() {
        return this.agV;
    }

    public void wD() {
        if (this.agV.getVisibility() != 0) {
            this.agV.setVisibility(0);
        }
    }

    public void wE() {
        if (8 != this.agV.getVisibility()) {
            this.agV.setVisibility(8);
        }
    }

    public void wF() {
        this.mProgressBar.setVisibility(0);
        this.WJ.setText(this.mContext.getText(r.j.loading));
        di(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wG() {
        this.mProgressBar.setVisibility(8);
        if (this.agR != null) {
            this.WJ.setText(this.agR);
        } else {
            this.WJ.setText(this.mContext.getText(r.j.pb_load_more));
        }
        di(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wH() {
        this.WJ.setVisibility(0);
        this.agS.setVisibility(0);
        wG();
    }

    public void wI() {
        this.mProgressBar.setVisibility(0);
        this.WJ.setText(this.mContext.getText(r.j.loading));
    }

    public void dg(int i) {
        at.k(this.agS, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agS.getLayoutParams());
        layoutParams.height = i;
        this.agS.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.agR = str;
        this.WJ.setText(str);
        di(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.MM);
        }
    }

    public void dh(int i) {
        this.agW = i;
    }

    public void di(int i) {
        String charSequence = this.WJ.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(r.j.pb_load_more))) {
            i2 = at.getColor(r.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(r.j.loading))) {
            i2 = at.getColor(r.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(r.j.list_no_more))) {
            i2 = at.getColor(r.d.common_color_10005);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.WJ.setTextColor(i2);
        }
        at.c(this.agU, this.agT);
        if (this.agW == 0) {
            at.k(this.agS, r.d.cp_bg_line_d);
        } else if (this.agW > 0) {
            at.k(this.agS, this.agW);
        }
    }

    public void dj(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agQ.getLayoutParams());
        layoutParams.height = i;
        this.agQ.setLayoutParams(layoutParams);
        this.agQ.setVisibility(0);
    }

    public void wJ() {
        this.agQ.setVisibility(8);
    }

    public void wK() {
        this.agV.setVisibility(0);
        this.agU.setVisibility(0);
        this.agS.setVisibility(0);
        this.WJ.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wJ();
    }

    public void dk(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agQ.getLayoutParams());
        layoutParams.height = i;
        this.agQ.setLayoutParams(layoutParams);
        this.agQ.setVisibility(0);
        this.agV.setVisibility(8);
        this.agU.setVisibility(8);
        this.agS.setVisibility(8);
        this.WJ.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wL() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
