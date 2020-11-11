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
    private a cvT;
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
        c aQb = aQb();
        aQb.mSrc = str;
        this.cvT.d(aQb);
        this.cvT.fs(false);
    }

    public void mute(boolean z) {
        if (this.cvT != null) {
            this.mIsMute = z;
            this.cvT.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.cvT;
    }

    private void initPlayer() {
        e aHu = e.aHu();
        if (aHu != null) {
            this.cvT = new a(aHu.aHo(), aQb());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.cvT.f(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aQb() {
        c cVar = new c();
        cVar.daK = "SwanAdPlayer";
        cVar.cDK = "SwanAdPlayer";
        cVar.daT = true;
        cVar.deM = this.mIsMute;
        cVar.deU = false;
        cVar.dfd = false;
        cVar.dfa = false;
        return cVar;
    }
}
