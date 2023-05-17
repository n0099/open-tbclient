package com.baidu.nadcore.player.tail;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AdEmbeddedTailFrameView extends AdBaseTailFrameView {
    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public int f() {
        return R.layout.nad_video_ad_tail_frame;
    }

    public AdEmbeddedTailFrameView(Context context) {
        this(context, null);
    }

    public AdEmbeddedTailFrameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdEmbeddedTailFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public void g() {
        super.g();
        this.c.setTextColor(getResources().getColor(R.color.NAD_FC6));
        this.d.setTextColor(getResources().getColor(R.color.NAD_FC38));
        this.e.setTextColor(getResources().getColor(R.color.NAD_FC38));
        this.d.setBackgroundDrawable(getResources().getDrawable(R.drawable.nad_video_ad_tail_btn_selector));
        this.e.setBackgroundDrawable(getResources().getDrawable(R.drawable.nad_video_ad_tail_btn_selector));
        this.k.setTextColor(getResources().getColor(R.color.nad_tail_time_close));
    }
}
