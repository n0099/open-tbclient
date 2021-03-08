package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.media.b.a;
import com.baidu.swan.apps.media.b.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes5.dex */
public class RewardVideoView extends RelativeLayout {
    private a cFb;
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

    public void start(String str) {
        c aRs = aRs();
        aRs.mSrc = str;
        this.cFb.d(aRs);
        this.cFb.fR(false);
    }

    public void mute(boolean z) {
        if (this.cFb != null) {
            this.mIsMute = z;
            this.cFb.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.cFb;
    }

    private void initPlayer() {
        e aIN = e.aIN();
        if (aIN != null) {
            this.cFb = new a(aIN.aIH(), aRs());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.cFb.f(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aRs() {
        c cVar = new c();
        cVar.djT = "SwanAdPlayer";
        cVar.cMQ = "SwanAdPlayer";
        cVar.dkc = true;
        cVar.mMute = this.mIsMute;
        cVar.doi = false;
        cVar.dor = false;
        cVar.doo = false;
        return cVar;
    }
}
