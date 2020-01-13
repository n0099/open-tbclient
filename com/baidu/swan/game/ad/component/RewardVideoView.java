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
/* loaded from: classes10.dex */
public class RewardVideoView extends RelativeLayout {
    private a aXu;
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
        c ahU = ahU();
        ahU.mSrc = str;
        this.aXu.d(ahU);
        this.aXu.cD(false);
    }

    public void cC(boolean z) {
        if (this.aXu != null) {
            this.mIsMute = z;
            this.aXu.cC(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.aXu;
    }

    private void initPlayer() {
        e aap = e.aap();
        if (aap != null) {
            this.aXu = new a(aap.aal(), ahU());
            this.mIsMute = true;
            this.aXu.cC(this.mIsMute);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.aXu.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c ahU() {
        c cVar = new c();
        cVar.bwp = "SwanAdPlayer";
        cVar.bdV = "SwanAdPlayer";
        cVar.bwx = true;
        cVar.bAa = this.mIsMute;
        cVar.bAj = false;
        cVar.bAs = false;
        return cVar;
    }
}
