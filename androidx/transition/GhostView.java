package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public interface GhostView {
    void reserveEndViewTransition(ViewGroup viewGroup, View view);

    void setVisibility(int i2);
}
