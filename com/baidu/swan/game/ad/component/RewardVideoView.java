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
    private a bMP;
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
        Pu();
    }

    public void bl(String str) {
        c axk = axk();
        axk.mSrc = str;
        this.bMP.d(axk);
        this.bMP.ec(false);
    }

    public void eb(boolean z) {
        if (this.bMP != null) {
            this.mIsMute = z;
            this.bMP.eb(z);
        }
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public a getPlayer() {
        return this.bMP;
    }

    private void Pu() {
        e apM = e.apM();
        if (apM != null) {
            this.bMP = new a(apM.apG(), axk());
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bMP.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @NonNull
    private c axk() {
        c cVar = new c();
        cVar.cop = "SwanAdPlayer";
        cVar.bUt = "SwanAdPlayer";
        cVar.coy = true;
        cVar.csx = this.mIsMute;
        cVar.csF = false;
        cVar.csO = false;
        return cVar;
    }
}
