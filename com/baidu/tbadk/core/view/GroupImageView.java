package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class GroupImageView extends TbClipImageView {
    public int x0;
    public int y0;

    public GroupImageView(Context context) {
        this(context, null, 0);
    }

    public final void G() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.x0);
        setDefaultBgResource(this.y0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x0 = R.drawable.transparent_bg;
        this.y0 = R.color.CAM_X0205;
        G();
    }
}
