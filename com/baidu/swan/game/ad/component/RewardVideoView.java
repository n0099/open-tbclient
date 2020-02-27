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
    private a bbF;
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
        c aki = aki();
        aki.mSrc = str;
        this.bbF.d(aki);
        this.bbF.cK(false);
    }

    public void cJ(boolean z) {
        if (this.bbF != null) {
            this.mIsMute = z;
            this.bbF.cJ(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bbF;
    }

    private void initPlayer() {
        e acD = e.acD();
        if (acD != null) {
            this.bbF = new a(acD.acz(), aki());
            this.mIsMute = true;
            this.bbF.cJ(this.mIsMute);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bbF.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c aki() {
        c cVar = new c();
        cVar.bAy = "SwanAdPlayer";
        cVar.bik = "SwanAdPlayer";
        cVar.bAG = true;
        cVar.bEg = this.mIsMute;
        cVar.bEp = false;
        cVar.bEy = false;
        return cVar;
    }
}
