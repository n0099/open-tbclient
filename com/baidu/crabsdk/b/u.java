package com.baidu.crabsdk.b;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.crabsdk.c.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static b<List> f4850a = new b<>(com.baidu.crabsdk.a.f4785g);

    /* renamed from: b  reason: collision with root package name */
    public static String f4851b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f4852c = "";

    /* renamed from: d  reason: collision with root package name */
    public static int f4853d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f4854e = 0;

    public static String a() {
        return f4850a.size() > 0 ? new JSONArray((Collection) f4850a).toString() : "";
    }

    public static boolean b() {
        return a().length() > 0;
    }

    public static WebView c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0 && childAt.getLocalVisibleRect(new Rect(0, 0, f4853d, f4854e))) {
                    if (childAt instanceof WebView) {
                        return (WebView) childAt;
                    }
                    WebView c2 = c(childAt);
                    if (c2 != null) {
                        return c2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b A[Catch: Exception -> 0x00c8, TryCatch #0 {Exception -> 0x00c8, blocks: (B:16:0x0049, B:18:0x0053, B:21:0x005b, B:23:0x0067), top: B:27:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(MotionEvent motionEvent, Activity activity) {
        WebView c2;
        if (activity == null) {
            return;
        }
        if (f4853d == 0 || f4854e == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            f4854e = displayMetrics.heightPixels;
            f4853d = displayMetrics.widthPixels;
        }
        if (motionEvent.getAction() != 0) {
            return;
        }
        String name = activity.getClass().getName();
        if (!name.equals(f4852c)) {
            com.baidu.crabsdk.c.a.c("***** !tempName.equals(activityName) *****");
            f4852c = name;
            f4850a.clear();
        }
        if (activity != null) {
            try {
                View decorView = activity.getWindow().getDecorView();
                if (decorView != null) {
                    c2 = c(decorView);
                    if (c2 == null) {
                        String url = c2.getUrl();
                        if (url.equals(f4851b)) {
                            return;
                        }
                        com.baidu.crabsdk.c.a.c("-------- !tempUrl.equals(mUrl) --------");
                        f4851b = url;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                        arrayList.add(c2.getTitle());
                        arrayList.add(f4851b);
                        com.baidu.crabsdk.c.a.c("title:" + c2.getTitle() + "; url:" + f4851b);
                        f4850a.add(arrayList);
                        StringBuilder sb = new StringBuilder("###### jsonArray.toString() : ");
                        sb.append(a());
                        com.baidu.crabsdk.c.a.c(sb.toString());
                        return;
                    }
                    return;
                }
            } catch (Exception unused) {
                com.baidu.crabsdk.c.a.d("createUrlRecord error!!");
                return;
            }
        }
        c2 = null;
        if (c2 == null) {
        }
    }
}
