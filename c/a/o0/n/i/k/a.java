package c.a.o0.n.i.k;

import android.text.TextUtils;
import c.a.o0.n.f.g;
import c.a.o0.n.h.f;
import c.a.o0.n.i.l.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c.a.o0.n.i.d<c.a.o0.n.i.l.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g gVar, c.a.o0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, gVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((g) objArr2[0], (c.a.o0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.n.i.d
    /* renamed from: o */
    public boolean e(c.a.o0.n.i.l.a aVar) {
        InterceptResult invokeL;
        List<a.C0621a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar == null || (list = aVar.f11927a) == null || list.isEmpty()) {
                return false;
            }
            for (a.C0621a c0621a : aVar.f11927a) {
                if (TextUtils.isEmpty(c0621a.f11929b)) {
                    return false;
                }
                if (c0621a.f11928a == 0) {
                    if (c0621a.f11931d == null && c0621a.f11933f == null && c0621a.f11932e == null) {
                        return false;
                    }
                    f fVar = c0621a.f11931d;
                    if (fVar != null && !fVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = c0621a.f11933f;
                    if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.n.i.d
    /* renamed from: p */
    public c.a.o0.n.h.a m(c.a.o0.n.i.l.a aVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            this.f11874e.D();
            c.a.o0.n.o.f fVar = new c.a.o0.n.o.f();
            Map<String, PMSAppInfo> t = c.a.o0.n.g.a.h().t();
            ArrayList arrayList = new ArrayList();
            for (a.C0621a c0621a : aVar.f11927a) {
                if (c0621a != null) {
                    int i2 = c0621a.f11928a;
                    if (i2 != 0) {
                        this.f11874e.u().o(c0621a, t.get(c0621a.f11929b), new c.a.o0.n.h.a(i2, c0621a.f11929b + "，Server返回错误"));
                    } else {
                        List<c.a.o0.n.h.g> list = c0621a.f11932e;
                        if (list != null) {
                            for (c.a.o0.n.h.g gVar : list) {
                                if (gVar != null) {
                                    gVar.o = c0621a.f11929b;
                                }
                            }
                            j(c0621a.f11932e, fVar);
                            arrayList.addAll(c0621a.f11932e);
                        }
                        if (c0621a.f11931d != null && (pMSAppInfo2 = c0621a.f11933f) != null) {
                            pMSAppInfo2.appId = c0621a.f11929b;
                            this.f11874e.u().l(c0621a.f11933f);
                            i(c0621a.f11931d, fVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = t.get(c0621a.f11929b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = c0621a.f11933f;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = c0621a.f11929b;
                                    List<c.a.o0.n.h.g> list2 = c0621a.f11932e;
                                    if (list2 != null && !list2.isEmpty()) {
                                        c0621a.f11933f.copySubPkgInfo(c0621a.f11932e.get(0));
                                    }
                                    this.f11874e.u().p(c0621a.f11933f, null);
                                } else {
                                    int i3 = c0621a.f11928a;
                                    this.f11874e.u().o(c0621a, null, new c.a.o0.n.h.a(i3, c0621a.f11929b + "，本地记录不存在"));
                                }
                            } else if (c0621a.f11931d == null && (pMSAppInfo = c0621a.f11933f) != null) {
                                pMSAppInfo.appId = c0621a.f11929b;
                                this.f11874e.u().p(c0621a.f11933f, pMSAppInfo3);
                            } else {
                                f fVar2 = c0621a.f11931d;
                                if (fVar2 != null && c0621a.f11933f == null) {
                                    c0621a.f11934g = true;
                                    c0621a.f11933f = pMSAppInfo3;
                                    i(fVar2, fVar);
                                }
                            }
                        }
                    }
                }
            }
            if (fVar.l() == 0) {
                this.f11874e.E();
            } else {
                this.f11874e.F(fVar);
                c.a.o0.n.i.i.a.a(aVar, arrayList, this.f11874e);
            }
            return null;
        }
        return (c.a.o0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.n.i.d
    /* renamed from: q */
    public c.a.o0.n.i.l.a n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.o0.n.o.e.e(jSONObject) : (c.a.o0.n.i.l.a) invokeL.objValue;
    }
}
