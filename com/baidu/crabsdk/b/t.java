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
    private static com.baidu.crabsdk.c.b<List> aan = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String aao = "";
    private static String ZV = "";
    private static int aap = 0;
    private static int aaq = 0;

    private static WebView M(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (!(childAt.getLocalVisibleRect(new Rect(0, 0, aap, aaq)))) {
                        continue;
                    } else if (childAt instanceof WebView) {
                        return (WebView) childAt;
                    } else {
                        WebView M = M(childAt);
                        if (M != null) {
                            return M;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static String P() {
        return aan.size() > 0 ? new JSONArray((Collection) aan).toString() : "";
    }

    public static boolean rn() {
        return P().length() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:16:0x004a, B:18:0x0054, B:20:0x005a, B:22:0x0066), top: B:27:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        WebView M;
        if (activity == null) {
            return;
        }
        if (aap == 0 || aaq == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            aaq = displayMetrics.heightPixels;
            aap = displayMetrics.widthPixels;
        }
        switch (motionEvent.getAction()) {
            case 0:
                String name = activity.getClass().getName();
                if (!name.equals(ZV)) {
                    com.baidu.crabsdk.c.a.v("***** !tempName.equals(activityName) *****");
                    ZV = name;
                    aan.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            M = M(decorView);
                            if (M == null) {
                                String url = M.getUrl();
                                if (url.equals(aao)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.v("-------- !tempUrl.equals(mUrl) --------");
                                aao = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(M.getTitle());
                                arrayList.add(aao);
                                com.baidu.crabsdk.c.a.v("title:" + M.getTitle() + "; url:" + aao);
                                aan.add(arrayList);
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
                M = null;
                if (M == null) {
                }
            default:
                return;
        }
    }
}
