package c.a.u0.a0.f.c.g;

import c.a.d.o.e.n;
import c.a.u0.a0.f.c.e.e;
import c.a.u0.a0.f.c.e.f;
import c.a.u0.a0.f.c.e.g;
import c.a.u0.a0.f.c.e.j;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public g f14917b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.u0.a0.f.c.e.a f14918c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.u0.a0.f.c.e.d f14919d;

    /* renamed from: e  reason: collision with root package name */
    public j f14920e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f14921f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f14922g;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f14923h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f14924i;

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaTabLiveResponsedMessage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f14917b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f14918c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f14919d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f14920e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.f14923h = new ArrayList();
        this.f14924i = new ArrayList();
        e();
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean g2 = g(jVar);
            this.a = jVar.a;
            return g2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14917b = null;
            this.f14918c = null;
            this.f14919d = null;
            this.a = false;
            List<n> list = this.f14921f;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f14922g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.f14923h;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.f14924i;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<n> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                e eVar = new e();
                c.a.u0.a0.f.a.a aVar = new c.a.u0.a0.f.a.a();
                aVar.f14741e = list.get(i2);
                aVar.f14746j = true;
                eVar.f14844e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c.a.u0.a0.f.a.a aVar2 = new c.a.u0.a0.f.a.a();
                    aVar2.f14741e = list.get(i3);
                    eVar.f14845f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f14746j = false;
                    aVar.l = true;
                }
                arrayList.add(eVar);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<n> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.f14922g)) {
                arrayList.addAll(this.f14922g);
            }
            if (!ListUtils.isEmpty(this.f14924i)) {
                arrayList.addAll(this.f14924i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14921f = new ArrayList();
            g gVar = this.f14917b;
            if (gVar != null && gVar.a()) {
                f fVar = new f();
                fVar.f14847e = this.f14917b;
                this.f14921f.add(fVar);
            }
            if (this.f14918c != null) {
                ArrayList<n> f2 = f();
                if (!ListUtils.isEmpty(f2)) {
                    this.f14921f.addAll(f2);
                }
            }
            c.a.u0.a0.f.c.e.d dVar = this.f14919d;
            if (dVar != null && !ListUtils.isEmpty(dVar.a)) {
                c.a.u0.a0.f.c.e.c cVar = new c.a.u0.a0.f.c.e.c();
                cVar.f14841e = this.f14919d;
                this.f14921f.add(cVar);
            }
            this.f14922g = new ArrayList(this.f14921f);
            a(this.f14920e);
        }
    }

    public final ArrayList<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.f14918c.a;
            if (arrayList == null || arrayList.size() < 2) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
                if (sdkLiveInfoData != null) {
                    arrayList2.add(sdkLiveInfoData);
                }
            }
            if (arrayList2.size() < 2) {
                return null;
            }
            return c(arrayList2);
        }
        return (ArrayList) invokeV.objValue;
    }

    public final boolean g(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            ArrayList<SdkLiveInfoData> arrayList = jVar.f14852b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || c.a.u0.a0.f.c.c.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f14923h.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f14923h);
            this.f14924i = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
