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
/* loaded from: classes3.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> apN = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float apO = 0.0f;
    private static float apP = 0.0f;
    private static float apQ = 0.0f;
    private static float apR = 0.0f;
    private static String bc = "";
    private static long apS = 0;
    private static long apT = 0;
    private static Rect apU = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) apO;
                    int i3 = (int) apP;
                    if (apU == null) {
                        apU = new Rect();
                    }
                    childAt.getDrawingRect(apU);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    apU.left = iArr[0];
                    apU.top = iArr[1];
                    apU.right += iArr[0];
                    apU.bottom = iArr[1] + apU.bottom;
                    if (apU.contains(i2, i3)) {
                        arrayList.add(childAt);
                        arrayList.addAll(I(childAt));
                    }
                }
            }
        }
        return arrayList;
    }

    private static void a(int i, Activity activity) {
        View decorView;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        StringBuilder sb = new StringBuilder();
        if (activity != null && (decorView = activity.getWindow().getDecorView()) != null) {
            List<View> I = I(decorView);
            String str = "";
            for (View view : I) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb.append(str);
        }
        arrayList.add(sb.toString());
        switch (i) {
            case 1:
                arrayList.add("click");
                arrayList.add("(" + apO + ", " + apP + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + apO + ", " + apP + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + apO + ", " + apP + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + apO + ", " + apP + ") to:(" + apQ + ", " + apR + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + apO + ", " + apP + ") to:(" + apQ + ", " + apR + ")");
                break;
        }
        arrayList.add(bc);
        apN.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                apO = motionEvent.getX();
                apP = motionEvent.getY();
                apS = System.currentTimeMillis();
                return;
            case 1:
                apQ = motionEvent.getX();
                apR = motionEvent.getY();
                apT = System.currentTimeMillis();
                if (Math.abs(apR - apP) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(apQ - apO) > 30.0f && Math.abs(apR - apP) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (apT - apS > 300) {
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

    public static String w() {
        StringBuilder sb = new StringBuilder();
        int size = apN.size();
        for (int i = 0; i < size; i++) {
            List list = apN.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
