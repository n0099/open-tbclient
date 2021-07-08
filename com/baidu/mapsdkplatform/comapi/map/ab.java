package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.TipsConfigItem;
/* loaded from: classes2.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f7661a;

    /* renamed from: b  reason: collision with root package name */
    public int f7662b;

    /* renamed from: c  reason: collision with root package name */
    public int f7663c;

    /* renamed from: d  reason: collision with root package name */
    public double f7664d;

    /* renamed from: e  reason: collision with root package name */
    public double f7665e;

    /* renamed from: f  reason: collision with root package name */
    public int f7666f;

    /* renamed from: g  reason: collision with root package name */
    public int f7667g;

    /* renamed from: h  reason: collision with root package name */
    public long f7668h;

    /* renamed from: i  reason: collision with root package name */
    public long f7669i;
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

        /* renamed from: a  reason: collision with root package name */
        public long f7670a;

        /* renamed from: b  reason: collision with root package name */
        public long f7671b;

        /* renamed from: c  reason: collision with root package name */
        public long f7672c;

        /* renamed from: d  reason: collision with root package name */
        public long f7673d;

        /* renamed from: e  reason: collision with root package name */
        public Point f7674e;

        /* renamed from: f  reason: collision with root package name */
        public Point f7675f;

        /* renamed from: g  reason: collision with root package name */
        public Point f7676g;

        /* renamed from: h  reason: collision with root package name */
        public Point f7677h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f7678i;

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
            this.f7678i = abVar;
            this.f7670a = 0L;
            this.f7671b = 0L;
            this.f7672c = 0L;
            this.f7673d = 0L;
            this.f7674e = new Point(0, 0);
            this.f7675f = new Point(0, 0);
            this.f7676g = new Point(0, 0);
            this.f7677h = new Point(0, 0);
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
        this.f7661a = 12.0f;
        this.f7662b = 0;
        this.f7663c = 0;
        this.f7664d = 1.2958162E7d;
        this.f7665e = 4825907.0d;
        this.f7668h = 0L;
        this.f7669i = 0L;
        this.f7666f = -1;
        this.f7667g = -1;
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
            float f2 = this.f7661a;
            float f3 = eVar.f7709b;
            if (f2 < f3) {
                this.f7661a = f3;
            }
            float f4 = this.f7661a;
            float f5 = eVar.f7708a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f7707d == 26.0f) {
                    this.f7661a = 26.0f;
                    e.f7707d = 26.0f;
                } else {
                    this.f7661a = f5;
                }
            }
            while (true) {
                i2 = this.f7662b;
                if (i2 >= 0) {
                    break;
                }
                this.f7662b = i2 + 360;
            }
            this.f7662b = i2 % 360;
            if (this.f7663c > 0) {
                this.f7663c = 0;
            }
            if (this.f7663c < -45) {
                this.f7663c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.f7661a);
            bundle.putDouble("rotation", this.f7662b);
            bundle.putDouble("overlooking", this.f7663c);
            bundle.putDouble("centerptx", this.f7664d);
            bundle.putDouble("centerpty", this.f7665e);
            bundle.putInt(CustomDialogData.POS_LEFT, this.j.left);
            bundle.putInt("right", this.j.right);
            bundle.putInt("top", this.j.top);
            bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, this.j.bottom);
            int i6 = this.f7666f;
            if (i6 >= 0 && (i3 = this.f7667g) >= 0 && i6 <= (i4 = (winRound = this.j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j = i6 - ((i4 - winRound.left) / 2);
                this.f7668h = j;
                this.f7669i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j);
                bundle.putLong("yoffset", this.f7669i);
            }
            bundle.putInt("lbx", this.k.f7674e.x);
            bundle.putInt("lby", this.k.f7674e.y);
            bundle.putInt("ltx", this.k.f7675f.x);
            bundle.putInt("lty", this.k.f7675f.y);
            bundle.putInt("rtx", this.k.f7676g.x);
            bundle.putInt("rty", this.k.f7676g.y);
            bundle.putInt("rbx", this.k.f7677h.x);
            bundle.putInt("rby", this.k.f7677h.y);
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
            this.f7661a = (float) bundle.getDouble("level");
            this.f7662b = (int) bundle.getDouble("rotation");
            this.f7663c = (int) bundle.getDouble("overlooking");
            this.f7664d = bundle.getDouble("centerptx");
            this.f7665e = bundle.getDouble("centerpty");
            this.j.left = bundle.getInt(CustomDialogData.POS_LEFT);
            this.j.right = bundle.getInt("right");
            this.j.top = bundle.getInt("top");
            this.j.bottom = bundle.getInt(TipsConfigItem.TipConfigData.BOTTOM);
            this.f7668h = bundle.getLong("xoffset");
            long j = bundle.getLong("yoffset");
            this.f7669i = j;
            WinRound winRound = this.j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f7666f = ((int) this.f7668h) + ((i3 - winRound.left) / 2);
                this.f7667g = ((int) (-j)) + ((i2 - winRound.top) / 2);
            }
            this.k.f7670a = bundle.getLong("gleft");
            this.k.f7671b = bundle.getLong("gright");
            this.k.f7672c = bundle.getLong("gtop");
            this.k.f7673d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.f7670a <= -20037508) {
                aVar.f7670a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f7671b >= 20037508) {
                aVar2.f7671b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f7672c >= 20037508) {
                aVar3.f7672c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f7673d <= -20037508) {
                aVar4.f7673d = -20037508L;
            }
            this.k.f7674e.x = bundle.getInt("lbx");
            this.k.f7674e.y = bundle.getInt("lby");
            this.k.f7675f.x = bundle.getInt("ltx");
            this.k.f7675f.y = bundle.getInt("lty");
            this.k.f7676g.x = bundle.getInt("rtx");
            this.k.f7676g.y = bundle.getInt("rty");
            this.k.f7677h.x = bundle.getInt("rbx");
            this.k.f7677h.y = bundle.getInt("rby");
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
