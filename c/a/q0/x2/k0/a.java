package c.a.q0.x2.k0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.q0.x2.e;
import c.a.q0.x2.l0.d;
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
/* loaded from: classes4.dex */
public class a extends c.a.q0.q.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.q.b.b f28945h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull PlaceId placeId, @NonNull String str, @Nullable IAdBaseAsyncController.a aVar) {
        super(placeId, str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {placeId, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((PlaceId) objArr2[0], (String) objArr2[1], (IAdBaseAsyncController.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28945h = c.a.q0.q.b.b.d();
    }

    @Override // c.a.q0.q.b.a
    public void c(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f28945h.a(this.f23551a, list);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (e.e(System.currentTimeMillis(), this.f28945h.e(this.f23551a), i2)) {
                List<AdvertAppInfo> b2 = this.f28945h.b(this.f23551a);
                if (c.a.q0.o1.o.k.a.e(b2)) {
                    return;
                }
                for (AdvertAppInfo advertAppInfo : b2) {
                    d.h(advertAppInfo, 0, 44);
                }
            }
        }
    }

    @Nullable
    public AdvertAppInfo i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28945h.c(this.f23551a) : (AdvertAppInfo) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28945h.f(this.f23551a) : invokeV.booleanValue;
    }
}
