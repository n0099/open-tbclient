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
    private static com.baidu.crabsdk.c.b<List> JQ = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String JR = "";
    private static String Jy = "";
    private static int JS = 0;
    private static int JT = 0;

    private static WebView H(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (!(childAt.getLocalVisibleRect(new Rect(0, 0, JS, JT)))) {
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
        return JQ.size() > 0 ? new JSONArray((Collection) JQ).toString() : "";
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
        if (JS == 0 || JT == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            JT = displayMetrics.heightPixels;
            JS = displayMetrics.widthPixels;
        }
        switch (motionEvent.getAction()) {
            case 0:
                String name = activity.getClass().getName();
                if (!name.equals(Jy)) {
                    com.baidu.crabsdk.c.a.v("***** !tempName.equals(activityName) *****");
                    Jy = name;
                    JQ.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            H = H(decorView);
                            if (H == null) {
                                String url = H.getUrl();
                                if (url.equals(JR)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.v("-------- !tempUrl.equals(mUrl) --------");
                                JR = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(H.getTitle());
                                arrayList.add(JR);
                                com.baidu.crabsdk.c.a.v("title:" + H.getTitle() + "; url:" + JR);
                                JQ.add(arrayList);
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
