package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private com.baidu.tbadk.core.data.ah afg;
    private View.OnClickListener afh;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new c(this);
        this.mContext = context;
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new c(this);
        this.mContext = context;
    }

    public void setData(com.baidu.tbadk.core.data.ah ahVar) {
        if (ahVar != null && ahVar.getAuthor() != null && ahVar.getAuthor().getPortrait() != null) {
            this.afg = ahVar;
            setOnClickListener(this.mOnClickListener);
            d(ahVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afh = onClickListener;
    }
}
