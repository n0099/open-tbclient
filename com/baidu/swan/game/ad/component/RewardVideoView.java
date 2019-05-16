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
    private a bdl;
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
        cVar.aAu = "SwanAdPlayer";
        cVar.id = "SwanAdPlayer";
        cVar.aAD = true;
        cVar.aCx = this.c;
        cVar.aCG = false;
        this.bdl.d(cVar);
        this.bdl.bp(false);
    }

    public void a(boolean z) {
        if (this.bdl != null) {
            this.c = z;
            this.bdl.bo(z);
        }
    }

    public boolean a() {
        return this.c;
    }

    public a getPlayer() {
        return this.bdl;
    }

    private void b() {
        b Lq = b.Lq();
        if (Lq != null) {
            this.bdl = new a(Lq.getActivity(), "SwanAdPlayer");
            this.c = true;
            this.bdl.bo(this.c);
            FrameLayout frameLayout = new FrameLayout(this.b);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bdl.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
