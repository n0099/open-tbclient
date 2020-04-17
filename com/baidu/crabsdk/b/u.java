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
/* loaded from: classes8.dex */
public final class u {
    private static com.baidu.crabsdk.c.b<List> akx = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String aky = "";
    private static String akg = "";
    private static int akz = 0;
    private static int akA = 0;

    private static WebView I(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (!(childAt.getLocalVisibleRect(new Rect(0, 0, akz, akA)))) {
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

    public static String sK() {
        return akx.size() > 0 ? new JSONArray((Collection) akx).toString() : "";
    }

    public static boolean sL() {
        return sK().length() > 0;
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
        if (akz == 0 || akA == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            akA = displayMetrics.heightPixels;
            akz = displayMetrics.widthPixels;
        }
        switch (motionEvent.getAction()) {
            case 0:
                String name = activity.getClass().getName();
                if (!name.equals(akg)) {
                    com.baidu.crabsdk.c.a.v("***** !tempName.equals(activityName) *****");
                    akg = name;
                    akx.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            I = I(decorView);
                            if (I == null) {
                                String url = I.getUrl();
                                if (url.equals(aky)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.v("-------- !tempUrl.equals(mUrl) --------");
                                aky = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(I.getTitle());
                                arrayList.add(aky);
                                com.baidu.crabsdk.c.a.v("title:" + I.getTitle() + "; url:" + aky);
                                akx.add(arrayList);
                                com.baidu.crabsdk.c.a.v("###### jsonArray.toString() : " + sK());
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
