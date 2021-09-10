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
/* loaded from: classes5.dex */
public abstract class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static String f41067c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.location.c.h f41068a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.location.c.a f41069b;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f41070d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41071e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41072f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41073g;

    /* renamed from: h  reason: collision with root package name */
    public String f41074h;

    /* renamed from: i  reason: collision with root package name */
    public String f41075i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41076j;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f41077a;

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
            this.f41077a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && com.baidu.location.f.isServing) {
                int i2 = message.what;
                if (i2 == 21) {
                    this.f41077a.a(message);
                } else if (i2 == 62 || i2 == 63) {
                    this.f41077a.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends com.baidu.location.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41078a;

        /* renamed from: b  reason: collision with root package name */
        public String f41079b;

        /* renamed from: c  reason: collision with root package name */
        public long f41080c;

        /* renamed from: d  reason: collision with root package name */
        public long f41081d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f41082e;

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
            this.f41082e = iVar;
            this.f41078a = null;
            this.f41079b = null;
            this.f41080c = 0L;
            this.f41081d = 0L;
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41279h = com.baidu.location.e.k.e();
                if ((com.baidu.location.e.k.f41299h || com.baidu.location.e.k.f41301j) && this.f41082e.f41074h != null && this.f41082e.f41075i != null) {
                    this.f41079b += String.format(Locale.CHINA, "&ki=%s&sn=%s", this.f41082e.f41074h, this.f41082e.f41075i);
                }
                if (j.a().b()) {
                    this.f41079b += "&enc=2";
                }
                String encodeTp4 = Jni.encodeTp4(this.f41079b);
                this.f41079b = null;
                if (this.f41078a == null) {
                    this.f41078a = w.b();
                }
                this.k.put(BaseLocationBox.TYPE, encodeTp4);
                String str = this.f41078a;
                if (str != null) {
                    this.k.put("up", str);
                }
                this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
            }
        }

        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.f41079b = str;
                this.f41081d = System.currentTimeMillis();
                this.f41080c = j2;
                ExecutorService b2 = v.a().b();
                if (com.baidu.location.e.k.b()) {
                    a(b2, false, null);
                } else if (b2 != null) {
                    a(b2, com.baidu.location.e.k.f41297f);
                } else {
                    b(com.baidu.location.e.k.f41297f);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
            r10 = r9.f41281j;
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
                    i.f41067c = str;
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
                    this.f41078a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        obtainMessage = this.f41082e.f41070d.obtainMessage(63);
                        obtainMessage.obj = "HttpStatus error";
                    } else {
                        long currentTimeMillis = (System.currentTimeMillis() - this.f41081d) / 1000;
                        if (currentTimeMillis < 0) {
                            currentTimeMillis = 0;
                        }
                        if (this.f41080c < 0) {
                            this.f41080c = 0L;
                        }
                        bDLocation.setDelayTime(this.f41080c + currentTimeMillis);
                        obtainMessage = this.f41082e.f41070d.obtainMessage(21);
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
            Message obtainMessage2 = this.f41082e.f41070d.obtainMessage(63);
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
        this.f41068a = null;
        this.f41069b = null;
        this.f41071e = true;
        this.f41072f = true;
        this.f41073g = false;
        this.f41070d = new a(this);
        this.f41074h = null;
        this.f41075i = null;
        this.f41076j = false;
    }

    public String a(String str) {
        InterceptResult invokeL;
        com.baidu.location.c.h hVar;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f41074h == null) {
                this.f41074h = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
            }
            if (this.f41075i == null) {
                this.f41075i = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
            }
            com.baidu.location.c.a aVar = this.f41069b;
            if (aVar == null || !aVar.a()) {
                this.f41069b = com.baidu.location.c.b.a().f();
            }
            com.baidu.location.c.h hVar2 = this.f41068a;
            if (hVar2 == null || !hVar2.j()) {
                this.f41068a = com.baidu.location.c.i.a().o();
            }
            Location g2 = com.baidu.location.c.e.a().i() ? com.baidu.location.c.e.a().g() : null;
            com.baidu.location.c.a aVar2 = this.f41069b;
            if ((aVar2 == null || aVar2.d() || this.f41069b.c()) && (((hVar = this.f41068a) == null || hVar.a() == 0) && g2 == null)) {
                return null;
            }
            String b2 = b();
            if (h.a().d() == -2) {
                b2 = b2 + "&imo=1";
            }
            int b3 = com.baidu.location.e.k.b(com.baidu.location.f.getServiceContext());
            if (b3 >= 0) {
                b2 = b2 + "&lmd=" + b3;
                if (Build.VERSION.SDK_INT >= 28 && !this.f41076j) {
                    this.f41076j = true;
                    try {
                        if (com.baidu.location.f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                            b2 = b2 + "&rtt=1";
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            com.baidu.location.c.h hVar3 = this.f41068a;
            if ((hVar3 == null || hVar3.a() == 0) && (l = com.baidu.location.c.i.a().l()) != null) {
                b2 = l + b2;
            }
            String str2 = b2;
            if (this.f41072f) {
                this.f41072f = false;
                return com.baidu.location.e.k.a(this.f41069b, this.f41068a, g2, str2, 0, true);
            }
            return com.baidu.location.e.k.a(this.f41069b, this.f41068a, g2, str2, 0);
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
            if (this.f41071e) {
                this.f41071e = false;
                int i2 = Build.VERSION.SDK_INT;
            } else if (!this.f41073g) {
                String e2 = w.e();
                if (e2 != null) {
                    format = format + e2;
                }
                this.f41073g = true;
            }
            return format + c2;
        }
        return (String) invokeV.objValue;
    }
}
