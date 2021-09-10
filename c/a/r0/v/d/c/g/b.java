package c.a.r0.v.d.c.g;

import c.a.e.l.e.n;
import c.a.r0.v.d.c.e.e;
import c.a.r0.v.d.c.e.f;
import c.a.r0.v.d.c.e.g;
import c.a.r0.v.d.c.e.j;
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
    public boolean f25651a;

    /* renamed from: b  reason: collision with root package name */
    public g f25652b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.v.d.c.e.a f25653c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.v.d.c.e.d f25654d;

    /* renamed from: e  reason: collision with root package name */
    public j f25655e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f25656f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f25657g;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f25658h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f25659i;

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
        this.f25651a = false;
        this.f25652b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f25653c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f25654d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f25655e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.f25658h = new ArrayList();
        this.f25659i = new ArrayList();
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
            this.f25651a = jVar.f25573a;
            return g2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25652b = null;
            this.f25653c = null;
            this.f25654d = null;
            this.f25651a = false;
            List<n> list = this.f25656f;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f25657g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.f25658h;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.f25659i;
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
                c.a.r0.v.d.a.a aVar = new c.a.r0.v.d.a.a();
                aVar.f25460e = list.get(i2);
                aVar.f25465j = true;
                eVar.f25562e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c.a.r0.v.d.a.a aVar2 = new c.a.r0.v.d.a.a();
                    aVar2.f25460e = list.get(i3);
                    eVar.f25563f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f25465j = false;
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
            if (!ListUtils.isEmpty(this.f25657g)) {
                arrayList.addAll(this.f25657g);
            }
            if (!ListUtils.isEmpty(this.f25659i)) {
                arrayList.addAll(this.f25659i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f25656f = new ArrayList();
            g gVar = this.f25652b;
            if (gVar != null && gVar.a()) {
                f fVar = new f();
                fVar.f25565e = this.f25652b;
                this.f25656f.add(fVar);
            }
            if (this.f25653c != null) {
                ArrayList<n> f2 = f();
                if (!ListUtils.isEmpty(f2)) {
                    this.f25656f.addAll(f2);
                }
            }
            c.a.r0.v.d.c.e.d dVar = this.f25654d;
            if (dVar != null && !ListUtils.isEmpty(dVar.f25559a)) {
                c.a.r0.v.d.c.e.c cVar = new c.a.r0.v.d.c.e.c();
                cVar.f25558e = this.f25654d;
                this.f25656f.add(cVar);
            }
            this.f25657g = new ArrayList(this.f25656f);
            a(this.f25655e);
        }
    }

    public final ArrayList<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.f25653c.f25553a;
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
            ArrayList<SdkLiveInfoData> arrayList = jVar.f25574b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || c.a.r0.v.d.c.c.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f25658h.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f25658h);
            this.f25659i = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25651a : invokeV.booleanValue;
    }
}
