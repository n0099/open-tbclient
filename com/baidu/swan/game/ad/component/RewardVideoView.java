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
    private a bxr;
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
        cVar.aUO = "SwanAdPlayer";
        cVar.id = "SwanAdPlayer";
        cVar.aUX = true;
        cVar.aWS = this.c;
        cVar.aXb = false;
        this.bxr.d(cVar);
        this.bxr.bK(false);
    }

    public void a(boolean z) {
        if (this.bxr != null) {
            this.c = z;
            this.bxr.bJ(z);
        }
    }

    public boolean a() {
        return this.c;
    }

    public a getPlayer() {
        return this.bxr;
    }

    private void b() {
        b QZ = b.QZ();
        if (QZ != null) {
            this.bxr = new a(QZ.getActivity(), "SwanAdPlayer");
            this.c = true;
            this.bxr.bJ(this.c);
            FrameLayout frameLayout = new FrameLayout(this.b);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bxr.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
