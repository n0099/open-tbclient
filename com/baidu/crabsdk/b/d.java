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
/* loaded from: classes12.dex */
public final class d {
    private static com.baidu.crabsdk.c.b<List> amd = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.f);
    private static float ame = 0.0f;
    private static float amf = 0.0f;
    private static float amg = 0.0f;
    private static float amh = 0.0f;
    private static String bc = "";
    private static long ami = 0;
    private static long amj = 0;
    private static Rect amk = null;

    private static List<View> I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    int i2 = (int) ame;
                    int i3 = (int) amf;
                    if (amk == null) {
                        amk = new Rect();
                    }
                    childAt.getDrawingRect(amk);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    amk.left = iArr[0];
                    amk.top = iArr[1];
                    amk.right += iArr[0];
                    amk.bottom = iArr[1] + amk.bottom;
                    if (amk.contains(i2, i3)) {
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
                arrayList.add("(" + ame + ", " + amf + ")");
                break;
            case 2:
                arrayList.add("doubleClick");
                arrayList.add("(" + ame + ", " + amf + ")");
                break;
            case 3:
                arrayList.add("longPressed");
                arrayList.add("(" + ame + ", " + amf + ")");
                break;
            case 4:
                arrayList.add("scroll");
                arrayList.add("from:(" + ame + ", " + amf + ") to:(" + amg + ", " + amh + ")");
                break;
            case 5:
                arrayList.add("fling");
                arrayList.add("from:(" + ame + ", " + amf + ") to:(" + amg + ", " + amh + ")");
                break;
        }
        arrayList.add(bc);
        amd.add(arrayList);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        bc = activity.getClass().getName();
        switch (motionEvent.getAction()) {
            case 0:
                ame = motionEvent.getX();
                amf = motionEvent.getY();
                ami = System.currentTimeMillis();
                return;
            case 1:
                amg = motionEvent.getX();
                amh = motionEvent.getY();
                amj = System.currentTimeMillis();
                if (Math.abs(amh - amf) > 30.0f) {
                    a(4, activity);
                    return;
                } else if (Math.abs(amg - ame) > 30.0f && Math.abs(amh - amf) < 30.0f) {
                    a(5, activity);
                    return;
                } else if (amj - ami > 300) {
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
        int size = amd.size();
        for (int i = 0; i < size; i++) {
            List list = amd.get(i);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            sb.append("STEP" + (i + 1) + "\nTime: " + list.get(0) + "; Activity: " + list.get(4) + "; Component: " + list.get(1) + "; Operation: " + list.get(2) + "; Location: " + list.get(3) + "\n");
        }
        com.baidu.crabsdk.c.a.v("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
