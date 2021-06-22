package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class RoundTbImageView extends TbClipImageView {
    public int C0;
    public int D0;

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
        setDefaultBgResource(this.D0);
        setDefaultResource(this.C0);
        setAutoChangeStyle(true);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        setPlaceHolder(1);
    }

    public RoundTbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundTbImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.C0 = R.drawable.transparent_bg;
        this.D0 = R.color.CAM_X0209;
        G();
    }
}
