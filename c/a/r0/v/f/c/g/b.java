package c.a.r0.v.f.c.g;

import c.a.e.l.e.n;
import c.a.r0.v.f.c.e.e;
import c.a.r0.v.f.c.e.f;
import c.a.r0.v.f.c.e.g;
import c.a.r0.v.f.c.e.j;
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
    public boolean f25674a;

    /* renamed from: b  reason: collision with root package name */
    public g f25675b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.v.f.c.e.a f25676c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.v.f.c.e.d f25677d;

    /* renamed from: e  reason: collision with root package name */
    public j f25678e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f25679f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f25680g;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f25681h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f25682i;

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
        this.f25674a = false;
        this.f25675b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f25676c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f25677d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f25678e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.f25681h = new ArrayList();
        this.f25682i = new ArrayList();
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
            this.f25674a = jVar.f25596a;
            return g2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25675b = null;
            this.f25676c = null;
            this.f25677d = null;
            this.f25674a = false;
            List<n> list = this.f25679f;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f25680g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.f25681h;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.f25682i;
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
                c.a.r0.v.f.a.a aVar = new c.a.r0.v.f.a.a();
                aVar.f25483e = list.get(i2);
                aVar.f25488j = true;
                eVar.f25585e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c.a.r0.v.f.a.a aVar2 = new c.a.r0.v.f.a.a();
                    aVar2.f25483e = list.get(i3);
                    eVar.f25586f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f25488j = false;
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
            if (!ListUtils.isEmpty(this.f25680g)) {
                arrayList.addAll(this.f25680g);
            }
            if (!ListUtils.isEmpty(this.f25682i)) {
                arrayList.addAll(this.f25682i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f25679f = new ArrayList();
            g gVar = this.f25675b;
            if (gVar != null && gVar.a()) {
                f fVar = new f();
                fVar.f25588e = this.f25675b;
                this.f25679f.add(fVar);
            }
            if (this.f25676c != null) {
                ArrayList<n> f2 = f();
                if (!ListUtils.isEmpty(f2)) {
                    this.f25679f.addAll(f2);
                }
            }
            c.a.r0.v.f.c.e.d dVar = this.f25677d;
            if (dVar != null && !ListUtils.isEmpty(dVar.f25582a)) {
                c.a.r0.v.f.c.e.c cVar = new c.a.r0.v.f.c.e.c();
                cVar.f25581e = this.f25677d;
                this.f25679f.add(cVar);
            }
            this.f25680g = new ArrayList(this.f25679f);
            a(this.f25678e);
        }
    }

    public final ArrayList<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.f25676c.f25576a;
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
            ArrayList<SdkLiveInfoData> arrayList = jVar.f25597b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || c.a.r0.v.f.c.c.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f25681h.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f25681h);
            this.f25682i = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25674a : invokeV.booleanValue;
    }
}
