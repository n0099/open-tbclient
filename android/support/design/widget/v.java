package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class v {
    private static final a sH;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(ViewGroup viewGroup, View view, Rect rect);
    }

    /* loaded from: classes2.dex */
    private static class b implements a {
        b() {
        }

        @Override // android.support.design.widget.v.a
        public void a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements a {
        c() {
        }

        @Override // android.support.design.widget.v.a
        public void a(ViewGroup viewGroup, View view, Rect rect) {
            w.a(viewGroup, view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            sH = new c();
        } else {
            sH = new b();
        }
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        sH.a(viewGroup, view, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a(viewGroup, view, rect);
    }
}
