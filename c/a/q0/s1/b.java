package c.a.q0.s1;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.a.e.e.i.a;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b implements c.a.e.e.i.b {
    public static /* synthetic */ Interceptable $ic;
    public static b n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f24288a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24289b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f24290c;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f24291d;

    /* renamed from: e  reason: collision with root package name */
    public Address f24292e;

    /* renamed from: f  reason: collision with root package name */
    public long f24293f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f24294g;

    /* renamed from: h  reason: collision with root package name */
    public int f24295h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24296i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f24297j;
    public Runnable k;
    public final LocationListener l;
    public final LocationListener m;

    /* loaded from: classes3.dex */
    public class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24298a;

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
            this.f24298a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f24298a.f24294g.hasMessages(0)) {
                    this.f24298a.f24294g.removeMessages(0);
                }
                this.f24298a.f24294g.removeCallbacks(this.f24298a.k);
                this.f24298a.f24294g.removeCallbacks(this.f24298a.f24297j);
                if (this.f24298a.f24288a != null) {
                    return;
                }
                this.f24298a.f24288a = new f(this.f24298a, null);
                this.f24298a.f24288a.setSelfExecute(true);
                this.f24298a.f24288a.execute(location);
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
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, bundle) == null) {
            }
        }
    }

    /* renamed from: c.a.q0.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1122b implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24299a;

        public C1122b(b bVar) {
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
            this.f24299a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f24299a.f24294g.hasMessages(0)) {
                    this.f24299a.f24294g.removeMessages(0);
                }
                this.f24299a.f24294g.removeCallbacks(this.f24299a.k);
                this.f24299a.f24294g.removeCallbacks(this.f24299a.f24297j);
                if (this.f24299a.f24288a != null) {
                    return;
                }
                this.f24299a.f24288a = new f(this.f24299a, null);
                this.f24299a.f24288a.setSelfExecute(true);
                this.f24299a.f24288a.execute(location);
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
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, bundle) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24300e;

        public c(b bVar) {
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
            this.f24300e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24300e.f24291d != null && PermissionUtil.checkLocationForGoogle(this.f24300e.f24289b)) {
                try {
                    this.f24300e.f24291d.requestLocationUpdates("network", 10000L, 100.0f, this.f24300e.l);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24301e;

        public d(b bVar) {
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
            this.f24301e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24301e.f24291d != null && PermissionUtil.checkLocationForGoogle(this.f24301e.f24289b)) {
                try {
                    this.f24301e.f24291d.requestLocationUpdates("gps", 10000L, 100.0f, this.f24301e.m);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24302e;

        public e(b bVar) {
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
            this.f24302e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f24302e.c();
                this.f24302e.f24290c.a(this.f24302e.f24295h, "", null, this.f24302e.f24293f, this.f24302e.f24296i);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<Location, Void, Address> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24303a;

        public f(b bVar) {
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
            this.f24303a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Address doInBackground(Location... locationArr) {
            InterceptResult invokeL;
            List<Address> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, locationArr)) == null) {
                Geocoder geocoder = new Geocoder(this.f24303a.f24289b, Locale.getDefault());
                if (locationArr != null && locationArr.length >= 1) {
                    Location location = locationArr[0];
                    try {
                        list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    } catch (IOException | IllegalArgumentException unused) {
                        list = null;
                    }
                    if (list != null && list.size() > 0) {
                        Address address = list.get(0);
                        StringBuffer stringBuffer = new StringBuffer();
                        if (address.getSubLocality() == null || address.getThoroughfare() == null) {
                            stringBuffer.append(address.getLocality());
                        }
                        stringBuffer.append(address.getSubLocality());
                        stringBuffer.append(address.getThoroughfare());
                        address.setAddressLine(0, stringBuffer.toString());
                        return address;
                    }
                }
                return null;
            }
            return (Address) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, address) == null) {
                super.onPostExecute(address);
                this.f24303a.f24288a = null;
                if (address != null) {
                    this.f24303a.c();
                    this.f24303a.f24293f = System.currentTimeMillis();
                    this.f24303a.f24292e = address;
                    this.f24303a.f24290c.a(0, "", this.f24303a.f24292e, this.f24303a.f24293f, this.f24303a.f24296i);
                    c.a.q0.x2.j0.a.e().i(String.valueOf(address.getLatitude()));
                    c.a.q0.x2.j0.a.e().j(String.valueOf(address.getLongitude()));
                    c.a.q0.x2.j0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreCancel();
                this.f24303a.f24288a = null;
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24288a = null;
        this.f24290c = null;
        this.f24292e = null;
        this.f24293f = 0L;
        this.f24294g = null;
        this.f24296i = false;
        this.f24297j = null;
        this.k = null;
        this.l = new a(this);
        this.m = new C1122b(this);
    }

    public static b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (n == null) {
                synchronized (b.class) {
                    if (n == null) {
                        n = new b();
                    }
                }
            }
            return n;
        }
        return (b) invokeV.objValue;
    }

    @Override // c.a.e.e.i.b
    public void a(boolean z) {
        LocationManager locationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f24290c == null || (locationManager = this.f24291d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f24295h = 4;
                this.f24296i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f24295h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f24289b) && (this.f24291d.isProviderEnabled("gps") || this.f24291d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f24289b) && this.f24291d.isProviderEnabled("gps")) {
                    this.f24294g.post(this.k);
                } else {
                    this.f24295h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f24289b) && this.f24291d.isProviderEnabled("network")) {
                        this.f24294g.post(this.f24297j);
                    } else {
                        this.f24295h = 2;
                    }
                }
                return;
            }
            this.f24295h = 3;
            this.f24294g.sendMessageDelayed(this.f24294g.obtainMessage(0), c.a.e.e.i.a.l().m());
        } finally {
            Handler handler = this.f24294g;
            handler.sendMessageDelayed(handler.obtainMessage(0), c.a.e.e.i.a.l().m());
        }
    }

    @Override // c.a.e.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f24289b = context;
            this.f24290c = dVar;
            try {
                this.f24291d = (LocationManager) context.getSystemService("location");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.f24297j = new c(this);
            this.k = new d(this);
            u();
        }
    }

    @Override // c.a.e.e.i.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f24294g.hasMessages(0)) {
                this.f24294g.removeMessages(0);
            }
            this.f24294g.removeCallbacks(this.k);
            this.f24294g.removeCallbacks(this.f24297j);
            LocationManager locationManager = this.f24291d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f24291d.removeUpdates(this.m);
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            f fVar = this.f24288a;
            if (fVar != null) {
                fVar.cancel();
                this.f24288a = null;
            }
        }
    }

    @Override // c.a.e.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f24294g.hasMessages(0)) {
                this.f24294g.removeMessages(0);
            }
            this.f24294g.removeCallbacks(this.k);
            this.f24294g.removeCallbacks(this.f24297j);
            LocationManager locationManager = this.f24291d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f24291d.removeUpdates(this.m);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
            f fVar = this.f24288a;
            if (fVar != null) {
                fVar.cancel();
                this.f24288a = null;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f24294g = new Handler(Looper.getMainLooper(), new e(this));
        }
    }
}
