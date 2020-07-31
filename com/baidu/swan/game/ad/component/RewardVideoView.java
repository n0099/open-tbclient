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
/* loaded from: classes9.dex */
public class RewardVideoView extends RelativeLayout {
    private a bNE;
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
        PJ();
    }

    public void bl(String str) {
        c aAa = aAa();
        aAa.mSrc = str;
        this.bNE.d(aAa);
        this.bNE.ej(false);
    }

    public void ei(boolean z) {
        if (this.bNE != null) {
            this.mIsMute = z;
            this.bNE.ei(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bNE;
    }

    private void PJ() {
        e arv = e.arv();
        if (arv != null) {
            this.bNE = new a(arv.arp(), aAa());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bNE.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aAa() {
        c cVar = new c();
        cVar.cqu = "SwanAdPlayer";
        cVar.bVl = "SwanAdPlayer";
        cVar.cqD = true;
        cVar.cuB = this.mIsMute;
        cVar.cuJ = false;
        cVar.cuS = false;
        cVar.cuP = false;
        return cVar;
    }
}
