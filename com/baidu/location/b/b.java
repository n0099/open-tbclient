package com.baidu.location.b;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long c = 0;
    public static int d = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int e;
    public ArrayList<a> f;
    public boolean g;
    public BDLocation h;
    public BDLocation i;
    public Object j;
    public BDLocation k;
    public boolean l;
    public boolean m;
    public c n;

    /* renamed from: com.baidu.location.b.b$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Messenger b;
        public LocationClientOption c;
        public int d;
        public final /* synthetic */ b e;

        public a(b bVar, Message message) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, message};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bVar;
            this.a = null;
            this.b = null;
            this.c = new LocationClientOption();
            this.d = 0;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.e.b.a().a(this.c.prodName, this.a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.e.k.l = com.baidu.location.e.k.l || this.c.enableSimulateGps;
            if (!com.baidu.location.e.k.e.equals("all")) {
                com.baidu.location.e.k.e = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.e.k.h = com.baidu.location.e.k.h || this.c.isNeedNewVersionRgc;
            com.baidu.location.e.k.g = com.baidu.location.e.k.g || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.e.k.i = com.baidu.location.e.k.i || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.e.k.R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i3 = message.getData().getInt("wfnum", com.baidu.location.e.k.ay);
            float f = message.getData().getFloat("wfsm", com.baidu.location.e.k.az);
            int i4 = message.getData().getInt("gnmcon", com.baidu.location.e.k.aB);
            double d = message.getData().getDouble("gnmcrm", com.baidu.location.e.k.aA);
            int i5 = message.getData().getInt("iupl", 1);
            com.baidu.location.e.k.aG = message.getData().getInt(Config.EXCEPTION_CRASH_TYPE, 10);
            com.baidu.location.e.k.aH = message.getData().getInt("suci", 3);
            com.baidu.location.e.k.aJ = message.getData().getDoubleArray("cgs");
            com.baidu.location.e.k.aK = message.getData().getInt("ums", 1);
            com.baidu.location.e.k.aI = message.getData().getInt("smn", 40);
            if (i5 <= 0) {
                com.baidu.location.e.k.aF = 0;
            } else if (com.baidu.location.e.k.aF == -1) {
                com.baidu.location.e.k.aF = 1;
            }
            if (message.getData().getInt("opetco", 1) == 0) {
                com.baidu.location.e.k.aL = 0;
            }
            if (message.getData().getInt("lpcs", com.baidu.location.e.k.aM) == 0) {
                com.baidu.location.e.k.aM = 0;
            }
            if (i4 == 1) {
                com.baidu.location.e.k.aB = 1;
            }
            if (d > com.baidu.location.e.k.aA) {
                com.baidu.location.e.k.aA = d;
            }
            com.baidu.location.e.k.ax = com.baidu.location.e.k.ax || message.getData().getBoolean("ischeckper", false);
            boolean z = message.getData().getBoolean("isEnableBeidouMode", false);
            if (Build.VERSION.SDK_INT >= 28) {
                com.baidu.location.e.k.aN = com.baidu.location.e.k.aN || z;
            }
            if (i3 > com.baidu.location.e.k.ay) {
                com.baidu.location.e.k.ay = i3;
            }
            if (f > com.baidu.location.e.k.az) {
                com.baidu.location.e.k.az = f;
            }
            int i6 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i6 < com.baidu.location.e.k.af) {
                com.baidu.location.e.k.af = i6;
            }
            int i7 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i7 >= com.baidu.location.e.k.W) {
                com.baidu.location.e.k.W = i7;
            }
            int i8 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i8 >= com.baidu.location.e.k.Y) {
                com.baidu.location.e.k.Y = i8;
            }
            int i9 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i9 >= com.baidu.location.e.k.X) {
                com.baidu.location.e.k.X = i9;
            }
            LocationClientOption locationClientOption = this.c;
            if (locationClientOption.mIsNeedDeviceDirect || locationClientOption.isNeedAltitude) {
                t.a().a(this.c.mIsNeedDeviceDirect);
                t.a().b();
            }
            bVar.b = bVar.b || this.c.isNeedAltitude;
            if (message.getData().getInt("hpdts", com.baidu.location.e.k.aC) == 1) {
                com.baidu.location.e.k.aC = 1;
            } else {
                com.baidu.location.e.k.aC = 0;
            }
            if (message.getData().getInt("oldts", com.baidu.location.e.k.aD) == 1) {
                com.baidu.location.e.k.aD = 1;
            } else {
                com.baidu.location.e.k.aD = 0;
            }
        }

        private double a(boolean z, BDLocation bDLocation, BDLocation bDLocation2) {
            InterceptResult invokeCommon;
            double d;
            double latitude;
            double longitude;
            double latitude2;
            double longitude2;
            double a;
            double[] dArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Boolean.valueOf(z), bDLocation, bDLocation2})) == null) {
                if (z) {
                    if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                        if (TextUtils.equals("bd09", bDLocation2.getCoorType())) {
                            double[] coorEncrypt = Jni.coorEncrypt(bDLocation2.getLongitude(), bDLocation2.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                            double[] coorEncrypt2 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                            latitude = coorEncrypt[1];
                            longitude = coorEncrypt[0];
                            latitude2 = coorEncrypt2[1];
                            longitude2 = coorEncrypt2[0];
                            a = com.baidu.location.e.k.a(latitude, longitude, latitude2, longitude2);
                        }
                        a = com.baidu.location.e.k.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                    } else {
                        if (TextUtils.equals("wgs84", bDLocation.getCoorType())) {
                            dArr = new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                        } else {
                            double[] coorEncrypt3 = TextUtils.equals("bd09", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02) : TextUtils.equals("bd09ll", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02) : new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                            dArr = Jni.coorEncrypt(coorEncrypt3[0], coorEncrypt3[1], "gcj2wgs");
                        }
                        bDLocation.setLatitude(dArr[1]);
                        d = dArr[0];
                        bDLocation.setLongitude(d);
                        bDLocation.setTime(com.baidu.location.e.k.a());
                        bDLocation.setCoorType("wgs84");
                        a = com.baidu.location.e.k.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                    }
                } else if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                    latitude = bDLocation2.getLatitude();
                    longitude = bDLocation2.getLongitude();
                    latitude2 = bDLocation.getLatitude();
                    longitude2 = bDLocation.getLongitude();
                    a = com.baidu.location.e.k.a(latitude, longitude, latitude2, longitude2);
                } else {
                    double[] coorEncrypt4 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), "gcj2wgs");
                    bDLocation.setLatitude(coorEncrypt4[1]);
                    d = coorEncrypt4[0];
                    bDLocation.setLongitude(d);
                    bDLocation.setTime(com.baidu.location.e.k.a());
                    bDLocation.setCoorType("wgs84");
                    a = com.baidu.location.e.k.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                }
                bDLocation2.setDisToRealLocation(a);
                if (bDLocation != null) {
                    bDLocation2.setReallLocation(bDLocation);
                }
                return a;
            }
            return invokeCommon.doubleValue;
        }

        private int a(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Double.valueOf(d)})) == null) {
                if (d < 0.0d || d > 10.0d) {
                    if (d <= 10.0d || d > 100.0d) {
                        return (d <= 100.0d || d > 200.0d) ? 3 : 2;
                    }
                    return 1;
                }
                return 0;
            }
            return invokeCommon.intValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
                Message obtain = Message.obtain((Handler) null, i);
                try {
                    if (this.b != null) {
                        this.b.send(obtain);
                    }
                    this.d = 0;
                } catch (Exception e) {
                    if (e instanceof DeadObjectException) {
                        this.d++;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, bundle) == null) {
                Message obtain = Message.obtain((Handler) null, i);
                obtain.setData(bundle);
                try {
                    if (this.b != null) {
                        this.b.send(obtain);
                    }
                    this.d = 0;
                } catch (Exception e) {
                    if (e instanceof DeadObjectException) {
                        this.d++;
                    }
                    e.printStackTrace();
                }
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(65541, this, i, str, bDLocation) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(str, bDLocation);
                bundle.setClassLoader(BDLocation.class.getClassLoader());
                Message obtain = Message.obtain((Handler) null, i);
                obtain.setData(bundle);
                try {
                    if (this.b != null) {
                        this.b.send(obtain);
                    }
                    this.d = 0;
                } catch (Exception e) {
                    if (e instanceof DeadObjectException) {
                        this.d++;
                    }
                }
            }
        }

        private BDLocation b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
                BDLocation h = com.baidu.location.c.e.a().h();
                if (h != null) {
                    double[] coorEncrypt = Jni.coorEncrypt(h.getLongitude(), h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    double[] coorEncrypt2 = Jni.coorEncrypt(coorEncrypt[0], coorEncrypt[1], this.c.coorType);
                    BDLocation bDLocation = new BDLocation();
                    bDLocation.setLongitude(coorEncrypt2[0]);
                    bDLocation.setLatitude(coorEncrypt2[1]);
                    bDLocation.setTime(com.baidu.location.e.k.a());
                    bDLocation.setLocType(61);
                    bDLocation.setCoorType(this.c.coorType);
                    return bDLocation;
                }
                return null;
            }
            return (BDLocation) invokeV.objValue;
        }

        private BDLocation c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
                BDLocation h = com.baidu.location.c.e.a().h();
                if (h != null) {
                    double[] coorEncrypt = Jni.coorEncrypt(h.getLongitude(), h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    BDLocation bDLocation = new BDLocation();
                    bDLocation.setLongitude(coorEncrypt[0]);
                    bDLocation.setLatitude(coorEncrypt[1]);
                    bDLocation.setTime(com.baidu.location.e.k.a());
                    bDLocation.setLocType(61);
                    bDLocation.setCoorType("gcj02");
                    return bDLocation;
                }
                return null;
            }
            return (BDLocation) invokeV.objValue;
        }

        public int a(int i, boolean z, BDLocation bDLocation) {
            InterceptResult invokeCommon;
            double a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), bDLocation})) == null) {
                if (i == 100) {
                    if (z) {
                        BDLocation b = b();
                        if (b != null) {
                            a(true, b, bDLocation);
                            return 3;
                        }
                        return 3;
                    }
                    BDLocation c = c();
                    if (c != null) {
                        a(false, c, bDLocation);
                        return 3;
                    }
                    return 3;
                } else if (i == 200 || i == 300) {
                    return 1;
                } else {
                    if (i != 400) {
                        return i == 500 ? 1 : 0;
                    }
                    if (z) {
                        BDLocation b2 = b();
                        if (b2 == null) {
                            return -1;
                        }
                        a = a(true, b2, bDLocation);
                    } else {
                        BDLocation c2 = c();
                        if (c2 == null) {
                            return -1;
                        }
                        a = a(false, c2, bDLocation);
                    }
                    return a(a);
                }
            }
            return invokeCommon.intValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c.location_change_notify) {
                a(com.baidu.location.e.k.b ? 54 : 55);
            }
        }

        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bDLocation) == null) {
                a(bDLocation, 21);
            }
        }

        public void a(BDLocation bDLocation, int i) {
            int a;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, bDLocation, i) == null) {
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                if (i == 21) {
                    a(27, "locStr", bDLocation2);
                }
                String str2 = this.c.coorType;
                if (str2 == null || str2.equals("gcj02")) {
                    if (!com.baidu.location.e.k.l && bDLocation2.getMockGpsStrategy() > 0) {
                        a = a(bDLocation2.getMockGpsStrategy(), false, bDLocation2);
                        bDLocation2.setMockGpsProbability(a);
                    }
                    a(i, "locStr", bDLocation2);
                }
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        str = this.c.coorType;
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.c.coorType.equals("bd09ll")) {
                        double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt2[0]);
                        bDLocation2.setLatitude(coorEncrypt2[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
                if (!com.baidu.location.e.k.l && bDLocation2.getMockGpsStrategy() > 0) {
                    a = a(bDLocation2.getMockGpsStrategy(), true, bDLocation2);
                    bDLocation2.setMockGpsProbability(a);
                }
                a(i, "locStr", bDLocation2);
            }
        }
    }

    /* renamed from: com.baidu.location.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0103b {
        public static /* synthetic */ Interceptable $ic;
        public static b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819673076, "Lcom/baidu/location/b/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(819673076, "Lcom/baidu/location/b/b$b;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public int b;
        public boolean c;

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c) {
                return;
            }
            this.b++;
            this.a.m = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723314, "Lcom/baidu/location/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723314, "Lcom/baidu/location/b/b;");
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
        this.f = null;
        this.g = false;
        this.a = false;
        this.b = false;
        this.h = null;
        this.i = null;
        this.j = new Object();
        this.e = 0;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = null;
        this.f = new ArrayList<>();
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    private a a(Messenger messenger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, messenger)) == null) {
            if (this.f == null) {
                return null;
            }
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (this.j) {
                Iterator<a> it = this.f.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.b.equals(messenger)) {
                        return next;
                    }
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0103b.a : (b) invokeV.objValue;
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, aVar) == null) || aVar == null) {
            return;
        }
        synchronized (this.j) {
            if (a(aVar.b) != null) {
                aVar.a(14);
            } else {
                this.f.add(aVar);
                aVar.a(13);
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            Intent intent = new Intent("com.baidu.location.flp.log");
            intent.setPackage("com.baidu.baidulocationdemo");
            intent.putExtra("data", str);
            intent.putExtra("pack", com.baidu.location.e.b.e);
            intent.putExtra("tag", "state");
            com.baidu.location.f.getServiceContext().sendBroadcast(intent);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            f();
            d();
            g();
        }
    }

    private void f() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            boolean z2 = false;
            try {
                try {
                    synchronized (this.j) {
                        try {
                            Iterator<a> it = this.f.iterator();
                            z = false;
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next.c.openGps) {
                                    z2 = true;
                                }
                                if (next.c.location_change_notify) {
                                    z = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                throw th;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                com.baidu.location.e.k.a = z;
                if (this.g != z2) {
                    this.g = z2;
                    com.baidu.location.c.e.a().a(this.g);
                }
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                Iterator<a> it = this.f.iterator();
                while (it.hasNext()) {
                    com.baidu.location.e.k.f = Math.min(com.baidu.location.e.k.f, it.next().c.priority);
                }
                if (com.baidu.location.f.isServing) {
                    return;
                }
                com.baidu.location.e.k.f = 4;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Bundle bundle, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bundle, i) == null) {
            synchronized (this.j) {
                Iterator<a> it = this.f.iterator();
                while (it.hasNext()) {
                    try {
                        a next = it.next();
                        next.a(i, bundle);
                        if (next.d > 4) {
                            it.remove();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) || message == null || message.replyTo == null) {
            return;
        }
        c = System.currentTimeMillis();
        this.a = true;
        com.baidu.location.c.k.a().b();
        a(new a(this, message));
        e();
        if (this.l) {
            a("start");
            this.e = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bDLocation) == null) {
            b(bDLocation);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.a = z;
            d = z ? 1 : 0;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.j) {
                try {
                    if (this.f != null) {
                        this.f.clear();
                    }
                } catch (Throwable unused) {
                }
            }
            this.h = null;
            e();
        }
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
            synchronized (this.j) {
                a a2 = a(message.replyTo);
                if (a2 != null) {
                    this.f.remove(a2);
                }
            }
            t.a().c();
            e();
            if (this.l) {
                a("stop");
                this.e = 0;
            }
        }
    }

    public void b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bDLocation) == null) {
            if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().b()) {
                synchronized (this.j) {
                    Iterator<a> it = this.f.iterator();
                    while (it.hasNext()) {
                        try {
                            a next = it.next();
                            next.a(bDLocation);
                            if (next.d > 4) {
                                it.remove();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            } else {
                if (this.i == null) {
                    BDLocation bDLocation3 = new BDLocation();
                    this.i = bDLocation3;
                    bDLocation3.setLocType(505);
                }
                synchronized (this.j) {
                    Iterator<a> it2 = this.f.iterator();
                    while (it2.hasNext()) {
                        try {
                            a next2 = it2.next();
                            next2.a(this.i);
                            if (next2.d > 4) {
                                it2.remove();
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            boolean z = p.h;
            if (z) {
                p.h = false;
            }
            if (com.baidu.location.e.k.W >= 10000) {
                if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                    BDLocation bDLocation4 = this.h;
                    if (bDLocation4 != null) {
                        float[] fArr = new float[1];
                        Location.distanceBetween(bDLocation4.getLatitude(), this.h.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                        if (fArr[0] <= com.baidu.location.e.k.Y && !z) {
                            return;
                        }
                        this.h = null;
                        bDLocation2 = new BDLocation(bDLocation);
                    } else {
                        bDLocation2 = new BDLocation(bDLocation);
                    }
                    this.h = bDLocation2;
                }
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(256);
            if (this.f.isEmpty()) {
                return "&prod=" + com.baidu.location.e.b.f + ":" + com.baidu.location.e.b.e;
            }
            String stringBuffer2 = stringBuffer.toString();
            try {
                a aVar = this.f.get(0);
                if (aVar.c.prodName != null) {
                    stringBuffer.append(aVar.c.prodName);
                }
                if (aVar.a != null) {
                    stringBuffer.append(":");
                    stringBuffer.append(aVar.a);
                    stringBuffer.append("|");
                }
                if (stringBuffer2 == null || stringBuffer2.equals("")) {
                    sb = new StringBuilder();
                    sb.append("&prod=");
                    sb.append(com.baidu.location.e.b.f);
                    sb.append(":");
                    stringBuffer2 = com.baidu.location.e.b.e;
                } else {
                    sb = new StringBuilder();
                    sb.append("&prod=");
                }
                sb.append(stringBuffer2);
                return sb.toString();
            } catch (Exception unused) {
                return "&prod=" + com.baidu.location.e.b.f + ":" + com.baidu.location.e.b.e;
            }
        }
        return (String) invokeV.objValue;
    }

    public void c(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDLocation) == null) {
            Address a2 = p.c().a(bDLocation);
            String f = p.c().f();
            List<Poi> g = p.c().g();
            PoiRegion h = p.c().h();
            if (a2 != null) {
                bDLocation.setAddr(a2);
            }
            if (f != null) {
                bDLocation.setLocationDescribe(f);
            }
            if (g != null) {
                bDLocation.setPoiList(g);
            }
            if (h != null) {
                bDLocation.setPoiRegion(h);
            }
            a(bDLocation);
            p.c().c(bDLocation);
        }
    }

    public boolean c(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, message)) == null) {
            a a2 = a(message.replyTo);
            boolean z = false;
            if (a2 == null) {
                return false;
            }
            LocationClientOption locationClientOption = a2.c;
            int i = locationClientOption.scanSpan;
            locationClientOption.scanSpan = message.getData().getInt("scanSpan", a2.c.scanSpan);
            if (a2.c.scanSpan < 1000) {
                t.a().c();
                this.a = false;
            } else {
                this.a = true;
            }
            LocationClientOption locationClientOption2 = a2.c;
            if (locationClientOption2.scanSpan > 999 && i < 1000) {
                if (locationClientOption2.mIsNeedDeviceDirect || locationClientOption2.isNeedAltitude) {
                    t.a().a(a2.c.mIsNeedDeviceDirect);
                    t.a().b();
                }
                this.b = (this.b || a2.c.isNeedAltitude) ? true : true;
                z = true;
            }
            a2.c.openGps = message.getData().getBoolean("openGPS", a2.c.openGps);
            String string = message.getData().getString("coorType");
            LocationClientOption locationClientOption3 = a2.c;
            if (string == null || string.equals("")) {
                string = a2.c.coorType;
            }
            locationClientOption3.coorType = string;
            String string2 = message.getData().getString("addrType");
            LocationClientOption locationClientOption4 = a2.c;
            if (string2 == null || string2.equals("")) {
                string2 = a2.c.addrType;
            }
            locationClientOption4.addrType = string2;
            if (!com.baidu.location.e.k.e.equals(a2.c.addrType)) {
                p.c().k();
            }
            a2.c.timeOut = message.getData().getInt("timeOut", a2.c.timeOut);
            a2.c.location_change_notify = message.getData().getBoolean("location_change_notify", a2.c.location_change_notify);
            a2.c.priority = message.getData().getInt("priority", a2.c.priority);
            com.baidu.location.e.k.f = a2.c.priority;
            int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i2 < com.baidu.location.e.k.af) {
                com.baidu.location.e.k.af = i2;
            }
            e();
            return z;
        }
        return invokeL.booleanValue;
    }

    public int d(Message message) {
        InterceptResult invokeL;
        Messenger messenger;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, message)) == null) {
            if (message == null || (messenger = message.replyTo) == null || (a2 = a(messenger)) == null || a2.c == null) {
                return 1;
            }
            return com.baidu.location.e.k.f;
        }
        return invokeL.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                synchronized (this.j) {
                    Iterator<a> it = this.f.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bDLocation) == null) {
            c(bDLocation);
        }
    }

    public int e(Message message) {
        InterceptResult invokeL;
        Messenger messenger;
        a a2;
        LocationClientOption locationClientOption;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, message)) == null) {
            if (message == null || (messenger = message.replyTo) == null || (a2 = a(messenger)) == null || (locationClientOption = a2.c) == null) {
                return 1000;
            }
            return locationClientOption.scanSpan;
        }
        return invokeL.intValue;
    }
}
