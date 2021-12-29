package c.a.t0.v.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.t0.j3.e;
import c.a.t0.j3.l0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class a implements AdAsyncRequestModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PlaceId a;

    /* renamed from: b  reason: collision with root package name */
    public String f25159b;

    /* renamed from: c  reason: collision with root package name */
    public int f25160c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25161d;

    /* renamed from: e  reason: collision with root package name */
    public AdAsyncRequestModel f25162e;

    /* renamed from: f  reason: collision with root package name */
    public long f25163f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<IAdBaseAsyncController.a> f25164g;

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
        this.f25161d = false;
        this.f25163f = 0L;
        this.a = placeId;
        this.f25159b = str;
        this.f25164g = new WeakReference<>(aVar);
        this.f25162e = new AdAsyncRequestModel(this, this.a);
    }

    @Override // com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel.b
    public final void a(boolean z, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
            IAdBaseAsyncController.a aVar = this.f25164g.get();
            if (!z || c.a.t0.x1.o.k.a.e(list)) {
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
            this.f25162e.c();
        }
    }

    public void c(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
        }
    }

    public void d(int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, map) == null) || System.currentTimeMillis() - this.f25163f < this.f25160c * e.f18739c) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (c.a.t0.a.h().y()) {
            map.put(AdExtParam.KEY_NAD_CORE_VERSION, "4.2.1.3");
        }
        this.f25162e.d(map, i2);
        this.f25163f = System.currentTimeMillis();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f25160c = i2;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f25161d = z;
        }
    }

    public void g(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.p4 = this.f25159b;
                if (c.a.t0.j3.a.n(next) && this.f25161d) {
                    it.remove();
                } else {
                    int Y4 = next.Y4();
                    if (Y4 != 0) {
                        d.i(next, 0, Y4);
                        it.remove();
                    }
                }
            }
        }
    }
}
