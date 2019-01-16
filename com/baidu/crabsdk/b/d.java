package com.baidu.crabsdk.b;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes6.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> Yc = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float Yd = 0.0f;
    private static float Ye = 0.0f;
    private static float Yf = 0.0f;
    private static float Yg = 0.0f;
    private static String Yh = "";
    private static long Yi = 0;
    private static long Yj = 0;
    private static Rect Yk = null;

    private static List<View> D(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) Yd;
                    int i3 = (int) Ye;
                    if (Yk == null) {
                        Yk = new Rect();
                    }
                    childAt.getDrawingRect(Yk);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    Yk.left = iArr[0];
                    Yk.top = iArr[1];
                    Yk.right += iArr[0];
                    Yk.bottom = iArr[1] + Yk.bottom;
                    if (Yk.contains(i2, i3)) {
                        arrayList.add(childAt);
                        arrayList.addAll(D(childAt));
                    }
                }
            }
        }
        return arrayList;
    }

    private static void a(int i, Activity activity) {
        View decorView;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SimpleDateFormat(AiAppDateTimeUtil.TIME_FORMAT).format(new Date(System.currentTimeMillis())));
        StringBuilder sb = new StringBuilder();
        if (activity != null && (decorView = activity.getWindow().getDecorView()) != null) {
            List<View> D = D(decorView);
            String str = "";
            for (View view : D) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb.append(str);
        }
        arrayList.add(sb.toString());
        switch (i) {
            case 1:
                arrayList.add(AiAppsUBCStatistic.TYPE_CLICK);
                arrayList.add("(" + Yd + ", " + Ye + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + Yd + ", " + Ye + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + Yd + ", " + Ye + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + Yd + ", " + Ye + ") to:(" + Yf + ", " + Yg + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + Yd + ", " + Ye + ") to:(" + Yf + ", " + Yg + ")");
                break;
        }
        arrayList.add(Yh);
        Yc.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        Yh = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                Yd = motionEvent.getX();
                Ye = motionEvent.getY();
                Yi = System.currentTimeMillis();
                return;
            case 1:
                Yf = motionEvent.getX();
                Yg = motionEvent.getY();
                Yj = System.currentTimeMillis();
                if (Math.abs(Yg - Ye) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(Yf - Yd) > 30.0f && Math.abs(Yg - Ye) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (Yj - Yi > 300) {
                    a(3, activity);
                    return;
                } else {
                    a(1, activity);
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    public static String u() {
        StringBuilder sb = new StringBuilder();
        int size = Yc.size();
        for (int i = 0; i < size; i++) {
            List list = Yc.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.cJ("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
