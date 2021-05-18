package com.baidu.crabsdk.b;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.crabsdk.c.b;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static b<List> f4676a = new b<>(com.baidu.crabsdk.a.f4638f);

    /* renamed from: b  reason: collision with root package name */
    public static float f4677b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public static float f4678c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public static float f4679d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public static float f4680e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public static String f4681f = "";

    /* renamed from: g  reason: collision with root package name */
    public static long f4682g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static long f4683h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static Rect f4684i = null;

    public static List<View> a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    int i3 = (int) f4677b;
                    int i4 = (int) f4678c;
                    if (f4684i == null) {
                        f4684i = new Rect();
                    }
                    childAt.getDrawingRect(f4684i);
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    Rect rect = f4684i;
                    rect.left = iArr[0];
                    rect.top = iArr[1];
                    rect.right += iArr[0];
                    rect.bottom += iArr[1];
                    if (rect.contains(i3, i4)) {
                        arrayList.add(childAt);
                        arrayList.addAll(a(childAt));
                    }
                }
            }
        }
        return arrayList;
    }

    public static void b(int i2, Activity activity) {
        StringBuilder sb;
        float f2;
        View decorView;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        StringBuilder sb2 = new StringBuilder();
        if (activity != null && (decorView = activity.getWindow().getDecorView()) != null) {
            String str = "";
            for (View view : a(decorView)) {
                str = view.getClass().getName() + ", id=" + view.getId();
            }
            sb2.append(str);
        }
        arrayList.add(sb2.toString());
        if (i2 == 1) {
            arrayList.add(PrefetchEvent.STATE_CLICK);
            sb = new StringBuilder("(");
        } else if (i2 == 2) {
            arrayList.add("doubleClick");
            sb = new StringBuilder("(");
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    arrayList.add("fling");
                    sb = new StringBuilder("from:(");
                }
                arrayList.add(f4681f);
                f4676a.add(arrayList);
            }
            arrayList.add("scroll");
            sb = new StringBuilder("from:(");
            sb.append(f4677b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(f4678c);
            sb.append(") to:(");
            sb.append(f4679d);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            f2 = f4680e;
            sb.append(f2);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            arrayList.add(sb.toString());
            arrayList.add(f4681f);
            f4676a.add(arrayList);
        } else {
            arrayList.add("longPressed");
            sb = new StringBuilder("(");
        }
        sb.append(f4677b);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        f2 = f4678c;
        sb.append(f2);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        arrayList.add(sb.toString());
        arrayList.add(f4681f);
        f4676a.add(arrayList);
    }

    public static void c(MotionEvent motionEvent, Activity activity) {
        if (activity == null) {
            return;
        }
        f4681f = activity.getClass().getName();
        int action = motionEvent.getAction();
        if (action == 0) {
            f4677b = motionEvent.getX();
            f4678c = motionEvent.getY();
            f4682g = System.currentTimeMillis();
        } else if (action != 1) {
        } else {
            f4679d = motionEvent.getX();
            f4680e = motionEvent.getY();
            f4683h = System.currentTimeMillis();
            if (Math.abs(f4680e - f4678c) > 30.0f) {
                b(4, activity);
            } else if (Math.abs(f4679d - f4677b) > 30.0f && Math.abs(f4680e - f4678c) < 30.0f) {
                b(5, activity);
            } else if (f4683h - f4682g > 300) {
                b(3, activity);
            } else {
                b(1, activity);
            }
        }
    }

    public static String d() {
        StringBuilder sb = new StringBuilder();
        int size = f4676a.size();
        int i2 = 0;
        while (i2 < size) {
            List list = f4676a.get(i2);
            if (list == null || list.size() <= 0) {
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder("STEP");
            i2++;
            sb2.append(i2);
            sb2.append("\nTime: ");
            sb2.append(list.get(0));
            sb2.append("; Activity: ");
            sb2.append(list.get(4));
            sb2.append("; Component: ");
            sb2.append(list.get(1));
            sb2.append("; Operation: ");
            sb2.append(list.get(2));
            sb2.append("; Location: ");
            sb2.append(list.get(3));
            sb2.append("\n");
            sb.append(sb2.toString());
        }
        com.baidu.crabsdk.c.a.c("Behavior Steps --> " + sb.toString());
        return sb.toString();
    }
}
