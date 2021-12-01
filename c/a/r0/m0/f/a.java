package c.a.r0.m0.f;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.m0.j.b;
import c.a.r0.m0.k.g;
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
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final c f19877h;

    /* renamed from: i  reason: collision with root package name */
    public static final b f19878i;

    /* renamed from: j  reason: collision with root package name */
    public static final a f19879j;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.m0.i.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r0.m0.k.b f19880b;

    /* renamed from: c  reason: collision with root package name */
    public final CacheManager f19881c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.m0.a f19882d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.r0.m0.f.d.e.d f19883e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.r0.m0.e.a> f19884f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.m0.j.b f19885g;

    /* renamed from: c.a.r0.m0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class HandlerC1183a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1183a(a this$0, Looper looper) {
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

    /* loaded from: classes6.dex */
    public static final class b implements c.a.r0.m0.i.a {
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

        @Override // c.a.r0.m0.i.a
        public g a(c.a.r0.m0.e.a item, c.a.r0.m0.j.b displayer, c.a.r0.m0.a config) {
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

        @Override // c.a.r0.m0.i.a
        public void b(c.a.r0.m0.e.a item, Canvas canvas, c.a.r0.m0.j.b displayer, c.a.r0.m0.a config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
            }
        }
    }

    /* loaded from: classes6.dex */
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f19879j : (a) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements c.a.r0.m0.j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f19886b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19887c;

        /* renamed from: d  reason: collision with root package name */
        public final float f19888d;

        /* renamed from: e  reason: collision with root package name */
        public final float f19889e;

        /* renamed from: f  reason: collision with root package name */
        public final int f19890f;

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
            this.f19887c = 4;
            this.f19889e = 1.0f;
            this.f19890f = 200;
        }

        @Override // c.a.r0.m0.j.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19890f : invokeV.intValue;
        }

        @Override // c.a.r0.m0.j.b
        public float b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19889e : invokeV.floatValue;
        }

        @Override // c.a.r0.m0.j.b
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19887c : invokeV.intValue;
        }

        @Override // c.a.r0.m0.j.b
        public float d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.a(this) : invokeV.floatValue;
        }

        @Override // c.a.r0.m0.j.b
        public float e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19888d : invokeV.floatValue;
        }

        @Override // c.a.r0.m0.j.b
        public int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.intValue;
        }

        @Override // c.a.r0.m0.j.b
        public int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19886b : invokeV.intValue;
        }

        @Override // c.a.r0.m0.j.b
        public void setHeight(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.a = i2;
            }
        }

        @Override // c.a.r0.m0.j.b
        public void setWidth(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f19886b = i2;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1831280572, "Lc/a/r0/m0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1831280572, "Lc/a/r0/m0/f/a;");
                return;
            }
        }
        f19877h = new c(null);
        b bVar = new b();
        f19878i = bVar;
        f19879j = new a(bVar);
    }

    public a(c.a.r0.m0.i.a renderer) {
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
        this.f19880b = new c.a.r0.m0.k.b();
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        Intrinsics.checkNotNullExpressionValue(myLooper, "myLooper()!!");
        this.f19881c = new CacheManager(new HandlerC1183a(this, myLooper), this.a);
        this.f19882d = new c.a.r0.m0.a(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        this.f19883e = new c.a.r0.m0.f.d.e.d();
        new c.a.r0.m0.d.a();
        this.f19884f = new ArrayList();
        new c.a.r0.m0.d.a();
        this.f19885g = new d();
        this.f19884f.iterator();
        new ArrayList();
        new ArrayList();
    }

    public final CacheManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19881c : (CacheManager) invokeV.objValue;
    }

    public final c.a.r0.m0.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19882d : (c.a.r0.m0.a) invokeV.objValue;
    }

    public final c.a.r0.m0.j.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19885g : (c.a.r0.m0.j.b) invokeV.objValue;
    }

    public final c.a.r0.m0.f.d.e.d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19883e : (c.a.r0.m0.f.d.e.d) invokeV.objValue;
    }

    public final c.a.r0.m0.k.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19880b : (c.a.r0.m0.k.b) invokeV.objValue;
    }

    public final void g(c.a.r0.m0.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.f19885g = bVar;
        }
    }

    public final void h(c.a.r0.m0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.f19882d = config;
            if (this.f19883e.b().size() != config.i().size()) {
                this.f19883e.d(CollectionsKt___CollectionsKt.toList(config.i()));
            }
            if (this.f19883e.c().size() != config.n().size()) {
                this.f19883e.e(CollectionsKt___CollectionsKt.toList(config.n()));
            }
        }
    }
}
