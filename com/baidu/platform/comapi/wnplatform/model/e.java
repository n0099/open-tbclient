package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
import com.baidu.f.a.b;
import com.baidu.f.a.d;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f3133a = 0;
    private int b = 0;
    private int c = 1;
    private ArrayList<LatLng> d = new ArrayList<>();
    private com.baidu.f.a.d e = null;

    public String a() {
        StringBuffer stringBuffer = new StringBuffer();
        g.a(this.f3133a, g.b.ZH, stringBuffer);
        return stringBuffer.toString();
    }

    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        g.b(this.b, g.b.ZH, stringBuffer);
        return stringBuffer.toString();
    }

    public void c() {
        this.f3133a = 0;
        this.b = 0;
        if (this.d != null) {
            this.d.clear();
        }
    }

    public void a(Bundle bundle, int i) {
        c();
        if (bundle != null) {
            this.c = i;
            this.f3133a = bundle.getInt("totaldistance");
            this.b = bundle.getInt("totaltime");
            if (this.f3133a <= 0 && this.e != null) {
                this.f3133a = b(this.e, com.baidu.platform.comapi.walknavi.b.a().b());
            }
            if (this.b <= 0 && this.e != null) {
                this.b = a(this.e, com.baidu.platform.comapi.walknavi.b.a().b());
            }
            double[] doubleArray = bundle.getDoubleArray("ptShapeX");
            double[] doubleArray2 = bundle.getDoubleArray("ptShapeY");
            if (doubleArray != null && doubleArray2 != null) {
                LatLng latLng = new LatLng(0.0d, 0.0d);
                for (int i2 = 0; i2 < doubleArray.length; i2++) {
                    LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(doubleArray2[i2], doubleArray[i2]));
                    if (Math.abs(latLng.longitude - gcjToBaidu.longitude) >= 1.0E-6d || Math.abs(latLng.latitude - gcjToBaidu.latitude) >= 1.0E-6d) {
                        this.d.add(gcjToBaidu);
                        latLng = gcjToBaidu;
                    }
                }
            }
        }
    }

    public boolean a(com.baidu.platform.comapi.wnplatform.e.a aVar) {
        com.baidu.platform.comapi.wnplatform.e.c cVar;
        MessageMicro messageMicro;
        if (!(aVar instanceof com.baidu.platform.comapi.wnplatform.e.c)) {
            cVar = null;
        } else {
            cVar = (com.baidu.platform.comapi.wnplatform.e.c) aVar;
        }
        if (cVar != null && (messageMicro = cVar.a().get(0)) != null) {
            try {
                this.e = (com.baidu.f.a.d) messageMicro;
                com.baidu.platform.comapi.walknavi.b.a().a(this.e);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public com.baidu.f.a.d d() {
        return this.e;
    }

    public int e() {
        return this.f3133a;
    }

    public int a(com.baidu.f.a.d dVar, int i) {
        int i2;
        int i3 = 0;
        if (dVar == null) {
            return 0;
        }
        d.b bVar = null;
        if (i < dVar.vR()) {
            bVar = dVar.cc(i);
        }
        if (bVar == null) {
            i2 = 0;
        } else {
            Iterator<d.b.C0121b> it = bVar.vU().iterator();
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                i3 = it.next().getDuration() + i2;
            }
        }
        for (com.baidu.f.a.b bVar2 : dVar.wz()) {
            for (b.C0116b c0116b : bVar2.vQ()) {
                for (b.C0116b.a aVar : c0116b.vU()) {
                    i2 += aVar.getDuration();
                }
            }
        }
        return i2;
    }

    public int b(com.baidu.f.a.d dVar, int i) {
        int i2;
        int i3 = 0;
        if (dVar == null) {
            return 0;
        }
        d.b bVar = null;
        if (i < dVar.vR()) {
            bVar = dVar.cc(i);
        }
        if (bVar != null) {
            Iterator<d.b.C0121b> it = bVar.vU().iterator();
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                i3 = it.next().getDistance() + i2;
            }
        } else {
            i2 = 0;
        }
        for (com.baidu.f.a.b bVar2 : dVar.wz()) {
            for (b.C0116b c0116b : bVar2.vQ()) {
                for (b.C0116b.a aVar : c0116b.vU()) {
                    i2 += aVar.getDistance();
                }
            }
        }
        return i2;
    }
}
