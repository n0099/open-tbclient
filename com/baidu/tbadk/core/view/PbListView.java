package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.i {
    private LinearLayout Mz;
    private String NF;
    private ImageView NG;
    private int NH;
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

        /* JADX DEBUG: Replace access to removed values field (NI) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static IconType[] valuesCustom() {
            IconType[] valuesCustom = values();
            int length = valuesCustom.length;
            IconType[] iconTypeArr = new IconType[length];
            System.arraycopy(valuesCustom, 0, iconTypeArr, 0, length);
            return iconTypeArr;
        }
    }

    public String qC() {
        return this.NF;
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.mRoot = null;
        this.NF = null;
        this.Mz = null;
        this.mTextColor = 0;
        this.NG = null;
        this.NH = 0;
        this.mContext = context;
    }

    public PbListView(Context context, IconType iconType) {
        this(context);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jr() {
        this.mRoot = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.new_pb_list_more, null);
        this.Mz = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        this.NG = (ImageView) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_view_top_line);
        return this.mRoot;
    }

    public void qD() {
        this.NG.setVisibility(0);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(com.baidu.tieba.z.loading));
        cs(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void qE() {
        this.mProgressBar.setVisibility(8);
        if (this.NF != null) {
            this.mTextView.setText(this.NF);
        } else {
            this.mTextView.setText(this.mContext.getText(com.baidu.tieba.z.pb_load_more));
        }
        cs(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void cq(int i) {
        bc.i(this.Mz, i);
    }

    public void setText(String str) {
        this.NF = str;
        this.mTextView.setText(str);
        cs(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void cr(int i) {
        this.NH = i;
    }

    public void cs(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(com.baidu.tieba.z.pb_load_more))) {
            i2 = bc.getColor(com.baidu.tieba.t.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.z.loading))) {
            i2 = bc.getColor(com.baidu.tieba.t.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.z.no_more_to_load))) {
            i2 = bc.getColor(com.baidu.tieba.t.pb_more_txt);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        bc.c(this.NG, com.baidu.tieba.t.cp_bg_line_b);
        if (this.NH == 0) {
            bc.i(this.Mz, com.baidu.tieba.t.cp_bg_line_d);
        } else if (this.NH > 0) {
            bc.i(this.Mz, this.NH);
        }
    }
}
