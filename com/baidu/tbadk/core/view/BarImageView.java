package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BarImageView extends com.baidu.tbadk.widget.b {
    private int mDefaultBgId;
    private int mDefaultId;

    public BarImageView(Context context) {
        this(context, null, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDefaultId = d.f.icon_default_ba_120;
        this.mDefaultBgId = d.C0141d.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(d.f.icon_default_ba_120);
        setDefaultBgResource(this.mDefaultBgId);
    }
}
