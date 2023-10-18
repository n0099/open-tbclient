package com.baidu.nadcore.player.tail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AdFullTailFrameView extends AdBaseTailFrameView {
    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public int e() {
        return R.layout.nad_video_tail_frame_full_view;
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
        }

        public a() {
        }
    }

    public AdFullTailFrameView(Context context) {
        super(context);
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public void d(Context context) {
        super.d(context);
        ((ImageView) findViewById(R.id.immersive_video_ad_tail_frame_full_back_btn)).setOnClickListener(new a());
    }

    public AdFullTailFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdFullTailFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
