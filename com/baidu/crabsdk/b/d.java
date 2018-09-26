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
    private static com.baidu.crabsdk.c.b<List> Vh = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float Vi = 0.0f;
    private static float Vj = 0.0f;
    private static float Vk = 0.0f;
    private static float Vl = 0.0f;
    private static String Vm = "";
    private static long Vn = 0;
    private static long Vo = 0;
    private static Rect Vp = null;

    private static List<View> D(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) Vi;
                    int i3 = (int) Vj;
                    if (Vp == null) {
                        Vp = new Rect();
                    }
                    childAt.getDrawingRect(Vp);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    Vp.left = iArr[0];
                    Vp.top = iArr[1];
                    Vp.right += iArr[0];
                    Vp.bottom = iArr[1] + Vp.bottom;
                    if (Vp.contains(i2, i3)) {
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
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
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
                arrayList.add("click");
                arrayList.add("(" + Vi + ", " + Vj + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + Vi + ", " + Vj + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + Vi + ", " + Vj + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + Vi + ", " + Vj + ") to:(" + Vk + ", " + Vl + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + Vi + ", " + Vj + ") to:(" + Vk + ", " + Vl + ")");
                break;
        }
        arrayList.add(Vm);
        Vh.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        Vm = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                Vi = motionEvent.getX();
                Vj = motionEvent.getY();
                Vn = System.currentTimeMillis();
                return;
            case 1:
                Vk = motionEvent.getX();
                Vl = motionEvent.getY();
                Vo = System.currentTimeMillis();
                if (Math.abs(Vl - Vj) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(Vk - Vi) > 30.0f && Math.abs(Vl - Vj) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (Vo - Vn > 300) {
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
        int size = Vh.size();
        for (int i = 0; i < size; i++) {
            List list = Vh.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.cx("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
