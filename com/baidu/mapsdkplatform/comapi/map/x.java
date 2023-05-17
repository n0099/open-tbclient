package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.WinRound;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class x {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "x";
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public int b;
    public int c;
    public double d;
    public double e;
    public int f;
    public int g;
    public float h;
    public float i;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(724782716, "Lcom/baidu/mapsdkplatform/comapi/map/x;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(724782716, "Lcom/baidu/mapsdkplatform/comapi/map/x;");
        }
    }

    /* loaded from: classes3.dex */
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
        public final /* synthetic */ x i;

        public a(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = xVar;
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

    public x() {
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
        this.h = 0.0f;
        this.i = 0.0f;
        this.f = -1;
        this.g = -1;
        this.j = new WinRound();
        this.k = new a(this);
        this.l = false;
    }

    public Bundle a(d dVar) {
        InterceptResult invokeL;
        int i;
        int i2;
        WinRound winRound;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            float f = this.a;
            float f2 = dVar.b;
            if (f < f2) {
                this.a = f2;
            }
            float f3 = this.a;
            float f4 = dVar.a;
            if (f3 > f4) {
                if (f3 != 1096.0f && d.d != 26.0f) {
                    this.a = f4;
                } else {
                    this.a = 26.0f;
                    d.d = 26.0f;
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
                float f5 = i5 - ((i3 - winRound.left) / 2);
                this.h = f5;
                this.i = -(i2 - ((i4 - winRound.top) / 2));
                bundle.putFloat("xoffset", f5);
                bundle.putFloat("yoffset", this.i);
            }
            bundle.putInt("lbx", this.k.e.getIntX());
            bundle.putInt("lby", this.k.e.getIntY());
            bundle.putInt("ltx", this.k.f.getIntX());
            bundle.putInt("lty", this.k.f.getIntY());
            bundle.putInt("rtx", this.k.g.getIntX());
            bundle.putInt("rty", this.k.g.getIntY());
            bundle.putInt("rbx", this.k.h.getIntX());
            bundle.putInt("rby", this.k.h.getIntY());
            bundle.putLong("gleft", this.k.a);
            bundle.putLong("gbottom", this.k.d);
            bundle.putLong("gtop", this.k.c);
            bundle.putLong("gright", this.k.b);
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
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) != null) || bundle == null) {
            return;
        }
        this.a = (float) bundle.getDouble("level");
        this.b = (int) bundle.getDouble("rotation");
        this.c = (int) bundle.getDouble("overlooking");
        this.d = bundle.getDouble("centerptx");
        this.e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt("left");
        this.j.right = bundle.getInt("right");
        this.j.top = bundle.getInt("top");
        this.j.bottom = bundle.getInt("bottom");
        this.h = bundle.getFloat("xoffset");
        float f = bundle.getFloat("yoffset");
        this.i = f;
        WinRound winRound = this.j;
        int i2 = winRound.right;
        if (i2 != 0 && (i = winRound.bottom) != 0) {
            this.f = ((int) this.h) + ((i2 - winRound.left) / 2);
            this.g = ((int) (-f)) + ((i - winRound.top) / 2);
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
        a aVar5 = this.k;
        Point point = aVar5.e;
        long j = aVar5.a;
        point.doubleX = j;
        long j2 = aVar5.d;
        point.doubleY = j2;
        Point point2 = aVar5.f;
        point2.doubleX = j;
        long j3 = aVar5.c;
        point2.doubleY = j3;
        Point point3 = aVar5.g;
        long j4 = aVar5.b;
        point3.doubleX = j4;
        point3.doubleY = j3;
        Point point4 = aVar5.h;
        point4.doubleX = j4;
        point4.doubleY = j2;
        boolean z2 = false;
        if (bundle.getInt("bfpp") == 1) {
            z = true;
        } else {
            z = false;
        }
        this.l = z;
        this.m = bundle.getFloat("adapterZoomUnits");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        if (bundle.getInt("isbirdeye") != 0) {
            z2 = true;
        }
        this.r = z2;
        this.s = bundle.getInt("ssext");
    }
}
