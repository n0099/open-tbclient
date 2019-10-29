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
/* loaded from: classes3.dex */
public final class t {
    private static com.baidu.crabsdk.c.b<List> Kq = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String Kr = "";
    private static String JY = "";
    private static int Ks = 0;
    private static int Kt = 0;

    private static WebView H(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (!(childAt.getLocalVisibleRect(new Rect(0, 0, Ks, Kt)))) {
                        continue;
                    } else if (childAt instanceof WebView) {
                        return (WebView) childAt;
                    } else {
                        WebView H = H(childAt);
                        if (H != null) {
                            return H;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static String P() {
        return Kq.size() > 0 ? new JSONArray((Collection) Kq).toString() : "";
    }

    public static boolean ms() {
        return P().length() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:16:0x004a, B:18:0x0054, B:20:0x005a, B:22:0x0066), top: B:27:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        WebView H;
        if (activity == null) {
            return;
        }
        if (Ks == 0 || Kt == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Kt = displayMetrics.heightPixels;
            Ks = displayMetrics.widthPixels;
        }
        switch (motionEvent.getAction()) {
            case 0:
                String name = activity.getClass().getName();
                if (!name.equals(JY)) {
                    com.baidu.crabsdk.c.a.v("***** !tempName.equals(activityName) *****");
                    JY = name;
                    Kq.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            H = H(decorView);
                            if (H == null) {
                                String url = H.getUrl();
                                if (url.equals(Kr)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.v("-------- !tempUrl.equals(mUrl) --------");
                                Kr = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(H.getTitle());
                                arrayList.add(Kr);
                                com.baidu.crabsdk.c.a.v("title:" + H.getTitle() + "; url:" + Kr);
                                Kq.add(arrayList);
                                com.baidu.crabsdk.c.a.v("###### jsonArray.toString() : " + P());
                                return;
                            }
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.crabsdk.c.a.w("createUrlRecord error!!");
                        return;
                    }
                }
                H = null;
                if (H == null) {
                }
            default:
                return;
        }
    }
}
