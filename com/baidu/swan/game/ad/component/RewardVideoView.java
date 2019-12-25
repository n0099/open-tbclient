package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.media.c.a;
import com.baidu.swan.apps.media.c.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class RewardVideoView extends RelativeLayout {
    private a aWC;
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

    public void U(String str) {
        c ahB = ahB();
        ahB.mSrc = str;
        this.aWC.d(ahB);
        this.aWC.cy(false);
    }

    public void cx(boolean z) {
        if (this.aWC != null) {
            this.mIsMute = z;
            this.aWC.cx(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.aWC;
    }

    private void initPlayer() {
        e ZS = e.ZS();
        if (ZS != null) {
            this.aWC = new a(ZS.ZO(), ahB());
            this.mIsMute = true;
            this.aWC.cx(this.mIsMute);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.aWC.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c ahB() {
        c cVar = new c();
        cVar.bvC = "SwanAdPlayer";
        cVar.bdh = "SwanAdPlayer";
        cVar.bvK = true;
        cVar.bzn = this.mIsMute;
        cVar.bzw = false;
        cVar.bzF = false;
        return cVar;
    }
}
