package c.a.p0.n0.f;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.n0.j.b;
import c.a.p0.n0.k.g;
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
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final c f16455h;
    public static final b i;
    public static final a j;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.n0.i.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.n0.k.b f16456b;

    /* renamed from: c  reason: collision with root package name */
    public final CacheManager f16457c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.n0.a f16458d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.p0.n0.f.d.e.d f16459e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.p0.n0.e.a> f16460f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.n0.j.b f16461g;

    /* renamed from: c.a.p0.n0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class HandlerC1233a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1233a(a this$0, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
    public static final class b implements c.a.p0.n0.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.n0.i.a
        public g a(c.a.p0.n0.e.a item, c.a.p0.n0.j.b displayer, c.a.p0.n0.a config) {
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

        @Override // c.a.p0.n0.i.a
        public void b(c.a.p0.n0.e.a item, Canvas canvas, c.a.p0.n0.j.b displayer, c.a.p0.n0.a config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.j : (a) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements c.a.p0.n0.j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f16462b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16463c;

        /* renamed from: d  reason: collision with root package name */
        public final float f16464d;

        /* renamed from: e  reason: collision with root package name */
        public final float f16465e;

        /* renamed from: f  reason: collision with root package name */
        public final int f16466f;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16463c = 4;
            this.f16465e = 1.0f;
            this.f16466f = 200;
        }

        @Override // c.a.p0.n0.j.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16466f : invokeV.intValue;
        }

        @Override // c.a.p0.n0.j.b
        public float b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16465e : invokeV.floatValue;
        }

        @Override // c.a.p0.n0.j.b
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16463c : invokeV.intValue;
        }

        @Override // c.a.p0.n0.j.b
        public float d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.a(this) : invokeV.floatValue;
        }

        @Override // c.a.p0.n0.j.b
        public float e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16464d : invokeV.floatValue;
        }

        @Override // c.a.p0.n0.j.b
        public int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.intValue;
        }

        @Override // c.a.p0.n0.j.b
        public int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16462b : invokeV.intValue;
        }

        @Override // c.a.p0.n0.j.b
        public void setHeight(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.a = i;
            }
        }

        @Override // c.a.p0.n0.j.b
        public void setWidth(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.f16462b = i;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-550749881, "Lc/a/p0/n0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-550749881, "Lc/a/p0/n0/f/a;");
                return;
            }
        }
        f16455h = new c(null);
        b bVar = new b();
        i = bVar;
        j = new a(bVar);
    }

    public a(c.a.p0.n0.i.a renderer) {
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
        this.f16456b = new c.a.p0.n0.k.b();
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        Intrinsics.checkNotNullExpressionValue(myLooper, "myLooper()!!");
        this.f16457c = new CacheManager(new HandlerC1233a(this, myLooper), this.a);
        this.f16458d = new c.a.p0.n0.a(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        this.f16459e = new c.a.p0.n0.f.d.e.d();
        new c.a.p0.n0.d.a();
        this.f16460f = new ArrayList();
        new c.a.p0.n0.d.a();
        this.f16461g = new d();
        this.f16460f.iterator();
        new ArrayList();
        new ArrayList();
    }

    public final CacheManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16457c : (CacheManager) invokeV.objValue;
    }

    public final c.a.p0.n0.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16458d : (c.a.p0.n0.a) invokeV.objValue;
    }

    public final c.a.p0.n0.j.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16461g : (c.a.p0.n0.j.b) invokeV.objValue;
    }

    public final c.a.p0.n0.f.d.e.d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16459e : (c.a.p0.n0.f.d.e.d) invokeV.objValue;
    }

    public final c.a.p0.n0.k.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16456b : (c.a.p0.n0.k.b) invokeV.objValue;
    }

    public final void g(c.a.p0.n0.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.f16461g = bVar;
        }
    }

    public final void h(c.a.p0.n0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.f16458d = config;
            if (this.f16459e.b().size() != config.i().size()) {
                this.f16459e.d(CollectionsKt___CollectionsKt.toList(config.i()));
            }
            if (this.f16459e.c().size() != config.n().size()) {
                this.f16459e.e(CollectionsKt___CollectionsKt.toList(config.n()));
            }
        }
    }
}
