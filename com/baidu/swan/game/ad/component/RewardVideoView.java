package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.media.d.a;
import com.baidu.swan.apps.media.d.c;
/* loaded from: classes2.dex */
public class RewardVideoView extends RelativeLayout {
    private Context b;
    private a bwA;
    private boolean c;

    public RewardVideoView(Context context) {
        this(context, null);
    }

    public RewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        b();
    }

    public void a(String str) {
        c cVar = new c();
        cVar.mSrc = str;
        cVar.aUw = "SwanAdPlayer";
        cVar.id = "SwanAdPlayer";
        cVar.aUF = true;
        cVar.aWA = this.c;
        cVar.aWJ = false;
        this.bwA.d(cVar);
        this.bwA.bK(false);
    }

    public void a(boolean z) {
        if (this.bwA != null) {
            this.c = z;
            this.bwA.bJ(z);
        }
    }

    public boolean a() {
        return this.c;
    }

    public a getPlayer() {
        return this.bwA;
    }

    private void b() {
        b Ra = b.Ra();
        if (Ra != null) {
            this.bwA = new a(Ra.getActivity(), "SwanAdPlayer");
            this.c = true;
            this.bwA.bJ(this.c);
            FrameLayout frameLayout = new FrameLayout(this.b);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bwA.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
