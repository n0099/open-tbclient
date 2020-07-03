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
    private static com.baidu.crabsdk.c.b<List> ami = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float amj = 0.0f;
    private static float amk = 0.0f;
    private static float aml = 0.0f;
    private static float amm = 0.0f;
    private static String bc = "";
    private static long amn = 0;
    private static long amo = 0;
    private static Rect amp = null;

    private static List<View> G(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) amj;
                    int i3 = (int) amk;
                    if (amp == null) {
                        amp = new Rect();
                    }
                    childAt.getDrawingRect(amp);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    amp.left = iArr[0];
                    amp.top = iArr[1];
                    amp.right += iArr[0];
                    amp.bottom = iArr[1] + amp.bottom;
                    if (amp.contains(i2, i3)) {
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
                arrayList.add("(" + amj + ", " + amk + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + amj + ", " + amk + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + amj + ", " + amk + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + amj + ", " + amk + ") to:(" + aml + ", " + amm + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + amj + ", " + amk + ") to:(" + aml + ", " + amm + ")");
                break;
        }
        arrayList.add(bc);
        ami.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                amj = motionEvent.getX();
                amk = motionEvent.getY();
                amn = System.currentTimeMillis();
                return;
            case 1:
                aml = motionEvent.getX();
                amm = motionEvent.getY();
                amo = System.currentTimeMillis();
                if (Math.abs(amm - amk) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(aml - amj) > 30.0f && Math.abs(amm - amk) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (amo - amn > 300) {
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
        int size = ami.size();
        for (int i = 0; i < size; i++) {
            List list = ami.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
