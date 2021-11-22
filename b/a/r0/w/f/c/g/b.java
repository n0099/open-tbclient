package b.a.r0.w.f.c.g;

import b.a.e.m.e.n;
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
    public boolean f26207a;

    /* renamed from: b  reason: collision with root package name */
    public g f26208b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.w.f.c.e.a f26209c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.w.f.c.e.d f26210d;

    /* renamed from: e  reason: collision with root package name */
    public j f26211e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f26212f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f26213g;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f26214h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f26215i;

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
        this.f26207a = false;
        this.f26208b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f26209c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f26210d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f26211e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.f26214h = new ArrayList();
        this.f26215i = new ArrayList();
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
            this.f26207a = jVar.f26132a;
            return g2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26208b = null;
            this.f26209c = null;
            this.f26210d = null;
            this.f26207a = false;
            List<n> list = this.f26212f;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f26213g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.f26214h;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.f26215i;
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
                aVar.f26012e = list.get(i2);
                aVar.j = true;
                eVar.f26121e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    b.a.r0.w.f.a.a aVar2 = new b.a.r0.w.f.a.a();
                    aVar2.f26012e = list.get(i3);
                    eVar.f26122f = aVar2;
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
            if (!ListUtils.isEmpty(this.f26213g)) {
                arrayList.addAll(this.f26213g);
            }
            if (!ListUtils.isEmpty(this.f26215i)) {
                arrayList.addAll(this.f26215i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f26212f = new ArrayList();
            g gVar = this.f26208b;
            if (gVar != null && gVar.a()) {
                f fVar = new f();
                fVar.f26124e = this.f26208b;
                this.f26212f.add(fVar);
            }
            if (this.f26209c != null) {
                ArrayList<n> f2 = f();
                if (!ListUtils.isEmpty(f2)) {
                    this.f26212f.addAll(f2);
                }
            }
            b.a.r0.w.f.c.e.d dVar = this.f26210d;
            if (dVar != null && !ListUtils.isEmpty(dVar.f26118a)) {
                b.a.r0.w.f.c.e.c cVar = new b.a.r0.w.f.c.e.c();
                cVar.f26117e = this.f26210d;
                this.f26212f.add(cVar);
            }
            this.f26213g = new ArrayList(this.f26212f);
            a(this.f26211e);
        }
    }

    public final ArrayList<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.f26209c.f26112a;
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
            ArrayList<SdkLiveInfoData> arrayList = jVar.f26133b;
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
            this.f26214h.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f26214h);
            this.f26215i = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26207a : invokeV.booleanValue;
    }
}
