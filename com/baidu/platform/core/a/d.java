package com.baidu.platform.core.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.base.a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public OnGetDistricSearchResultListener f9425b;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9425b = null;
    }

    @Override // com.baidu.platform.core.a.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9394a.lock();
            this.f9425b = null;
            this.f9394a.unlock();
        }
    }

    @Override // com.baidu.platform.core.a.e
    public void a(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGetDistricSearchResultListener) == null) {
            this.f9394a.lock();
            this.f9425b = onGetDistricSearchResultListener;
            this.f9394a.unlock();
        }
    }

    @Override // com.baidu.platform.core.a.e
    public boolean a(DistrictSearchOption districtSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, districtSearchOption)) == null) {
            b bVar = new b();
            bVar.a(SearchType.p);
            return a(new a(districtSearchOption), this.f9425b, bVar);
        }
        return invokeL.booleanValue;
    }
}
