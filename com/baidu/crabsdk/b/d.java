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
/* loaded from: classes2.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> SC = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float SD = 0.0f;
    private static float SE = 0.0f;
    private static float SF = 0.0f;
    private static float SG = 0.0f;
    private static String SH = "";
    private static long SJ = 0;
    private static long SK = 0;
    private static Rect SL = null;

    private static void a(int i, Activity activity) {
        View decorView;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        StringBuilder sb = new StringBuilder();
        if (activity != null && (decorView = activity.getWindow().getDecorView()) != null) {
            List<View> t = t(decorView);
            String str = "";
            for (View view : t) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb.append(str);
        }
        arrayList.add(sb.toString());
        switch (i) {
            case 1:
                arrayList.add("click");
                arrayList.add("(" + SD + ", " + SE + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + SD + ", " + SE + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + SD + ", " + SE + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + SD + ", " + SE + ") to:(" + SF + ", " + SG + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + SD + ", " + SE + ") to:(" + SF + ", " + SG + ")");
                break;
        }
        arrayList.add(SH);
        SC.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        SH = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                SD = motionEvent.getX();
                SE = motionEvent.getY();
                SJ = System.currentTimeMillis();
                return;
            case 1:
                SF = motionEvent.getX();
                SG = motionEvent.getY();
                SK = System.currentTimeMillis();
                if (Math.abs(SG - SE) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(SF - SD) > 30.0f && Math.abs(SG - SE) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (SK - SJ > 300) {
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

    private static List<View> t(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) SD;
                    int i3 = (int) SE;
                    if (SL == null) {
                        SL = new Rect();
                    }
                    childAt.getDrawingRect(SL);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    SL.left = iArr[0];
                    SL.top = iArr[1];
                    SL.right += iArr[0];
                    SL.bottom = iArr[1] + SL.bottom;
                    if (SL.contains(i2, i3)) {
                        arrayList.add(childAt);
                        arrayList.addAll(t(childAt));
                    }
                }
            }
        }
        return arrayList;
    }

    public static String u() {
        StringBuilder sb = new StringBuilder();
        int size = SC.size();
        for (int i = 0; i < size; i++) {
            List list = SC.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.cd("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
