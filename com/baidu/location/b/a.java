package com.baidu.location.b;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static long f34966c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f34967d = -1;

    /* renamed from: f  reason: collision with root package name */
    public static a f34968f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34969b;

    /* renamed from: e  reason: collision with root package name */
    public int f34970e;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<C1818a> f34971g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34972h;

    /* renamed from: i  reason: collision with root package name */
    public BDLocation f34973i;

    /* renamed from: j  reason: collision with root package name */
    public BDLocation f34974j;
    public BDLocation k;
    public boolean l;
    public boolean m;
    public b n;

    /* renamed from: com.baidu.location.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C1818a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Messenger f34975b;

        /* renamed from: c  reason: collision with root package name */
        public LocationClientOption f34976c;

        /* renamed from: d  reason: collision with root package name */
        public int f34977d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f34978e;

        public C1818a(a aVar, Message message) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, message};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34978e = aVar;
            this.a = null;
            this.f34975b = null;
            this.f34976c = new LocationClientOption();
            boolean z = false;
            this.f34977d = 0;
            this.f34975b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.f34976c.prodName = message.getData().getString("prodName");
            com.baidu.location.e.b.a().a(this.f34976c.prodName, this.a);
            this.f34976c.coorType = message.getData().getString("coorType");
            this.f34976c.addrType = message.getData().getString("addrType");
            this.f34976c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.e.k.m = com.baidu.location.e.k.m || this.f34976c.enableSimulateGps;
            if (!com.baidu.location.e.k.f35198g.equals("all")) {
                com.baidu.location.e.k.f35198g = this.f34976c.addrType;
            }
            this.f34976c.openGps = message.getData().getBoolean("openGPS");
            this.f34976c.scanSpan = message.getData().getInt("scanSpan");
            this.f34976c.timeOut = message.getData().getInt("timeOut");
            this.f34976c.priority = message.getData().getInt("priority");
            this.f34976c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.f34976c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.f34976c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.f34976c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.e.k.f35200i = com.baidu.location.e.k.f35200i || this.f34976c.isNeedNewVersionRgc;
            com.baidu.location.e.k.f35199h = com.baidu.location.e.k.f35199h || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.e.k.f35201j = com.baidu.location.e.k.f35201j || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.e.k.S = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i4 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i4 < com.baidu.location.e.k.ag) {
                com.baidu.location.e.k.ag = i4;
            }
            int i5 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i5 >= com.baidu.location.e.k.X) {
                com.baidu.location.e.k.X = i5;
            }
            int i6 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i6 >= com.baidu.location.e.k.Z) {
                com.baidu.location.e.k.Z = i6;
            }
            int i7 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i7 >= com.baidu.location.e.k.Y) {
                com.baidu.location.e.k.Y = i7;
            }
            LocationClientOption locationClientOption = this.f34976c;
            if (locationClientOption.mIsNeedDeviceDirect || locationClientOption.isNeedAltitude) {
                n.a().a(this.f34976c.mIsNeedDeviceDirect);
                n.a().b();
            }
            aVar.f34969b = (aVar.f34969b || this.f34976c.isNeedAltitude) ? true : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
                Message obtain = Message.obtain((Handler) null, i2);
                try {
                    if (this.f34975b != null) {
                        this.f34975b.send(obtain);
                    }
                    this.f34977d = 0;
                } catch (Exception e2) {
                    if (e2 instanceof DeadObjectException) {
                        this.f34977d++;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65538, this, i2, bundle) == null) {
                Message obtain = Message.obtain((Handler) null, i2);
                obtain.setData(bundle);
                try {
                    if (this.f34975b != null) {
                        this.f34975b.send(obtain);
                    }
                    this.f34977d = 0;
                } catch (Exception e2) {
                    if (e2 instanceof DeadObjectException) {
                        this.f34977d++;
                    }
                    e2.printStackTrace();
                }
            }
        }

        private void a(int i2, String str, BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(65539, this, i2, str, bDLocation) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(str, bDLocation);
                bundle.setClassLoader(BDLocation.class.getClassLoader());
                Message obtain = Message.obtain((Handler) null, i2);
                obtain.setData(bundle);
                try {
                    if (this.f34975b != null) {
                        this.f34975b.send(obtain);
                    }
                    this.f34977d = 0;
                } catch (Exception e2) {
                    if (e2 instanceof DeadObjectException) {
                        this.f34977d++;
                    }
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f34976c.location_change_notify) {
                a(com.baidu.location.e.k.f35193b ? 54 : 55);
            }
        }

        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bDLocation) == null) {
                a(bDLocation, 21);
            }
        }

        public void a(BDLocation bDLocation, int i2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bDLocation, i2) == null) {
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                if (i2 == 21) {
                    a(27, "locStr", bDLocation2);
                }
                String str2 = this.f34976c.coorType;
                if (str2 != null && !str2.equals("gcj02")) {
                    double longitude = bDLocation2.getLongitude();
                    double latitude = bDLocation2.getLatitude();
                    if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                        if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                            double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f34976c.coorType);
                            bDLocation2.setLongitude(coorEncrypt[0]);
                            bDLocation2.setLatitude(coorEncrypt[1]);
                            str = this.f34976c.coorType;
                        } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.WGS84)) {
                            double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, this.f34976c.coorType);
                            bDLocation2.setLongitude(coorEncrypt2[0]);
                            bDLocation2.setLatitude(coorEncrypt2[1]);
                            str = this.f34976c.coorType.equals("bd09ll") ? "wgs84mc" : "wgs84mc";
                        }
                        bDLocation2.setCoorType(str);
                    }
                }
                a(i2, "locStr", bDLocation2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        public int f34979b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34980c;

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34980c) {
                return;
            }
            this.f34979b++;
            this.a.m = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723283, "Lcom/baidu/location/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723283, "Lcom/baidu/location/b/a;");
        }
    }

    public a() {
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
        this.f34971g = null;
        this.f34972h = false;
        this.a = false;
        this.f34969b = false;
        this.f34973i = null;
        this.f34974j = null;
        this.f34970e = 0;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = null;
        this.f34971g = new ArrayList<>();
    }

    private C1818a a(Messenger messenger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, messenger)) == null) {
            ArrayList<C1818a> arrayList = this.f34971g;
            if (arrayList == null) {
                return null;
            }
            Iterator<C1818a> it = arrayList.iterator();
            while (it.hasNext()) {
                C1818a next = it.next();
                if (next.f34975b.equals(messenger)) {
                    return next;
                }
            }
            return null;
        }
        return (C1818a) invokeL.objValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f34968f == null) {
                f34968f = new a();
            }
            return f34968f;
        }
        return (a) invokeV.objValue;
    }

    private void a(C1818a c1818a) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, c1818a) == null) || c1818a == null) {
            return;
        }
        if (a(c1818a.f34975b) != null) {
            i2 = 14;
        } else {
            this.f34971g.add(c1818a);
            i2 = 13;
        }
        c1818a.a(i2);
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            Intent intent = new Intent("com.baidu.location.flp.log");
            intent.setPackage("com.baidu.baidulocationdemo");
            intent.putExtra("data", str);
            intent.putExtra("pack", com.baidu.location.e.b.f35159e);
            intent.putExtra("tag", "state");
            com.baidu.location.f.getServiceContext().sendBroadcast(intent);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            f();
            d();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Iterator<C1818a> it = this.f34971g.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                C1818a next = it.next();
                if (next.f34976c.openGps) {
                    z2 = true;
                }
                if (next.f34976c.location_change_notify) {
                    z = true;
                }
            }
            com.baidu.location.e.k.a = z;
            if (this.f34972h != z2) {
                this.f34972h = z2;
                com.baidu.location.c.e.a().a(this.f34972h);
            }
        }
    }

    public void a(Bundle bundle, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bundle, i2) == null) {
            Iterator<C1818a> it = this.f34971g.iterator();
            while (it.hasNext()) {
                try {
                    C1818a next = it.next();
                    next.a(i2, bundle);
                    if (next.f34977d > 4) {
                        it.remove();
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) || message == null || message.replyTo == null) {
            return;
        }
        f34966c = System.currentTimeMillis();
        this.a = true;
        com.baidu.location.c.i.a().b();
        a(new C1818a(this, message));
        e();
        if (this.l) {
            b("start");
            this.f34970e = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bDLocation) == null) {
            b(bDLocation);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            c(new BDLocation(str));
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
            f34967d = z ? 1 : 0;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f34971g.clear();
            this.f34973i = null;
            e();
        }
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
            C1818a a = a(message.replyTo);
            if (a != null) {
                this.f34971g.remove(a);
            }
            n.a().c();
            e();
            if (this.l) {
                b(IntentConfig.STOP);
                this.f34970e = 0;
            }
        }
    }

    public void b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bDLocation) == null) {
            try {
                if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().b()) {
                    Iterator<C1818a> it = this.f34971g.iterator();
                    while (it.hasNext()) {
                        C1818a next = it.next();
                        next.a(bDLocation);
                        if (next.f34977d > 4) {
                            it.remove();
                        }
                    }
                } else {
                    if (this.f34974j == null) {
                        BDLocation bDLocation3 = new BDLocation();
                        this.f34974j = bDLocation3;
                        bDLocation3.setLocType(505);
                    }
                    Iterator<C1818a> it2 = this.f34971g.iterator();
                    while (it2.hasNext()) {
                        C1818a next2 = it2.next();
                        next2.a(this.f34974j);
                        if (next2.f34977d > 4) {
                            it2.remove();
                        }
                    }
                }
            } catch (Exception unused) {
            }
            boolean z = l.f35057g;
            if (z) {
                l.f35057g = false;
            }
            if (com.baidu.location.e.k.X >= 10000) {
                if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                    BDLocation bDLocation4 = this.f34973i;
                    if (bDLocation4 != null) {
                        float[] fArr = new float[1];
                        Location.distanceBetween(bDLocation4.getLatitude(), this.f34973i.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                        if (fArr[0] <= com.baidu.location.e.k.Z && !z) {
                            return;
                        }
                        this.f34973i = null;
                        bDLocation2 = new BDLocation(bDLocation);
                    } else {
                        bDLocation2 = new BDLocation(bDLocation);
                    }
                    this.f34973i = bDLocation2;
                }
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(256);
            if (this.f34971g.isEmpty()) {
                return "&prod=" + com.baidu.location.e.b.f35160f + ":" + com.baidu.location.e.b.f35159e;
            }
            C1818a c1818a = this.f34971g.get(0);
            String str = c1818a.f34976c.prodName;
            if (str != null) {
                stringBuffer.append(str);
            }
            if (c1818a.a != null) {
                stringBuffer.append(":");
                stringBuffer.append(c1818a.a);
                stringBuffer.append("|");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2 == null || stringBuffer2.equals("")) {
                return null;
            }
            return "&prod=" + stringBuffer2;
        }
        return (String) invokeV.objValue;
    }

    public void c(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bDLocation) == null) {
            Address a = l.c().a(bDLocation);
            String f2 = l.c().f();
            List<Poi> g2 = l.c().g();
            if (a != null) {
                bDLocation.setAddr(a);
            }
            if (f2 != null) {
                bDLocation.setLocationDescribe(f2);
            }
            if (g2 != null) {
                bDLocation.setPoiList(g2);
            }
            a(bDLocation);
            l.c().c(bDLocation);
        }
    }

    public boolean c(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, message)) == null) {
            C1818a a = a(message.replyTo);
            boolean z = false;
            if (a == null) {
                return false;
            }
            LocationClientOption locationClientOption = a.f34976c;
            int i2 = locationClientOption.scanSpan;
            locationClientOption.scanSpan = message.getData().getInt("scanSpan", a.f34976c.scanSpan);
            if (a.f34976c.scanSpan < 1000) {
                n.a().c();
                this.a = false;
            } else {
                this.a = true;
            }
            LocationClientOption locationClientOption2 = a.f34976c;
            if (locationClientOption2.scanSpan > 999 && i2 < 1000) {
                if (locationClientOption2.mIsNeedDeviceDirect || locationClientOption2.isNeedAltitude) {
                    n.a().a(a.f34976c.mIsNeedDeviceDirect);
                    n.a().b();
                }
                this.f34969b = (this.f34969b || a.f34976c.isNeedAltitude) ? true : true;
                z = true;
            }
            a.f34976c.openGps = message.getData().getBoolean("openGPS", a.f34976c.openGps);
            String string = message.getData().getString("coorType");
            LocationClientOption locationClientOption3 = a.f34976c;
            if (string == null || string.equals("")) {
                string = a.f34976c.coorType;
            }
            locationClientOption3.coorType = string;
            String string2 = message.getData().getString("addrType");
            LocationClientOption locationClientOption4 = a.f34976c;
            if (string2 == null || string2.equals("")) {
                string2 = a.f34976c.addrType;
            }
            locationClientOption4.addrType = string2;
            if (!com.baidu.location.e.k.f35198g.equals(a.f34976c.addrType)) {
                l.c().i();
            }
            a.f34976c.timeOut = message.getData().getInt("timeOut", a.f34976c.timeOut);
            a.f34976c.location_change_notify = message.getData().getBoolean("location_change_notify", a.f34976c.location_change_notify);
            a.f34976c.priority = message.getData().getInt("priority", a.f34976c.priority);
            int i3 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i3 < com.baidu.location.e.k.ag) {
                com.baidu.location.e.k.ag = i3;
            }
            e();
            return z;
        }
        return invokeL.booleanValue;
    }

    public int d(Message message) {
        InterceptResult invokeL;
        Messenger messenger;
        C1818a a;
        LocationClientOption locationClientOption;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, message)) == null) {
            if (message == null || (messenger = message.replyTo) == null || (a = a(messenger)) == null || (locationClientOption = a.f34976c) == null) {
                return 1;
            }
            return locationClientOption.priority;
        }
        return invokeL.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Iterator<C1818a> it = this.f34971g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public int e(Message message) {
        InterceptResult invokeL;
        Messenger messenger;
        C1818a a;
        LocationClientOption locationClientOption;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, message)) == null) {
            if (message == null || (messenger = message.replyTo) == null || (a = a(messenger)) == null || (locationClientOption = a.f34976c) == null) {
                return 1000;
            }
            return locationClientOption.scanSpan;
        }
        return invokeL.intValue;
    }
}
