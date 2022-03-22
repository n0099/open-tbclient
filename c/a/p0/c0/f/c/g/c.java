package c.a.p0.c0.f.c.g;

import c.a.d.o.e.n;
import c.a.p0.c0.f.c.e.e;
import c.a.p0.c0.f.c.e.j;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f12992b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f12993c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f12994d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12995e;

    /* renamed from: f  reason: collision with root package name */
    public String f12996f;

    /* renamed from: g  reason: collision with root package name */
    public String f12997g;

    public c(j jVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f12995e = false;
        this.f12992b = new ArrayList();
        this.f12993c = new ArrayList();
        this.f12994d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f12995e = true;
        }
        this.f12996f = str;
        this.f12997g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f12933b);
            this.a = jVar.a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = false;
            List<String> list = this.f12992b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f12993c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f12994d;
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
            for (int i = 0; i < size; i += 2) {
                e eVar = new e();
                c.a.p0.c0.f.a.a aVar = new c.a.p0.c0.f.a.a();
                aVar.a = list.get(i);
                aVar.f12860f = true;
                aVar.f12856b = this.f12995e;
                aVar.f12857c = this.f12996f;
                aVar.f12858d = this.f12997g;
                int i2 = i + 1;
                aVar.f12859e = i2;
                eVar.a = aVar;
                if (i2 < size) {
                    c.a.p0.c0.f.a.a aVar2 = new c.a.p0.c0.f.a.a();
                    aVar2.a = list.get(i2);
                    aVar2.f12856b = this.f12995e;
                    aVar2.f12857c = this.f12996f;
                    aVar2.f12858d = this.f12997g;
                    aVar2.f12859e = i + 2;
                    eVar.f12928b = aVar2;
                    aVar2.f12861g = true;
                } else {
                    aVar.f12860f = false;
                    aVar.f12862h = true;
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
            if (!ListUtils.isEmpty(this.f12994d)) {
                arrayList.addAll(this.f12994d);
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
                    if (!this.f12992b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f12992b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f12993c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f12993c);
            this.f12994d = c2;
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
