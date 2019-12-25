package com.baidu.swan.games.view.recommend.popview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes9.dex */
public class d extends StateListDrawable {
    private a cqv;
    private View mView = null;

    /* loaded from: classes9.dex */
    public interface a {
        void ay(View view);

        void az(View view);
    }

    public d() {
        addState(new int[]{16842919}, new ColorDrawable(0));
        addState(new int[0], new ColorDrawable(0));
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void a(a aVar) {
        this.cqv = aVar;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.mView != null && this.cqv != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.cqv.ay(this.mView);
            } else {
                this.cqv.az(this.mView);
            }
        }
        return super.onStateChange(iArr);
    }
}
