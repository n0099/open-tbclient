package c.a.q0.v.d.c.g;

import c.a.e.l.e.n;
import c.a.q0.v.d.c.e.e;
import c.a.q0.v.d.c.e.j;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25182a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f25183b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f25184c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f25185d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25186e;

    /* renamed from: f  reason: collision with root package name */
    public String f25187f;

    /* renamed from: g  reason: collision with root package name */
    public String f25188g;

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
        this.f25182a = false;
        this.f25186e = false;
        this.f25183b = new ArrayList();
        this.f25184c = new ArrayList();
        this.f25185d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f25186e = true;
        }
        this.f25187f = str;
        this.f25188g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f25096b);
            this.f25182a = jVar.f25095a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25182a = false;
            List<String> list = this.f25183b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f25184c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f25185d;
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
                c.a.q0.v.d.a.a aVar = new c.a.q0.v.d.a.a();
                aVar.f24982e = list.get(i2);
                aVar.f24987j = true;
                aVar.f24983f = this.f25186e;
                aVar.f24984g = this.f25187f;
                aVar.f24985h = this.f25188g;
                int i3 = i2 + 1;
                aVar.f24986i = i3;
                eVar.f25084e = aVar;
                if (i3 < size) {
                    c.a.q0.v.d.a.a aVar2 = new c.a.q0.v.d.a.a();
                    aVar2.f24982e = list.get(i3);
                    aVar2.f24983f = this.f25186e;
                    aVar2.f24984g = this.f25187f;
                    aVar2.f24985h = this.f25188g;
                    aVar2.f24986i = i2 + 2;
                    eVar.f25085f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f24987j = false;
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
            if (!ListUtils.isEmpty(this.f25185d)) {
                arrayList.addAll(this.f25185d);
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
                    if (!this.f25183b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f25183b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f25184c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f25184c);
            this.f25185d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25182a : invokeV.booleanValue;
    }
}
