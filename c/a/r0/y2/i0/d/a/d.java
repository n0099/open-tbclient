package c.a.r0.y2.i0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.r0.y2.z;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f29548a;

    /* renamed from: b  reason: collision with root package name */
    public final DragImageView.h f29549b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f29550c;

    /* renamed from: d  reason: collision with root package name */
    public Map<AdvertAppInfo, b> f29551d;

    /* renamed from: e  reason: collision with root package name */
    public b f29552e;

    /* loaded from: classes4.dex */
    public class a implements c.a.r0.p1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f29553a;

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
            this.f29553a = bVar;
        }

        @Override // c.a.r0.p1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                AdvertAppInfo a2 = this.f29553a.a();
                if (i2 == 0 || a2 == null) {
                    return;
                }
                String str = "image";
                if (hashMap != null) {
                    String str2 = (String) hashMap.get("da_area");
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                }
                if (z.p(i2)) {
                    c.a.r0.y2.l0.d.f(a2, 0, str, i2);
                } else {
                    c.a.r0.y2.l0.d.n(a2, 0, null, null, str);
                }
                c.a.r0.p1.o.h.c.h(c.a.r0.p1.o.h.c.e(a2));
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
        this.f29548a = tbPageContext;
        this.f29550c = z;
        this.f29549b = hVar;
        this.f29551d = new HashMap();
    }

    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = new b(this.f29548a);
            bVar.b();
            bVar.setBusinessType(99);
            bVar.setFromCDN(this.f29550c);
            bVar.D(this.f29549b);
            bVar.setAfterClickSchemeListener(new a(this, bVar));
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{advertAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (advertAppInfo == null || !(advertAppInfo.e4 instanceof AdCard)) {
                return null;
            }
            b bVar = this.f29551d.get(advertAppInfo);
            if (bVar == null) {
                bVar = a();
                this.f29551d.put(advertAppInfo, bVar);
            }
            bVar.c((AdCard) advertAppInfo.e4);
            this.f29552e = bVar;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f29552e) == null) {
            return;
        }
        bVar.u();
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f29552e) == null) {
            return;
        }
        bVar.z();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (b bVar : this.f29551d.values()) {
                if (bVar != null) {
                    bVar.A();
                }
            }
            this.f29551d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) || advertAppInfo == null || (bVar = this.f29551d.get(advertAppInfo)) == null) {
            return;
        }
        bVar.A();
        this.f29551d.remove(advertAppInfo);
    }
}
