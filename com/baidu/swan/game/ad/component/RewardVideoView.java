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
/* loaded from: classes11.dex */
public class RewardVideoView extends RelativeLayout {
    private a bIb;
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
        Oo();
    }

    public void bk(String str) {
        c awe = awe();
        awe.mSrc = str;
        this.bIb.d(awe);
        this.bIb.dX(false);
    }

    public void dW(boolean z) {
        if (this.bIb != null) {
            this.mIsMute = z;
            this.bIb.dW(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bIb;
    }

    private void Oo() {
        e aoF = e.aoF();
        if (aoF != null) {
            this.bIb = new a(aoF.aoz(), awe());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bIb.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c awe() {
        c cVar = new c();
        cVar.cjA = "SwanAdPlayer";
        cVar.bPF = "SwanAdPlayer";
        cVar.cjJ = true;
        cVar.cnK = this.mIsMute;
        cVar.cnS = false;
        cVar.cob = false;
        return cVar;
    }
}
