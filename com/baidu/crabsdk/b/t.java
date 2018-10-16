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
/* loaded from: classes6.dex */
public final class t {
    private static com.baidu.crabsdk.c.b<List> Yp = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String Yq = "";
    private static String XY = "";
    private static int widthPixels = 0;
    private static int heightPixels = 0;

    private static WebView E(View view) {
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
                        WebView E = E(childAt);
                        if (E != null) {
                            return E;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean R() {
        return ru().length() > 0;
    }

    public static String ru() {
        return Yp.size() > 0 ? new JSONArray((Collection) Yp).toString() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:16:0x004a, B:18:0x0054, B:20:0x005a, B:22:0x0066), top: B:27:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        WebView E;
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
                if (!name.equals(XY)) {
                    com.baidu.crabsdk.c.a.cI("***** !tempName.equals(activityName) *****");
                    XY = name;
                    Yp.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            E = E(decorView);
                            if (E == null) {
                                String url = E.getUrl();
                                if (url.equals(Yq)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.cI("-------- !tempUrl.equals(mUrl) --------");
                                Yq = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(E.getTitle());
                                arrayList.add(Yq);
                                com.baidu.crabsdk.c.a.cI("title:" + E.getTitle() + "; url:" + Yq);
                                Yp.add(arrayList);
                                com.baidu.crabsdk.c.a.cI("###### jsonArray.toString() : " + ru());
                                return;
                            }
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.crabsdk.c.a.cJ("createUrlRecord error!!");
                        return;
                    }
                }
                E = null;
                if (E == null) {
                }
            default:
                return;
        }
    }
}
