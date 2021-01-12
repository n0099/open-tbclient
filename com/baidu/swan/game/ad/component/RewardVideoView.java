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
/* loaded from: classes14.dex */
public class RewardVideoView extends RelativeLayout {
    private a cBf;
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
        c aQZ = aQZ();
        aQZ.mSrc = str;
        this.cBf.d(aQZ);
        this.cBf.fP(false);
    }

    public void mute(boolean z) {
        if (this.cBf != null) {
            this.mIsMute = z;
            this.cBf.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.cBf;
    }

    private void initPlayer() {
        e aIr = e.aIr();
        if (aIr != null) {
            this.cBf = new a(aIr.aIl(), aQZ());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.cBf.f(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aQZ() {
        c cVar = new c();
        cVar.dge = "SwanAdPlayer";
        cVar.cJc = "SwanAdPlayer";
        cVar.dgn = true;
        cVar.mMute = this.mIsMute;
        cVar.dkv = false;
        cVar.dkE = false;
        cVar.dkB = false;
        return cVar;
    }
}
