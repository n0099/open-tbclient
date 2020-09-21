package com.baidu.fsg.base.utils.support;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public final class ViewHelper {
    private ViewHelper() {
    }

    public static float getAlpha(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getAlpha() : Honeycomb.a(view);
    }

    public static void setAlpha(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(f);
        } else {
            Honeycomb.a(view, f);
        }
    }

    public static void setAlphaPartly(View view, float f, View... viewArr) {
        if (view != null) {
            if (viewArr == null || viewArr.length <= 0 || !(view instanceof ViewGroup)) {
                setAlpha(view, f);
                return;
            }
            ArrayList<View> a = a(view);
            if (a == null || a.size() <= 0) {
                setAlpha(view, f);
                return;
            }
            for (View view2 : viewArr) {
                b(a, view2, true);
            }
            for (int i = 0; i < a.size(); i++) {
                View view3 = a.get(i);
                if ((view3 instanceof ViewGroup) && ((ViewGroup) view3).getChildCount() > 0) {
                    a(a, view3, false);
                }
            }
            for (int i2 = 0; i2 < a.size(); i2++) {
                View view4 = a.get(i2);
                if (view4 != null) {
                    setAlpha(view4, f);
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, View view, boolean z) {
        if (arrayList != null && arrayList.size() > 0 && view != null) {
            ArrayList<View> a = a(view);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= a.size()) {
                    break;
                }
                View view2 = a.get(i2);
                if (view2 != null && arrayList.contains(view2)) {
                    arrayList.remove(view2);
                }
                i = i2 + 1;
            }
            if (z && arrayList.contains(view)) {
                arrayList.remove(view);
            }
        }
    }

    private static void b(ArrayList<View> arrayList, View view, boolean z) {
        if (arrayList != null && arrayList.size() > 0 && view != null) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                arrayList.remove(view2);
                b(arrayList, view2, true);
            }
            if (z && arrayList.contains(view)) {
                arrayList.remove(view);
            }
        }
    }

    private static ArrayList<View> a(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList<View> arrayList = new ArrayList<>();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        arrayList2.add(view);
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(a(childAt));
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    public static float getPivotX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotX() : Honeycomb.b(view);
    }

    public static void setPivotX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotX(f);
        } else {
            Honeycomb.b(view, f);
        }
    }

    public static float getPivotY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotY() : Honeycomb.c(view);
    }

    public static void setPivotY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(f);
        } else {
            Honeycomb.c(view, f);
        }
    }

    public static float getRotation(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotation() : Honeycomb.d(view);
    }

    public static void setRotation(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(f);
        } else {
            Honeycomb.d(view, f);
        }
    }

    public static float getRotationX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationX() : Honeycomb.e(view);
    }

    public static void setRotationX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(f);
        } else {
            Honeycomb.e(view, f);
        }
    }

    public static float getRotationY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationY() : Honeycomb.f(view);
    }

    public static void setRotationY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(f);
        } else {
            Honeycomb.f(view, f);
        }
    }

    public static float getScaleX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleX() : Honeycomb.g(view);
    }

    public static void setScaleX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(f);
        } else {
            Honeycomb.g(view, f);
        }
    }

    public static float getScaleY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleY() : Honeycomb.h(view);
    }

    public static void setScaleY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(f);
        } else {
            Honeycomb.h(view, f);
        }
    }

    public static float getScrollX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScrollX() : Honeycomb.i(view);
    }

    public static void setScrollX(View view, int i) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(i);
        } else {
            Honeycomb.a(view, i);
        }
    }

    public static float getScrollY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScrollY() : Honeycomb.j(view);
    }

    public static void setScrollY(View view, int i) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(i);
        } else {
            Honeycomb.b(view, i);
        }
    }

    public static float getTranslationX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationX() : Honeycomb.k(view);
    }

    public static void setTranslationX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(f);
        } else {
            Honeycomb.i(view, f);
        }
    }

    public static float getTranslationY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationY() : Honeycomb.l(view);
    }

    public static void setTranslationY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(f);
        } else {
            Honeycomb.j(view, f);
        }
    }

    public static float getX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getX() : Honeycomb.m(view);
    }

    public static void setX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(f);
        } else {
            Honeycomb.k(view, f);
        }
    }

    public static float getY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getY() : Honeycomb.n(view);
    }

    public static void setY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(f);
        } else {
            Honeycomb.l(view, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class Honeycomb {
        private Honeycomb() {
        }

        static float a(View view) {
            return view.getAlpha();
        }

        static void a(View view, float f) {
            view.setAlpha(f);
        }

        static float b(View view) {
            return view.getPivotX();
        }

        static void b(View view, float f) {
            view.setPivotX(f);
        }

        static float c(View view) {
            return view.getPivotY();
        }

        static void c(View view, float f) {
            view.setPivotY(f);
        }

        static float d(View view) {
            return view.getRotation();
        }

        static void d(View view, float f) {
            view.setRotation(f);
        }

        static float e(View view) {
            return view.getRotationX();
        }

        static void e(View view, float f) {
            view.setRotationX(f);
        }

        static float f(View view) {
            return view.getRotationY();
        }

        static void f(View view, float f) {
            view.setRotationY(f);
        }

        static float g(View view) {
            return view.getScaleX();
        }

        static void g(View view, float f) {
            view.setScaleX(f);
        }

        static float h(View view) {
            return view.getScaleY();
        }

        static void h(View view, float f) {
            view.setScaleY(f);
        }

        static float i(View view) {
            return view.getScrollX();
        }

        static void a(View view, int i) {
            view.setScrollX(i);
        }

        static float j(View view) {
            return view.getScrollY();
        }

        static void b(View view, int i) {
            view.setScrollY(i);
        }

        static float k(View view) {
            return view.getTranslationX();
        }

        static void i(View view, float f) {
            view.setTranslationX(f);
        }

        static float l(View view) {
            return view.getTranslationY();
        }

        static void j(View view, float f) {
            view.setTranslationY(f);
        }

        static float m(View view) {
            return view.getX();
        }

        static void k(View view, float f) {
            view.setX(f);
        }

        static float n(View view) {
            return view.getY();
        }

        static void l(View view, float f) {
            view.setY(f);
        }
    }
}
