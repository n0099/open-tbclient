package b.a.r0.u1;

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
import b.a.e.e.i.a;
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
/* loaded from: classes5.dex */
public class b implements b.a.e.e.i.b {
    public static /* synthetic */ Interceptable $ic;
    public static b n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f23993a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23994b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f23995c;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f23996d;

    /* renamed from: e  reason: collision with root package name */
    public Address f23997e;

    /* renamed from: f  reason: collision with root package name */
    public long f23998f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f23999g;

    /* renamed from: h  reason: collision with root package name */
    public int f24000h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24001i;
    public Runnable j;
    public Runnable k;
    public final LocationListener l;
    public final LocationListener m;

    /* loaded from: classes5.dex */
    public class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24002a;

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
            this.f24002a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f24002a.f23999g.hasMessages(0)) {
                    this.f24002a.f23999g.removeMessages(0);
                }
                this.f24002a.f23999g.removeCallbacks(this.f24002a.k);
                this.f24002a.f23999g.removeCallbacks(this.f24002a.j);
                if (this.f24002a.f23993a != null) {
                    return;
                }
                this.f24002a.f23993a = new f(this.f24002a, null);
                this.f24002a.f23993a.setSelfExecute(true);
                this.f24002a.f23993a.execute(location);
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

    /* renamed from: b.a.r0.u1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1166b implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24003a;

        public C1166b(b bVar) {
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
            this.f24003a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f24003a.f23999g.hasMessages(0)) {
                    this.f24003a.f23999g.removeMessages(0);
                }
                this.f24003a.f23999g.removeCallbacks(this.f24003a.k);
                this.f24003a.f23999g.removeCallbacks(this.f24003a.j);
                if (this.f24003a.f23993a != null) {
                    return;
                }
                this.f24003a.f23993a = new f(this.f24003a, null);
                this.f24003a.f23993a.setSelfExecute(true);
                this.f24003a.f23993a.execute(location);
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

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24004e;

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
            this.f24004e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24004e.f23996d != null && PermissionUtil.checkLocationForGoogle(this.f24004e.f23994b)) {
                try {
                    this.f24004e.f23996d.requestLocationUpdates("network", 10000L, 100.0f, this.f24004e.l);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24005e;

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
            this.f24005e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24005e.f23996d != null && PermissionUtil.checkLocationForGoogle(this.f24005e.f23994b)) {
                try {
                    this.f24005e.f23996d.requestLocationUpdates("gps", 10000L, 100.0f, this.f24005e.m);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24006e;

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
            this.f24006e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f24006e.c();
                this.f24006e.f23995c.a(this.f24006e.f24000h, "", null, this.f24006e.f23998f, this.f24006e.f24001i);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<Location, Void, Address> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24007a;

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
            this.f24007a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Address doInBackground(Location... locationArr) {
            InterceptResult invokeL;
            List<Address> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, locationArr)) == null) {
                Geocoder geocoder = new Geocoder(this.f24007a.f23994b, Locale.getDefault());
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
                this.f24007a.f23993a = null;
                if (address != null) {
                    this.f24007a.c();
                    this.f24007a.f23998f = System.currentTimeMillis();
                    this.f24007a.f23997e = address;
                    this.f24007a.f23995c.a(0, "", this.f24007a.f23997e, this.f24007a.f23998f, this.f24007a.f24001i);
                    b.a.r0.z2.j0.a.e().i(String.valueOf(address.getLatitude()));
                    b.a.r0.z2.j0.a.e().j(String.valueOf(address.getLongitude()));
                    b.a.r0.z2.j0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreCancel();
                this.f24007a.f23993a = null;
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
        this.f23993a = null;
        this.f23995c = null;
        this.f23997e = null;
        this.f23998f = 0L;
        this.f23999g = null;
        this.f24001i = false;
        this.j = null;
        this.k = null;
        this.l = new a(this);
        this.m = new C1166b(this);
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

    @Override // b.a.e.e.i.b
    public void a(boolean z) {
        LocationManager locationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f23995c == null || (locationManager = this.f23996d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f24000h = 4;
                this.f24001i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f24000h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f23994b) && (this.f23996d.isProviderEnabled("gps") || this.f23996d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f23994b) && this.f23996d.isProviderEnabled("gps")) {
                    this.f23999g.post(this.k);
                } else {
                    this.f24000h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f23994b) && this.f23996d.isProviderEnabled("network")) {
                        this.f23999g.post(this.j);
                    } else {
                        this.f24000h = 2;
                    }
                }
                return;
            }
            this.f24000h = 3;
            this.f23999g.sendMessageDelayed(this.f23999g.obtainMessage(0), b.a.e.e.i.a.n().o());
        } finally {
            Handler handler = this.f23999g;
            handler.sendMessageDelayed(handler.obtainMessage(0), b.a.e.e.i.a.n().o());
        }
    }

    @Override // b.a.e.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f23994b = context;
            this.f23995c = dVar;
            try {
                this.f23996d = (LocationManager) context.getSystemService("location");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.j = new c(this);
            this.k = new d(this);
            u();
        }
    }

    @Override // b.a.e.e.i.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f23999g.hasMessages(0)) {
                this.f23999g.removeMessages(0);
            }
            this.f23999g.removeCallbacks(this.k);
            this.f23999g.removeCallbacks(this.j);
            LocationManager locationManager = this.f23996d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f23996d.removeUpdates(this.m);
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            f fVar = this.f23993a;
            if (fVar != null) {
                fVar.cancel();
                this.f23993a = null;
            }
        }
    }

    @Override // b.a.e.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f23999g.hasMessages(0)) {
                this.f23999g.removeMessages(0);
            }
            this.f23999g.removeCallbacks(this.k);
            this.f23999g.removeCallbacks(this.j);
            LocationManager locationManager = this.f23996d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f23996d.removeUpdates(this.m);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
            f fVar = this.f23993a;
            if (fVar != null) {
                fVar.cancel();
                this.f23993a = null;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f23999g = new Handler(Looper.getMainLooper(), new e(this));
        }
    }
}
