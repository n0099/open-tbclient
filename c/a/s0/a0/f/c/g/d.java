package c.a.s0.a0.f.c.g;

import c.a.d.m.e.n;
import c.a.s0.a0.f.c.e.e;
import c.a.s0.a0.f.c.e.j;
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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f14373b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f14374c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f14375d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14376e;

    /* renamed from: f  reason: collision with root package name */
    public String f14377f;

    /* renamed from: g  reason: collision with root package name */
    public String f14378g;

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
        this.a = false;
        this.f14376e = false;
        this.f14373b = new ArrayList();
        this.f14374c = new ArrayList();
        this.f14375d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f14376e = true;
        }
        this.f14377f = str;
        this.f14378g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f14291b);
            this.a = jVar.a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = false;
            List<String> list = this.f14373b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f14374c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f14375d;
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
                c.a.s0.a0.f.a.a aVar = new c.a.s0.a0.f.a.a();
                aVar.f14174e = list.get(i2);
                aVar.f14179j = true;
                aVar.f14175f = this.f14376e;
                aVar.f14176g = this.f14377f;
                aVar.f14177h = this.f14378g;
                int i3 = i2 + 1;
                aVar.f14178i = i3;
                eVar.f14283e = aVar;
                if (i3 < size) {
                    c.a.s0.a0.f.a.a aVar2 = new c.a.s0.a0.f.a.a();
                    aVar2.f14174e = list.get(i3);
                    aVar2.f14175f = this.f14376e;
                    aVar2.f14176g = this.f14377f;
                    aVar2.f14177h = this.f14378g;
                    aVar2.f14178i = i2 + 2;
                    eVar.f14284f = aVar2;
                    aVar2.f14180k = true;
                } else {
                    aVar.f14179j = false;
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
            if (!ListUtils.isEmpty(this.f14375d)) {
                arrayList.addAll(this.f14375d);
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
                    if (!this.f14373b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f14373b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f14374c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f14374c);
            this.f14375d = c2;
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
