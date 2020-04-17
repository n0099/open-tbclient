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
    private a bAi;
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
        Mc();
    }

    public void bk(String str) {
        c asy = asy();
        asy.mSrc = str;
        this.bAi.d(asy);
        this.bAi.dH(false);
    }

    public void dG(boolean z) {
        if (this.bAi != null) {
            this.mIsMute = z;
            this.bAi.dG(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bAi;
    }

    private void Mc() {
        e akN = e.akN();
        if (akN != null) {
            this.bAi = new a(akN.akJ(), asy());
            this.mIsMute = true;
            this.bAi.dG(this.mIsMute);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bAi.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c asy() {
        c cVar = new c();
        cVar.bYS = "SwanAdPlayer";
        cVar.bGI = "SwanAdPlayer";
        cVar.bZa = true;
        cVar.cdc = this.mIsMute;
        cVar.cdk = false;
        cVar.cdu = false;
        return cVar;
    }
}
