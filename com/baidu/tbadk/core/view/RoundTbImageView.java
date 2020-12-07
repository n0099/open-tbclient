package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class RoundTbImageView extends TbClipImageView {
    private int mDefaultBgId;
    private int mDefaultId;

    public RoundTbImageView(Context context) {
        this(context, null, 0);
    }

    public RoundTbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundTbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDefaultId = R.drawable.transparent_bg;
        this.mDefaultBgId = R.color.CAM_X0209;
        init();
    }

    private void init() {
        setDrawerType(1);
        setIsRound(true);
        setConrers(15);
        setGifIconSupport(false);
        setDrawBorder(false);
        setBorderSurroundContent(false);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setAutoChangeStyle(true);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        setPlaceHolder(1);
    }
}
