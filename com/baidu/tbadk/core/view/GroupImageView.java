package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class GroupImageView extends com.baidu.tbadk.widget.d {
    private int aiu;
    private int aiv;

    public GroupImageView(Context context) {
        this(context, null, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiu = w.g.transparent_bg;
        this.aiv = w.e.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.aiu);
        setDefaultErrorResource(w.g.icon_default_group_120);
        setDefaultBgResource(this.aiv);
    }
}
