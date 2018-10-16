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
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.location.d.g;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class b {
    private static b aet = null;
    private static Method k = null;
    private static Method l = null;
    private static Method m = null;
    private static Method n = null;
    private static Method o = null;
    private static Class<?> aex = null;
    public static int a = 0;
    public static int b = 0;
    private TelephonyManager aeu = null;
    private Object e = null;
    private com.baidu.location.b.a acX = new com.baidu.location.b.a();
    private com.baidu.location.b.a aev = null;
    private List<com.baidu.location.b.a> h = null;
    private a aew = null;
    private boolean j = false;
    private boolean q = false;
    private Handler aey = new Handler();

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
            b.this.aey.post(new Runnable() { // from class: com.baidu.location.b.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.k();
                    } catch (Exception e) {
                    }
                }
            });
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (b.this.acX != null) {
                if (b.this.acX.aes == 'g') {
                    b.this.acX.h = signalStrength.getGsmSignalStrength();
                } else if (b.this.acX.aes == 'c') {
                    b.this.acX.h = signalStrength.getCdmaDbm();
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

    private com.baidu.location.b.a a(CellLocation cellLocation, boolean z) {
        int i = 0;
        if (cellLocation == null || this.aeu == null) {
            return null;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        if (z) {
            aVar.f();
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.aeu.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.acX.c;
                    }
                    aVar.c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                }
                int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                if (intValue2 < 0) {
                    intValue2 = this.acX.d;
                }
                aVar.d = intValue2;
            }
            a = this.aeu.getSimState();
        } catch (Exception e) {
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = ((GsmCellLocation) cellLocation).getCid();
            aVar.aes = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.aes = 'c';
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 5) {
                return aVar;
            }
            if (aex == null) {
                try {
                    aex = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    k = aex.getMethod("getBaseStationId", new Class[0]);
                    l = aex.getMethod("getNetworkId", new Class[0]);
                    m = aex.getMethod("getSystemId", new Class[0]);
                    n = aex.getMethod("getBaseStationLatitude", new Class[0]);
                    o = aex.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception e2) {
                    aex = null;
                    b = 2;
                    return aVar;
                }
            }
            if (aex != null && aex.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) m.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.acX.d;
                    }
                    aVar.d = intValue3;
                    aVar.b = ((Integer) k.invoke(cellLocation, new Object[0])).intValue();
                    aVar.a = ((Integer) l.invoke(cellLocation, new Object[0])).intValue();
                    Object invoke = n.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        aVar.e = ((Integer) invoke).intValue();
                    }
                    Object invoke2 = o.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke2).intValue() < Integer.MAX_VALUE) {
                        aVar.f = ((Integer) invoke2).intValue();
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

    @SuppressLint({"NewApi"})
    private com.baidu.location.b.a b(CellInfo cellInfo) {
        boolean z = false;
        int i = -1;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity.getMcc());
            aVar.d = a(cellIdentity.getMnc());
            aVar.a = a(cellIdentity.getLac());
            aVar.b = a(cellIdentity.getCid());
            aVar.aes = 'g';
            aVar.h = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            aVar.e = cellIdentity2.getLatitude();
            aVar.f = cellIdentity2.getLongitude();
            aVar.d = a(cellIdentity2.getSystemId());
            aVar.a = a(cellIdentity2.getNetworkId());
            aVar.b = a(cellIdentity2.getBasestationId());
            aVar.aes = 'c';
            aVar.h = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            if (this.acX == null || this.acX.c <= 0) {
                try {
                    String networkOperator = this.aeu.getNetworkOperator();
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
                aVar.c = this.acX.c;
            }
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity3.getMcc());
            aVar.d = a(cellIdentity3.getMnc());
            aVar.a = a(cellIdentity3.getTac());
            aVar.b = a(cellIdentity3.getCi());
            aVar.aes = 'g';
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
                    aVar.aes = 'g';
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

    private com.baidu.location.b.a b(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private void c(com.baidu.location.b.a aVar) {
        if (aVar.b()) {
            if (this.acX == null || !this.acX.a(aVar)) {
                this.acX = aVar;
                if (!aVar.b()) {
                    if (this.h != null) {
                        this.h.clear();
                        return;
                    }
                    return;
                }
                int size = this.h.size();
                com.baidu.location.b.a aVar2 = size == 0 ? null : this.h.get(size - 1);
                if (aVar2 != null && aVar2.b == this.acX.b && aVar2.a == this.acX.a) {
                    return;
                }
                this.h.add(this.acX);
                if (this.h.size() > 3) {
                    this.h.remove(0);
                }
                j();
                this.q = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private String d(com.baidu.location.b.a aVar) {
        com.baidu.location.b.a b2;
        StringBuilder sb = new StringBuilder();
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.aeu.getAllCellInfo();
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
                        com.baidu.location.b.a aVar = new com.baidu.location.b.a(readInt3, readInt4, readInt, readInt2, 0, c);
                        aVar.g = readLong;
                        if (aVar.b()) {
                            this.q = true;
                            this.h.add(aVar);
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
        if (this.h == null && this.aev == null) {
            return;
        }
        if (this.h == null && this.aev != null) {
            this.h = new LinkedList();
            this.h.add(this.aev);
        }
        String g = g.g();
        if (g != null) {
            File file = new File(g + File.separator + "lcvif.dat");
            int size = this.h.size();
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeLong(this.h.get(size - 1).g);
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
                    randomAccessFile.writeLong(this.h.get(i2).g);
                    randomAccessFile.writeInt(this.h.get(i2).c);
                    randomAccessFile.writeInt(this.h.get(i2).d);
                    randomAccessFile.writeInt(this.h.get(i2).a);
                    randomAccessFile.writeInt(this.h.get(i2).b);
                    if (this.h.get(i2).aes == 'g') {
                        randomAccessFile.writeInt(1);
                    } else if (this.h.get(i2).aes == 'c') {
                        randomAccessFile.writeInt(2);
                    } else {
                        randomAccessFile.writeInt(3);
                    }
                }
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        CellLocation cellLocation;
        CellLocation tC;
        com.baidu.location.b.a tE = tE();
        if (tE != null) {
            c(tE);
        }
        if (tE == null || !tE.b()) {
            try {
                cellLocation = this.aeu.getCellLocation();
            } catch (Throwable th) {
                cellLocation = null;
            }
            com.baidu.location.b.a b2 = cellLocation != null ? b(cellLocation) : null;
            if ((b2 == null || !b2.b()) && (tC = tC()) != null) {
                a(tC, true);
            }
        }
    }

    private int o() {
        int i = 0;
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            i = 1;
        } catch (Exception e) {
        }
        if (i == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                return 2;
            } catch (Exception e2) {
                return i;
            }
        }
        return i;
    }

    public static synchronized b tA() {
        b bVar;
        synchronized (b.class) {
            if (aet == null) {
                aet = new b();
            }
            bVar = aet;
        }
        return bVar;
    }

    private CellLocation tC() {
        CellLocation cellLocation;
        Object obj;
        List<?> list;
        Object obj2 = this.e;
        if (obj2 == null) {
            return null;
        }
        try {
            Class<?> tD = tD();
            if (tD.isInstance(obj2)) {
                Object cast = tD.cast(obj2);
                try {
                    obj = g.a(cast, "getCellLocation", new Object[0]);
                } catch (NoSuchMethodException e) {
                    obj = null;
                } catch (Exception e2) {
                    obj = null;
                }
                if (obj == null) {
                    try {
                        obj = g.a(cast, "getCellLocation", 1);
                    } catch (NoSuchMethodException e3) {
                    } catch (Exception e4) {
                    }
                }
                if (obj == null) {
                    try {
                        obj = g.a(cast, "getCellLocationGemini", 1);
                    } catch (NoSuchMethodException e5) {
                    } catch (Exception e6) {
                    }
                }
                if (obj == null) {
                    try {
                        list = (List) g.a(cast, "getAllCellInfo", new Object[0]);
                    } catch (NoSuchMethodException e7) {
                        list = null;
                    } catch (Exception e8) {
                        list = null;
                    }
                    obj = x(list);
                    if (obj != null) {
                    }
                }
            } else {
                obj = null;
            }
            cellLocation = obj != null ? (CellLocation) obj : null;
        } catch (Exception e9) {
            cellLocation = null;
        }
        return cellLocation;
    }

    private Class<?> tD() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (o()) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = null;
                break;
        }
        try {
            return systemClassLoader.loadClass(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r1 == null) goto L26;
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.b.a tE() {
        com.baidu.location.b.a aVar;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            a = this.aeu.getSimState();
            List<CellInfo> allCellInfo = this.aeu.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            com.baidu.location.b.a aVar2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar2 != null;
                    aVar = b(cellInfo);
                    if (aVar == null) {
                        continue;
                    } else if (!aVar.b()) {
                        aVar = null;
                    } else if (z) {
                        aVar2.j = aVar.h();
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

    private CellLocation x(List<?> list) {
        char c;
        CdmaCellLocation cdmaCellLocation;
        GsmCellLocation gsmCellLocation;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        GsmCellLocation gsmCellLocation2 = null;
        int i = 0;
        char c2 = 0;
        CdmaCellLocation cdmaCellLocation2 = null;
        while (true) {
            if (i >= list.size()) {
                c = c2;
                cdmaCellLocation = cdmaCellLocation2;
                gsmCellLocation = gsmCellLocation2;
                break;
            }
            Object obj = list.get(i);
            if (obj != null) {
                try {
                    Class<?> loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class<?> loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class<?> loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class<?> loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    c = loadClass.isInstance(obj) ? (char) 1 : loadClass2.isInstance(obj) ? (char) 2 : loadClass3.isInstance(obj) ? (char) 3 : loadClass4.isInstance(obj) ? (char) 4 : (char) 0;
                    if (c > 0) {
                        Object obj2 = null;
                        if (c == 1) {
                            try {
                                obj2 = loadClass.cast(obj);
                            } catch (Exception e) {
                                c2 = c;
                            }
                        } else if (c == 2) {
                            obj2 = loadClass2.cast(obj);
                        } else if (c == 3) {
                            obj2 = loadClass3.cast(obj);
                        } else if (c == 4) {
                            obj2 = loadClass4.cast(obj);
                        }
                        Object a2 = g.a(obj2, "getCellIdentity", new Object[0]);
                        if (a2 == null) {
                            c2 = c;
                        } else if (c == 4) {
                            cdmaCellLocation = new CdmaCellLocation();
                            try {
                                cdmaCellLocation.setCellLocationData(g.e(a2, "getBasestationId", new Object[0]), g.e(a2, "getLatitude", new Object[0]), g.e(a2, "getLongitude", new Object[0]), g.e(a2, "getSystemId", new Object[0]), g.e(a2, "getNetworkId", new Object[0]));
                                gsmCellLocation = gsmCellLocation2;
                                break;
                            } catch (Exception e2) {
                                cdmaCellLocation2 = cdmaCellLocation;
                                c2 = c;
                            }
                        } else if (c == 3) {
                            int e3 = g.e(a2, "getTac", new Object[0]);
                            int e4 = g.e(a2, "getCi", new Object[0]);
                            GsmCellLocation gsmCellLocation3 = new GsmCellLocation();
                            try {
                                gsmCellLocation3.setLacAndCid(e3, e4);
                                CdmaCellLocation cdmaCellLocation3 = cdmaCellLocation2;
                                gsmCellLocation = gsmCellLocation3;
                                cdmaCellLocation = cdmaCellLocation3;
                                break;
                            } catch (Exception e5) {
                                gsmCellLocation2 = gsmCellLocation3;
                                c2 = c;
                            }
                        } else {
                            int e6 = g.e(a2, "getLac", new Object[0]);
                            int e7 = g.e(a2, "getCid", new Object[0]);
                            GsmCellLocation gsmCellLocation4 = new GsmCellLocation();
                            try {
                                gsmCellLocation4.setLacAndCid(e6, e7);
                                CdmaCellLocation cdmaCellLocation4 = cdmaCellLocation2;
                                gsmCellLocation = gsmCellLocation4;
                                cdmaCellLocation = cdmaCellLocation4;
                                break;
                            } catch (Exception e8) {
                                gsmCellLocation2 = gsmCellLocation4;
                                c2 = c;
                            }
                        }
                    } else {
                        c2 = c;
                    }
                } catch (Exception e9) {
                }
            }
            i++;
        }
        return c != 4 ? gsmCellLocation : cdmaCellLocation;
    }

    public synchronized void b() {
        if (!this.j && com.baidu.location.f.isServing) {
            this.aeu = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.h = new LinkedList();
            this.aew = new a();
            i();
            if (this.aeu != null && this.aew != null) {
                try {
                    this.aeu.listen(this.aew, AuthorityState.STATE_INIT_ING);
                } catch (Exception e) {
                }
                switch (o()) {
                    case 0:
                        this.e = g.ad(com.baidu.location.f.getServiceContext(), "phone2");
                        break;
                    case 1:
                        this.e = g.ad(com.baidu.location.f.getServiceContext(), "phone_msim");
                        break;
                    case 2:
                        this.e = g.ad(com.baidu.location.f.getServiceContext(), "phone2");
                        break;
                }
                this.j = true;
            }
        }
    }

    public synchronized void c() {
        if (this.j) {
            if (this.aew != null && this.aeu != null) {
                this.aeu.listen(this.aew, 0);
            }
            this.aew = null;
            this.aeu = null;
            this.h.clear();
            this.h = null;
            j();
            this.j = false;
        }
    }

    public boolean d() {
        return this.q;
    }

    public int e() {
        if (this.aeu == null) {
            return 0;
        }
        try {
            return this.aeu.getNetworkType();
        } catch (Exception e) {
            return 0;
        }
    }

    public String e(com.baidu.location.b.a aVar) {
        String str;
        int intValue;
        try {
            str = d(aVar);
            intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        if ((str == null || str.equals("") || str.equals("&nc=")) && intValue < 17) {
            List neighboringCellInfo = this.aeu.getNeighboringCellInfo();
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

    public String f(com.baidu.location.b.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.aes);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.a), Integer.valueOf(aVar.b), Integer.valueOf(aVar.h)));
        if (aVar.e < Integer.MAX_VALUE && aVar.f < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(aVar.f / 14400.0d), Double.valueOf(aVar.e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        try {
            if (this.h != null && this.h.size() > 0) {
                int size = this.h.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    com.baidu.location.b.a aVar2 = this.h.get(i);
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

    public String g() {
        int i = -1;
        try {
            if (this.aeu != null) {
                i = this.aeu.getSimState();
            }
        } catch (Exception e) {
        }
        return "&sim=" + i;
    }

    public int h() {
        String str;
        try {
            str = ((TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
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

    public com.baidu.location.b.a tB() {
        if ((this.acX == null || !this.acX.a() || !this.acX.b()) && this.aeu != null) {
            try {
                k();
            } catch (Exception e) {
            }
        }
        if (this.acX.e()) {
            this.aev = null;
            this.aev = new com.baidu.location.b.a(this.acX.a, this.acX.b, this.acX.c, this.acX.d, this.acX.h, this.acX.aes);
        }
        if (this.acX.d() && this.aev != null && this.acX.aes == 'g') {
            this.acX.d = this.aev.d;
            this.acX.c = this.aev.c;
        }
        return this.acX;
    }
}
