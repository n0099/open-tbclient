package com.baidu.crabsdk.b;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public final class t {
    private static com.baidu.crabsdk.c.b<List> Tc = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String Td = "";
    private static String SK = "";
    private static int widthPixels = 0;
    private static int heightPixels = 0;

    public static String P() {
        return Tc.size() > 0 ? new JSONArray((Collection) Tc).toString() : "";
    }

    public static boolean pe() {
        return P().length() > 0;
    }

    private static WebView u(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (!(childAt.getLocalVisibleRect(new Rect(0, 0, widthPixels, heightPixels)))) {
                        continue;
                    } else if (childAt instanceof WebView) {
                        return (WebView) childAt;
                    } else {
                        WebView u = u(childAt);
                        if (u != null) {
                            return u;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:16:0x004a, B:18:0x0054, B:20:0x005a, B:22:0x0066), top: B:27:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        WebView u;
        if (activity == null) {
            return;
        }
        if (widthPixels == 0 || heightPixels == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            heightPixels = displayMetrics.heightPixels;
            widthPixels = displayMetrics.widthPixels;
        }
        switch (motionEvent.getAction()) {
            case 0:
                String name = activity.getClass().getName();
                if (!name.equals(SK)) {
                    com.baidu.crabsdk.c.a.cf("***** !tempName.equals(activityName) *****");
                    SK = name;
                    Tc.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            u = u(decorView);
                            if (u == null) {
                                String url = u.getUrl();
                                if (url.equals(Td)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.cf("-------- !tempUrl.equals(mUrl) --------");
                                Td = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(u.getTitle());
                                arrayList.add(Td);
                                com.baidu.crabsdk.c.a.cf("title:" + u.getTitle() + "; url:" + Td);
                                Tc.add(arrayList);
                                com.baidu.crabsdk.c.a.cf("###### jsonArray.toString() : " + P());
                                return;
                            }
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.crabsdk.c.a.cg("createUrlRecord error!!");
                        return;
                    }
                }
                u = null;
                if (u == null) {
                }
            default:
                return;
        }
    }
}
