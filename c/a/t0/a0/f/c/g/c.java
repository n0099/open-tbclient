package c.a.t0.a0.f.c.g;

import c.a.d.n.e.n;
import c.a.t0.a0.f.c.e.e;
import c.a.t0.a0.f.c.e.j;
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
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f14511b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f14512c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f14513d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14514e;

    /* renamed from: f  reason: collision with root package name */
    public String f14515f;

    /* renamed from: g  reason: collision with root package name */
    public String f14516g;

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
        this.f14514e = false;
        this.f14511b = new ArrayList();
        this.f14512c = new ArrayList();
        this.f14513d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f14514e = true;
        }
        this.f14515f = str;
        this.f14516g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f14438b);
            this.a = jVar.a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = false;
            List<String> list = this.f14511b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f14512c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f14513d;
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
                c.a.t0.a0.f.a.a aVar = new c.a.t0.a0.f.a.a();
                aVar.f14327e = list.get(i2);
                aVar.f14332j = true;
                aVar.f14328f = this.f14514e;
                aVar.f14329g = this.f14515f;
                aVar.f14330h = this.f14516g;
                int i3 = i2 + 1;
                aVar.f14331i = i3;
                eVar.f14430e = aVar;
                if (i3 < size) {
                    c.a.t0.a0.f.a.a aVar2 = new c.a.t0.a0.f.a.a();
                    aVar2.f14327e = list.get(i3);
                    aVar2.f14328f = this.f14514e;
                    aVar2.f14329g = this.f14515f;
                    aVar2.f14330h = this.f14516g;
                    aVar2.f14331i = i2 + 2;
                    eVar.f14431f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f14332j = false;
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
            if (!ListUtils.isEmpty(this.f14513d)) {
                arrayList.addAll(this.f14513d);
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
                    if (!this.f14511b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f14511b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f14512c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f14512c);
            this.f14513d = c2;
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
