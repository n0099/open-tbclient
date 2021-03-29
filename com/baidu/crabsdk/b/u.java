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
    public static b<List> f4703a = new b<>(com.baidu.crabsdk.a.f4641g);

    /* renamed from: b  reason: collision with root package name */
    public static String f4704b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f4705c = "";

    /* renamed from: d  reason: collision with root package name */
    public static int f4706d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f4707e = 0;

    public static String a() {
        return f4703a.size() > 0 ? new JSONArray((Collection) f4703a).toString() : "";
    }

    public static boolean b() {
        return a().length() > 0;
    }

    public static WebView c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0 && childAt.getLocalVisibleRect(new Rect(0, 0, f4706d, f4707e))) {
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
        if (f4706d == 0 || f4707e == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            f4707e = displayMetrics.heightPixels;
            f4706d = displayMetrics.widthPixels;
        }
        if (motionEvent.getAction() != 0) {
            return;
        }
        String name = activity.getClass().getName();
        if (!name.equals(f4705c)) {
            com.baidu.crabsdk.c.a.c("***** !tempName.equals(activityName) *****");
            f4705c = name;
            f4703a.clear();
        }
        if (activity != null) {
            try {
                View decorView = activity.getWindow().getDecorView();
                if (decorView != null) {
                    c2 = c(decorView);
                    if (c2 == null) {
                        String url = c2.getUrl();
                        if (url.equals(f4704b)) {
                            return;
                        }
                        com.baidu.crabsdk.c.a.c("-------- !tempUrl.equals(mUrl) --------");
                        f4704b = url;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                        arrayList.add(c2.getTitle());
                        arrayList.add(f4704b);
                        com.baidu.crabsdk.c.a.c("title:" + c2.getTitle() + "; url:" + f4704b);
                        f4703a.add(arrayList);
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
