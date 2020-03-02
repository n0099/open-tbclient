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
    private a bbG;
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
        c akk = akk();
        akk.mSrc = str;
        this.bbG.d(akk);
        this.bbG.cK(false);
    }

    public void cJ(boolean z) {
        if (this.bbG != null) {
            this.mIsMute = z;
            this.bbG.cJ(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bbG;
    }

    private void initPlayer() {
        e acF = e.acF();
        if (acF != null) {
            this.bbG = new a(acF.acB(), akk());
            this.mIsMute = true;
            this.bbG.cJ(this.mIsMute);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bbG.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c akk() {
        c cVar = new c();
        cVar.bAz = "SwanAdPlayer";
        cVar.bil = "SwanAdPlayer";
        cVar.bAH = true;
        cVar.bEh = this.mIsMute;
        cVar.bEq = false;
        cVar.bEz = false;
        return cVar;
    }
}
