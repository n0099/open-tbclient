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
    private static com.baidu.crabsdk.c.b<List> SB = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float SC = 0.0f;
    private static float SD = 0.0f;
    private static float SE = 0.0f;
    private static float SF = 0.0f;
    private static String SG = "";
    private static long SH = 0;
    private static long SJ = 0;
    private static Rect SK = null;

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
                arrayList.add("(" + SC + ", " + SD + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + SC + ", " + SD + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + SC + ", " + SD + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + SC + ", " + SD + ") to:(" + SE + ", " + SF + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + SC + ", " + SD + ") to:(" + SE + ", " + SF + ")");
                break;
        }
        arrayList.add(SG);
        SB.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        SG = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                SC = motionEvent.getX();
                SD = motionEvent.getY();
                SH = System.currentTimeMillis();
                return;
            case 1:
                SE = motionEvent.getX();
                SF = motionEvent.getY();
                SJ = System.currentTimeMillis();
                if (Math.abs(SF - SD) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(SE - SC) > 30.0f && Math.abs(SF - SD) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (SJ - SH > 300) {
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
                    int i2 = (int) SC;
                    int i3 = (int) SD;
                    if (SK == null) {
                        SK = new Rect();
                    }
                    childAt.getDrawingRect(SK);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    SK.left = iArr[0];
                    SK.top = iArr[1];
                    SK.right += iArr[0];
                    SK.bottom = iArr[1] + SK.bottom;
                    if (SK.contains(i2, i3)) {
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
        int size = SB.size();
        for (int i = 0; i < size; i++) {
            List list = SB.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.cg("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
