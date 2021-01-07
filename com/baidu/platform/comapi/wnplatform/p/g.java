package com.baidu.platform.comapi.wnplatform.p;

import android.text.TextUtils;
import com.baidu.g.a.d;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f4687a = {"m", "km", "米", "公里"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f4688b = {"m", "h", "分钟", "小时"};
    public static final String[] c = {"m", "h", "d", "分钟", "小时", "天"};

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f4689a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static int f4690b = 2;
    }

    /* loaded from: classes3.dex */
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
                    stringBuffer.append(String.format("%d%s", Integer.valueOf(i3), f4687a[i2 + 1]));
                } else {
                    stringBuffer.append(String.format(str, Double.valueOf(i / 1000.0d), f4687a[i2 + 1]));
                }
            }
        } else if (stringBuffer != null) {
            stringBuffer.append(String.format("%d%s", Integer.valueOf(i), f4687a[0 + i2]));
        }
    }

    public static void b(int i, b bVar, StringBuffer stringBuffer) {
        int a2 = bVar.a();
        if (a2 != 0) {
            a2++;
        }
        if (i >= 3600) {
            if (i % SdkConfigData.DEFAULT_REQUEST_INTERVAL < 0 || i % SdkConfigData.DEFAULT_REQUEST_INTERVAL >= 360) {
            }
            if (stringBuffer != null) {
                stringBuffer.append(String.format("%.0f%s", Double.valueOf(i / 3600.0d), f4688b[a2 + 1]));
            }
        } else if (i < 60) {
            if (stringBuffer != null) {
                stringBuffer.append("少于1分钟");
            }
        } else if (stringBuffer != null) {
            stringBuffer.append(String.format("%d%s", Integer.valueOf(i / 60), f4688b[a2 + 0]));
        }
    }

    public static void a(int i, int i2, StringBuffer stringBuffer) {
        if (stringBuffer != null) {
            if (i < 60) {
                stringBuffer.append("少于1分钟");
                return;
            }
            int i3 = (i / SdkConfigData.DEFAULT_REQUEST_INTERVAL) % 24;
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
        return (Q == null || Q.vI() == 0) ? false : true;
    }

    public static int b() {
        boolean z = false;
        if (a()) {
            com.baidu.g.a.d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
            int a2 = a(Q, com.baidu.platform.comapi.walknavi.b.a().b());
            if (Q != null && Q.uV() && Q.vC().hasStart()) {
                String floor = Q.vC().vN().getFloor();
                String wm = Q.vC().vN().wm();
                if (!TextUtils.isEmpty(floor) && !TextUtils.isEmpty(wm)) {
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
            if (dVar.vI() != 0) {
                return 3;
            }
        } else if (dVar != null && dVar.uZ() > 0 && i < dVar.uZ()) {
            z = false;
            z2 = false;
            for (int i2 = 0; i2 < dVar.ce(i).wq(); i2++) {
                d.b.C0122b.C0123b wZ = dVar.ce(i).cr(i2).wZ();
                if (wZ != null && wZ.xf()) {
                    z2 = true;
                }
                if (wZ != null && wZ.hasNext()) {
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
        if (dVar.ce(i) != null) {
            int wq = dVar.ce(i).wq();
            for (int i2 = 0; i2 < wq; i2++) {
                if (dVar.ce(i).wq() > i2 && dVar.ce(i).cr(i2) != null) {
                    int wM = dVar.ce(i).cr(i2).wM();
                    for (int i3 = 0; i3 < wM; i3++) {
                        if (dVar.ce(i).cr(i2).cv(i3) != null && dVar.ce(i).cr(i2).cv(i3).vf() != null) {
                            arrayList.add(CoordTrans.gcjToBaidu(new LatLng(dVar.ce(i).cr(i2).cv(i3).vf().get(1).doubleValue() / 100000.0d, dVar.ce(i).cr(i2).cv(i3).vf().get(0).doubleValue() / 100000.0d)));
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
        List<d.b.C0122b.a> b2;
        if (dVar == null || (b2 = b(dVar)) == null || b2.size() == 0) {
            return 0;
        }
        return b2.get(0).getType();
    }

    public static List<d.b.C0122b.a> b(com.baidu.g.a.d dVar) {
        int b2 = com.baidu.platform.comapi.walknavi.b.a().b();
        ArrayList arrayList = new ArrayList();
        if (dVar.uZ() > 0 && b2 < dVar.uZ()) {
            for (d.b.C0122b c0122b : dVar.ce(b2).vc()) {
                List<d.b.C0122b.a> wX = c0122b.wX();
                if (wX != null) {
                    for (d.b.C0122b.a aVar : wX) {
                        arrayList.add(aVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean c() {
        com.baidu.g.a.d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
        if (Q == null || Q.vI() == 0) {
            return false;
        }
        List<com.baidu.g.a.b> vH = Q.vH();
        int i = 0;
        for (int i2 = 0; i2 < vH.size(); i2++) {
            com.baidu.g.a.b bVar = vH.get(i2);
            if (bVar.uZ() != 0 && bVar.bO(0).vd() == 1) {
                i++;
            }
        }
        return i == vH.size();
    }

    public static boolean d() {
        com.baidu.g.a.d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
        return (Q == null || Q.uZ() != 0 || Q.vI() == 0) ? false : true;
    }

    public static int a(boolean z) {
        com.baidu.g.a.d d = com.baidu.platform.comapi.walknavi.b.a().U().a().d();
        if (d == null) {
            return 0;
        }
        if (!z) {
            return a(d) == a.f4690b ? 1 : 0;
        } else if (d()) {
            return 3;
        } else {
            return a(d) == a.f4689a ? 2 : 0;
        }
    }
}
