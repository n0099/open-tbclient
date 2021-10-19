package c.a.r0.u1;

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
    public f f25150a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25151b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f25152c;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f25153d;

    /* renamed from: e  reason: collision with root package name */
    public Address f25154e;

    /* renamed from: f  reason: collision with root package name */
    public long f25155f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f25156g;

    /* renamed from: h  reason: collision with root package name */
    public int f25157h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25158i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f25159j;
    public Runnable k;
    public final LocationListener l;
    public final LocationListener m;

    /* loaded from: classes3.dex */
    public class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25160a;

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
            this.f25160a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f25160a.f25156g.hasMessages(0)) {
                    this.f25160a.f25156g.removeMessages(0);
                }
                this.f25160a.f25156g.removeCallbacks(this.f25160a.k);
                this.f25160a.f25156g.removeCallbacks(this.f25160a.f25159j);
                if (this.f25160a.f25150a != null) {
                    return;
                }
                this.f25160a.f25150a = new f(this.f25160a, null);
                this.f25160a.f25150a.setSelfExecute(true);
                this.f25160a.f25150a.execute(location);
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

    /* renamed from: c.a.r0.u1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1167b implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25161a;

        public C1167b(b bVar) {
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
            this.f25161a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f25161a.f25156g.hasMessages(0)) {
                    this.f25161a.f25156g.removeMessages(0);
                }
                this.f25161a.f25156g.removeCallbacks(this.f25161a.k);
                this.f25161a.f25156g.removeCallbacks(this.f25161a.f25159j);
                if (this.f25161a.f25150a != null) {
                    return;
                }
                this.f25161a.f25150a = new f(this.f25161a, null);
                this.f25161a.f25150a.setSelfExecute(true);
                this.f25161a.f25150a.execute(location);
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
        public final /* synthetic */ b f25162e;

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
            this.f25162e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f25162e.f25153d != null && PermissionUtil.checkLocationForGoogle(this.f25162e.f25151b)) {
                try {
                    this.f25162e.f25153d.requestLocationUpdates("network", 10000L, 100.0f, this.f25162e.l);
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
        public final /* synthetic */ b f25163e;

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
            this.f25163e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f25163e.f25153d != null && PermissionUtil.checkLocationForGoogle(this.f25163e.f25151b)) {
                try {
                    this.f25163e.f25153d.requestLocationUpdates("gps", 10000L, 100.0f, this.f25163e.m);
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
        public final /* synthetic */ b f25164e;

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
            this.f25164e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f25164e.c();
                this.f25164e.f25152c.a(this.f25164e.f25157h, "", null, this.f25164e.f25155f, this.f25164e.f25158i);
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
        public final /* synthetic */ b f25165a;

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
            this.f25165a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Address doInBackground(Location... locationArr) {
            InterceptResult invokeL;
            List<Address> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, locationArr)) == null) {
                Geocoder geocoder = new Geocoder(this.f25165a.f25151b, Locale.getDefault());
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
                this.f25165a.f25150a = null;
                if (address != null) {
                    this.f25165a.c();
                    this.f25165a.f25155f = System.currentTimeMillis();
                    this.f25165a.f25154e = address;
                    this.f25165a.f25152c.a(0, "", this.f25165a.f25154e, this.f25165a.f25155f, this.f25165a.f25158i);
                    c.a.r0.z2.j0.a.e().i(String.valueOf(address.getLatitude()));
                    c.a.r0.z2.j0.a.e().j(String.valueOf(address.getLongitude()));
                    c.a.r0.z2.j0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreCancel();
                this.f25165a.f25150a = null;
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
        this.f25150a = null;
        this.f25152c = null;
        this.f25154e = null;
        this.f25155f = 0L;
        this.f25156g = null;
        this.f25158i = false;
        this.f25159j = null;
        this.k = null;
        this.l = new a(this);
        this.m = new C1167b(this);
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
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25152c == null || (locationManager = this.f25153d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f25157h = 4;
                this.f25158i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f25157h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f25151b) && (this.f25153d.isProviderEnabled("gps") || this.f25153d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f25151b) && this.f25153d.isProviderEnabled("gps")) {
                    this.f25156g.post(this.k);
                } else {
                    this.f25157h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f25151b) && this.f25153d.isProviderEnabled("network")) {
                        this.f25156g.post(this.f25159j);
                    } else {
                        this.f25157h = 2;
                    }
                }
                return;
            }
            this.f25157h = 3;
            this.f25156g.sendMessageDelayed(this.f25156g.obtainMessage(0), c.a.e.e.i.a.l().m());
        } finally {
            Handler handler = this.f25156g;
            handler.sendMessageDelayed(handler.obtainMessage(0), c.a.e.e.i.a.l().m());
        }
    }

    @Override // c.a.e.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f25151b = context;
            this.f25152c = dVar;
            try {
                this.f25153d = (LocationManager) context.getSystemService("location");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.f25159j = new c(this);
            this.k = new d(this);
            u();
        }
    }

    @Override // c.a.e.e.i.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f25156g.hasMessages(0)) {
                this.f25156g.removeMessages(0);
            }
            this.f25156g.removeCallbacks(this.k);
            this.f25156g.removeCallbacks(this.f25159j);
            LocationManager locationManager = this.f25153d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f25153d.removeUpdates(this.m);
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            f fVar = this.f25150a;
            if (fVar != null) {
                fVar.cancel();
                this.f25150a = null;
            }
        }
    }

    @Override // c.a.e.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f25156g.hasMessages(0)) {
                this.f25156g.removeMessages(0);
            }
            this.f25156g.removeCallbacks(this.k);
            this.f25156g.removeCallbacks(this.f25159j);
            LocationManager locationManager = this.f25153d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f25153d.removeUpdates(this.m);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
            f fVar = this.f25150a;
            if (fVar != null) {
                fVar.cancel();
                this.f25150a = null;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f25156g = new Handler(Looper.getMainLooper(), new e(this));
        }
    }
}
