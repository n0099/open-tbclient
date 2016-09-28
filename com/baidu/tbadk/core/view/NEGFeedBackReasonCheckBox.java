package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class NEGFeedBackReasonCheckBox extends CheckBox {
    private Context mContext;

    public NEGFeedBackReasonCheckBox(Context context) {
        super(context);
        this.mContext = null;
        this.mContext = context;
        init();
    }

    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mContext = context;
        init();
    }

    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mContext = context;
        init();
    }

    private void init() {
        av.k(this, r.f.btn_home_neg_feedback_reason_selector);
        av.c(this, r.f.text_home_neg_feedback_reason_selector, 4);
        int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
        setPadding(e, 0, e, 0);
        setButtonDrawable((Drawable) null);
    }
}
