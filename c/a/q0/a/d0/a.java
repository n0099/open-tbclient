package c.a.q0.a.d0;

import c.a.q0.a.d0.g.g;
import c.a.q0.a.d0.g.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f11841b;

    /* renamed from: c  reason: collision with root package name */
    public String f11842c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11843d;

    /* renamed from: e  reason: collision with root package name */
    public String f11844e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, String> f11845f;

    /* renamed from: g  reason: collision with root package name */
    public final List<f> f11846g;

    public a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11845f = new LinkedHashMap();
        this.f11846g = new ArrayList();
        this.a = str;
        this.f11841b = str2;
        this.f11842c = str3;
        if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            d.a(str3);
            a();
            b();
            c();
            return;
        }
        this.f11843d = false;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f11846g.add(new c.a.q0.a.d0.g.f());
            this.f11846g.add(new c.a.q0.a.d0.g.d());
            this.f11846g.add(new c.a.q0.a.d0.g.b());
            this.f11846g.add(new g());
            this.f11846g.add(new c.a.q0.a.d0.g.e());
            this.f11846g.add(new h());
            this.f11846g.add(new c.a.q0.a.d0.g.c());
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f11845f.put("@d", BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            this.f11845f.put("@n", BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE);
            this.f11845f.put("@v", BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            this.f11845f.put("@rid", "reqid");
            this.f11845f.put("@sid", TiebaStatic.Params.WISE_SAMPLE_ID);
            this.f11845f.put("@c", TiebaStatic.Params.QD);
            this.f11845f.put("@p", "obj_source");
            this.f11845f.put("@eq", "eqid");
            this.f11845f.put("@1p", "obj_param1");
            this.f11845f.put("@2p", TiebaStatic.Params.OBJ_PARAM2);
            this.f11845f.put("@m", "obj_name");
            this.f11845f.put("@re", TiebaStatic.Params.REFER);
            this.f11845f.put("@lo", "obj_locate");
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || StringUtils.isNull(this.f11841b)) {
            return;
        }
        String valueOf = String.valueOf(this.f11841b.charAt(0));
        String[] split = this.f11841b.split("@");
        for (f fVar : this.f11846g) {
            if (valueOf.equals(fVar.b())) {
                String a = fVar.a(split, this.f11845f);
                this.f11844e = a;
                if (StringUtils.isNull(a)) {
                    return;
                }
                this.f11843d = true;
                return;
            }
        }
    }
}
