package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
/* loaded from: classes.dex */
public class ShareSDKImageView extends TbClipImageView {
    private int Lf;
    private int Lg;

    public ShareSDKImageView(Context context) {
        this(context, null, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Lf = com.baidu.tieba.v.pic_share_link;
        this.Lg = com.baidu.tieba.t.cp_cont_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(false);
        setIsRound(false);
        setDefaultResource(this.Lf);
        setDefaultBgResource(this.Lg);
    }
}
