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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView YG = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sn = null;
    private View agP = null;
    private String agQ = null;
    private LinearLayout agR = null;
    private int mTextColor = 0;
    private int agS = t.d.cp_bg_line_b;
    private ImageView agT = null;
    private LinearLayout agU = null;
    private int agV = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (agW) with 'values()' method */
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
    public View ni() {
        this.Sn = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_more, (ViewGroup) null);
        this.agR = (LinearLayout) this.Sn.findViewById(t.g.pb_more_view);
        this.YG = (TextView) this.Sn.findViewById(t.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.Sn.findViewById(t.g.progress);
        this.agT = (ImageView) this.Sn.findViewById(t.g.pb_more_view_top_line);
        this.agP = this.Sn.findViewById(t.g.empty_view);
        this.agU = (LinearLayout) this.Sn.findViewById(t.g.pb_more_top_extra_view);
        return this.Sn;
    }

    public void wW() {
        this.agT.setVisibility(0);
    }

    public void wX() {
        this.agT.setVisibility(8);
    }

    public LinearLayout wY() {
        return this.agU;
    }

    public void wZ() {
        if (this.agU.getVisibility() != 0) {
            this.agU.setVisibility(0);
        }
    }

    public void xa() {
        if (8 != this.agU.getVisibility()) {
            this.agU.setVisibility(8);
        }
    }

    public void xb() {
        this.mProgressBar.setVisibility(0);
        this.YG.setText(this.mContext.getText(t.j.loading));
        dg(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void xc() {
        this.mProgressBar.setVisibility(8);
        if (this.agQ != null) {
            this.YG.setText(this.agQ);
        } else {
            this.YG.setText(this.mContext.getText(t.j.pb_load_more));
        }
        dg(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.YG.setText(this.mContext.getText(t.j.loading));
    }

    public void de(int i) {
        ar.k(this.agR, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agR.getLayoutParams());
        layoutParams.height = i;
        this.agR.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.agQ = str;
        this.YG.setText(str);
        dg(TbadkCoreApplication.m411getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.Sn);
        }
    }

    public void df(int i) {
        this.agV = i;
    }

    public void dg(int i) {
        String charSequence = this.YG.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(t.j.pb_load_more))) {
            i2 = ar.getColor(t.d.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(t.j.loading))) {
            i2 = ar.getColor(t.d.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(t.j.list_no_more))) {
            i2 = ar.getColor(t.d.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.YG.setTextColor(i2);
        }
        ar.c(this.agT, this.agS);
        if (this.agV == 0) {
            ar.k(this.agR, t.d.cp_bg_line_d);
        } else if (this.agV > 0) {
            ar.k(this.agR, this.agV);
        }
    }

    public void dh(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agP.getLayoutParams());
        layoutParams.height = i;
        this.agP.setLayoutParams(layoutParams);
        this.agP.setVisibility(0);
    }

    public void xd() {
        this.agP.setVisibility(8);
    }

    public void xe() {
        this.agU.setVisibility(0);
        this.agT.setVisibility(0);
        this.agR.setVisibility(0);
        this.YG.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        xd();
    }

    public void di(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agP.getLayoutParams());
        layoutParams.height = i;
        this.agP.setLayoutParams(layoutParams);
        this.agP.setVisibility(0);
        this.agU.setVisibility(8);
        this.agT.setVisibility(8);
        this.agR.setVisibility(8);
        this.YG.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }
}
