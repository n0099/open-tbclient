package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(18)
/* loaded from: classes.dex */
public class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    public final ViewGroupOverlay mViewGroupOverlay;

    public ViewGroupOverlayApi18(@NonNull ViewGroup viewGroup) {
        this.mViewGroupOverlay = viewGroup.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.mViewGroupOverlay.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void clear() {
        this.mViewGroupOverlay.clear();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.mViewGroupOverlay.remove(drawable);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(@NonNull View view) {
        this.mViewGroupOverlay.add(view);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(@NonNull View view) {
        this.mViewGroupOverlay.remove(view);
    }
}
