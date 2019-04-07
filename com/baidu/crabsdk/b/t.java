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
    private static com.baidu.crabsdk.c.b<List> acd = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String ace = "";
    private static String abK = "";
    private static int widthPixels = 0;
    private static int heightPixels = 0;

    private static WebView K(View view) {
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
                        WebView K = K(childAt);
                        if (K != null) {
                            return K;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static String P() {
        return acd.size() > 0 ? new JSONArray((Collection) acd).toString() : "";
    }

    public static boolean rV() {
        return P().length() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:16:0x004a, B:18:0x0054, B:20:0x005a, B:22:0x0066), top: B:27:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        WebView K;
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
                if (!name.equals(abK)) {
                    com.baidu.crabsdk.c.a.v("***** !tempName.equals(activityName) *****");
                    abK = name;
                    acd.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            K = K(decorView);
                            if (K == null) {
                                String url = K.getUrl();
                                if (url.equals(ace)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.v("-------- !tempUrl.equals(mUrl) --------");
                                ace = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(K.getTitle());
                                arrayList.add(ace);
                                com.baidu.crabsdk.c.a.v("title:" + K.getTitle() + "; url:" + ace);
                                acd.add(arrayList);
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
                K = null;
                if (K == null) {
                }
            default:
                return;
        }
    }
}
