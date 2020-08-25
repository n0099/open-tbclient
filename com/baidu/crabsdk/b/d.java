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
/* loaded from: classes6.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> anf = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float ang = 0.0f;
    private static float anh = 0.0f;
    private static float ani = 0.0f;
    private static float anj = 0.0f;
    private static String bc = "";
    private static long ank = 0;
    private static long anl = 0;
    private static Rect anm = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) ang;
                    int i3 = (int) anh;
                    if (anm == null) {
                        anm = new Rect();
                    }
                    childAt.getDrawingRect(anm);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    anm.left = iArr[0];
                    anm.top = iArr[1];
                    anm.right += iArr[0];
                    anm.bottom = iArr[1] + anm.bottom;
                    if (anm.contains(i2, i3)) {
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
                arrayList.add("(" + ang + ", " + anh + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + ang + ", " + anh + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + ang + ", " + anh + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + ang + ", " + anh + ") to:(" + ani + ", " + anj + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + ang + ", " + anh + ") to:(" + ani + ", " + anj + ")");
                break;
        }
        arrayList.add(bc);
        anf.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                ang = motionEvent.getX();
                anh = motionEvent.getY();
                ank = System.currentTimeMillis();
                return;
            case 1:
                ani = motionEvent.getX();
                anj = motionEvent.getY();
                anl = System.currentTimeMillis();
                if (Math.abs(anj - anh) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(ani - ang) > 30.0f && Math.abs(anj - anh) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (anl - ank > 300) {
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
        int size = anf.size();
        for (int i = 0; i < size; i++) {
            List list = anf.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
