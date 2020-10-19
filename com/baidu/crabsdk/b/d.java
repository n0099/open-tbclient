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
/* loaded from: classes11.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> aos = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float aot = 0.0f;
    private static float aou = 0.0f;
    private static float aov = 0.0f;
    private static float aow = 0.0f;
    private static String bc = "";
    private static long aox = 0;
    private static long aoy = 0;
    private static Rect aoz = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) aot;
                    int i3 = (int) aou;
                    if (aoz == null) {
                        aoz = new Rect();
                    }
                    childAt.getDrawingRect(aoz);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    aoz.left = iArr[0];
                    aoz.top = iArr[1];
                    aoz.right += iArr[0];
                    aoz.bottom = iArr[1] + aoz.bottom;
                    if (aoz.contains(i2, i3)) {
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
                arrayList.add("(" + aot + ", " + aou + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + aot + ", " + aou + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + aot + ", " + aou + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + aot + ", " + aou + ") to:(" + aov + ", " + aow + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + aot + ", " + aou + ") to:(" + aov + ", " + aow + ")");
                break;
        }
        arrayList.add(bc);
        aos.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                aot = motionEvent.getX();
                aou = motionEvent.getY();
                aox = System.currentTimeMillis();
                return;
            case 1:
                aov = motionEvent.getX();
                aow = motionEvent.getY();
                aoy = System.currentTimeMillis();
                if (Math.abs(aow - aou) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(aov - aot) > 30.0f && Math.abs(aow - aou) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (aoy - aox > 300) {
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
        int size = aos.size();
        for (int i = 0; i < size; i++) {
            List list = aos.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
