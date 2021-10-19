package c.p.a.e.b.i;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes4.dex */
public class b implements c, d, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f35191a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35192b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f35193c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f35194d;

    /* renamed from: e  reason: collision with root package name */
    public a f35195e;

    /* renamed from: f  reason: collision with root package name */
    public a f35196f;

    /* renamed from: g  reason: collision with root package name */
    public a f35197g;

    /* renamed from: h  reason: collision with root package name */
    public a f35198h;

    /* renamed from: i  reason: collision with root package name */
    public a f35199i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f35200j;
    public int k;

    public b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35193c = new Object();
        this.f35194d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f35191a = i2;
        this.f35192b = i3;
    }

    @Override // c.p.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f35199i;
            if (aVar2 != null) {
                this.f35199i = aVar2.f35190d;
                aVar2.f35190d = null;
                return aVar2;
            }
            synchronized (this.f35194d) {
                aVar = this.f35197g;
                while (aVar == null) {
                    if (!this.f35200j) {
                        this.f35194d.wait();
                        aVar = this.f35197g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f35199i = aVar.f35190d;
                this.f35198h = null;
                this.f35197g = null;
                aVar.f35190d = null;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.p.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f35193c) {
                if (!this.f35200j) {
                    a aVar = this.f35195e;
                    if (aVar == null) {
                        if (this.k < this.f35191a) {
                            this.k++;
                            return new a(this.f35192b);
                        }
                        do {
                            this.f35193c.wait();
                            if (!this.f35200j) {
                                aVar = this.f35195e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f35195e = aVar.f35190d;
                    if (aVar == this.f35196f) {
                        this.f35196f = null;
                    }
                    aVar.f35190d = null;
                    return aVar;
                }
                throw new p("obtain");
            }
        }
        return (a) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f35200j = true;
            synchronized (this.f35193c) {
                this.f35193c.notifyAll();
            }
            synchronized (this.f35194d) {
                this.f35194d.notifyAll();
            }
        }
    }

    @Override // c.p.a.e.b.i.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f35193c) {
                a aVar2 = this.f35196f;
                if (aVar2 == null) {
                    this.f35196f = aVar;
                    this.f35195e = aVar;
                } else {
                    aVar2.f35190d = aVar;
                    this.f35196f = aVar;
                }
                this.f35193c.notify();
            }
        }
    }

    @Override // c.p.a.e.b.i.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f35194d) {
                a aVar2 = this.f35198h;
                if (aVar2 == null) {
                    this.f35198h = aVar;
                    this.f35197g = aVar;
                    this.f35194d.notify();
                } else {
                    aVar2.f35190d = aVar;
                    this.f35198h = aVar;
                }
            }
        }
    }
}
