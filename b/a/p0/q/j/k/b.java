package b.a.p0.q.j.k;

import android.text.TextUtils;
import b.a.p0.q.f.i;
import b.a.p0.q.i.g;
import b.a.p0.q.j.l.b;
import b.a.p0.q.j.m.h;
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
public class b extends b.a.p0.q.j.d<b.a.p0.q.j.l.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(i iVar, h hVar) {
        super(iVar, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (h) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.q.j.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: v */
    public boolean f(b.a.p0.q.j.l.b bVar) {
        InterceptResult invokeL;
        List<b.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null || (list = bVar.f11846a) == null || list.isEmpty()) {
                return false;
            }
            for (b.a aVar : bVar.f11846a) {
                if (TextUtils.isEmpty(aVar.f11848b)) {
                    return false;
                }
                if (aVar.f11847a == 0) {
                    if (aVar.f11850d == null && aVar.f11853g == null && aVar.f11851e == null) {
                        return false;
                    }
                    g gVar = aVar.f11850d;
                    if (gVar != null && !gVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = aVar.f11853g;
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
    @Override // b.a.p0.q.j.d
    /* renamed from: w */
    public b.a.p0.q.i.b t(b.a.p0.q.j.l.b bVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f11788e.E();
            b.a.p0.q.p.g gVar = new b.a.p0.q.p.g();
            Map<String, PMSAppInfo> v = b.a.p0.q.g.a.i().v();
            ArrayList arrayList = new ArrayList();
            List<b.a.p0.q.i.i> list = null;
            for (b.a aVar : bVar.f11846a) {
                if (aVar != null) {
                    int i2 = aVar.f11847a;
                    if (i2 != 0) {
                        this.f11788e.v().o(aVar, v.get(aVar.f11848b), new b.a.p0.q.i.b(i2, aVar.f11848b + "，Server返回错误"));
                    } else {
                        List<b.a.p0.q.i.h> list2 = aVar.f11851e;
                        if (list2 != null) {
                            for (b.a.p0.q.i.h hVar : list2) {
                                if (hVar != null) {
                                    hVar.o = aVar.f11848b;
                                }
                            }
                            p(aVar.f11851e, gVar);
                            arrayList.addAll(aVar.f11851e);
                        }
                        list = g(aVar.f11852f);
                        if (list != null) {
                            n(list, gVar);
                        }
                        if (aVar.f11850d != null && (pMSAppInfo2 = aVar.f11853g) != null) {
                            pMSAppInfo2.appId = aVar.f11848b;
                            this.f11788e.v().l(aVar.f11853g);
                            o(aVar.f11850d, gVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.f11848b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.f11853g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.f11848b;
                                    List<b.a.p0.q.i.h> list3 = aVar.f11851e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.f11853g.copySubPkgInfo(aVar.f11851e.get(0));
                                    }
                                    this.f11788e.v().p(aVar.f11853g, null);
                                } else {
                                    this.f11788e.v().o(aVar, null, new b.a.p0.q.i.b(aVar.f11847a, aVar.f11848b + "，本地记录不存在"));
                                }
                            } else if (aVar.f11850d == null && (pMSAppInfo = aVar.f11853g) != null) {
                                pMSAppInfo.appId = aVar.f11848b;
                                this.f11788e.v().p(aVar.f11853g, pMSAppInfo3);
                            } else {
                                g gVar2 = aVar.f11850d;
                                if (gVar2 != null && aVar.f11853g == null) {
                                    aVar.f11854h = true;
                                    aVar.f11853g = pMSAppInfo3;
                                    o(gVar2, gVar);
                                }
                            }
                        }
                    }
                }
            }
            if (gVar.n() == 0) {
                this.f11788e.F();
            } else {
                this.f11788e.G(gVar);
                b.a.p0.q.j.i.a.a(bVar, arrayList, list, this.f11788e);
            }
            return null;
        }
        return (b.a.p0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: x */
    public b.a.p0.q.j.l.b u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? b.a.p0.q.p.f.f(jSONObject) : (b.a.p0.q.j.l.b) invokeL.objValue;
    }
}
