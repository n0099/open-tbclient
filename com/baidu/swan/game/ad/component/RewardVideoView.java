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
    private a cBb;
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

    public void bv(String str) {
        c aSy = aSy();
        aSy.mSrc = str;
        this.cBb.d(aSy);
        this.cBb.fK(false);
    }

    public void mute(boolean z) {
        if (this.cBb != null) {
            this.mIsMute = z;
            this.cBb.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.cBb;
    }

    private void initPlayer() {
        e aJU = e.aJU();
        if (aJU != null) {
            this.cBb = new a(aJU.aJO(), aSy());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.cBb.f(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aSy() {
        c cVar = new c();
        cVar.dga = "SwanAdPlayer";
        cVar.cIV = "SwanAdPlayer";
        cVar.dgj = true;
        cVar.dkd = this.mIsMute;
        cVar.dkl = false;
        cVar.dku = false;
        cVar.dkr = false;
        return cVar;
    }
}
