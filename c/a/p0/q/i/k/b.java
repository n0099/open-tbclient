package c.a.p0.q.i.k;

import android.text.TextUtils;
import c.a.p0.q.e.i;
import c.a.p0.q.h.g;
import c.a.p0.q.i.l.b;
import c.a.p0.q.i.m.h;
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
/* loaded from: classes2.dex */
public class b extends c.a.p0.q.i.d<c.a.p0.q.i.l.b> {
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

    @Override // c.a.p0.q.i.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: v */
    public boolean f(c.a.p0.q.i.l.b bVar) {
        InterceptResult invokeL;
        List<b.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null || (list = bVar.a) == null || list.isEmpty()) {
                return false;
            }
            for (b.a aVar : bVar.a) {
                if (TextUtils.isEmpty(aVar.f11018b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.f11020d == null && aVar.f11023g == null && aVar.f11021e == null) {
                        return false;
                    }
                    g gVar = aVar.f11020d;
                    if (gVar != null && !gVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = aVar.f11023g;
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
    @Override // c.a.p0.q.i.d
    /* renamed from: w */
    public c.a.p0.q.h.b t(c.a.p0.q.i.l.b bVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f10972e.F();
            c.a.p0.q.o.g gVar = new c.a.p0.q.o.g();
            Map<String, PMSAppInfo> v = c.a.p0.q.f.a.i().v();
            ArrayList arrayList = new ArrayList();
            List<c.a.p0.q.h.i> list = null;
            for (b.a aVar : bVar.a) {
                if (aVar != null) {
                    int i2 = aVar.a;
                    if (i2 != 0) {
                        this.f10972e.w().o(aVar, v.get(aVar.f11018b), new c.a.p0.q.h.b(i2, aVar.f11018b + "，Server返回错误"));
                    } else {
                        List<c.a.p0.q.h.h> list2 = aVar.f11021e;
                        if (list2 != null) {
                            for (c.a.p0.q.h.h hVar : list2) {
                                if (hVar != null) {
                                    hVar.o = aVar.f11018b;
                                }
                            }
                            p(aVar.f11021e, gVar);
                            arrayList.addAll(aVar.f11021e);
                        }
                        list = g(aVar.f11022f);
                        if (list != null) {
                            n(list, gVar);
                        }
                        if (aVar.f11020d != null && (pMSAppInfo2 = aVar.f11023g) != null) {
                            pMSAppInfo2.appId = aVar.f11018b;
                            this.f10972e.w().l(aVar.f11023g);
                            o(aVar.f11020d, gVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.f11018b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.f11023g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.f11018b;
                                    List<c.a.p0.q.h.h> list3 = aVar.f11021e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.f11023g.copySubPkgInfo(aVar.f11021e.get(0));
                                    }
                                    this.f10972e.w().p(aVar.f11023g, null);
                                } else {
                                    this.f10972e.w().o(aVar, null, new c.a.p0.q.h.b(aVar.a, aVar.f11018b + "，本地记录不存在"));
                                }
                            } else if (aVar.f11020d == null && (pMSAppInfo = aVar.f11023g) != null) {
                                pMSAppInfo.appId = aVar.f11018b;
                                this.f10972e.w().p(aVar.f11023g, pMSAppInfo3);
                            } else {
                                g gVar2 = aVar.f11020d;
                                if (gVar2 != null && aVar.f11023g == null) {
                                    aVar.f11024h = true;
                                    aVar.f11023g = pMSAppInfo3;
                                    o(gVar2, gVar);
                                }
                            }
                        }
                    }
                }
            }
            if (gVar.n() == 0) {
                this.f10972e.G();
            } else {
                this.f10972e.H(gVar);
                c.a.p0.q.i.i.a.a(bVar, arrayList, list, this.f10972e);
            }
            return null;
        }
        return (c.a.p0.q.h.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: x */
    public c.a.p0.q.i.l.b u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.p0.q.o.f.f(jSONObject) : (c.a.p0.q.i.l.b) invokeL.objValue;
    }
}
