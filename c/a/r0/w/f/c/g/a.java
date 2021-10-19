package c.a.r0.w.f.c.g;

import c.a.e.l.e.n;
import c.a.r0.w.f.c.e.e;
import c.a.r0.w.f.c.e.j;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25845a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f25846b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f25847c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f25848d;

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
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
        this.f25845a = false;
        this.f25846b = new ArrayList();
        this.f25847c = new ArrayList();
        this.f25848d = new ArrayList();
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar);
            this.f25845a = jVar.f25771a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25845a = false;
            List<String> list = this.f25846b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f25847c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f25848d;
            if (list3 != null) {
                list3.clear();
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
                c.a.r0.w.f.a.a aVar = new c.a.r0.w.f.a.a();
                aVar.f25658e = list.get(i2);
                aVar.f25663j = true;
                eVar.f25760e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c.a.r0.w.f.a.a aVar2 = new c.a.r0.w.f.a.a();
                    aVar2.f25658e = list.get(i3);
                    eVar.f25761f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f25663j = false;
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
            if (!ListUtils.isEmpty(this.f25848d)) {
                arrayList.addAll(this.f25848d);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean e(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            ArrayList<SdkLiveInfoData> arrayList = jVar.f25772b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && c.a.r0.w.f.c.c.c(next)) {
                    String str = next.liveId;
                    if (!this.f25846b.contains(str)) {
                        arrayList2.add(next);
                        this.f25846b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f25847c.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f25847c);
            this.f25848d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25845a : invokeV.booleanValue;
    }
}
