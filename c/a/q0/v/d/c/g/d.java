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
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25189a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f25190b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f25191c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f25192d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25193e;

    /* renamed from: f  reason: collision with root package name */
    public String f25194f;

    /* renamed from: g  reason: collision with root package name */
    public String f25195g;

    public d(j jVar, String str, String str2) {
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
        this.f25189a = false;
        this.f25193e = false;
        this.f25190b = new ArrayList();
        this.f25191c = new ArrayList();
        this.f25192d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f25193e = true;
        }
        this.f25194f = str;
        this.f25195g = str2;
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
            this.f25189a = jVar.f25095a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25189a = false;
            List<String> list = this.f25190b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f25191c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f25192d;
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
                aVar.f24983f = this.f25193e;
                aVar.f24984g = this.f25194f;
                aVar.f24985h = this.f25195g;
                int i3 = i2 + 1;
                aVar.f24986i = i3;
                eVar.f25084e = aVar;
                if (i3 < size) {
                    c.a.q0.v.d.a.a aVar2 = new c.a.q0.v.d.a.a();
                    aVar2.f24982e = list.get(i3);
                    aVar2.f24983f = this.f25193e;
                    aVar2.f24984g = this.f25194f;
                    aVar2.f24985h = this.f25195g;
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
            if (!ListUtils.isEmpty(this.f25192d)) {
                arrayList.addAll(this.f25192d);
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
                    if (!this.f25190b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f25190b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f25191c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f25191c);
            this.f25192d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25189a : invokeV.booleanValue;
    }
}
