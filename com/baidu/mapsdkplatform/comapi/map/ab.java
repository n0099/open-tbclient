package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f40067a;

    /* renamed from: b  reason: collision with root package name */
    public int f40068b;

    /* renamed from: c  reason: collision with root package name */
    public int f40069c;

    /* renamed from: d  reason: collision with root package name */
    public double f40070d;

    /* renamed from: e  reason: collision with root package name */
    public double f40071e;

    /* renamed from: f  reason: collision with root package name */
    public int f40072f;

    /* renamed from: g  reason: collision with root package name */
    public int f40073g;

    /* renamed from: h  reason: collision with root package name */
    public long f40074h;

    /* renamed from: i  reason: collision with root package name */
    public long f40075i;
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

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f40076a;

        /* renamed from: b  reason: collision with root package name */
        public long f40077b;

        /* renamed from: c  reason: collision with root package name */
        public long f40078c;

        /* renamed from: d  reason: collision with root package name */
        public long f40079d;

        /* renamed from: e  reason: collision with root package name */
        public Point f40080e;

        /* renamed from: f  reason: collision with root package name */
        public Point f40081f;

        /* renamed from: g  reason: collision with root package name */
        public Point f40082g;

        /* renamed from: h  reason: collision with root package name */
        public Point f40083h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f40084i;

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
            this.f40084i = abVar;
            this.f40076a = 0L;
            this.f40077b = 0L;
            this.f40078c = 0L;
            this.f40079d = 0L;
            this.f40080e = new Point(0, 0);
            this.f40081f = new Point(0, 0);
            this.f40082g = new Point(0, 0);
            this.f40083h = new Point(0, 0);
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
        this.f40067a = 12.0f;
        this.f40068b = 0;
        this.f40069c = 0;
        this.f40070d = 1.2958162E7d;
        this.f40071e = 4825907.0d;
        this.f40074h = 0L;
        this.f40075i = 0L;
        this.f40072f = -1;
        this.f40073g = -1;
        this.j = new WinRound();
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
            float f2 = this.f40067a;
            float f3 = eVar.f40115b;
            if (f2 < f3) {
                this.f40067a = f3;
            }
            float f4 = this.f40067a;
            float f5 = eVar.f40114a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f40113d == 26.0f) {
                    this.f40067a = 26.0f;
                    e.f40113d = 26.0f;
                } else {
                    this.f40067a = f5;
                }
            }
            while (true) {
                i2 = this.f40068b;
                if (i2 >= 0) {
                    break;
                }
                this.f40068b = i2 + 360;
            }
            this.f40068b = i2 % 360;
            if (this.f40069c > 0) {
                this.f40069c = 0;
            }
            if (this.f40069c < -45) {
                this.f40069c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, this.f40067a);
            bundle.putDouble(Key.ROTATION, this.f40068b);
            bundle.putDouble("overlooking", this.f40069c);
            bundle.putDouble("centerptx", this.f40070d);
            bundle.putDouble("centerpty", this.f40071e);
            bundle.putInt("left", this.j.left);
            bundle.putInt(HorizontalTranslateLayout.RIGHT, this.j.right);
            bundle.putInt(VerticalTranslateLayout.TOP, this.j.top);
            bundle.putInt("bottom", this.j.bottom);
            int i6 = this.f40072f;
            if (i6 >= 0 && (i3 = this.f40073g) >= 0 && i6 <= (i4 = (winRound = this.j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j = i6 - ((i4 - winRound.left) / 2);
                this.f40074h = j;
                this.f40075i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j);
                bundle.putLong("yoffset", this.f40075i);
            }
            bundle.putInt("lbx", this.k.f40080e.x);
            bundle.putInt("lby", this.k.f40080e.y);
            bundle.putInt("ltx", this.k.f40081f.x);
            bundle.putInt("lty", this.k.f40081f.y);
            bundle.putInt("rtx", this.k.f40082g.x);
            bundle.putInt("rty", this.k.f40082g.y);
            bundle.putInt("rbx", this.k.f40083h.x);
            bundle.putInt("rby", this.k.f40083h.y);
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
            this.f40067a = (float) bundle.getDouble(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
            this.f40068b = (int) bundle.getDouble(Key.ROTATION);
            this.f40069c = (int) bundle.getDouble("overlooking");
            this.f40070d = bundle.getDouble("centerptx");
            this.f40071e = bundle.getDouble("centerpty");
            this.j.left = bundle.getInt("left");
            this.j.right = bundle.getInt(HorizontalTranslateLayout.RIGHT);
            this.j.top = bundle.getInt(VerticalTranslateLayout.TOP);
            this.j.bottom = bundle.getInt("bottom");
            this.f40074h = bundle.getLong("xoffset");
            long j = bundle.getLong("yoffset");
            this.f40075i = j;
            WinRound winRound = this.j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f40072f = ((int) this.f40074h) + ((i3 - winRound.left) / 2);
                this.f40073g = ((int) (-j)) + ((i2 - winRound.top) / 2);
            }
            this.k.f40076a = bundle.getLong("gleft");
            this.k.f40077b = bundle.getLong("gright");
            this.k.f40078c = bundle.getLong("gtop");
            this.k.f40079d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.f40076a <= -20037508) {
                aVar.f40076a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f40077b >= 20037508) {
                aVar2.f40077b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f40078c >= 20037508) {
                aVar3.f40078c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f40079d <= -20037508) {
                aVar4.f40079d = -20037508L;
            }
            this.k.f40080e.x = bundle.getInt("lbx");
            this.k.f40080e.y = bundle.getInt("lby");
            this.k.f40081f.x = bundle.getInt("ltx");
            this.k.f40081f.y = bundle.getInt("lty");
            this.k.f40082g.x = bundle.getInt("rtx");
            this.k.f40082g.y = bundle.getInt("rty");
            this.k.f40083h.x = bundle.getInt("rbx");
            this.k.f40083h.y = bundle.getInt("rby");
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
