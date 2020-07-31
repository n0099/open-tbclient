package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.mapapi.model.inner.Point;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    public static double a(Point point, Point point2) {
        Bundle bundle = new Bundle();
        bundle.putDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1, point.x);
        bundle.putDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1, point.y);
        bundle.putDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X2, point2.x);
        bundle.putDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y2, point2.y);
        JNITools.GetDistanceByMC(bundle);
        return bundle.getDouble("distance");
    }

    public static com.baidu.mapapi.model.inner.a a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransGeoStr2ComplexPt(bundle);
        com.baidu.mapapi.model.inner.a aVar = new com.baidu.mapapi.model.inner.a();
        Bundle bundle2 = bundle.getBundle("map_bound");
        if (bundle2 != null) {
            Bundle bundle3 = bundle2.getBundle("ll");
            if (bundle3 != null) {
                aVar.b = new Point((int) bundle3.getDouble("ptx"), (int) bundle3.getDouble("pty"));
            }
            Bundle bundle4 = bundle2.getBundle("ru");
            if (bundle4 != null) {
                aVar.c = new Point((int) bundle4.getDouble("ptx"), (int) bundle4.getDouble("pty"));
            }
        }
        for (ParcelItem parcelItem : (ParcelItem[]) bundle.getParcelableArray("poly_line")) {
            if (aVar.d == null) {
                aVar.d = new ArrayList<>();
            }
            Bundle bundle5 = parcelItem.getBundle();
            if (bundle5 != null) {
                ParcelItem[] parcelItemArr = (ParcelItem[]) bundle5.getParcelableArray("point_array");
                ArrayList<Point> arrayList = new ArrayList<>();
                for (ParcelItem parcelItem2 : parcelItemArr) {
                    Bundle bundle6 = parcelItem2.getBundle();
                    if (bundle6 != null) {
                        arrayList.add(new Point((int) bundle6.getDouble("ptx"), (int) bundle6.getDouble("pty")));
                    }
                }
                arrayList.trimToSize();
                aVar.d.add(arrayList);
            }
        }
        aVar.d.trimToSize();
        aVar.a = (int) bundle.getDouble("type");
        return aVar;
    }

    public static String a() {
        return JNITools.GetToken();
    }

    public static void a(boolean z, int i) {
        JNITools.openLogEnable(z, i);
    }

    public static void b() {
        JNITools.initClass(new Bundle(), 0);
    }
}
