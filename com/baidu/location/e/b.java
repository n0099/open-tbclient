package com.baidu.location.e;

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
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.location.g.g;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class b {
    private static b afz = null;
    public static int a = 0;
    public static int b = 0;
    private static Class<?> afD = null;
    private TelephonyManager afA = null;
    private com.baidu.location.e.a afB = new com.baidu.location.e.a();
    private com.baidu.location.e.a acR = null;
    private List<com.baidu.location.e.a> g = null;
    private a afC = null;
    private boolean i = false;
    private boolean j = false;
    private Handler l = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends PhoneStateListener {
        public a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            b.this.l.post(new Runnable() { // from class: com.baidu.location.e.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.k();
                    } catch (Exception e) {
                    }
                    com.baidu.location.b.b.ty().e();
                }
            });
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (b.this.afB != null) {
                if (b.this.afB.afy == 'g') {
                    b.this.afB.h = signalStrength.getGsmSignalStrength();
                } else if (b.this.afB.afy == 'c') {
                    b.this.afB.h = signalStrength.getCdmaDbm();
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

    private com.baidu.location.e.a a(CellLocation cellLocation, boolean z) {
        if (cellLocation == null || this.afA == null) {
            return null;
        }
        com.baidu.location.e.a aVar = new com.baidu.location.e.a();
        if (z) {
            aVar.f();
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.afA.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                int i = -1;
                if (networkOperator.length() >= 3) {
                    i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.c = i < 0 ? this.afB.c : i;
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
                    i = this.afB.d;
                }
                aVar.d = i;
            }
            a = this.afA.getSimState();
        } catch (Exception e) {
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = ((GsmCellLocation) cellLocation).getCid();
            aVar.afy = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.afy = 'c';
            if (afD == null) {
                try {
                    afD = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception e2) {
                    afD = null;
                    return aVar;
                }
            }
            if (afD != null && afD.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.afB.d;
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
        d(aVar);
        return aVar;
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.e.a b(CellInfo cellInfo) {
        boolean z = false;
        int i = -1;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.e.a aVar = new com.baidu.location.e.a();
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity.getMcc());
            aVar.d = a(cellIdentity.getMnc());
            aVar.a = a(cellIdentity.getLac());
            aVar.b = a(cellIdentity.getCid());
            aVar.afy = 'g';
            aVar.h = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            aVar.e = cellIdentity2.getLatitude();
            aVar.f = cellIdentity2.getLongitude();
            aVar.d = a(cellIdentity2.getSystemId());
            aVar.a = a(cellIdentity2.getNetworkId());
            aVar.b = a(cellIdentity2.getBasestationId());
            aVar.afy = 'c';
            aVar.h = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            if (this.afB == null || this.afB.c <= 0) {
                try {
                    String networkOperator = this.afA.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                        int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue2 < 0) {
                            intValue2 = -1;
                        }
                        i = intValue2;
                    }
                } catch (Exception e) {
                }
                if (i > 0) {
                    aVar.c = i;
                }
            } else {
                aVar.c = this.afB.c;
            }
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity3.getMcc());
            aVar.d = a(cellIdentity3.getMnc());
            aVar.a = a(cellIdentity3.getTac());
            aVar.b = a(cellIdentity3.getCi());
            aVar.afy = 'g';
            aVar.h = ((CellInfoLte) cellInfo).getCellSignalStrength().getAsuLevel();
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
                    aVar.afy = 'g';
                    aVar.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                }
            } catch (Exception e2) {
            }
        }
        try {
            aVar.g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
        } catch (Error e3) {
            aVar.g = System.currentTimeMillis();
        }
        return aVar;
    }

    private com.baidu.location.e.a b(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private void d(com.baidu.location.e.a aVar) {
        if (aVar.b()) {
            if (this.afB == null || !this.afB.a(aVar)) {
                this.afB = aVar;
                if (!aVar.b()) {
                    if (this.g != null) {
                        this.g.clear();
                        return;
                    }
                    return;
                }
                int size = this.g.size();
                com.baidu.location.e.a aVar2 = size == 0 ? null : this.g.get(size - 1);
                if (aVar2 != null && aVar2.b == this.afB.b && aVar2.a == this.afB.a) {
                    return;
                }
                this.g.add(this.afB);
                if (this.g.size() > 3) {
                    this.g.remove(0);
                }
                j();
                this.j = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private String e(com.baidu.location.e.a aVar) {
        com.baidu.location.e.a b2;
        StringBuilder sb = new StringBuilder();
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.afA.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (b2 = b(cellInfo)) != null && b2.a != -1 && b2.b != -1) {
                            if (aVar.a != b2.a) {
                                sb.append(b2.a + "|" + b2.b + "|" + b2.h + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                            } else {
                                sb.append("|" + b2.b + "|" + b2.h + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        return sb.toString();
    }

    private void i() {
        String g = g.g();
        if (g == null) {
            return;
        }
        File file = new File(g + File.separator + "lcvif.dat");
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
                        com.baidu.location.e.a aVar = new com.baidu.location.e.a(readInt3, readInt4, readInt, readInt2, 0, c);
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
        if (this.g == null && this.acR == null) {
            return;
        }
        if (this.g == null && this.acR != null) {
            this.g = new LinkedList();
            this.g.add(this.acR);
        }
        String g = g.g();
        if (g == null || this.g == null) {
            return;
        }
        File file = new File(g + File.separator + "lcvif.dat");
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
            for (int i = 0; i < 3 - size; i++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(2);
            }
            for (int i2 = 0; i2 < size; i2++) {
                randomAccessFile.writeLong(this.g.get(i2).g);
                randomAccessFile.writeInt(this.g.get(i2).c);
                randomAccessFile.writeInt(this.g.get(i2).d);
                randomAccessFile.writeInt(this.g.get(i2).a);
                randomAccessFile.writeInt(this.g.get(i2).b);
                if (this.g.get(i2).afy == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.g.get(i2).afy == 'c') {
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
        com.baidu.location.e.a tR = tR();
        if (tR != null) {
            d(tR);
        }
        if (tR == null || !tR.b()) {
            try {
                cellLocation = this.afA.getCellLocation();
            } catch (Throwable th) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                b(cellLocation);
            }
        }
    }

    public static synchronized b tP() {
        b bVar;
        synchronized (b.class) {
            if (afz == null) {
                afz = new b();
            }
            bVar = afz;
        }
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r1 == null) goto L26;
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.e.a tR() {
        com.baidu.location.e.a aVar;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            a = this.afA.getSimState();
            List<CellInfo> allCellInfo = this.afA.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            com.baidu.location.e.a aVar2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar2 != null;
                    aVar = b(cellInfo);
                    if (aVar == null) {
                        continue;
                    } else if (!aVar.b()) {
                        aVar = null;
                    } else if (z && aVar2 != null) {
                        aVar2.j = aVar.i();
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

    public synchronized void b() {
        if (!this.i && com.baidu.location.f.isServing) {
            this.afA = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.g = new LinkedList();
            this.afC = new a();
            i();
            if (this.afA != null && this.afC != null) {
                try {
                    this.afA.listen(this.afC, AuthorityState.STATE_INIT_ING);
                } catch (Exception e) {
                }
                this.i = true;
            }
        }
    }

    public synchronized void c() {
        if (this.i) {
            if (this.afC != null && this.afA != null) {
                this.afA.listen(this.afC, 0);
            }
            this.afC = null;
            this.afA = null;
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
        if (this.afA == null) {
            return 0;
        }
        try {
            return this.afA.getNetworkType();
        } catch (Exception e) {
            return 0;
        }
    }

    public String f(com.baidu.location.e.a aVar) {
        String str;
        int intValue;
        try {
            str = e(aVar);
            intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        if ((str == null || str.equals("") || str.equals("&nc=")) && intValue < 17) {
            List neighboringCellInfo = this.afA.getNeighboringCellInfo();
            if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                String str2 = "&nc=";
                Iterator it = neighboringCellInfo.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        str = str2;
                        break;
                    }
                    NeighboringCellInfo neighboringCellInfo2 = (NeighboringCellInfo) it.next();
                    int lac = neighboringCellInfo2.getLac();
                    str = (lac == -1 || neighboringCellInfo2.getCid() == -1) ? str2 : aVar.a != lac ? str2 + lac + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : str2 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
                    int i2 = i + 1;
                    if (i2 >= 8) {
                        break;
                    }
                    i = i2;
                    str2 = str;
                }
            }
            if (str == null || !str.equals("&nc=")) {
                return str;
            }
            return null;
        }
        return str;
    }

    public String g() {
        int i = -1;
        try {
            if (this.afA != null) {
                i = this.afA.getSimState();
            }
        } catch (Exception e) {
        }
        return "&sim=" + i;
    }

    public String g(com.baidu.location.e.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.afy);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.a), Integer.valueOf(aVar.b), Integer.valueOf(aVar.h)));
        if (aVar.e < Integer.MAX_VALUE && aVar.f < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(aVar.f / 14400.0d), Double.valueOf(aVar.e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        try {
            if (this.g != null && this.g.size() > 0) {
                int size = this.g.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    com.baidu.location.e.a aVar2 = this.g.get(i);
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
        if (aVar.j != null) {
            stringBuffer.append(aVar.j);
        }
        return stringBuffer.toString();
    }

    public int h() {
        String str;
        try {
            str = this.afA.getSubscriberId();
        } catch (Exception e) {
            str = null;
        }
        if (str != null) {
            if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46007")) {
                return 1;
            }
            if (str.startsWith("46001")) {
                return 2;
            }
            if (str.startsWith("46003")) {
                return 3;
            }
        }
        return 0;
    }

    public com.baidu.location.e.a tQ() {
        if ((this.afB == null || !this.afB.a() || !this.afB.b()) && this.afA != null) {
            try {
                k();
            } catch (Exception e) {
            }
        }
        if (this.afB != null && this.afB.e()) {
            this.acR = null;
            this.acR = new com.baidu.location.e.a(this.afB.a, this.afB.b, this.afB.c, this.afB.d, this.afB.h, this.afB.afy);
        }
        if (this.afB != null && this.afB.d() && this.acR != null && this.afB.afy == 'g') {
            this.afB.d = this.acR.d;
            this.afB.c = this.acR.c;
        }
        return this.afB;
    }
}
