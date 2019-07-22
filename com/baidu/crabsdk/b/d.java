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
    private static com.baidu.crabsdk.c.b<List> ZQ = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float ZR = 0.0f;
    private static float ZS = 0.0f;
    private static float ZT = 0.0f;
    private static float ZU = 0.0f;
    private static String ZV = "";
    private static long ZW = 0;
    private static long ZX = 0;
    private static Rect ZY = null;

    private static List<View> L(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) ZR;
                    int i3 = (int) ZS;
                    if (ZY == null) {
                        ZY = new Rect();
                    }
                    childAt.getDrawingRect(ZY);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    ZY.left = iArr[0];
                    ZY.top = iArr[1];
                    ZY.right += iArr[0];
                    ZY.bottom = iArr[1] + ZY.bottom;
                    if (ZY.contains(i2, i3)) {
                        arrayList.add(childAt);
                        arrayList.addAll(L(childAt));
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
            List<View> L = L(decorView);
            String str = "";
            for (View view : L) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb.append(str);
        }
        arrayList.add(sb.toString());
        switch (i) {
            case 1:
                arrayList.add("click");
                arrayList.add("(" + ZR + ", " + ZS + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + ZR + ", " + ZS + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + ZR + ", " + ZS + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + ZR + ", " + ZS + ") to:(" + ZT + ", " + ZU + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + ZR + ", " + ZS + ") to:(" + ZT + ", " + ZU + ")");
                break;
        }
        arrayList.add(ZV);
        ZQ.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        ZV = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                ZR = motionEvent.getX();
                ZS = motionEvent.getY();
                ZW = System.currentTimeMillis();
                return;
            case 1:
                ZT = motionEvent.getX();
                ZU = motionEvent.getY();
                ZX = System.currentTimeMillis();
                if (Math.abs(ZU - ZS) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(ZT - ZR) > 30.0f && Math.abs(ZU - ZS) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (ZX - ZW > 300) {
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
        int size = ZQ.size();
        for (int i = 0; i < size; i++) {
            List list = ZQ.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
