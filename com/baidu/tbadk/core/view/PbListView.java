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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private View aen = null;
    private String aeo = null;
    private LinearLayout aep = null;
    private int mTextColor = 0;
    private ImageView aeq = null;
    private int aer = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (aes) with 'values()' method */
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
    public View no() {
        this.mRoot = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_more, (ViewGroup) null);
        this.aep = (LinearLayout) this.mRoot.findViewById(i.f.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.aeq = (ImageView) this.mRoot.findViewById(i.f.pb_more_view_top_line);
        this.aen = this.mRoot.findViewById(i.f.empty_view);
        return this.mRoot;
    }

    public void vx() {
        this.aeq.setVisibility(0);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(i.h.loading));
        cN(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void vy() {
        this.mProgressBar.setVisibility(8);
        if (this.aeo != null) {
            this.mTextView.setText(this.aeo);
        } else {
            this.mTextView.setText(this.mContext.getText(i.h.pb_load_more));
        }
        cN(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(i.h.loading));
    }

    public void cL(int i) {
        am.i(this.aep, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aep.getLayoutParams());
        layoutParams.height = i;
        this.aep.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.aeo = str;
        this.mTextView.setText(str);
        cN(TbadkCoreApplication.m411getInst().getSkinType());
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

    public void cM(int i) {
        this.aer = i;
    }

    public void cN(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(i.h.pb_load_more))) {
            i2 = am.getColor(i.c.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(i.h.loading))) {
            i2 = am.getColor(i.c.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(i.h.list_no_more))) {
            i2 = am.getColor(i.c.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        am.c(this.aeq, i.c.cp_bg_line_b);
        if (this.aer == 0) {
            am.i(this.aep, i.c.cp_bg_line_d);
        } else if (this.aer > 0) {
            am.i(this.aep, this.aer);
        }
    }

    public void cO(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aen.getLayoutParams());
        layoutParams.height = i;
        this.aen.setLayoutParams(layoutParams);
        this.aen.setVisibility(0);
    }

    public void vz() {
        this.aen.setVisibility(8);
    }
}
