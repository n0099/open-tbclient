package c.a.o0.a.e0;

import c.a.o0.a.e0.g.g;
import c.a.o0.a.e0.g.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
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
    public String f9655b;

    /* renamed from: c  reason: collision with root package name */
    public String f9656c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9657d;

    /* renamed from: e  reason: collision with root package name */
    public String f9658e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, String> f9659f;

    /* renamed from: g  reason: collision with root package name */
    public final List<f> f9660g;

    public a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9659f = new LinkedHashMap();
        this.f9660g = new ArrayList();
        this.a = str;
        this.f9655b = str2;
        this.f9656c = str3;
        if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            a();
            b();
            c();
            return;
        }
        this.f9657d = false;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9660g.add(new c.a.o0.a.e0.g.f());
            this.f9660g.add(new c.a.o0.a.e0.g.d());
            this.f9660g.add(new c.a.o0.a.e0.g.b());
            this.f9660g.add(new g());
            this.f9660g.add(new c.a.o0.a.e0.g.e());
            this.f9660g.add(new h());
            this.f9660g.add(new c.a.o0.a.e0.g.c());
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f9659f.put("@d", BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            this.f9659f.put("@n", BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE);
            this.f9659f.put("@v", BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            this.f9659f.put("@rid", HttpClientWrap.f27909f);
            this.f9659f.put("@sid", TiebaStatic.Params.WISE_SAMPLE_ID);
            this.f9659f.put("@c", TiebaStatic.Params.QD);
            this.f9659f.put("@p", "obj_source");
            this.f9659f.put("@eq", TiebaStatic.Params.EQID);
            this.f9659f.put("@1p", "obj_param1");
            this.f9659f.put("@2p", TiebaStatic.Params.OBJ_PARAM2);
            this.f9659f.put("@m", "obj_name");
            this.f9659f.put("@re", TiebaStatic.Params.REFER);
            this.f9659f.put("@lo", "obj_locate");
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || StringUtils.isNull(this.f9655b)) {
            return;
        }
        String valueOf = String.valueOf(this.f9655b.charAt(0));
        String[] split = this.f9655b.split("@");
        for (f fVar : this.f9660g) {
            if (valueOf.equals(fVar.b())) {
                String a = fVar.a(split, this.f9659f);
                this.f9658e = a;
                if (StringUtils.isNull(a)) {
                    return;
                }
                this.f9657d = true;
                return;
            }
        }
    }
}
