package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class GroupImageView extends TbClipImageView {
    private int acQ;
    private int acR;

    public GroupImageView(Context context) {
        this(context, null, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acQ = r.g.transparent_bg;
        this.acR = r.e.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.acQ);
        setDefaultErrorResource(r.g.icon_default_group_120);
        setDefaultBgResource(this.acR);
    }
}
