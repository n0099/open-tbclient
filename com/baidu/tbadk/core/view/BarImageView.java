package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
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
        this.mDefaultId = e.f.icon_default_ba_120;
        this.mDefaultBgId = e.d.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(e.f.icon_default_ba_120);
        setDefaultBgResource(this.mDefaultBgId);
    }
}
