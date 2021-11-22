package b.a.r0.w.f.c.g;

import b.a.e.m.e.n;
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
    public boolean f26216a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f26217b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f26218c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f26219d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26220e;

    /* renamed from: f  reason: collision with root package name */
    public String f26221f;

    /* renamed from: g  reason: collision with root package name */
    public String f26222g;

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
        this.f26216a = false;
        this.f26220e = false;
        this.f26217b = new ArrayList();
        this.f26218c = new ArrayList();
        this.f26219d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f26220e = true;
        }
        this.f26221f = str;
        this.f26222g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f26133b);
            this.f26216a = jVar.f26132a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26216a = false;
            List<String> list = this.f26217b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f26218c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f26219d;
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
                aVar.f26012e = list.get(i2);
                aVar.j = true;
                aVar.f26013f = this.f26220e;
                aVar.f26014g = this.f26221f;
                aVar.f26015h = this.f26222g;
                int i3 = i2 + 1;
                aVar.f26016i = i3;
                eVar.f26121e = aVar;
                if (i3 < size) {
                    b.a.r0.w.f.a.a aVar2 = new b.a.r0.w.f.a.a();
                    aVar2.f26012e = list.get(i3);
                    aVar2.f26013f = this.f26220e;
                    aVar2.f26014g = this.f26221f;
                    aVar2.f26015h = this.f26222g;
                    aVar2.f26016i = i2 + 2;
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
            if (!ListUtils.isEmpty(this.f26219d)) {
                arrayList.addAll(this.f26219d);
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
                    if (!this.f26217b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f26217b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f26218c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f26218c);
            this.f26219d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26216a : invokeV.booleanValue;
    }
}
