package c.i.b.a.h0;

import android.net.Uri;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class o<T> implements Loader.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30190b;

    /* renamed from: c  reason: collision with root package name */
    public final e f30191c;

    /* renamed from: d  reason: collision with root package name */
    public final a<? extends T> f30192d;

    /* renamed from: e  reason: collision with root package name */
    public volatile T f30193e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f30194f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f30195g;

    /* loaded from: classes7.dex */
    public interface a<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(e eVar, Uri uri, int i2, a<? extends T> aVar) {
        this(eVar, new g(uri, 1), i2, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, uri, Integer.valueOf(i2), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((e) objArr2[0], (g) objArr2[1], ((Integer) objArr2[2]).intValue(), (a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30194f : invokeV.booleanValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30195g : invokeV.longValue;
    }

    public final T c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30193e : (T) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f30194f = true;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f fVar = new f(this.f30191c, this.a);
            try {
                fVar.e();
                this.f30193e = this.f30192d.a(this.f30191c.getUri(), fVar);
            } finally {
                this.f30195g = fVar.a();
                v.i(fVar);
            }
        }
    }

    public o(e eVar, g gVar, int i2, a<? extends T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, gVar, Integer.valueOf(i2), aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30191c = eVar;
        this.a = gVar;
        this.f30190b = i2;
        this.f30192d = aVar;
    }
}
