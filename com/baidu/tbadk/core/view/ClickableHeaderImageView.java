package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private com.baidu.tbadk.core.data.z aeF;
    private View.OnClickListener aeG;
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

    public void setData(com.baidu.tbadk.core.data.z zVar) {
        if (zVar != null && zVar.getAuthor() != null && zVar.getAuthor().getPortrait() != null) {
            this.aeF = zVar;
            setOnClickListener(this.mOnClickListener);
            d(zVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aeG = onClickListener;
    }
}
