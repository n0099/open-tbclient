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
    private static com.baidu.crabsdk.c.b<List> akh = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float aki = 0.0f;
    private static float akj = 0.0f;
    private static float akk = 0.0f;
    private static float akl = 0.0f;
    private static String akm = "";
    private static long akn = 0;
    private static long ako = 0;
    private static Rect akp = null;

    private static List<View> H(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) aki;
                    int i3 = (int) akj;
                    if (akp == null) {
                        akp = new Rect();
                    }
                    childAt.getDrawingRect(akp);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    akp.left = iArr[0];
                    akp.top = iArr[1];
                    akp.right += iArr[0];
                    akp.bottom = iArr[1] + akp.bottom;
                    if (akp.contains(i2, i3)) {
                        arrayList.add(childAt);
                        arrayList.addAll(H(childAt));
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
            List<View> H = H(decorView);
            String str = "";
            for (View view : H) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb.append(str);
        }
        arrayList.add(sb.toString());
        switch (i) {
            case 1:
                arrayList.add("click");
                arrayList.add("(" + aki + ", " + akj + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + aki + ", " + akj + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + aki + ", " + akj + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + aki + ", " + akj + ") to:(" + akk + ", " + akl + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + aki + ", " + akj + ") to:(" + akk + ", " + akl + ")");
                break;
        }
        arrayList.add(akm);
        akh.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        akm = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                aki = motionEvent.getX();
                akj = motionEvent.getY();
                akn = System.currentTimeMillis();
                return;
            case 1:
                akk = motionEvent.getX();
                akl = motionEvent.getY();
                ako = System.currentTimeMillis();
                if (Math.abs(akl - akj) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(akk - aki) > 30.0f && Math.abs(akl - akj) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (ako - akn > 300) {
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
        int size = akh.size();
        for (int i = 0; i < size; i++) {
            List list = akh.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
