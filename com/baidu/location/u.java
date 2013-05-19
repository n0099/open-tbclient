package com.baidu.location;

import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import com.baidu.zeus.bouncycastle.DERTags;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    public long e;
    final /* synthetic */ t h;
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public int f = -1;
    public char g = 0;

    public u(t tVar) {
        this.h = tVar;
        this.e = 0L;
        this.e = System.currentTimeMillis();
    }

    public boolean a() {
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.e;
        j = t.o;
        return currentTimeMillis < j;
    }

    public boolean a(u uVar) {
        return this.a == uVar.a && this.b == uVar.b && this.d == uVar.d;
    }

    public boolean b() {
        return this.a > -1 && this.b > 0;
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer((int) DERTags.TAGGED);
        stringBuffer.append(this.b + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.a + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.d + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.c + 203);
        return stringBuffer.toString();
    }

    public String d() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(String.format("cell=%d|%d|%d|%d:%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.f)));
        return stringBuffer.toString();
    }

    public String e() {
        String str;
        TelephonyManager telephonyManager;
        String str2;
        try {
            telephonyManager = this.h.c;
            List<NeighboringCellInfo> neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
            if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
                str = null;
            } else {
                String str3 = "&nc=";
                int i = 0;
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    if (i != 0) {
                        if (i >= 8) {
                            break;
                        }
                        str2 = neighboringCellInfo2.getLac() != this.a ? str3 + ";" + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str3 + ";|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                    } else {
                        str2 = neighboringCellInfo2.getLac() != this.a ? str3 + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str3 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                    }
                    i++;
                    str3 = str2;
                }
                str = str3;
            }
        } catch (Exception e) {
            str = null;
        }
        ap.a("baidu_location_service", "Neighbour:" + str);
        return str;
    }

    public String toString() {
        u uVar;
        List list;
        List list2;
        List list3;
        List list4;
        StringBuffer stringBuffer = new StringBuffer((int) DERTags.TAGGED);
        stringBuffer.append("&nw=");
        uVar = this.h.d;
        stringBuffer.append(uVar.g);
        stringBuffer.append(String.format("&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.f)));
        stringBuffer.append("&cl_t=");
        stringBuffer.append(this.e);
        list = this.h.e;
        if (list != null) {
            list2 = this.h.e;
            if (list2.size() > 0) {
                list3 = this.h.e;
                int size = list3.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    list4 = this.h.e;
                    u uVar2 = (u) list4.get(i);
                    if (uVar2.c != this.c) {
                        stringBuffer.append(uVar2.c);
                    }
                    stringBuffer.append("|");
                    if (uVar2.d != this.d) {
                        stringBuffer.append(uVar2.d);
                    }
                    stringBuffer.append("|");
                    if (uVar2.a != this.a) {
                        stringBuffer.append(uVar2.a);
                    }
                    stringBuffer.append("|");
                    if (uVar2.b != this.b) {
                        stringBuffer.append(uVar2.b);
                    }
                    stringBuffer.append("|");
                    if (i != size - 1) {
                        stringBuffer.append(uVar2.e / 1000);
                    } else {
                        stringBuffer.append((System.currentTimeMillis() - uVar2.e) / 1000);
                    }
                    stringBuffer.append(";");
                }
            }
        }
        return stringBuffer.toString();
    }
}
