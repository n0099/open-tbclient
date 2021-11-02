package b.a.r0.z2.i0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import b.a.r0.z2.z;
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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f28154a;

    /* renamed from: b  reason: collision with root package name */
    public final DragImageView.h f28155b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f28156c;

    /* renamed from: d  reason: collision with root package name */
    public Map<AdvertAppInfo, b> f28157d;

    /* renamed from: e  reason: collision with root package name */
    public b f28158e;

    /* loaded from: classes6.dex */
    public class a implements b.a.r0.q1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28159a;

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
            this.f28159a = bVar;
        }

        @Override // b.a.r0.q1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                AdvertAppInfo a2 = this.f28159a.a();
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
                    b.a.r0.z2.l0.d.g(a2, 0, str, i2);
                } else {
                    b.a.r0.z2.l0.d.o(a2, 0, null, null, str);
                }
                b.a.r0.q1.o.h.c.h(b.a.r0.q1.o.h.c.e(a2));
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
        this.f28154a = tbPageContext;
        this.f28156c = z;
        this.f28155b = hVar;
        this.f28157d = new HashMap();
    }

    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = new b(this.f28154a);
            bVar.b();
            bVar.setBusinessType(99);
            bVar.setFromCDN(this.f28156c);
            bVar.D(this.f28155b);
            bVar.setAfterClickSchemeListener(new a(this, bVar));
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{advertAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (advertAppInfo == null || !(advertAppInfo.f4 instanceof AdCard)) {
                return null;
            }
            b bVar = this.f28157d.get(advertAppInfo);
            if (bVar == null) {
                bVar = a();
                this.f28157d.put(advertAppInfo, bVar);
            }
            bVar.c((AdCard) advertAppInfo.f4);
            this.f28158e = bVar;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f28158e) == null) {
            return;
        }
        bVar.u();
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f28158e) == null) {
            return;
        }
        bVar.z();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (b bVar : this.f28157d.values()) {
                if (bVar != null) {
                    bVar.A();
                }
            }
            this.f28157d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) || advertAppInfo == null || (bVar = this.f28157d.get(advertAppInfo)) == null) {
            return;
        }
        bVar.A();
        this.f28157d.remove(advertAppInfo);
    }
}
