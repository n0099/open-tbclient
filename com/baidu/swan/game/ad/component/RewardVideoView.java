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
/* loaded from: classes19.dex */
public class RewardVideoView extends RelativeLayout {
    private a bTg;
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

    public void bq(String str) {
        c aIn = aIn();
        aIn.mSrc = str;
        this.bTg.d(aIn);
        this.bTg.eC(false);
    }

    public void mute(boolean z) {
        if (this.bTg != null) {
            this.mIsMute = z;
            this.bTg.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bTg;
    }

    private void initPlayer() {
        e azI = e.azI();
        if (azI != null) {
            this.bTg = new a(azI.azC(), aIn());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bTg.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aIn() {
        c cVar = new c();
        cVar.cyo = "SwanAdPlayer";
        cVar.caX = "SwanAdPlayer";
        cVar.cyx = true;
        cVar.cCp = this.mIsMute;
        cVar.cCx = false;
        cVar.cCG = false;
        cVar.cCD = false;
        return cVar;
    }
}
