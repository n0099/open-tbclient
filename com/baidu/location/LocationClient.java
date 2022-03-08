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
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.location.b.c;
import com.baidu.location.b.k;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class LocationClient implements c.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean A;
    public boolean B;
    public com.baidu.location.b.c C;
    public boolean D;
    public boolean E;
    public boolean F;
    public ServiceConnection G;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f33561b;

    /* renamed from: c  reason: collision with root package name */
    public LocationClientOption f33562c;

    /* renamed from: d  reason: collision with root package name */
    public LocationClientOption f33563d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33564e;

    /* renamed from: f  reason: collision with root package name */
    public Context f33565f;

    /* renamed from: g  reason: collision with root package name */
    public Messenger f33566g;

    /* renamed from: h  reason: collision with root package name */
    public a f33567h;

    /* renamed from: i  reason: collision with root package name */
    public final Messenger f33568i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<BDLocationListener> f33569j;
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
    public boolean w;
    public boolean x;
    public Boolean y;
    public Boolean z;

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = message.what;
            boolean z = true;
            if (i2 == 21) {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                if (!locationClient.E && locationClient.D && bDLocation.getLocType() == 66) {
                    return;
                }
                if (!locationClient.E && locationClient.D) {
                    locationClient.E = true;
                    return;
                }
                if (!locationClient.E) {
                    locationClient.E = true;
                }
                locationClient.a(message, 21);
                return;
            }
            try {
                if (i2 == 303) {
                    Bundle data2 = message.getData();
                    int i3 = data2.getInt("loctype");
                    int i4 = data2.getInt("diagtype");
                    byte[] byteArray = data2.getByteArray("diagmessage");
                    if (i3 <= 0 || i4 <= 0 || byteArray == null || locationClient.k == null) {
                        return;
                    }
                    Iterator it = locationClient.k.iterator();
                    while (it.hasNext()) {
                        ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i3, i4, new String(byteArray, "UTF-8"));
                    }
                } else if (i2 == 406) {
                    Bundle data3 = message.getData();
                    byte[] byteArray2 = data3.getByteArray("mac");
                    String str = byteArray2 != null ? new String(byteArray2, "UTF-8") : null;
                    int i5 = data3.getInt("hotspot", -1);
                    if (locationClient.k != null) {
                        Iterator it2 = locationClient.k.iterator();
                        while (it2.hasNext()) {
                            ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i5);
                        }
                    }
                } else if (i2 == 701) {
                    locationClient.a((BDLocation) message.obj);
                } else if (i2 == 1300) {
                    locationClient.c(message);
                } else if (i2 == 1400) {
                    locationClient.d(message);
                } else {
                    if (i2 != 54) {
                        z = false;
                        if (i2 != 55) {
                            if (i2 == 703) {
                                Bundle data4 = message.getData();
                                int i6 = data4.getInt("id", 0);
                                if (i6 > 0) {
                                    locationClient.a(i6, (Notification) data4.getParcelable(ActionJsonData.TAG_NOTIFICATION));
                                    return;
                                }
                                return;
                            } else if (i2 == 704) {
                                locationClient.a(message.getData().getBoolean("removenotify"));
                                return;
                            } else {
                                switch (i2) {
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
                                        locationClient.d();
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
                        } else if (!locationClient.f33562c.location_change_notify) {
                            return;
                        }
                    } else if (!locationClient.f33562c.location_change_notify) {
                        return;
                    }
                    locationClient.q = z;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    if (this.a.f33566g != null && this.a.f33568i != null) {
                        if ((this.a.f33569j != null && this.a.f33569j.size() >= 1) || (this.a.k != null && this.a.k.size() >= 1)) {
                            if (!this.a.n) {
                                this.a.f33567h.obtainMessage(4).sendToTarget();
                                return;
                            }
                            if (this.a.p == null) {
                                this.a.p = new b(this.a);
                            }
                            this.a.f33567h.postDelayed(this.a.p, this.a.f33562c.scanSpan);
                        }
                    }
                }
            }
        }
    }

    public LocationClient(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f33561b = null;
        this.f33562c = new LocationClientOption();
        this.f33563d = new LocationClientOption();
        this.f33564e = false;
        this.f33565f = null;
        this.f33566g = null;
        this.f33569j = null;
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
        this.w = false;
        this.x = true;
        Boolean bool = Boolean.FALSE;
        this.y = bool;
        this.z = bool;
        this.A = Boolean.TRUE;
        this.C = null;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = new com.baidu.location.b(this);
        this.f33565f = context;
        this.f33562c = new LocationClientOption();
        this.f33563d = new LocationClientOption();
        this.f33567h = new a(Looper.getMainLooper(), this);
        this.f33568i = new Messenger(this.f33567h);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locationClientOption};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f33561b = null;
        this.f33562c = new LocationClientOption();
        this.f33563d = new LocationClientOption();
        this.f33564e = false;
        this.f33565f = null;
        this.f33566g = null;
        this.f33569j = null;
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
        this.w = false;
        this.x = true;
        Boolean bool = Boolean.FALSE;
        this.y = bool;
        this.z = bool;
        this.A = Boolean.TRUE;
        this.C = null;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = new com.baidu.location.b(this);
        this.f33565f = context;
        this.f33562c = locationClientOption;
        this.f33563d = new LocationClientOption(locationClientOption);
        this.f33567h = new a(Looper.getMainLooper(), this);
        this.f33568i = new Messenger(this.f33567h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || this.f33564e) {
            return;
        }
        if (this.A.booleanValue()) {
            try {
                new c(this).start();
            } catch (Throwable unused) {
            }
            this.A = Boolean.FALSE;
        }
        this.f33561b = this.f33565f.getPackageName();
        this.u = this.f33561b + "_bdls_v2.9";
        Intent intent = new Intent(this.f33565f, f.class);
        try {
            intent.putExtra("debug_dev", this.B);
        } catch (Exception unused2) {
        }
        if (this.f33562c == null) {
            this.f33562c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.f33562c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.f33562c.isIgnoreKillProcess);
        try {
            this.f33565f.bindService(intent, this.G, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f33564e = false;
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            if (this.l.getCoorType() == null) {
                this.l.setCoorType(this.f33562c.coorType);
            }
            if (this.m || ((this.f33562c.location_change_notify && this.l.getLocType() == 61) || this.l.getLocType() == 66 || this.l.getLocType() == 67 || this.w || this.l.getLocType() == 161)) {
                ArrayList<BDLocationListener> arrayList = this.f33569j;
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
    public void a(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, this, i2, notification) == null) {
            try {
                Intent intent = new Intent(this.f33565f, f.class);
                intent.putExtra(ActionJsonData.TAG_NOTIFICATION, notification);
                intent.putExtra("id", i2);
                intent.putExtra("command", 1);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f33565f.startForegroundService(intent);
                } else {
                    this.f33565f.startService(intent);
                }
                this.F = true;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, message) == null) {
            this.n = false;
            if (message == null || (obj = message.obj) == null) {
                return;
            }
            LocationClientOption locationClientOption = (LocationClientOption) obj;
            if (this.f33562c.optionEquals(locationClientOption)) {
                return;
            }
            if (this.f33562c.scanSpan != locationClientOption.scanSpan) {
                try {
                    synchronized (this.r) {
                        if (this.o) {
                            this.f33567h.removeCallbacks(this.p);
                            this.o = false;
                        }
                        if (locationClientOption.scanSpan >= 1000 && !this.o) {
                            if (this.p == null) {
                                this.p = new b(this, null);
                            }
                            this.f33567h.postDelayed(this.p, locationClientOption.scanSpan);
                            this.o = true;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.f33562c = new LocationClientOption(locationClientOption);
            if (this.f33566g == null) {
                return;
            }
            try {
                Message obtain = Message.obtain((Handler) null, 15);
                obtain.replyTo = this.f33568i;
                obtain.setData(c());
                this.f33566g.send(obtain);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65546, this, message, i2) == null) && this.f33564e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                this.l = bDLocation;
                if (bDLocation.getLocType() == 61) {
                    this.s = System.currentTimeMillis();
                }
                a(i2);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, bDLocation) == null) || this.x) {
            return;
        }
        this.l = bDLocation;
        if (!this.E && bDLocation.getLocType() == 161) {
            this.D = true;
        }
        ArrayList<BDLocationListener> arrayList = this.f33569j;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, this, z) == null) {
            try {
                Intent intent = new Intent(this.f33565f, f.class);
                intent.putExtra("removenotify", z);
                intent.putExtra("command", 2);
                this.f33565f.startService(intent);
                this.F = true;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && this.f33564e && this.f33566g != null) {
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.replyTo = this.f33568i;
            try {
                this.f33566g.send(obtain);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                this.f33565f.unbindService(this.G);
                if (this.F) {
                    try {
                        this.f33565f.stopService(new Intent(this.f33565f, f.class));
                    } catch (Exception unused) {
                    }
                    this.F = false;
                }
            } catch (Exception unused2) {
            }
            synchronized (this.r) {
                try {
                    if (this.o) {
                        this.f33567h.removeCallbacks(this.p);
                        this.o = false;
                    }
                } catch (Exception unused3) {
                }
            }
            this.f33566g = null;
            this.n = false;
            this.w = false;
            this.f33564e = false;
            this.D = false;
            this.E = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, message) == null) || message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        if (this.f33569j == null) {
            this.f33569j = new ArrayList<>();
        }
        if (this.f33569j.contains(bDLocationListener)) {
            return;
        }
        this.f33569j.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            if (this.f33562c == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("packName", this.f33561b);
            bundle.putString("prodName", this.f33562c.prodName);
            bundle.putString("coorType", this.f33562c.coorType);
            bundle.putString("addrType", this.f33562c.addrType);
            bundle.putBoolean("openGPS", this.f33562c.openGps);
            bundle.putBoolean("location_change_notify", this.f33562c.location_change_notify);
            bundle.putInt("scanSpan", this.f33562c.scanSpan);
            bundle.putBoolean("enableSimulateGps", this.f33562c.enableSimulateGps);
            bundle.putInt("timeOut", this.f33562c.timeOut);
            bundle.putInt("priority", this.f33562c.priority);
            bundle.putBoolean("map", this.y.booleanValue());
            bundle.putBoolean(ShareDirectionType.IMPORT, this.z.booleanValue());
            bundle.putBoolean("needDirect", this.f33562c.mIsNeedDeviceDirect);
            bundle.putBoolean("isneedaptag", this.f33562c.isNeedAptag);
            bundle.putBoolean("isneedpoiregion", this.f33562c.isNeedPoiRegion);
            bundle.putBoolean("isneedregular", this.f33562c.isNeedRegular);
            bundle.putBoolean("isneedaptagd", this.f33562c.isNeedAptagd);
            bundle.putBoolean("isneedaltitude", this.f33562c.isNeedAltitude);
            bundle.putBoolean("isneednewrgc", this.f33562c.isNeedNewVersionRgc);
            bundle.putInt("autoNotifyMaxInterval", this.f33562c.a());
            bundle.putInt("autoNotifyMinTimeInterval", this.f33562c.getAutoNotifyMinTimeInterval());
            bundle.putInt("autoNotifyMinDistance", this.f33562c.getAutoNotifyMinDistance());
            bundle.putFloat("autoNotifyLocSensitivity", this.f33562c.b());
            bundle.putInt("wifitimeout", this.f33562c.wifiCacheTimeOut);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, this, message) == null) || message == null || (obj = message.obj) == null) {
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
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || this.f33566g == null) {
            return;
        }
        if ((System.currentTimeMillis() - this.s > 3000 || !this.f33562c.location_change_notify || this.n) && (!this.w || System.currentTimeMillis() - this.t > 20000 || this.n)) {
            Message obtain = Message.obtain((Handler) null, 22);
            if (this.n) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isWaitingLocTag", this.n);
                this.n = false;
                obtain.setData(bundle);
            }
            try {
                obtain.replyTo = this.f33568i;
                this.f33566g.send(obtain);
                this.a = System.currentTimeMillis();
                this.m = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        synchronized (this.r) {
            if (this.f33562c != null && this.f33562c.scanSpan >= 1000 && !this.o) {
                if (this.p == null) {
                    this.p = new b(this, null);
                }
                this.f33567h.postDelayed(this.p, this.f33562c.scanSpan);
                this.o = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, this, message) == null) || message == null || (obj = message.obj) == null) {
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
    public void e(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65570, this, message) == null) || message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        ArrayList<BDLocationListener> arrayList = this.f33569j;
        if (arrayList == null || !arrayList.contains(bDLocationListener)) {
            return;
        }
        this.f33569j.remove(bDLocationListener);
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, bDLocation, str)) == null) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
            bDLocation2.setLatitude(coorEncrypt[1]);
            bDLocation2.setLongitude(coorEncrypt[0]);
            return bDLocation2;
        }
        return (BDLocation) invokeLL.objValue;
    }

    public void disableAssistantLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k.a().b();
        }
    }

    public void disableLocInForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("removenotify", z);
            Message obtainMessage = this.f33567h.obtainMessage(704);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public void enableAssistantLocation(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView) == null) {
            k.a().a(this.f33565f, webView, this);
        }
    }

    public void enableLocInForeground(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, notification) == null) || i2 <= 0 || notification == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i2);
        bundle.putParcelable(ActionJsonData.TAG_NOTIFICATION, notification);
        Message obtainMessage = this.f33567h.obtainMessage(IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public String getAccessKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                String b2 = com.baidu.location.a.a.b(this.f33565f);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33562c : (LocationClientOption) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "7.9.3" : (String) invokeV.objValue;
    }

    public boolean isStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33564e : invokeV.booleanValue;
    }

    public void onReceiveLightLocString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    @Override // com.baidu.location.b.c.a
    public void onReceiveLocation(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bDLocation) == null) {
            if ((!this.E || this.D) && bDLocation != null) {
                Message obtainMessage = this.f33567h.obtainMessage(701);
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
            Message obtainMessage = this.f33567h.obtainMessage(1300);
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
            Message obtainMessage = this.f33567h.obtainMessage(5);
            obtainMessage.obj = bDLocationListener;
            obtainMessage.sendToTarget();
        }
    }

    public boolean requestHotSpotState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f33566g != null && this.f33564e) {
                try {
                    this.f33566g.send(Message.obtain((Handler) null, 406));
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
            if (this.f33566g == null || this.f33568i == null) {
                return 1;
            }
            ArrayList<BDLocationListener> arrayList2 = this.f33569j;
            if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.k) == null || arrayList.size() < 1)) {
                return 2;
            }
            if (System.currentTimeMillis() - this.a < 1000) {
                return 6;
            }
            this.n = true;
            Message obtainMessage = this.f33567h.obtainMessage(4);
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
            this.x = false;
            this.f33567h.sendEmptyMessageDelayed(1, 1000L);
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
            this.f33563d = new LocationClientOption(locationClientOption);
            Message obtainMessage = this.f33567h.obtainMessage(3);
            obtainMessage.obj = locationClientOption;
            obtainMessage.sendToTarget();
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.x = false;
            this.f33567h.obtainMessage(1).sendToTarget();
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.x = true;
            this.f33567h.obtainMessage(2).sendToTarget();
            this.C = null;
        }
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bDAbstractLocationListener) == null) {
            if (bDAbstractLocationListener == null) {
                throw new IllegalStateException("please set a non-null listener");
            }
            Message obtainMessage = this.f33567h.obtainMessage(1400);
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
            Message obtainMessage = this.f33567h.obtainMessage(6);
            obtainMessage.obj = bDLocationListener;
            obtainMessage.sendToTarget();
        }
    }

    public boolean updateLocation(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, location)) == null) {
            if (this.f33566g == null || this.f33568i == null || location == null) {
                return false;
            }
            try {
                Message obtain = Message.obtain((Handler) null, 57);
                obtain.obj = location;
                this.f33566g.send(obtain);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
