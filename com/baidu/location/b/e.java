package com.baidu.location.b;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lbsapi.auth.LBSAuthManager;
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
import com.baidu.webkit.sdk.WebChromeClient;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static char[] q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public c c;
    public Context d;
    public TelephonyManager e;
    public com.baidu.location.c.a f;
    public WifiManager g;
    public C0102e h;
    public String i;
    public String j;
    public LocationClientOption k;
    public b l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public boolean r;
    public final Object s;
    public f t;
    public boolean u;
    public boolean v;
    public long w;
    public boolean x;

    @TargetApi(29)
    /* loaded from: classes2.dex */
    public class a extends TelephonyManager.CellInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        public /* synthetic */ a(e eVar, com.baidu.location.b.f fVar) {
            this(eVar);
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            e eVar = this.a;
            eVar.u = !eVar.u;
            if (this.a.u || this.a.k.priority == 4) {
                synchronized (this.a.s) {
                    this.a.s.notifyAll();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* loaded from: classes2.dex */
    public class c extends com.baidu.location.e.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public LocationManager b;
        public a c;
        public boolean d;
        public final /* synthetic */ e e;

        /* loaded from: classes2.dex */
        public class a implements LocationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            public /* synthetic */ a(c cVar, com.baidu.location.b.f fVar) {
                this(cVar);
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                    this.a.c();
                    this.a.d = true;
                }
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                }
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, bundle) == null) {
                }
            }
        }

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = eVar;
            this.a = null;
            this.d = false;
            this.j = new HashMap();
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                try {
                    this.b = (LocationManager) this.e.d.getSystemService("location");
                    a aVar = new a(this, null);
                    this.c = aVar;
                    if (this.b == null || aVar == null) {
                        return;
                    }
                    try {
                        this.b.requestLocationUpdates("network", 1000L, 0.0f, aVar, Looper.getMainLooper());
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                } catch (Throwable unused) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            a aVar;
            LocationManager locationManager;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (aVar = this.c) == null || (locationManager = this.b) == null) {
                return;
            }
            try {
                locationManager.removeUpdates(aVar);
            } catch (Exception unused) {
            }
        }

        @Override // com.baidu.location.e.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.e.n != null && this.e.o != null) {
                    this.a += String.format(Locale.CHINA, "&ki=%s&sn=%s", this.e.n, this.e.o);
                }
                String str = this.a + "&enc=2";
                this.a = str;
                String encodeTp4 = Jni.encodeTp4(str);
                this.a = null;
                this.j.put(BaseLocationBox.TYPE, encodeTp4);
                this.j.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a = str;
                b(com.baidu.location.e.d.c);
                if (this.e.r) {
                    b();
                    Timer timer = new Timer();
                    timer.schedule(new g(this, timer), 10000L);
                    SharedPreferences.Editor edit = this.e.d.getSharedPreferences("cuidRelate", 0).edit();
                    edit.putLong("reqtime", System.currentTimeMillis());
                    edit.apply();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
            r6 = r5.i;
         */
        @Override // com.baidu.location.e.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            String str;
            BDLocation bDLocation;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (!z || str == null) {
                    this.e.b(63);
                } else {
                    try {
                        if (str.contains("\"enc\"")) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("enc")) {
                                    str = n.a().b(jSONObject.getString("enc"));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            bDLocation = new BDLocation(str);
                            this.e.a(str);
                        } catch (Exception unused) {
                            bDLocation = new BDLocation();
                            bDLocation.setLocType(63);
                        }
                        if (bDLocation.getLocType() == 161) {
                            bDLocation.setCoorType(this.e.k.coorType);
                            bDLocation.setLocationID(Jni.en1(this.e.a + ParamableElem.DIVIDE_PARAM + this.e.b + ParamableElem.DIVIDE_PARAM + bDLocation.getTime()));
                            bDLocation.setRoadLocString(0.0f, 0.0f, null);
                            this.e.x = true;
                            this.e.l.onReceiveLocation(bDLocation);
                        } else {
                            this.e.b(bDLocation.getLocType());
                        }
                    } catch (Exception e2) {
                        this.e.b(63);
                        e2.printStackTrace();
                    }
                }
                Map<String, Object> map = this.j;
                if (map != null) {
                    map.clear();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public final /* synthetic */ e c;

        public d(e eVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eVar;
            this.a = str;
            this.b = i;
        }
    }

    /* renamed from: com.baidu.location.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0102e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ScanResult> a;
        public String b;
        public long c;
        public String d;
        public int e;

        public C0102e(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.c = 0L;
            this.b = null;
            this.d = null;
            this.e = 16;
            this.a = list;
            this.c = System.currentTimeMillis();
            try {
                b();
            } catch (Exception e) {
                e.printStackTrace();
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
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.location.b.e.C0102e.$ic
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e.C0102e.b():void");
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

        /* JADX WARN: Removed duplicated region for block: B:102:0x00ef A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String a(int i, String str, boolean z, int i2) {
            InterceptResult invokeCommon;
            long j;
            boolean z2;
            int size;
            int i3;
            String str2;
            int i4;
            String str3;
            boolean z3;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), Integer.valueOf(i2)})) != null) {
                return (String) invokeCommon.objValue;
            }
            String str4 = str;
            if (a() < 1) {
                return null;
            }
            this.e = i2;
            ArrayList<Long> arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    j = SystemClock.elapsedRealtimeNanos() / 1000;
                } catch (Error unused) {
                    j = 0;
                }
                if (j > 0) {
                    z2 = true;
                    StringBuffer stringBuffer = new StringBuffer(512);
                    size = this.a.size();
                    long j3 = 0;
                    i3 = 0;
                    int i5 = 0;
                    boolean z4 = true;
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        if (i3 < size) {
                            str2 = "";
                            i4 = i6;
                            break;
                        }
                        if (this.a.get(i3) != null && this.a.get(i3).level != 0) {
                            int i8 = i5 + 1;
                            if (z4) {
                                stringBuffer.append("&wf=");
                                z4 = false;
                            } else {
                                stringBuffer.append("|");
                            }
                            String replace = this.a.get(i3).BSSID.replace(":", "");
                            stringBuffer.append(replace);
                            if (str4 != null && replace.equals(str4)) {
                                i7 = i8;
                            }
                            int i9 = this.a.get(i3).level;
                            if (i9 < 0) {
                                i9 = -i9;
                            }
                            str2 = "";
                            stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i9)));
                            i4 = i6 + 1;
                            if (z2) {
                                try {
                                    j2 = (j - this.a.get(i3).timestamp) / 1000000;
                                } catch (Throwable unused2) {
                                    j2 = 0;
                                }
                                arrayList.add(Long.valueOf(j2));
                                if (j2 > j3) {
                                    j3 = j2;
                                }
                            }
                            if (i4 > i) {
                                break;
                            }
                            i6 = i4;
                            i5 = i8;
                        }
                        i3++;
                        str4 = str;
                    }
                    int i10 = i7;
                    if (z) {
                        if (i10 > 0) {
                            stringBuffer.append("&wf_n=");
                            stringBuffer.append(i10);
                        }
                        if (i4 > i && this.e > i + 1) {
                            int i11 = i4;
                            while (i11 < size) {
                                if (i11 == i4) {
                                    stringBuffer.append("&wf2=");
                                } else {
                                    stringBuffer.append("|");
                                }
                                str3 = str2;
                                stringBuffer.append(this.a.get(i11).BSSID.replace(":", str3));
                                int i12 = this.a.get(i11).level;
                                if (i12 < 0) {
                                    i12 = -i12;
                                }
                                z3 = true;
                                stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i12)));
                                if (i11 >= this.e) {
                                    break;
                                }
                                i11++;
                                str2 = str3;
                            }
                        }
                        str3 = str2;
                        z3 = true;
                        if (z4) {
                            return null;
                        }
                        if (j3 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                            StringBuffer stringBuffer2 = new StringBuffer(128);
                            stringBuffer2.append("&wf_ut=");
                            Long l = (Long) arrayList.get(0);
                            for (Long l2 : arrayList) {
                                if (z3) {
                                    stringBuffer2.append(l2.longValue());
                                    z3 = false;
                                } else {
                                    long longValue = l2.longValue() - l.longValue();
                                    if (longValue != 0) {
                                        stringBuffer2.append(str3 + longValue);
                                    }
                                }
                                stringBuffer2.append("|");
                            }
                            stringBuffer.append(stringBuffer2.toString());
                        }
                        return stringBuffer.toString();
                    }
                    return stringBuffer.toString();
                }
            } else {
                j = 0;
            }
            z2 = false;
            StringBuffer stringBuffer3 = new StringBuffer(512);
            size = this.a.size();
            long j32 = 0;
            i3 = 0;
            int i52 = 0;
            boolean z42 = true;
            int i62 = 0;
            int i72 = 0;
            while (true) {
                if (i3 < size) {
                }
                i3++;
                str4 = str;
            }
            int i102 = i72;
            if (z) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        public /* synthetic */ f(e eVar, com.baidu.location.b.f fVar) {
            this(eVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || context == null || intent == null) {
                return;
            }
            String action = intent.getAction();
            e eVar = this.a;
            eVar.u = !eVar.u;
            if (!(action.equals("android.net.wifi.SCAN_RESULTS") && this.a.u) && Build.VERSION.SDK_INT >= 29 && this.a.v) {
                return;
            }
            synchronized (this.a.s) {
                this.a.s.notifyAll();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037723407, "Lcom/baidu/location/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037723407, "Lcom/baidu/location/b/e;");
                return;
            }
        }
        q = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    }

    public e(Context context, LocationClientOption locationClientOption, b bVar, String str) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locationClientOption, bVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String str2 = null;
        this.d = null;
        this.e = null;
        this.f = new com.baidu.location.c.a();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = null;
        this.b = null;
        this.p = false;
        this.c = new c(this);
        this.r = false;
        this.s = new Object();
        this.t = null;
        this.u = true;
        this.v = false;
        this.w = 0L;
        this.x = false;
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        try {
            com.baidu.location.e.k.aw = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.p = true;
        if (1 != 0) {
            this.k = new LocationClientOption(locationClientOption);
            this.l = bVar;
            this.a = this.d.getPackageName();
            this.b = null;
            try {
                this.e = (TelephonyManager) this.d.getSystemService("phone");
                this.g = (WifiManager) this.d.getApplicationContext().getSystemService("wifi");
            } catch (Exception unused2) {
            }
            LocationClientOption locationClientOption2 = this.k;
            if (locationClientOption2.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
                if (locationClientOption2.priority != 4) {
                    f fVar = new f(this, null);
                    this.t = fVar;
                    try {
                        this.d.registerReceiver(fVar, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                    } catch (Exception unused3) {
                    }
                }
                if (Build.VERSION.SDK_INT >= 30) {
                    this.v = com.baidu.location.e.k.b("android.telephony.TelephonyManager$CellInfoCallback");
                }
            }
            this.j = "&" + this.a + "&" + ((String) null);
            try {
                this.b = LBSAuthManager.getInstance(this.d).getCUID();
            } catch (Throwable unused4) {
                this.b = null;
                this.e = null;
                this.g = null;
            }
            if (this.b != null) {
                com.baidu.location.e.k.n = "" + this.b;
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(this.k.prodName);
                sb.append(":");
                sb.append(this.a);
                sb.append("|&cu=");
                str2 = this.b;
            } else {
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(this.k.prodName);
                sb.append(":");
                sb.append(this.a);
                sb.append("|&im=");
            }
            sb.append(str2);
            sb.append("&coor=");
            sb.append(locationClientOption.getCoorType());
            this.i = sb.toString();
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("&fw=");
            stringBuffer.append("9.363");
            stringBuffer.append("&sdk=");
            stringBuffer.append("9.363");
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&resid=");
            stringBuffer.append("12");
            locationClientOption.getAddrType();
            if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
                this.i += "&addr=allj2";
                if (locationClientOption.isNeedNewVersionRgc) {
                    stringBuffer.append("&adtp=n2");
                }
            }
            if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
                this.i += "&sema=";
                if (locationClientOption.isNeedAptag) {
                    this.i += "aptag|";
                }
                if (locationClientOption.isNeedAptagd) {
                    this.i += "aptagd2|";
                }
                this.n = com.baidu.location.a.a.b(this.d);
                this.o = com.baidu.location.a.a.c(this.d);
            }
            stringBuffer.append("&first=1");
            stringBuffer.append("&os=A");
            stringBuffer.append(Build.VERSION.SDK);
            this.i += stringBuffer.toString();
        }
    }

    public static com.baidu.location.c.a a(CellLocation cellLocation, TelephonyManager telephonyManager, com.baidu.location.c.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cellLocation, telephonyManager, aVar)) == null) {
            if (cellLocation == null || telephonyManager == null) {
                return null;
            }
            com.baidu.location.c.a aVar2 = new com.baidu.location.c.a();
            aVar2.l = 1;
            String networkOperator = telephonyManager.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = aVar.c;
                        }
                        aVar2.c = intValue;
                    }
                    String substring = networkOperator.substring(3);
                    if (substring != null) {
                        char[] charArray = substring.toCharArray();
                        int i = 0;
                        while (i < charArray.length && Character.isDigit(charArray[i])) {
                            i++;
                        }
                        int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                        if (intValue2 < 0) {
                            intValue2 = aVar.d;
                        }
                        aVar2.d = intValue2;
                    }
                } catch (Exception unused) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                aVar2.a = gsmCellLocation.getLac();
                aVar2.b = gsmCellLocation.getCid();
                aVar2.i = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                aVar2.i = 'c';
                try {
                    Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    if (cls != null && cls.isInstance(cellLocation)) {
                        try {
                            int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                            if (systemId < 0) {
                                systemId = -1;
                            }
                            aVar2.d = systemId;
                            aVar2.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                            aVar2.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                            int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                            if (baseStationLatitude < Integer.MAX_VALUE) {
                                aVar2.e = baseStationLatitude;
                            }
                            int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                            if (baseStationLongitude < Integer.MAX_VALUE) {
                                aVar2.f = baseStationLongitude;
                            }
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Exception unused3) {
                    return null;
                }
            }
            if (aVar2.b()) {
                return aVar2;
            }
            return null;
        }
        return (com.baidu.location.c.a) invokeLLL.objValue;
    }

    private Object a(Object obj, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, obj, str)) == null) ? obj.getClass().getField(str).get(obj) : invokeLL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:3|(2:4|5)|(15:7|(1:9)|10|11|(1:60)(1:15)|17|18|(1:24)|26|27|(5:31|33|34|(1:38)|(2:(1:(1:47)(1:48))|(1:50)(4:51|(1:53)|54|55))(2:42|43))|57|(0)|(0)|(0)(0))|61|(2:63|10)|11|(1:13)|60|17|18|(3:20|22|24)|26|27|(8:29|31|33|34|(2:36|38)|(0)|(0)|(0)(0))|57|(0)|(0)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:3|4|5|(15:7|(1:9)|10|11|(1:60)(1:15)|17|18|(1:24)|26|27|(5:31|33|34|(1:38)|(2:(1:(1:47)(1:48))|(1:50)(4:51|(1:53)|54|55))(2:42|43))|57|(0)|(0)|(0)(0))|61|(2:63|10)|11|(1:13)|60|17|18|(3:20|22|24)|26|27|(8:29|31|33|34|(2:36|38)|(0)|(0)|(0)(0))|57|(0)|(0)|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00af A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(int i) {
        InterceptResult invokeI;
        String str;
        String str2;
        com.baidu.location.c.a a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) != null) {
            return (String) invokeI.objValue;
        }
        try {
            a2 = com.baidu.location.c.b.a(this.f, this.e, true);
        } catch (Throwable unused) {
            str = null;
        }
        if (a2 != null) {
            if (!a2.b()) {
            }
            this.f = a2;
            str = (this.f == null && this.f.b()) ? this.f.h() : null;
            if (!TextUtils.isEmpty(str) && this.f != null && this.f.m != null) {
                str = str + this.f.m;
            }
            this.h = null;
            if (a(this.g) && this.k.priority != 4) {
                C0102e c0102e = new C0102e(this.g.getScanResults());
                this.h = c0102e;
                str2 = c0102e.a(i, b(this.g), this.r, com.baidu.location.b.a.a().b);
                try {
                    if (this.k != null && this.k.isOnceLocation()) {
                        this.g.startScan();
                    }
                } catch (Exception unused2) {
                }
                if (str != null && str2 == null) {
                    this.m = null;
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
                this.m = str;
                if (this.i != null) {
                    this.m += this.i;
                }
                g();
                return str + this.i;
            }
            str2 = null;
            if (str != null) {
            }
            if (str2 != null) {
            }
            if (str != null) {
            }
        }
        if (Build.VERSION.SDK_INT <= 28) {
            a2 = a(this.e.getCellLocation(), this.e, this.f);
            this.f = a2;
        }
        if (this.f == null) {
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + this.f.m;
        }
        this.h = null;
        if (a(this.g)) {
            C0102e c0102e2 = new C0102e(this.g.getScanResults());
            this.h = c0102e2;
            str2 = c0102e2.a(i, b(this.g), this.r, com.baidu.location.b.a.a().b);
            if (this.k != null) {
                this.g.startScan();
            }
            if (str != null) {
            }
            if (str2 != null) {
            }
            if (str != null) {
            }
        }
        str2 = null;
        if (str != null) {
        }
        if (str2 != null) {
        }
        if (str != null) {
        }
    }

    private String a(List<WifiConfiguration> list) {
        InterceptResult invokeL;
        ArrayList<d> arrayList;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, list)) == null) {
            int i2 = 0;
            if (list == null || list.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (WifiConfiguration wifiConfiguration : list) {
                    String str = wifiConfiguration.SSID;
                    try {
                        i = ((Integer) a(wifiConfiguration, "numAssociation")).intValue();
                    } catch (Throwable unused) {
                        i = 0;
                    }
                    if (i > 0 && !TextUtils.isEmpty(str)) {
                        arrayList.add(new d(this, str, i));
                    }
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, new com.baidu.location.b.f(this));
            }
            StringBuffer stringBuffer = new StringBuffer(200);
            for (d dVar : arrayList) {
                stringBuffer.append(dVar.a);
                stringBuffer.append(",");
                stringBuffer.append(dVar.b);
                stringBuffer.append("|");
                i2++;
                if (i2 == 4) {
                    break;
                }
            }
            if (arrayList.size() >= 5) {
                stringBuffer.append(((d) arrayList.get(4)).a);
                stringBuffer.append(",");
                stringBuffer.append(((d) arrayList.get(4)).b);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
                String string = jSONObject.has("ideocfre") ? jSONObject.getString("ideocfre") : null;
                if (TextUtils.isEmpty(string) || !string.contains("|") || (split = string.split(WebChromeClient.PARAM_SEPARATOR)) == null || split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseLong = Long.parseLong(split[1]);
                SharedPreferences.Editor edit = this.d.getSharedPreferences("cuidRelate", 0).edit();
                edit.putInt("cuidoc", parseInt);
                edit.putLong("cuidfreq", parseLong);
                edit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(WifiManager wifiManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, wifiManager)) == null) {
            try {
                if (!wifiManager.isWifiEnabled()) {
                    if (Build.VERSION.SDK_INT <= 17) {
                        return false;
                    }
                    if (!wifiManager.isScanAlwaysAvailable()) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String b(WifiManager wifiManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, wifiManager)) == null) {
            if (wifiManager == null) {
                return null;
            }
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    return null;
                }
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
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65550, this, i) == null) && this.k.isOnceLocation()) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(i);
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
            bDLocation.setLocationID(Jni.en1(this.a + ParamableElem.DIVIDE_PARAM + this.b + ParamableElem.DIVIDE_PARAM + format));
            b bVar = this.l;
            if (bVar != null) {
                bVar.onReceiveLocation(bDLocation);
            }
        }
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            if (com.baidu.location.b.a.a().d == 0) {
                return false;
            }
            SharedPreferences sharedPreferences = this.d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
            if (!sharedPreferences.contains("isInstalled")) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (!com.baidu.location.e.k.b(this.d, "com.baidu.map.location")) {
                    edit.putInt("isInstalled", 0);
                    return false;
                }
                edit.putInt("isInstalled", 1);
                edit.apply();
            } else if (sharedPreferences.getInt("isInstalled", -1) == 0) {
                return false;
            }
            return sharedPreferences.getInt("cuidoc", 1) != 0 && (System.currentTimeMillis() - sharedPreferences.getLong("reqtime", 0L)) / 1000 >= sharedPreferences.getLong("cuidfreq", 60L) && com.baidu.location.e.k.b(this.d) >= 2 && a(this.g) && this.h.a() > 3;
        }
        return invokeV.booleanValue;
    }

    private void g() {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (!f()) {
                this.r = false;
                return;
            }
            this.r = true;
            if (this.h.a() >= 10) {
                String a3 = this.h.a(9, b(this.g), this.r, com.baidu.location.b.a.a().b);
                if (!TextUtils.isEmpty(a3)) {
                    a2 = com.baidu.location.e.k.a(a3.getBytes(), false);
                }
                a2 = null;
            } else {
                C0102e c0102e = this.h;
                String a4 = c0102e.a(c0102e.a(), b(this.g), this.r, com.baidu.location.b.a.a().b);
                if (!TextUtils.isEmpty(a4)) {
                    a2 = com.baidu.location.e.k.a(a4.getBytes(), false);
                }
                a2 = null;
            }
            String a5 = a(h());
            String a6 = TextUtils.isEmpty(a5) ? null : com.baidu.location.e.k.a(a5.getBytes(), false);
            if (TextUtils.isEmpty(a2)) {
                this.r = false;
            } else {
                this.m += "&swf5=" + a2;
                this.r = true;
            }
            if (TextUtils.isEmpty(a6)) {
                return;
            }
            this.m += "&hwf5=" + a6;
            this.r = true;
        }
    }

    private List<WifiConfiguration> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            try {
                if (this.g != null) {
                    return this.g.getConfiguredNetworks();
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return a(15);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.m == null) {
                int i = 62;
                int f2 = com.baidu.location.e.k.f(this.d);
                if (f2 == -1) {
                    i = 69;
                } else if (f2 == -2) {
                    i = 70;
                } else if (f2 == 0) {
                    i = 71;
                }
                b(i);
            } else if (this.p) {
                if (this.d != null) {
                    com.baidu.location.b.c.a().a(this.d);
                    this.m += com.baidu.location.b.c.a().b();
                }
                this.c.a(this.m);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.g.isWifiEnabled() || this.g.isScanAlwaysAvailable()) && this.k.priority != 4) {
                this.g.startScan();
            }
            if (com.baidu.location.e.k.a(this.d, com.kuaishou.weapon.p0.h.g) == 1 && Build.VERSION.SDK_INT >= 29 && this.v) {
                this.e.requestCellInfoUpdate(this.d.getMainExecutor(), new a(this, null));
            }
            synchronized (this.s) {
                try {
                    this.s.wait(3000L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                if (this.t != null) {
                    this.d.unregisterReceiver(this.t);
                }
            } catch (Exception unused) {
            }
        }
    }
}
