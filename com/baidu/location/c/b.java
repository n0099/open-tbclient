package com.baidu.location.c;

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
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public static b c;
    public static Class k;
    public transient /* synthetic */ FieldHolder $fh;
    public TelephonyManager d;
    public com.baidu.location.c.a e;
    public com.baidu.location.c.a f;
    public List g;
    public a h;
    public boolean i;
    public boolean j;
    public Handler l;

    /* loaded from: classes2.dex */
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, signalStrength) == null) || this.a.e == null) {
                return;
            }
            if (this.a.e.i == 'g') {
                aVar = this.a.e;
                cdmaDbm = signalStrength.getGsmSignalStrength();
            } else if (this.a.e.i != 'c') {
                return;
            } else {
                aVar = this.a.e;
                cdmaDbm = signalStrength.getCdmaDbm();
            }
            aVar.h = cdmaDbm;
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
        this.d = null;
        this.e = new com.baidu.location.c.a();
        this.f = null;
        this.g = null;
        this.h = null;
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
        r1.g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121 A[Catch: Exception -> 0x015f, TRY_LEAVE, TryCatch #0 {Exception -> 0x015f, blocks: (B:40:0x011d, B:42:0x0121), top: B:52:0x011d }] */
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
                        aVar.c = a(cellIdentity.getMcc());
                        aVar.d = a(cellIdentity.getMnc());
                        aVar.a = a(cellIdentity.getTac());
                        aVar.b = a(cellIdentity.getCi());
                        aVar.i = 'g';
                        asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    }
                    if (intValue >= 18) {
                        if (cellInfo instanceof CellInfoWcdma) {
                        }
                    }
                    aVar.g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                    return aVar;
                }
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                aVar.e = cellIdentity2.getLatitude();
                aVar.f = cellIdentity2.getLongitude();
                aVar.d = a(cellIdentity2.getSystemId());
                aVar.a = a(cellIdentity2.getNetworkId());
                aVar.b = a(cellIdentity2.getBasestationId());
                aVar.i = 'c';
                aVar.h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                com.baidu.location.c.a aVar2 = this.e;
                if (aVar2 == null || (i = aVar2.c) <= 0) {
                    i = -1;
                    try {
                        String networkOperator = this.d.getNetworkOperator();
                        if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                            int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                            if (intValue2 >= 0) {
                                i = intValue2;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                aVar.c = i;
                z = true;
                if (intValue >= 18 && !z) {
                    try {
                        if (cellInfo instanceof CellInfoWcdma) {
                            CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            aVar.c = a(cellIdentity3.getMcc());
                            aVar.d = a(cellIdentity3.getMnc());
                            aVar.a = a(cellIdentity3.getLac());
                            aVar.b = a(cellIdentity3.getCid());
                            aVar.i = 'g';
                            aVar.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                        }
                    } catch (Exception unused2) {
                    }
                }
                aVar.g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
            aVar.c = a(cellIdentity4.getMcc());
            aVar.d = a(cellIdentity4.getMnc());
            aVar.a = a(cellIdentity4.getLac());
            aVar.b = a(cellIdentity4.getCid());
            aVar.i = 'g';
            asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            aVar.h = asuLevel;
            z = true;
            if (intValue >= 18) {
            }
            aVar.g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
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
            } catch (Exception unused) {
                b = 1;
            }
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                aVar.a = gsmCellLocation.getLac();
                aVar.b = gsmCellLocation.getCid();
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
                Class cls = k;
                if (cls != null && cls.isInstance(cellLocation)) {
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
                    } catch (Exception unused3) {
                        b = 3;
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
                if (c == null) {
                    c = new b();
                }
                bVar = c;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    private void c(com.baidu.location.c.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, aVar) == null) && aVar.b()) {
            com.baidu.location.c.a aVar2 = this.e;
            if (aVar2 == null || !aVar2.a(aVar)) {
                this.e = aVar;
                if (!aVar.b()) {
                    List list = this.g;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.g.size();
                com.baidu.location.c.a aVar3 = size == 0 ? null : (com.baidu.location.c.a) this.g.get(size - 1);
                if (aVar3 != null) {
                    int i = aVar3.b;
                    com.baidu.location.c.a aVar4 = this.e;
                    if (i == aVar4.b && aVar3.a == aVar4.a) {
                        return;
                    }
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

    private String d(com.baidu.location.c.a aVar) {
        InterceptResult invokeL;
        com.baidu.location.c.a a2;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, aVar)) == null) {
            StringBuilder sb2 = new StringBuilder();
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
                try {
                    List<CellInfo> allCellInfo = this.d.getAllCellInfo();
                    if (allCellInfo != null && allCellInfo.size() > 0) {
                        sb2.append("&nc=");
                        for (CellInfo cellInfo : allCellInfo) {
                            if (!cellInfo.isRegistered() && (a2 = a(cellInfo)) != null && a2.a != -1 && a2.b != -1) {
                                if (aVar.a != a2.a) {
                                    sb = new StringBuilder();
                                    sb.append(a2.a);
                                    sb.append("|");
                                    sb.append(a2.b);
                                    sb.append("|");
                                    sb.append(a2.h);
                                    sb.append(ParamableElem.DIVIDE_PARAM);
                                } else {
                                    sb = new StringBuilder();
                                    sb.append("|");
                                    sb.append(a2.b);
                                    sb.append("|");
                                    sb.append(a2.h);
                                    sb.append(ParamableElem.DIVIDE_PARAM);
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
                        aVar.g = readLong;
                        if (aVar.b()) {
                            this.j = true;
                            this.g.add(aVar);
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
            if (this.g == null && this.f == null) {
                return;
            }
            if (this.g == null && this.f != null) {
                LinkedList linkedList = new LinkedList();
                this.g = linkedList;
                linkedList.add(this.f);
            }
            String i = k.i();
            if (i == null || this.g == null) {
                return;
            }
            File file = new File(i + File.separator + "lcvif.dat");
            int size = this.g.size();
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeLong(((com.baidu.location.c.a) this.g.get(size - 1)).g);
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
                    randomAccessFile.writeLong(((com.baidu.location.c.a) this.g.get(i3)).g);
                    randomAccessFile.writeInt(((com.baidu.location.c.a) this.g.get(i3)).c);
                    randomAccessFile.writeInt(((com.baidu.location.c.a) this.g.get(i3)).d);
                    randomAccessFile.writeInt(((com.baidu.location.c.a) this.g.get(i3)).a);
                    randomAccessFile.writeInt(((com.baidu.location.c.a) this.g.get(i3)).b);
                    if (((com.baidu.location.c.a) this.g.get(i3)).i == 'g') {
                        randomAccessFile.writeInt(1);
                    } else if (((com.baidu.location.c.a) this.g.get(i3)).i == 'c') {
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
                    cellLocation = this.d.getCellLocation();
                } catch (Throwable unused) {
                    cellLocation = null;
                }
                if (cellLocation != null) {
                    a(cellLocation);
                }
            }
        }
    }

    private com.baidu.location.c.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
                return null;
            }
            try {
                a = this.d.getSimState();
                List<CellInfo> allCellInfo = this.d.getAllCellInfo();
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
        String d;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String str = "";
            try {
                d = d(aVar);
                intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
                if (d != null && !d.equals("")) {
                    if (!d.equals("&nc=")) {
                        return d;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (intValue >= 17) {
                return d;
            }
            str = d;
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
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.a), Integer.valueOf(aVar.b), Integer.valueOf(aVar.h)));
            if (aVar.e < Integer.MAX_VALUE && (i = aVar.f) < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(i / 14400.0d), Double.valueOf(aVar.e / 14400.0d)));
            }
            stringBuffer.append("&cl_t=");
            stringBuffer.append(aVar.g);
            if (Build.VERSION.SDK_INT >= 28 && aVar.j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs=");
                stringBuffer.append(aVar.j);
            }
            try {
                if (this.g != null && this.g.size() > 0) {
                    int size = this.g.size();
                    stringBuffer.append("&clt=");
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.location.c.a aVar2 = (com.baidu.location.c.a) this.g.get(i2);
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
                            stringBuffer.append(ParamableElem.DIVIDE_PARAM);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (a > 100) {
                a = 0;
            }
            int i3 = a + (b << 8);
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
                    this.d = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
                    this.g = new LinkedList();
                    this.h = new a(this);
                    i();
                    if (this.d == null || this.h == null) {
                        return;
                    }
                    try {
                        this.d.listen(this.h, 272);
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
            TelephonyManager telephonyManager = this.d;
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
            com.baidu.location.c.a aVar2 = this.e;
            if ((aVar2 == null || !aVar2.a() || !this.e.b()) && this.d != null) {
                try {
                    k();
                } catch (Exception unused) {
                }
            }
            com.baidu.location.c.a aVar3 = this.e;
            if (aVar3 != null && aVar3.e()) {
                this.f = null;
                com.baidu.location.c.a aVar4 = this.e;
                this.f = new com.baidu.location.c.a(aVar4.a, aVar4.b, aVar4.c, aVar4.d, aVar4.h, aVar4.i, aVar4.j);
            }
            com.baidu.location.c.a aVar5 = this.e;
            if (aVar5 != null && aVar5.d() && (aVar = this.f) != null) {
                com.baidu.location.c.a aVar6 = this.e;
                if (aVar6.i == 'g') {
                    aVar6.d = aVar.d;
                    aVar6.c = aVar.c;
                }
            }
            return this.e;
        }
        return (com.baidu.location.c.a) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = -1;
            try {
                if (this.d != null) {
                    i = this.d.getSimState();
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
