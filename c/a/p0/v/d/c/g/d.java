package c.a.p0.v.d.c.g;

import c.a.e.k.e.n;
import c.a.p0.v.d.c.e.e;
import c.a.p0.v.d.c.e.j;
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
    public boolean f24856a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f24857b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f24858c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f24859d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24860e;

    /* renamed from: f  reason: collision with root package name */
    public String f24861f;

    /* renamed from: g  reason: collision with root package name */
    public String f24862g;

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
        this.f24856a = false;
        this.f24860e = false;
        this.f24857b = new ArrayList();
        this.f24858c = new ArrayList();
        this.f24859d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f24860e = true;
        }
        this.f24861f = str;
        this.f24862g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f24763b);
            this.f24856a = jVar.f24762a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24856a = false;
            List<String> list = this.f24857b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f24858c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f24859d;
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
                c.a.p0.v.d.a.a aVar = new c.a.p0.v.d.a.a();
                aVar.f24649e = list.get(i2);
                aVar.f24654j = true;
                aVar.f24650f = this.f24860e;
                aVar.f24651g = this.f24861f;
                aVar.f24652h = this.f24862g;
                int i3 = i2 + 1;
                aVar.f24653i = i3;
                eVar.f24751e = aVar;
                if (i3 < size) {
                    c.a.p0.v.d.a.a aVar2 = new c.a.p0.v.d.a.a();
                    aVar2.f24649e = list.get(i3);
                    aVar2.f24650f = this.f24860e;
                    aVar2.f24651g = this.f24861f;
                    aVar2.f24652h = this.f24862g;
                    aVar2.f24653i = i2 + 2;
                    eVar.f24752f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.f24654j = false;
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
            if (!ListUtils.isEmpty(this.f24859d)) {
                arrayList.addAll(this.f24859d);
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
                    if (!this.f24857b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f24857b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f24858c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f24858c);
            this.f24859d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f24856a : invokeV.booleanValue;
    }
}
