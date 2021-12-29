package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f37034b;

    /* renamed from: c  reason: collision with root package name */
    public int f37035c;

    /* renamed from: d  reason: collision with root package name */
    public double f37036d;

    /* renamed from: e  reason: collision with root package name */
    public double f37037e;

    /* renamed from: f  reason: collision with root package name */
    public int f37038f;

    /* renamed from: g  reason: collision with root package name */
    public int f37039g;

    /* renamed from: h  reason: collision with root package name */
    public long f37040h;

    /* renamed from: i  reason: collision with root package name */
    public long f37041i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f37042j;

    /* renamed from: k  reason: collision with root package name */
    public a f37043k;
    public boolean l;
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f37044b;

        /* renamed from: c  reason: collision with root package name */
        public long f37045c;

        /* renamed from: d  reason: collision with root package name */
        public long f37046d;

        /* renamed from: e  reason: collision with root package name */
        public Point f37047e;

        /* renamed from: f  reason: collision with root package name */
        public Point f37048f;

        /* renamed from: g  reason: collision with root package name */
        public Point f37049g;

        /* renamed from: h  reason: collision with root package name */
        public Point f37050h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f37051i;

        public a(ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37051i = abVar;
            this.a = 0L;
            this.f37044b = 0L;
            this.f37045c = 0L;
            this.f37046d = 0L;
            this.f37047e = new Point(0, 0);
            this.f37048f = new Point(0, 0);
            this.f37049g = new Point(0, 0);
            this.f37050h = new Point(0, 0);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(993406881, "Lcom/baidu/mapsdkplatform/comapi/map/ab;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(993406881, "Lcom/baidu/mapsdkplatform/comapi/map/ab;");
        }
    }

    public ab() {
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
        this.a = 12.0f;
        this.f37034b = 0;
        this.f37035c = 0;
        this.f37036d = 1.2958162E7d;
        this.f37037e = 4825907.0d;
        this.f37040h = 0L;
        this.f37041i = 0L;
        this.f37038f = -1;
        this.f37039g = -1;
        this.f37042j = new WinRound();
        this.f37043k = new a(this);
        this.l = false;
    }

    public Bundle a(e eVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        WinRound winRound;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            float f2 = this.a;
            float f3 = eVar.f37078b;
            if (f2 < f3) {
                this.a = f3;
            }
            float f4 = this.a;
            float f5 = eVar.a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f37077d == 26.0f) {
                    this.a = 26.0f;
                    e.f37077d = 26.0f;
                } else {
                    this.a = f5;
                }
            }
            while (true) {
                i2 = this.f37034b;
                if (i2 >= 0) {
                    break;
                }
                this.f37034b = i2 + 360;
            }
            this.f37034b = i2 % 360;
            if (this.f37035c > 0) {
                this.f37035c = 0;
            }
            if (this.f37035c < -45) {
                this.f37035c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.f37034b);
            bundle.putDouble("overlooking", this.f37035c);
            bundle.putDouble("centerptx", this.f37036d);
            bundle.putDouble("centerpty", this.f37037e);
            bundle.putInt("left", this.f37042j.left);
            bundle.putInt("right", this.f37042j.right);
            bundle.putInt("top", this.f37042j.top);
            bundle.putInt("bottom", this.f37042j.bottom);
            int i6 = this.f37038f;
            if (i6 >= 0 && (i3 = this.f37039g) >= 0 && i6 <= (i4 = (winRound = this.f37042j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f37040h = j2;
                this.f37041i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f37041i);
            }
            bundle.putInt("lbx", this.f37043k.f37047e.x);
            bundle.putInt("lby", this.f37043k.f37047e.y);
            bundle.putInt("ltx", this.f37043k.f37048f.x);
            bundle.putInt("lty", this.f37043k.f37048f.y);
            bundle.putInt("rtx", this.f37043k.f37049g.x);
            bundle.putInt("rty", this.f37043k.f37049g.y);
            bundle.putInt("rbx", this.f37043k.f37050h.x);
            bundle.putInt("rby", this.f37043k.f37050h.y);
            bundle.putInt("bfpp", this.l ? 1 : 0);
            bundle.putInt("animation", 1);
            bundle.putInt("animatime", this.o);
            bundle.putString("panoid", this.p);
            bundle.putInt("autolink", 0);
            bundle.putFloat("siangle", this.q);
            bundle.putInt("isbirdeye", this.r ? 1 : 0);
            bundle.putInt("ssext", this.s);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void a(Bundle bundle) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.a = (float) bundle.getDouble("level");
            this.f37034b = (int) bundle.getDouble("rotation");
            this.f37035c = (int) bundle.getDouble("overlooking");
            this.f37036d = bundle.getDouble("centerptx");
            this.f37037e = bundle.getDouble("centerpty");
            this.f37042j.left = bundle.getInt("left");
            this.f37042j.right = bundle.getInt("right");
            this.f37042j.top = bundle.getInt("top");
            this.f37042j.bottom = bundle.getInt("bottom");
            this.f37040h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f37041i = j2;
            WinRound winRound = this.f37042j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f37038f = ((int) this.f37040h) + ((i3 - winRound.left) / 2);
                this.f37039g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.f37043k.a = bundle.getLong("gleft");
            this.f37043k.f37044b = bundle.getLong("gright");
            this.f37043k.f37045c = bundle.getLong("gtop");
            this.f37043k.f37046d = bundle.getLong("gbottom");
            a aVar = this.f37043k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.f37043k;
            if (aVar2.f37044b >= 20037508) {
                aVar2.f37044b = 20037508L;
            }
            a aVar3 = this.f37043k;
            if (aVar3.f37045c >= 20037508) {
                aVar3.f37045c = 20037508L;
            }
            a aVar4 = this.f37043k;
            if (aVar4.f37046d <= -20037508) {
                aVar4.f37046d = -20037508L;
            }
            this.f37043k.f37047e.x = bundle.getInt("lbx");
            this.f37043k.f37047e.y = bundle.getInt("lby");
            this.f37043k.f37048f.x = bundle.getInt("ltx");
            this.f37043k.f37048f.y = bundle.getInt("lty");
            this.f37043k.f37049g.x = bundle.getInt("rtx");
            this.f37043k.f37049g.y = bundle.getInt("rty");
            this.f37043k.f37050h.x = bundle.getInt("rbx");
            this.f37043k.f37050h.y = bundle.getInt("rby");
            this.l = bundle.getInt("bfpp") == 1;
            this.m = bundle.getDouble("adapterzoomunit");
            this.n = bundle.getDouble("zoomunit");
            this.p = bundle.getString("panoid");
            this.q = bundle.getFloat("siangle");
            this.r = bundle.getInt("isbirdeye") != 0;
            this.s = bundle.getInt("ssext");
        }
    }
}
