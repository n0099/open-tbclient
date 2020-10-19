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
    private a chu;
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
        c aLH = aLH();
        aLH.mSrc = str;
        this.chu.d(aLH);
        this.chu.eW(false);
    }

    public void mute(boolean z) {
        if (this.chu != null) {
            this.mIsMute = z;
            this.chu.mute(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.chu;
    }

    private void initPlayer() {
        e aDa = e.aDa();
        if (aDa != null) {
            this.chu = new a(aDa.aCU(), aLH());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.chu.c(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aLH() {
        c cVar = new c();
        cVar.cMu = "SwanAdPlayer";
        cVar.cpp = "SwanAdPlayer";
        cVar.cMD = true;
        cVar.cQt = this.mIsMute;
        cVar.cQB = false;
        cVar.cQK = false;
        cVar.cQH = false;
        return cVar;
    }
}
