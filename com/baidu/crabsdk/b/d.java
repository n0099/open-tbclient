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
/* loaded from: classes8.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> anJ = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float anK = 0.0f;
    private static float anL = 0.0f;
    private static float anM = 0.0f;
    private static float anN = 0.0f;
    private static String bc = "";
    private static long anO = 0;
    private static long anP = 0;
    private static Rect anQ = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) anK;
                    int i3 = (int) anL;
                    if (anQ == null) {
                        anQ = new Rect();
                    }
                    childAt.getDrawingRect(anQ);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    anQ.left = iArr[0];
                    anQ.top = iArr[1];
                    anQ.right += iArr[0];
                    anQ.bottom = iArr[1] + anQ.bottom;
                    if (anQ.contains(i2, i3)) {
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
                arrayList.add("(" + anK + ", " + anL + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + anK + ", " + anL + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + anK + ", " + anL + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + anK + ", " + anL + ") to:(" + anM + ", " + anN + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + anK + ", " + anL + ") to:(" + anM + ", " + anN + ")");
                break;
        }
        arrayList.add(bc);
        anJ.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                anK = motionEvent.getX();
                anL = motionEvent.getY();
                anO = System.currentTimeMillis();
                return;
            case 1:
                anM = motionEvent.getX();
                anN = motionEvent.getY();
                anP = System.currentTimeMillis();
                if (Math.abs(anN - anL) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(anM - anK) > 30.0f && Math.abs(anN - anL) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (anP - anO > 300) {
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
        int size = anJ.size();
        for (int i = 0; i < size; i++) {
            List list = anJ.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
