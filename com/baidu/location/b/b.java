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
    public static int f6880a;

    /* renamed from: b  reason: collision with root package name */
    public static int f6881b;

    /* renamed from: c  reason: collision with root package name */
    public static b f6882c;
    public static Class<?> k;

    /* renamed from: d  reason: collision with root package name */
    public TelephonyManager f6883d = null;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.location.b.a f6884e = new com.baidu.location.b.a();

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.location.b.a f6885f = null;

    /* renamed from: g  reason: collision with root package name */
    public List<com.baidu.location.b.a> f6886g = null;

    /* renamed from: h  reason: collision with root package name */
    public a f6887h = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6888i = false;
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
            if (b.this.f6884e != null) {
                if (b.this.f6884e.f6879i == 'g') {
                    aVar = b.this.f6884e;
                    cdmaDbm = signalStrength.getGsmSignalStrength();
                } else if (b.this.f6884e.f6879i != 'c') {
                    return;
                } else {
                    aVar = b.this.f6884e;
                    cdmaDbm = signalStrength.getCdmaDbm();
                }
                aVar.f6878h = cdmaDbm;
            }
        }
    }

    private int a(int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:5|(1:7)(2:24|(9:26|(4:31|32|33|(2:39|(1:41)))|30|9|10|(3:13|14|(1:16))|19|20|21)(7:45|(1:47)|10|(3:13|14|(0))|19|20|21))|8|9|10|(0)|19|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d1, code lost:
        if (r2 <= 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0170, code lost:
        r1.f6877g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #2 {Exception -> 0x015b, blocks: (B:38:0x0119, B:40:0x011d), top: B:50:0x0119 }] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.b.a a(CellInfo cellInfo) {
        int asuLevel;
        int i2;
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
                    aVar.f6873c = a(cellIdentity.getMcc());
                    aVar.f6874d = a(cellIdentity.getMnc());
                    aVar.f6871a = a(cellIdentity.getTac());
                    aVar.f6872b = a(cellIdentity.getCi());
                    aVar.f6879i = 'g';
                    asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                }
                if (intValue >= 18) {
                    if (cellInfo instanceof CellInfoWcdma) {
                    }
                }
                aVar.f6877g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            aVar.f6875e = cellIdentity2.getLatitude();
            aVar.f6876f = cellIdentity2.getLongitude();
            aVar.f6874d = a(cellIdentity2.getSystemId());
            aVar.f6871a = a(cellIdentity2.getNetworkId());
            aVar.f6872b = a(cellIdentity2.getBasestationId());
            aVar.f6879i = 'c';
            aVar.f6878h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
            com.baidu.location.b.a aVar2 = this.f6884e;
            if (aVar2 == null || (i2 = aVar2.f6873c) <= 0) {
                i2 = -1;
                try {
                    String networkOperator = this.f6883d.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                        int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue2 >= 0) {
                            i2 = intValue2;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            aVar.f6873c = i2;
            z = true;
            if (intValue >= 18 && !z) {
                try {
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                        aVar.f6873c = a(cellIdentity3.getMcc());
                        aVar.f6874d = a(cellIdentity3.getMnc());
                        aVar.f6871a = a(cellIdentity3.getLac());
                        aVar.f6872b = a(cellIdentity3.getCid());
                        aVar.f6879i = 'g';
                        aVar.f6878h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    }
                } catch (Exception unused2) {
                }
            }
            aVar.f6877g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
            return aVar;
        }
        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
        CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
        aVar.f6873c = a(cellIdentity4.getMcc());
        aVar.f6874d = a(cellIdentity4.getMnc());
        aVar.f6871a = a(cellIdentity4.getLac());
        aVar.f6872b = a(cellIdentity4.getCid());
        aVar.f6879i = 'g';
        asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
        aVar.f6878h = asuLevel;
        z = true;
        if (intValue >= 18) {
        }
        aVar.f6877g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
        return aVar;
    }

    private com.baidu.location.b.a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private com.baidu.location.b.a a(CellLocation cellLocation, boolean z) {
        if (cellLocation == null || this.f6883d == null) {
            return null;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        if (z) {
            aVar.f();
        }
        aVar.f6877g = System.currentTimeMillis();
        try {
            String networkOperator = this.f6883d.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                int i2 = -1;
                if (networkOperator.length() >= 3) {
                    i2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.f6873c = i2 < 0 ? this.f6884e.f6873c : i2;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i3 = 0;
                    while (i3 < charArray.length && Character.isDigit(charArray[i3])) {
                        i3++;
                    }
                    i2 = Integer.valueOf(substring.substring(0, i3)).intValue();
                }
                if (i2 < 0) {
                    i2 = this.f6884e.f6874d;
                }
                aVar.f6874d = i2;
            }
            f6880a = this.f6883d.getSimState();
        } catch (Exception unused) {
            f6881b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            aVar.f6871a = gsmCellLocation.getLac();
            aVar.f6872b = gsmCellLocation.getCid();
            aVar.f6879i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f6879i = 'c';
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
                        systemId = this.f6884e.f6874d;
                    }
                    aVar.f6874d = systemId;
                    aVar.f6872b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.f6871a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.f6875e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f6876f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                    f6881b = 3;
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
            if (f6882c == null) {
                f6882c = new b();
            }
            bVar = f6882c;
        }
        return bVar;
    }

    private void c(com.baidu.location.b.a aVar) {
        if (aVar.b()) {
            com.baidu.location.b.a aVar2 = this.f6884e;
            if (aVar2 == null || !aVar2.a(aVar)) {
                this.f6884e = aVar;
                if (!aVar.b()) {
                    List<com.baidu.location.b.a> list = this.f6886g;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f6886g.size();
                com.baidu.location.b.a aVar3 = size == 0 ? null : this.f6886g.get(size - 1);
                if (aVar3 != null) {
                    int i2 = aVar3.f6872b;
                    com.baidu.location.b.a aVar4 = this.f6884e;
                    if (i2 == aVar4.f6872b && aVar3.f6871a == aVar4.f6871a) {
                        return;
                    }
                }
                this.f6886g.add(this.f6884e);
                if (this.f6886g.size() > 3) {
                    this.f6886g.remove(0);
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
                List<CellInfo> allCellInfo = this.f6883d.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb2.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (a2 = a(cellInfo)) != null && a2.f6871a != -1 && a2.f6872b != -1) {
                            if (aVar.f6871a != a2.f6871a) {
                                sb = new StringBuilder();
                                sb.append(a2.f6871a);
                                sb.append(FieldBuilder.SE);
                                sb.append(a2.f6872b);
                                sb.append(FieldBuilder.SE);
                                sb.append(a2.f6878h);
                                sb.append(";");
                            } else {
                                sb = new StringBuilder();
                                sb.append(FieldBuilder.SE);
                                sb.append(a2.f6872b);
                                sb.append(FieldBuilder.SE);
                                sb.append(a2.f6878h);
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
                int i2 = 0;
                while (i2 < 3) {
                    long readLong = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    int readInt4 = randomAccessFile.readInt();
                    int readInt5 = randomAccessFile.readInt();
                    char c2 = readInt5 == 2 ? 'c' : readInt5 == 1 ? 'g' : (char) 0;
                    if (readLong != j) {
                        com.baidu.location.b.a aVar = new com.baidu.location.b.a(readInt3, readInt4, readInt, readInt2, 0, c2);
                        aVar.f6877g = readLong;
                        if (aVar.b()) {
                            this.j = true;
                            this.f6886g.add(aVar);
                        }
                    }
                    i2++;
                    j = 0;
                }
                randomAccessFile.close();
            } catch (Exception unused) {
                file.delete();
            }
        }
    }

    private void j() {
        if (this.f6886g == null && this.f6885f == null) {
            return;
        }
        if (this.f6886g == null && this.f6885f != null) {
            LinkedList linkedList = new LinkedList();
            this.f6886g = linkedList;
            linkedList.add(this.f6885f);
        }
        String g2 = com.baidu.location.d.j.g();
        if (g2 == null || this.f6886g == null) {
            return;
        }
        File file = new File(g2 + File.separator + "lcvif.dat");
        int size = this.f6886g.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.f6886g.get(size - 1).f6877g);
            randomAccessFile.writeInt(size);
            for (int i2 = 0; i2 < 3 - size; i2++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(2);
            }
            for (int i3 = 0; i3 < size; i3++) {
                randomAccessFile.writeLong(this.f6886g.get(i3).f6877g);
                randomAccessFile.writeInt(this.f6886g.get(i3).f6873c);
                randomAccessFile.writeInt(this.f6886g.get(i3).f6874d);
                randomAccessFile.writeInt(this.f6886g.get(i3).f6871a);
                randomAccessFile.writeInt(this.f6886g.get(i3).f6872b);
                if (this.f6886g.get(i3).f6879i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.f6886g.get(i3).f6879i == 'c') {
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
                cellLocation = this.f6883d.getCellLocation();
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
            f6880a = this.f6883d.getSimState();
            List<CellInfo> allCellInfo = this.f6883d.getAllCellInfo();
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
            List<NeighboringCellInfo> neighboringCellInfo = this.f6883d.getNeighboringCellInfo();
            if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
                str = d2;
            } else {
                int i2 = 0;
                String str2 = "&nc=";
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    int lac = neighboringCellInfo2.getLac();
                    if (lac != -1 && neighboringCellInfo2.getCid() != -1) {
                        str2 = aVar.f6871a != lac ? str2 + lac + FieldBuilder.SE + neighboringCellInfo2.getCid() + FieldBuilder.SE + neighboringCellInfo2.getRssi() + ";" : str2 + FieldBuilder.SE + neighboringCellInfo2.getCid() + FieldBuilder.SE + neighboringCellInfo2.getRssi() + ";";
                    }
                    i2++;
                    if (i2 >= 8) {
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
        int i2;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.f6879i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.f6873c), Integer.valueOf(aVar.f6874d), Integer.valueOf(aVar.f6871a), Integer.valueOf(aVar.f6872b), Integer.valueOf(aVar.f6878h)));
        if (aVar.f6875e < Integer.MAX_VALUE && (i2 = aVar.f6876f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(i2 / 14400.0d), Double.valueOf(aVar.f6875e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.f6877g);
        try {
            if (this.f6886g != null && this.f6886g.size() > 0) {
                int size = this.f6886g.size();
                stringBuffer.append("&clt=");
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.location.b.a aVar2 = this.f6886g.get(i3);
                    if (aVar2 != null) {
                        if (aVar2.f6873c != aVar.f6873c) {
                            stringBuffer.append(aVar2.f6873c);
                        }
                        stringBuffer.append(FieldBuilder.SE);
                        if (aVar2.f6874d != aVar.f6874d) {
                            stringBuffer.append(aVar2.f6874d);
                        }
                        stringBuffer.append(FieldBuilder.SE);
                        if (aVar2.f6871a != aVar.f6871a) {
                            stringBuffer.append(aVar2.f6871a);
                        }
                        stringBuffer.append(FieldBuilder.SE);
                        if (aVar2.f6872b != aVar.f6872b) {
                            stringBuffer.append(aVar2.f6872b);
                        }
                        stringBuffer.append(FieldBuilder.SE);
                        stringBuffer.append((System.currentTimeMillis() - aVar2.f6877g) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (f6880a > 100) {
            f6880a = 0;
        }
        int i4 = f6880a + (f6881b << 8);
        stringBuffer.append("&cs=" + i4);
        String str = aVar.j;
        if (str != null) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public synchronized void b() {
        if (this.f6888i) {
            return;
        }
        if (com.baidu.location.f.isServing) {
            this.f6883d = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
            this.f6886g = new LinkedList();
            this.f6887h = new a();
            i();
            if (this.f6883d == null || this.f6887h == null) {
                return;
            }
            try {
                this.f6883d.listen(this.f6887h, AuthorityState.STATE_INIT_ING);
            } catch (Exception unused) {
            }
            this.f6888i = true;
        }
    }

    public synchronized void c() {
        if (this.f6888i) {
            if (this.f6887h != null && this.f6883d != null) {
                this.f6883d.listen(this.f6887h, 0);
            }
            this.f6887h = null;
            this.f6883d = null;
            this.f6886g.clear();
            this.f6886g = null;
            j();
            this.f6888i = false;
        }
    }

    public boolean d() {
        return this.j;
    }

    public int e() {
        TelephonyManager telephonyManager = this.f6883d;
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
        com.baidu.location.b.a aVar2 = this.f6884e;
        if ((aVar2 == null || !aVar2.a() || !this.f6884e.b()) && this.f6883d != null) {
            try {
                k();
            } catch (Exception unused) {
            }
        }
        com.baidu.location.b.a aVar3 = this.f6884e;
        if (aVar3 != null && aVar3.e()) {
            this.f6885f = null;
            com.baidu.location.b.a aVar4 = this.f6884e;
            this.f6885f = new com.baidu.location.b.a(aVar4.f6871a, aVar4.f6872b, aVar4.f6873c, aVar4.f6874d, aVar4.f6878h, aVar4.f6879i);
        }
        com.baidu.location.b.a aVar5 = this.f6884e;
        if (aVar5 != null && aVar5.d() && (aVar = this.f6885f) != null) {
            com.baidu.location.b.a aVar6 = this.f6884e;
            if (aVar6.f6879i == 'g') {
                aVar6.f6874d = aVar.f6874d;
                aVar6.f6873c = aVar.f6873c;
            }
        }
        return this.f6884e;
    }

    public String g() {
        int i2 = -1;
        try {
            if (this.f6883d != null) {
                i2 = this.f6883d.getSimState();
            }
        } catch (Exception unused) {
        }
        return "&sim=" + i2;
    }

    public int h() {
        String str;
        try {
            str = this.f6883d.getSubscriberId();
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
