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
/* loaded from: classes3.dex */
public class RewardVideoView extends RelativeLayout {
    private a cFR;
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
        c aUS = aUS();
        aUS.mSrc = str;
        this.cFR.d(aUS);
        this.cFR.fT(false);
    }

    public void mute(boolean z) {
        if (this.cFR != null) {
            this.mIsMute = z;
            this.cFR.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.cFR;
    }

    private void initPlayer() {
        e aMk = e.aMk();
        if (aMk != null) {
            this.cFR = new a(aMk.aMe(), aUS());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.cFR.f(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aUS() {
        c cVar = new c();
        cVar.dkT = "SwanAdPlayer";
        cVar.cNO = "SwanAdPlayer";
        cVar.dlc = true;
        cVar.mMute = this.mIsMute;
        cVar.dpk = false;
        cVar.dpu = false;
        cVar.dpr = false;
        return cVar;
    }
}
