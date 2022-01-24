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
import com.baidu.idl.authority.AuthorityState;
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
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f35106b;

    /* renamed from: c  reason: collision with root package name */
    public static b f35107c;
    public static Class<?> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public TelephonyManager f35108d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.location.c.a f35109e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.location.c.a f35110f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.baidu.location.c.a> f35111g;

    /* renamed from: h  reason: collision with root package name */
    public a f35112h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35113i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35114j;
    public Handler l;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, signalStrength) == null) || this.a.f35109e == null) {
                return;
            }
            if (this.a.f35109e.f35104i == 'g') {
                aVar = this.a.f35109e;
                cdmaDbm = signalStrength.getGsmSignalStrength();
            } else if (this.a.f35109e.f35104i != 'c') {
                return;
            } else {
                aVar = this.a.f35109e;
                cdmaDbm = signalStrength.getCdmaDbm();
            }
            aVar.f35103h = cdmaDbm;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35108d = null;
        this.f35109e = new com.baidu.location.c.a();
        this.f35110f = null;
        this.f35111g = null;
        this.f35112h = null;
        this.f35113i = false;
        this.f35114j = false;
        this.l = new Handler();
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:7|(1:9)(2:26|(9:28|(4:33|34|35|(2:41|(1:43)))|32|11|12|(3:15|16|(1:18))|21|22|23)(7:47|(1:49)|12|(3:15|16|(0))|21|22|23))|10|11|12|(0)|21|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d5, code lost:
        if (r2 <= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0174, code lost:
        r1.f35102g = java.lang.System.currentTimeMillis();
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
        int i2;
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
                        aVar.f35098c = a(cellIdentity.getMcc());
                        aVar.f35099d = a(cellIdentity.getMnc());
                        aVar.a = a(cellIdentity.getTac());
                        aVar.f35097b = a(cellIdentity.getCi());
                        aVar.f35104i = 'g';
                        asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    }
                    if (intValue >= 18) {
                        if (cellInfo instanceof CellInfoWcdma) {
                        }
                    }
                    aVar.f35102g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                    return aVar;
                }
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                aVar.f35100e = cellIdentity2.getLatitude();
                aVar.f35101f = cellIdentity2.getLongitude();
                aVar.f35099d = a(cellIdentity2.getSystemId());
                aVar.a = a(cellIdentity2.getNetworkId());
                aVar.f35097b = a(cellIdentity2.getBasestationId());
                aVar.f35104i = 'c';
                aVar.f35103h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                com.baidu.location.c.a aVar2 = this.f35109e;
                if (aVar2 == null || (i2 = aVar2.f35098c) <= 0) {
                    i2 = -1;
                    try {
                        String networkOperator = this.f35108d.getNetworkOperator();
                        if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                            int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                            if (intValue2 >= 0) {
                                i2 = intValue2;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                aVar.f35098c = i2;
                z = true;
                if (intValue >= 18 && !z) {
                    try {
                        if (cellInfo instanceof CellInfoWcdma) {
                            CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            aVar.f35098c = a(cellIdentity3.getMcc());
                            aVar.f35099d = a(cellIdentity3.getMnc());
                            aVar.a = a(cellIdentity3.getLac());
                            aVar.f35097b = a(cellIdentity3.getCid());
                            aVar.f35104i = 'g';
                            aVar.f35103h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                        }
                    } catch (Exception unused2) {
                    }
                }
                aVar.f35102g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
            aVar.f35098c = a(cellIdentity4.getMcc());
            aVar.f35099d = a(cellIdentity4.getMnc());
            aVar.a = a(cellIdentity4.getLac());
            aVar.f35097b = a(cellIdentity4.getCid());
            aVar.f35104i = 'g';
            asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            aVar.f35103h = asuLevel;
            z = true;
            if (intValue >= 18) {
            }
            aVar.f35102g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
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
            if (cellLocation == null || this.f35108d == null) {
                return null;
            }
            com.baidu.location.c.a aVar = new com.baidu.location.c.a();
            if (z) {
                aVar.f();
            }
            aVar.f35102g = System.currentTimeMillis();
            try {
                String networkOperator = this.f35108d.getNetworkOperator();
                if (networkOperator != null && networkOperator.length() > 0) {
                    int i2 = -1;
                    if (networkOperator.length() >= 3) {
                        i2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        aVar.f35098c = i2 < 0 ? this.f35109e.f35098c : i2;
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
                        i2 = this.f35109e.f35099d;
                    }
                    aVar.f35099d = i2;
                }
                a = this.f35108d.getSimState();
            } catch (Exception unused) {
                f35106b = 1;
            }
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                aVar.a = gsmCellLocation.getLac();
                aVar.f35097b = gsmCellLocation.getCid();
                aVar.f35104i = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                aVar.f35104i = 'c';
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
                            systemId = this.f35109e.f35099d;
                        }
                        aVar.f35099d = systemId;
                        aVar.f35097b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                        aVar.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                        int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                        if (baseStationLatitude < Integer.MAX_VALUE) {
                            aVar.f35100e = baseStationLatitude;
                        }
                        int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                        if (baseStationLongitude < Integer.MAX_VALUE) {
                            aVar.f35101f = baseStationLongitude;
                        }
                    } catch (Exception unused3) {
                        f35106b = 3;
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
                if (f35107c == null) {
                    f35107c = new b();
                }
                bVar = f35107c;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    private void c(com.baidu.location.c.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, aVar) == null) && aVar.b()) {
            com.baidu.location.c.a aVar2 = this.f35109e;
            if (aVar2 == null || !aVar2.a(aVar)) {
                this.f35109e = aVar;
                if (!aVar.b()) {
                    List<com.baidu.location.c.a> list = this.f35111g;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f35111g.size();
                com.baidu.location.c.a aVar3 = size == 0 ? null : this.f35111g.get(size - 1);
                if (aVar3 != null) {
                    int i2 = aVar3.f35097b;
                    com.baidu.location.c.a aVar4 = this.f35109e;
                    if (i2 == aVar4.f35097b && aVar3.a == aVar4.a) {
                        return;
                    }
                }
                this.f35111g.add(this.f35109e);
                if (this.f35111g.size() > 3) {
                    this.f35111g.remove(0);
                }
                j();
                this.f35114j = false;
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
                    List<CellInfo> allCellInfo = this.f35108d.getAllCellInfo();
                    if (allCellInfo != null && allCellInfo.size() > 0) {
                        sb2.append("&nc=");
                        for (CellInfo cellInfo : allCellInfo) {
                            if (!cellInfo.isRegistered() && (a2 = a(cellInfo)) != null && a2.a != -1 && a2.f35097b != -1) {
                                if (aVar.a != a2.a) {
                                    sb = new StringBuilder();
                                    sb.append(a2.a);
                                    sb.append("|");
                                    sb.append(a2.f35097b);
                                    sb.append("|");
                                    sb.append(a2.f35103h);
                                    sb.append(";");
                                } else {
                                    sb = new StringBuilder();
                                    sb.append("|");
                                    sb.append(a2.f35097b);
                                    sb.append("|");
                                    sb.append(a2.f35103h);
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
        String i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (i2 = k.i()) == null) {
            return;
        }
        File file = new File(i2 + File.separator + "lcvif.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                long j2 = 0;
                randomAccessFile.seek(0L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                int i3 = 0;
                while (i3 < 3) {
                    long readLong = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    int readInt4 = randomAccessFile.readInt();
                    int readInt5 = randomAccessFile.readInt();
                    char c2 = readInt5 == 2 ? 'c' : readInt5 == 1 ? 'g' : (char) 0;
                    if (readLong != j2) {
                        com.baidu.location.c.a aVar = new com.baidu.location.c.a(readInt3, readInt4, readInt, readInt2, 0, c2, -1);
                        aVar.f35102g = readLong;
                        if (aVar.b()) {
                            this.f35114j = true;
                            this.f35111g.add(aVar);
                        }
                    }
                    i3++;
                    j2 = 0;
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
            if (this.f35111g == null && this.f35110f == null) {
                return;
            }
            if (this.f35111g == null && this.f35110f != null) {
                LinkedList linkedList = new LinkedList();
                this.f35111g = linkedList;
                linkedList.add(this.f35110f);
            }
            String i2 = k.i();
            if (i2 == null || this.f35111g == null) {
                return;
            }
            File file = new File(i2 + File.separator + "lcvif.dat");
            int size = this.f35111g.size();
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeLong(this.f35111g.get(size - 1).f35102g);
                randomAccessFile.writeInt(size);
                for (int i3 = 0; i3 < 3 - size; i3++) {
                    randomAccessFile.writeLong(0L);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeInt(2);
                }
                for (int i4 = 0; i4 < size; i4++) {
                    randomAccessFile.writeLong(this.f35111g.get(i4).f35102g);
                    randomAccessFile.writeInt(this.f35111g.get(i4).f35098c);
                    randomAccessFile.writeInt(this.f35111g.get(i4).f35099d);
                    randomAccessFile.writeInt(this.f35111g.get(i4).a);
                    randomAccessFile.writeInt(this.f35111g.get(i4).f35097b);
                    if (this.f35111g.get(i4).f35104i == 'g') {
                        randomAccessFile.writeInt(1);
                    } else if (this.f35111g.get(i4).f35104i == 'c') {
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
                    cellLocation = this.f35108d.getCellLocation();
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
                a = this.f35108d.getSimState();
                List<CellInfo> allCellInfo = this.f35108d.getAllCellInfo();
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(aVar.f35104i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.f35098c), Integer.valueOf(aVar.f35099d), Integer.valueOf(aVar.a), Integer.valueOf(aVar.f35097b), Integer.valueOf(aVar.f35103h)));
            if (aVar.f35100e < Integer.MAX_VALUE && (i2 = aVar.f35101f) < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(i2 / 14400.0d), Double.valueOf(aVar.f35100e / 14400.0d)));
            }
            stringBuffer.append("&cl_t=");
            stringBuffer.append(aVar.f35102g);
            if (Build.VERSION.SDK_INT >= 28 && aVar.f35105j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs=");
                stringBuffer.append(aVar.f35105j);
            }
            try {
                if (this.f35111g != null && this.f35111g.size() > 0) {
                    int size = this.f35111g.size();
                    stringBuffer.append("&clt=");
                    for (int i3 = 0; i3 < size; i3++) {
                        com.baidu.location.c.a aVar2 = this.f35111g.get(i3);
                        if (aVar2 != null) {
                            if (aVar2.f35098c != aVar.f35098c) {
                                stringBuffer.append(aVar2.f35098c);
                            }
                            stringBuffer.append("|");
                            if (aVar2.f35099d != aVar.f35099d) {
                                stringBuffer.append(aVar2.f35099d);
                            }
                            stringBuffer.append("|");
                            if (aVar2.a != aVar.a) {
                                stringBuffer.append(aVar2.a);
                            }
                            stringBuffer.append("|");
                            if (aVar2.f35097b != aVar.f35097b) {
                                stringBuffer.append(aVar2.f35097b);
                            }
                            stringBuffer.append("|");
                            stringBuffer.append((System.currentTimeMillis() - aVar2.f35102g) / 1000);
                            stringBuffer.append(";");
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (a > 100) {
                a = 0;
            }
            int i4 = a + (f35106b << 8);
            stringBuffer.append("&cs=" + i4);
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
                if (this.f35113i) {
                    return;
                }
                if (com.baidu.location.f.isServing) {
                    this.f35108d = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
                    this.f35111g = new LinkedList();
                    this.f35112h = new a(this);
                    i();
                    if (this.f35108d == null || this.f35112h == null) {
                        return;
                    }
                    try {
                        this.f35108d.listen(this.f35112h, AuthorityState.STATE_INIT_ING);
                    } catch (Exception unused) {
                    }
                    this.f35113i = true;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f35113i) {
                    if (this.f35112h != null && this.f35108d != null) {
                        this.f35108d.listen(this.f35112h, 0);
                    }
                    this.f35112h = null;
                    this.f35108d = null;
                    this.f35111g.clear();
                    this.f35111g = null;
                    j();
                    this.f35113i = false;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35114j : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TelephonyManager telephonyManager = this.f35108d;
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
            com.baidu.location.c.a aVar2 = this.f35109e;
            if ((aVar2 == null || !aVar2.a() || !this.f35109e.b()) && this.f35108d != null) {
                try {
                    k();
                } catch (Exception unused) {
                }
            }
            com.baidu.location.c.a aVar3 = this.f35109e;
            if (aVar3 != null && aVar3.e()) {
                this.f35110f = null;
                com.baidu.location.c.a aVar4 = this.f35109e;
                this.f35110f = new com.baidu.location.c.a(aVar4.a, aVar4.f35097b, aVar4.f35098c, aVar4.f35099d, aVar4.f35103h, aVar4.f35104i, aVar4.f35105j);
            }
            com.baidu.location.c.a aVar5 = this.f35109e;
            if (aVar5 != null && aVar5.d() && (aVar = this.f35110f) != null) {
                com.baidu.location.c.a aVar6 = this.f35109e;
                if (aVar6.f35104i == 'g') {
                    aVar6.f35099d = aVar.f35099d;
                    aVar6.f35098c = aVar.f35098c;
                }
            }
            return this.f35109e;
        }
        return (com.baidu.location.c.a) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = -1;
            try {
                if (this.f35108d != null) {
                    i2 = this.f35108d.getSimState();
                }
            } catch (Exception unused) {
            }
            return "&sim=" + i2;
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
