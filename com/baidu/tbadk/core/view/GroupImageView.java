package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class GroupImageView extends TbClipImageView {
    private int aeA;
    private int aez;

    public GroupImageView(Context context) {
        this(context, null, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aez = n.f.icon_default_group_120;
        this.aeA = n.d.cp_cont_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.aez);
        setDefaultBgResource(this.aeA);
    }
}
