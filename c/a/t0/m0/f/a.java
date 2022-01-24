package c.a.t0.m0.f;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.m0.j.b;
import c.a.t0.m0.k.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final c f19485h;

    /* renamed from: i  reason: collision with root package name */
    public static final b f19486i;

    /* renamed from: j  reason: collision with root package name */
    public static final a f19487j;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.t0.m0.i.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.t0.m0.k.b f19488b;

    /* renamed from: c  reason: collision with root package name */
    public final CacheManager f19489c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.m0.a f19490d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.t0.m0.f.d.e.d f19491e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.t0.m0.e.a> f19492f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.m0.j.b f19493g;

    /* renamed from: c.a.t0.m0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class HandlerC1212a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1212a(a this$0, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.a = this$0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what == -1) {
                    BdLog.w("DanmakuEngine [Context] onCacheSign, updateRender");
                    this.a.c().H();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements c.a.t0.m0.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.t0.m0.i.a
        public g a(c.a.t0.m0.e.a item, c.a.t0.m0.j.b displayer, c.a.t0.m0.a config) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, displayer, config)) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
                return new g(0, 0);
            }
            return (g) invokeLLL.objValue;
        }

        @Override // c.a.t0.m0.i.a
        public void b(c.a.t0.m0.e.a item, Canvas canvas, c.a.t0.m0.j.b displayer, c.a.t0.m0.a config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f19487j : (a) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements c.a.t0.m0.j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f19494b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19495c;

        /* renamed from: d  reason: collision with root package name */
        public final float f19496d;

        /* renamed from: e  reason: collision with root package name */
        public final float f19497e;

        /* renamed from: f  reason: collision with root package name */
        public final int f19498f;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19495c = 4;
            this.f19497e = 1.0f;
            this.f19498f = 200;
        }

        @Override // c.a.t0.m0.j.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19498f : invokeV.intValue;
        }

        @Override // c.a.t0.m0.j.b
        public float b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19497e : invokeV.floatValue;
        }

        @Override // c.a.t0.m0.j.b
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19495c : invokeV.intValue;
        }

        @Override // c.a.t0.m0.j.b
        public float d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.a(this) : invokeV.floatValue;
        }

        @Override // c.a.t0.m0.j.b
        public float e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19496d : invokeV.floatValue;
        }

        @Override // c.a.t0.m0.j.b
        public int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.intValue;
        }

        @Override // c.a.t0.m0.j.b
        public int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19494b : invokeV.intValue;
        }

        @Override // c.a.t0.m0.j.b
        public void setHeight(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.a = i2;
            }
        }

        @Override // c.a.t0.m0.j.b
        public void setWidth(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f19494b = i2;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2070659714, "Lc/a/t0/m0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2070659714, "Lc/a/t0/m0/f/a;");
                return;
            }
        }
        f19485h = new c(null);
        b bVar = new b();
        f19486i = bVar;
        f19487j = new a(bVar);
    }

    public a(c.a.t0.m0.i.a renderer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {renderer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.a = renderer;
        this.f19488b = new c.a.t0.m0.k.b();
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        Intrinsics.checkNotNullExpressionValue(myLooper, "myLooper()!!");
        this.f19489c = new CacheManager(new HandlerC1212a(this, myLooper), this.a);
        this.f19490d = new c.a.t0.m0.a(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        this.f19491e = new c.a.t0.m0.f.d.e.d();
        new c.a.t0.m0.d.a();
        this.f19492f = new ArrayList();
        new c.a.t0.m0.d.a();
        this.f19493g = new d();
        this.f19492f.iterator();
        new ArrayList();
        new ArrayList();
    }

    public final CacheManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19489c : (CacheManager) invokeV.objValue;
    }

    public final c.a.t0.m0.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19490d : (c.a.t0.m0.a) invokeV.objValue;
    }

    public final c.a.t0.m0.j.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19493g : (c.a.t0.m0.j.b) invokeV.objValue;
    }

    public final c.a.t0.m0.f.d.e.d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19491e : (c.a.t0.m0.f.d.e.d) invokeV.objValue;
    }

    public final c.a.t0.m0.k.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19488b : (c.a.t0.m0.k.b) invokeV.objValue;
    }

    public final void g(c.a.t0.m0.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.f19493g = bVar;
        }
    }

    public final void h(c.a.t0.m0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.f19490d = config;
            if (this.f19491e.b().size() != config.i().size()) {
                this.f19491e.d(CollectionsKt___CollectionsKt.toList(config.i()));
            }
            if (this.f19491e.c().size() != config.n().size()) {
                this.f19491e.e(CollectionsKt___CollectionsKt.toList(config.n()));
            }
        }
    }
}
