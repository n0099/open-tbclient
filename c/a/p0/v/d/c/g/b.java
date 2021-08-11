package c.a.p0.v.d.c.g;

import c.a.e.k.e.n;
import c.a.p0.v.d.c.e.e;
import c.a.p0.v.d.c.e.f;
import c.a.p0.v.d.c.e.g;
import c.a.p0.v.d.c.e.j;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f24840a;

    /* renamed from: b  reason: collision with root package name */
    public g f24841b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.v.d.c.e.a f24842c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.v.d.c.e.d f24843d;

    /* renamed from: e  reason: collision with root package name */
    public j f24844e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f24845f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f24846g;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f24847h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f24848i;

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
        this.f24840a = false;
        this.f24841b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f24842c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f24843d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f24844e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.f24847h = new ArrayList();
        this.f24848i = new ArrayList();
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
            this.f24840a = jVar.f24762a;
            return g2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24841b = null;
            this.f24842c = null;
            this.f24843d = null;
            this.f24840a = false;
            List<n> list = this.f24845f;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f24846g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.f24847h;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.f24848i;
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
                c.a.p0.v.d.a.a aVar = new c.a.p0.v.d.a.a();
                aVar.f24649e = list.get(i2);
                aVar.f24654j = true;
                eVar.f24751e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c.a.p0.v.d.a.a aVar2 = new c.a.p0.v.d.a.a();
                    aVar2.f24649e = list.get(i3);
                    eVar.f24752f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f24654j = false;
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
            if (!ListUtils.isEmpty(this.f24846g)) {
                arrayList.addAll(this.f24846g);
            }
            if (!ListUtils.isEmpty(this.f24848i)) {
                arrayList.addAll(this.f24848i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f24845f = new ArrayList();
            g gVar = this.f24841b;
            if (gVar != null && gVar.a()) {
                f fVar = new f();
                fVar.f24754e = this.f24841b;
                this.f24845f.add(fVar);
            }
            if (this.f24842c != null) {
                ArrayList<n> f2 = f();
                if (!ListUtils.isEmpty(f2)) {
                    this.f24845f.addAll(f2);
                }
            }
            c.a.p0.v.d.c.e.d dVar = this.f24843d;
            if (dVar != null && !ListUtils.isEmpty(dVar.f24748a)) {
                c.a.p0.v.d.c.e.c cVar = new c.a.p0.v.d.c.e.c();
                cVar.f24747e = this.f24843d;
                this.f24845f.add(cVar);
            }
            this.f24846g = new ArrayList(this.f24845f);
            a(this.f24844e);
        }
    }

    public final ArrayList<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.f24842c.f24742a;
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
            ArrayList<SdkLiveInfoData> arrayList = jVar.f24763b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || c.a.p0.v.d.c.c.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f24847h.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f24847h);
            this.f24848i = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f24840a : invokeV.booleanValue;
    }
}
