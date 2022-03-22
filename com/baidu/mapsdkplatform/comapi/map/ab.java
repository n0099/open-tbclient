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
import com.kwad.sdk.core.config.item.TipsConfigItem;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes4.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f26664b;

    /* renamed from: c  reason: collision with root package name */
    public int f26665c;

    /* renamed from: d  reason: collision with root package name */
    public double f26666d;

    /* renamed from: e  reason: collision with root package name */
    public double f26667e;

    /* renamed from: f  reason: collision with root package name */
    public int f26668f;

    /* renamed from: g  reason: collision with root package name */
    public int f26669g;

    /* renamed from: h  reason: collision with root package name */
    public long f26670h;
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

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f26671b;

        /* renamed from: c  reason: collision with root package name */
        public long f26672c;

        /* renamed from: d  reason: collision with root package name */
        public long f26673d;

        /* renamed from: e  reason: collision with root package name */
        public Point f26674e;

        /* renamed from: f  reason: collision with root package name */
        public Point f26675f;

        /* renamed from: g  reason: collision with root package name */
        public Point f26676g;

        /* renamed from: h  reason: collision with root package name */
        public Point f26677h;
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
            this.f26671b = 0L;
            this.f26672c = 0L;
            this.f26673d = 0L;
            this.f26674e = new Point(0, 0);
            this.f26675f = new Point(0, 0);
            this.f26676g = new Point(0, 0);
            this.f26677h = new Point(0, 0);
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
        this.f26664b = 0;
        this.f26665c = 0;
        this.f26666d = 1.2958162E7d;
        this.f26667e = 4825907.0d;
        this.f26670h = 0L;
        this.i = 0L;
        this.f26668f = -1;
        this.f26669g = -1;
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
            float f2 = this.a;
            float f3 = eVar.f26700b;
            if (f2 < f3) {
                this.a = f3;
            }
            float f4 = this.a;
            float f5 = eVar.a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f26699d == 26.0f) {
                    this.a = 26.0f;
                    e.f26699d = 26.0f;
                } else {
                    this.a = f5;
                }
            }
            while (true) {
                i = this.f26664b;
                if (i >= 0) {
                    break;
                }
                this.f26664b = i + 360;
            }
            this.f26664b = i % 360;
            if (this.f26665c > 0) {
                this.f26665c = 0;
            }
            if (this.f26665c < -45) {
                this.f26665c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.f26664b);
            bundle.putDouble("overlooking", this.f26665c);
            bundle.putDouble("centerptx", this.f26666d);
            bundle.putDouble("centerpty", this.f26667e);
            bundle.putInt("left", this.j.left);
            bundle.putInt("right", this.j.right);
            bundle.putInt(AnimationProperty.TOP, this.j.top);
            bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, this.j.bottom);
            int i5 = this.f26668f;
            if (i5 >= 0 && (i2 = this.f26669g) >= 0 && i5 <= (i3 = (winRound = this.j).right) && i2 <= (i4 = winRound.bottom) && i3 > 0 && i4 > 0) {
                long j = i5 - ((i3 - winRound.left) / 2);
                this.f26670h = j;
                this.i = -(i2 - ((i4 - winRound.top) / 2));
                bundle.putLong("xoffset", j);
                bundle.putLong("yoffset", this.i);
            }
            bundle.putInt("lbx", this.k.f26674e.x);
            bundle.putInt("lby", this.k.f26674e.y);
            bundle.putInt("ltx", this.k.f26675f.x);
            bundle.putInt("lty", this.k.f26675f.y);
            bundle.putInt("rtx", this.k.f26676g.x);
            bundle.putInt("rty", this.k.f26676g.y);
            bundle.putInt("rbx", this.k.f26677h.x);
            bundle.putInt("rby", this.k.f26677h.y);
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
            this.f26664b = (int) bundle.getDouble("rotation");
            this.f26665c = (int) bundle.getDouble("overlooking");
            this.f26666d = bundle.getDouble("centerptx");
            this.f26667e = bundle.getDouble("centerpty");
            this.j.left = bundle.getInt("left");
            this.j.right = bundle.getInt("right");
            this.j.top = bundle.getInt(AnimationProperty.TOP);
            this.j.bottom = bundle.getInt(TipsConfigItem.TipConfigData.BOTTOM);
            this.f26670h = bundle.getLong("xoffset");
            long j = bundle.getLong("yoffset");
            this.i = j;
            WinRound winRound = this.j;
            int i2 = winRound.right;
            if (i2 != 0 && (i = winRound.bottom) != 0) {
                this.f26668f = ((int) this.f26670h) + ((i2 - winRound.left) / 2);
                this.f26669g = ((int) (-j)) + ((i - winRound.top) / 2);
            }
            this.k.a = bundle.getLong("gleft");
            this.k.f26671b = bundle.getLong("gright");
            this.k.f26672c = bundle.getLong("gtop");
            this.k.f26673d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f26671b >= 20037508) {
                aVar2.f26671b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f26672c >= 20037508) {
                aVar3.f26672c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f26673d <= -20037508) {
                aVar4.f26673d = -20037508L;
            }
            this.k.f26674e.x = bundle.getInt("lbx");
            this.k.f26674e.y = bundle.getInt("lby");
            this.k.f26675f.x = bundle.getInt("ltx");
            this.k.f26675f.y = bundle.getInt("lty");
            this.k.f26676g.x = bundle.getInt("rtx");
            this.k.f26676g.y = bundle.getInt("rty");
            this.k.f26677h.x = bundle.getInt("rbx");
            this.k.f26677h.y = bundle.getInt("rby");
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
