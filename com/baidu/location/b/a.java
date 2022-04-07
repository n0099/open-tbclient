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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long c = 0;
    public static int d = -1;
    public static a f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int e;
    public ArrayList<C0098a> g;
    public boolean h;
    public BDLocation i;
    public BDLocation j;
    public BDLocation k;
    public boolean l;
    public boolean m;
    public b n;

    /* renamed from: com.baidu.location.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0098a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Messenger b;
        public LocationClientOption c;
        public int d;
        public final /* synthetic */ a e;

        public C0098a(a aVar, Message message) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, message};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = aVar;
            this.a = null;
            this.b = null;
            this.c = new LocationClientOption();
            boolean z = false;
            this.d = 0;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.e.b.a().a(this.c.prodName, this.a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.e.k.m = com.baidu.location.e.k.m || this.c.enableSimulateGps;
            if (!com.baidu.location.e.k.g.equals("all")) {
                com.baidu.location.e.k.g = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.e.k.i = com.baidu.location.e.k.i || this.c.isNeedNewVersionRgc;
            com.baidu.location.e.k.h = com.baidu.location.e.k.h || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.e.k.j = com.baidu.location.e.k.j || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.e.k.S = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i3 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i3 < com.baidu.location.e.k.ag) {
                com.baidu.location.e.k.ag = i3;
            }
            int i4 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i4 >= com.baidu.location.e.k.X) {
                com.baidu.location.e.k.X = i4;
            }
            int i5 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i5 >= com.baidu.location.e.k.Z) {
                com.baidu.location.e.k.Z = i5;
            }
            int i6 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i6 >= com.baidu.location.e.k.Y) {
                com.baidu.location.e.k.Y = i6;
            }
            LocationClientOption locationClientOption = this.c;
            if (locationClientOption.mIsNeedDeviceDirect || locationClientOption.isNeedAltitude) {
                n.a().a(this.c.mIsNeedDeviceDirect);
                n.a().b();
            }
            aVar.b = (aVar.b || this.c.isNeedAltitude) ? true : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
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
            if (interceptable == null || interceptable.invokeIL(65538, this, i, bundle) == null) {
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
            if (interceptable == null || interceptable.invokeILL(65539, this, i, str, bDLocation) == null) {
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

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.location_change_notify) {
                a(com.baidu.location.e.k.b ? 54 : 55);
            }
        }

        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bDLocation) == null) {
                a(bDLocation, 21);
            }
        }

        public void a(BDLocation bDLocation, int i) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bDLocation, i) == null) {
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                if (i == 21) {
                    a(27, "locStr", bDLocation2);
                }
                String str2 = this.c.coorType;
                if (str2 != null && !str2.equals("gcj02")) {
                    double longitude = bDLocation2.getLongitude();
                    double latitude = bDLocation2.getLatitude();
                    if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                        if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                            double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                            bDLocation2.setLongitude(coorEncrypt[0]);
                            bDLocation2.setLatitude(coorEncrypt[1]);
                            str = this.c.coorType;
                        } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.WGS84)) {
                            double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                            bDLocation2.setLongitude(coorEncrypt2[0]);
                            bDLocation2.setLatitude(coorEncrypt2[1]);
                            str = this.c.coorType.equals("bd09ll") ? "wgs84mc" : "wgs84mc";
                        }
                        bDLocation2.setCoorType(str);
                    }
                }
                a(i, "locStr", bDLocation2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = false;
        this.a = false;
        this.b = false;
        this.i = null;
        this.j = null;
        this.e = 0;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = null;
        this.g = new ArrayList<>();
    }

    private C0098a a(Messenger messenger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, messenger)) == null) {
            ArrayList<C0098a> arrayList = this.g;
            if (arrayList == null) {
                return null;
            }
            Iterator<C0098a> it = arrayList.iterator();
            while (it.hasNext()) {
                C0098a next = it.next();
                if (next.b.equals(messenger)) {
                    return next;
                }
            }
            return null;
        }
        return (C0098a) invokeL.objValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f == null) {
                f = new a();
            }
            return f;
        }
        return (a) invokeV.objValue;
    }

    private void a(C0098a c0098a) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, c0098a) == null) || c0098a == null) {
            return;
        }
        if (a(c0098a.b) != null) {
            i = 14;
        } else {
            this.g.add(c0098a);
            i = 13;
        }
        c0098a.a(i);
    }

    private void b(String str) {
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
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            f();
            d();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Iterator<C0098a> it = this.g.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                C0098a next = it.next();
                if (next.c.openGps) {
                    z2 = true;
                }
                if (next.c.location_change_notify) {
                    z = true;
                }
            }
            com.baidu.location.e.k.a = z;
            if (this.h != z2) {
                this.h = z2;
                com.baidu.location.c.e.a().a(this.h);
            }
        }
    }

    public void a(Bundle bundle, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bundle, i) == null) {
            Iterator<C0098a> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    C0098a next = it.next();
                    next.a(i, bundle);
                    if (next.d > 4) {
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
        c = System.currentTimeMillis();
        this.a = true;
        com.baidu.location.c.i.a().b();
        a(new C0098a(this, message));
        e();
        if (this.l) {
            b("start");
            this.e = 0;
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
            d = z ? 1 : 0;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g.clear();
            this.i = null;
            e();
        }
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
            C0098a a = a(message.replyTo);
            if (a != null) {
                this.g.remove(a);
            }
            n.a().c();
            e();
            if (this.l) {
                b(IntentConfig.STOP);
                this.e = 0;
            }
        }
    }

    public void b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bDLocation) == null) {
            try {
                if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().b()) {
                    Iterator<C0098a> it = this.g.iterator();
                    while (it.hasNext()) {
                        C0098a next = it.next();
                        next.a(bDLocation);
                        if (next.d > 4) {
                            it.remove();
                        }
                    }
                } else {
                    if (this.j == null) {
                        BDLocation bDLocation3 = new BDLocation();
                        this.j = bDLocation3;
                        bDLocation3.setLocType(505);
                    }
                    Iterator<C0098a> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        C0098a next2 = it2.next();
                        next2.a(this.j);
                        if (next2.d > 4) {
                            it2.remove();
                        }
                    }
                }
            } catch (Exception unused) {
            }
            boolean z = l.g;
            if (z) {
                l.g = false;
            }
            if (com.baidu.location.e.k.X >= 10000) {
                if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                    BDLocation bDLocation4 = this.i;
                    if (bDLocation4 != null) {
                        float[] fArr = new float[1];
                        Location.distanceBetween(bDLocation4.getLatitude(), this.i.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                        if (fArr[0] <= com.baidu.location.e.k.Z && !z) {
                            return;
                        }
                        this.i = null;
                        bDLocation2 = new BDLocation(bDLocation);
                    } else {
                        bDLocation2 = new BDLocation(bDLocation);
                    }
                    this.i = bDLocation2;
                }
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(256);
            if (this.g.isEmpty()) {
                return "&prod=" + com.baidu.location.e.b.f + ":" + com.baidu.location.e.b.e;
            }
            C0098a c0098a = this.g.get(0);
            String str = c0098a.c.prodName;
            if (str != null) {
                stringBuffer.append(str);
            }
            if (c0098a.a != null) {
                stringBuffer.append(":");
                stringBuffer.append(c0098a.a);
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
            List<Poi> g = l.c().g();
            if (a != null) {
                bDLocation.setAddr(a);
            }
            if (f2 != null) {
                bDLocation.setLocationDescribe(f2);
            }
            if (g != null) {
                bDLocation.setPoiList(g);
            }
            a(bDLocation);
            l.c().c(bDLocation);
        }
    }

    public boolean c(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, message)) == null) {
            C0098a a = a(message.replyTo);
            boolean z = false;
            if (a == null) {
                return false;
            }
            LocationClientOption locationClientOption = a.c;
            int i = locationClientOption.scanSpan;
            locationClientOption.scanSpan = message.getData().getInt("scanSpan", a.c.scanSpan);
            if (a.c.scanSpan < 1000) {
                n.a().c();
                this.a = false;
            } else {
                this.a = true;
            }
            LocationClientOption locationClientOption2 = a.c;
            if (locationClientOption2.scanSpan > 999 && i < 1000) {
                if (locationClientOption2.mIsNeedDeviceDirect || locationClientOption2.isNeedAltitude) {
                    n.a().a(a.c.mIsNeedDeviceDirect);
                    n.a().b();
                }
                this.b = (this.b || a.c.isNeedAltitude) ? true : true;
                z = true;
            }
            a.c.openGps = message.getData().getBoolean("openGPS", a.c.openGps);
            String string = message.getData().getString("coorType");
            LocationClientOption locationClientOption3 = a.c;
            if (string == null || string.equals("")) {
                string = a.c.coorType;
            }
            locationClientOption3.coorType = string;
            String string2 = message.getData().getString("addrType");
            LocationClientOption locationClientOption4 = a.c;
            if (string2 == null || string2.equals("")) {
                string2 = a.c.addrType;
            }
            locationClientOption4.addrType = string2;
            if (!com.baidu.location.e.k.g.equals(a.c.addrType)) {
                l.c().i();
            }
            a.c.timeOut = message.getData().getInt("timeOut", a.c.timeOut);
            a.c.location_change_notify = message.getData().getBoolean("location_change_notify", a.c.location_change_notify);
            a.c.priority = message.getData().getInt("priority", a.c.priority);
            int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i2 < com.baidu.location.e.k.ag) {
                com.baidu.location.e.k.ag = i2;
            }
            e();
            return z;
        }
        return invokeL.booleanValue;
    }

    public int d(Message message) {
        InterceptResult invokeL;
        Messenger messenger;
        C0098a a;
        LocationClientOption locationClientOption;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, message)) == null) {
            if (message == null || (messenger = message.replyTo) == null || (a = a(messenger)) == null || (locationClientOption = a.c) == null) {
                return 1;
            }
            return locationClientOption.priority;
        }
        return invokeL.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Iterator<C0098a> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public int e(Message message) {
        InterceptResult invokeL;
        Messenger messenger;
        C0098a a;
        LocationClientOption locationClientOption;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, message)) == null) {
            if (message == null || (messenger = message.replyTo) == null || (a = a(messenger)) == null || (locationClientOption = a.c) == null) {
                return 1000;
            }
            return locationClientOption.scanSpan;
        }
        return invokeL.intValue;
    }
}
