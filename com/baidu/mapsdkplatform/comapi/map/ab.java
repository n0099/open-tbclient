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
    public int f35845b;

    /* renamed from: c  reason: collision with root package name */
    public int f35846c;

    /* renamed from: d  reason: collision with root package name */
    public double f35847d;

    /* renamed from: e  reason: collision with root package name */
    public double f35848e;

    /* renamed from: f  reason: collision with root package name */
    public int f35849f;

    /* renamed from: g  reason: collision with root package name */
    public int f35850g;

    /* renamed from: h  reason: collision with root package name */
    public long f35851h;

    /* renamed from: i  reason: collision with root package name */
    public long f35852i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f35853j;
    public a k;
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
        public long f35854b;

        /* renamed from: c  reason: collision with root package name */
        public long f35855c;

        /* renamed from: d  reason: collision with root package name */
        public long f35856d;

        /* renamed from: e  reason: collision with root package name */
        public Point f35857e;

        /* renamed from: f  reason: collision with root package name */
        public Point f35858f;

        /* renamed from: g  reason: collision with root package name */
        public Point f35859g;

        /* renamed from: h  reason: collision with root package name */
        public Point f35860h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f35861i;

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
            this.f35861i = abVar;
            this.a = 0L;
            this.f35854b = 0L;
            this.f35855c = 0L;
            this.f35856d = 0L;
            this.f35857e = new Point(0, 0);
            this.f35858f = new Point(0, 0);
            this.f35859g = new Point(0, 0);
            this.f35860h = new Point(0, 0);
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
        this.f35845b = 0;
        this.f35846c = 0;
        this.f35847d = 1.2958162E7d;
        this.f35848e = 4825907.0d;
        this.f35851h = 0L;
        this.f35852i = 0L;
        this.f35849f = -1;
        this.f35850g = -1;
        this.f35853j = new WinRound();
        this.k = new a(this);
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
            float f3 = eVar.f35887b;
            if (f2 < f3) {
                this.a = f3;
            }
            float f4 = this.a;
            float f5 = eVar.a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f35886d == 26.0f) {
                    this.a = 26.0f;
                    e.f35886d = 26.0f;
                } else {
                    this.a = f5;
                }
            }
            while (true) {
                i2 = this.f35845b;
                if (i2 >= 0) {
                    break;
                }
                this.f35845b = i2 + 360;
            }
            this.f35845b = i2 % 360;
            if (this.f35846c > 0) {
                this.f35846c = 0;
            }
            if (this.f35846c < -45) {
                this.f35846c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.f35845b);
            bundle.putDouble("overlooking", this.f35846c);
            bundle.putDouble("centerptx", this.f35847d);
            bundle.putDouble("centerpty", this.f35848e);
            bundle.putInt("left", this.f35853j.left);
            bundle.putInt("right", this.f35853j.right);
            bundle.putInt("top", this.f35853j.top);
            bundle.putInt("bottom", this.f35853j.bottom);
            int i6 = this.f35849f;
            if (i6 >= 0 && (i3 = this.f35850g) >= 0 && i6 <= (i4 = (winRound = this.f35853j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f35851h = j2;
                this.f35852i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f35852i);
            }
            bundle.putInt("lbx", this.k.f35857e.x);
            bundle.putInt("lby", this.k.f35857e.y);
            bundle.putInt("ltx", this.k.f35858f.x);
            bundle.putInt("lty", this.k.f35858f.y);
            bundle.putInt("rtx", this.k.f35859g.x);
            bundle.putInt("rty", this.k.f35859g.y);
            bundle.putInt("rbx", this.k.f35860h.x);
            bundle.putInt("rby", this.k.f35860h.y);
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
            this.f35845b = (int) bundle.getDouble("rotation");
            this.f35846c = (int) bundle.getDouble("overlooking");
            this.f35847d = bundle.getDouble("centerptx");
            this.f35848e = bundle.getDouble("centerpty");
            this.f35853j.left = bundle.getInt("left");
            this.f35853j.right = bundle.getInt("right");
            this.f35853j.top = bundle.getInt("top");
            this.f35853j.bottom = bundle.getInt("bottom");
            this.f35851h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f35852i = j2;
            WinRound winRound = this.f35853j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f35849f = ((int) this.f35851h) + ((i3 - winRound.left) / 2);
                this.f35850g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.k.a = bundle.getLong("gleft");
            this.k.f35854b = bundle.getLong("gright");
            this.k.f35855c = bundle.getLong("gtop");
            this.k.f35856d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f35854b >= 20037508) {
                aVar2.f35854b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f35855c >= 20037508) {
                aVar3.f35855c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f35856d <= -20037508) {
                aVar4.f35856d = -20037508L;
            }
            this.k.f35857e.x = bundle.getInt("lbx");
            this.k.f35857e.y = bundle.getInt("lby");
            this.k.f35858f.x = bundle.getInt("ltx");
            this.k.f35858f.y = bundle.getInt("lty");
            this.k.f35859g.x = bundle.getInt("rtx");
            this.k.f35859g.y = bundle.getInt("rty");
            this.k.f35860h.x = bundle.getInt("rbx");
            this.k.f35860h.y = bundle.getInt("rby");
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
