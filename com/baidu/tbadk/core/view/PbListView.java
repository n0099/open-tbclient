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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private View afb = null;
    private String afc = null;
    private LinearLayout adD = null;
    private int mTextColor = 0;
    private ImageView afd = null;
    private int afe = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (aff) with 'values()' method */
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
    public View nn() {
        this.mRoot = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_more, (ViewGroup) null);
        this.adD = (LinearLayout) this.mRoot.findViewById(i.f.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.afd = (ImageView) this.mRoot.findViewById(i.f.pb_more_view_top_line);
        this.afb = this.mRoot.findViewById(i.f.empty_view);
        return this.mRoot;
    }

    public void vF() {
        this.afd.setVisibility(0);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(i.h.loading));
        cM(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void vG() {
        this.mProgressBar.setVisibility(8);
        if (this.afc != null) {
            this.mTextView.setText(this.afc);
        } else {
            this.mTextView.setText(this.mContext.getText(i.h.pb_load_more));
        }
        cM(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(i.h.loading));
    }

    public void cK(int i) {
        al.h(this.adD, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adD.getLayoutParams());
        layoutParams.height = i;
        this.adD.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.afc = str;
        this.mTextView.setText(str);
        cM(TbadkCoreApplication.m411getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void cL(int i) {
        this.afe = i;
    }

    public void cM(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(i.h.pb_load_more))) {
            i2 = al.getColor(i.c.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(i.h.loading))) {
            i2 = al.getColor(i.c.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(i.h.list_no_more))) {
            i2 = al.getColor(i.c.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        al.c(this.afd, i.c.cp_bg_line_b);
        if (this.afe == 0) {
            al.h(this.adD, i.c.cp_bg_line_d);
        } else if (this.afe > 0) {
            al.h(this.adD, this.afe);
        }
    }

    public void cN(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afb.getLayoutParams());
        layoutParams.height = i;
        this.afb.setLayoutParams(layoutParams);
        this.afb.setVisibility(0);
    }

    public void vH() {
        this.afb.setVisibility(8);
    }
}
