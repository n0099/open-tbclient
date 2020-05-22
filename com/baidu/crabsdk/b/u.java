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
    private static com.baidu.crabsdk.c.b<List> alj = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.g);
    private static String bv = "";
    private static String akS = "";
    private static int alk = 0;
    private static int alm = 0;

    private static WebView H(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (!(childAt.getLocalVisibleRect(new Rect(0, 0, alk, alm)))) {
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

    public static String sR() {
        return alj.size() > 0 ? new JSONArray((Collection) alj).toString() : "";
    }

    public static boolean sS() {
        return sR().length() > 0;
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
        if (alk == 0 || alm == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            alm = displayMetrics.heightPixels;
            alk = displayMetrics.widthPixels;
        }
        switch (motionEvent.getAction()) {
            case 0:
                String name = activity.getClass().getName();
                if (!name.equals(akS)) {
                    com.baidu.crabsdk.c.a.v("***** !tempName.equals(activityName) *****");
                    akS = name;
                    alj.clear();
                }
                if (activity != null) {
                    try {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView != null) {
                            H = H(decorView);
                            if (H == null) {
                                String url = H.getUrl();
                                if (url.equals(bv)) {
                                    return;
                                }
                                com.baidu.crabsdk.c.a.v("-------- !tempUrl.equals(mUrl) --------");
                                bv = url;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                arrayList.add(H.getTitle());
                                arrayList.add(bv);
                                com.baidu.crabsdk.c.a.v("title:" + H.getTitle() + "; url:" + bv);
                                alj.add(arrayList);
                                com.baidu.crabsdk.c.a.v("###### jsonArray.toString() : " + sR());
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
