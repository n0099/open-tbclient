package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.platform.comapi.map.MapBundleKey;
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
public abstract class m {
    public static /* synthetic */ Interceptable $ic;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.location.c.j a;
    public com.baidu.location.c.a b;
    public final Handler d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;
    public String i;
    public String j;
    public boolean k;
    public long l;
    public int m;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && com.baidu.location.f.isServing) {
                int i = message.what;
                if (i == 21) {
                    this.a.a(message);
                } else if (i == 62 || i == 63) {
                    this.a.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends com.baidu.location.e.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public long c;
        public long d;
        public final /* synthetic */ m e;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mVar;
            this.a = null;
            this.b = null;
            this.c = 0L;
            this.d = 0L;
            this.j = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((com.baidu.location.e.k.g || com.baidu.location.e.k.i) && this.e.i != null && this.e.j != null) {
                    this.b += String.format(Locale.CHINA, "&ki=%s&sn=%s", this.e.i, this.e.j);
                }
                if (n.a().b()) {
                    this.b += "&enc=2";
                }
                String encodeTp4 = Jni.encodeTp4(this.b);
                this.b = null;
                if (this.a == null) {
                    this.a = y.b();
                }
                this.j.put(BaseLocationBox.TYPE, encodeTp4);
                String str = this.a;
                if (str != null) {
                    this.j.put(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, str);
                }
                this.j.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
            }
        }

        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.b = str;
                this.d = System.currentTimeMillis();
                this.c = j;
                ExecutorService b = w.a().b();
                if (com.baidu.location.e.k.b()) {
                    a(b, false, null);
                } else if (b != null) {
                    a(b, com.baidu.location.e.d.c);
                } else {
                    b(com.baidu.location.e.d.c);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
            r12 = r11.i;
         */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.location.e.f
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
                    m.c = str;
                    if (str.contains("enc") && n.a().b()) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = n.a().b(jSONObject.getString("enc"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    int i = 1;
                    if (str.contains("net_loc_save")) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str);
                            JSONObject jSONObject3 = jSONObject2.has("content") ? jSONObject2.getJSONObject("content") : null;
                            if (jSONObject3 != null && jSONObject3.has("net_loc_save")) {
                                i = jSONObject3.optInt("net_loc_save", 1);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    try {
                        bDLocation = new BDLocation(str);
                        if (bDLocation.getLocType() == 161) {
                            l.a().a(str);
                        }
                        bDLocation.setOperators(com.baidu.location.c.b.a().h());
                        if (t.a().d()) {
                            bDLocation.setDirection(t.a().e());
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        obtainMessage = this.e.d.obtainMessage(63);
                        obtainMessage.obj = "HttpStatus error";
                    } else {
                        long currentTimeMillis = (System.currentTimeMillis() - this.d) / 1000;
                        if (currentTimeMillis < 0) {
                            currentTimeMillis = 0;
                        }
                        if (this.c < 0) {
                            this.c = 0L;
                        }
                        bDLocation.setDelayTime(this.c + currentTimeMillis);
                        obtainMessage = this.e.d.obtainMessage(21);
                        obtainMessage.obj = bDLocation;
                        obtainMessage.arg1 = i;
                    }
                    obtainMessage.sendToTarget();
                } catch (Exception unused2) {
                }
                map = this.j;
                if (map == null) {
                    map.clear();
                    return;
                }
                return;
            }
            Message obtainMessage2 = this.e.d.obtainMessage(63);
            obtainMessage2.obj = "HttpStatus error";
            obtainMessage2.sendToTarget();
            map = this.j;
            if (map == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723655, "Lcom/baidu/location/b/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723655, "Lcom/baidu/location/b/m;");
        }
    }

    public m() {
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
        this.a = null;
        this.b = null;
        this.e = true;
        this.f = true;
        this.g = false;
        this.h = 0L;
        this.d = new a(this);
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = 0L;
        this.m = 0;
    }

    public String a(String str) {
        InterceptResult invokeL;
        com.baidu.location.c.j jVar;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.i == null) {
                this.i = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
            }
            if (this.j == null) {
                this.j = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
            }
            com.baidu.location.c.a aVar = this.b;
            if (aVar == null || !aVar.a()) {
                this.b = com.baidu.location.c.b.a().f();
            }
            com.baidu.location.c.j jVar2 = this.a;
            if (jVar2 == null || !jVar2.j()) {
                this.a = com.baidu.location.c.k.a().o();
            }
            Location g = com.baidu.location.c.e.a().j() ? com.baidu.location.c.e.a().g() : null;
            com.baidu.location.c.a aVar2 = this.b;
            if ((aVar2 == null || aVar2.d() || this.b.c()) && (((jVar = this.a) == null || jVar.a() == 0) && g == null)) {
                return null;
            }
            String b2 = b();
            if (l.a().d() == -2) {
                b2 = b2 + "&imo=1";
            }
            int b3 = com.baidu.location.e.k.b(com.baidu.location.f.getServiceContext());
            if (b3 >= 0) {
                b2 = b2 + "&lmd=" + b3;
                if (Build.VERSION.SDK_INT >= 28 && !this.k) {
                    this.k = true;
                    try {
                        if (com.baidu.location.f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                            b2 = b2 + "&rtt=1";
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            com.baidu.location.c.j jVar3 = this.a;
            if ((jVar3 == null || jVar3.a() == 0) && (l = com.baidu.location.c.k.a().l()) != null) {
                b2 = l + b2;
            }
            String str2 = b2;
            if (this.f) {
                this.f = false;
                return com.baidu.location.e.k.a(this.b, this.a, g, str2, 0, true);
            }
            return com.baidu.location.e.k.a(this.b, this.a, g, str2, 0);
        }
        return (String) invokeL.objValue;
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String c2 = com.baidu.location.b.b.a().c();
            String format = com.baidu.location.c.k.a().i() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.c.b.a().e()));
            long currentTimeMillis = System.currentTimeMillis() - this.l;
            if (Build.VERSION.SDK_INT >= 18 && currentTimeMillis > 60000) {
                this.l = System.currentTimeMillis();
                String c3 = com.baidu.location.e.k.c();
                if (!TextUtils.isEmpty(c3)) {
                    format = format + "&qcip6c=" + c3;
                }
            }
            if (this.e) {
                this.e = false;
                int i = Build.VERSION.SDK_INT;
            } else if (!this.g) {
                String e = y.e();
                if (e != null) {
                    format = format + e;
                }
                this.g = true;
            }
            return format + c2;
        }
        return (String) invokeV.objValue;
    }
}
