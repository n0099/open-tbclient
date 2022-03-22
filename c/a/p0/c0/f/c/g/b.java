package c.a.p0.c0.f.c.g;

import c.a.d.o.e.n;
import c.a.p0.c0.f.c.e.e;
import c.a.p0.c0.f.c.e.f;
import c.a.p0.c0.f.c.e.g;
import c.a.p0.c0.f.c.e.j;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public g f12985b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.c0.f.c.e.a f12986c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.c0.f.c.e.d f12987d;

    /* renamed from: e  reason: collision with root package name */
    public j f12988e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f12989f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f12990g;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f12991h;
    public List<n> i;

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaTabLiveResponsedMessage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f12985b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f12986c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f12987d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f12988e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.f12991h = new ArrayList();
        this.i = new ArrayList();
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
            this.f12985b = null;
            this.f12986c = null;
            this.f12987d = null;
            this.a = false;
            List<n> list = this.f12989f;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f12990g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.f12991h;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.i;
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
            for (int i = 0; i < size; i += 2) {
                e eVar = new e();
                c.a.p0.c0.f.a.a aVar = new c.a.p0.c0.f.a.a();
                aVar.a = list.get(i);
                aVar.f12860f = true;
                eVar.a = aVar;
                int i2 = i + 1;
                if (i2 < size) {
                    c.a.p0.c0.f.a.a aVar2 = new c.a.p0.c0.f.a.a();
                    aVar2.a = list.get(i2);
                    eVar.f12928b = aVar2;
                    aVar2.f12861g = true;
                } else {
                    aVar.f12860f = false;
                    aVar.f12862h = true;
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
            if (!ListUtils.isEmpty(this.f12990g)) {
                arrayList.addAll(this.f12990g);
            }
            if (!ListUtils.isEmpty(this.i)) {
                arrayList.addAll(this.i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12989f = new ArrayList();
            g gVar = this.f12985b;
            if (gVar != null && gVar.a()) {
                f fVar = new f();
                fVar.a = this.f12985b;
                this.f12989f.add(fVar);
            }
            if (this.f12986c != null) {
                ArrayList<n> f2 = f();
                if (!ListUtils.isEmpty(f2)) {
                    this.f12989f.addAll(f2);
                }
            }
            c.a.p0.c0.f.c.e.d dVar = this.f12987d;
            if (dVar != null && !ListUtils.isEmpty(dVar.a)) {
                c.a.p0.c0.f.c.e.c cVar = new c.a.p0.c0.f.c.e.c();
                cVar.a = this.f12987d;
                this.f12989f.add(cVar);
            }
            this.f12990g = new ArrayList(this.f12989f);
            a(this.f12988e);
        }
    }

    public final ArrayList<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.f12986c.a;
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
            ArrayList<SdkLiveInfoData> arrayList = jVar.f12933b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || c.a.p0.c0.f.c.c.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f12991h.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f12991h);
            this.i = c2;
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
