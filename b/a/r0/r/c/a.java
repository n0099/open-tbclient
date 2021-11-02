package b.a.r0.r.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.r0.z2.e;
import b.a.r0.z2.l0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class a implements AdAsyncRequestModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f22937a;

    /* renamed from: b  reason: collision with root package name */
    public String f22938b;

    /* renamed from: c  reason: collision with root package name */
    public int f22939c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22940d;

    /* renamed from: e  reason: collision with root package name */
    public AdAsyncRequestModel f22941e;

    /* renamed from: f  reason: collision with root package name */
    public long f22942f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<IAdBaseAsyncController.a> f22943g;

    public a(@NonNull PlaceId placeId, @NonNull String str, @Nullable IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {placeId, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22940d = false;
        this.f22942f = 0L;
        this.f22937a = placeId;
        this.f22938b = str;
        this.f22943g = new WeakReference<>(aVar);
        this.f22941e = new AdAsyncRequestModel(this, this.f22937a);
    }

    @Override // com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel.b
    public final void a(boolean z, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
            IAdBaseAsyncController.a aVar = this.f22943g.get();
            if (!z || b.a.r0.q1.o.k.a.e(list)) {
                if (aVar != null) {
                    aVar.b(null);
                    return;
                }
                return;
            }
            g(list);
            c(list);
            if (aVar != null) {
                aVar.b(list);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22941e.c();
        }
    }

    public void c(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
        }
    }

    public void d(int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, map) == null) || System.currentTimeMillis() - this.f22942f < this.f22939c * e.f27935c) {
            return;
        }
        this.f22941e.d(map, i2);
        this.f22942f = System.currentTimeMillis();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f22939c = i2;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f22940d = z;
        }
    }

    public void g(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.h4 = this.f22938b;
                if (b.a.r0.z2.a.n(next) && this.f22940d) {
                    it.remove();
                } else {
                    int U4 = next.U4();
                    if (U4 != 0) {
                        d.i(next, 0, U4);
                        it.remove();
                    }
                }
            }
        }
    }
}
