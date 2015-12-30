package com.baidu.location;

import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a0, n {
    private static u eo = null;
    private static String ee = null;
    private static Method em = null;
    private static Method d8 = null;
    private static Method eh = null;
    private static Method d7 = null;
    private static Method ep = null;
    private static Class ei = null;
    private static long eg = 3000;
    private static int ej = 3;
    private static boolean en = false;
    private TelephonyManager d6 = null;
    private a ec = new a();
    private a d9 = null;
    private List ek = null;
    private b el = null;
    private boolean ea = false;
    private boolean ef = false;
    private int ed = 0;
    private int eb = 0;

    /* loaded from: classes.dex */
    public class a {
        public int a;

        /* renamed from: byte  reason: not valid java name */
        public int f107byte;

        /* renamed from: case  reason: not valid java name */
        public int f108case;

        /* renamed from: char  reason: not valid java name */
        public int f109char;

        /* renamed from: do  reason: not valid java name */
        public int f110do;

        /* renamed from: for  reason: not valid java name */
        public int f111for;

        /* renamed from: if  reason: not valid java name */
        public long f112if;

        /* renamed from: int  reason: not valid java name */
        public int f113int;

        /* renamed from: new  reason: not valid java name */
        public char f114new;

        public a() {
            this.a = -1;
            this.f111for = -1;
            this.f107byte = -1;
            this.f108case = -1;
            this.f109char = Integer.MAX_VALUE;
            this.f110do = Integer.MAX_VALUE;
            this.f112if = 0L;
            this.f113int = -1;
            this.f114new = (char) 0;
            this.f112if = System.currentTimeMillis();
        }

        public a(int i, int i2, int i3, int i4, char c) {
            this.a = -1;
            this.f111for = -1;
            this.f107byte = -1;
            this.f108case = -1;
            this.f109char = Integer.MAX_VALUE;
            this.f110do = Integer.MAX_VALUE;
            this.f112if = 0L;
            this.f113int = -1;
            this.f114new = (char) 0;
            this.a = i;
            this.f111for = i2;
            this.f107byte = i3;
            this.f108case = i4;
            this.f114new = c;
            this.f112if = System.currentTimeMillis();
        }

        public boolean a() {
            return this.a > -1 && this.f111for > 0;
        }

        public boolean a(a aVar) {
            return this.a == aVar.a && this.f111for == aVar.f111for && this.f108case == aVar.f108case;
        }

        /* renamed from: byte  reason: not valid java name */
        public boolean m352byte() {
            return this.a > -1 && this.f111for > -1 && this.f108case == -1 && this.f107byte == -1;
        }

        /* renamed from: case  reason: not valid java name */
        public String m353case() {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.f111for + 23);
            stringBuffer.append("H");
            stringBuffer.append(this.a + 45);
            stringBuffer.append("K");
            stringBuffer.append(this.f108case + 54);
            stringBuffer.append("Q");
            stringBuffer.append(this.f107byte + a0.f35if);
            return stringBuffer.toString();
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m354do() {
            return this.a == -1 && this.f111for == -1 && this.f108case == -1 && this.f107byte == -1;
        }

        /* renamed from: for  reason: not valid java name */
        public String m355for() {
            String str;
            try {
                List<NeighboringCellInfo> neighboringCellInfo = u.this.d6.getNeighboringCellInfo();
                if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
                    return null;
                }
                String str2 = "&nc=";
                int i = 0;
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    if (i != 0) {
                        if (i >= 8) {
                            break;
                        }
                        str = neighboringCellInfo2.getLac() != this.a ? str2 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str2 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                    } else {
                        str = neighboringCellInfo2.getLac() != this.a ? str2 + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str2 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                    }
                    i++;
                    str2 = str;
                }
                return str2;
            } catch (Exception e) {
                return null;
            }
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m356if() {
            return System.currentTimeMillis() - this.f112if < u.eg;
        }

        /* renamed from: int  reason: not valid java name */
        public String m357int() {
            if (a()) {
                if (this.f114new == 'g') {
                    return String.format(Locale.CHINA, "<cell-tower>\n<mcc>%d</mcc><mnc>%d</mnc><lac>%d</lac><ci>%d</ci><rssi>%d</rssi></cell-tower>", Integer.valueOf(this.f107byte), Integer.valueOf(this.f108case), Integer.valueOf(this.a), Integer.valueOf(this.f111for), Integer.valueOf(this.f113int));
                }
                if (this.f114new == 'c') {
                    return String.format(Locale.CHINA, "<cdma-tower>\n<sid>%d</sid><nid>%d</nid><bsid>%d</bsid><rssi>%d</rssi></cdma-tower>", Integer.valueOf(this.f108case), Integer.valueOf(this.a), Integer.valueOf(this.f111for), Integer.valueOf(this.f113int));
                }
                return null;
            }
            return null;
        }

        /* renamed from: new  reason: not valid java name */
        public boolean m358new() {
            return this.a > -1 && this.f111for > -1 && this.f108case > -1 && this.f107byte > -1;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(u.this.ec.f114new);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f107byte), Integer.valueOf(this.f108case), Integer.valueOf(this.a), Integer.valueOf(this.f111for), Integer.valueOf(this.f113int)));
            if (this.f109char < Integer.MAX_VALUE && this.f110do < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(this.f110do / 14400.0d), Double.valueOf(this.f109char / 14400.0d)));
            }
            stringBuffer.append("&cl_t=");
            stringBuffer.append(this.f112if);
            if (u.this.ek != null && u.this.ek.size() > 0) {
                int size = u.this.ek.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    a aVar = (a) u.this.ek.get(i);
                    if (aVar.f107byte != this.f107byte) {
                        stringBuffer.append(aVar.f107byte);
                    }
                    stringBuffer.append("|");
                    if (aVar.f108case != this.f108case) {
                        stringBuffer.append(aVar.f108case);
                    }
                    stringBuffer.append("|");
                    if (aVar.a != this.a) {
                        stringBuffer.append(aVar.a);
                    }
                    stringBuffer.append("|");
                    if (aVar.f111for != this.f111for) {
                        stringBuffer.append(aVar.f111for);
                    }
                    stringBuffer.append("|");
                    if (i != size - 1) {
                        stringBuffer.append(aVar.f112if / 1000);
                    } else {
                        stringBuffer.append((System.currentTimeMillis() - aVar.f112if) / 1000);
                    }
                    stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
            }
            if (u.this.ed > 100) {
                u.this.ed = 0;
            }
            stringBuffer.append("&cs=" + ((u.this.eb << 8) + u.this.ed));
            if (u.this.ef) {
                stringBuffer.append("&cfr=2");
            }
            return stringBuffer.toString();
        }

        /* renamed from: try  reason: not valid java name */
        public String m359try() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(String.format(Locale.CHINA, "cell=%d|%d|%d|%d:%d", Integer.valueOf(this.f107byte), Integer.valueOf(this.f108case), Integer.valueOf(this.a), Integer.valueOf(this.f111for), Integer.valueOf(this.f113int)));
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            try {
                u.this.m346if(u.this.d6.getCellLocation());
            } catch (Exception e) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (u.this.ec != null) {
                if (u.this.ec.f114new == 'g') {
                    u.this.ec.f113int = signalStrength.getGsmSignalStrength();
                } else if (u.this.ec.f114new == 'c') {
                    u.this.ec.f113int = signalStrength.getCdmaDbm();
                }
            }
        }
    }

    private u() {
    }

    private boolean ap() {
        if (ee == null || ee.length() < 10) {
            return false;
        }
        try {
            char[] charArray = ee.toCharArray();
            for (int i = 0; i < 10; i++) {
                if (charArray[i] > '9' || charArray[i] < '0') {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void ar() {
        String m266goto = c.m266goto();
        if (m266goto == null) {
            return;
        }
        File file = new File(m266goto + File.separator + "lcvif.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > TbConfig.USE_TIME_INTERVAL) {
                    randomAccessFile.close();
                    return;
                }
                randomAccessFile.readInt();
                for (int i = 0; i < 3; i++) {
                    long readLong = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    int readInt4 = randomAccessFile.readInt();
                    int readInt5 = randomAccessFile.readInt();
                    char c = readInt5 == 1 ? 'g' : (char) 0;
                    if (readInt5 == 2) {
                        c = 'c';
                    }
                    if (readLong != 0) {
                        a aVar = new a(readInt3, readInt4, readInt, readInt2, c);
                        aVar.f112if = readLong;
                        if (aVar.a()) {
                            this.ef = true;
                            this.ek.add(aVar);
                        }
                    }
                }
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
    }

    public static u au() {
        if (eo == null) {
            eo = new u();
        }
        return eo;
    }

    private void ay() {
        int i = 0;
        if (this.ek == null && this.d9 == null) {
            return;
        }
        if (this.ek == null && this.d9 != null) {
            this.ek = new LinkedList();
            this.ek.add(this.d9);
        }
        String m266goto = c.m266goto();
        if (m266goto != null) {
            File file = new File(m266goto + File.separator + "lcvif.dat");
            int size = this.ek.size();
            try {
                if (!file.exists()) {
                    file.createNewFile();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeLong(((a) this.ek.get(size - 1)).f112if);
                    randomAccessFile.writeInt(size);
                    for (int i2 = 0; i2 < 3 - size; i2++) {
                        randomAccessFile.writeLong(0L);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(2);
                    }
                    while (i < size) {
                        randomAccessFile.writeLong(((a) this.ek.get(i)).f112if);
                        randomAccessFile.writeInt(((a) this.ek.get(i)).f107byte);
                        randomAccessFile.writeInt(((a) this.ek.get(i)).f108case);
                        randomAccessFile.writeInt(((a) this.ek.get(i)).a);
                        randomAccessFile.writeInt(((a) this.ek.get(i)).f111for);
                        if (((a) this.ek.get(i)).f114new == 'g') {
                            randomAccessFile.writeInt(1);
                        } else if (((a) this.ek.get(i)).f114new == 'c') {
                            randomAccessFile.writeInt(2);
                        } else {
                            randomAccessFile.writeInt(3);
                        }
                        i++;
                    }
                    randomAccessFile.close();
                    return;
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                randomAccessFile2.seek(0L);
                if (randomAccessFile2.readLong() >= ((a) this.ek.get(size - 1)).f112if) {
                    randomAccessFile2.close();
                    return;
                }
                randomAccessFile2.seek(0L);
                randomAccessFile2.writeLong(((a) this.ek.get(size - 1)).f112if);
                randomAccessFile2.writeInt(size);
                for (int i3 = 0; i3 < 3 - size; i3++) {
                    randomAccessFile2.writeLong(0L);
                    randomAccessFile2.writeInt(-1);
                    randomAccessFile2.writeInt(-1);
                    randomAccessFile2.writeInt(-1);
                    randomAccessFile2.writeInt(-1);
                    randomAccessFile2.writeInt(2);
                }
                while (i < size) {
                    randomAccessFile2.writeLong(((a) this.ek.get(i)).f112if);
                    randomAccessFile2.writeInt(((a) this.ek.get(i)).f107byte);
                    randomAccessFile2.writeInt(((a) this.ek.get(i)).f108case);
                    randomAccessFile2.writeInt(((a) this.ek.get(i)).a);
                    randomAccessFile2.writeInt(((a) this.ek.get(i)).f111for);
                    if (((a) this.ek.get(i)).f114new == 'g') {
                        randomAccessFile2.writeInt(1);
                    } else if (((a) this.ek.get(i)).f114new == 'c') {
                        randomAccessFile2.writeInt(2);
                    } else {
                        randomAccessFile2.writeInt(3);
                    }
                    i++;
                }
                randomAccessFile2.close();
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m346if(CellLocation cellLocation) {
        int i;
        if (cellLocation == null || this.d6 == null) {
            return;
        }
        if (!en) {
            ee = this.d6.getDeviceId();
            en = ap();
        }
        a aVar = new a();
        aVar.f112if = System.currentTimeMillis();
        try {
            String networkOperator = this.d6.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.ec.f107byte;
                    }
                    aVar.f107byte = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                } else {
                    i = 0;
                }
                int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                if (intValue2 < 0) {
                    intValue2 = this.ec.f108case;
                }
                aVar.f108case = intValue2;
            }
            this.ed = this.d6.getSimState();
        } catch (Exception e) {
            this.eb = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.f111for = ((GsmCellLocation) cellLocation).getCid();
            aVar.f114new = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f114new = 'c';
            if (Integer.parseInt(Build.VERSION.SDK) < 5) {
                return;
            }
            if (ei == null) {
                try {
                    ei = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    em = ei.getMethod("getBaseStationId", new Class[0]);
                    d8 = ei.getMethod("getNetworkId", new Class[0]);
                    eh = ei.getMethod("getSystemId", new Class[0]);
                    d7 = ei.getMethod("getBaseStationLatitude", new Class[0]);
                    ep = ei.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception e2) {
                    ei = null;
                    this.eb = 2;
                    return;
                }
            }
            if (ei != null && ei.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) eh.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.ec.f108case;
                    }
                    aVar.f108case = intValue3;
                    aVar.f111for = ((Integer) em.invoke(cellLocation, new Object[0])).intValue();
                    aVar.a = ((Integer) d8.invoke(cellLocation, new Object[0])).intValue();
                    Object invoke = d7.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        aVar.f109char = ((Integer) invoke).intValue();
                    }
                    Object invoke2 = ep.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke2).intValue() < Integer.MAX_VALUE) {
                        aVar.f110do = ((Integer) invoke2).intValue();
                    }
                } catch (Exception e3) {
                    this.eb = 3;
                    return;
                }
            }
        }
        if (aVar.a()) {
            if (this.ec == null || !this.ec.a(aVar)) {
                this.ec = aVar;
                if (!aVar.a()) {
                    if (this.ek != null) {
                        this.ek.clear();
                        return;
                    }
                    return;
                }
                if (this.ek == null) {
                    this.ek = new LinkedList();
                }
                int size = this.ek.size();
                a aVar2 = size == 0 ? null : (a) this.ek.get(size - 1);
                if (aVar2 != null && aVar2.f111for == this.ec.f111for && aVar2.a == this.ec.a) {
                    return;
                }
                if (aVar2 != null) {
                    aVar2.f112if = this.ec.f112if - aVar2.f112if;
                }
                this.ek.add(this.ec);
                ay();
                this.ef = false;
                if (this.ek.size() > ej) {
                    this.ek.remove(0);
                }
            }
        }
    }

    public int aq() {
        if (this.d6 == null) {
            return 0;
        }
        return this.d6.getNetworkType();
    }

    public synchronized void as() {
        if (this.ea) {
            if (this.el != null && this.d6 != null) {
                this.d6.listen(this.el, 0);
            }
            this.el = null;
            this.d6 = null;
            this.ek.clear();
            this.ek = null;
            ay();
            this.ea = false;
        }
    }

    public a at() {
        if ((this.ec == null || !this.ec.m356if() || !this.ec.a()) && this.d6 != null) {
            try {
                m346if(this.d6.getCellLocation());
            } catch (Exception e) {
            }
        }
        if (this.ec.m358new()) {
            this.d9 = null;
            this.d9 = new a(this.ec.a, this.ec.f111for, this.ec.f107byte, this.ec.f108case, this.ec.f114new);
        }
        if (this.ec.m352byte() && this.d9 != null && System.currentTimeMillis() - this.d9.f112if < TbConfig.USE_TIME_INTERVAL) {
            this.ec.f108case = this.d9.f108case;
            this.ec.f107byte = this.d9.f107byte;
        }
        return this.ec;
    }

    public String aw() {
        return ee;
    }

    public synchronized void ax() {
        if (!this.ea && ad.gO) {
            this.d6 = (TelephonyManager) f.getServiceContext().getSystemService("phone");
            this.ek = new LinkedList();
            this.el = new b();
            ar();
            if (this.d6 != null && this.el != null) {
                try {
                    this.d6.listen(this.el, 272);
                } catch (Exception e) {
                }
                en = ap();
                c.m273if(a0.i, "i:" + ee);
                this.ea = true;
            }
        }
    }

    public int az() {
        String subscriberId = ((TelephonyManager) f.getServiceContext().getSystemService("phone")).getSubscriberId();
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return 1;
            }
            if (subscriberId.startsWith("46001")) {
                return 2;
            }
            if (subscriberId.startsWith("46003")) {
                return 3;
            }
        }
        return 0;
    }
}
