package b.a.r0.r.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.r0.a3.e;
import b.a.r0.a3.l0.d;
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
    public PlaceId f24469a;

    /* renamed from: b  reason: collision with root package name */
    public String f24470b;

    /* renamed from: c  reason: collision with root package name */
    public int f24471c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24472d;

    /* renamed from: e  reason: collision with root package name */
    public AdAsyncRequestModel f24473e;

    /* renamed from: f  reason: collision with root package name */
    public long f24474f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<IAdBaseAsyncController.a> f24475g;

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
        this.f24472d = false;
        this.f24474f = 0L;
        this.f24469a = placeId;
        this.f24470b = str;
        this.f24475g = new WeakReference<>(aVar);
        this.f24473e = new AdAsyncRequestModel(this, this.f24469a);
    }

    @Override // com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel.b
    public final void a(boolean z, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
            IAdBaseAsyncController.a aVar = this.f24475g.get();
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
            this.f24473e.c();
        }
    }

    public void c(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
        }
    }

    public void d(int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, map) == null) || System.currentTimeMillis() - this.f24474f < this.f24471c * e.f15570c) {
            return;
        }
        this.f24473e.d(map, i2);
        this.f24474f = System.currentTimeMillis();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f24471c = i2;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f24472d = z;
        }
    }

    public void g(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.i4 = this.f24470b;
                if (b.a.r0.a3.a.n(next) && this.f24472d) {
                    it.remove();
                } else {
                    int W4 = next.W4();
                    if (W4 != 0) {
                        d.i(next, 0, W4);
                        it.remove();
                    }
                }
            }
        }
    }
}
