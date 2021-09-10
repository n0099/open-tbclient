package c.a.p0.n.i.k;

import android.text.TextUtils;
import c.a.p0.n.f.g;
import c.a.p0.n.h.f;
import c.a.p0.n.i.l.a;
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
public class a extends c.a.p0.n.i.d<c.a.p0.n.i.l.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g gVar, c.a.p0.n.i.m.g gVar2) {
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
                super((g) objArr2[0], (c.a.p0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.n.i.d
    /* renamed from: o */
    public boolean e(c.a.p0.n.i.l.a aVar) {
        InterceptResult invokeL;
        List<a.C0623a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar == null || (list = aVar.f11955a) == null || list.isEmpty()) {
                return false;
            }
            for (a.C0623a c0623a : aVar.f11955a) {
                if (TextUtils.isEmpty(c0623a.f11957b)) {
                    return false;
                }
                if (c0623a.f11956a == 0) {
                    if (c0623a.f11959d == null && c0623a.f11961f == null && c0623a.f11960e == null) {
                        return false;
                    }
                    f fVar = c0623a.f11959d;
                    if (fVar != null && !fVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = c0623a.f11961f;
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
    @Override // c.a.p0.n.i.d
    /* renamed from: p */
    public c.a.p0.n.h.a m(c.a.p0.n.i.l.a aVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            this.f11902e.D();
            c.a.p0.n.o.f fVar = new c.a.p0.n.o.f();
            Map<String, PMSAppInfo> t = c.a.p0.n.g.a.h().t();
            ArrayList arrayList = new ArrayList();
            for (a.C0623a c0623a : aVar.f11955a) {
                if (c0623a != null) {
                    int i2 = c0623a.f11956a;
                    if (i2 != 0) {
                        this.f11902e.u().o(c0623a, t.get(c0623a.f11957b), new c.a.p0.n.h.a(i2, c0623a.f11957b + "，Server返回错误"));
                    } else {
                        List<c.a.p0.n.h.g> list = c0623a.f11960e;
                        if (list != null) {
                            for (c.a.p0.n.h.g gVar : list) {
                                if (gVar != null) {
                                    gVar.o = c0623a.f11957b;
                                }
                            }
                            j(c0623a.f11960e, fVar);
                            arrayList.addAll(c0623a.f11960e);
                        }
                        if (c0623a.f11959d != null && (pMSAppInfo2 = c0623a.f11961f) != null) {
                            pMSAppInfo2.appId = c0623a.f11957b;
                            this.f11902e.u().l(c0623a.f11961f);
                            i(c0623a.f11959d, fVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = t.get(c0623a.f11957b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = c0623a.f11961f;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = c0623a.f11957b;
                                    List<c.a.p0.n.h.g> list2 = c0623a.f11960e;
                                    if (list2 != null && !list2.isEmpty()) {
                                        c0623a.f11961f.copySubPkgInfo(c0623a.f11960e.get(0));
                                    }
                                    this.f11902e.u().p(c0623a.f11961f, null);
                                } else {
                                    int i3 = c0623a.f11956a;
                                    this.f11902e.u().o(c0623a, null, new c.a.p0.n.h.a(i3, c0623a.f11957b + "，本地记录不存在"));
                                }
                            } else if (c0623a.f11959d == null && (pMSAppInfo = c0623a.f11961f) != null) {
                                pMSAppInfo.appId = c0623a.f11957b;
                                this.f11902e.u().p(c0623a.f11961f, pMSAppInfo3);
                            } else {
                                f fVar2 = c0623a.f11959d;
                                if (fVar2 != null && c0623a.f11961f == null) {
                                    c0623a.f11962g = true;
                                    c0623a.f11961f = pMSAppInfo3;
                                    i(fVar2, fVar);
                                }
                            }
                        }
                    }
                }
            }
            if (fVar.l() == 0) {
                this.f11902e.E();
            } else {
                this.f11902e.F(fVar);
                c.a.p0.n.i.i.a.a(aVar, arrayList, this.f11902e);
            }
            return null;
        }
        return (c.a.p0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.n.i.d
    /* renamed from: q */
    public c.a.p0.n.i.l.a n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.p0.n.o.e.e(jSONObject) : (c.a.p0.n.i.l.a) invokeL.objValue;
    }
}
