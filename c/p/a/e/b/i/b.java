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
    public final int f35164a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35165b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f35166c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f35167d;

    /* renamed from: e  reason: collision with root package name */
    public a f35168e;

    /* renamed from: f  reason: collision with root package name */
    public a f35169f;

    /* renamed from: g  reason: collision with root package name */
    public a f35170g;

    /* renamed from: h  reason: collision with root package name */
    public a f35171h;

    /* renamed from: i  reason: collision with root package name */
    public a f35172i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f35173j;
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
        this.f35166c = new Object();
        this.f35167d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f35164a = i2;
        this.f35165b = i3;
    }

    @Override // c.p.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f35172i;
            if (aVar2 != null) {
                this.f35172i = aVar2.f35163d;
                aVar2.f35163d = null;
                return aVar2;
            }
            synchronized (this.f35167d) {
                aVar = this.f35170g;
                while (aVar == null) {
                    if (!this.f35173j) {
                        this.f35167d.wait();
                        aVar = this.f35170g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f35172i = aVar.f35163d;
                this.f35171h = null;
                this.f35170g = null;
                aVar.f35163d = null;
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
            synchronized (this.f35166c) {
                if (!this.f35173j) {
                    a aVar = this.f35168e;
                    if (aVar == null) {
                        if (this.k < this.f35164a) {
                            this.k++;
                            return new a(this.f35165b);
                        }
                        do {
                            this.f35166c.wait();
                            if (!this.f35173j) {
                                aVar = this.f35168e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f35168e = aVar.f35163d;
                    if (aVar == this.f35169f) {
                        this.f35169f = null;
                    }
                    aVar.f35163d = null;
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
            this.f35173j = true;
            synchronized (this.f35166c) {
                this.f35166c.notifyAll();
            }
            synchronized (this.f35167d) {
                this.f35167d.notifyAll();
            }
        }
    }

    @Override // c.p.a.e.b.i.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f35166c) {
                a aVar2 = this.f35169f;
                if (aVar2 == null) {
                    this.f35169f = aVar;
                    this.f35168e = aVar;
                } else {
                    aVar2.f35163d = aVar;
                    this.f35169f = aVar;
                }
                this.f35166c.notify();
            }
        }
    }

    @Override // c.p.a.e.b.i.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f35167d) {
                a aVar2 = this.f35171h;
                if (aVar2 == null) {
                    this.f35171h = aVar;
                    this.f35170g = aVar;
                    this.f35167d.notify();
                } else {
                    aVar2.f35163d = aVar;
                    this.f35171h = aVar;
                }
            }
        }
    }
}
