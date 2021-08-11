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
    public final int f34949a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34950b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f34951c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f34952d;

    /* renamed from: e  reason: collision with root package name */
    public a f34953e;

    /* renamed from: f  reason: collision with root package name */
    public a f34954f;

    /* renamed from: g  reason: collision with root package name */
    public a f34955g;

    /* renamed from: h  reason: collision with root package name */
    public a f34956h;

    /* renamed from: i  reason: collision with root package name */
    public a f34957i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f34958j;
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
        this.f34951c = new Object();
        this.f34952d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f34949a = i2;
        this.f34950b = i3;
    }

    @Override // c.p.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f34957i;
            if (aVar2 != null) {
                this.f34957i = aVar2.f34948d;
                aVar2.f34948d = null;
                return aVar2;
            }
            synchronized (this.f34952d) {
                aVar = this.f34955g;
                while (aVar == null) {
                    if (!this.f34958j) {
                        this.f34952d.wait();
                        aVar = this.f34955g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f34957i = aVar.f34948d;
                this.f34956h = null;
                this.f34955g = null;
                aVar.f34948d = null;
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
            synchronized (this.f34951c) {
                if (!this.f34958j) {
                    a aVar = this.f34953e;
                    if (aVar == null) {
                        if (this.k < this.f34949a) {
                            this.k++;
                            return new a(this.f34950b);
                        }
                        do {
                            this.f34951c.wait();
                            if (!this.f34958j) {
                                aVar = this.f34953e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f34953e = aVar.f34948d;
                    if (aVar == this.f34954f) {
                        this.f34954f = null;
                    }
                    aVar.f34948d = null;
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
            this.f34958j = true;
            synchronized (this.f34951c) {
                this.f34951c.notifyAll();
            }
            synchronized (this.f34952d) {
                this.f34952d.notifyAll();
            }
        }
    }

    @Override // c.p.a.e.b.i.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f34951c) {
                a aVar2 = this.f34954f;
                if (aVar2 == null) {
                    this.f34954f = aVar;
                    this.f34953e = aVar;
                } else {
                    aVar2.f34948d = aVar;
                    this.f34954f = aVar;
                }
                this.f34951c.notify();
            }
        }
    }

    @Override // c.p.a.e.b.i.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f34952d) {
                a aVar2 = this.f34956h;
                if (aVar2 == null) {
                    this.f34956h = aVar;
                    this.f34955g = aVar;
                    this.f34952d.notify();
                } else {
                    aVar2.f34948d = aVar;
                    this.f34956h = aVar;
                }
            }
        }
    }
}
