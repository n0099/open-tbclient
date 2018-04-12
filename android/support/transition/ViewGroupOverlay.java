package android.support.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ViewGroupOverlay extends ViewOverlay {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupOverlay(Context context, ViewGroup viewGroup, View view2) {
        super(context, viewGroup, view2);
    }

    public static ViewGroupOverlay createFrom(ViewGroup viewGroup) {
        return (ViewGroupOverlay) ViewOverlay.createFrom(viewGroup);
    }

    public void add(View view2) {
        this.mOverlayViewGroup.add(view2);
    }

    public void remove(View view2) {
        this.mOverlayViewGroup.remove(view2);
    }
}
