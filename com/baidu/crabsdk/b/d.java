package com.baidu.crabsdk.b;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> SE = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float SF = 0.0f;
    private static float SG = 0.0f;
    private static float SH = 0.0f;
    private static float SJ = 0.0f;
    private static String SK = "";
    private static long SL = 0;
    private static long SM = 0;
    private static Rect SO = null;

    private static void a(int i, Activity activity) {
        View decorView;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        StringBuilder sb = new StringBuilder();
        if (activity != null && (decorView = activity.getWindow().getDecorView()) != null) {
            List<View> t = t(decorView);
            String str = "";
            for (View view : t) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb.append(str);
        }
        arrayList.add(sb.toString());
        switch (i) {
            case 1:
                arrayList.add("click");
                arrayList.add("(" + SF + ", " + SG + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + SF + ", " + SG + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + SF + ", " + SG + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + SF + ", " + SG + ") to:(" + SH + ", " + SJ + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + SF + ", " + SG + ") to:(" + SH + ", " + SJ + ")");
                break;
        }
        arrayList.add(SK);
        SE.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        SK = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                SF = motionEvent.getX();
                SG = motionEvent.getY();
                SL = System.currentTimeMillis();
                return;
            case 1:
                SH = motionEvent.getX();
                SJ = motionEvent.getY();
                SM = System.currentTimeMillis();
                if (Math.abs(SJ - SG) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(SH - SF) > 30.0f && Math.abs(SJ - SG) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (SM - SL > 300) {
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

    private static List<View> t(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) SF;
                    int i3 = (int) SG;
                    if (SO == null) {
                        SO = new Rect();
                    }
                    childAt.getDrawingRect(SO);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    SO.left = iArr[0];
                    SO.top = iArr[1];
                    SO.right += iArr[0];
                    SO.bottom = iArr[1] + SO.bottom;
                    if (SO.contains(i2, i3)) {
                        arrayList.add(childAt);
                        arrayList.addAll(t(childAt));
                    }
                }
            }
        }
        return arrayList;
    }

    public static String u() {
        StringBuilder sb = new StringBuilder();
        int size = SE.size();
        for (int i = 0; i < size; i++) {
            List list = SE.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.cf("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
