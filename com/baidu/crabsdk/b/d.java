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
/* loaded from: classes7.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> aoz = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float aoA = 0.0f;
    private static float aoB = 0.0f;
    private static float aoC = 0.0f;
    private static float aoD = 0.0f;
    private static String bc = "";
    private static long aoE = 0;
    private static long aoF = 0;
    private static Rect aoG = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) aoA;
                    int i3 = (int) aoB;
                    if (aoG == null) {
                        aoG = new Rect();
                    }
                    childAt.getDrawingRect(aoG);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    aoG.left = iArr[0];
                    aoG.top = iArr[1];
                    aoG.right += iArr[0];
                    aoG.bottom = iArr[1] + aoG.bottom;
                    if (aoG.contains(i2, i3)) {
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
                arrayList.add("(" + aoA + ", " + aoB + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + aoA + ", " + aoB + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + aoA + ", " + aoB + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + aoA + ", " + aoB + ") to:(" + aoC + ", " + aoD + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + aoA + ", " + aoB + ") to:(" + aoC + ", " + aoD + ")");
                break;
        }
        arrayList.add(bc);
        aoz.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                aoA = motionEvent.getX();
                aoB = motionEvent.getY();
                aoE = System.currentTimeMillis();
                return;
            case 1:
                aoC = motionEvent.getX();
                aoD = motionEvent.getY();
                aoF = System.currentTimeMillis();
                if (Math.abs(aoD - aoB) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(aoC - aoA) > 30.0f && Math.abs(aoD - aoB) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (aoF - aoE > 300) {
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
        int size = aoz.size();
        for (int i = 0; i < size; i++) {
            List list = aoz.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
