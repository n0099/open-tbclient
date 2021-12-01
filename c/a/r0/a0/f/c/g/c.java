package c.a.r0.a0.f.c.g;

import c.a.d.m.e.n;
import c.a.r0.a0.f.c.e.e;
import c.a.r0.a0.f.c.e.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f14027b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f14028c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f14029d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14030e;

    /* renamed from: f  reason: collision with root package name */
    public String f14031f;

    /* renamed from: g  reason: collision with root package name */
    public String f14032g;

    public c(j jVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, str, str2};
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
        this.f14030e = false;
        this.f14027b = new ArrayList();
        this.f14028c = new ArrayList();
        this.f14029d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f14030e = true;
        }
        this.f14031f = str;
        this.f14032g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f13951b);
            this.a = jVar.a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = false;
            List<String> list = this.f14027b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f14028c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f14029d;
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
                c.a.r0.a0.f.a.a aVar = new c.a.r0.a0.f.a.a();
                aVar.f13834e = list.get(i2);
                aVar.f13839j = true;
                aVar.f13835f = this.f14030e;
                aVar.f13836g = this.f14031f;
                aVar.f13837h = this.f14032g;
                int i3 = i2 + 1;
                aVar.f13838i = i3;
                eVar.f13943e = aVar;
                if (i3 < size) {
                    c.a.r0.a0.f.a.a aVar2 = new c.a.r0.a0.f.a.a();
                    aVar2.f13834e = list.get(i3);
                    aVar2.f13835f = this.f14030e;
                    aVar2.f13836g = this.f14031f;
                    aVar2.f13837h = this.f14032g;
                    aVar2.f13838i = i2 + 2;
                    eVar.f13944f = aVar2;
                    aVar2.f13840k = true;
                } else {
                    aVar.f13839j = false;
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
            if (!ListUtils.isEmpty(this.f14029d)) {
                arrayList.addAll(this.f14029d);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean e(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (SdkLiveInfoData sdkLiveInfoData : list) {
                if (sdkLiveInfoData != null) {
                    String str = sdkLiveInfoData.liveId;
                    if (!this.f14027b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f14027b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f14028c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f14028c);
            this.f14029d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
