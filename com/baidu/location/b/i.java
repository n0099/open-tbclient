package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static String f6578c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.location.c.h f6579a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.location.c.a f6580b;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f6581d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6582e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6583f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6584g;

    /* renamed from: h  reason: collision with root package name */
    public String f6585h;

    /* renamed from: i  reason: collision with root package name */
    public String f6586i;
    public boolean j;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f6587a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6587a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && com.baidu.location.f.isServing) {
                int i2 = message.what;
                if (i2 == 21) {
                    this.f6587a.a(message);
                } else if (i2 == 62 || i2 == 63) {
                    this.f6587a.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends com.baidu.location.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6588a;

        /* renamed from: b  reason: collision with root package name */
        public String f6589b;

        /* renamed from: c  reason: collision with root package name */
        public long f6590c;

        /* renamed from: d  reason: collision with root package name */
        public long f6591d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f6592e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6592e = iVar;
            this.f6588a = null;
            this.f6589b = null;
            this.f6590c = 0L;
            this.f6591d = 0L;
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6780h = com.baidu.location.e.k.e();
                if ((com.baidu.location.e.k.f6799h || com.baidu.location.e.k.j) && this.f6592e.f6585h != null && this.f6592e.f6586i != null) {
                    this.f6589b += String.format(Locale.CHINA, "&ki=%s&sn=%s", this.f6592e.f6585h, this.f6592e.f6586i);
                }
                if (j.a().b()) {
                    this.f6589b += "&enc=2";
                }
                String encodeTp4 = Jni.encodeTp4(this.f6589b);
                this.f6589b = null;
                if (this.f6588a == null) {
                    this.f6588a = w.b();
                }
                this.k.put(BaseLocationBox.TYPE, encodeTp4);
                String str = this.f6588a;
                if (str != null) {
                    this.k.put("up", str);
                }
                this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
            }
        }

        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f6589b = str;
                this.f6591d = System.currentTimeMillis();
                this.f6590c = j;
                ExecutorService b2 = v.a().b();
                if (com.baidu.location.e.k.b()) {
                    a(b2, false, null);
                } else if (b2 != null) {
                    a(b2, com.baidu.location.e.k.f6797f);
                } else {
                    b(com.baidu.location.e.k.f6797f);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
            r10 = r9.j;
         */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.location.e.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            Map<String, Object> map;
            String str;
            BDLocation bDLocation;
            Message obtainMessage;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
                return;
            }
            if (z && str != null) {
                try {
                    i.f6578c = str;
                    if (str.contains("enc") && j.a().b()) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = j.a().a(jSONObject.getString("enc"));
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        bDLocation = new BDLocation(str);
                        if (bDLocation.getLocType() == 161) {
                            h.a().a(str);
                        }
                        bDLocation.setOperators(com.baidu.location.c.b.a().h());
                        if (n.a().d()) {
                            bDLocation.setDirection(n.a().e());
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.f6588a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        obtainMessage = this.f6592e.f6581d.obtainMessage(63);
                        obtainMessage.obj = "HttpStatus error";
                    } else {
                        long currentTimeMillis = (System.currentTimeMillis() - this.f6591d) / 1000;
                        if (currentTimeMillis < 0) {
                            currentTimeMillis = 0;
                        }
                        if (this.f6590c < 0) {
                            this.f6590c = 0L;
                        }
                        bDLocation.setDelayTime(this.f6590c + currentTimeMillis);
                        obtainMessage = this.f6592e.f6581d.obtainMessage(21);
                        obtainMessage.obj = bDLocation;
                    }
                    obtainMessage.sendToTarget();
                } catch (Exception unused) {
                }
                map = this.k;
                if (map == null) {
                    map.clear();
                    return;
                }
                return;
            }
            Message obtainMessage2 = this.f6592e.f6581d.obtainMessage(63);
            obtainMessage2.obj = "HttpStatus error";
            obtainMessage2.sendToTarget();
            map = this.k;
            if (map == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723531, "Lcom/baidu/location/b/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723531, "Lcom/baidu/location/b/i;");
        }
    }

    public i() {
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
        this.f6579a = null;
        this.f6580b = null;
        this.f6582e = true;
        this.f6583f = true;
        this.f6584g = false;
        this.f6581d = new a(this);
        this.f6585h = null;
        this.f6586i = null;
        this.j = false;
    }

    public String a(String str) {
        InterceptResult invokeL;
        com.baidu.location.c.h hVar;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f6585h == null) {
                this.f6585h = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
            }
            if (this.f6586i == null) {
                this.f6586i = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
            }
            com.baidu.location.c.a aVar = this.f6580b;
            if (aVar == null || !aVar.a()) {
                this.f6580b = com.baidu.location.c.b.a().f();
            }
            com.baidu.location.c.h hVar2 = this.f6579a;
            if (hVar2 == null || !hVar2.j()) {
                this.f6579a = com.baidu.location.c.i.a().o();
            }
            Location g2 = com.baidu.location.c.e.a().i() ? com.baidu.location.c.e.a().g() : null;
            com.baidu.location.c.a aVar2 = this.f6580b;
            if ((aVar2 == null || aVar2.d() || this.f6580b.c()) && (((hVar = this.f6579a) == null || hVar.a() == 0) && g2 == null)) {
                return null;
            }
            String b2 = b();
            if (h.a().d() == -2) {
                b2 = b2 + "&imo=1";
            }
            int b3 = com.baidu.location.e.k.b(com.baidu.location.f.getServiceContext());
            if (b3 >= 0) {
                b2 = b2 + "&lmd=" + b3;
                if (Build.VERSION.SDK_INT >= 28 && !this.j) {
                    this.j = true;
                    try {
                        if (com.baidu.location.f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                            b2 = b2 + "&rtt=1";
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            com.baidu.location.c.h hVar3 = this.f6579a;
            if ((hVar3 == null || hVar3.a() == 0) && (l = com.baidu.location.c.i.a().l()) != null) {
                b2 = l + b2;
            }
            String str2 = b2;
            if (this.f6583f) {
                this.f6583f = false;
                return com.baidu.location.e.k.a(this.f6580b, this.f6579a, g2, str2, 0, true);
            }
            return com.baidu.location.e.k.a(this.f6580b, this.f6579a, g2, str2, 0);
        }
        return (String) invokeL.objValue;
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String c2 = com.baidu.location.b.a.a().c();
            String format = com.baidu.location.c.i.i() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.c.b.a().e()));
            if (Build.VERSION.SDK_INT >= 18) {
                String d2 = com.baidu.location.e.k.d();
                if (!TextUtils.isEmpty(d2)) {
                    format = format + "&qcip6c=" + d2;
                }
            }
            if (this.f6582e) {
                this.f6582e = false;
                int i2 = Build.VERSION.SDK_INT;
            } else if (!this.f6584g) {
                String e2 = w.e();
                if (e2 != null) {
                    format = format + e2;
                }
                this.f6584g = true;
            }
            return format + c2;
        }
        return (String) invokeV.objValue;
    }
}
