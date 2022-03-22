package c.a.p0.l3.l0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.l3.e;
import c.a.p0.l3.m0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends c.a.p0.x.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.x.e.b f16280h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull PlaceId placeId, @NonNull String str, @Nullable IAdBaseAsyncController.a aVar) {
        super(placeId, str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {placeId, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((PlaceId) objArr2[0], (String) objArr2[1], (IAdBaseAsyncController.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16280h = c.a.p0.x.e.b.d();
    }

    @Override // c.a.p0.x.e.a
    public void c(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f16280h.a(this.a, list);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (e.e(System.currentTimeMillis(), this.f16280h.e(this.a), i)) {
                List<AdvertAppInfo> b2 = this.f16280h.b(this.a);
                if (c.a.p0.b2.o.k.a.e(b2)) {
                    return;
                }
                for (AdvertAppInfo advertAppInfo : b2) {
                    d.i(advertAppInfo, 0, 44);
                }
            }
        }
    }

    @Nullable
    public AdvertAppInfo i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16280h.c(this.a) : (AdvertAppInfo) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16280h.f(this.a) : invokeV.booleanValue;
    }
}
