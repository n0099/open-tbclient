package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class GroupImageView extends com.baidu.tbadk.widget.e {
    private int ahN;
    private int ahO;

    public GroupImageView(Context context) {
        this(context, null, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahN = w.g.transparent_bg;
        this.ahO = w.e.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.ahN);
        setDefaultErrorResource(w.g.icon_default_group_120);
        setDefaultBgResource(this.ahO);
    }
}
