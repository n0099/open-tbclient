package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.location.e.l;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
@SuppressLint({"NewApi"})
/* loaded from: classes20.dex */
public class b {
    private a l;
    private static b c = null;
    public static int a = 0;
    public static int b = 0;
    private static Class<?> k = null;
    private TelephonyManager d = null;
    private com.baidu.location.c.a e = new com.baidu.location.c.a();
    private com.baidu.location.c.a f = null;
    private List<com.baidu.location.c.a> g = null;
    private C0207b h = null;
    private boolean i = false;
    private boolean j = false;
    private long m = 0;
    private Handler n = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends TelephonyManager.CellInfoCallback {
        private a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            b.this.n.post(new c(this));
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onError(int i, Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C0207b extends PhoneStateListener {
        public C0207b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            b.this.n.post(new d(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (b.this.e != null) {
                if (b.this.e.i == 'g') {
                    b.this.e.h = signalStrength.getGsmSignalStrength();
                } else if (b.this.e.i == 'c') {
                    b.this.e.h = signalStrength.getCdmaDbm();
                }
            }
        }
    }

    private b() {
    }

    private int a(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.c.a a(CellInfo cellInfo) {
        CellIdentityNr cellIdentityNr;
        boolean z = false;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity.getMcc());
            aVar.d = a(cellIdentity.getMnc());
            aVar.a = a(cellIdentity.getLac());
            aVar.b = a(cellIdentity.getCid());
            aVar.i = 'g';
            aVar.h = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            aVar.k = 2;
            if (Build.VERSION.SDK_INT >= 28) {
                aVar.j = cellInfo.getCellConnectionStatus();
            }
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            aVar.e = cellIdentity2.getLatitude();
            aVar.f = cellIdentity2.getLongitude();
            aVar.d = a(cellIdentity2.getSystemId());
            aVar.a = a(cellIdentity2.getNetworkId());
            aVar.b = a(cellIdentity2.getBasestationId());
            aVar.i = 'c';
            aVar.h = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            aVar.k = 1;
            if (Build.VERSION.SDK_INT >= 28) {
                aVar.j = cellInfo.getCellConnectionStatus();
            }
            if (this.e == null || this.e.c <= 0) {
                int i = -1;
                try {
                    String networkOperator = this.d.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                        i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (i < 0) {
                            i = -1;
                        }
                    }
                } catch (Exception e) {
                }
                if (i > 0) {
                    aVar.c = i;
                }
            } else {
                aVar.c = this.e.c;
            }
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity3.getMcc());
            aVar.d = a(cellIdentity3.getMnc());
            aVar.a = a(cellIdentity3.getTac());
            aVar.b = a(cellIdentity3.getCi());
            aVar.i = 'g';
            aVar.h = ((CellInfoLte) cellInfo).getCellSignalStrength().getAsuLevel();
            aVar.k = 3;
            if (Build.VERSION.SDK_INT >= 28) {
                aVar.j = cellInfo.getCellConnectionStatus();
            }
            z = true;
        }
        if (intValue >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    aVar.c = a(cellIdentity4.getMcc());
                    aVar.d = a(cellIdentity4.getMnc());
                    aVar.a = a(cellIdentity4.getLac());
                    aVar.b = a(cellIdentity4.getCid());
                    aVar.i = 'g';
                    aVar.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    aVar.k = 4;
                    if (Build.VERSION.SDK_INT >= 28) {
                        aVar.j = cellInfo.getCellConnectionStatus();
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    if (cellInfo instanceof CellInfoTdscdma) {
                        CellIdentityTdscdma cellIdentity5 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                        if (cellIdentity5.getMccString() != null) {
                            try {
                                aVar.c = Integer.valueOf(cellIdentity5.getMccString()).intValue();
                            } catch (Throwable th) {
                            }
                        }
                        if (cellIdentity5.getMncString() != null) {
                            try {
                                aVar.d = Integer.valueOf(cellIdentity5.getMncString()).intValue();
                            } catch (Throwable th2) {
                            }
                        }
                        aVar.a = a(cellIdentity5.getLac());
                        aVar.b = a(cellIdentity5.getCid());
                        aVar.i = 'g';
                        aVar.h = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getAsuLevel();
                        aVar.k = 5;
                        if (Build.VERSION.SDK_INT >= 28) {
                            aVar.j = cellInfo.getCellConnectionStatus();
                        }
                    } else if ((cellInfo instanceof CellInfoNr) && (cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity()) != null) {
                        if (cellIdentityNr.getMccString() != null) {
                            try {
                                aVar.c = Integer.valueOf(cellIdentityNr.getMccString()).intValue();
                            } catch (Throwable th3) {
                            }
                        }
                        if (cellIdentityNr.getMncString() != null) {
                            try {
                                aVar.d = Integer.valueOf(cellIdentityNr.getMncString()).intValue();
                            } catch (Throwable th4) {
                            }
                        }
                        aVar.a = a(cellIdentityNr.getTac());
                        if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                            aVar.b = cellIdentityNr.getNci();
                        }
                        aVar.i = 'g';
                        aVar.k = 6;
                        if (Build.VERSION.SDK_INT >= 28) {
                            aVar.j = cellInfo.getCellConnectionStatus();
                        }
                        CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                        aVar.h = cellSignalStrengthNr.getAsuLevel();
                        if (aVar.b()) {
                            aVar.m = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
        try {
            aVar.g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / TimeUtils.NANOS_PER_MS);
        } catch (Error e3) {
            aVar.g = System.currentTimeMillis();
        }
        return aVar;
    }

    private com.baidu.location.c.a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private com.baidu.location.c.a a(CellLocation cellLocation, boolean z) {
        if (cellLocation == null || this.d == null) {
            return null;
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        if (z) {
            aVar.f();
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.d.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                int i = -1;
                if (networkOperator.length() >= 3) {
                    i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.c = i < 0 ? this.e.c : i;
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
                    i = this.e.d;
                }
                aVar.d = i;
            }
            a = this.d.getSimState();
        } catch (Exception e) {
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = ((GsmCellLocation) cellLocation).getCid();
            aVar.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.i = 'c';
            if (k == null) {
                try {
                    k = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception e2) {
                    k = null;
                    return aVar;
                }
            }
            if (k != null && k.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.e.d;
                    }
                    aVar.d = systemId;
                    aVar.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f = baseStationLongitude;
                    }
                } catch (Exception e3) {
                    b = 3;
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
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    private void c(com.baidu.location.c.a aVar) {
        if (aVar.b()) {
            if (this.e == null || !this.e.a(aVar)) {
                this.e = aVar;
                if (!aVar.b()) {
                    if (this.g != null) {
                        this.g.clear();
                        return;
                    }
                    return;
                }
                int size = this.g.size();
                com.baidu.location.c.a aVar2 = size == 0 ? null : this.g.get(size - 1);
                if (aVar2 != null && aVar2.b == this.e.b && aVar2.a == this.e.a) {
                    return;
                }
                this.g.add(this.e);
                if (this.g.size() > 3) {
                    this.g.remove(0);
                }
                j();
                this.j = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private String d(com.baidu.location.c.a aVar) {
        com.baidu.location.c.a a2;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = null;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.d.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb2.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (a2 = a(cellInfo)) != null) {
                            if (a2.a != -1 && a2.b != -1) {
                                if (aVar == null || aVar.a != a2.a) {
                                    sb2.append(a2.a + "|" + a2.b + "|" + a2.h + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                } else {
                                    sb2.append("|" + a2.b + "|" + a2.h + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                }
                            }
                            if (Build.VERSION.SDK_INT <= 28 || a2.k != 6 || a2.m == null || !a2.b()) {
                                sb = sb3;
                            } else {
                                if (sb3 == null) {
                                    sb = new StringBuilder();
                                    try {
                                        sb.append("&ncnr=");
                                    } catch (Throwable th) {
                                        sb3 = sb;
                                    }
                                } else {
                                    sb = sb3;
                                }
                                sb.append(a2.g());
                                sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                                sb.append(a2.m);
                                sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                            }
                            sb3 = sb;
                        }
                    }
                }
            } catch (Throwable th2) {
            }
        }
        return sb3 != null ? sb2.toString() + sb3.toString() : sb2.toString();
    }

    private void i() {
        String i = l.i();
        if (i == null) {
            return;
        }
        File file = new File(i + File.separator + "lcvif2.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                for (int i2 = 0; i2 < 3; i2++) {
                    long readLong = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    long readLong2 = randomAccessFile.readLong();
                    int readInt4 = randomAccessFile.readInt();
                    char c2 = readInt4 == 1 ? 'g' : (char) 0;
                    if (readInt4 == 2) {
                        c2 = 'c';
                    }
                    if (readLong != 0) {
                        com.baidu.location.c.a aVar = new com.baidu.location.c.a(readInt3, readLong2, readInt, readInt2, 0, c2, -1);
                        aVar.g = readLong;
                        if (aVar.b()) {
                            this.j = true;
                            this.g.add(aVar);
                        }
                    }
                }
                randomAccessFile.close();
            } catch (Exception e) {
                file.delete();
            }
        }
    }

    private void j() {
        if (this.g == null && this.f == null) {
            return;
        }
        if (this.g == null && this.f != null) {
            this.g = new LinkedList();
            this.g.add(this.f);
        }
        String i = l.i();
        if (i == null || this.g == null) {
            return;
        }
        File file = new File(i + File.separator + "lcvif2.dat");
        int size = this.g.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.g.get(size - 1).g);
            randomAccessFile.writeInt(size);
            for (int i2 = 0; i2 < 3 - size; i2++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeLong(-1L);
                randomAccessFile.writeInt(2);
            }
            for (int i3 = 0; i3 < size; i3++) {
                randomAccessFile.writeLong(this.g.get(i3).g);
                randomAccessFile.writeInt(this.g.get(i3).c);
                randomAccessFile.writeInt(this.g.get(i3).d);
                randomAccessFile.writeInt(this.g.get(i3).a);
                randomAccessFile.writeLong(this.g.get(i3).b);
                if (this.g.get(i3).i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.g.get(i3).i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        CellLocation cellLocation;
        com.baidu.location.c.a l = l();
        if (l != null) {
            c(l);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (l == null || !l.b()) {
                try {
                    cellLocation = this.d.getCellLocation();
                } catch (Throwable th) {
                    cellLocation = null;
                }
                if (cellLocation != null) {
                    a(cellLocation);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r1 == null) goto L26;
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.c.a l() {
        com.baidu.location.c.a aVar;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            a = this.d.getSimState();
            List<CellInfo> allCellInfo = this.d.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            com.baidu.location.c.a aVar2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar2 != null;
                    aVar = a(cellInfo);
                    if (aVar == null) {
                        continue;
                    } else if (!aVar.b()) {
                        aVar = null;
                    } else if (z && aVar2 != null) {
                        aVar2.l = aVar.i();
                        return aVar2;
                    }
                }
                aVar = aVar2;
                aVar2 = aVar;
            }
            return aVar2;
        } catch (Throwable th) {
            return null;
        }
    }

    public String a(com.baidu.location.c.a aVar) {
        String str;
        try {
            str = d(aVar);
            int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if (str != null && !str.equals("")) {
                if (!str.equals("&nc=")) {
                    return str;
                }
            }
            if (intValue >= 17) {
                return str;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        if (str == null || !str.equals("&nc=")) {
            return str;
        }
        return null;
    }

    public String b(com.baidu.location.c.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h)));
        if (aVar.e < Integer.MAX_VALUE && aVar.f < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(aVar.f / 14400.0d), Double.valueOf(aVar.e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        stringBuffer.append("&clp=");
        stringBuffer.append(aVar.k);
        if (aVar.m != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(aVar.m);
        }
        if (Build.VERSION.SDK_INT >= 28 && aVar.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(aVar.j);
        }
        try {
            if (this.g != null && this.g.size() > 0) {
                int size = this.g.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    com.baidu.location.c.a aVar2 = this.g.get(i);
                    if (aVar2 != null) {
                        if (aVar2.c != aVar.c) {
                            stringBuffer.append(aVar2.c);
                        }
                        stringBuffer.append("|");
                        if (aVar2.d != aVar.d) {
                            stringBuffer.append(aVar2.d);
                        }
                        stringBuffer.append("|");
                        if (aVar2.a != aVar.a) {
                            stringBuffer.append(aVar2.a);
                        }
                        stringBuffer.append("|");
                        if (aVar2.b != aVar.b) {
                            stringBuffer.append(aVar2.b);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - aVar2.g) / 1000);
                        stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                }
            }
        } catch (Exception e) {
        }
        if (a > 100) {
            a = 0;
        }
        stringBuffer.append("&cs=" + ((b << 8) + a));
        if (aVar.l != null) {
            stringBuffer.append(aVar.l);
        }
        return stringBuffer.toString();
    }

    public synchronized void b() {
        if (!this.i && com.baidu.location.f.isServing) {
            this.d = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
            this.g = new LinkedList();
            this.h = new C0207b();
            i();
            if (this.d != null && this.h != null) {
                if (Build.VERSION.SDK_INT < 29) {
                    try {
                        this.d.listen(this.h, PlatformPlugin.DEFAULT_SYSTEM_UI);
                    } catch (Exception e) {
                    }
                }
                this.i = true;
            }
        }
    }

    public synchronized void c() {
        if (this.i) {
            if (this.h != null && this.d != null) {
                this.d.listen(this.h, 0);
            }
            this.h = null;
            this.d = null;
            this.g.clear();
            this.g = null;
            j();
            this.i = false;
        }
    }

    public boolean d() {
        return this.j;
    }

    public int e() {
        if (this.d == null) {
            return 0;
        }
        try {
            return this.d.getNetworkType();
        } catch (Exception e) {
            return 0;
        }
    }

    public com.baidu.location.c.a f() {
        if ((this.e == null || !this.e.a() || !this.e.b()) && this.d != null) {
            try {
                k();
                if (Build.VERSION.SDK_INT >= 29 && System.currentTimeMillis() - this.m > 30000) {
                    this.m = System.currentTimeMillis();
                    if (this.l == null) {
                        this.l = new a();
                    }
                    this.d.requestCellInfoUpdate(com.baidu.location.f.getServiceContext().getMainExecutor(), this.l);
                }
            } catch (Exception e) {
            }
        }
        if (this.e != null && this.e.e()) {
            this.f = null;
            this.f = new com.baidu.location.c.a(this.e);
        }
        if (this.e != null && this.e.d() && this.f != null && this.e.i == 'g') {
            this.e.d = this.f.d;
            this.e.c = this.f.c;
        }
        return this.e;
    }

    public String g() {
        int i = -1;
        try {
            if (this.d != null) {
                i = this.d.getSimState();
            }
        } catch (Exception e) {
        }
        return "&sim=" + i;
    }

    public int h() {
        return 0;
    }
}
