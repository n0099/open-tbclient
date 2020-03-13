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
    private a bbH;
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
        this.bbH.d(akk);
        this.bbH.cK(false);
    }

    public void cJ(boolean z) {
        if (this.bbH != null) {
            this.mIsMute = z;
            this.bbH.cJ(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bbH;
    }

    private void initPlayer() {
        e acF = e.acF();
        if (acF != null) {
            this.bbH = new a(acF.acB(), akk());
            this.mIsMute = true;
            this.bbH.cJ(this.mIsMute);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bbH.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c akk() {
        c cVar = new c();
        cVar.bAA = "SwanAdPlayer";
        cVar.bim = "SwanAdPlayer";
        cVar.bAI = true;
        cVar.bEi = this.mIsMute;
        cVar.bEr = false;
        cVar.bEA = false;
        return cVar;
    }
}
