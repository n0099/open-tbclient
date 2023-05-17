package com.baidu.sapi2.views.swipeback.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class a {
    public static View a(ViewGroup viewGroup) {
        View a;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if (a(childAt)) {
                    return childAt;
                }
                if ((childAt instanceof ViewGroup) && (a = a((ViewGroup) childAt)) != null) {
                    return a;
                }
            }
        }
        return null;
    }

    public static boolean a(View view2) {
        if (!(view2 instanceof ScrollView) && !(view2 instanceof HorizontalScrollView) && !(view2 instanceof NestedScrollView) && !(view2 instanceof AbsListView) && !(view2 instanceof ViewPager) && !(view2 instanceof WebView)) {
            return false;
        }
        return true;
    }

    public static boolean a(View view2, float f, float f2) {
        Rect rect = new Rect();
        view2.getGlobalVisibleRect(rect);
        return rect.contains((int) f, (int) f2);
    }

    public static boolean a(View view2, float f, float f2, boolean z) {
        if (view2 != null && a(view2, f, f2)) {
            return ViewCompat.canScrollVertically(view2, 1);
        }
        return z;
    }

    public static boolean b(View view2, float f, float f2, boolean z) {
        if (view2 != null && a(view2, f, f2)) {
            return ViewCompat.canScrollHorizontally(view2, 1);
        }
        return z;
    }

    public static boolean c(View view2, float f, float f2, boolean z) {
        if (view2 != null && a(view2, f, f2)) {
            return ViewCompat.canScrollHorizontally(view2, -1);
        }
        return z;
    }

    public static boolean d(View view2, float f, float f2, boolean z) {
        if (view2 != null && a(view2, f, f2)) {
            return ViewCompat.canScrollVertically(view2, -1);
        }
        return z;
    }
}
