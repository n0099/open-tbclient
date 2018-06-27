package com.baidu.location.f;

import android.os.Build;
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
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class b extends d {
    private static b XW = null;
    private static Method k = null;
    private static Method l = null;
    private static Method m = null;
    private static Method n = null;
    private static Method o = null;
    private static Class<?> Yb = null;
    public static int a = 0;
    public static int b = 0;
    private TelephonyManager XX = null;
    private Object e = null;
    private com.baidu.location.f.a XY = new com.baidu.location.f.a();
    private com.baidu.location.f.a XZ = null;
    private List<com.baidu.location.f.a> h = null;
    private a Ya = null;
    private boolean j = false;
    private boolean q = false;

    /* loaded from: classes2.dex */
    private class a extends PhoneStateListener {
        public a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            try {
                b.this.j();
            } catch (Exception e) {
            }
            com.baidu.location.c.a.qu().e();
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (b.this.XY != null) {
                if (b.this.XY.XV == 'g') {
                    b.this.XY.h = signalStrength.getGsmSignalStrength();
                } else if (b.this.XY.XV == 'c') {
                    b.this.XY.h = signalStrength.getCdmaDbm();
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

    private com.baidu.location.f.a a(CellLocation cellLocation, boolean z) {
        int i = 0;
        if (cellLocation == null || this.XX == null) {
            return null;
        }
        com.baidu.location.f.a aVar = new com.baidu.location.f.a();
        if (z) {
            aVar.f();
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.XX.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.XY.c;
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
                    intValue2 = this.XY.d;
                }
                aVar.d = intValue2;
            }
            a = this.XX.getSimState();
        } catch (Exception e) {
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = ((GsmCellLocation) cellLocation).getCid();
            aVar.XV = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.XV = 'c';
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 5) {
                return aVar;
            }
            if (Yb == null) {
                try {
                    Yb = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    k = Yb.getMethod("getBaseStationId", new Class[0]);
                    l = Yb.getMethod("getNetworkId", new Class[0]);
                    m = Yb.getMethod("getSystemId", new Class[0]);
                    n = Yb.getMethod("getBaseStationLatitude", new Class[0]);
                    o = Yb.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception e2) {
                    Yb = null;
                    b = 2;
                    return aVar;
                }
            }
            if (Yb != null && Yb.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) m.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.XY.d;
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
        d(aVar);
        return aVar;
    }

    private com.baidu.location.f.a b(CellInfo cellInfo) {
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.f.a aVar = new com.baidu.location.f.a();
        boolean z = false;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity.getMcc());
            aVar.d = a(cellIdentity.getMnc());
            aVar.a = a(cellIdentity.getLac());
            aVar.b = a(cellIdentity.getCid());
            aVar.XV = 'g';
            aVar.h = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            aVar.e = cellIdentity2.getLatitude();
            aVar.f = cellIdentity2.getLongitude();
            aVar.d = a(cellIdentity2.getSystemId());
            aVar.a = a(cellIdentity2.getNetworkId());
            aVar.b = a(cellIdentity2.getBasestationId());
            aVar.XV = 'c';
            aVar.h = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity3.getMcc());
            aVar.d = a(cellIdentity3.getMnc());
            aVar.a = a(cellIdentity3.getTac());
            aVar.b = a(cellIdentity3.getCi());
            aVar.XV = 'g';
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
                    aVar.XV = 'g';
                    aVar.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                }
            } catch (Exception e) {
            }
        }
        try {
            aVar.g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
        } catch (Error e2) {
            aVar.g = System.currentTimeMillis();
        }
        return aVar;
    }

    private com.baidu.location.f.a b(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private void d(com.baidu.location.f.a aVar) {
        if (aVar.b()) {
            if (this.XY == null || !this.XY.a(aVar)) {
                this.XY = aVar;
                if (!aVar.b()) {
                    if (this.h != null) {
                        this.h.clear();
                        return;
                    }
                    return;
                }
                int size = this.h.size();
                com.baidu.location.f.a aVar2 = size == 0 ? null : this.h.get(size - 1);
                if (aVar2 != null && aVar2.b == this.XY.b && aVar2.a == this.XY.a) {
                    return;
                }
                this.h.add(this.XY);
                if (this.h.size() > 3) {
                    this.h.remove(0);
                }
                i();
                this.q = false;
            }
        }
    }

    private String e(com.baidu.location.f.a aVar) {
        com.baidu.location.f.a b2;
        StringBuilder sb = new StringBuilder();
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.XX.getAllCellInfo();
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
            } catch (Exception e) {
            } catch (NoSuchMethodError e2) {
            }
        }
        return sb.toString();
    }

    private void h() {
        String f = com.baidu.location.h.i.f();
        if (f == null) {
            return;
        }
        File file = new File(f + File.separator + "lcvif.dat");
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
                        com.baidu.location.f.a aVar = new com.baidu.location.f.a(readInt3, readInt4, readInt, readInt2, 0, c);
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

    private void i() {
        if (this.h == null && this.XZ == null) {
            return;
        }
        if (this.h == null && this.XZ != null) {
            this.h = new LinkedList();
            this.h.add(this.XZ);
        }
        String f = com.baidu.location.h.i.f();
        if (f != null) {
            File file = new File(f + File.separator + "lcvif.dat");
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
                    if (this.h.get(i2).XV == 'g') {
                        randomAccessFile.writeInt(1);
                    } else if (this.h.get(i2).XV == 'c') {
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
    public void j() {
        CellLocation qS;
        com.baidu.location.f.a qU = qU();
        if (qU != null) {
            d(qU);
        }
        if (qU == null || !qU.b()) {
            com.baidu.location.f.a b2 = b(this.XX.getCellLocation());
            if ((b2 == null || !b2.b()) && (qS = qS()) != null) {
                Log.i(com.baidu.location.h.b.a, "cell sim2 cell is valid");
                a(qS, true);
            }
        }
    }

    private int n() {
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

    private CellLocation n(List<?> list) {
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
                        Object a2 = com.baidu.location.h.i.a(obj2, "getCellIdentity", new Object[0]);
                        if (a2 == null) {
                            c2 = c;
                        } else if (c == 4) {
                            cdmaCellLocation = new CdmaCellLocation();
                            try {
                                cdmaCellLocation.setCellLocationData(com.baidu.location.h.i.e(a2, "getBasestationId", new Object[0]), com.baidu.location.h.i.e(a2, "getLatitude", new Object[0]), com.baidu.location.h.i.e(a2, "getLongitude", new Object[0]), com.baidu.location.h.i.e(a2, "getSystemId", new Object[0]), com.baidu.location.h.i.e(a2, "getNetworkId", new Object[0]));
                                gsmCellLocation = gsmCellLocation2;
                                break;
                            } catch (Exception e2) {
                                cdmaCellLocation2 = cdmaCellLocation;
                                c2 = c;
                            }
                        } else if (c == 3) {
                            int e3 = com.baidu.location.h.i.e(a2, "getTac", new Object[0]);
                            int e4 = com.baidu.location.h.i.e(a2, "getCi", new Object[0]);
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
                            int e6 = com.baidu.location.h.i.e(a2, "getLac", new Object[0]);
                            int e7 = com.baidu.location.h.i.e(a2, "getCid", new Object[0]);
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

    public static synchronized b qQ() {
        b bVar;
        synchronized (b.class) {
            if (XW == null) {
                XW = new b();
            }
            bVar = XW;
        }
        return bVar;
    }

    private CellLocation qS() {
        CellLocation cellLocation;
        Object obj;
        List<?> list;
        Object obj2 = this.e;
        if (obj2 == null) {
            return null;
        }
        try {
            Class<?> qT = qT();
            if (qT.isInstance(obj2)) {
                Object cast = qT.cast(obj2);
                try {
                    obj = com.baidu.location.h.i.a(cast, "getCellLocation", new Object[0]);
                } catch (NoSuchMethodException e) {
                    obj = null;
                } catch (Exception e2) {
                    obj = null;
                }
                if (obj == null) {
                    try {
                        obj = com.baidu.location.h.i.a(cast, "getCellLocation", 1);
                    } catch (NoSuchMethodException e3) {
                    } catch (Exception e4) {
                    }
                }
                if (obj == null) {
                    try {
                        obj = com.baidu.location.h.i.a(cast, "getCellLocationGemini", 1);
                    } catch (NoSuchMethodException e5) {
                    } catch (Exception e6) {
                    }
                }
                if (obj == null) {
                    try {
                        list = (List) com.baidu.location.h.i.a(cast, "getAllCellInfo", new Object[0]);
                    } catch (NoSuchMethodException e7) {
                        list = null;
                    } catch (Exception e8) {
                        list = null;
                    }
                    obj = n(list);
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

    private Class<?> qT() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (n()) {
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

    private com.baidu.location.f.a qU() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            try {
                List<CellInfo> allCellInfo = this.XX.getAllCellInfo();
                if (allCellInfo == null || allCellInfo.size() <= 0) {
                    return null;
                }
                com.baidu.location.f.a aVar = null;
                for (CellInfo cellInfo : allCellInfo) {
                    try {
                        if (cellInfo.isRegistered()) {
                            com.baidu.location.f.a b2 = b(cellInfo);
                            if (b2 != null) {
                                try {
                                    if (!b2.b()) {
                                        b2 = null;
                                    }
                                    return b2;
                                } catch (Exception e) {
                                    return b2;
                                }
                            }
                            aVar = b2;
                        }
                    } catch (Exception e2) {
                        return aVar;
                    }
                }
                return aVar;
            } catch (NoSuchMethodError e3) {
                return null;
            }
        } catch (Exception e4) {
            return null;
        }
    }

    @Override // com.baidu.location.f.d
    public synchronized void b() {
        if (!this.j && com.baidu.location.f.isServing) {
            this.XX = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.h = new LinkedList();
            this.Ya = new a();
            h();
            if (this.XX != null && this.Ya != null) {
                try {
                    this.XX.listen(this.Ya, AuthorityState.STATE_INIT_ING);
                } catch (Exception e) {
                }
                switch (n()) {
                    case 0:
                        this.e = com.baidu.location.h.i.M(com.baidu.location.f.getServiceContext(), "phone2");
                        break;
                    case 1:
                        this.e = com.baidu.location.h.i.M(com.baidu.location.f.getServiceContext(), "phone_msim");
                        break;
                    case 2:
                        this.e = com.baidu.location.h.i.M(com.baidu.location.f.getServiceContext(), "phone2");
                        break;
                }
                this.j = true;
            }
        }
    }

    @Override // com.baidu.location.f.d
    public synchronized void c() {
        if (this.j) {
            if (this.Ya != null && this.XX != null) {
                this.XX.listen(this.Ya, 0);
            }
            this.Ya = null;
            this.XX = null;
            this.h.clear();
            this.h = null;
            i();
            this.j = false;
        }
    }

    public boolean d() {
        return this.q;
    }

    @Override // com.baidu.location.f.d
    public int e() {
        if (this.XX == null) {
            return 0;
        }
        try {
            return this.XX.getNetworkType();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // com.baidu.location.f.d
    public String f(com.baidu.location.f.a aVar) {
        String str;
        try {
            str = e(aVar);
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        if (str == null || str.equals("") || str.equals("&nc=")) {
            List neighboringCellInfo = this.XX.getNeighboringCellInfo();
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

    @Override // com.baidu.location.f.d
    public int g() {
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

    public String g(com.baidu.location.f.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.XV);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.a), Integer.valueOf(aVar.b), Integer.valueOf(aVar.h)));
        if (aVar.e < Integer.MAX_VALUE && aVar.f < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(aVar.f / 14400.0d), Double.valueOf(aVar.e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        if (this.h != null && this.h.size() > 0) {
            int size = this.h.size();
            stringBuffer.append("&clt=");
            for (int i = 0; i < size; i++) {
                com.baidu.location.f.a aVar2 = this.h.get(i);
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
        if (a > 100) {
            a = 0;
        }
        stringBuffer.append("&cs=" + ((b << 8) + a));
        return stringBuffer.toString();
    }

    @Override // com.baidu.location.f.d
    public com.baidu.location.f.a qR() {
        if ((this.XY == null || !this.XY.a() || !this.XY.b()) && this.XX != null) {
            try {
                j();
            } catch (Exception e) {
            }
        }
        if (this.XY.e()) {
            this.XZ = null;
            this.XZ = new com.baidu.location.f.a(this.XY.a, this.XY.b, this.XY.c, this.XY.d, this.XY.h, this.XY.XV);
        }
        if (this.XY.d() && this.XZ != null && this.XY.XV == 'g') {
            this.XY.d = this.XZ.d;
            this.XY.c = this.XZ.c;
        }
        return this.XY;
    }
}
