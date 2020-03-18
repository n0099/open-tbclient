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
    private static com.baidu.crabsdk.c.b<List> RF = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float RG = 0.0f;
    private static float RH = 0.0f;
    private static float RI = 0.0f;
    private static float RJ = 0.0f;
    private static String RK = "";
    private static long RL = 0;
    private static long RO = 0;
    private static Rect RP = null;

    private static List<View> H(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) RG;
                    int i3 = (int) RH;
                    if (RP == null) {
                        RP = new Rect();
                    }
                    childAt.getDrawingRect(RP);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    RP.left = iArr[0];
                    RP.top = iArr[1];
                    RP.right += iArr[0];
                    RP.bottom = iArr[1] + RP.bottom;
                    if (RP.contains(i2, i3)) {
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
                arrayList.add("(" + RG + ", " + RH + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + RG + ", " + RH + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + RG + ", " + RH + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + RG + ", " + RH + ") to:(" + RI + ", " + RJ + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + RG + ", " + RH + ") to:(" + RI + ", " + RJ + ")");
                break;
        }
        arrayList.add(RK);
        RF.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        RK = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                RG = motionEvent.getX();
                RH = motionEvent.getY();
                RL = System.currentTimeMillis();
                return;
            case 1:
                RI = motionEvent.getX();
                RJ = motionEvent.getY();
                RO = System.currentTimeMillis();
                if (Math.abs(RJ - RH) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(RI - RG) > 30.0f && Math.abs(RJ - RH) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (RO - RL > 300) {
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
        int size = RF.size();
        for (int i = 0; i < size; i++) {
            List list = RF.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
