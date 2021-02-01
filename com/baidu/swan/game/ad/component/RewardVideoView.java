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
    private a cDB;
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
        c aRp = aRp();
        aRp.mSrc = str;
        this.cDB.d(aRp);
        this.cDB.fR(false);
    }

    public void mute(boolean z) {
        if (this.cDB != null) {
            this.mIsMute = z;
            this.cDB.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.cDB;
    }

    private void initPlayer() {
        e aIK = e.aIK();
        if (aIK != null) {
            this.cDB = new a(aIK.aIE(), aRp());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.cDB.f(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aRp() {
        c cVar = new c();
        cVar.diq = "SwanAdPlayer";
        cVar.cLq = "SwanAdPlayer";
        cVar.diB = true;
        cVar.mMute = this.mIsMute;
        cVar.dmF = false;
        cVar.dmO = false;
        cVar.dmL = false;
        return cVar;
    }
}
