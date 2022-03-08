package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
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
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static Class<?> f33592i;
    public static char[] r;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f33593b;

    /* renamed from: c  reason: collision with root package name */
    public b f33594c;

    /* renamed from: d  reason: collision with root package name */
    public Context f33595d;

    /* renamed from: e  reason: collision with root package name */
    public TelephonyManager f33596e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.location.c.a f33597f;

    /* renamed from: g  reason: collision with root package name */
    public WifiManager f33598g;

    /* renamed from: h  reason: collision with root package name */
    public C1805c f33599h;

    /* renamed from: j  reason: collision with root package name */
    public String f33600j;
    public String k;
    public LocationClientOption l;
    public a m;
    public String n;
    public String o;
    public String p;
    public boolean q;
    public long s;
    public boolean t;

    /* loaded from: classes4.dex */
    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* loaded from: classes4.dex */
    public class b extends com.baidu.location.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33601b;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33601b = cVar;
            this.a = null;
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33794h = com.baidu.location.e.k.e();
                if (this.f33601b.o != null && this.f33601b.p != null) {
                    this.a += String.format(Locale.CHINA, "&ki=%s&sn=%s", this.f33601b.o, this.f33601b.p);
                }
                String str = this.a + "&enc=2";
                this.a = str;
                String encodeTp4 = Jni.encodeTp4(str);
                this.a = null;
                this.k.put(BaseLocationBox.TYPE, encodeTp4);
                this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a = str;
                b(com.baidu.location.e.k.f33806f);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
            r5 = r4.f33796j;
         */
        @Override // com.baidu.location.e.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            String str;
            BDLocation bDLocation;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z && str != null) {
                    try {
                        if (str.contains("\"enc\"")) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("enc")) {
                                    str = j.a().a(jSONObject.getString("enc"));
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            bDLocation = new BDLocation(str);
                        } catch (Exception unused) {
                            bDLocation = new BDLocation();
                            bDLocation.setLocType(63);
                        }
                        if (bDLocation.getLocType() == 161) {
                            bDLocation.setCoorType(this.f33601b.l.coorType);
                            bDLocation.setLocationID(Jni.en1(this.f33601b.a + ";" + this.f33601b.f33593b + ";" + bDLocation.getTime()));
                            bDLocation.setRoadLocString(0.0f, 0.0f);
                            this.f33601b.t = true;
                            this.f33601b.m.onReceiveLocation(bDLocation);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                Map<String, Object> map = this.k;
                if (map != null) {
                    map.clear();
                }
            }
        }
    }

    /* renamed from: com.baidu.location.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1805c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ScanResult> a;

        /* renamed from: b  reason: collision with root package name */
        public String f33602b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33603c;

        /* renamed from: d  reason: collision with root package name */
        public long f33604d;

        /* renamed from: e  reason: collision with root package name */
        public String f33605e;

        public C1805c(c cVar, List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33603c = cVar;
            this.a = null;
            this.f33604d = 0L;
            this.f33602b = null;
            this.f33605e = null;
            this.a = list;
            this.f33604d = System.currentTimeMillis();
            try {
                b();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        private void b() {
            /*
                r7 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.location.b.c.C1805c.$ic
                if (r0 != 0) goto L63
            L4:
                int r0 = r7.a()
                r1 = 1
                if (r0 >= r1) goto Lc
                return
            Lc:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.a
                int r0 = r0.size()
                int r0 = r0 - r1
                r2 = 1
            L14:
                if (r0 < r1) goto L62
                if (r2 == 0) goto L62
                r2 = 0
                r3 = 0
            L1a:
                if (r2 >= r0) goto L5e
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                java.lang.Object r4 = r4.get(r2)
                if (r4 == 0) goto L5b
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                int r5 = r2 + 1
                java.lang.Object r4 = r4.get(r5)
                if (r4 == 0) goto L5b
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r6 = r7.a
                java.lang.Object r6 = r6.get(r5)
                android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
                int r6 = r6.level
                if (r4 >= r6) goto L5b
                java.util.List<android.net.wifi.ScanResult> r3 = r7.a
                java.lang.Object r3 = r3.get(r5)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                java.lang.Object r6 = r4.get(r2)
                r4.set(r5, r6)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.a
                r4.set(r2, r3)
                r3 = 1
            L5b:
                int r2 = r2 + 1
                goto L1a
            L5e:
                int r0 = r0 + (-1)
                r2 = r3
                goto L14
            L62:
                return
            L63:
                r5 = r0
                r6 = 65537(0x10001, float:9.1837E-41)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r5.invokeV(r6, r7)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.c.C1805c.b():void");
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<ScanResult> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00f6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x00e8 A[EDGE_INSN: B:91:0x00e8->B:53:0x00e8 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String a(int i2, String str) {
            InterceptResult invokeIL;
            long j2;
            boolean z;
            int size;
            int i3;
            boolean z2;
            String str2;
            int i4;
            String str3;
            long j3;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) != null) {
                return (String) invokeIL.objValue;
            }
            String str4 = str;
            if (a() < 2) {
                return null;
            }
            ArrayList<Long> arrayList = new ArrayList();
            int i6 = 1;
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    j2 = SystemClock.elapsedRealtimeNanos() / 1000;
                } catch (Error unused) {
                    j2 = 0;
                }
                if (j2 > 0) {
                    z = true;
                    StringBuffer stringBuffer = new StringBuffer(512);
                    size = this.a.size();
                    long j4 = 0;
                    i3 = 0;
                    int i7 = 0;
                    z2 = true;
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        if (i3 < size) {
                            str2 = "";
                            break;
                        }
                        if (this.a.get(i3).level != 0) {
                            i7++;
                            if (z2) {
                                stringBuffer.append("&wf=");
                                z2 = false;
                            } else {
                                stringBuffer.append("|");
                            }
                            String replace = this.a.get(i3).BSSID.replace(":", "");
                            stringBuffer.append(replace);
                            if (str4 != null && replace.equals(str4)) {
                                i9 = i7;
                            }
                            int i10 = this.a.get(i3).level;
                            if (i10 < 0) {
                                i10 = -i10;
                            }
                            Locale locale = Locale.CHINA;
                            Object[] objArr = new Object[i6];
                            objArr[0] = Integer.valueOf(i10);
                            stringBuffer.append(String.format(locale, ";%d;", objArr));
                            int i11 = i8 + 1;
                            if (z) {
                                try {
                                    str2 = "";
                                } catch (Throwable unused2) {
                                    str2 = "";
                                }
                                try {
                                    j3 = (j2 - this.a.get(i3).timestamp) / 1000000;
                                } catch (Throwable unused3) {
                                    j3 = 0;
                                    arrayList.add(Long.valueOf(j3));
                                    if (j3 > j4) {
                                    }
                                    i5 = i2;
                                    if (i11 > i5) {
                                    }
                                }
                                arrayList.add(Long.valueOf(j3));
                                if (j3 > j4) {
                                    i5 = i2;
                                    j4 = j3;
                                    if (i11 > i5) {
                                        break;
                                    }
                                    i8 = i11;
                                }
                            } else {
                                str2 = "";
                            }
                            i5 = i2;
                            if (i11 > i5) {
                            }
                        }
                        i3++;
                        str4 = str;
                        i6 = 1;
                    }
                    i4 = i9;
                    if (i4 > 0) {
                        stringBuffer.append("&wf_n=");
                        stringBuffer.append(i4);
                    }
                    if (z2) {
                        if (j4 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                            StringBuffer stringBuffer2 = new StringBuffer(128);
                            stringBuffer2.append("&wf_ut=");
                            Long l = (Long) arrayList.get(0);
                            boolean z3 = true;
                            for (Long l2 : arrayList) {
                                if (z3) {
                                    stringBuffer2.append(l2.longValue());
                                    str3 = str2;
                                    z3 = false;
                                } else {
                                    long longValue = l2.longValue() - l.longValue();
                                    if (longValue != 0) {
                                        StringBuilder sb = new StringBuilder();
                                        str3 = str2;
                                        sb.append(str3);
                                        sb.append(longValue);
                                        stringBuffer2.append(sb.toString());
                                    } else {
                                        str3 = str2;
                                    }
                                }
                                stringBuffer2.append("|");
                                str2 = str3;
                            }
                            stringBuffer.append(stringBuffer2.toString());
                        }
                        return stringBuffer.toString();
                    }
                    return null;
                }
            } else {
                j2 = 0;
            }
            z = false;
            StringBuffer stringBuffer3 = new StringBuffer(512);
            size = this.a.size();
            long j42 = 0;
            i3 = 0;
            int i72 = 0;
            z2 = true;
            int i82 = 0;
            int i92 = 0;
            while (true) {
                if (i3 < size) {
                }
                i3++;
                str4 = str;
                i6 = 1;
            }
            i4 = i92;
            if (i4 > 0) {
            }
            if (z2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037723345, "Lcom/baidu/location/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037723345, "Lcom/baidu/location/b/c;");
                return;
            }
        }
        r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    }

    public c(Context context, LocationClientOption locationClientOption, a aVar) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locationClientOption, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String str = null;
        this.f33595d = null;
        this.f33596e = null;
        this.f33597f = new com.baidu.location.c.a();
        this.f33598g = null;
        this.f33599h = null;
        this.f33600j = null;
        this.k = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.a = null;
        this.f33593b = null;
        this.q = false;
        this.f33594c = new b(this);
        this.s = 0L;
        this.t = false;
        Context applicationContext = context.getApplicationContext();
        this.f33595d = applicationContext;
        try {
            com.baidu.location.e.k.ax = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.q = true;
        if (1 != 0) {
            this.l = new LocationClientOption(locationClientOption);
            this.m = aVar;
            this.a = this.f33595d.getPackageName();
            this.f33593b = null;
            try {
                this.f33596e = (TelephonyManager) this.f33595d.getSystemService("phone");
                this.f33598g = (WifiManager) this.f33595d.getApplicationContext().getSystemService("wifi");
            } catch (Exception unused2) {
            }
            this.k = "&" + this.a + "&" + ((String) null);
            try {
                this.f33593b = CommonParam.getCUID(this.f33595d);
            } catch (Throwable unused3) {
                this.f33593b = null;
                this.f33596e = null;
                this.f33598g = null;
            }
            if (this.f33593b != null) {
                com.baidu.location.e.k.o = "" + this.f33593b;
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(this.l.prodName);
                sb.append(":");
                sb.append(this.a);
                sb.append("|&cu=");
                str = this.f33593b;
            } else {
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(this.l.prodName);
                sb.append(":");
                sb.append(this.a);
                sb.append("|&im=");
            }
            sb.append(str);
            sb.append("&coor=");
            sb.append(locationClientOption.getCoorType());
            this.f33600j = sb.toString();
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("&fw=");
            stringBuffer.append("7.93");
            stringBuffer.append("&sdk=");
            stringBuffer.append("7.93");
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&resid=");
            stringBuffer.append("12");
            locationClientOption.getAddrType();
            if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
                this.f33600j += "&addr=allj";
                if (locationClientOption.isNeedNewVersionRgc) {
                    stringBuffer.append("&adtp=n2");
                }
            }
            if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
                this.f33600j += "&sema=";
                if (locationClientOption.isNeedAptag) {
                    this.f33600j += "aptag|";
                }
                if (locationClientOption.isNeedAptagd) {
                    this.f33600j += "aptagd|";
                }
                this.o = com.baidu.location.a.a.b(this.f33595d);
                this.p = com.baidu.location.a.a.c(this.f33595d);
            }
            stringBuffer.append("&first=1");
            stringBuffer.append("&os=A");
            stringBuffer.append(Build.VERSION.SDK);
            this.f33600j += stringBuffer.toString();
            String a2 = a();
            a2 = TextUtils.isEmpty(a2) ? a2 : a2.replace(":", "");
            if (!TextUtils.isEmpty(a2) && !a2.equals("020000000000")) {
                this.f33600j += "&mac=" + a2;
            }
            b();
        }
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
        r1.f33711g = java.lang.System.currentTimeMillis();
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
                        aVar.f33707c = a(cellIdentity.getMcc());
                        aVar.f33708d = a(cellIdentity.getMnc());
                        aVar.a = a(cellIdentity.getTac());
                        aVar.f33706b = a(cellIdentity.getCi());
                        aVar.f33713i = 'g';
                        asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    }
                    if (intValue >= 18) {
                        if (cellInfo instanceof CellInfoWcdma) {
                        }
                    }
                    aVar.f33711g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                    return aVar;
                }
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                aVar.f33709e = cellIdentity2.getLatitude();
                aVar.f33710f = cellIdentity2.getLongitude();
                aVar.f33708d = a(cellIdentity2.getSystemId());
                aVar.a = a(cellIdentity2.getNetworkId());
                aVar.f33706b = a(cellIdentity2.getBasestationId());
                aVar.f33713i = 'c';
                aVar.f33712h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                com.baidu.location.c.a aVar2 = this.f33597f;
                if (aVar2 == null || (i2 = aVar2.f33707c) <= 0) {
                    i2 = -1;
                    try {
                        String networkOperator = this.f33596e.getNetworkOperator();
                        if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                            int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                            if (intValue2 >= 0) {
                                i2 = intValue2;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                aVar.f33707c = i2;
                z = true;
                if (intValue >= 18 && !z) {
                    try {
                        if (cellInfo instanceof CellInfoWcdma) {
                            CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            aVar.f33707c = a(cellIdentity3.getMcc());
                            aVar.f33708d = a(cellIdentity3.getMnc());
                            aVar.a = a(cellIdentity3.getLac());
                            aVar.f33706b = a(cellIdentity3.getCid());
                            aVar.f33713i = 'g';
                            aVar.f33712h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                        }
                    } catch (Exception unused2) {
                    }
                }
                aVar.f33711g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
            aVar.f33707c = a(cellIdentity4.getMcc());
            aVar.f33708d = a(cellIdentity4.getMnc());
            aVar.a = a(cellIdentity4.getLac());
            aVar.f33706b = a(cellIdentity4.getCid());
            aVar.f33713i = 'g';
            asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            aVar.f33712h = asuLevel;
            z = true;
            if (intValue >= 18) {
            }
            aVar.f33711g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
            return aVar;
        }
        return (com.baidu.location.c.a) invokeL.objValue;
    }

    private void a(CellLocation cellLocation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, cellLocation) == null) || cellLocation == null || this.f33596e == null) {
            return;
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        String networkOperator = this.f33596e.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.f33597f.f33707c;
                    }
                    aVar.f33707c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i2 = 0;
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i2)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.f33597f.f33708d;
                    }
                    aVar.f33708d = intValue2;
                }
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            aVar.a = gsmCellLocation.getLac();
            aVar.f33706b = gsmCellLocation.getCid();
            aVar.f33713i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f33713i = 'c';
            if (f33592i == null) {
                try {
                    f33592i = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    f33592i = null;
                    return;
                }
            }
            Class<?> cls = f33592i;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = -1;
                    }
                    aVar.f33708d = systemId;
                    aVar.f33706b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.f33709e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f33710f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                }
            }
        }
        if (aVar.b()) {
            this.f33597f = aVar;
        } else {
            this.f33597f = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:3|(2:4|5)|(9:10|11|(1:47)(1:15)|17|18|(1:24)|26|27|(2:(1:(1:35)(1:36))|(1:38)(4:39|(1:41)|42|43))(2:30|31))|48|11|(1:13)|47|17|18|(3:20|22|24)|26|27|(0)|(0)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:3|4|5|(9:10|11|(1:47)(1:15)|17|18|(1:24)|26|27|(2:(1:(1:35)(1:36))|(1:38)(4:39|(1:41)|42|43))(2:30|31))|48|11|(1:13)|47|17|18|(3:20|22|24)|26|27|(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(int i2) {
        InterceptResult invokeI;
        String str;
        String str2;
        com.baidu.location.c.a d2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65543, this, i2)) != null) {
            return (String) invokeI.objValue;
        }
        try {
            d2 = d();
        } catch (Throwable unused) {
            str = null;
        }
        if (d2 != null && d2.b()) {
            this.f33597f = d2;
            str = (this.f33597f == null && this.f33597f.b()) ? this.f33597f.g() : null;
            if (!TextUtils.isEmpty(str) && this.f33597f != null && this.f33597f.k != null) {
                str = str + this.f33597f.k;
            }
            this.f33599h = null;
            C1805c c1805c = new C1805c(this, this.f33598g.getScanResults());
            this.f33599h = c1805c;
            str2 = c1805c.a(i2, e());
            if (str != null && str2 == null) {
                this.n = null;
                return null;
            }
            if (str2 != null) {
                if (str == null) {
                    str = str2;
                } else {
                    str = str + str2;
                }
            }
            if (str != null) {
                return null;
            }
            this.n = str;
            if (this.f33600j != null) {
                this.n += this.f33600j;
            }
            return str + this.f33600j;
        }
        a(this.f33596e.getCellLocation());
        if (this.f33597f == null) {
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + this.f33597f.k;
        }
        this.f33599h = null;
        C1805c c1805c2 = new C1805c(this, this.f33598g.getScanResults());
        this.f33599h = c1805c2;
        str2 = c1805c2.a(i2, e());
        if (str != null) {
        }
        if (str2 != null) {
        }
        if (str != null) {
        }
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
                return null;
            }
            try {
                List<CellInfo> allCellInfo = this.f33596e.getAllCellInfo();
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

    private String e() {
        InterceptResult invokeV;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            WifiManager wifiManager = this.f33598g;
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return null;
            }
            try {
                String bssid = connectionInfo.getBSSID();
                String replace = bssid != null ? bssid.replace(":", "") : null;
                if (replace == null || replace.length() == 12) {
                    return new String(replace);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                WifiInfo connectionInfo = this.f33598g.getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getMacAddress();
                }
                return null;
            } catch (Error | Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return b(15);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void c() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (str = this.n) != null && this.q) {
            this.f33594c.a(str);
        }
    }
}
