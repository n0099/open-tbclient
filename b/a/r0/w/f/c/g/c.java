package b.a.r0.w.f.c.g;

import b.a.e.l.e.n;
import b.a.r0.w.f.c.e.e;
import b.a.r0.w.f.c.e.j;
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

    /* renamed from: a  reason: collision with root package name */
    public boolean f24699a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f24700b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f24701c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f24702d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24703e;

    /* renamed from: f  reason: collision with root package name */
    public String f24704f;

    /* renamed from: g  reason: collision with root package name */
    public String f24705g;

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
        this.f24699a = false;
        this.f24703e = false;
        this.f24700b = new ArrayList();
        this.f24701c = new ArrayList();
        this.f24702d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f24703e = true;
        }
        this.f24704f = str;
        this.f24705g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f24616b);
            this.f24699a = jVar.f24615a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24699a = false;
            List<String> list = this.f24700b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f24701c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f24702d;
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
                b.a.r0.w.f.a.a aVar = new b.a.r0.w.f.a.a();
                aVar.f24495e = list.get(i2);
                aVar.j = true;
                aVar.f24496f = this.f24703e;
                aVar.f24497g = this.f24704f;
                aVar.f24498h = this.f24705g;
                int i3 = i2 + 1;
                aVar.f24499i = i3;
                eVar.f24604e = aVar;
                if (i3 < size) {
                    b.a.r0.w.f.a.a aVar2 = new b.a.r0.w.f.a.a();
                    aVar2.f24495e = list.get(i3);
                    aVar2.f24496f = this.f24703e;
                    aVar2.f24497g = this.f24704f;
                    aVar2.f24498h = this.f24705g;
                    aVar2.f24499i = i2 + 2;
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
            if (!ListUtils.isEmpty(this.f24702d)) {
                arrayList.addAll(this.f24702d);
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
                    if (!this.f24700b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f24700b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f24701c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f24701c);
            this.f24702d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f24699a : invokeV.booleanValue;
    }
}
