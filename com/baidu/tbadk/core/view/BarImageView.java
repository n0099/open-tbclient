package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private int aen;
    private int aeo;

    public BarImageView(Context context) {
        this(context, null, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aen = r.f.transparent_bg;
        this.aeo = r.d.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.aen);
        setDefaultErrorResource(r.f.icon_default_ba_120);
        setDefaultBgResource(this.aeo);
    }
}
