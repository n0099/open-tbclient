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
/* loaded from: classes14.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> aoY = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float aoZ = 0.0f;
    private static float apa = 0.0f;
    private static float apb = 0.0f;
    private static float apc = 0.0f;
    private static String bc = "";
    private static long apd = 0;
    private static long ape = 0;
    private static Rect apf = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) aoZ;
                    int i3 = (int) apa;
                    if (apf == null) {
                        apf = new Rect();
                    }
                    childAt.getDrawingRect(apf);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    apf.left = iArr[0];
                    apf.top = iArr[1];
                    apf.right += iArr[0];
                    apf.bottom = iArr[1] + apf.bottom;
                    if (apf.contains(i2, i3)) {
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
                arrayList.add("(" + aoZ + ", " + apa + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + aoZ + ", " + apa + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + aoZ + ", " + apa + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + aoZ + ", " + apa + ") to:(" + apb + ", " + apc + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + aoZ + ", " + apa + ") to:(" + apb + ", " + apc + ")");
                break;
        }
        arrayList.add(bc);
        aoY.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                aoZ = motionEvent.getX();
                apa = motionEvent.getY();
                apd = System.currentTimeMillis();
                return;
            case 1:
                apb = motionEvent.getX();
                apc = motionEvent.getY();
                ape = System.currentTimeMillis();
                if (Math.abs(apc - apa) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(apb - aoZ) > 30.0f && Math.abs(apc - apa) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (ape - apd > 300) {
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
        int size = aoY.size();
        for (int i = 0; i < size; i++) {
            List list = aoY.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
