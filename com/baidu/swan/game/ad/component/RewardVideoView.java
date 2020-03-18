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
    private a bbU;
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

    public void V(String str) {
        c akn = akn();
        akn.mSrc = str;
        this.bbU.d(akn);
        this.bbU.cL(false);
    }

    public void cK(boolean z) {
        if (this.bbU != null) {
            this.mIsMute = z;
            this.bbU.cK(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bbU;
    }

    private void initPlayer() {
        e acI = e.acI();
        if (acI != null) {
            this.bbU = new a(acI.acE(), akn());
            this.mIsMute = true;
            this.bbU.cK(this.mIsMute);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bbU.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c akn() {
        c cVar = new c();
        cVar.bAL = "SwanAdPlayer";
        cVar.biA = "SwanAdPlayer";
        cVar.bAT = true;
        cVar.bEt = this.mIsMute;
        cVar.bEC = false;
        cVar.bEL = false;
        return cVar;
    }
}
