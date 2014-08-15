package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class GroupImageView extends com.baidu.tbadk.widget.j {
    private int d;
    private int e;
    private int f;
    private int g;

    public GroupImageView(Context context) {
        this(context, null, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = com.baidu.tieba.t.icon_default_group_120;
        this.e = com.baidu.tieba.t.icon_default_group_120_1;
        this.f = com.baidu.tieba.r.cp_cont_e;
        this.g = com.baidu.tieba.r.cp_cont_e_1;
        g();
    }

    private void g() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.d);
        setNightDefaultResource(this.e);
        setDefaultBgResource(this.f);
        setNightDefaultBgResource(this.g);
    }
}
