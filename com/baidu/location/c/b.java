package com.baidu.location.c;

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
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.e.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f26004b;

    /* renamed from: c  reason: collision with root package name */
    public static b f26005c;
    public static Class<?> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public TelephonyManager f26006d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.location.c.a f26007e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.location.c.a f26008f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.baidu.location.c.a> f26009g;

    /* renamed from: h  reason: collision with root package name */
    public a f26010h;
    public boolean i;
    public boolean j;
    public Handler l;

    /* loaded from: classes4.dex */
    public class a extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cellLocation) == null) || cellLocation == null) {
                return;
            }
            this.a.l.post(new c(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.baidu.location.c.a aVar;
            int cdmaDbm;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, signalStrength) == null) || this.a.f26007e == null) {
                return;
            }
            if (this.a.f26007e.i == 'g') {
                aVar = this.a.f26007e;
                cdmaDbm = signalStrength.getGsmSignalStrength();
            } else if (this.a.f26007e.i != 'c') {
                return;
            } else {
                aVar = this.a.f26007e;
                cdmaDbm = signalStrength.getCdmaDbm();
            }
            aVar.f26003h = cdmaDbm;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037753105, "Lcom/baidu/location/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037753105, "Lcom/baidu/location/c/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26006d = null;
        this.f26007e = new com.baidu.location.c.a();
        this.f26008f = null;
        this.f26009g = null;
        this.f26010h = null;
        this.i = false;
        this.j = false;
        this.l = new Handler();
    }

    private int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i;
        }
        return invokeI.intValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:7|(1:9)(2:26|(9:28|(4:33|34|35|(2:41|(1:43)))|32|11|12|(3:15|16|(1:18))|21|22|23)(7:47|(1:49)|12|(3:15|16|(0))|21|22|23))|10|11|12|(0)|21|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d5, code lost:
        if (r2 <= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0174, code lost:
        r1.f26002g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121 A[Catch: Exception -> 0x015f, TRY_LEAVE, TryCatch #0 {Exception -> 0x015f, blocks: (B:40:0x011d, B:42:0x0121), top: B:52:0x011d }] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.c.a a(CellInfo cellInfo) {
        InterceptResult invokeL;
        int asuLevel;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, cellInfo)) == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if (intValue < 17) {
                return null;
            }
            com.baidu.location.c.a aVar = new com.baidu.location.c.a();
            boolean z = false;
            if (!(cellInfo instanceof CellInfoGsm)) {
                if (!(cellInfo instanceof CellInfoCdma)) {
                    if (cellInfo instanceof CellInfoLte) {
                        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                        aVar.f25998c = a(cellIdentity.getMcc());
                        aVar.f25999d = a(cellIdentity.getMnc());
                        aVar.a = a(cellIdentity.getTac());
                        aVar.f25997b = a(cellIdentity.getCi());
                        aVar.i = 'g';
                        asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    }
                    if (intValue >= 18) {
                        if (cellInfo instanceof CellInfoWcdma) {
                        }
                    }
                    aVar.f26002g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                    return aVar;
                }
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                aVar.f26000e = cellIdentity2.getLatitude();
                aVar.f26001f = cellIdentity2.getLongitude();
                aVar.f25999d = a(cellIdentity2.getSystemId());
                aVar.a = a(cellIdentity2.getNetworkId());
                aVar.f25997b = a(cellIdentity2.getBasestationId());
                aVar.i = 'c';
                aVar.f26003h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                com.baidu.location.c.a aVar2 = this.f26007e;
                if (aVar2 == null || (i = aVar2.f25998c) <= 0) {
                    i = -1;
                    try {
                        String networkOperator = this.f26006d.getNetworkOperator();
                        if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                            int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                            if (intValue2 >= 0) {
                                i = intValue2;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                aVar.f25998c = i;
                z = true;
                if (intValue >= 18 && !z) {
                    try {
                        if (cellInfo instanceof CellInfoWcdma) {
                            CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            aVar.f25998c = a(cellIdentity3.getMcc());
                            aVar.f25999d = a(cellIdentity3.getMnc());
                            aVar.a = a(cellIdentity3.getLac());
                            aVar.f25997b = a(cellIdentity3.getCid());
                            aVar.i = 'g';
                            aVar.f26003h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                        }
                    } catch (Exception unused2) {
                    }
                }
                aVar.f26002g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
            aVar.f25998c = a(cellIdentity4.getMcc());
            aVar.f25999d = a(cellIdentity4.getMnc());
            aVar.a = a(cellIdentity4.getLac());
            aVar.f25997b = a(cellIdentity4.getCid());
            aVar.i = 'g';
            asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            aVar.f26003h = asuLevel;
            z = true;
            if (intValue >= 18) {
            }
            aVar.f26002g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
            return aVar;
        }
        return (com.baidu.location.c.a) invokeL.objValue;
    }

    private com.baidu.location.c.a a(CellLocation cellLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cellLocation)) == null) ? a(cellLocation, false) : (com.baidu.location.c.a) invokeL.objValue;
    }

    private com.baidu.location.c.a a(CellLocation cellLocation, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, this, cellLocation, z)) == null) {
            if (cellLocation == null || this.f26006d == null) {
                return null;
            }
            com.baidu.location.c.a aVar = new com.baidu.location.c.a();
            if (z) {
                aVar.f();
            }
            aVar.f26002g = System.currentTimeMillis();
            try {
                String networkOperator = this.f26006d.getNetworkOperator();
                if (networkOperator != null && networkOperator.length() > 0) {
                    int i = -1;
                    if (networkOperator.length() >= 3) {
                        i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        aVar.f25998c = i < 0 ? this.f26007e.f25998c : i;
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
                        i = this.f26007e.f25999d;
                    }
                    aVar.f25999d = i;
                }
                a = this.f26006d.getSimState();
            } catch (Exception unused) {
                f26004b = 1;
            }
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                aVar.a = gsmCellLocation.getLac();
                aVar.f25997b = gsmCellLocation.getCid();
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
                            systemId = this.f26007e.f25999d;
                        }
                        aVar.f25999d = systemId;
                        aVar.f25997b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                        aVar.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                        int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                        if (baseStationLatitude < Integer.MAX_VALUE) {
                            aVar.f26000e = baseStationLatitude;
                        }
                        int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                        if (baseStationLongitude < Integer.MAX_VALUE) {
                            aVar.f26001f = baseStationLongitude;
                        }
                    } catch (Exception unused3) {
                        f26004b = 3;
                        return aVar;
                    }
                }
            }
            c(aVar);
            return aVar;
        }
        return (com.baidu.location.c.a) invokeLZ.objValue;
    }

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (b.class) {
                if (f26005c == null) {
                    f26005c = new b();
                }
                bVar = f26005c;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    private void c(com.baidu.location.c.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, aVar) == null) && aVar.b()) {
            com.baidu.location.c.a aVar2 = this.f26007e;
            if (aVar2 == null || !aVar2.a(aVar)) {
                this.f26007e = aVar;
                if (!aVar.b()) {
                    List<com.baidu.location.c.a> list = this.f26009g;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f26009g.size();
                com.baidu.location.c.a aVar3 = size == 0 ? null : this.f26009g.get(size - 1);
                if (aVar3 != null) {
                    int i = aVar3.f25997b;
                    com.baidu.location.c.a aVar4 = this.f26007e;
                    if (i == aVar4.f25997b && aVar3.a == aVar4.a) {
                        return;
                    }
                }
                this.f26009g.add(this.f26007e);
                if (this.f26009g.size() > 3) {
                    this.f26009g.remove(0);
                }
                j();
                this.j = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private String d(com.baidu.location.c.a aVar) {
        InterceptResult invokeL;
        com.baidu.location.c.a a2;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, aVar)) == null) {
            StringBuilder sb2 = new StringBuilder();
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
                try {
                    List<CellInfo> allCellInfo = this.f26006d.getAllCellInfo();
                    if (allCellInfo != null && allCellInfo.size() > 0) {
                        sb2.append("&nc=");
                        for (CellInfo cellInfo : allCellInfo) {
                            if (!cellInfo.isRegistered() && (a2 = a(cellInfo)) != null && a2.a != -1 && a2.f25997b != -1) {
                                if (aVar.a != a2.a) {
                                    sb = new StringBuilder();
                                    sb.append(a2.a);
                                    sb.append("|");
                                    sb.append(a2.f25997b);
                                    sb.append("|");
                                    sb.append(a2.f26003h);
                                    sb.append(";");
                                } else {
                                    sb = new StringBuilder();
                                    sb.append("|");
                                    sb.append(a2.f25997b);
                                    sb.append("|");
                                    sb.append(a2.f26003h);
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
        return (String) invokeL.objValue;
    }

    private void i() {
        String i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (i = k.i()) == null) {
            return;
        }
        File file = new File(i + File.separator + "lcvif.dat");
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
                        com.baidu.location.c.a aVar = new com.baidu.location.c.a(readInt3, readInt4, readInt, readInt2, 0, c2, -1);
                        aVar.f26002g = readLong;
                        if (aVar.b()) {
                            this.j = true;
                            this.f26009g.add(aVar);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.f26009g == null && this.f26008f == null) {
                return;
            }
            if (this.f26009g == null && this.f26008f != null) {
                LinkedList linkedList = new LinkedList();
                this.f26009g = linkedList;
                linkedList.add(this.f26008f);
            }
            String i = k.i();
            if (i == null || this.f26009g == null) {
                return;
            }
            File file = new File(i + File.separator + "lcvif.dat");
            int size = this.f26009g.size();
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeLong(this.f26009g.get(size - 1).f26002g);
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
                    randomAccessFile.writeLong(this.f26009g.get(i3).f26002g);
                    randomAccessFile.writeInt(this.f26009g.get(i3).f25998c);
                    randomAccessFile.writeInt(this.f26009g.get(i3).f25999d);
                    randomAccessFile.writeInt(this.f26009g.get(i3).a);
                    randomAccessFile.writeInt(this.f26009g.get(i3).f25997b);
                    if (this.f26009g.get(i3).i == 'g') {
                        randomAccessFile.writeInt(1);
                    } else if (this.f26009g.get(i3).i == 'c') {
                        randomAccessFile.writeInt(2);
                    } else {
                        randomAccessFile.writeInt(3);
                    }
                }
                randomAccessFile.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        CellLocation cellLocation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.baidu.location.c.a l = l();
            if (l != null) {
                c(l);
            }
            if (l == null || !l.b()) {
                try {
                    cellLocation = this.f26006d.getCellLocation();
                } catch (Throwable unused) {
                    cellLocation = null;
                }
                if (cellLocation != null) {
                    a(cellLocation);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.c.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
                return null;
            }
            try {
                a = this.f26006d.getSimState();
                List<CellInfo> allCellInfo = this.f26006d.getAllCellInfo();
                if (allCellInfo == null || allCellInfo.size() <= 0) {
                    return null;
                }
                com.baidu.location.c.a aVar = null;
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo.isRegistered()) {
                        boolean z = aVar != null;
                        com.baidu.location.c.a a2 = a(cellInfo);
                        if (a2 != null) {
                            if (!a2.b()) {
                                a2 = null;
                            } else if (z && aVar != null) {
                                aVar.k = a2.h();
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
        return (com.baidu.location.c.a) invokeV.objValue;
    }

    public String a(com.baidu.location.c.a aVar) {
        InterceptResult invokeL;
        String d2;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String str = "";
            try {
                d2 = d(aVar);
                intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
                if (d2 != null && !d2.equals("")) {
                    if (!d2.equals("&nc=")) {
                        return d2;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (intValue >= 17) {
                return d2;
            }
            str = d2;
            if (str == null || !str.equals("&nc=")) {
                return str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String b(com.baidu.location.c.a aVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(aVar.i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.f25998c), Integer.valueOf(aVar.f25999d), Integer.valueOf(aVar.a), Integer.valueOf(aVar.f25997b), Integer.valueOf(aVar.f26003h)));
            if (aVar.f26000e < Integer.MAX_VALUE && (i = aVar.f26001f) < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(i / 14400.0d), Double.valueOf(aVar.f26000e / 14400.0d)));
            }
            stringBuffer.append("&cl_t=");
            stringBuffer.append(aVar.f26002g);
            if (Build.VERSION.SDK_INT >= 28 && aVar.j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs=");
                stringBuffer.append(aVar.j);
            }
            try {
                if (this.f26009g != null && this.f26009g.size() > 0) {
                    int size = this.f26009g.size();
                    stringBuffer.append("&clt=");
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.location.c.a aVar2 = this.f26009g.get(i2);
                        if (aVar2 != null) {
                            if (aVar2.f25998c != aVar.f25998c) {
                                stringBuffer.append(aVar2.f25998c);
                            }
                            stringBuffer.append("|");
                            if (aVar2.f25999d != aVar.f25999d) {
                                stringBuffer.append(aVar2.f25999d);
                            }
                            stringBuffer.append("|");
                            if (aVar2.a != aVar.a) {
                                stringBuffer.append(aVar2.a);
                            }
                            stringBuffer.append("|");
                            if (aVar2.f25997b != aVar.f25997b) {
                                stringBuffer.append(aVar2.f25997b);
                            }
                            stringBuffer.append("|");
                            stringBuffer.append((System.currentTimeMillis() - aVar2.f26002g) / 1000);
                            stringBuffer.append(";");
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (a > 100) {
                a = 0;
            }
            int i3 = a + (f26004b << 8);
            stringBuffer.append("&cs=" + i3);
            String str = aVar.k;
            if (str != null) {
                stringBuffer.append(str);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.i) {
                    return;
                }
                if (com.baidu.location.f.isServing) {
                    this.f26006d = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
                    this.f26009g = new LinkedList();
                    this.f26010h = new a(this);
                    i();
                    if (this.f26006d == null || this.f26010h == null) {
                        return;
                    }
                    try {
                        this.f26006d.listen(this.f26010h, 272);
                    } catch (Exception unused) {
                    }
                    this.i = true;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.i) {
                    if (this.f26010h != null && this.f26006d != null) {
                        this.f26006d.listen(this.f26010h, 0);
                    }
                    this.f26010h = null;
                    this.f26006d = null;
                    this.f26009g.clear();
                    this.f26009g = null;
                    j();
                    this.i = false;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TelephonyManager telephonyManager = this.f26006d;
            if (telephonyManager == null) {
                return 0;
            }
            try {
                return telephonyManager.getNetworkType();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public com.baidu.location.c.a f() {
        InterceptResult invokeV;
        com.baidu.location.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.baidu.location.c.a aVar2 = this.f26007e;
            if ((aVar2 == null || !aVar2.a() || !this.f26007e.b()) && this.f26006d != null) {
                try {
                    k();
                } catch (Exception unused) {
                }
            }
            com.baidu.location.c.a aVar3 = this.f26007e;
            if (aVar3 != null && aVar3.e()) {
                this.f26008f = null;
                com.baidu.location.c.a aVar4 = this.f26007e;
                this.f26008f = new com.baidu.location.c.a(aVar4.a, aVar4.f25997b, aVar4.f25998c, aVar4.f25999d, aVar4.f26003h, aVar4.i, aVar4.j);
            }
            com.baidu.location.c.a aVar5 = this.f26007e;
            if (aVar5 != null && aVar5.d() && (aVar = this.f26008f) != null) {
                com.baidu.location.c.a aVar6 = this.f26007e;
                if (aVar6.i == 'g') {
                    aVar6.f25999d = aVar.f25999d;
                    aVar6.f25998c = aVar.f25998c;
                }
            }
            return this.f26007e;
        }
        return (com.baidu.location.c.a) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = -1;
            try {
                if (this.f26006d != null) {
                    i = this.f26006d.getSimState();
                }
            } catch (Exception unused) {
            }
            return "&sim=" + i;
        }
        return (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}
