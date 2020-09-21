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
/* loaded from: classes10.dex */
public class RewardVideoView extends RelativeLayout {
    private a bVg;
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
        c aIY = aIY();
        aIY.mSrc = str;
        this.bVg.d(aIY);
        this.bVg.eA(false);
    }

    public void mute(boolean z) {
        if (this.bVg != null) {
            this.mIsMute = z;
            this.bVg.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bVg;
    }

    private void initPlayer() {
        e aAr = e.aAr();
        if (aAr != null) {
            this.bVg = new a(aAr.aAl(), aIY());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bVg.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aIY() {
        c cVar = new c();
        cVar.cAp = "SwanAdPlayer";
        cVar.ccZ = "SwanAdPlayer";
        cVar.cAy = true;
        cVar.cEp = this.mIsMute;
        cVar.cEx = false;
        cVar.cEG = false;
        cVar.cED = false;
        return cVar;
    }
}
