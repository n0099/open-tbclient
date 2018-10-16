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
    private static com.baidu.crabsdk.c.b<List> XT = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float XU = 0.0f;
    private static float XV = 0.0f;
    private static float XW = 0.0f;
    private static float XX = 0.0f;
    private static String XY = "";
    private static long XZ = 0;
    private static long Ya = 0;
    private static Rect Yb = null;

    private static List<View> D(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) XU;
                    int i3 = (int) XV;
                    if (Yb == null) {
                        Yb = new Rect();
                    }
                    childAt.getDrawingRect(Yb);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    Yb.left = iArr[0];
                    Yb.top = iArr[1];
                    Yb.right += iArr[0];
                    Yb.bottom = iArr[1] + Yb.bottom;
                    if (Yb.contains(i2, i3)) {
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
                arrayList.add("(" + XU + ", " + XV + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + XU + ", " + XV + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + XU + ", " + XV + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + XU + ", " + XV + ") to:(" + XW + ", " + XX + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + XU + ", " + XV + ") to:(" + XW + ", " + XX + ")");
                break;
        }
        arrayList.add(XY);
        XT.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        XY = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                XU = motionEvent.getX();
                XV = motionEvent.getY();
                XZ = System.currentTimeMillis();
                return;
            case 1:
                XW = motionEvent.getX();
                XX = motionEvent.getY();
                Ya = System.currentTimeMillis();
                if (Math.abs(XX - XV) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(XW - XU) > 30.0f && Math.abs(XX - XV) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (Ya - XZ > 300) {
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
        int size = XT.size();
        for (int i = 0; i < size; i++) {
            List list = XT.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.cI("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
