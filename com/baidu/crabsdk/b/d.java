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
    private static com.baidu.crabsdk.c.b<List> Zw = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float Zx = 0.0f;
    private static float Zy = 0.0f;
    private static float Zz = 0.0f;
    private static float ZA = 0.0f;
    private static String ZB = "";
    private static long ZC = 0;
    private static long ZD = 0;
    private static Rect ZE = null;

    private static List<View> J(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) Zx;
                    int i3 = (int) Zy;
                    if (ZE == null) {
                        ZE = new Rect();
                    }
                    childAt.getDrawingRect(ZE);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    ZE.left = iArr[0];
                    ZE.top = iArr[1];
                    ZE.right += iArr[0];
                    ZE.bottom = iArr[1] + ZE.bottom;
                    if (ZE.contains(i2, i3)) {
                        arrayList.add(childAt);
                        arrayList.addAll(J(childAt));
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
            List<View> J = J(decorView);
            String str = "";
            for (View view : J) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb.append(str);
        }
        arrayList.add(sb.toString());
        switch (i) {
            case 1:
                arrayList.add("click");
                arrayList.add("(" + Zx + ", " + Zy + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + Zx + ", " + Zy + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + Zx + ", " + Zy + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + Zx + ", " + Zy + ") to:(" + Zz + ", " + ZA + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + Zx + ", " + Zy + ") to:(" + Zz + ", " + ZA + ")");
                break;
        }
        arrayList.add(ZB);
        Zw.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        ZB = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                Zx = motionEvent.getX();
                Zy = motionEvent.getY();
                ZC = System.currentTimeMillis();
                return;
            case 1:
                Zz = motionEvent.getX();
                ZA = motionEvent.getY();
                ZD = System.currentTimeMillis();
                if (Math.abs(ZA - Zy) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(Zz - Zx) > 30.0f && Math.abs(ZA - Zy) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (ZD - ZC > 300) {
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
        int size = Zw.size();
        for (int i = 0; i < size; i++) {
            List list = Zw.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
