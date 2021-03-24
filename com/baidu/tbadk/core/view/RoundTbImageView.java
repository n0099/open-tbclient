package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class RoundTbImageView extends TbClipImageView {
    public int x0;
    public int y0;

    public RoundTbImageView(Context context) {
        this(context, null, 0);
    }

    public final void G() {
        setDrawerType(1);
        setIsRound(true);
        setConrers(15);
        setGifIconSupport(false);
        setDrawBorder(false);
        setBorderSurroundContent(false);
        setDefaultBgResource(this.y0);
        setDefaultResource(this.x0);
        setAutoChangeStyle(true);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        setPlaceHolder(1);
    }

    public RoundTbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundTbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x0 = R.drawable.transparent_bg;
        this.y0 = R.color.CAM_X0209;
        G();
    }
}
