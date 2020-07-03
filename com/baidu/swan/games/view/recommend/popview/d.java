package com.baidu.swan.games.view.recommend.popview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes11.dex */
public class d extends StateListDrawable {
    private a djN;
    private View mView = null;

    /* loaded from: classes11.dex */
    public interface a {
        void aC(View view);

        void aD(View view);
    }

    public d() {
        addState(new int[]{16842919}, new ColorDrawable(0));
        addState(new int[0], new ColorDrawable(0));
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void a(a aVar) {
        this.djN = aVar;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.mView != null && this.djN != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.djN.aC(this.mView);
            } else {
                this.djN.aD(this.mView);
            }
        }
        return super.onStateChange(iArr);
    }
}
