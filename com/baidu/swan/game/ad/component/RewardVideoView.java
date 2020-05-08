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
/* loaded from: classes11.dex */
public class RewardVideoView extends RelativeLayout {
    private a bAn;
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
        Mb();
    }

    public void bk(String str) {
        c asx = asx();
        asx.mSrc = str;
        this.bAn.d(asx);
        this.bAn.dH(false);
    }

    public void dG(boolean z) {
        if (this.bAn != null) {
            this.mIsMute = z;
            this.bAn.dG(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bAn;
    }

    private void Mb() {
        e akM = e.akM();
        if (akM != null) {
            this.bAn = new a(akM.akI(), asx());
            this.mIsMute = true;
            this.bAn.dG(this.mIsMute);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bAn.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c asx() {
        c cVar = new c();
        cVar.bYY = "SwanAdPlayer";
        cVar.bGN = "SwanAdPlayer";
        cVar.bZg = true;
        cVar.cdi = this.mIsMute;
        cVar.cdr = false;
        cVar.cdA = false;
        return cVar;
    }
}
