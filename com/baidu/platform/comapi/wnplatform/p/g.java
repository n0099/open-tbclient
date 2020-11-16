package com.baidu.platform.comapi.wnplatform.p;

import android.text.TextUtils;
import com.baidu.g.a.d;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f3145a = {"m", "km", "米", "公里"};
    public static final String[] b = {"m", "h", "分钟", "小时"};
    public static final String[] c = {"m", "h", "d", "分钟", "小时", "天"};

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f3146a = 1;
        public static int b = 2;
    }

    /* loaded from: classes7.dex */
    public enum b {
        EN(0),
        ZH(1);
        
        private int c;

        b(int i) {
            this.c = i;
        }

        public int a() {
            return this.c;
        }
    }

    public static void a(int i, b bVar, StringBuffer stringBuffer) {
        String str;
        int a2 = bVar.a();
        int i2 = a2 != 0 ? a2 + 1 : a2;
        if (i >= 1000) {
            if (i % 1000 == 0) {
                str = "%.0f%s";
            } else {
                str = "%.1f%s";
            }
            if (stringBuffer != null) {
                int i3 = i / 1000;
                if (i3 >= 100) {
                    stringBuffer.append(String.format("%d%s", Integer.valueOf(i3), f3145a[i2 + 1]));
                } else {
                    stringBuffer.append(String.format(str, Double.valueOf(i / 1000.0d), f3145a[i2 + 1]));
                }
            }
        } else if (stringBuffer != null) {
            stringBuffer.append(String.format("%d%s", Integer.valueOf(i), f3145a[0 + i2]));
        }
    }

    public static void b(int i, b bVar, StringBuffer stringBuffer) {
        int a2 = bVar.a();
        if (a2 != 0) {
            a2++;
        }
        if (i >= 3600) {
            if (i % 3600 < 0 || i % 3600 >= 360) {
            }
            if (stringBuffer != null) {
                stringBuffer.append(String.format("%.0f%s", Double.valueOf(i / 3600.0d), b[a2 + 1]));
            }
        } else if (i < 60) {
            if (stringBuffer != null) {
                stringBuffer.append("少于1分钟");
            }
        } else if (stringBuffer != null) {
            stringBuffer.append(String.format("%d%s", Integer.valueOf(i / 60), b[a2 + 0]));
        }
    }

    public static void a(int i, int i2, StringBuffer stringBuffer) {
        if (stringBuffer != null) {
            if (i < 60) {
                stringBuffer.append("少于1分钟");
                return;
            }
            int i3 = (i / 3600) % 24;
            int i4 = (i / 60) % 60;
            if (i < 3600) {
                stringBuffer.append(i4).append(c[i2 + 1]);
            } else if (i < 86400) {
                stringBuffer.append(i3).append(c[i2 + 2]);
                if (i4 > 0) {
                    stringBuffer.append(i4).append("分");
                }
            } else {
                stringBuffer.append(i / 86400).append(c[i2 + 3]);
                if (i3 > 0) {
                    stringBuffer.append(i3).append(c[i2 + 2]);
                }
            }
        }
    }

    public static String a(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        a(i, i2, stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean a() {
        com.baidu.g.a.d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
        return (Q == null || Q.wz() == 0) ? false : true;
    }

    public static int b() {
        boolean z = false;
        if (a()) {
            com.baidu.g.a.d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
            int a2 = a(Q, com.baidu.platform.comapi.walknavi.b.a().b());
            if (Q != null && Q.vM() && Q.wt().hasStart()) {
                String floor = Q.wt().wE().getFloor();
                String xd = Q.wt().wE().xd();
                if (!TextUtils.isEmpty(floor) && !TextUtils.isEmpty(xd)) {
                    z = true;
                }
            }
            return (z && (a2 == 2 || a2 == 3)) ? 1 : 2;
        }
        return 0;
    }

    public static int a(com.baidu.g.a.d dVar, int i) {
        boolean z;
        boolean z2;
        if (d()) {
            if (dVar.wz() != 0) {
                return 3;
            }
        } else if (dVar != null && dVar.vQ() > 0 && i < dVar.vQ()) {
            z = false;
            z2 = false;
            for (int i2 = 0; i2 < dVar.ca(i).xh(); i2++) {
                d.b.C0129b.C0130b xQ = dVar.ca(i).cn(i2).xQ();
                if (xQ != null && xQ.xW()) {
                    z2 = true;
                }
                if (xQ != null && xQ.hasNext()) {
                    z = true;
                }
            }
            if (z2 || z) {
                return (z2 && z) ? 1 : 0;
            }
            return 2;
        }
        z = false;
        z2 = false;
        if (z2) {
        }
        if (z2) {
        }
    }

    public static ArrayList<LatLng> b(com.baidu.g.a.d dVar, int i) {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        LatLng O = com.baidu.platform.comapi.walknavi.b.a().O();
        if (O != null) {
            arrayList.add(O);
        }
        if (dVar.ca(i) != null) {
            int xh = dVar.ca(i).xh();
            for (int i2 = 0; i2 < xh; i2++) {
                if (dVar.ca(i).xh() > i2 && dVar.ca(i).cn(i2) != null) {
                    int xD = dVar.ca(i).cn(i2).xD();
                    for (int i3 = 0; i3 < xD; i3++) {
                        if (dVar.ca(i).cn(i2).cr(i3) != null && dVar.ca(i).cn(i2).cr(i3).vW() != null) {
                            arrayList.add(CoordTrans.gcjToBaidu(new LatLng(dVar.ca(i).cn(i2).cr(i3).vW().get(1).doubleValue() / 100000.0d, dVar.ca(i).cn(i2).cr(i3).vW().get(0).doubleValue() / 100000.0d)));
                        }
                    }
                }
            }
        }
        LatLng P = com.baidu.platform.comapi.walknavi.b.a().P();
        if (P != null) {
            arrayList.add(P);
        }
        return arrayList;
    }

    public static int a(com.baidu.g.a.d dVar) {
        List<d.b.C0129b.a> b2;
        if (dVar == null || (b2 = b(dVar)) == null || b2.size() == 0) {
            return 0;
        }
        return b2.get(0).getType();
    }

    public static List<d.b.C0129b.a> b(com.baidu.g.a.d dVar) {
        int b2 = com.baidu.platform.comapi.walknavi.b.a().b();
        ArrayList arrayList = new ArrayList();
        if (dVar.vQ() > 0 && b2 < dVar.vQ()) {
            for (d.b.C0129b c0129b : dVar.ca(b2).vT()) {
                List<d.b.C0129b.a> xO = c0129b.xO();
                if (xO != null) {
                    for (d.b.C0129b.a aVar : xO) {
                        arrayList.add(aVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean c() {
        com.baidu.g.a.d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
        if (Q == null || Q.wz() == 0) {
            return false;
        }
        List<com.baidu.g.a.b> wy = Q.wy();
        int i = 0;
        for (int i2 = 0; i2 < wy.size(); i2++) {
            com.baidu.g.a.b bVar = wy.get(i2);
            if (bVar.vQ() != 0 && bVar.bK(0).vU() == 1) {
                i++;
            }
        }
        return i == wy.size();
    }

    public static boolean d() {
        com.baidu.g.a.d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
        return (Q == null || Q.vQ() != 0 || Q.wz() == 0) ? false : true;
    }

    public static int a(boolean z) {
        com.baidu.g.a.d d = com.baidu.platform.comapi.walknavi.b.a().U().a().d();
        if (d == null) {
            return 0;
        }
        if (!z) {
            return a(d) == a.b ? 1 : 0;
        } else if (d()) {
            return 3;
        } else {
            return a(d) == a.f3146a ? 2 : 0;
        }
    }
}
