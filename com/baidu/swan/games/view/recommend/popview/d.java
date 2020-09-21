package com.baidu.swan.games.view.recommend.popview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes3.dex */
public class d extends StateListDrawable {
    private a dBO;
    private View mView = null;

    /* loaded from: classes3.dex */
    public interface a {
        void aL(View view);

        void aM(View view);
    }

    public d() {
        addState(new int[]{16842919}, new ColorDrawable(0));
        addState(new int[0], new ColorDrawable(0));
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void a(a aVar) {
        this.dBO = aVar;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.mView != null && this.dBO != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.dBO.aL(this.mView);
            } else {
                this.dBO.aM(this.mView);
            }
        }
        return super.onStateChange(iArr);
    }
}
