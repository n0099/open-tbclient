package b.a.r0.w.f.c.g;

import b.a.e.l.e.n;
import b.a.r0.w.f.c.e.e;
import b.a.r0.w.f.c.e.f;
import b.a.r0.w.f.c.e.g;
import b.a.r0.w.f.c.e.j;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f24690a;

    /* renamed from: b  reason: collision with root package name */
    public g f24691b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.w.f.c.e.a f24692c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.w.f.c.e.d f24693d;

    /* renamed from: e  reason: collision with root package name */
    public j f24694e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f24695f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f24696g;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f24697h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f24698i;

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
        this.f24690a = false;
        this.f24691b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f24692c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f24693d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f24694e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.f24697h = new ArrayList();
        this.f24698i = new ArrayList();
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
            this.f24690a = jVar.f24615a;
            return g2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24691b = null;
            this.f24692c = null;
            this.f24693d = null;
            this.f24690a = false;
            List<n> list = this.f24695f;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f24696g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.f24697h;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.f24698i;
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
                b.a.r0.w.f.a.a aVar = new b.a.r0.w.f.a.a();
                aVar.f24495e = list.get(i2);
                aVar.j = true;
                eVar.f24604e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    b.a.r0.w.f.a.a aVar2 = new b.a.r0.w.f.a.a();
                    aVar2.f24495e = list.get(i3);
                    eVar.f24605f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.j = false;
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
            if (!ListUtils.isEmpty(this.f24696g)) {
                arrayList.addAll(this.f24696g);
            }
            if (!ListUtils.isEmpty(this.f24698i)) {
                arrayList.addAll(this.f24698i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f24695f = new ArrayList();
            g gVar = this.f24691b;
            if (gVar != null && gVar.a()) {
                f fVar = new f();
                fVar.f24607e = this.f24691b;
                this.f24695f.add(fVar);
            }
            if (this.f24692c != null) {
                ArrayList<n> f2 = f();
                if (!ListUtils.isEmpty(f2)) {
                    this.f24695f.addAll(f2);
                }
            }
            b.a.r0.w.f.c.e.d dVar = this.f24693d;
            if (dVar != null && !ListUtils.isEmpty(dVar.f24601a)) {
                b.a.r0.w.f.c.e.c cVar = new b.a.r0.w.f.c.e.c();
                cVar.f24600e = this.f24693d;
                this.f24695f.add(cVar);
            }
            this.f24696g = new ArrayList(this.f24695f);
            a(this.f24694e);
        }
    }

    public final ArrayList<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.f24692c.f24595a;
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
            ArrayList<SdkLiveInfoData> arrayList = jVar.f24616b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || b.a.r0.w.f.c.c.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f24697h.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f24697h);
            this.f24698i = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f24690a : invokeV.booleanValue;
    }
}
