package c.a.u0.a0.f.c.g;

import c.a.d.o.e.n;
import c.a.u0.a0.f.c.e.e;
import c.a.u0.a0.f.c.e.j;
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
    public List<String> f14925b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f14926c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f14927d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14928e;

    /* renamed from: f  reason: collision with root package name */
    public String f14929f;

    /* renamed from: g  reason: collision with root package name */
    public String f14930g;

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
        this.f14928e = false;
        this.f14925b = new ArrayList();
        this.f14926c = new ArrayList();
        this.f14927d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f14928e = true;
        }
        this.f14929f = str;
        this.f14930g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f14852b);
            this.a = jVar.a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = false;
            List<String> list = this.f14925b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f14926c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f14927d;
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
                c.a.u0.a0.f.a.a aVar = new c.a.u0.a0.f.a.a();
                aVar.f14741e = list.get(i2);
                aVar.f14746j = true;
                aVar.f14742f = this.f14928e;
                aVar.f14743g = this.f14929f;
                aVar.f14744h = this.f14930g;
                int i3 = i2 + 1;
                aVar.f14745i = i3;
                eVar.f14844e = aVar;
                if (i3 < size) {
                    c.a.u0.a0.f.a.a aVar2 = new c.a.u0.a0.f.a.a();
                    aVar2.f14741e = list.get(i3);
                    aVar2.f14742f = this.f14928e;
                    aVar2.f14743g = this.f14929f;
                    aVar2.f14744h = this.f14930g;
                    aVar2.f14745i = i2 + 2;
                    eVar.f14845f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f14746j = false;
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
            if (!ListUtils.isEmpty(this.f14927d)) {
                arrayList.addAll(this.f14927d);
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
                    if (!this.f14925b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f14925b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f14926c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f14926c);
            this.f14927d = c2;
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
