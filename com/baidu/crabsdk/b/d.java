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
    private static com.baidu.crabsdk.c.b<List> anh = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float ani = 0.0f;
    private static float anj = 0.0f;
    private static float ank = 0.0f;
    private static float anl = 0.0f;
    private static String bc = "";
    private static long anm = 0;
    private static long ann = 0;
    private static Rect ano = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) ani;
                    int i3 = (int) anj;
                    if (ano == null) {
                        ano = new Rect();
                    }
                    childAt.getDrawingRect(ano);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    ano.left = iArr[0];
                    ano.top = iArr[1];
                    ano.right += iArr[0];
                    ano.bottom = iArr[1] + ano.bottom;
                    if (ano.contains(i2, i3)) {
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
                arrayList.add("(" + ani + ", " + anj + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + ani + ", " + anj + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + ani + ", " + anj + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + ani + ", " + anj + ") to:(" + ank + ", " + anl + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + ani + ", " + anj + ") to:(" + ank + ", " + anl + ")");
                break;
        }
        arrayList.add(bc);
        anh.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                ani = motionEvent.getX();
                anj = motionEvent.getY();
                anm = System.currentTimeMillis();
                return;
            case 1:
                ank = motionEvent.getX();
                anl = motionEvent.getY();
                ann = System.currentTimeMillis();
                if (Math.abs(anl - anj) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(ank - ani) > 30.0f && Math.abs(anl - anj) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (ann - anm > 300) {
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
        int size = anh.size();
        for (int i = 0; i < size; i++) {
            List list = anh.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
