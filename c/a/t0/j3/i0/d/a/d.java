package c.a.t0.j3.i0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.t0.j3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final DragImageView.h f18915b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f18916c;

    /* renamed from: d  reason: collision with root package name */
    public Map<AdvertAppInfo, b> f18917d;

    /* renamed from: e  reason: collision with root package name */
    public b f18918e;

    /* loaded from: classes7.dex */
    public class a implements c.a.t0.x1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(d dVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.t0.x1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                AdvertAppInfo a = this.a.a();
                if (i2 == 0 || a == null) {
                    return;
                }
                String str = "image";
                if (hashMap != null) {
                    String str2 = (String) hashMap.get("da_area");
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                }
                if (z.q(i2)) {
                    c.a.t0.j3.l0.d.g(a, 0, str, i2);
                } else {
                    c.a.t0.j3.l0.d.o(a, 0, null, null, str);
                }
                c.a.t0.x1.o.h.c.h(c.a.t0.x1.o.h.c.e(a));
            }
        }
    }

    public d(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f18916c = z;
        this.f18915b = hVar;
        this.f18917d = new HashMap();
    }

    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = new b(this.a);
            bVar.b();
            bVar.setBusinessType(99);
            bVar.setFromCDN(this.f18916c);
            bVar.D(this.f18915b);
            bVar.setAfterClickSchemeListener(new a(this, bVar));
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{advertAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (advertAppInfo == null || !(advertAppInfo.n4 instanceof AdCard)) {
                return null;
            }
            b bVar = this.f18917d.get(advertAppInfo);
            if (bVar == null) {
                bVar = a();
                this.f18917d.put(advertAppInfo, bVar);
            }
            bVar.c((AdCard) advertAppInfo.n4);
            this.f18918e = bVar;
            if (z2) {
                bVar.u();
            }
            return bVar.o();
        }
        return (View) invokeCommon.objValue;
    }

    public void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f18918e) == null) {
            return;
        }
        bVar.u();
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f18918e) == null) {
            return;
        }
        bVar.z();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (b bVar : this.f18917d.values()) {
                if (bVar != null) {
                    bVar.A();
                }
            }
            this.f18917d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) || advertAppInfo == null || (bVar = this.f18917d.get(advertAppInfo)) == null) {
            return;
        }
        bVar.A();
        this.f18917d.remove(advertAppInfo);
    }
}
