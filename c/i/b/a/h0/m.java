package c.i.b.a.h0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes4.dex */
public final class m extends HttpDataSource.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f33644b;

    /* renamed from: c  reason: collision with root package name */
    public final p<? super e> f33645c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33646d;

    /* renamed from: e  reason: collision with root package name */
    public final int f33647e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33648f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(String str, p<? super e> pVar) {
        this(str, pVar, 8000, 8000, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (p) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* renamed from: d */
    public l c(HttpDataSource.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? new l(this.f33644b, null, this.f33645c, this.f33646d, this.f33647e, this.f33648f, bVar) : (l) invokeL.objValue;
    }

    public m(String str, p<? super e> pVar, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, pVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33644b = str;
        this.f33645c = pVar;
        this.f33646d = i2;
        this.f33647e = i3;
        this.f33648f = z;
    }
}
