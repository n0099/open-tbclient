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
    private a bdX;
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
        cVar.aBc = "SwanAdPlayer";
        cVar.id = "SwanAdPlayer";
        cVar.aBl = true;
        cVar.aDf = this.c;
        cVar.aDo = false;
        this.bdX.d(cVar);
        this.bdX.bs(false);
    }

    public void a(boolean z) {
        if (this.bdX != null) {
            this.c = z;
            this.bdX.br(z);
        }
    }

    public boolean a() {
        return this.c;
    }

    public a getPlayer() {
        return this.bdX;
    }

    private void b() {
        b Md = b.Md();
        if (Md != null) {
            this.bdX = new a(Md.getActivity(), "SwanAdPlayer");
            this.c = true;
            this.bdX.br(this.c);
            FrameLayout frameLayout = new FrameLayout(this.b);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            this.bdX.b(frameLayout);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
