package com.baidu.location.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.p;
import com.baidu.location.b.u;
import com.baidu.location.b.y;
import com.baidu.location.b.z;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String L = null;
    public static double N = 100.0d;
    public static float Q = -1.0f;
    public static int a = 0;
    public static String b = "";
    public static String c = "";
    public static e e = null;
    public static Location i = null;
    public static int j = -1;
    public static int t;
    public static int u;
    public static int v;
    public static int w;
    public static int x;
    public static long y;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public String C;
    public boolean D;
    public long E;
    public double F;
    public double G;
    public double H;
    public long I;
    public long J;
    public long K;
    public HandlerC0100e M;
    public long O;
    public long P;
    public a R;
    public b S;

    /* renamed from: T  reason: collision with root package name */
    public ArrayList<ArrayList<Float>> f1045T;
    public ArrayList<ArrayList<Float>> U;
    public ArrayList<ArrayList<Float>> V;
    public ArrayList<ArrayList<Float>> W;
    public ArrayList<ArrayList<Float>> X;
    public ArrayList<ArrayList<Float>> Y;
    public ArrayList<ArrayList<Float>> Z;
    public String aa;
    public long ab;
    public ArrayList<Integer> ac;
    public String ad;
    public String ae;
    public long af;
    public long ag;
    public long ah;
    public BDLocation ai;
    public boolean aj;
    public boolean ak;
    public long al;
    public String am;
    public long an;
    public StringBuilder ao;
    public long d;
    public Context f;
    public LocationManager g;
    public Location h;
    public f k;
    public h l;
    public GpsStatus m;
    public c n;
    public boolean o;
    public d p;
    public boolean q;
    public GpsStatus.NmeaListener r;
    public OnNmeaMessageListener s;
    public long z;

    @TargetApi(24)
    /* loaded from: classes3.dex */
    public class a extends GnssMeasurementsEvent.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gnssMeasurementsEvent) == null) {
            }
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a = i;
            }
        }
    }

    @TargetApi(24)
    /* loaded from: classes3.dex */
    public class b extends GnssNavigationMessage.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ e b;

        public b(e eVar) {
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
            this.b = eVar;
            this.a = 0;
        }

        public /* synthetic */ b(e eVar, com.baidu.location.c.f fVar) {
            this(eVar);
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gnssNavigationMessage) == null) {
                z.a().a(gnssNavigationMessage, this.b.K != 0 ? this.b.K : System.currentTimeMillis() / 1000);
            }
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a = i;
            }
        }
    }

    @TargetApi(24)
    /* loaded from: classes3.dex */
    public class c extends GnssStatus.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

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
            this.a = eVar;
        }

        public /* synthetic */ c(e eVar, com.baidu.location.c.f fVar) {
            this(eVar);
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            ArrayList arrayList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gnssStatus) == null) || this.a.g == null) {
                return;
            }
            this.a.P = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            this.a.W.clear();
            this.a.X.clear();
            this.a.Y.clear();
            this.a.Z.clear();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < satelliteCount; i4++) {
                i3++;
                ArrayList arrayList2 = new ArrayList();
                int constellationType = gnssStatus.getConstellationType(i4);
                arrayList2.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i4)));
                arrayList2.add(Float.valueOf(gnssStatus.getElevationDegrees(i4)));
                arrayList2.add(Float.valueOf(gnssStatus.getCn0DbHz(i4)));
                if (gnssStatus.usedInFix(i4)) {
                    i++;
                    arrayList2.add(Float.valueOf(1.0f));
                    if (constellationType == 1) {
                        i2++;
                    }
                } else {
                    arrayList2.add(Float.valueOf(0.0f));
                }
                arrayList2.add(Float.valueOf(gnssStatus.getSvid(i4)));
                if (constellationType == 1) {
                    arrayList2.add(Float.valueOf(1.0f));
                    arrayList = this.a.W;
                } else if (constellationType == 5) {
                    arrayList2.add(Float.valueOf(2.0f));
                    arrayList = this.a.X;
                } else if (constellationType == 3) {
                    arrayList2.add(Float.valueOf(3.0f));
                    arrayList = this.a.Y;
                } else if (constellationType == 6) {
                    arrayList2.add(Float.valueOf(4.0f));
                    arrayList = this.a.Z;
                }
                arrayList.add(arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(this.a.W);
            arrayList3.addAll(this.a.X);
            arrayList3.addAll(this.a.Y);
            arrayList3.addAll(this.a.Z);
            this.a.b(arrayList3);
            e eVar = this.a;
            eVar.f1045T = eVar.a(true, false, false, false, true, -1.0f);
            e eVar2 = this.a;
            e.b = eVar2.a(eVar2.f1045T);
            e eVar3 = this.a;
            eVar3.U = eVar3.a(true, true, true, true, true, -1.0f);
            e eVar4 = this.a;
            eVar4.V = eVar4.a(true, true, true, true, false, -1.0f);
            e eVar5 = this.a;
            e.c = eVar5.a(eVar5.V);
            e.a = i;
            int unused = e.t = i2;
            int unused2 = e.x = i3;
            long unused3 = e.y = System.currentTimeMillis();
            e eVar6 = this.a;
            int unused4 = e.u = eVar6.a((ArrayList<ArrayList<Float>>) eVar6.Y, true, -1.0f).size();
            e eVar7 = this.a;
            int unused5 = e.v = eVar7.a((ArrayList<ArrayList<Float>>) eVar7.Z, true, -1.0f).size();
            e eVar8 = this.a;
            int unused6 = e.w = eVar8.a((ArrayList<ArrayList<Float>>) eVar8.X, true, -1.0f).size();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.e((Location) null);
                this.a.b(false);
                e.a = 0;
                int unused = e.t = 0;
                int unused2 = e.u = 0;
                int unused3 = e.v = 0;
                int unused4 = e.w = 0;
                int unused5 = e.j = -1;
                Location unused6 = e.i = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements GpsStatus.Listener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public long b;

        public d(e eVar) {
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
            this.b = 0L;
        }

        public /* synthetic */ d(e eVar, com.baidu.location.c.f fVar) {
            this(eVar);
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            long currentTimeMillis;
            ArrayList arrayList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.g == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                this.a.e((Location) null);
                this.a.b(false);
                e.a = 0;
                int unused = e.t = 0;
                int unused2 = e.u = 0;
                int unused3 = e.v = 0;
                int unused4 = e.w = 0;
            } else if (i == 4 && this.a.B) {
                try {
                    if (this.a.m == null) {
                        this.a.m = this.a.g.getGpsStatus(null);
                    } else {
                        this.a.g.getGpsStatus(this.a.m);
                    }
                    this.a.P = System.currentTimeMillis();
                    this.a.W.clear();
                    this.a.X.clear();
                    this.a.Y.clear();
                    this.a.Z.clear();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : this.a.m.getSatellites()) {
                        ArrayList arrayList2 = new ArrayList();
                        int prn = gpsSatellite.getPrn();
                        arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                        if (gpsSatellite.usedInFix()) {
                            i2++;
                            arrayList2.add(Float.valueOf(1.0f));
                            if (prn >= 1 && prn <= 32) {
                                i3++;
                            }
                        } else {
                            arrayList2.add(Float.valueOf(0.0f));
                        }
                        arrayList2.add(Float.valueOf(prn));
                        if (prn >= 1 && prn <= 32) {
                            arrayList2.add(Float.valueOf(1.0f));
                            arrayList = this.a.W;
                        } else if (prn >= 201 && prn <= 235) {
                            arrayList2.add(Float.valueOf(2.0f));
                            arrayList = this.a.X;
                        } else if (prn >= 65 && prn <= 96) {
                            arrayList2.add(Float.valueOf(3.0f));
                            arrayList = this.a.Y;
                        } else if (prn >= 301 && prn <= 336) {
                            arrayList2.add(Float.valueOf(4.0f));
                            arrayList = this.a.Z;
                        }
                        arrayList.add(arrayList2);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(this.a.W);
                    arrayList3.addAll(this.a.X);
                    arrayList3.addAll(this.a.Y);
                    arrayList3.addAll(this.a.Z);
                    this.a.b(arrayList3);
                    this.a.f1045T = this.a.a(true, false, false, false, true, -1.0f);
                    e.b = this.a.a(this.a.f1045T);
                    this.a.U = this.a.a(true, true, true, true, true, -1.0f);
                    this.a.V = this.a.a(true, true, true, true, false, -1.0f);
                    e.c = this.a.a(this.a.V);
                    if (i3 > 0) {
                        int unused5 = e.t = i3;
                    }
                    if (i2 <= 0) {
                        if (System.currentTimeMillis() - this.b > 100) {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        long unused6 = e.y = System.currentTimeMillis();
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    this.b = currentTimeMillis;
                    e.a = i2;
                    long unused62 = e.y = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }
    }

    /* renamed from: com.baidu.location.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0100e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<e> a;
        public e b;

        public HandlerC0100e(e eVar) {
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
            this.a = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Location location;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && com.baidu.location.f.isServing) {
                e eVar = this.a.get();
                this.b = eVar;
                if (eVar == null) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    eVar.g((Location) message.obj);
                    return;
                }
                if (i == 3) {
                    location = (Location) message.obj;
                    str = "&og=1";
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    eVar.a((String) message.obj);
                    return;
                } else {
                    location = (Location) message.obj;
                    str = "&og=2";
                }
                eVar.a(str, location);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements LocationListener {
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

        public /* synthetic */ f(e eVar, com.baidu.location.c.f fVar) {
            this(eVar);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (!(location == null && com.baidu.location.e.k.f == 4) && !com.baidu.location.e.k.a(location) && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                    this.a.K = location.getTime() / 1000;
                    this.a.ag = System.currentTimeMillis();
                    if (this.a.J != 0) {
                        this.a.I = System.currentTimeMillis() - this.a.J;
                    }
                    this.a.J = System.currentTimeMillis();
                    int i = e.a;
                    if (i == 0) {
                        try {
                            i = location.getExtras().getInt("satellites");
                        } catch (Exception unused) {
                        }
                    }
                    if (i == 0 || p.c().j()) {
                        System.currentTimeMillis();
                        long unused2 = this.a.P;
                    }
                    this.a.b(true);
                    this.a.e(location);
                    this.a.A = false;
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.e((Location) null);
                this.a.b(false);
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
                if (i == 0) {
                    this.a.e((Location) null);
                } else if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    this.a.A = false;
                    return;
                } else {
                    this.a.z = System.currentTimeMillis();
                    this.a.A = true;
                }
                this.a.b(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements GpsStatus.NmeaListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public g(e eVar) {
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

        public /* synthetic */ g(e eVar, com.baidu.location.c.f fVar) {
            this(eVar);
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) || this.a.M == null) {
                return;
            }
            this.a.M.sendMessage(this.a.M.obtainMessage(5, str));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public long b;

        public h(e eVar) {
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
            this.b = 0L;
        }

        public /* synthetic */ h(e eVar, com.baidu.location.c.f fVar) {
            this(eVar);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (!(this.a.B && com.baidu.location.e.k.f == 4) && location != null && TextUtils.equals(location.getProvider(), "gps") && System.currentTimeMillis() - this.b >= 10000 && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && y.a(location, false)) {
                    this.b = System.currentTimeMillis();
                    if (this.a.M != null) {
                        this.a.d = System.currentTimeMillis();
                        this.a.M.sendMessage(this.a.M.obtainMessage(4, location));
                    }
                }
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037753198, "Lcom/baidu/location/c/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037753198, "Lcom/baidu/location/c/e;");
        }
    }

    public e() {
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
        this.g = null;
        this.k = null;
        this.l = null;
        this.o = false;
        this.p = null;
        this.q = false;
        this.r = null;
        this.s = null;
        this.z = 0L;
        this.A = false;
        this.B = false;
        this.C = null;
        this.D = false;
        this.E = 0L;
        this.F = -1.0d;
        this.G = 0.0d;
        this.H = 0.0d;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.M = null;
        this.O = 0L;
        this.P = 0L;
        this.R = null;
        this.S = null;
        this.f1045T = new ArrayList<>();
        this.U = new ArrayList<>();
        this.V = new ArrayList<>();
        this.W = new ArrayList<>();
        this.X = new ArrayList<>();
        this.Y = new ArrayList<>();
        this.Z = new ArrayList<>();
        this.aa = null;
        this.ab = 0L;
        this.ac = new ArrayList<>();
        this.ad = null;
        this.ae = null;
        this.af = 0L;
        this.ag = -1L;
        this.ah = -1L;
        this.aj = false;
        this.ak = false;
        this.al = 0L;
        this.am = null;
        this.an = 0L;
        this.ao = new StringBuilder();
        this.d = 0L;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.o = true;
            } catch (ClassNotFoundException unused) {
                this.o = false;
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                this.am = Build.MANUFACTURER;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.q = false;
    }

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new e();
                }
                eVar = e;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public static String a(Location location) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, location)) == null) {
            if (location == null) {
                return null;
            }
            float speed = (float) (location.getSpeed() * 3.6d);
            if (!location.hasSpeed()) {
                speed = -1.0f;
            }
            int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
            double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
            float bearing = location.hasBearing() ? location.getBearing() : -1.0f;
            String format = Q < -0.01f ? String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(a), Integer.valueOf(t), Integer.valueOf(u), Integer.valueOf(v), Integer.valueOf(w), Double.valueOf(N)) : String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(a), Integer.valueOf(t), Integer.valueOf(u), Integer.valueOf(v), Integer.valueOf(w), Double.valueOf(N), Float.valueOf(Q));
            try {
                if (j != 2 || i == null) {
                    sb = new StringBuilder();
                    sb.append(format);
                    sb.append("&ll_fake=");
                    sb.append(j);
                } else {
                    sb = new StringBuilder();
                    sb.append(format);
                    sb.append(String.format(Locale.CHINA, "&ll_fake=%d|%.5f|%.5f|%d", Integer.valueOf(j), Double.valueOf(i.getLongitude()), Double.valueOf(i.getLatitude()), Long.valueOf(i.getTime() / 1000)));
                }
                return sb.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return format;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<ArrayList<Float>> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            if (arrayList.size() == 0) {
                return sb.toString();
            }
            Iterator<ArrayList<Float>> it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("|");
                    }
                    sb.append(String.format("%.1f;", next.get(0)));
                    sb.append(String.format("%.1f;", next.get(1)));
                    sb.append(String.format("%.1f;", next.get(2)));
                    sb.append(String.format("%.0f;", next.get(3)));
                    sb.append(String.format("%.0f;", next.get(4)));
                    sb.append(String.format("%.0f", next.get(5)));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(ArrayList<ArrayList<Float>> arrayList, boolean z, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{arrayList, Boolean.valueOf(z), Float.valueOf(f2)})) == null) {
            ArrayList<ArrayList<Float>> arrayList2 = new ArrayList<>();
            if (arrayList.size() <= 40 && arrayList.size() != 0) {
                Iterator<ArrayList<Float>> it = arrayList.iterator();
                while (it.hasNext()) {
                    ArrayList<Float> next = it.next();
                    if (next.size() == 6) {
                        float floatValue = next.get(3).floatValue();
                        float floatValue2 = next.get(2).floatValue();
                        if (!z || floatValue >= 1.0f) {
                            if (f2 <= 0.0f || floatValue2 >= f2) {
                                arrayList2.add(next);
                            }
                        }
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Float.valueOf(f2)})) == null) {
            ArrayList<ArrayList<Float>> arrayList = new ArrayList<>();
            if (z) {
                arrayList.addAll(a(this.W, z5, f2));
            }
            if (z2) {
                arrayList.addAll(a(this.X, z5, f2));
            }
            if (z3) {
                arrayList.addAll(a(this.Y, z5, f2));
            }
            if (z4) {
                arrayList.addAll(a(this.Z, z5, f2));
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, this, str) == null) && !TextUtils.isEmpty(str) && b(str)) {
            if (str.startsWith("$GPGGA,")) {
                a(str, 2, 4, 6);
            } else if (str.startsWith("$GPRMC,")) {
                a(str, 3, 5, 2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
        if (android.text.TextUtils.equals(r0[r14], androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fa, code lost:
        if (android.text.TextUtils.equals(r0[r14], "0") != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fd, code lost:
        r10.aj = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(65556, this, str, i2, i3, i4) == null) && !TextUtils.isEmpty(str) && b(str)) {
            String[] split = str.split(",");
            if (str.startsWith("$GPGGA,")) {
                if (split.length < 7) {
                    return;
                }
            } else if (str.startsWith("$GPRMC,") && split.length < 6) {
                return;
            }
            if (TextUtils.isEmpty(split[i2].trim()) || split[i2].trim().length() <= 2) {
                this.ai = null;
            } else {
                try {
                    double doubleValue = Double.valueOf(split[i2].substring(0, 2)).doubleValue() + (Double.valueOf(split[i2].substring(2)).doubleValue() / 60.0d);
                    if (this.ai == null) {
                        this.ai = new BDLocation();
                    }
                    this.ai.setLatitude(doubleValue);
                } catch (NumberFormatException unused) {
                    this.ak = true;
                }
            }
            if (this.ai == null || TextUtils.isEmpty(split[i3].trim()) || split[i3].trim().length() <= 3) {
                this.ai = null;
            } else {
                try {
                    this.ai.setLongitude(Double.valueOf(split[i3].substring(0, 3)).doubleValue() + (Double.valueOf(split[i3].substring(3)).doubleValue() / 60.0d));
                } catch (NumberFormatException unused2) {
                    this.ak = true;
                }
            }
            if (!TextUtils.isEmpty(split[i4].trim())) {
                if (i4 == 2) {
                    if (!TextUtils.equals(split[i4], ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    }
                    this.aj = false;
                } else if (i4 == 6) {
                }
            }
            if (this.ai != null) {
                this.ak = false;
            }
            this.ah = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65557, this, str, location) == null) || location == null) {
            return;
        }
        String str2 = str + com.baidu.location.b.b.a().c();
        boolean e2 = k.a().e();
        u.a(new com.baidu.location.c.a(com.baidu.location.c.b.a().f()));
        u.a(System.currentTimeMillis());
        u.a(new Location(location));
        u.a(str2);
        u.b(com.baidu.location.b.c.a().c());
        if (e2) {
            return;
        }
        y.a(u.c(), (j) null, u.d(), str2, u.e());
    }

    public static boolean a(Location location, Location location2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65558, null, location, location2, z)) == null) {
            if (location == location2) {
                return false;
            }
            if (location == null || location2 == null) {
                return true;
            }
            float speed = location2.getSpeed();
            if (!z || ((com.baidu.location.e.k.u != 3 && com.baidu.location.e.e.a().a(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
                float distanceTo = location2.distanceTo(location);
                return speed > com.baidu.location.e.k.K ? distanceTo > com.baidu.location.e.k.M : speed > com.baidu.location.e.k.J ? distanceTo > com.baidu.location.e.k.L : distanceTo > 5.0f;
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static String b(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, location)) == null) {
            String a2 = a(location);
            if (a2 != null) {
                return a2 + "&g_tp=0";
            }
            return a2;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<ArrayList<Float>> arrayList) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, arrayList) == null) {
            if (arrayList == null || arrayList.size() <= 0) {
                str = null;
            } else {
                StringBuilder sb = new StringBuilder(100);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.W);
                sb.append(com.baidu.location.e.c.g(arrayList2));
                sb.append("|");
                sb.append(com.baidu.location.e.c.f(arrayList2));
                sb.append("|");
                sb.append(com.baidu.location.e.c.a(arrayList2));
                sb.append("|");
                sb.append(com.baidu.location.e.c.h(arrayList2));
                sb.append("|");
                sb.append(com.baidu.location.e.c.b(arrayList2));
                sb.append("|");
                sb.append(com.baidu.location.e.c.c(arrayList2));
                sb.append("|");
                sb.append(com.baidu.location.e.c.e(arrayList2));
                sb.append("|");
                sb.append(com.baidu.location.e.c.d(arrayList2));
                str = sb.toString();
            }
            this.aa = str;
            this.ab = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65565, this, z) == null) {
            this.D = z;
            Q = -1.0f;
        }
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, this, str)) == null) {
            if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
                byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
                int i3 = bytes[1];
                for (int i4 = 2; i4 < bytes.length; i4++) {
                    i3 ^= bytes[i4];
                }
                String format = String.format("%02x", Integer.valueOf(i3));
                int indexOf = str.indexOf("*");
                if (indexOf != -1 && str.length() >= (i2 = indexOf + 3) && format.equalsIgnoreCase(str.substring(indexOf + 1, i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String c(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, location)) == null) {
            String a2 = a(location);
            if (a2 != null) {
                return a2 + L;
            }
            return a2;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65583, this, location) == null) || this.M == null || System.currentTimeMillis() - this.an <= 3000) {
            return;
        }
        this.M.sendMessage(this.M.obtainMessage(1, location));
    }

    private int f(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, this, location)) == null) {
            if (location == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT <= 17 || !location.isFromMockProvider()) {
                if (Math.abs(this.ag - this.ah) >= 3000) {
                    this.ah = -1L;
                    this.ak = false;
                    this.aj = false;
                    this.ai = null;
                } else if (this.ai == null) {
                    if (!this.aj) {
                        return 200;
                    }
                    if (this.ak) {
                        return 300;
                    }
                } else if (!this.ak && this.aj) {
                    return 400;
                }
                if (this.ag > 0) {
                    if (this.ah == -1) {
                        return 500;
                    }
                }
                return 0;
            }
            return 100;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, this, location) == null) {
            String str = null;
            if (location == null) {
                this.h = null;
                return;
            }
            if (a == 0) {
                try {
                    location.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            if (this.q && com.baidu.location.e.k.a(location.getSpeed(), 0.0f) && !com.baidu.location.e.k.a(this.G, 0.0d) && System.currentTimeMillis() - this.H < 2000.0d) {
                location.setSpeed((float) this.G);
            }
            Location location2 = new Location(location);
            this.E = System.currentTimeMillis();
            this.h = location;
            int i2 = a;
            if (location != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.h.setTime(currentTimeMillis);
                float speed = (float) (this.h.getSpeed() * 3.6d);
                if (!this.h.hasSpeed()) {
                    speed = -1.0f;
                }
                if (i2 == 0) {
                    try {
                        i2 = this.h.getExtras().getInt("satellites");
                    } catch (Exception unused2) {
                    }
                }
                str = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.h.getLongitude()), Double.valueOf(this.h.getLatitude()), Float.valueOf(speed), Float.valueOf(this.h.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
            }
            this.C = str;
            if (this.h != null) {
                BDLocation bDLocation = new BDLocation(f());
                com.baidu.location.b.c.a().a(bDLocation, "gcj02", this.h);
                bDLocation.setExtrainfo(location.getExtras());
                Location location3 = this.h;
                if (location3 != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(location3.getProvider())) {
                    bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
                }
                a(bDLocation);
                if (a > 2 && y.a(this.h, true) && "gps".equals(this.h.getProvider())) {
                    boolean e2 = k.a().e();
                    u.a(new com.baidu.location.c.a(com.baidu.location.c.b.a().f()));
                    u.a(System.currentTimeMillis());
                    u.a(new Location(this.h));
                    u.a(com.baidu.location.b.b.a().c());
                    u.b(com.baidu.location.b.c.a().c());
                    if (!e2) {
                        z.a().b();
                    }
                }
            }
            if ("gps".equals(location2.getProvider())) {
                z.a().a(location2, a);
            }
        }
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - y;
            if (currentTimeMillis < 0 || currentTimeMillis >= 3000) {
                return null;
            }
            return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(x), Integer.valueOf(a));
        }
        return (String) invokeV.objValue;
    }

    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
            if (com.baidu.location.e.k.l || f(this.h) <= 0) {
                com.baidu.location.b.b.a().d(bDLocation);
            } else {
                com.baidu.location.b.b.a().c(bDLocation);
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                c();
            } else {
                d();
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (com.baidu.location.f.isServing) {
                    Context serviceContext = com.baidu.location.f.getServiceContext();
                    this.f = serviceContext;
                    try {
                        this.g = (LocationManager) serviceContext.getSystemService("location");
                    } catch (Exception unused) {
                    }
                    this.M = new HandlerC0100e(this);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Log.d("baidu_location_service", "GpsMan start gps...");
            if (this.B) {
                return;
            }
            try {
                if (!this.o) {
                    d dVar = new d(this, null);
                    this.p = dVar;
                    this.g.addGpsStatusListener(dVar);
                } else if (com.baidu.location.e.k.a(this.f, com.kuaishou.weapon.p0.h.g) == 1) {
                    c cVar = new c(this, null);
                    this.n = cVar;
                    this.g.registerGnssStatusCallback(cVar);
                }
                h hVar = new h(this, null);
                this.l = hVar;
                this.g.requestLocationUpdates("passive", 9000L, 0.0f, hVar);
            } catch (Exception unused) {
            }
            try {
                this.k = new f(this, null);
                try {
                    this.g.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
                } catch (Exception unused2) {
                }
                this.g.requestLocationUpdates("gps", 1000L, 0.0f, this.k);
                if (this.o && this.S == null && com.baidu.location.e.k.aB == 1 && new Random().nextDouble() < com.baidu.location.e.k.aA) {
                    this.S = new b(this, null);
                }
                if (this.S != null) {
                    this.g.registerGnssNavigationMessageCallback(this.S);
                }
                this.O = System.currentTimeMillis();
                if (!com.baidu.location.e.k.l && com.baidu.location.e.k.aM == 1) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        com.baidu.location.c.f fVar = new com.baidu.location.c.f(this);
                        this.s = fVar;
                        this.g.addNmeaListener(fVar);
                    } else {
                        this.r = new g(this, null);
                        Class.forName("android.location.LocationManager").getMethod("addNmeaListener", GpsStatus.NmeaListener.class).invoke(this.g, this.r);
                    }
                }
                this.B = true;
            } catch (Exception unused3) {
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.B) {
            LocationManager locationManager = this.g;
            if (locationManager != null) {
                try {
                    if (this.p != null) {
                        locationManager.removeGpsStatusListener(this.p);
                        this.p = null;
                    }
                    if (this.o && this.n != null) {
                        this.g.unregisterGnssStatusCallback(this.n);
                        this.n = null;
                    }
                    if (this.l != null) {
                        this.g.removeUpdates(this.l);
                        this.l = null;
                    }
                } catch (Exception unused) {
                }
                try {
                    if (this.k != null) {
                        this.g.removeUpdates(this.k);
                    }
                    if (this.s != null) {
                        this.g.removeNmeaListener(this.s);
                    }
                    if (this.r != null) {
                        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", GpsStatus.NmeaListener.class).invoke(this.g, this.r);
                    }
                    if (this.S != null) {
                        this.g.unregisterGnssNavigationMessageCallback(this.S);
                    }
                    k();
                } catch (Exception unused2) {
                }
            }
            com.baidu.location.e.k.d = 0;
            com.baidu.location.e.k.u = 0;
            this.k = null;
            this.B = false;
            b(false);
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                d();
                if (this.g == null) {
                    return;
                }
                try {
                    if (this.M != null) {
                        this.M.removeCallbacksAndMessages(null);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.g = null;
            }
        }
    }

    public String f() {
        InterceptResult invokeV;
        boolean z;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.h != null) {
                String str2 = "{\"result\":{\"time\":\"" + com.baidu.location.e.k.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
                int accuracy = (int) (this.h.hasAccuracy() ? this.h.getAccuracy() : 10.0f);
                float speed = (float) (this.h.getSpeed() * 3.6d);
                if (!this.h.hasSpeed()) {
                    speed = -1.0f;
                }
                double[] dArr = new double[2];
                if (com.baidu.location.e.e.a().a(this.h.getLongitude(), this.h.getLatitude())) {
                    dArr = Jni.coorEncrypt(this.h.getLongitude(), this.h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                        dArr[0] = this.h.getLongitude();
                        dArr[1] = this.h.getLatitude();
                    }
                    z = true;
                } else {
                    dArr[0] = this.h.getLongitude();
                    dArr[1] = this.h.getLatitude();
                    if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                        dArr[0] = this.h.getLongitude();
                        dArr[1] = this.h.getLatitude();
                    }
                    z = false;
                }
                String format = String.format(Locale.CHINA, str2, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.h.getBearing()), Float.valueOf(speed), Integer.valueOf(a));
                if (!z) {
                    format = format + ",\"in_cn\":\"0\"";
                }
                if (!com.baidu.location.e.k.l) {
                    format = format + String.format(Locale.CHINA, ",\"is_mock\":%d", Integer.valueOf(f(this.h)));
                }
                if (this.h.hasAltitude()) {
                    sb = new StringBuilder();
                    sb.append(format);
                    str = String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.h.getAltitude()));
                } else {
                    sb = new StringBuilder();
                    sb.append(format);
                    str = "}}";
                }
                sb.append(str);
                return sb.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Location g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.h != null && Math.abs(System.currentTimeMillis() - this.h.getTime()) <= 60000) {
                return this.h;
            }
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public BDLocation h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.ai != null && Math.abs(System.currentTimeMillis() - this.ah) <= 3000) {
                return this.ai;
            }
            return null;
        }
        return (BDLocation) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                System.currentTimeMillis();
                if (a == 0) {
                    try {
                        this.h.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (this.h != null && this.h.getLatitude() != 0.0d) {
                    if (this.h.getLongitude() != 0.0d) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused2) {
                Location location = this.h;
                return (location == null || location.getLatitude() == 0.0d || this.h.getLongitude() == 0.0d) ? false : true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (i() && System.currentTimeMillis() - this.E <= 10000) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.A || currentTimeMillis - this.z >= 3000) {
                    return this.D;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        a aVar;
        LocationManager locationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || !this.o || (aVar = this.R) == null || (locationManager = this.g) == null) {
            return;
        }
        try {
            locationManager.unregisterGnssMeasurementsCallback(aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.R = null;
    }

    public synchronized String m() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                str = "&gnsf=" + (Math.abs(System.currentTimeMillis() - this.ab) < 3000 ? this.aa == null ? "0" : this.aa : "-1");
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
