package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class ViewGroupUtils {
    private static final ViewGroupUtilsImpl IMPL;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface ViewGroupUtilsImpl {
        void offsetDescendantRect(ViewGroup viewGroup, View view2, Rect rect);
    }

    ViewGroupUtils() {
    }

    /* loaded from: classes2.dex */
    private static class ViewGroupUtilsImplBase implements ViewGroupUtilsImpl {
        ViewGroupUtilsImplBase() {
        }

        @Override // android.support.design.widget.ViewGroupUtils.ViewGroupUtilsImpl
        public void offsetDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view2, rect);
            rect.offset(view2.getScrollX(), view2.getScrollY());
        }
    }

    /* loaded from: classes2.dex */
    private static class ViewGroupUtilsImplHoneycomb implements ViewGroupUtilsImpl {
        ViewGroupUtilsImplHoneycomb() {
        }

        @Override // android.support.design.widget.ViewGroupUtils.ViewGroupUtilsImpl
        public void offsetDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
            ViewGroupUtilsHoneycomb.offsetDescendantRect(viewGroup, view2, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new ViewGroupUtilsImplHoneycomb();
        } else {
            IMPL = new ViewGroupUtilsImplBase();
        }
    }

    static void offsetDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
        IMPL.offsetDescendantRect(viewGroup, view2, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
        rect.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRect(viewGroup, view2, rect);
    }
}
