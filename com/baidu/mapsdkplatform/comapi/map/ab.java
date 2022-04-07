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
/* loaded from: classes2.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public int b;
    public int c;
    public double d;
    public double e;
    public int f;
    public int g;
    public long h;
    public long i;
    public WinRound j;
    public a k;
    public boolean l;
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;
        public long c;
        public long d;
        public Point e;
        public Point f;
        public Point g;
        public Point h;
        public final /* synthetic */ ab i;

        public a(ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = abVar;
            this.a = 0L;
            this.b = 0L;
            this.c = 0L;
            this.d = 0L;
            this.e = new Point(0, 0);
            this.f = new Point(0, 0);
            this.g = new Point(0, 0);
            this.h = new Point(0, 0);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 12.0f;
        this.b = 0;
        this.c = 0;
        this.d = 1.2958162E7d;
        this.e = 4825907.0d;
        this.h = 0L;
        this.i = 0L;
        this.f = -1;
        this.g = -1;
        this.j = new WinRound();
        this.k = new a(this);
        this.l = false;
    }

    public Bundle a(e eVar) {
        InterceptResult invokeL;
        int i;
        int i2;
        WinRound winRound;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            float f = this.a;
            float f2 = eVar.b;
            if (f < f2) {
                this.a = f2;
            }
            float f3 = this.a;
            float f4 = eVar.a;
            if (f3 > f4) {
                if (f3 == 1096.0f || e.d == 26.0f) {
                    this.a = 26.0f;
                    e.d = 26.0f;
                } else {
                    this.a = f4;
                }
            }
            while (true) {
                i = this.b;
                if (i >= 0) {
                    break;
                }
                this.b = i + 360;
            }
            this.b = i % 360;
            if (this.c > 0) {
                this.c = 0;
            }
            if (this.c < -45) {
                this.c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.b);
            bundle.putDouble("overlooking", this.c);
            bundle.putDouble("centerptx", this.d);
            bundle.putDouble("centerpty", this.e);
            bundle.putInt("left", this.j.left);
            bundle.putInt("right", this.j.right);
            bundle.putInt("top", this.j.top);
            bundle.putInt("bottom", this.j.bottom);
            int i5 = this.f;
            if (i5 >= 0 && (i2 = this.g) >= 0 && i5 <= (i3 = (winRound = this.j).right) && i2 <= (i4 = winRound.bottom) && i3 > 0 && i4 > 0) {
                long j = i5 - ((i3 - winRound.left) / 2);
                this.h = j;
                this.i = -(i2 - ((i4 - winRound.top) / 2));
                bundle.putLong("xoffset", j);
                bundle.putLong("yoffset", this.i);
            }
            bundle.putInt("lbx", this.k.e.x);
            bundle.putInt("lby", this.k.e.y);
            bundle.putInt("ltx", this.k.f.x);
            bundle.putInt("lty", this.k.f.y);
            bundle.putInt("rtx", this.k.g.x);
            bundle.putInt("rty", this.k.g.y);
            bundle.putInt("rbx", this.k.h.x);
            bundle.putInt("rby", this.k.h.y);
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.a = (float) bundle.getDouble("level");
            this.b = (int) bundle.getDouble("rotation");
            this.c = (int) bundle.getDouble("overlooking");
            this.d = bundle.getDouble("centerptx");
            this.e = bundle.getDouble("centerpty");
            this.j.left = bundle.getInt("left");
            this.j.right = bundle.getInt("right");
            this.j.top = bundle.getInt("top");
            this.j.bottom = bundle.getInt("bottom");
            this.h = bundle.getLong("xoffset");
            long j = bundle.getLong("yoffset");
            this.i = j;
            WinRound winRound = this.j;
            int i2 = winRound.right;
            if (i2 != 0 && (i = winRound.bottom) != 0) {
                this.f = ((int) this.h) + ((i2 - winRound.left) / 2);
                this.g = ((int) (-j)) + ((i - winRound.top) / 2);
            }
            this.k.a = bundle.getLong("gleft");
            this.k.b = bundle.getLong("gright");
            this.k.c = bundle.getLong("gtop");
            this.k.d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.b >= 20037508) {
                aVar2.b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.c >= 20037508) {
                aVar3.c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.d <= -20037508) {
                aVar4.d = -20037508L;
            }
            this.k.e.x = bundle.getInt("lbx");
            this.k.e.y = bundle.getInt("lby");
            this.k.f.x = bundle.getInt("ltx");
            this.k.f.y = bundle.getInt("lty");
            this.k.g.x = bundle.getInt("rtx");
            this.k.g.y = bundle.getInt("rty");
            this.k.h.x = bundle.getInt("rbx");
            this.k.h.y = bundle.getInt("rby");
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
