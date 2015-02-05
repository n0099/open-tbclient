package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private int Lw;
    private int Lx;

    public BarImageView(Context context) {
        this(context, null, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Lw = com.baidu.tieba.v.icon_default_ba_120;
        this.Lx = com.baidu.tieba.t.cp_cont_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.Lw);
        setDefaultBgResource(this.Lx);
    }
}
