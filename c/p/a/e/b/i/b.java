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
    public final int f35055a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35056b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f35057c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f35058d;

    /* renamed from: e  reason: collision with root package name */
    public a f35059e;

    /* renamed from: f  reason: collision with root package name */
    public a f35060f;

    /* renamed from: g  reason: collision with root package name */
    public a f35061g;

    /* renamed from: h  reason: collision with root package name */
    public a f35062h;

    /* renamed from: i  reason: collision with root package name */
    public a f35063i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f35064j;
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
        this.f35057c = new Object();
        this.f35058d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f35055a = i2;
        this.f35056b = i3;
    }

    @Override // c.p.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f35063i;
            if (aVar2 != null) {
                this.f35063i = aVar2.f35054d;
                aVar2.f35054d = null;
                return aVar2;
            }
            synchronized (this.f35058d) {
                aVar = this.f35061g;
                while (aVar == null) {
                    if (!this.f35064j) {
                        this.f35058d.wait();
                        aVar = this.f35061g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f35063i = aVar.f35054d;
                this.f35062h = null;
                this.f35061g = null;
                aVar.f35054d = null;
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
            synchronized (this.f35057c) {
                if (!this.f35064j) {
                    a aVar = this.f35059e;
                    if (aVar == null) {
                        if (this.k < this.f35055a) {
                            this.k++;
                            return new a(this.f35056b);
                        }
                        do {
                            this.f35057c.wait();
                            if (!this.f35064j) {
                                aVar = this.f35059e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f35059e = aVar.f35054d;
                    if (aVar == this.f35060f) {
                        this.f35060f = null;
                    }
                    aVar.f35054d = null;
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
            this.f35064j = true;
            synchronized (this.f35057c) {
                this.f35057c.notifyAll();
            }
            synchronized (this.f35058d) {
                this.f35058d.notifyAll();
            }
        }
    }

    @Override // c.p.a.e.b.i.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f35057c) {
                a aVar2 = this.f35060f;
                if (aVar2 == null) {
                    this.f35060f = aVar;
                    this.f35059e = aVar;
                } else {
                    aVar2.f35054d = aVar;
                    this.f35060f = aVar;
                }
                this.f35057c.notify();
            }
        }
    }

    @Override // c.p.a.e.b.i.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f35058d) {
                a aVar2 = this.f35062h;
                if (aVar2 == null) {
                    this.f35062h = aVar;
                    this.f35061g = aVar;
                    this.f35058d.notify();
                } else {
                    aVar2.f35054d = aVar;
                    this.f35062h = aVar;
                }
            }
        }
    }
}
