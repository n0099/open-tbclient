package com.baidu.apollon.utils.support;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class ViewHelper {

    /* loaded from: classes2.dex */
    public static final class a {
        public static float a(View view) {
            return view.getAlpha();
        }

        public static float b(View view) {
            return view.getPivotX();
        }

        public static float c(View view) {
            return view.getPivotY();
        }

        public static float d(View view) {
            return view.getRotation();
        }

        public static float e(View view) {
            return view.getRotationX();
        }

        public static float f(View view) {
            return view.getRotationY();
        }

        public static float g(View view) {
            return view.getScaleX();
        }

        public static float h(View view) {
            return view.getScaleY();
        }

        public static float i(View view) {
            return view.getScrollX();
        }

        public static float j(View view) {
            return view.getScrollY();
        }

        public static float k(View view) {
            return view.getTranslationX();
        }

        public static float l(View view) {
            return view.getTranslationY();
        }

        public static float m(View view) {
            return view.getX();
        }

        public static float n(View view) {
            return view.getY();
        }

        public static void a(View view, float f2) {
            view.setAlpha(f2);
        }

        public static void b(View view, float f2) {
            view.setPivotX(f2);
        }

        public static void c(View view, float f2) {
            view.setPivotY(f2);
        }

        public static void d(View view, float f2) {
            view.setRotation(f2);
        }

        public static void e(View view, float f2) {
            view.setRotationX(f2);
        }

        public static void f(View view, float f2) {
            view.setRotationY(f2);
        }

        public static void g(View view, float f2) {
            view.setScaleX(f2);
        }

        public static void h(View view, float f2) {
            view.setScaleY(f2);
        }

        public static void i(View view, float f2) {
            view.setTranslationX(f2);
        }

        public static void j(View view, float f2) {
            view.setTranslationY(f2);
        }

        public static void k(View view, float f2) {
            view.setX(f2);
        }

        public static void l(View view, float f2) {
            view.setY(f2);
        }

        public static void a(View view, int i) {
            view.setScrollX(i);
        }

        public static void b(View view, int i) {
            view.setScrollY(i);
        }
    }

    public static void a(ArrayList<View> arrayList, View view, boolean z) {
        if (arrayList == null || arrayList.size() <= 0 || view == null) {
            return;
        }
        ArrayList<View> a2 = a(view);
        for (int i = 1; i < a2.size(); i++) {
            View view2 = a2.get(i);
            if (view2 != null && arrayList.contains(view2)) {
                arrayList.remove(view2);
            }
        }
        if (z && arrayList.contains(view)) {
            arrayList.remove(view);
        }
    }

    public static void b(ArrayList<View> arrayList, View view, boolean z) {
        if (arrayList == null || arrayList.size() <= 0 || view == null) {
            return;
        }
        View view2 = (View) view.getParent();
        if (view2 != null) {
            arrayList.remove(view2);
            b(arrayList, view2, true);
        }
        if (z && arrayList.contains(view)) {
            arrayList.remove(view);
        }
    }

    public static float getAlpha(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getAlpha() : a.a(view);
    }

    public static float getPivotX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotX() : a.b(view);
    }

    public static float getPivotY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotY() : a.c(view);
    }

    public static float getRotation(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotation() : a.d(view);
    }

    public static float getRotationX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationX() : a.e(view);
    }

    public static float getRotationY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationY() : a.f(view);
    }

    public static float getScaleX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleX() : a.g(view);
    }

    public static float getScaleY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleY() : a.h(view);
    }

    public static float getScrollX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScrollX() : a.i(view);
    }

    public static float getScrollY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScrollY() : a.j(view);
    }

    public static float getTranslationX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationX() : a.k(view);
    }

    public static float getTranslationY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationY() : a.l(view);
    }

    public static float getX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getX() : a.m(view);
    }

    public static float getY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getY() : a.n(view);
    }

    public static void setAlpha(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(f2);
        } else {
            a.a(view, f2);
        }
    }

    public static void setAlphaPartly(View view, float f2, View... viewArr) {
        if (view == null) {
            return;
        }
        if (viewArr != null && viewArr.length > 0 && (view instanceof ViewGroup)) {
            ArrayList<View> a2 = a(view);
            if (a2 != null && a2.size() > 0) {
                for (View view2 : viewArr) {
                    b(a2, view2, true);
                }
                for (int i = 0; i < a2.size(); i++) {
                    View view3 = a2.get(i);
                    if ((view3 instanceof ViewGroup) && ((ViewGroup) view3).getChildCount() > 0) {
                        a(a2, view3, false);
                    }
                }
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    View view4 = a2.get(i2);
                    if (view4 != null) {
                        setAlpha(view4, f2);
                    }
                }
                return;
            }
            setAlpha(view, f2);
            return;
        }
        setAlpha(view, f2);
    }

    public static void setPivotX(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotX(f2);
        } else {
            a.b(view, f2);
        }
    }

    public static void setPivotY(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(f2);
        } else {
            a.c(view, f2);
        }
    }

    public static void setRotation(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(f2);
        } else {
            a.d(view, f2);
        }
    }

    public static void setRotationX(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(f2);
        } else {
            a.e(view, f2);
        }
    }

    public static void setRotationY(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(f2);
        } else {
            a.f(view, f2);
        }
    }

    public static void setScaleX(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(f2);
        } else {
            a.g(view, f2);
        }
    }

    public static void setScaleY(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(f2);
        } else {
            a.h(view, f2);
        }
    }

    public static void setScrollX(View view, int i) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(i);
        } else {
            a.a(view, i);
        }
    }

    public static void setScrollY(View view, int i) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(i);
        } else {
            a.b(view, i);
        }
    }

    public static void setTranslationX(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(f2);
        } else {
            a.i(view, f2);
        }
    }

    public static void setTranslationY(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(f2);
        } else {
            a.j(view, f2);
        }
    }

    public static void setX(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(f2);
        } else {
            a.k(view, f2);
        }
    }

    public static void setY(View view, float f2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(f2);
        } else {
            a.l(view, f2);
        }
    }

    public static ArrayList<View> a(View view) {
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
}
