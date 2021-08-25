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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f41064a;

    /* renamed from: b  reason: collision with root package name */
    public static int f41065b;

    /* renamed from: c  reason: collision with root package name */
    public static b f41066c;
    public static Class<?> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public TelephonyManager f41067d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.location.c.a f41068e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.location.c.a f41069f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.baidu.location.c.a> f41070g;

    /* renamed from: h  reason: collision with root package name */
    public a f41071h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41072i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41073j;
    public Handler l;

    /* loaded from: classes5.dex */
    public class a extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f41074a;

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
            this.f41074a = bVar;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cellLocation) == null) || cellLocation == null) {
                return;
            }
            this.f41074a.l.post(new c(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.baidu.location.c.a aVar;
            int cdmaDbm;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, signalStrength) == null) || this.f41074a.f41068e == null) {
                return;
            }
            if (this.f41074a.f41068e.f41062i == 'g') {
                aVar = this.f41074a.f41068e;
                cdmaDbm = signalStrength.getGsmSignalStrength();
            } else if (this.f41074a.f41068e.f41062i != 'c') {
                return;
            } else {
                aVar = this.f41074a.f41068e;
                cdmaDbm = signalStrength.getCdmaDbm();
            }
            aVar.f41061h = cdmaDbm;
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
        this.f41067d = null;
        this.f41068e = new com.baidu.location.c.a();
        this.f41069f = null;
        this.f41070g = null;
        this.f41071h = null;
        this.f41072i = false;
        this.f41073j = false;
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
        r1.f41060g = java.lang.System.currentTimeMillis();
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
                        aVar.f41056c = a(cellIdentity.getMcc());
                        aVar.f41057d = a(cellIdentity.getMnc());
                        aVar.f41054a = a(cellIdentity.getTac());
                        aVar.f41055b = a(cellIdentity.getCi());
                        aVar.f41062i = 'g';
                        asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    }
                    if (intValue >= 18) {
                        if (cellInfo instanceof CellInfoWcdma) {
                        }
                    }
                    aVar.f41060g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                    return aVar;
                }
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                aVar.f41058e = cellIdentity2.getLatitude();
                aVar.f41059f = cellIdentity2.getLongitude();
                aVar.f41057d = a(cellIdentity2.getSystemId());
                aVar.f41054a = a(cellIdentity2.getNetworkId());
                aVar.f41055b = a(cellIdentity2.getBasestationId());
                aVar.f41062i = 'c';
                aVar.f41061h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                com.baidu.location.c.a aVar2 = this.f41068e;
                if (aVar2 == null || (i2 = aVar2.f41056c) <= 0) {
                    i2 = -1;
                    try {
                        String networkOperator = this.f41067d.getNetworkOperator();
                        if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                            int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                            if (intValue2 >= 0) {
                                i2 = intValue2;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                aVar.f41056c = i2;
                z = true;
                if (intValue >= 18 && !z) {
                    try {
                        if (cellInfo instanceof CellInfoWcdma) {
                            CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            aVar.f41056c = a(cellIdentity3.getMcc());
                            aVar.f41057d = a(cellIdentity3.getMnc());
                            aVar.f41054a = a(cellIdentity3.getLac());
                            aVar.f41055b = a(cellIdentity3.getCid());
                            aVar.f41062i = 'g';
                            aVar.f41061h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                        }
                    } catch (Exception unused2) {
                    }
                }
                aVar.f41060g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
            aVar.f41056c = a(cellIdentity4.getMcc());
            aVar.f41057d = a(cellIdentity4.getMnc());
            aVar.f41054a = a(cellIdentity4.getLac());
            aVar.f41055b = a(cellIdentity4.getCid());
            aVar.f41062i = 'g';
            asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            aVar.f41061h = asuLevel;
            z = true;
            if (intValue >= 18) {
            }
            aVar.f41060g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
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
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, this, cellLocation, z)) == null) {
            if (cellLocation == null || this.f41067d == null) {
                return null;
            }
            com.baidu.location.c.a aVar = new com.baidu.location.c.a();
            if (z) {
                aVar.f();
            }
            aVar.f41060g = System.currentTimeMillis();
            try {
                String networkOperator = this.f41067d.getNetworkOperator();
                if (networkOperator != null && networkOperator.length() > 0) {
                    int i2 = -1;
                    if (networkOperator.length() >= 3) {
                        i2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        aVar.f41056c = i2 < 0 ? this.f41068e.f41056c : i2;
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
                        i2 = this.f41068e.f41057d;
                    }
                    aVar.f41057d = i2;
                }
                f41064a = this.f41067d.getSimState();
            } catch (Exception unused) {
                f41065b = 1;
            }
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                aVar.f41054a = gsmCellLocation.getLac();
                aVar.f41055b = gsmCellLocation.getCid();
                aVar.f41062i = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                aVar.f41062i = 'c';
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
                            systemId = this.f41068e.f41057d;
                        }
                        aVar.f41057d = systemId;
                        aVar.f41055b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                        aVar.f41054a = ((CdmaCellLocation) cellLocation).getNetworkId();
                        int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                        if (baseStationLatitude < Integer.MAX_VALUE) {
                            aVar.f41058e = baseStationLatitude;
                        }
                        int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                        if (baseStationLongitude < Integer.MAX_VALUE) {
                            aVar.f41059f = baseStationLongitude;
                        }
                    } catch (Exception unused3) {
                        f41065b = 3;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (b.class) {
                if (f41066c == null) {
                    f41066c = new b();
                }
                bVar = f41066c;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    private void c(com.baidu.location.c.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, aVar) == null) && aVar.b()) {
            com.baidu.location.c.a aVar2 = this.f41068e;
            if (aVar2 == null || !aVar2.a(aVar)) {
                this.f41068e = aVar;
                if (!aVar.b()) {
                    List<com.baidu.location.c.a> list = this.f41070g;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f41070g.size();
                com.baidu.location.c.a aVar3 = size == 0 ? null : this.f41070g.get(size - 1);
                if (aVar3 != null) {
                    int i2 = aVar3.f41055b;
                    com.baidu.location.c.a aVar4 = this.f41068e;
                    if (i2 == aVar4.f41055b && aVar3.f41054a == aVar4.f41054a) {
                        return;
                    }
                }
                this.f41070g.add(this.f41068e);
                if (this.f41070g.size() > 3) {
                    this.f41070g.remove(0);
                }
                j();
                this.f41073j = false;
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
                    List<CellInfo> allCellInfo = this.f41067d.getAllCellInfo();
                    if (allCellInfo != null && allCellInfo.size() > 0) {
                        sb2.append("&nc=");
                        for (CellInfo cellInfo : allCellInfo) {
                            if (!cellInfo.isRegistered() && (a2 = a(cellInfo)) != null && a2.f41054a != -1 && a2.f41055b != -1) {
                                if (aVar.f41054a != a2.f41054a) {
                                    sb = new StringBuilder();
                                    sb.append(a2.f41054a);
                                    sb.append("|");
                                    sb.append(a2.f41055b);
                                    sb.append("|");
                                    sb.append(a2.f41061h);
                                    sb.append(";");
                                } else {
                                    sb = new StringBuilder();
                                    sb.append("|");
                                    sb.append(a2.f41055b);
                                    sb.append("|");
                                    sb.append(a2.f41061h);
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
                        aVar.f41060g = readLong;
                        if (aVar.b()) {
                            this.f41073j = true;
                            this.f41070g.add(aVar);
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
            if (this.f41070g == null && this.f41069f == null) {
                return;
            }
            if (this.f41070g == null && this.f41069f != null) {
                LinkedList linkedList = new LinkedList();
                this.f41070g = linkedList;
                linkedList.add(this.f41069f);
            }
            String i2 = k.i();
            if (i2 == null || this.f41070g == null) {
                return;
            }
            File file = new File(i2 + File.separator + "lcvif.dat");
            int size = this.f41070g.size();
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeLong(this.f41070g.get(size - 1).f41060g);
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
                    randomAccessFile.writeLong(this.f41070g.get(i4).f41060g);
                    randomAccessFile.writeInt(this.f41070g.get(i4).f41056c);
                    randomAccessFile.writeInt(this.f41070g.get(i4).f41057d);
                    randomAccessFile.writeInt(this.f41070g.get(i4).f41054a);
                    randomAccessFile.writeInt(this.f41070g.get(i4).f41055b);
                    if (this.f41070g.get(i4).f41062i == 'g') {
                        randomAccessFile.writeInt(1);
                    } else if (this.f41070g.get(i4).f41062i == 'c') {
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
                    cellLocation = this.f41067d.getCellLocation();
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
                f41064a = this.f41067d.getSimState();
                List<CellInfo> allCellInfo = this.f41067d.getAllCellInfo();
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
            stringBuffer.append(aVar.f41062i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.f41056c), Integer.valueOf(aVar.f41057d), Integer.valueOf(aVar.f41054a), Integer.valueOf(aVar.f41055b), Integer.valueOf(aVar.f41061h)));
            if (aVar.f41058e < Integer.MAX_VALUE && (i2 = aVar.f41059f) < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(i2 / 14400.0d), Double.valueOf(aVar.f41058e / 14400.0d)));
            }
            stringBuffer.append("&cl_t=");
            stringBuffer.append(aVar.f41060g);
            if (Build.VERSION.SDK_INT >= 28 && aVar.f41063j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs=");
                stringBuffer.append(aVar.f41063j);
            }
            try {
                if (this.f41070g != null && this.f41070g.size() > 0) {
                    int size = this.f41070g.size();
                    stringBuffer.append("&clt=");
                    for (int i3 = 0; i3 < size; i3++) {
                        com.baidu.location.c.a aVar2 = this.f41070g.get(i3);
                        if (aVar2 != null) {
                            if (aVar2.f41056c != aVar.f41056c) {
                                stringBuffer.append(aVar2.f41056c);
                            }
                            stringBuffer.append("|");
                            if (aVar2.f41057d != aVar.f41057d) {
                                stringBuffer.append(aVar2.f41057d);
                            }
                            stringBuffer.append("|");
                            if (aVar2.f41054a != aVar.f41054a) {
                                stringBuffer.append(aVar2.f41054a);
                            }
                            stringBuffer.append("|");
                            if (aVar2.f41055b != aVar.f41055b) {
                                stringBuffer.append(aVar2.f41055b);
                            }
                            stringBuffer.append("|");
                            stringBuffer.append((System.currentTimeMillis() - aVar2.f41060g) / 1000);
                            stringBuffer.append(";");
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (f41064a > 100) {
                f41064a = 0;
            }
            int i4 = f41064a + (f41065b << 8);
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
                if (this.f41072i) {
                    return;
                }
                if (com.baidu.location.f.isServing) {
                    this.f41067d = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
                    this.f41070g = new LinkedList();
                    this.f41071h = new a(this);
                    i();
                    if (this.f41067d == null || this.f41071h == null) {
                        return;
                    }
                    try {
                        this.f41067d.listen(this.f41071h, AuthorityState.STATE_INIT_ING);
                    } catch (Exception unused) {
                    }
                    this.f41072i = true;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f41072i) {
                    if (this.f41071h != null && this.f41067d != null) {
                        this.f41067d.listen(this.f41071h, 0);
                    }
                    this.f41071h = null;
                    this.f41067d = null;
                    this.f41070g.clear();
                    this.f41070g = null;
                    j();
                    this.f41072i = false;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41073j : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TelephonyManager telephonyManager = this.f41067d;
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
            com.baidu.location.c.a aVar2 = this.f41068e;
            if ((aVar2 == null || !aVar2.a() || !this.f41068e.b()) && this.f41067d != null) {
                try {
                    k();
                } catch (Exception unused) {
                }
            }
            com.baidu.location.c.a aVar3 = this.f41068e;
            if (aVar3 != null && aVar3.e()) {
                this.f41069f = null;
                com.baidu.location.c.a aVar4 = this.f41068e;
                this.f41069f = new com.baidu.location.c.a(aVar4.f41054a, aVar4.f41055b, aVar4.f41056c, aVar4.f41057d, aVar4.f41061h, aVar4.f41062i, aVar4.f41063j);
            }
            com.baidu.location.c.a aVar5 = this.f41068e;
            if (aVar5 != null && aVar5.d() && (aVar = this.f41069f) != null) {
                com.baidu.location.c.a aVar6 = this.f41068e;
                if (aVar6.f41062i == 'g') {
                    aVar6.f41057d = aVar.f41057d;
                    aVar6.f41056c = aVar.f41056c;
                }
            }
            return this.f41068e;
        }
        return (com.baidu.location.c.a) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = -1;
            try {
                if (this.f41067d != null) {
                    i2 = this.f41067d.getSimState();
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
