package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.media.b.a;
import com.baidu.swan.apps.media.b.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes14.dex */
public class RewardVideoView extends RelativeLayout {
    private a cpV;
    private Context mContext;
    private boolean mIsMute;

    public RewardVideoView(Context context) {
        this(context, null);
    }

    public RewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initPlayer();
    }

    public void bs(String str) {
        c aNB = aNB();
        aNB.mSrc = str;
        this.cpV.d(aNB);
        this.cpV.fj(false);
    }

    public void mute(boolean z) {
        if (this.cpV != null) {
            this.mIsMute = z;
            this.cpV.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.cpV;
    }

    private void initPlayer() {
        e aEU = e.aEU();
        if (aEU != null) {
            this.cpV = new a(aEU.aEO(), aNB());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.cpV.c(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aNB() {
        c cVar = new c();
        cVar.cUQ = "SwanAdPlayer";
        cVar.cxR = "SwanAdPlayer";
        cVar.cUZ = true;
        cVar.cYP = this.mIsMute;
        cVar.cYX = false;
        cVar.cZg = false;
        cVar.cZd = false;
        return cVar;
    }
}
