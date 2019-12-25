package com.baidu.crabsdk.b;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.util.time.DateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes5.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> PU = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float PV = 0.0f;
    private static float PW = 0.0f;
    private static float PY = 0.0f;
    private static float PZ = 0.0f;
    private static String Qa = "";
    private static long Qb = 0;
    private static long Qc = 0;
    private static Rect Qe = null;

    private static List<View> H(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) PV;
                    int i3 = (int) PW;
                    if (Qe == null) {
                        Qe = new Rect();
                    }
                    childAt.getDrawingRect(Qe);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    Qe.left = iArr[0];
                    Qe.top = iArr[1];
                    Qe.right += iArr[0];
                    Qe.bottom = iArr[1] + Qe.bottom;
                    if (Qe.contains(i2, i3)) {
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
        arrayList.add(new SimpleDateFormat(DateTimeUtil.TIME_FORMAT).format(new Date(System.currentTimeMillis())));
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
                arrayList.add("(" + PV + ", " + PW + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + PV + ", " + PW + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + PV + ", " + PW + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + PV + ", " + PW + ") to:(" + PY + ", " + PZ + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + PV + ", " + PW + ") to:(" + PY + ", " + PZ + ")");
                break;
        }
        arrayList.add(Qa);
        PU.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        Qa = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                PV = motionEvent.getX();
                PW = motionEvent.getY();
                Qb = System.currentTimeMillis();
                return;
            case 1:
                PY = motionEvent.getX();
                PZ = motionEvent.getY();
                Qc = System.currentTimeMillis();
                if (Math.abs(PZ - PW) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(PY - PV) > 30.0f && Math.abs(PZ - PW) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (Qc - Qb > 300) {
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
        int size = PU.size();
        for (int i = 0; i < size; i++) {
            List list = PU.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
