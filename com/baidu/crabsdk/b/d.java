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
/* loaded from: classes8.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> RD = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float RE = 0.0f;
    private static float RF = 0.0f;
    private static float RG = 0.0f;
    private static float RH = 0.0f;
    private static String RI = "";
    private static long RJ = 0;
    private static long RK = 0;
    private static Rect RL = null;

    private static List<View> H(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) RE;
                    int i3 = (int) RF;
                    if (RL == null) {
                        RL = new Rect();
                    }
                    childAt.getDrawingRect(RL);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    RL.left = iArr[0];
                    RL.top = iArr[1];
                    RL.right += iArr[0];
                    RL.bottom = iArr[1] + RL.bottom;
                    if (RL.contains(i2, i3)) {
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
                arrayList.add("(" + RE + ", " + RF + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + RE + ", " + RF + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + RE + ", " + RF + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + RE + ", " + RF + ") to:(" + RG + ", " + RH + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + RE + ", " + RF + ") to:(" + RG + ", " + RH + ")");
                break;
        }
        arrayList.add(RI);
        RD.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        RI = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                RE = motionEvent.getX();
                RF = motionEvent.getY();
                RJ = System.currentTimeMillis();
                return;
            case 1:
                RG = motionEvent.getX();
                RH = motionEvent.getY();
                RK = System.currentTimeMillis();
                if (Math.abs(RH - RF) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(RG - RE) > 30.0f && Math.abs(RH - RF) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (RK - RJ > 300) {
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
        int size = RD.size();
        for (int i = 0; i < size; i++) {
            List list = RD.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
