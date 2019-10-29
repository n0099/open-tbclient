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
    private static com.baidu.crabsdk.c.b<List> JT = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float JU = 0.0f;
    private static float JV = 0.0f;
    private static float JW = 0.0f;
    private static float JX = 0.0f;
    private static String JY = "";
    private static long JZ = 0;
    private static long Ka = 0;
    private static Rect Kb = null;

    private static List<View> G(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) JU;
                    int i3 = (int) JV;
                    if (Kb == null) {
                        Kb = new Rect();
                    }
                    childAt.getDrawingRect(Kb);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    Kb.left = iArr[0];
                    Kb.top = iArr[1];
                    Kb.right += iArr[0];
                    Kb.bottom = iArr[1] + Kb.bottom;
                    if (Kb.contains(i2, i3)) {
                        arrayList.add(childAt);
                        arrayList.addAll(G(childAt));
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
            List<View> G = G(decorView);
            String str = "";
            for (View view : G) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb.append(str);
        }
        arrayList.add(sb.toString());
        switch (i) {
            case 1:
                arrayList.add("click");
                arrayList.add("(" + JU + ", " + JV + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + JU + ", " + JV + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + JU + ", " + JV + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + JU + ", " + JV + ") to:(" + JW + ", " + JX + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + JU + ", " + JV + ") to:(" + JW + ", " + JX + ")");
                break;
        }
        arrayList.add(JY);
        JT.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        JY = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                JU = motionEvent.getX();
                JV = motionEvent.getY();
                JZ = System.currentTimeMillis();
                return;
            case 1:
                JW = motionEvent.getX();
                JX = motionEvent.getY();
                Ka = System.currentTimeMillis();
                if (Math.abs(JX - JV) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(JW - JU) > 30.0f && Math.abs(JX - JV) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (Ka - JZ > 300) {
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

    public static String t() {
        StringBuilder sb = new StringBuilder();
        int size = JT.size();
        for (int i = 0; i < size; i++) {
            List list = JT.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
