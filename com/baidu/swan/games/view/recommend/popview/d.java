package com.baidu.swan.games.view.recommend.popview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes11.dex */
public class d extends StateListDrawable {
    private a cTT;
    private View mView = null;

    /* loaded from: classes11.dex */
    public interface a {
        void aD(View view);

        void aE(View view);
    }

    public d() {
        addState(new int[]{16842919}, new ColorDrawable(0));
        addState(new int[0], new ColorDrawable(0));
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void a(a aVar) {
        this.cTT = aVar;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.mView != null && this.cTT != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.cTT.aD(this.mView);
            } else {
                this.cTT.aE(this.mView);
            }
        }
        return super.onStateChange(iArr);
    }
}
