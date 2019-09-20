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
    private a bex;
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
        cVar.aBA = "SwanAdPlayer";
        cVar.id = "SwanAdPlayer";
        cVar.aBJ = true;
        cVar.aDD = this.c;
        cVar.aDM = false;
        this.bex.d(cVar);
        this.bex.bs(false);
    }

    public void a(boolean z) {
        if (this.bex != null) {
            this.c = z;
            this.bex.br(z);
        }
    }

    public boolean a() {
        return this.c;
    }

    public a getPlayer() {
        return this.bex;
    }

    private void b() {
        b Mh = b.Mh();
        if (Mh != null) {
            this.bex = new a(Mh.getActivity(), "SwanAdPlayer");
            this.c = true;
            this.bex.br(this.c);
            FrameLayout frameLayout = new FrameLayout(this.b);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bex.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
