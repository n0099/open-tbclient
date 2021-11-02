package b.a.p0.n.i.k;

import android.text.TextUtils;
import b.a.p0.n.f.g;
import b.a.p0.n.h.f;
import b.a.p0.n.i.l.a;
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
/* loaded from: classes4.dex */
public class a extends b.a.p0.n.i.d<b.a.p0.n.i.l.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g gVar, b.a.p0.n.i.m.g gVar2) {
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
                super((g) objArr2[0], (b.a.p0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.i.d
    /* renamed from: o */
    public boolean e(b.a.p0.n.i.l.a aVar) {
        InterceptResult invokeL;
        List<a.C0618a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar == null || (list = aVar.f11144a) == null || list.isEmpty()) {
                return false;
            }
            for (a.C0618a c0618a : aVar.f11144a) {
                if (TextUtils.isEmpty(c0618a.f11146b)) {
                    return false;
                }
                if (c0618a.f11145a == 0) {
                    if (c0618a.f11148d == null && c0618a.f11150f == null && c0618a.f11149e == null) {
                        return false;
                    }
                    f fVar = c0618a.f11148d;
                    if (fVar != null && !fVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = c0618a.f11150f;
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
    @Override // b.a.p0.n.i.d
    /* renamed from: p */
    public b.a.p0.n.h.a m(b.a.p0.n.i.l.a aVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            this.f11092e.D();
            b.a.p0.n.o.f fVar = new b.a.p0.n.o.f();
            Map<String, PMSAppInfo> t = b.a.p0.n.g.a.h().t();
            ArrayList arrayList = new ArrayList();
            for (a.C0618a c0618a : aVar.f11144a) {
                if (c0618a != null) {
                    int i2 = c0618a.f11145a;
                    if (i2 != 0) {
                        this.f11092e.u().o(c0618a, t.get(c0618a.f11146b), new b.a.p0.n.h.a(i2, c0618a.f11146b + "，Server返回错误"));
                    } else {
                        List<b.a.p0.n.h.g> list = c0618a.f11149e;
                        if (list != null) {
                            for (b.a.p0.n.h.g gVar : list) {
                                if (gVar != null) {
                                    gVar.o = c0618a.f11146b;
                                }
                            }
                            j(c0618a.f11149e, fVar);
                            arrayList.addAll(c0618a.f11149e);
                        }
                        if (c0618a.f11148d != null && (pMSAppInfo2 = c0618a.f11150f) != null) {
                            pMSAppInfo2.appId = c0618a.f11146b;
                            this.f11092e.u().l(c0618a.f11150f);
                            i(c0618a.f11148d, fVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = t.get(c0618a.f11146b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = c0618a.f11150f;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = c0618a.f11146b;
                                    List<b.a.p0.n.h.g> list2 = c0618a.f11149e;
                                    if (list2 != null && !list2.isEmpty()) {
                                        c0618a.f11150f.copySubPkgInfo(c0618a.f11149e.get(0));
                                    }
                                    this.f11092e.u().p(c0618a.f11150f, null);
                                } else {
                                    int i3 = c0618a.f11145a;
                                    this.f11092e.u().o(c0618a, null, new b.a.p0.n.h.a(i3, c0618a.f11146b + "，本地记录不存在"));
                                }
                            } else if (c0618a.f11148d == null && (pMSAppInfo = c0618a.f11150f) != null) {
                                pMSAppInfo.appId = c0618a.f11146b;
                                this.f11092e.u().p(c0618a.f11150f, pMSAppInfo3);
                            } else {
                                f fVar2 = c0618a.f11148d;
                                if (fVar2 != null && c0618a.f11150f == null) {
                                    c0618a.f11151g = true;
                                    c0618a.f11150f = pMSAppInfo3;
                                    i(fVar2, fVar);
                                }
                            }
                        }
                    }
                }
            }
            if (fVar.l() == 0) {
                this.f11092e.E();
            } else {
                this.f11092e.F(fVar);
                b.a.p0.n.i.i.a.a(aVar, arrayList, this.f11092e);
            }
            return null;
        }
        return (b.a.p0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.i.d
    /* renamed from: q */
    public b.a.p0.n.i.l.a n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? b.a.p0.n.o.e.e(jSONObject) : (b.a.p0.n.i.l.a) invokeL.objValue;
    }
}
