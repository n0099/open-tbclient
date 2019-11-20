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
    private static com.baidu.crabsdk.c.b<List> Jt = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float Ju = 0.0f;
    private static float Jv = 0.0f;
    private static float Jw = 0.0f;
    private static float Jx = 0.0f;
    private static String Jy = "";
    private static long Jz = 0;
    private static long JA = 0;
    private static Rect JB = null;

    private static List<View> G(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) Ju;
                    int i3 = (int) Jv;
                    if (JB == null) {
                        JB = new Rect();
                    }
                    childAt.getDrawingRect(JB);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    JB.left = iArr[0];
                    JB.top = iArr[1];
                    JB.right += iArr[0];
                    JB.bottom = iArr[1] + JB.bottom;
                    if (JB.contains(i2, i3)) {
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
                arrayList.add("(" + Ju + ", " + Jv + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + Ju + ", " + Jv + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + Ju + ", " + Jv + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + Ju + ", " + Jv + ") to:(" + Jw + ", " + Jx + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + Ju + ", " + Jv + ") to:(" + Jw + ", " + Jx + ")");
                break;
        }
        arrayList.add(Jy);
        Jt.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        Jy = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                Ju = motionEvent.getX();
                Jv = motionEvent.getY();
                Jz = System.currentTimeMillis();
                return;
            case 1:
                Jw = motionEvent.getX();
                Jx = motionEvent.getY();
                JA = System.currentTimeMillis();
                if (Math.abs(Jx - Jv) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(Jw - Ju) > 30.0f && Math.abs(Jx - Jv) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (JA - Jz > 300) {
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
        int size = Jt.size();
        for (int i = 0; i < size; i++) {
            List list = Jt.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
