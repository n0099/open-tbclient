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
/* loaded from: classes5.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> aoO = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float aoP = 0.0f;
    private static float aoQ = 0.0f;
    private static float aoR = 0.0f;
    private static float aoS = 0.0f;
    private static String bc = "";
    private static long aoT = 0;
    private static long aoU = 0;
    private static Rect aoV = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) aoP;
                    int i3 = (int) aoQ;
                    if (aoV == null) {
                        aoV = new Rect();
                    }
                    childAt.getDrawingRect(aoV);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    aoV.left = iArr[0];
                    aoV.top = iArr[1];
                    aoV.right += iArr[0];
                    aoV.bottom = iArr[1] + aoV.bottom;
                    if (aoV.contains(i2, i3)) {
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
                arrayList.add("(" + aoP + ", " + aoQ + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + aoP + ", " + aoQ + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + aoP + ", " + aoQ + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + aoP + ", " + aoQ + ") to:(" + aoR + ", " + aoS + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + aoP + ", " + aoQ + ") to:(" + aoR + ", " + aoS + ")");
                break;
        }
        arrayList.add(bc);
        aoO.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                aoP = motionEvent.getX();
                aoQ = motionEvent.getY();
                aoT = System.currentTimeMillis();
                return;
            case 1:
                aoR = motionEvent.getX();
                aoS = motionEvent.getY();
                aoU = System.currentTimeMillis();
                if (Math.abs(aoS - aoQ) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(aoR - aoP) > 30.0f && Math.abs(aoS - aoQ) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (aoU - aoT > 300) {
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
        int size = aoO.size();
        for (int i = 0; i < size; i++) {
            List list = aoO.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
