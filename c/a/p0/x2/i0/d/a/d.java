package c.a.p0.x2.i0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.p0.x2.z;
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
    public final TbPageContext<?> f28590a;

    /* renamed from: b  reason: collision with root package name */
    public final DragImageView.h f28591b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f28592c;

    /* renamed from: d  reason: collision with root package name */
    public Map<AdvertAppInfo, b> f28593d;

    /* loaded from: classes4.dex */
    public class a implements c.a.p0.o1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28594a;

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
            this.f28594a = bVar;
        }

        @Override // c.a.p0.o1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                AdvertAppInfo a2 = this.f28594a.a();
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
                    c.a.p0.x2.l0.d.f(a2, 0, str, i2);
                } else {
                    c.a.p0.x2.l0.d.n(a2, 0, null, null, str);
                }
                c.a.p0.o1.o.h.c.h(c.a.p0.o1.o.h.c.e(a2));
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
        this.f28590a = tbPageContext;
        this.f28592c = z;
        this.f28591b = hVar;
        this.f28593d = new HashMap();
    }

    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = new b(this.f28590a);
            bVar.b();
            bVar.setBusinessType(99);
            bVar.setFromCDN(this.f28592c);
            bVar.z(this.f28591b);
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
            b bVar = this.f28593d.get(advertAppInfo);
            if (bVar == null) {
                bVar = a();
                this.f28593d.put(advertAppInfo, bVar);
            }
            bVar.c((AdCard) advertAppInfo.b4);
            return bVar.n();
        }
        return (View) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (b bVar : this.f28593d.values()) {
                if (bVar != null) {
                    bVar.w();
                }
            }
            this.f28593d.clear();
        }
    }

    public void d(AdvertAppInfo advertAppInfo) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, advertAppInfo) == null) || advertAppInfo == null || (bVar = this.f28593d.get(advertAppInfo)) == null) {
            return;
        }
        bVar.w();
        this.f28593d.remove(advertAppInfo);
    }
}
