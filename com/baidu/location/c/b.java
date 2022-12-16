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
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public static b c;
    public static String n;
    public static Class<?> o;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public TelephonyManager d;
    public TelephonyManager e;
    public TelephonyManager f;
    public SubscriptionManager g;
    public com.baidu.location.c.a h;
    public com.baidu.location.c.a i;
    public List<com.baidu.location.c.a> j;
    public d k;
    public boolean l;
    public boolean m;
    public a p;
    public C0117b q;
    public c r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public long x;
    public final Object y;
    public Handler z;

    /* renamed from: com.baidu.location.c.b$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class a extends TelephonyManager.CellInfoCallback {
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

        public /* synthetic */ a(b bVar, AnonymousClass1 anonymousClass1) {
            this(bVar);
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            this.a.n();
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onError(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, th) == null) || th == null) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: com.baidu.location.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0117b extends TelephonyManager.CellInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0117b(b bVar) {
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

        public /* synthetic */ C0117b(b bVar, AnonymousClass1 anonymousClass1) {
            this(bVar);
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            if (this.a.t) {
                b bVar = this.a;
                bVar.s = !bVar.s;
            }
            if (!this.a.t || this.a.s) {
                this.a.n();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends TelephonyManager.CellInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
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

        public /* synthetic */ c(b bVar, AnonymousClass1 anonymousClass1) {
            this(bVar);
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            if (this.a.t) {
                b bVar = this.a;
                bVar.s = !bVar.s;
            }
            if (!this.a.t || this.a.s) {
                this.a.n();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
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
        public void onCellInfoChanged(List<CellInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            this.a.z.post(new com.baidu.location.c.c(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.baidu.location.c.a aVar;
            int cdmaDbm;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, signalStrength) == null) || this.a.h == null) {
                return;
            }
            if (this.a.h.i == 'g') {
                aVar = this.a.h;
                cdmaDbm = signalStrength.getGsmSignalStrength();
            } else if (this.a.h.i != 'c') {
                return;
            } else {
                aVar = this.a.h;
                cdmaDbm = signalStrength.getCdmaDbm();
            }
            aVar.h = cdmaDbm;
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements Comparator<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gVar, gVar2)) == null) ? gVar.g - gVar2.g : invokeLL.intValue;
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
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = new com.baidu.location.c.a();
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.s = true;
        this.t = false;
        this.u = false;
        this.v = -1;
        this.w = -1;
        this.x = 0L;
        this.y = new Object();
        this.z = new Handler();
        this.A = false;
        this.B = 30;
        if (Build.VERSION.SDK_INT >= 30) {
            this.A = com.baidu.location.e.k.b("android.telephony.TelephonyManager$CellInfoCallback");
        }
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static int a(CellIdentityNr cellIdentityNr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cellIdentityNr)) == null) {
            try {
                return com.baidu.location.e.k.a(cellIdentityNr, "getHwTac");
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null || !str.contains("mNrTac")) {
                return -1;
            }
            Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(" ", ""));
            while (true) {
                int i = -1;
                while (matcher.find()) {
                    if (matcher.groupCount() >= 1) {
                        try {
                            i = Integer.parseInt(matcher.group(1));
                        } catch (Throwable unused) {
                        }
                    }
                }
                return i;
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006a, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006c, code lost:
        r4.j = r18.getCellConnectionStatus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ec, code lost:
        if (r0 < 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ef, code lost:
        if (r0 > 0) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0136, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L11;
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.location.c.a a(CellInfo cellInfo, com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        InterceptResult invokeLLL;
        boolean z;
        int i;
        long elapsedRealtimeNanos;
        long currentTimeMillis;
        int cellConnectionStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cellInfo, aVar, telephonyManager)) == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if (intValue < 17) {
                return null;
            }
            com.baidu.location.c.a aVar2 = new com.baidu.location.c.a();
            if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                aVar2.c = a(cellIdentity.getMcc());
                aVar2.d = a(cellIdentity.getMnc());
                aVar2.a = a(cellIdentity.getLac());
                aVar2.b = a(cellIdentity.getCid());
                aVar2.i = 'g';
                aVar2.h = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                aVar2.k = 2;
            } else {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                    aVar2.e = cellIdentity2.getLatitude();
                    aVar2.f = cellIdentity2.getLongitude();
                    aVar2.d = a(cellIdentity2.getSystemId());
                    aVar2.a = a(cellIdentity2.getNetworkId());
                    aVar2.b = a(cellIdentity2.getBasestationId());
                    aVar2.i = 'c';
                    aVar2.h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    aVar2.k = 1;
                    if (Build.VERSION.SDK_INT >= 28) {
                        aVar2.j = cellInfo.getCellConnectionStatus();
                    }
                    if (aVar == null || (i = aVar.c) <= 0) {
                        try {
                            String networkOperator = telephonyManager.getNetworkOperator();
                            if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                                i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                        i = -1;
                    }
                    aVar2.c = i;
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    aVar2.c = a(cellIdentity3.getMcc());
                    aVar2.d = a(cellIdentity3.getMnc());
                    aVar2.a = a(cellIdentity3.getTac());
                    aVar2.b = a(cellIdentity3.getCi());
                    aVar2.i = 'g';
                    aVar2.h = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    aVar2.k = 3;
                } else {
                    z = false;
                }
                z = true;
            }
            if (intValue >= 18 && !z) {
                try {
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                        aVar2.c = a(cellIdentity4.getMcc());
                        aVar2.d = a(cellIdentity4.getMnc());
                        aVar2.a = a(cellIdentity4.getLac());
                        aVar2.b = a(cellIdentity4.getCid());
                        aVar2.i = 'g';
                        aVar2.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                        aVar2.k = 4;
                        if (Build.VERSION.SDK_INT >= 28) {
                            cellConnectionStatus = cellInfo.getCellConnectionStatus();
                        }
                    } else if (Build.VERSION.SDK_INT >= 29) {
                        if (cellInfo instanceof CellInfoTdscdma) {
                            CellIdentityTdscdma cellIdentity5 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                            if (cellIdentity5.getMccString() != null) {
                                try {
                                    aVar2.c = Integer.valueOf(cellIdentity5.getMccString()).intValue();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (cellIdentity5.getMncString() != null) {
                                try {
                                    aVar2.d = Integer.valueOf(cellIdentity5.getMncString()).intValue();
                                } catch (Throwable unused3) {
                                }
                            }
                            aVar2.a = a(cellIdentity5.getLac());
                            aVar2.b = a(cellIdentity5.getCid());
                            aVar2.i = 'g';
                            aVar2.h = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getAsuLevel();
                            aVar2.k = 5;
                            if (Build.VERSION.SDK_INT >= 28) {
                                cellConnectionStatus = cellInfo.getCellConnectionStatus();
                            }
                        } else if (cellInfo instanceof CellInfoNr) {
                            CellIdentityNr cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                            if (cellIdentityNr != null) {
                                if (cellIdentityNr.getMccString() != null) {
                                    try {
                                        aVar2.c = Integer.valueOf(cellIdentityNr.getMccString()).intValue();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                if (cellIdentityNr.getMncString() != null) {
                                    try {
                                        aVar2.d = Integer.valueOf(cellIdentityNr.getMncString()).intValue();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                int a2 = a(cellIdentityNr.getTac());
                                aVar2.a = a2;
                                if (a2 == -1) {
                                    try {
                                        aVar2.a = a(a(cellIdentityNr));
                                    } catch (Throwable unused6) {
                                    }
                                }
                                if (aVar2.a == -1) {
                                    try {
                                        aVar2.a = a(a(cellIdentityNr.toString()));
                                    } catch (Throwable unused7) {
                                    }
                                }
                                if (aVar2.a == -1) {
                                    aVar2.a = cellIdentityNr.getTac();
                                }
                                if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                    aVar2.b = cellIdentityNr.getNci();
                                }
                                aVar2.i = 'g';
                                aVar2.k = 6;
                                if (Build.VERSION.SDK_INT >= 28) {
                                    aVar2.j = cellInfo.getCellConnectionStatus();
                                }
                                CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                if (aVar2.b()) {
                                    aVar2.o = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                }
                            }
                        }
                    }
                    aVar2.j = cellConnectionStatus;
                } catch (Exception unused8) {
                }
            }
            try {
                if (intValue >= 30) {
                    elapsedRealtimeNanos = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                    currentTimeMillis = System.currentTimeMillis();
                } else {
                    elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                    currentTimeMillis = System.currentTimeMillis();
                }
                aVar2.g = currentTimeMillis - elapsedRealtimeNanos;
            } catch (Error unused9) {
                aVar2.g = System.currentTimeMillis();
            }
            return aVar2;
        }
        return (com.baidu.location.c.a) invokeLLL.objValue;
    }

    private com.baidu.location.c.a a(CellLocation cellLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, cellLocation)) == null) ? a(cellLocation, false) : (com.baidu.location.c.a) invokeL.objValue;
    }

    private com.baidu.location.c.a a(CellLocation cellLocation, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, this, cellLocation, z)) == null) {
            if (cellLocation == null || this.d == null) {
                return null;
            }
            com.baidu.location.c.a aVar = new com.baidu.location.c.a();
            aVar.l = 1;
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
                        aVar.c = i < 0 ? this.h.c : i;
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
                        i = this.h.d;
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
                if (o == null) {
                    try {
                        o = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    } catch (Exception unused2) {
                        o = null;
                        return aVar;
                    }
                }
                Class<?> cls = o;
                if (cls != null && cls.isInstance(cellLocation)) {
                    try {
                        int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                        if (systemId < 0) {
                            systemId = this.h.d;
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

    @SuppressLint({"NewApi"})
    public static com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, aVar, telephonyManager, z)) == null) {
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
                return null;
            }
            try {
                a = telephonyManager.getSimState();
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo == null || allCellInfo.size() <= 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                com.baidu.location.c.a aVar2 = null;
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo.isRegistered()) {
                        boolean z2 = aVar2 != null;
                        com.baidu.location.c.a a2 = a(cellInfo, aVar, telephonyManager);
                        if (a2 != null) {
                            if (!a2.b()) {
                                a2 = null;
                            } else if (z2 && aVar2 != null) {
                                aVar2.m = a2.i();
                                aVar2.n = a2.g();
                            }
                            if (aVar2 == null) {
                                aVar2 = a2;
                            }
                        }
                    }
                }
                n = a(b(arrayList));
                return aVar2;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (com.baidu.location.c.a) invokeLLZ.objValue;
    }

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:159:0x0185 */
    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: android.telephony.TelephonyManager */
    /* JADX WARN: Multi-variable type inference failed */
    public static g a(CellInfo cellInfo, TelephonyManager telephonyManager) {
        InterceptResult invokeLL;
        i iVar;
        long elapsedRealtime;
        long currentTimeMillis;
        long elapsedRealtimeNanos;
        long currentTimeMillis2;
        long elapsedRealtimeNanos2;
        long currentTimeMillis3;
        long elapsedRealtimeNanos3;
        long currentTimeMillis4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cellInfo, telephonyManager)) == null) {
            int i = Build.VERSION.SDK_INT;
            h hVar = null;
            CellIdentityNr cellIdentityNr = null;
            if (i < 17) {
                return null;
            }
            try {
                if (cellInfo instanceof CellInfoGsm) {
                    g gVar = new g();
                    CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                    gVar.a = 1;
                    if (cellInfo.isRegistered()) {
                        gVar.d = 1;
                    }
                    if (i >= 28) {
                        gVar.b = cellIdentity.getMccString();
                        gVar.c = cellIdentity.getMncString();
                        gVar.f = cellInfo.getCellConnectionStatus();
                    } else {
                        gVar.b = cellIdentity.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity.getMcc());
                        gVar.c = cellIdentity.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity.getMnc()) : null;
                    }
                    if (i >= 30) {
                        elapsedRealtimeNanos3 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                        currentTimeMillis4 = System.currentTimeMillis();
                    } else {
                        elapsedRealtimeNanos3 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                        currentTimeMillis4 = System.currentTimeMillis();
                    }
                    gVar.e = currentTimeMillis4 - elapsedRealtimeNanos3;
                    iVar = gVar;
                } else if (cellInfo instanceof CellInfoCdma) {
                    g gVar2 = new g();
                    CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                    gVar2.a = 2;
                    gVar2.c = cellIdentity2.getSystemId() != Integer.MAX_VALUE ? String.valueOf(cellIdentity2.getSystemId()) : null;
                    if (cellInfo.isRegistered()) {
                        gVar2.d = 1;
                    }
                    if (i >= 28) {
                        gVar2.f = cellInfo.getCellConnectionStatus();
                    }
                    try {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                            gVar2.b = networkOperator.substring(0, 3);
                        }
                    } catch (Exception unused) {
                    }
                    try {
                        if (i >= 30) {
                            elapsedRealtimeNanos2 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                            currentTimeMillis3 = System.currentTimeMillis();
                        } else {
                            elapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                            currentTimeMillis3 = System.currentTimeMillis();
                        }
                        gVar2.e = currentTimeMillis3 - elapsedRealtimeNanos2;
                    } catch (Error unused2) {
                        gVar2.e = System.currentTimeMillis();
                    }
                    return gVar2;
                } else if (!(cellInfo instanceof CellInfoWcdma)) {
                    try {
                        if (cellInfo instanceof CellInfoTdscdma) {
                            if (i < 28) {
                                return null;
                            }
                            g gVar3 = new g();
                            CellIdentityTdscdma cellIdentity3 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                            gVar3.a = 5;
                            if (cellInfo.isRegistered()) {
                                gVar3.d = 1;
                            }
                            gVar3.b = cellIdentity3.getMccString();
                            gVar3.c = cellIdentity3.getMncString();
                            gVar3.f = cellInfo.getCellConnectionStatus();
                            if (i >= 30) {
                                elapsedRealtime = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                                currentTimeMillis = System.currentTimeMillis();
                                hVar = gVar3;
                            } else {
                                elapsedRealtime = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                                currentTimeMillis = System.currentTimeMillis();
                                hVar = gVar3;
                            }
                        } else if (cellInfo instanceof CellInfoLte) {
                            h hVar2 = new h();
                            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                            CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                            CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                            hVar2.a = 3;
                            if (cellInfo.isRegistered()) {
                                hVar2.d = 1;
                            }
                            hVar2.h = cellIdentity4.getCi();
                            hVar2.i = cellIdentity4.getPci();
                            hVar2.j = cellIdentity4.getTac();
                            hVar2.r = cellSignalStrength.getTimingAdvance();
                            if (i >= 28) {
                                hVar2.b = cellIdentity4.getMccString();
                                hVar2.c = cellIdentity4.getMncString();
                                hVar2.f = cellInfo.getCellConnectionStatus();
                                hVar2.l = cellIdentity4.getBandwidth();
                            } else {
                                if (cellIdentity4.getMcc() != Integer.MAX_VALUE) {
                                    hVar2.b = String.valueOf(cellIdentity4.getMcc());
                                }
                                if (cellIdentity4.getMnc() != Integer.MAX_VALUE) {
                                    hVar2.c = String.valueOf(cellIdentity4.getMnc());
                                }
                            }
                            if (i >= 24) {
                                hVar2.k = cellIdentity4.getEarfcn();
                            }
                            if (i >= 29) {
                                hVar2.m = Math.abs(cellSignalStrength.getRssi());
                            }
                            if (i >= 26) {
                                hVar2.n = Math.abs(cellSignalStrength.getRsrp());
                                hVar2.g = Math.abs(cellSignalStrength.getRsrp());
                                hVar2.o = cellSignalStrength.getRsrq();
                                hVar2.p = cellSignalStrength.getRssnr();
                                hVar2.q = cellSignalStrength.getCqi();
                            }
                            elapsedRealtime = i >= 30 ? SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis() : (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                            currentTimeMillis = System.currentTimeMillis();
                            hVar = hVar2;
                        } else if (!(cellInfo instanceof CellInfoNr) || i < 29) {
                            return null;
                        } else {
                            i iVar2 = new i();
                            try {
                                cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                            if (cellIdentityNr != null) {
                                iVar2.a = 6;
                                iVar2.b = cellIdentityNr.getMccString();
                                iVar2.c = cellIdentityNr.getMncString();
                                iVar2.h = cellIdentityNr.getNci();
                                iVar2.i = cellIdentityNr.getPci();
                                int tac = cellIdentityNr.getTac();
                                iVar2.j = tac;
                                if (tac == Integer.MAX_VALUE) {
                                    try {
                                        iVar2.j = a(cellIdentityNr);
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (iVar2.j == Integer.MAX_VALUE) {
                                    try {
                                        iVar2.j = a(cellIdentityNr.toString());
                                    } catch (Throwable unused4) {
                                    }
                                }
                                iVar2.k = cellIdentityNr.getNrarfcn();
                            }
                            if (cellInfo.isRegistered()) {
                                iVar2.d = 1;
                            }
                            iVar2.f = cellInfo.getCellConnectionStatus();
                            iVar2.l = Math.abs(cellSignalStrengthNr.getSsRsrp());
                            iVar2.g = Math.abs(cellSignalStrengthNr.getSsRsrp());
                            iVar2.m = cellSignalStrengthNr.getSsRsrq();
                            iVar2.n = cellSignalStrengthNr.getSsSinr();
                            iVar2.o = Math.abs(cellSignalStrengthNr.getCsiRsrp());
                            iVar2.p = cellSignalStrengthNr.getCsiRsrq();
                            iVar2.q = cellSignalStrengthNr.getCsiSinr();
                            iVar2.e = System.currentTimeMillis() - (i >= 30 ? SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis() : (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                            iVar = iVar2;
                        }
                        hVar.e = currentTimeMillis - elapsedRealtime;
                        return hVar;
                    } catch (Error unused5) {
                        hVar.e = System.currentTimeMillis();
                        return hVar;
                    }
                } else {
                    g gVar4 = new g();
                    CellIdentityWcdma cellIdentity5 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    gVar4.a = 4;
                    if (cellInfo.isRegistered()) {
                        gVar4.d = 1;
                    }
                    if (i >= 28) {
                        gVar4.b = cellIdentity5.getMccString();
                        gVar4.c = cellIdentity5.getMncString();
                        gVar4.f = cellInfo.getCellConnectionStatus();
                    } else {
                        gVar4.b = cellIdentity5.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity5.getMcc());
                        gVar4.c = cellIdentity5.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity5.getMnc()) : null;
                    }
                    if (i >= 30) {
                        elapsedRealtimeNanos = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                        currentTimeMillis2 = System.currentTimeMillis();
                    } else {
                        elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                        currentTimeMillis2 = System.currentTimeMillis();
                    }
                    gVar4.e = currentTimeMillis2 - elapsedRealtimeNanos;
                    iVar = gVar4;
                }
            } catch (Error unused6) {
                telephonyManager.e = System.currentTimeMillis();
                iVar = telephonyManager;
            }
            return iVar;
        }
        return (g) invokeLL.objValue;
    }

    public static String a(List<g> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, list)) == null) {
            if (list == null || list.size() == 0) {
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static List<g> b(List<g> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, list)) == null) {
            if (list.size() == 0) {
                return null;
            }
            if (list.size() == 1) {
                return list;
            }
            Collections.sort(list.subList(1, list.size()), new e(null));
            return list.subList(0, list.size());
        }
        return (List) invokeL.objValue;
    }

    private void c(com.baidu.location.c.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, this, aVar) == null) && aVar.b()) {
            com.baidu.location.c.a aVar2 = this.h;
            if (aVar2 == null || !aVar2.a(aVar)) {
                this.h = aVar;
                if (!aVar.b()) {
                    List<com.baidu.location.c.a> list = this.j;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.j.size();
                com.baidu.location.c.a aVar3 = size == 0 ? null : this.j.get(size - 1);
                if (aVar3 != null) {
                    long j = aVar3.b;
                    com.baidu.location.c.a aVar4 = this.h;
                    if (j == aVar4.b && aVar3.a == aVar4.a) {
                        return;
                    }
                }
                this.j.add(this.h);
                if (this.j.size() > 3) {
                    this.j.remove(0);
                }
                k();
                this.m = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private String d(com.baidu.location.c.a aVar) {
        InterceptResult invokeL;
        com.baidu.location.c.a a2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, aVar)) == null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = null;
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
                try {
                    List<CellInfo> allCellInfo = this.d.getAllCellInfo();
                    if (allCellInfo != null && allCellInfo.size() > 0) {
                        sb.append("&nc=");
                        for (CellInfo cellInfo : allCellInfo) {
                            if (!cellInfo.isRegistered() && (a2 = a(cellInfo, this.h, this.d)) != null) {
                                if (a2.a != -1 && a2.b != -1) {
                                    if (aVar != null && aVar.a == a2.a) {
                                        str = "|" + a2.b + "|" + a2.h + ";";
                                        sb.append(str);
                                    }
                                    str = a2.a + "|" + a2.b + "|" + a2.h + ";";
                                    sb.append(str);
                                }
                                if (Build.VERSION.SDK_INT > 28 && a2.k == 6 && a2.o != null && a2.b()) {
                                    if (sb2 == null) {
                                        StringBuilder sb3 = new StringBuilder();
                                        try {
                                            sb3.append("&ncnr=");
                                            sb2 = sb3;
                                        } catch (Throwable unused) {
                                            sb2 = sb3;
                                        }
                                    }
                                    sb2.append(a2.g());
                                    sb2.append("_");
                                    sb2.append(a2.o);
                                    sb2.append(";");
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (sb2 != null) {
                return sb.toString() + sb2.toString();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            String str = n;
            if (str == null || str.length() == 0) {
                return null;
            }
            return n.replace("\n", "");
        }
        return (String) invokeV.objValue;
    }

    private void j() {
        String f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (f = com.baidu.location.e.k.f()) == null) {
            return;
        }
        File file = new File(f + File.separator + "lcvif2.dat");
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
                    long readLong2 = randomAccessFile.readLong();
                    int readInt4 = randomAccessFile.readInt();
                    char c2 = readInt4 == 1 ? 'g' : (char) 0;
                    if (readInt4 == 2) {
                        c2 = 'c';
                    }
                    if (readLong != j) {
                        com.baidu.location.c.a aVar = new com.baidu.location.c.a(readInt3, readLong2, readInt, readInt2, 0, c2, -1);
                        aVar.g = readLong;
                        if (aVar.b()) {
                            this.m = true;
                            this.j.add(aVar);
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

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (this.j == null && this.i == null) {
                return;
            }
            if (this.j == null && this.i != null) {
                LinkedList linkedList = new LinkedList();
                this.j = linkedList;
                linkedList.add(this.i);
            }
            String f = com.baidu.location.e.k.f();
            if (f == null || this.j == null) {
                return;
            }
            File file = new File(f + File.separator + "lcvif2.dat");
            int size = this.j.size();
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeLong(this.j.get(size - 1).g);
                randomAccessFile.writeInt(size);
                for (int i = 0; i < 3 - size; i++) {
                    randomAccessFile.writeLong(0L);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeLong(-1L);
                    randomAccessFile.writeInt(2);
                }
                for (int i2 = 0; i2 < size; i2++) {
                    randomAccessFile.writeLong(this.j.get(i2).g);
                    randomAccessFile.writeInt(this.j.get(i2).c);
                    randomAccessFile.writeInt(this.j.get(i2).d);
                    randomAccessFile.writeInt(this.j.get(i2).a);
                    randomAccessFile.writeLong(this.j.get(i2).b);
                    if (this.j.get(i2).i == 'g') {
                        randomAccessFile.writeInt(1);
                    } else if (this.j.get(i2).i == 'c') {
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

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            if (this.p == null) {
                this.p = new a(this, null);
            }
            this.d.requestCellInfoUpdate(com.baidu.location.f.getServiceContext().getMainExecutor(), this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        CellLocation cellLocation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            synchronized (this) {
                com.baidu.location.c.a a2 = a(this.h, this.d, false);
                if (a2 != null) {
                    c(a2);
                }
                if (Build.VERSION.SDK_INT <= 28 && (a2 == null || !a2.b())) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            try {
                m();
                synchronized (this.y) {
                    this.y.notifyAll();
                }
            } catch (Exception unused) {
            }
        }
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
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h)));
            if (aVar.e < Integer.MAX_VALUE && (i = aVar.f) < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(i / 14400.0d), Double.valueOf(aVar.e / 14400.0d)));
            }
            stringBuffer.append("&cl_t=");
            stringBuffer.append(aVar.g);
            stringBuffer.append("&cl_api=");
            stringBuffer.append(aVar.l);
            stringBuffer.append("&clp=");
            stringBuffer.append(aVar.k);
            if (aVar.o != null) {
                stringBuffer.append("&clnrs=");
                stringBuffer.append(aVar.o);
            }
            if (Build.VERSION.SDK_INT >= 28 && aVar.j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs=");
                stringBuffer.append(aVar.j);
            }
            try {
                if (this.j != null && this.j.size() > 0) {
                    int size = this.j.size();
                    stringBuffer.append("&clt=");
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.location.c.a aVar2 = this.j.get(i2);
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
                            stringBuffer.append(";");
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
            String str = aVar.m;
            if (str != null) {
                stringBuffer.append(str);
            }
            stringBuffer.append("&cl_list=");
            stringBuffer.append(i());
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.l) {
                    return;
                }
                if (com.baidu.location.f.isServing) {
                    this.d = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
                    this.j = new LinkedList();
                    this.k = new d(this);
                    j();
                    if (this.d != null && this.k != null) {
                        if (Build.VERSION.SDK_INT < this.B || !this.A) {
                            try {
                                this.d.listen(this.k, 1280);
                            } catch (Exception unused) {
                            }
                        }
                        this.l = true;
                    }
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.l) {
                    if (this.k != null && this.d != null) {
                        this.d.listen(this.k, 0);
                    }
                    this.k = null;
                    this.d = null;
                    this.e = null;
                    this.f = null;
                    this.j.clear();
                    this.j = null;
                    k();
                    this.l = false;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.booleanValue;
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

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0111, code lost:
        if (r0 != false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:23:0x0045, B:25:0x0049, B:26:0x0058, B:28:0x0068, B:30:0x006b, B:33:0x0071, B:35:0x0074, B:36:0x0076, B:38:0x007c, B:40:0x0082, B:42:0x0087, B:44:0x008d, B:46:0x0091, B:47:0x0097, B:51:0x00a7, B:53:0x00ab, B:54:0x00b2, B:56:0x00b6, B:58:0x00c9, B:60:0x00cf, B:62:0x00d3, B:63:0x00d9, B:67:0x00e9, B:69:0x00ed, B:70:0x00f4, B:72:0x00f8, B:74:0x010b, B:64:0x00dc, B:66:0x00e0, B:73:0x0109, B:48:0x009a, B:50:0x009e, B:57:0x00c7, B:41:0x0085), top: B:112:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6 A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:23:0x0045, B:25:0x0049, B:26:0x0058, B:28:0x0068, B:30:0x006b, B:33:0x0071, B:35:0x0074, B:36:0x0076, B:38:0x007c, B:40:0x0082, B:42:0x0087, B:44:0x008d, B:46:0x0091, B:47:0x0097, B:51:0x00a7, B:53:0x00ab, B:54:0x00b2, B:56:0x00b6, B:58:0x00c9, B:60:0x00cf, B:62:0x00d3, B:63:0x00d9, B:67:0x00e9, B:69:0x00ed, B:70:0x00f4, B:72:0x00f8, B:74:0x010b, B:64:0x00dc, B:66:0x00e0, B:73:0x0109, B:48:0x009a, B:50:0x009e, B:57:0x00c7, B:41:0x0085), top: B:112:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ed A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:23:0x0045, B:25:0x0049, B:26:0x0058, B:28:0x0068, B:30:0x006b, B:33:0x0071, B:35:0x0074, B:36:0x0076, B:38:0x007c, B:40:0x0082, B:42:0x0087, B:44:0x008d, B:46:0x0091, B:47:0x0097, B:51:0x00a7, B:53:0x00ab, B:54:0x00b2, B:56:0x00b6, B:58:0x00c9, B:60:0x00cf, B:62:0x00d3, B:63:0x00d9, B:67:0x00e9, B:69:0x00ed, B:70:0x00f4, B:72:0x00f8, B:74:0x010b, B:64:0x00dc, B:66:0x00e0, B:73:0x0109, B:48:0x009a, B:50:0x009e, B:57:0x00c7, B:41:0x0085), top: B:112:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f8 A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:23:0x0045, B:25:0x0049, B:26:0x0058, B:28:0x0068, B:30:0x006b, B:33:0x0071, B:35:0x0074, B:36:0x0076, B:38:0x007c, B:40:0x0082, B:42:0x0087, B:44:0x008d, B:46:0x0091, B:47:0x0097, B:51:0x00a7, B:53:0x00ab, B:54:0x00b2, B:56:0x00b6, B:58:0x00c9, B:60:0x00cf, B:62:0x00d3, B:63:0x00d9, B:67:0x00e9, B:69:0x00ed, B:70:0x00f4, B:72:0x00f8, B:74:0x010b, B:64:0x00dc, B:66:0x00e0, B:73:0x0109, B:48:0x009a, B:50:0x009e, B:57:0x00c7, B:41:0x0085), top: B:112:0x0045 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.location.c.a f() {
        InterceptResult invokeV;
        TelephonyManager createForSubscriptionId;
        TelephonyManager createForSubscriptionId2;
        com.baidu.location.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.baidu.location.c.a aVar2 = this.h;
            if ((aVar2 == null || !aVar2.a() || !this.h.b()) && this.d != null) {
                try {
                    m();
                    if (Build.VERSION.SDK_INT >= 29 && this.A && System.currentTimeMillis() - this.x > 30000) {
                        this.x = System.currentTimeMillis();
                        if (this.u) {
                            boolean z = false;
                            try {
                                if (this.g == null) {
                                    this.g = (SubscriptionManager) com.baidu.location.f.getServiceContext().getSystemService("telephony_subscription_service");
                                }
                                int[] subscriptionIds = this.g.getSubscriptionIds(0);
                                int[] subscriptionIds2 = this.g.getSubscriptionIds(1);
                                int i = -1;
                                int i2 = (subscriptionIds == null || subscriptionIds.length <= 0) ? -1 : subscriptionIds[0];
                                if (subscriptionIds2 != null && subscriptionIds2.length > 0) {
                                    i = subscriptionIds2[0];
                                }
                                if (SubscriptionManager.isValidSubscriptionId(i2) && SubscriptionManager.isValidSubscriptionId(i)) {
                                    this.t = true;
                                } else {
                                    this.t = false;
                                }
                                if (SubscriptionManager.isValidSubscriptionId(i2)) {
                                    if (this.e == null) {
                                        createForSubscriptionId2 = this.d.createForSubscriptionId(i2);
                                    } else {
                                        if (this.v != i2) {
                                            this.e = null;
                                            createForSubscriptionId2 = this.d.createForSubscriptionId(i2);
                                        }
                                        if (this.q == null) {
                                            this.q = new C0117b(this, null);
                                        }
                                        if (this.e != null) {
                                            this.e.requestCellInfoUpdate(com.baidu.location.f.getServiceContext().getMainExecutor(), this.q);
                                            z = true;
                                        }
                                    }
                                    this.e = createForSubscriptionId2;
                                    if (this.q == null) {
                                    }
                                    if (this.e != null) {
                                    }
                                } else {
                                    this.e = null;
                                }
                                if (SubscriptionManager.isValidSubscriptionId(i)) {
                                    if (this.f == null) {
                                        createForSubscriptionId = this.d.createForSubscriptionId(i);
                                    } else {
                                        if (this.w != i) {
                                            this.f = null;
                                            createForSubscriptionId = this.d.createForSubscriptionId(i);
                                        }
                                        if (this.r == null) {
                                            this.r = new c(this, null);
                                        }
                                        if (this.f != null) {
                                            this.f.requestCellInfoUpdate(com.baidu.location.f.getServiceContext().getMainExecutor(), this.r);
                                            z = true;
                                        }
                                    }
                                    this.f = createForSubscriptionId;
                                    if (this.r == null) {
                                    }
                                    if (this.f != null) {
                                    }
                                } else {
                                    this.f = null;
                                }
                                this.v = i2;
                                this.w = i;
                            } catch (Exception unused) {
                            }
                        }
                        l();
                        synchronized (this.y) {
                            try {
                                this.y.wait(100);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                } catch (Exception unused3) {
                }
            }
            com.baidu.location.c.a aVar3 = this.h;
            if (aVar3 != null && aVar3.e()) {
                this.i = null;
                this.i = new com.baidu.location.c.a(this.h);
            }
            com.baidu.location.c.a aVar4 = this.h;
            if (aVar4 != null && aVar4.d() && (aVar = this.i) != null) {
                com.baidu.location.c.a aVar5 = this.h;
                if (aVar5.i == 'g') {
                    aVar5.d = aVar.d;
                    aVar5.c = aVar.c;
                }
            }
            return this.h;
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
