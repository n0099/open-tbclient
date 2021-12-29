package c.a.r0.q.j.k;

import android.text.TextUtils;
import c.a.r0.q.f.i;
import c.a.r0.q.i.g;
import c.a.r0.q.j.l.b;
import c.a.r0.q.j.m.h;
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
/* loaded from: classes6.dex */
public class b extends c.a.r0.q.j.d<c.a.r0.q.j.l.b> {
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

    @Override // c.a.r0.q.j.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q.j.d
    /* renamed from: v */
    public boolean f(c.a.r0.q.j.l.b bVar) {
        InterceptResult invokeL;
        List<b.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null || (list = bVar.a) == null || list.isEmpty()) {
                return false;
            }
            for (b.a aVar : bVar.a) {
                if (TextUtils.isEmpty(aVar.f11820b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.f11822d == null && aVar.f11825g == null && aVar.f11823e == null) {
                        return false;
                    }
                    g gVar = aVar.f11822d;
                    if (gVar != null && !gVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = aVar.f11825g;
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
    @Override // c.a.r0.q.j.d
    /* renamed from: w */
    public c.a.r0.q.i.b t(c.a.r0.q.j.l.b bVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f11773e.F();
            c.a.r0.q.p.g gVar = new c.a.r0.q.p.g();
            Map<String, PMSAppInfo> v = c.a.r0.q.g.a.i().v();
            ArrayList arrayList = new ArrayList();
            List<c.a.r0.q.i.i> list = null;
            for (b.a aVar : bVar.a) {
                if (aVar != null) {
                    int i2 = aVar.a;
                    if (i2 != 0) {
                        this.f11773e.w().o(aVar, v.get(aVar.f11820b), new c.a.r0.q.i.b(i2, aVar.f11820b + "，Server返回错误"));
                    } else {
                        List<c.a.r0.q.i.h> list2 = aVar.f11823e;
                        if (list2 != null) {
                            for (c.a.r0.q.i.h hVar : list2) {
                                if (hVar != null) {
                                    hVar.o = aVar.f11820b;
                                }
                            }
                            p(aVar.f11823e, gVar);
                            arrayList.addAll(aVar.f11823e);
                        }
                        list = g(aVar.f11824f);
                        if (list != null) {
                            n(list, gVar);
                        }
                        if (aVar.f11822d != null && (pMSAppInfo2 = aVar.f11825g) != null) {
                            pMSAppInfo2.appId = aVar.f11820b;
                            this.f11773e.w().l(aVar.f11825g);
                            o(aVar.f11822d, gVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.f11820b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.f11825g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.f11820b;
                                    List<c.a.r0.q.i.h> list3 = aVar.f11823e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.f11825g.copySubPkgInfo(aVar.f11823e.get(0));
                                    }
                                    this.f11773e.w().p(aVar.f11825g, null);
                                } else {
                                    this.f11773e.w().o(aVar, null, new c.a.r0.q.i.b(aVar.a, aVar.f11820b + "，本地记录不存在"));
                                }
                            } else if (aVar.f11822d == null && (pMSAppInfo = aVar.f11825g) != null) {
                                pMSAppInfo.appId = aVar.f11820b;
                                this.f11773e.w().p(aVar.f11825g, pMSAppInfo3);
                            } else {
                                g gVar2 = aVar.f11822d;
                                if (gVar2 != null && aVar.f11825g == null) {
                                    aVar.f11826h = true;
                                    aVar.f11825g = pMSAppInfo3;
                                    o(gVar2, gVar);
                                }
                            }
                        }
                    }
                }
            }
            if (gVar.n() == 0) {
                this.f11773e.G();
            } else {
                this.f11773e.H(gVar);
                c.a.r0.q.j.i.a.a(bVar, arrayList, list, this.f11773e);
            }
            return null;
        }
        return (c.a.r0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q.j.d
    /* renamed from: x */
    public c.a.r0.q.j.l.b u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.r0.q.p.f.f(jSONObject) : (c.a.r0.q.j.l.b) invokeL.objValue;
    }
}
