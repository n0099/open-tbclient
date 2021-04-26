package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import com.baidu.mapapi.model.inner.Point;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    public static double a(Point point, Point point2) {
        Bundle bundle = new Bundle();
        bundle.putDouble("x1", point.x);
        bundle.putDouble("y1", point.y);
        bundle.putDouble("x2", point2.x);
        bundle.putDouble("y2", point2.y);
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
                aVar.f7410b = new Point((int) bundle3.getDouble("ptx"), (int) bundle3.getDouble("pty"));
            }
            Bundle bundle4 = bundle2.getBundle("ru");
            if (bundle4 != null) {
                aVar.f7411c = new Point((int) bundle4.getDouble("ptx"), (int) bundle4.getDouble("pty"));
            }
        }
        for (ParcelItem parcelItem : (ParcelItem[]) bundle.getParcelableArray("poly_line")) {
            if (aVar.f7412d == null) {
                aVar.f7412d = new ArrayList<>();
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
                aVar.f7412d.add(arrayList);
            }
        }
        aVar.f7412d.trimToSize();
        aVar.f7409a = (int) bundle.getDouble("type");
        return aVar;
    }

    public static String a() {
        return JNITools.GetToken();
    }

    public static void a(boolean z, int i2) {
        JNITools.openLogEnable(z, i2);
    }

    public static void b() {
        JNITools.initClass(new Bundle(), 0);
    }
}
