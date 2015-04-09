package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.e {
    private LinearLayout XI;
    private String YQ;
    private ImageView YR;
    private int YS;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private ProgressBar mProgressBar;
    private View mRoot;
    private int mTextColor;
    private TextView mTextView;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (YT) with 'values()' method */
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
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.mRoot = null;
        this.YQ = null;
        this.XI = null;
        this.mTextColor = 0;
        this.YR = null;
        this.YS = 0;
        this.mContext = context;
    }

    public PbListView(Context context, IconType iconType) {
        this(context);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View mN() {
        this.mRoot = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.new_pb_list_more, null);
        this.XI = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        this.YR = (ImageView) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_view_top_line);
        return this.mRoot;
    }

    public void tN() {
        this.YR.setVisibility(0);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(com.baidu.tieba.y.loading));
        ct(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void tO() {
        this.mProgressBar.setVisibility(8);
        if (this.YQ != null) {
            this.mTextView.setText(this.YQ);
        } else {
            this.mTextView.setText(this.mContext.getText(com.baidu.tieba.y.pb_load_more));
        }
        ct(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cr(int i) {
        ba.i(this.XI, i);
    }

    public void setText(String str) {
        this.YQ = str;
        this.mTextView.setText(str);
        ct(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void cs(int i) {
        this.YS = i;
    }

    public void ct(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(com.baidu.tieba.y.pb_load_more))) {
            i2 = ba.getColor(com.baidu.tieba.s.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.y.loading))) {
            i2 = ba.getColor(com.baidu.tieba.s.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.y.list_no_more))) {
            i2 = ba.getColor(com.baidu.tieba.s.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        ba.c(this.YR, com.baidu.tieba.s.cp_bg_line_b);
        if (this.YS == 0) {
            ba.i(this.XI, com.baidu.tieba.s.cp_bg_line_d);
        } else if (this.YS > 0) {
            ba.i(this.XI, this.YS);
        }
    }
}
