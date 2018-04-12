package com.baidu.fsg.base.utils.support;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class ViewHelper {
    private ViewHelper() {
    }

    public static float getAlpha(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getAlpha() : Honeycomb.a(view2);
    }

    public static void setAlpha(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setAlpha(f);
        } else {
            Honeycomb.a(view2, f);
        }
    }

    public static void setAlphaPartly(View view2, float f, View... viewArr) {
        if (view2 != null) {
            if (viewArr == null || viewArr.length <= 0 || !(view2 instanceof ViewGroup)) {
                setAlpha(view2, f);
                return;
            }
            ArrayList<View> a = a(view2);
            if (a == null || a.size() <= 0) {
                setAlpha(view2, f);
                return;
            }
            for (View view3 : viewArr) {
                b(a, view3, true);
            }
            for (int i = 0; i < a.size(); i++) {
                View view4 = a.get(i);
                if ((view4 instanceof ViewGroup) && ((ViewGroup) view4).getChildCount() > 0) {
                    a(a, view4, false);
                }
            }
            for (int i2 = 0; i2 < a.size(); i2++) {
                View view5 = a.get(i2);
                if (view5 != null) {
                    setAlpha(view5, f);
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, View view2, boolean z) {
        if (arrayList != null && arrayList.size() > 0 && view2 != null) {
            ArrayList<View> a = a(view2);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= a.size()) {
                    break;
                }
                View view3 = a.get(i2);
                if (view3 != null && arrayList.contains(view3)) {
                    arrayList.remove(view3);
                }
                i = i2 + 1;
            }
            if (z && arrayList.contains(view2)) {
                arrayList.remove(view2);
            }
        }
    }

    private static void b(ArrayList<View> arrayList, View view2, boolean z) {
        if (arrayList != null && arrayList.size() > 0 && view2 != null) {
            View view3 = (View) view2.getParent();
            if (view3 != null) {
                arrayList.remove(view3);
                b(arrayList, view3, true);
            }
            if (z && arrayList.contains(view2)) {
                arrayList.remove(view2);
            }
        }
    }

    private static ArrayList<View> a(View view2) {
        if (!(view2 instanceof ViewGroup)) {
            ArrayList<View> arrayList = new ArrayList<>();
            arrayList.add(view2);
            return arrayList;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        arrayList2.add(view2);
        ViewGroup viewGroup = (ViewGroup) view2;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(a(childAt));
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    public static float getPivotX(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getPivotX() : Honeycomb.b(view2);
    }

    public static void setPivotX(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setPivotX(f);
        } else {
            Honeycomb.b(view2, f);
        }
    }

    public static float getPivotY(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getPivotY() : Honeycomb.c(view2);
    }

    public static void setPivotY(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setPivotY(f);
        } else {
            Honeycomb.c(view2, f);
        }
    }

    public static float getRotation(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getRotation() : Honeycomb.d(view2);
    }

    public static void setRotation(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setRotation(f);
        } else {
            Honeycomb.d(view2, f);
        }
    }

    public static float getRotationX(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getRotationX() : Honeycomb.e(view2);
    }

    public static void setRotationX(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setRotationX(f);
        } else {
            Honeycomb.e(view2, f);
        }
    }

    public static float getRotationY(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getRotationY() : Honeycomb.f(view2);
    }

    public static void setRotationY(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setRotationY(f);
        } else {
            Honeycomb.f(view2, f);
        }
    }

    public static float getScaleX(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getScaleX() : Honeycomb.g(view2);
    }

    public static void setScaleX(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setScaleX(f);
        } else {
            Honeycomb.g(view2, f);
        }
    }

    public static float getScaleY(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getScaleY() : Honeycomb.h(view2);
    }

    public static void setScaleY(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setScaleY(f);
        } else {
            Honeycomb.h(view2, f);
        }
    }

    public static float getScrollX(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getScrollX() : Honeycomb.i(view2);
    }

    public static void setScrollX(View view2, int i) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setScrollX(i);
        } else {
            Honeycomb.a(view2, i);
        }
    }

    public static float getScrollY(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getScrollY() : Honeycomb.j(view2);
    }

    public static void setScrollY(View view2, int i) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setScrollY(i);
        } else {
            Honeycomb.b(view2, i);
        }
    }

    public static float getTranslationX(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getTranslationX() : Honeycomb.k(view2);
    }

    public static void setTranslationX(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setTranslationX(f);
        } else {
            Honeycomb.i(view2, f);
        }
    }

    public static float getTranslationY(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getTranslationY() : Honeycomb.l(view2);
    }

    public static void setTranslationY(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setTranslationY(f);
        } else {
            Honeycomb.j(view2, f);
        }
    }

    public static float getX(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getX() : Honeycomb.m(view2);
    }

    public static void setX(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setX(f);
        } else {
            Honeycomb.k(view2, f);
        }
    }

    public static float getY(View view2) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view2).getY() : Honeycomb.n(view2);
    }

    public static void setY(View view2, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view2).setY(f);
        } else {
            Honeycomb.l(view2, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Honeycomb {
        private Honeycomb() {
        }

        static float a(View view2) {
            return view2.getAlpha();
        }

        static void a(View view2, float f) {
            view2.setAlpha(f);
        }

        static float b(View view2) {
            return view2.getPivotX();
        }

        static void b(View view2, float f) {
            view2.setPivotX(f);
        }

        static float c(View view2) {
            return view2.getPivotY();
        }

        static void c(View view2, float f) {
            view2.setPivotY(f);
        }

        static float d(View view2) {
            return view2.getRotation();
        }

        static void d(View view2, float f) {
            view2.setRotation(f);
        }

        static float e(View view2) {
            return view2.getRotationX();
        }

        static void e(View view2, float f) {
            view2.setRotationX(f);
        }

        static float f(View view2) {
            return view2.getRotationY();
        }

        static void f(View view2, float f) {
            view2.setRotationY(f);
        }

        static float g(View view2) {
            return view2.getScaleX();
        }

        static void g(View view2, float f) {
            view2.setScaleX(f);
        }

        static float h(View view2) {
            return view2.getScaleY();
        }

        static void h(View view2, float f) {
            view2.setScaleY(f);
        }

        static float i(View view2) {
            return view2.getScrollX();
        }

        static void a(View view2, int i) {
            view2.setScrollX(i);
        }

        static float j(View view2) {
            return view2.getScrollY();
        }

        static void b(View view2, int i) {
            view2.setScrollY(i);
        }

        static float k(View view2) {
            return view2.getTranslationX();
        }

        static void i(View view2, float f) {
            view2.setTranslationX(f);
        }

        static float l(View view2) {
            return view2.getTranslationY();
        }

        static void j(View view2, float f) {
            view2.setTranslationY(f);
        }

        static float m(View view2) {
            return view2.getX();
        }

        static void k(View view2, float f) {
            view2.setX(f);
        }

        static float n(View view2) {
            return view2.getY();
        }

        static void l(View view2, float f) {
            view2.setY(f);
        }
    }
}
