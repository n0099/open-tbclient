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
/* loaded from: classes2.dex */
public class a {
    public static boolean a(View view, float f2, float f3, boolean z) {
        return (view == null || !a(view, f2, f3)) ? z : ViewCompat.canScrollVertically(view, 1);
    }

    public static boolean b(View view, float f2, float f3, boolean z) {
        return (view == null || !a(view, f2, f3)) ? z : ViewCompat.canScrollHorizontally(view, 1);
    }

    public static boolean c(View view, float f2, float f3, boolean z) {
        return (view == null || !a(view, f2, f3)) ? z : ViewCompat.canScrollHorizontally(view, -1);
    }

    public static boolean d(View view, float f2, float f3, boolean z) {
        return (view == null || !a(view, f2, f3)) ? z : ViewCompat.canScrollVertically(view, -1);
    }

    public static View a(ViewGroup viewGroup) {
        View a2;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                if (a(childAt)) {
                    return childAt;
                }
                if ((childAt instanceof ViewGroup) && (a2 = a((ViewGroup) childAt)) != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    public static boolean a(View view) {
        return (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || (view instanceof NestedScrollView) || (view instanceof AbsListView) || (view instanceof ViewPager) || (view instanceof WebView);
    }

    public static boolean a(View view, float f2, float f3) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.contains((int) f2, (int) f3);
    }
}
