package com.baidu.swan.games.view.recommend.popview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
/* loaded from: classes8.dex */
public class c extends StateListDrawable {
    private a elJ;
    private View mView = null;

    /* loaded from: classes8.dex */
    public interface a {
        void bc(View view);

        void bd(View view);
    }

    public c() {
        addState(new int[]{16842919}, new ColorDrawable(0));
        addState(new int[0], new ColorDrawable(0));
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void a(a aVar) {
        this.elJ = aVar;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.mView != null && this.elJ != null) {
            if (StateSet.stateSetMatches(new int[]{16842919}, iArr)) {
                this.elJ.bc(this.mView);
            } else {
                this.elJ.bd(this.mView);
            }
        }
        return super.onStateChange(iArr);
    }
}
