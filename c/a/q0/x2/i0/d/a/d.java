package c.a.q0.x2.i0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.q0.x2.z;
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
    public final TbPageContext<?> f28929a;

    /* renamed from: b  reason: collision with root package name */
    public final DragImageView.h f28930b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f28931c;

    /* renamed from: d  reason: collision with root package name */
    public Map<AdvertAppInfo, b> f28932d;

    /* loaded from: classes4.dex */
    public class a implements c.a.q0.o1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28933a;

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
            this.f28933a = bVar;
        }

        @Override // c.a.q0.o1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                AdvertAppInfo a2 = this.f28933a.a();
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
                    c.a.q0.x2.l0.d.f(a2, 0, str, i2);
                } else {
                    c.a.q0.x2.l0.d.n(a2, 0, null, null, str);
                }
                c.a.q0.o1.o.h.c.h(c.a.q0.o1.o.h.c.e(a2));
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
        this.f28929a = tbPageContext;
        this.f28931c = z;
        this.f28930b = hVar;
        this.f28932d = new HashMap();
    }

    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = new b(this.f28929a);
            bVar.b();
            bVar.setBusinessType(99);
            bVar.setFromCDN(this.f28931c);
            bVar.z(this.f28930b);
            bVar.setAfterClickSchemeListener(new a(this, bVar));
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo)) == null) {
            if (advertAppInfo == null || !(advertAppInfo.b4 instanceof AdCard)) {
                return null;
            }
            b bVar = this.f28932d.get(advertAppInfo);
            if (bVar == null) {
                bVar = a();
                this.f28932d.put(advertAppInfo, bVar);
            }
            bVar.c((AdCard) advertAppInfo.b4);
            return bVar.n();
        }
        return (View) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (b bVar : this.f28932d.values()) {
                if (bVar != null) {
                    bVar.w();
                }
            }
            this.f28932d.clear();
        }
    }

    public void d(AdvertAppInfo advertAppInfo) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, advertAppInfo) == null) || advertAppInfo == null || (bVar = this.f28932d.get(advertAppInfo)) == null) {
            return;
        }
        bVar.w();
        this.f28932d.remove(advertAppInfo);
    }
}
