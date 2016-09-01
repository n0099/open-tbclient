package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class GroupImageView extends TbClipImageView {
    private int adE;
    private int adF;

    public GroupImageView(Context context) {
        this(context, null, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adE = t.f.transparent_bg;
        this.adF = t.d.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.adE);
        setDefaultErrorResource(t.f.icon_default_group_120);
        setDefaultBgResource(this.adF);
    }
}
