package c.a.n0.n.i.k;

import android.text.TextUtils;
import c.a.n0.n.f.g;
import c.a.n0.n.h.f;
import c.a.n0.n.i.l.a;
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
public class a extends c.a.n0.n.i.d<c.a.n0.n.i.l.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g gVar, c.a.n0.n.i.m.g gVar2) {
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
                super((g) objArr2[0], (c.a.n0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.n.i.d
    /* renamed from: o */
    public boolean e(c.a.n0.n.i.l.a aVar) {
        InterceptResult invokeL;
        List<a.C0613a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar == null || (list = aVar.f11681a) == null || list.isEmpty()) {
                return false;
            }
            for (a.C0613a c0613a : aVar.f11681a) {
                if (TextUtils.isEmpty(c0613a.f11683b)) {
                    return false;
                }
                if (c0613a.f11682a == 0) {
                    if (c0613a.f11685d == null && c0613a.f11687f == null && c0613a.f11686e == null) {
                        return false;
                    }
                    f fVar = c0613a.f11685d;
                    if (fVar != null && !fVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = c0613a.f11687f;
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
    @Override // c.a.n0.n.i.d
    /* renamed from: p */
    public c.a.n0.n.h.a m(c.a.n0.n.i.l.a aVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            this.f11628e.D();
            c.a.n0.n.o.f fVar = new c.a.n0.n.o.f();
            Map<String, PMSAppInfo> t = c.a.n0.n.g.a.h().t();
            ArrayList arrayList = new ArrayList();
            for (a.C0613a c0613a : aVar.f11681a) {
                if (c0613a != null) {
                    int i2 = c0613a.f11682a;
                    if (i2 != 0) {
                        this.f11628e.u().o(c0613a, t.get(c0613a.f11683b), new c.a.n0.n.h.a(i2, c0613a.f11683b + "，Server返回错误"));
                    } else {
                        List<c.a.n0.n.h.g> list = c0613a.f11686e;
                        if (list != null) {
                            for (c.a.n0.n.h.g gVar : list) {
                                if (gVar != null) {
                                    gVar.o = c0613a.f11683b;
                                }
                            }
                            j(c0613a.f11686e, fVar);
                            arrayList.addAll(c0613a.f11686e);
                        }
                        if (c0613a.f11685d != null && (pMSAppInfo2 = c0613a.f11687f) != null) {
                            pMSAppInfo2.appId = c0613a.f11683b;
                            this.f11628e.u().l(c0613a.f11687f);
                            i(c0613a.f11685d, fVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = t.get(c0613a.f11683b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = c0613a.f11687f;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = c0613a.f11683b;
                                    List<c.a.n0.n.h.g> list2 = c0613a.f11686e;
                                    if (list2 != null && !list2.isEmpty()) {
                                        c0613a.f11687f.copySubPkgInfo(c0613a.f11686e.get(0));
                                    }
                                    this.f11628e.u().p(c0613a.f11687f, null);
                                } else {
                                    int i3 = c0613a.f11682a;
                                    this.f11628e.u().o(c0613a, null, new c.a.n0.n.h.a(i3, c0613a.f11683b + "，本地记录不存在"));
                                }
                            } else if (c0613a.f11685d == null && (pMSAppInfo = c0613a.f11687f) != null) {
                                pMSAppInfo.appId = c0613a.f11683b;
                                this.f11628e.u().p(c0613a.f11687f, pMSAppInfo3);
                            } else {
                                f fVar2 = c0613a.f11685d;
                                if (fVar2 != null && c0613a.f11687f == null) {
                                    c0613a.f11688g = true;
                                    c0613a.f11687f = pMSAppInfo3;
                                    i(fVar2, fVar);
                                }
                            }
                        }
                    }
                }
            }
            if (fVar.l() == 0) {
                this.f11628e.E();
            } else {
                this.f11628e.F(fVar);
                c.a.n0.n.i.i.a.a(aVar, arrayList, this.f11628e);
            }
            return null;
        }
        return (c.a.n0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.n.i.d
    /* renamed from: q */
    public c.a.n0.n.i.l.a n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.n0.n.o.e.e(jSONObject) : (c.a.n0.n.i.l.a) invokeL.objValue;
    }
}
