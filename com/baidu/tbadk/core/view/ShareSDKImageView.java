package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ShareSDKImageView extends TbClipImageView {
    private int acI;
    private int acJ;

    public ShareSDKImageView(Context context) {
        this(context, null, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareSDKImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acI = i.e.pic_share_link;
        this.acJ = i.c.cp_cont_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(false);
        setIsRound(false);
        setDefaultResource(this.acI);
        setDefaultBgResource(this.acJ);
    }
}
