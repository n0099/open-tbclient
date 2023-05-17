package com.baidu.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.e;
import com.baidu.location.b.o;
import com.baidu.location.e.k;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class LocationClient implements e.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    public static boolean H = false;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    public static String w;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean A;
    public Boolean B;
    public boolean C;
    public com.baidu.location.b.e D;
    public boolean E;
    public boolean F;
    public boolean G;
    public ServiceConnection I;
    public long a;
    public String b;
    public LocationClientOption c;
    public LocationClientOption d;
    public boolean e;
    public Context f;
    public Messenger g;
    public a h;
    public final Messenger i;
    public ArrayList<BDLocationListener> j;
    public ArrayList<BDAbstractLocationListener> k;
    public BDLocation l;
    public boolean m;
    public boolean n;
    public boolean o;
    public b p;
    public boolean q;
    public final Object r;
    public long s;
    public long t;
    public String u;
    public String v;
    public boolean x;
    public boolean y;
    public Boolean z;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<LocationClient> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, LocationClient locationClient) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, locationClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(locationClient);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LocationClient locationClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (locationClient = this.a.get()) == null) {
                return;
            }
            int i = message.what;
            boolean z = true;
            if (i == 21) {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                if (!locationClient.F && locationClient.E && bDLocation.getLocType() == 66) {
                    return;
                }
                if (!locationClient.F && locationClient.E) {
                    locationClient.F = true;
                    return;
                }
                if (!locationClient.F) {
                    locationClient.F = true;
                }
                locationClient.a(message, 21);
                return;
            }
            try {
                if (i == 303) {
                    Bundle data2 = message.getData();
                    int i2 = data2.getInt("loctype");
                    int i3 = data2.getInt("diagtype");
                    byte[] byteArray = data2.getByteArray("diagmessage");
                    if (i2 <= 0 || i3 <= 0 || byteArray == null || locationClient.k == null) {
                        return;
                    }
                    Iterator it = locationClient.k.iterator();
                    while (it.hasNext()) {
                        ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i2, i3, new String(byteArray, "UTF-8"));
                    }
                } else if (i == 406) {
                    Bundle data3 = message.getData();
                    byte[] byteArray2 = data3.getByteArray("mac");
                    String str = byteArray2 != null ? new String(byteArray2, "UTF-8") : null;
                    int i4 = data3.getInt("hotspot", -1);
                    if (locationClient.k != null) {
                        Iterator it2 = locationClient.k.iterator();
                        while (it2.hasNext()) {
                            ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i4);
                        }
                    }
                } else if (i == 701) {
                    locationClient.b((BDLocation) message.obj);
                } else if (i == 1300) {
                    locationClient.c(message);
                } else if (i == 1400) {
                    locationClient.d(message);
                } else {
                    if (i != 54) {
                        z = false;
                        if (i != 55) {
                            if (i == 703) {
                                Bundle data4 = message.getData();
                                int i5 = data4.getInt("id", 0);
                                if (i5 > 0) {
                                    locationClient.a(i5, (Notification) data4.getParcelable("notification"));
                                    return;
                                }
                                return;
                            } else if (i == 704) {
                                locationClient.a(message.getData().getBoolean("removenotify"));
                                return;
                            } else {
                                switch (i) {
                                    case 1:
                                        locationClient.a();
                                        return;
                                    case 2:
                                        locationClient.b();
                                        return;
                                    case 3:
                                        locationClient.a(message);
                                        return;
                                    case 4:
                                        locationClient.e();
                                        return;
                                    case 5:
                                        locationClient.b(message);
                                        return;
                                    case 6:
                                        locationClient.e(message);
                                        return;
                                    default:
                                        super.handleMessage(message);
                                        return;
                                }
                            }
                        } else if (!locationClient.c.location_change_notify) {
                            return;
                        }
                    } else if (!locationClient.c.location_change_notify) {
                        return;
                    }
                    locationClient.q = z;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationClient a;

        public b(LocationClient locationClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = locationClient;
        }

        public /* synthetic */ b(LocationClient locationClient, com.baidu.location.b bVar) {
            this(locationClient);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.r) {
                    this.a.o = false;
                    if (this.a.g != null && this.a.i != null) {
                        if ((this.a.j != null && this.a.j.size() >= 1) || (this.a.k != null && this.a.k.size() >= 1)) {
                            if (!this.a.n) {
                                this.a.h.obtainMessage(4).sendToTarget();
                                return;
                            }
                            if (this.a.p == null) {
                                this.a.p = new b(this.a);
                            }
                            this.a.h.postDelayed(this.a.p, this.a.c.scanSpan);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationClient a;

        public c(LocationClient locationClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = locationClient;
        }

        public /* synthetic */ c(LocationClient locationClient, com.baidu.location.b bVar) {
            this(locationClient);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.B.booleanValue()) {
                        if (this.a.D == null) {
                            this.a.D = new com.baidu.location.b.e(this.a.f, this.a.d, this.a, null);
                        }
                        if (this.a.d.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
                            this.a.D.d();
                            this.a.D.e();
                        }
                    }
                    this.a.h.obtainMessage(1).sendToTarget();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1787192593, "Lcom/baidu/location/LocationClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1787192593, "Lcom/baidu/location/LocationClient;");
        }
    }

    public LocationClient(Context context) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = null;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.e = false;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = false;
        this.r = new Object();
        this.s = 0L;
        this.t = 0L;
        this.u = null;
        this.x = false;
        this.y = true;
        Boolean bool = Boolean.FALSE;
        this.z = bool;
        this.A = bool;
        this.B = Boolean.TRUE;
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = new com.baidu.location.b(this);
        c();
        this.f = context;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locationClientOption};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = null;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.e = false;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = false;
        this.r = new Object();
        this.s = 0L;
        this.t = 0L;
        this.u = null;
        this.x = false;
        this.y = true;
        Boolean bool = Boolean.FALSE;
        this.z = bool;
        this.A = bool;
        this.B = Boolean.TRUE;
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = new com.baidu.location.b(this);
        c();
        this.f = context;
        this.c = locationClientOption;
        this.d = new LocationClientOption(locationClientOption);
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.e) {
            return;
        }
        if (this.B.booleanValue()) {
            boolean c2 = k.c(this.f);
            if (this.d.isOnceLocation()) {
                c2 = true;
            }
            if (c2) {
                try {
                    new com.baidu.location.c(this).start();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.d.isOnceLocation()) {
            return;
        }
        this.B = Boolean.FALSE;
        this.b = this.f.getPackageName();
        this.u = this.b + "_bdls_v2.9";
        Intent intent = new Intent(this.f, f.class);
        try {
            intent.putExtra("debug_dev", this.C);
        } catch (Exception unused2) {
        }
        if (this.c == null) {
            this.c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.c.isIgnoreKillProcess);
        intent.putExtra("auth_key", w);
        try {
            this.f.bindService(intent, this.I, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.e = false;
        }
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            if (this.l.getCoorType() == null) {
                this.l.setCoorType(this.c.coorType);
            }
            if (this.m || ((this.c.location_change_notify && this.l.getLocType() == 61) || this.l.getLocType() == 66 || this.l.getLocType() == 67 || this.x || this.l.getLocType() == 161)) {
                ArrayList<BDLocationListener> arrayList = this.j;
                if (arrayList != null) {
                    Iterator<BDLocationListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onReceiveLocation(this.l);
                    }
                }
                ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
                if (arrayList2 != null) {
                    Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onReceiveLocation(this.l);
                    }
                }
                if (this.l.getLocType() == 66 || this.l.getLocType() == 67) {
                    return;
                }
                this.m = false;
                this.t = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, this, i, notification) == null) {
            try {
                Intent intent = new Intent(this.f, f.class);
                intent.putExtra("notification", notification);
                intent.putExtra("id", i);
                intent.putExtra("command", 1);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f.startForegroundService(intent);
                } else {
                    this.f.startService(intent);
                }
                this.G = true;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, message) == null) {
            this.n = false;
            if (message == null || (obj = message.obj) == null) {
                return;
            }
            LocationClientOption locationClientOption = (LocationClientOption) obj;
            if (this.c.optionEquals(locationClientOption)) {
                return;
            }
            if (this.c.scanSpan != locationClientOption.scanSpan) {
                try {
                    synchronized (this.r) {
                        if (this.o) {
                            this.h.removeCallbacks(this.p);
                            this.o = false;
                        }
                        if (locationClientOption.scanSpan >= 1000 && !this.o) {
                            if (this.p == null) {
                                this.p = new b(this, null);
                            }
                            this.h.postDelayed(this.p, locationClientOption.scanSpan);
                            this.o = true;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.c = new LocationClientOption(locationClientOption);
            if (this.g != null && k.f(this.f) >= 1) {
                try {
                    Message obtain = Message.obtain((Handler) null, 15);
                    obtain.replyTo = this.i;
                    obtain.setData(d());
                    this.g.send(obtain);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65547, this, message, i) == null) && this.e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                this.l = bDLocation;
                if (bDLocation.getLocType() == 61) {
                    this.s = System.currentTimeMillis();
                }
                if (this.l.getLocType() == 61 || this.l.getLocType() == 161) {
                    com.baidu.location.b.a.a().a(this.l.getLatitude(), this.l.getLongitude(), this.l.getCoorType());
                }
                a(i);
            } catch (Exception unused) {
            }
        }
    }

    private void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bDLocation) == null) {
            ArrayList<BDLocationListener> arrayList = this.j;
            if (arrayList != null) {
                Iterator<BDLocationListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(bDLocation);
                }
            }
            ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
            if (arrayList2 != null) {
                Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(bDLocation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            try {
                Intent intent = new Intent(this.f, f.class);
                intent.putExtra("removenotify", z);
                intent.putExtra("command", 2);
                this.f.startService(intent);
                this.G = true;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && this.e && this.g != null) {
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.replyTo = this.i;
            try {
                this.g.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.f.unbindService(this.I);
                if (this.G) {
                    try {
                        this.f.stopService(new Intent(this.f, f.class));
                    } catch (Exception unused) {
                    }
                    this.G = false;
                }
            } catch (Exception unused2) {
            }
            synchronized (this.r) {
                try {
                    if (this.o) {
                        this.h.removeCallbacks(this.p);
                        this.o = false;
                    }
                } catch (Exception unused3) {
                }
            }
            this.g = null;
            this.n = false;
            this.x = false;
            this.e = false;
            this.E = false;
            this.F = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, this, message) == null) || message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        if (this.j.contains(bDLocationListener)) {
            return;
        }
        this.j.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, bDLocation) == null) || this.y) {
            return;
        }
        this.l = bDLocation;
        if (!this.F && bDLocation.getLocType() == 161) {
            this.E = true;
            com.baidu.location.b.a.a().a(bDLocation.getLatitude(), bDLocation.getLongitude(), bDLocation.getCoorType());
        }
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    private void c() throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || H) {
            return;
        }
        Log.e("baidu_location_Client", "The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
        throw new Exception("The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, this, message) == null) || message == null || (obj = message.obj) == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) obj;
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        if (this.k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            if (this.c == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("packName", this.b);
            bundle.putString("prodName", this.c.prodName);
            bundle.putString("coorType", this.c.coorType);
            bundle.putString("addrType", this.c.addrType);
            bundle.putBoolean("openGPS", this.c.openGps);
            bundle.putBoolean("location_change_notify", this.c.location_change_notify);
            bundle.putInt("scanSpan", this.c.scanSpan);
            bundle.putBoolean("enableSimulateGps", this.c.enableSimulateGps);
            bundle.putInt("timeOut", this.c.timeOut);
            bundle.putInt("priority", this.c.priority);
            bundle.putBoolean("map", this.z.booleanValue());
            bundle.putBoolean(ShareDirectionType.IMPORT, this.A.booleanValue());
            bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
            bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
            bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
            bundle.putBoolean("isneedregular", this.c.isNeedRegular);
            bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
            bundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
            bundle.putBoolean("isneednewrgc", this.c.isNeedNewVersionRgc);
            bundle.putInt("autoNotifyMaxInterval", this.c.a());
            bundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
            bundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
            bundle.putFloat("autoNotifyLocSensitivity", this.c.b());
            bundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
            bundle.putInt("wfnum", com.baidu.location.b.a.a().b);
            bundle.putBoolean("ischeckper", com.baidu.location.b.a.a().a);
            bundle.putFloat("wfsm", (float) com.baidu.location.b.a.a().c);
            bundle.putDouble("gnmcrm", com.baidu.location.b.a.a().f);
            bundle.putInt("gnmcon", com.baidu.location.b.a.a().g);
            bundle.putInt("iupl", com.baidu.location.b.a.a().h);
            bundle.putInt("lpcs", com.baidu.location.b.a.a().e);
            bundle.putInt("hpdts", com.baidu.location.b.a.a().o);
            bundle.putInt("oldts", com.baidu.location.b.a.a().p);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, this, message) == null) || message == null || (obj = message.obj) == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) obj;
        ArrayList<BDAbstractLocationListener> arrayList = this.k;
        if (arrayList == null || !arrayList.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.remove(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65572, this) == null) || this.g == null) {
            return;
        }
        int f = k.f(this.f);
        if ((System.currentTimeMillis() - this.s > 3000 || !this.c.location_change_notify || this.n) && f == 1) {
            if (!this.x || System.currentTimeMillis() - this.t > 20000 || this.n) {
                Message obtain = Message.obtain((Handler) null, 22);
                if (this.n) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.n);
                    this.n = false;
                    obtain.setData(bundle);
                }
                try {
                    obtain.replyTo = this.i;
                    this.g.send(obtain);
                    this.a = System.currentTimeMillis();
                    this.m = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (f < 1) {
            BDLocation bDLocation = new BDLocation();
            if (f == -1) {
                i = 69;
            } else if (f == -2) {
                i = 70;
            } else {
                if (f == 0) {
                    i = 71;
                }
                a(bDLocation);
            }
            bDLocation.setLocType(i);
            a(bDLocation);
        }
        synchronized (this.r) {
            if (this.c != null && this.c.scanSpan >= 1000 && !this.o) {
                if (this.p == null) {
                    this.p = new b(this, null);
                }
                this.h.postDelayed(this.p, this.c.scanSpan);
                this.o = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65573, this, message) == null) || message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList == null || !arrayList.contains(bDLocationListener)) {
            return;
        }
        this.j.remove(bDLocationListener);
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, bDLocation, str)) == null) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
            bDLocation2.setLatitude(coorEncrypt[1]);
            bDLocation2.setLongitude(coorEncrypt[0]);
            return bDLocation2;
        }
        return (BDLocation) invokeLL.objValue;
    }

    public static void setAgreePrivacy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65591, null, z) == null) {
            H = z;
        }
    }

    public static void setKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, null, str) == null) {
            w = str;
        }
    }

    public void disableAssistantLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o.a().b();
        }
    }

    public void disableLocInForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("removenotify", z);
            Message obtainMessage = this.h.obtainMessage(704);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public void enableAssistantLocation(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView) == null) {
            o.a().a(this.f, webView, this);
        }
    }

    public void enableLocInForeground(int i, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, notification) == null) {
            if (i <= 0 || notification == null) {
                Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("id", i);
            bundle.putParcelable("notification", notification);
            Message obtainMessage = this.h.obtainMessage(IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public String getAccessKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                String b2 = com.baidu.location.a.a.b(this.f);
                this.v = b2;
                if (TextUtils.isEmpty(b2)) {
                    throw new IllegalStateException("please setting key from Manifest.xml");
                }
                return String.format("KEY=%s", this.v);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public BDLocation getLastKnownLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (BDLocation) invokeV.objValue;
    }

    public LocationClientOption getLocOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (LocationClientOption) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "9.3.6.3" : (String) invokeV.objValue;
    }

    public boolean isStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void onReceiveLightLocString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    @Override // com.baidu.location.b.e.b
    public void onReceiveLocation(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bDLocation) == null) {
            if ((!this.F || this.E) && bDLocation != null) {
                Message obtainMessage = this.h.obtainMessage(701);
                obtainMessage.obj = bDLocation;
                obtainMessage.sendToTarget();
            }
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bDAbstractLocationListener) == null) {
            if (bDAbstractLocationListener == null) {
                throw new IllegalStateException("please set a non-null listener");
            }
            Message obtainMessage = this.h.obtainMessage(1300);
            obtainMessage.obj = bDAbstractLocationListener;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bDLocationListener) == null) {
            if (bDLocationListener == null) {
                throw new IllegalStateException("please set a non-null listener");
            }
            Message obtainMessage = this.h.obtainMessage(5);
            obtainMessage.obj = bDLocationListener;
            obtainMessage.sendToTarget();
        }
    }

    public boolean requestHotSpotState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.g != null && this.e) {
                try {
                    this.g.send(Message.obtain((Handler) null, 406));
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int requestLocation() {
        InterceptResult invokeV;
        ArrayList<BDAbstractLocationListener> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.g == null || this.i == null) {
                return 1;
            }
            ArrayList<BDLocationListener> arrayList2 = this.j;
            if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.k) == null || arrayList.size() < 1)) {
                return 2;
            }
            if (System.currentTimeMillis() - this.a < 1000) {
                return 6;
            }
            this.n = true;
            Message obtainMessage = this.h.obtainMessage(4);
            obtainMessage.arg1 = 0;
            obtainMessage.sendToTarget();
            return 0;
        }
        return invokeV.intValue;
    }

    public void restart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            stop();
            this.y = false;
            this.h.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, locationClientOption) == null) {
            if (locationClientOption == null) {
                locationClientOption = new LocationClientOption();
            }
            if (locationClientOption.a() > 0) {
                locationClientOption.setScanSpan(0);
                locationClientOption.setLocationNotify(true);
            }
            this.d = new LocationClientOption(locationClientOption);
            Message obtainMessage = this.h.obtainMessage(3);
            obtainMessage.obj = locationClientOption;
            obtainMessage.sendToTarget();
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.y = false;
            LBSAuthManager.getInstance(this.f.getApplicationContext()).setPrivacyMode(H);
            com.baidu.location.b.a.a().a(this.f, this.d, (String) null);
            new c(this, null).start();
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.y = true;
            this.h.obtainMessage(2).sendToTarget();
            this.D = null;
        }
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bDAbstractLocationListener) == null) {
            if (bDAbstractLocationListener == null) {
                throw new IllegalStateException("please set a non-null listener");
            }
            Message obtainMessage = this.h.obtainMessage(1400);
            obtainMessage.obj = bDAbstractLocationListener;
            obtainMessage.sendToTarget();
        }
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bDLocationListener) == null) {
            if (bDLocationListener == null) {
                throw new IllegalStateException("please set a non-null listener");
            }
            Message obtainMessage = this.h.obtainMessage(6);
            obtainMessage.obj = bDLocationListener;
            obtainMessage.sendToTarget();
        }
    }

    public boolean updateLocation(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, location)) == null) {
            if (this.g == null || this.i == null || location == null) {
                return false;
            }
            try {
                Message obtain = Message.obtain((Handler) null, 57);
                obtain.obj = location;
                this.g.send(obtain);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
