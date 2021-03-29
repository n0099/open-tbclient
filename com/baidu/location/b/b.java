package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f6617a;

    /* renamed from: b  reason: collision with root package name */
    public static int f6618b;

    /* renamed from: c  reason: collision with root package name */
    public static b f6619c;
    public static Class<?> k;

    /* renamed from: d  reason: collision with root package name */
    public TelephonyManager f6620d = null;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.location.b.a f6621e = new com.baidu.location.b.a();

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.location.b.a f6622f = null;

    /* renamed from: g  reason: collision with root package name */
    public List<com.baidu.location.b.a> f6623g = null;

    /* renamed from: h  reason: collision with root package name */
    public a f6624h = null;
    public boolean i = false;
    public boolean j = false;
    public Handler l = new Handler();

    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        public a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            b.this.l.post(new c(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.baidu.location.b.a aVar;
            int cdmaDbm;
            if (b.this.f6621e != null) {
                if (b.this.f6621e.i == 'g') {
                    aVar = b.this.f6621e;
                    cdmaDbm = signalStrength.getGsmSignalStrength();
                } else if (b.this.f6621e.i != 'c') {
                    return;
                } else {
                    aVar = b.this.f6621e;
                    cdmaDbm = signalStrength.getCdmaDbm();
                }
                aVar.f6616h = cdmaDbm;
            }
        }
    }

    private int a(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:5|(1:7)(2:24|(9:26|(4:31|32|33|(2:39|(1:41)))|30|9|10|(3:13|14|(1:16))|19|20|21)(7:45|(1:47)|10|(3:13|14|(0))|19|20|21))|8|9|10|(0)|19|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d1, code lost:
        if (r2 <= 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0170, code lost:
        r1.f6615g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #2 {Exception -> 0x015b, blocks: (B:38:0x0119, B:40:0x011d), top: B:50:0x0119 }] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.b.a a(CellInfo cellInfo) {
        int asuLevel;
        int i;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        boolean z = false;
        if (!(cellInfo instanceof CellInfoGsm)) {
            if (!(cellInfo instanceof CellInfoCdma)) {
                if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                    aVar.f6611c = a(cellIdentity.getMcc());
                    aVar.f6612d = a(cellIdentity.getMnc());
                    aVar.f6609a = a(cellIdentity.getTac());
                    aVar.f6610b = a(cellIdentity.getCi());
                    aVar.i = 'g';
                    asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                }
                if (intValue >= 18) {
                    if (cellInfo instanceof CellInfoWcdma) {
                    }
                }
                aVar.f6615g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            aVar.f6613e = cellIdentity2.getLatitude();
            aVar.f6614f = cellIdentity2.getLongitude();
            aVar.f6612d = a(cellIdentity2.getSystemId());
            aVar.f6609a = a(cellIdentity2.getNetworkId());
            aVar.f6610b = a(cellIdentity2.getBasestationId());
            aVar.i = 'c';
            aVar.f6616h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
            com.baidu.location.b.a aVar2 = this.f6621e;
            if (aVar2 == null || (i = aVar2.f6611c) <= 0) {
                i = -1;
                try {
                    String networkOperator = this.f6620d.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                        int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue2 >= 0) {
                            i = intValue2;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            aVar.f6611c = i;
            z = true;
            if (intValue >= 18 && !z) {
                try {
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                        aVar.f6611c = a(cellIdentity3.getMcc());
                        aVar.f6612d = a(cellIdentity3.getMnc());
                        aVar.f6609a = a(cellIdentity3.getLac());
                        aVar.f6610b = a(cellIdentity3.getCid());
                        aVar.i = 'g';
                        aVar.f6616h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    }
                } catch (Exception unused2) {
                }
            }
            aVar.f6615g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
            return aVar;
        }
        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
        CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
        aVar.f6611c = a(cellIdentity4.getMcc());
        aVar.f6612d = a(cellIdentity4.getMnc());
        aVar.f6609a = a(cellIdentity4.getLac());
        aVar.f6610b = a(cellIdentity4.getCid());
        aVar.i = 'g';
        asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
        aVar.f6616h = asuLevel;
        z = true;
        if (intValue >= 18) {
        }
        aVar.f6615g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
        return aVar;
    }

    private com.baidu.location.b.a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private com.baidu.location.b.a a(CellLocation cellLocation, boolean z) {
        if (cellLocation == null || this.f6620d == null) {
            return null;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        if (z) {
            aVar.f();
        }
        aVar.f6615g = System.currentTimeMillis();
        try {
            String networkOperator = this.f6620d.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                int i = -1;
                if (networkOperator.length() >= 3) {
                    i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.f6611c = i < 0 ? this.f6621e.f6611c : i;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i2 = 0;
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                    i = Integer.valueOf(substring.substring(0, i2)).intValue();
                }
                if (i < 0) {
                    i = this.f6621e.f6612d;
                }
                aVar.f6612d = i;
            }
            f6617a = this.f6620d.getSimState();
        } catch (Exception unused) {
            f6618b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            aVar.f6609a = gsmCellLocation.getLac();
            aVar.f6610b = gsmCellLocation.getCid();
            aVar.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.i = 'c';
            if (k == null) {
                try {
                    k = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    k = null;
                    return aVar;
                }
            }
            Class<?> cls = k;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.f6621e.f6612d;
                    }
                    aVar.f6612d = systemId;
                    aVar.f6610b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.f6609a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.f6613e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f6614f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                    f6618b = 3;
                    return aVar;
                }
            }
        }
        c(aVar);
        return aVar;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f6619c == null) {
                f6619c = new b();
            }
            bVar = f6619c;
        }
        return bVar;
    }

    private void c(com.baidu.location.b.a aVar) {
        if (aVar.b()) {
            com.baidu.location.b.a aVar2 = this.f6621e;
            if (aVar2 == null || !aVar2.a(aVar)) {
                this.f6621e = aVar;
                if (!aVar.b()) {
                    List<com.baidu.location.b.a> list = this.f6623g;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f6623g.size();
                com.baidu.location.b.a aVar3 = size == 0 ? null : this.f6623g.get(size - 1);
                if (aVar3 != null) {
                    int i = aVar3.f6610b;
                    com.baidu.location.b.a aVar4 = this.f6621e;
                    if (i == aVar4.f6610b && aVar3.f6609a == aVar4.f6609a) {
                        return;
                    }
                }
                this.f6623g.add(this.f6621e);
                if (this.f6623g.size() > 3) {
                    this.f6623g.remove(0);
                }
                j();
                this.j = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private String d(com.baidu.location.b.a aVar) {
        com.baidu.location.b.a a2;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.f6620d.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb2.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (a2 = a(cellInfo)) != null && a2.f6609a != -1 && a2.f6610b != -1) {
                            if (aVar.f6609a != a2.f6609a) {
                                sb = new StringBuilder();
                                sb.append(a2.f6609a);
                                sb.append(FieldBuilder.SE);
                                sb.append(a2.f6610b);
                                sb.append(FieldBuilder.SE);
                                sb.append(a2.f6616h);
                                sb.append(";");
                            } else {
                                sb = new StringBuilder();
                                sb.append(FieldBuilder.SE);
                                sb.append(a2.f6610b);
                                sb.append(FieldBuilder.SE);
                                sb.append(a2.f6616h);
                                sb.append(";");
                            }
                            sb2.append(sb.toString());
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return sb2.toString();
    }

    private void i() {
        String g2 = com.baidu.location.d.j.g();
        if (g2 == null) {
            return;
        }
        File file = new File(g2 + File.separator + "lcvif.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                long j = 0;
                randomAccessFile.seek(0L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                int i = 0;
                while (i < 3) {
                    long readLong = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    int readInt4 = randomAccessFile.readInt();
                    int readInt5 = randomAccessFile.readInt();
                    char c2 = readInt5 == 2 ? 'c' : readInt5 == 1 ? 'g' : (char) 0;
                    if (readLong != j) {
                        com.baidu.location.b.a aVar = new com.baidu.location.b.a(readInt3, readInt4, readInt, readInt2, 0, c2);
                        aVar.f6615g = readLong;
                        if (aVar.b()) {
                            this.j = true;
                            this.f6623g.add(aVar);
                        }
                    }
                    i++;
                    j = 0;
                }
                randomAccessFile.close();
            } catch (Exception unused) {
                file.delete();
            }
        }
    }

    private void j() {
        if (this.f6623g == null && this.f6622f == null) {
            return;
        }
        if (this.f6623g == null && this.f6622f != null) {
            LinkedList linkedList = new LinkedList();
            this.f6623g = linkedList;
            linkedList.add(this.f6622f);
        }
        String g2 = com.baidu.location.d.j.g();
        if (g2 == null || this.f6623g == null) {
            return;
        }
        File file = new File(g2 + File.separator + "lcvif.dat");
        int size = this.f6623g.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.f6623g.get(size - 1).f6615g);
            randomAccessFile.writeInt(size);
            for (int i = 0; i < 3 - size; i++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(2);
            }
            for (int i2 = 0; i2 < size; i2++) {
                randomAccessFile.writeLong(this.f6623g.get(i2).f6615g);
                randomAccessFile.writeInt(this.f6623g.get(i2).f6611c);
                randomAccessFile.writeInt(this.f6623g.get(i2).f6612d);
                randomAccessFile.writeInt(this.f6623g.get(i2).f6609a);
                randomAccessFile.writeInt(this.f6623g.get(i2).f6610b);
                if (this.f6623g.get(i2).i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.f6623g.get(i2).i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        CellLocation cellLocation;
        com.baidu.location.b.a l = l();
        if (l != null) {
            c(l);
        }
        if (l == null || !l.b()) {
            try {
                cellLocation = this.f6620d.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                a(cellLocation);
            }
        }
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.b.a l() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            f6617a = this.f6620d.getSimState();
            List<CellInfo> allCellInfo = this.f6620d.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            com.baidu.location.b.a aVar = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar != null;
                    com.baidu.location.b.a a2 = a(cellInfo);
                    if (a2 != null) {
                        if (!a2.b()) {
                            a2 = null;
                        } else if (z && aVar != null) {
                            aVar.j = a2.h();
                            return aVar;
                        }
                        if (aVar == null) {
                            aVar = a2;
                        }
                    }
                }
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a(com.baidu.location.b.a aVar) {
        String d2;
        int intValue;
        String str = "";
        try {
            d2 = d(aVar);
            intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if ((d2 == null || d2.equals("") || d2.equals("&nc=")) && intValue < 17) {
            List<NeighboringCellInfo> neighboringCellInfo = this.f6620d.getNeighboringCellInfo();
            if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
                str = d2;
            } else {
                int i = 0;
                String str2 = "&nc=";
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    int lac = neighboringCellInfo2.getLac();
                    if (lac != -1 && neighboringCellInfo2.getCid() != -1) {
                        str2 = aVar.f6609a != lac ? str2 + lac + FieldBuilder.SE + neighboringCellInfo2.getCid() + FieldBuilder.SE + neighboringCellInfo2.getRssi() + ";" : str2 + FieldBuilder.SE + neighboringCellInfo2.getCid() + FieldBuilder.SE + neighboringCellInfo2.getRssi() + ";";
                    }
                    i++;
                    if (i >= 8) {
                        break;
                    }
                }
                str = str2;
            }
            if (str == null || !str.equals("&nc=")) {
                return str;
            }
            return null;
        }
        return d2;
    }

    public String b(com.baidu.location.b.a aVar) {
        int i;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.f6611c), Integer.valueOf(aVar.f6612d), Integer.valueOf(aVar.f6609a), Integer.valueOf(aVar.f6610b), Integer.valueOf(aVar.f6616h)));
        if (aVar.f6613e < Integer.MAX_VALUE && (i = aVar.f6614f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(i / 14400.0d), Double.valueOf(aVar.f6613e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.f6615g);
        try {
            if (this.f6623g != null && this.f6623g.size() > 0) {
                int size = this.f6623g.size();
                stringBuffer.append("&clt=");
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.location.b.a aVar2 = this.f6623g.get(i2);
                    if (aVar2 != null) {
                        if (aVar2.f6611c != aVar.f6611c) {
                            stringBuffer.append(aVar2.f6611c);
                        }
                        stringBuffer.append(FieldBuilder.SE);
                        if (aVar2.f6612d != aVar.f6612d) {
                            stringBuffer.append(aVar2.f6612d);
                        }
                        stringBuffer.append(FieldBuilder.SE);
                        if (aVar2.f6609a != aVar.f6609a) {
                            stringBuffer.append(aVar2.f6609a);
                        }
                        stringBuffer.append(FieldBuilder.SE);
                        if (aVar2.f6610b != aVar.f6610b) {
                            stringBuffer.append(aVar2.f6610b);
                        }
                        stringBuffer.append(FieldBuilder.SE);
                        stringBuffer.append((System.currentTimeMillis() - aVar2.f6615g) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (f6617a > 100) {
            f6617a = 0;
        }
        int i3 = f6617a + (f6618b << 8);
        stringBuffer.append("&cs=" + i3);
        String str = aVar.j;
        if (str != null) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public synchronized void b() {
        if (this.i) {
            return;
        }
        if (com.baidu.location.f.isServing) {
            this.f6620d = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
            this.f6623g = new LinkedList();
            this.f6624h = new a();
            i();
            if (this.f6620d == null || this.f6624h == null) {
                return;
            }
            try {
                this.f6620d.listen(this.f6624h, AuthorityState.STATE_INIT_ING);
            } catch (Exception unused) {
            }
            this.i = true;
        }
    }

    public synchronized void c() {
        if (this.i) {
            if (this.f6624h != null && this.f6620d != null) {
                this.f6620d.listen(this.f6624h, 0);
            }
            this.f6624h = null;
            this.f6620d = null;
            this.f6623g.clear();
            this.f6623g = null;
            j();
            this.i = false;
        }
    }

    public boolean d() {
        return this.j;
    }

    public int e() {
        TelephonyManager telephonyManager = this.f6620d;
        if (telephonyManager == null) {
            return 0;
        }
        try {
            return telephonyManager.getNetworkType();
        } catch (Exception unused) {
            return 0;
        }
    }

    public com.baidu.location.b.a f() {
        com.baidu.location.b.a aVar;
        com.baidu.location.b.a aVar2 = this.f6621e;
        if ((aVar2 == null || !aVar2.a() || !this.f6621e.b()) && this.f6620d != null) {
            try {
                k();
            } catch (Exception unused) {
            }
        }
        com.baidu.location.b.a aVar3 = this.f6621e;
        if (aVar3 != null && aVar3.e()) {
            this.f6622f = null;
            com.baidu.location.b.a aVar4 = this.f6621e;
            this.f6622f = new com.baidu.location.b.a(aVar4.f6609a, aVar4.f6610b, aVar4.f6611c, aVar4.f6612d, aVar4.f6616h, aVar4.i);
        }
        com.baidu.location.b.a aVar5 = this.f6621e;
        if (aVar5 != null && aVar5.d() && (aVar = this.f6622f) != null) {
            com.baidu.location.b.a aVar6 = this.f6621e;
            if (aVar6.i == 'g') {
                aVar6.f6612d = aVar.f6612d;
                aVar6.f6611c = aVar.f6611c;
            }
        }
        return this.f6621e;
    }

    public String g() {
        int i = -1;
        try {
            if (this.f6620d != null) {
                i = this.f6620d.getSimState();
            }
        } catch (Exception unused) {
        }
        return "&sim=" + i;
    }

    public int h() {
        String str;
        try {
            str = this.f6620d.getSubscriberId();
        } catch (Exception unused) {
            str = null;
        }
        if (str != null) {
            if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46007")) {
                return 1;
            }
            if (str.startsWith("46001")) {
                return 2;
            }
            return str.startsWith("46003") ? 3 : 0;
        }
        return 0;
    }
}
