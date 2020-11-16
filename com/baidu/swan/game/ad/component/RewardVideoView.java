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
/* loaded from: classes12.dex */
public class RewardVideoView extends RelativeLayout {
    private a cuh;
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
        c aPt = aPt();
        aPt.mSrc = str;
        this.cuh.d(aPt);
        this.cuh.fv(false);
    }

    public void mute(boolean z) {
        if (this.cuh != null) {
            this.mIsMute = z;
            this.cuh.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.cuh;
    }

    private void initPlayer() {
        e aGM = e.aGM();
        if (aGM != null) {
            this.cuh = new a(aGM.aGG(), aPt());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.cuh.f(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aPt() {
        c cVar = new c();
        cVar.cZa = "SwanAdPlayer";
        cVar.cCa = "SwanAdPlayer";
        cVar.cZj = true;
        cVar.ddd = this.mIsMute;
        cVar.ddl = false;
        cVar.ddv = false;
        cVar.ddr = false;
        return cVar;
    }
}
