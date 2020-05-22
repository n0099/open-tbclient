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
    private static com.baidu.crabsdk.c.b<List> akN = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float akO = 0.0f;
    private static float akP = 0.0f;
    private static float akQ = 0.0f;
    private static float akR = 0.0f;
    private static String akS = "";
    private static long akT = 0;
    private static long akU = 0;
    private static Rect akV = null;

    private static List<View> G(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) akO;
                    int i3 = (int) akP;
                    if (akV == null) {
                        akV = new Rect();
                    }
                    childAt.getDrawingRect(akV);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    akV.left = iArr[0];
                    akV.top = iArr[1];
                    akV.right += iArr[0];
                    akV.bottom = iArr[1] + akV.bottom;
                    if (akV.contains(i2, i3)) {
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
                arrayList.add("(" + akO + ", " + akP + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + akO + ", " + akP + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + akO + ", " + akP + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + akO + ", " + akP + ") to:(" + akQ + ", " + akR + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + akO + ", " + akP + ") to:(" + akQ + ", " + akR + ")");
                break;
        }
        arrayList.add(akS);
        akN.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        akS = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                akO = motionEvent.getX();
                akP = motionEvent.getY();
                akT = System.currentTimeMillis();
                return;
            case 1:
                akQ = motionEvent.getX();
                akR = motionEvent.getY();
                akU = System.currentTimeMillis();
                if (Math.abs(akR - akP) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(akQ - akO) > 30.0f && Math.abs(akR - akP) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (akU - akT > 300) {
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
        int size = akN.size();
        for (int i = 0; i < size; i++) {
            List list = akN.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
