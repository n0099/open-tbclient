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
/* loaded from: classes5.dex */
public final class t {
    private static com.baidu.crabsdk.c.b<List> Qt = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String Qu = "";
    private static String Qa = "";
    private static int Qv = 0;
    private static int Qw = 0;

    private static WebView I(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (!(childAt.getLocalVisibleRect(new Rect(0, 0, Qv, Qw)))) {
                        continue;
                    } else if (childAt instanceof WebView) {
                        return (WebView) childAt;
                    } else {
                        WebView I = I(childAt);
                        if (I != null) {
                            return I;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static String P() {
        return Qt.size() > 0 ? new JSONArray((Collection) Qt).toString() : "";
    }

    public static boolean nB() {
        return P().length() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:16:0x004a, B:18:0x0054, B:20:0x005a, B:22:0x0066), top: B:27:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void urlRecordEvent(MotionEvent motionEvent, Activity activity) {
        WebView I;
        if (activity == null) {
            return;
        }
        if (Qv == 0 || Qw == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Qw = displayMetrics.heightPixels;
            Qv = displayMetrics.widthPixels;
        }
        switch (motionEvent.getAction()) {
            case 0:
                String name = activity.getClass().getName();
                if (!name.equals(Qa)) {
                    com.baidu.crabsdk.c.a.v("***** !tempName.equals(activityName) *****");
                    Qa = name;
                    Qt.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            I = I(decorView);
                            if (I == null) {
                                String url = I.getUrl();
                                if (url.equals(Qu)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.v("-------- !tempUrl.equals(mUrl) --------");
                                Qu = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(I.getTitle());
                                arrayList.add(Qu);
                                com.baidu.crabsdk.c.a.v("title:" + I.getTitle() + "; url:" + Qu);
                                Qt.add(arrayList);
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
                I = null;
                if (I == null) {
                }
            default:
                return;
        }
    }
}
