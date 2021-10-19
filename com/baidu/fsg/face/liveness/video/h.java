package com.baidu.fsg.face.liveness.video;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public abstract class h implements c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final int f40349f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static final int f40350g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f40351h = 1048576;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f40352i;

    /* renamed from: j  reason: collision with root package name */
    public b f40353j;
    public volatile boolean k;
    public ExecutorService l;
    public long m;
    public long n;
    public VideoInfo o;
    public volatile boolean p;
    public int q;
    public int r;
    public int s;

    public h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = Executors.newSingleThreadExecutor();
        this.o = new VideoInfo();
        this.p = false;
        this.q = 24;
        this.r = 1;
        this.s = 1048576;
        this.f40353j = bVar;
    }

    public abstract boolean a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    @Override // com.baidu.fsg.face.liveness.video.c
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f40352i && !this.p) {
            b();
            d();
        }
    }

    public void h() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bVar = this.f40353j) == null) {
            return;
        }
        bVar.a(this);
    }

    public void i() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bVar = this.f40353j) == null) {
            return;
        }
        bVar.b(this);
    }
}
