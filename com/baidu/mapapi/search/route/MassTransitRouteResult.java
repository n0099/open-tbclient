package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class MassTransitRouteResult extends SearchResult implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MassTransitRouteResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public TransitResultNode a;

    /* renamed from: b  reason: collision with root package name */
    public TransitResultNode f26484b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f26485c;

    /* renamed from: d  reason: collision with root package name */
    public int f26486d;

    /* renamed from: e  reason: collision with root package name */
    public List<MassTransitRouteLine> f26487e;

    /* renamed from: f  reason: collision with root package name */
    public SuggestAddrInfo f26488f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(905834346, "Lcom/baidu/mapapi/search/route/MassTransitRouteResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(905834346, "Lcom/baidu/mapapi/search/route/MassTransitRouteResult;");
                return;
            }
        }
        CREATOR = new l();
    }

    public MassTransitRouteResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public MassTransitRouteResult(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f26484b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f26485c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f26486d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f26487e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f26488f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public TransitResultNode getDestination() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26484b : (TransitResultNode) invokeV.objValue;
    }

    public TransitResultNode getOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (TransitResultNode) invokeV.objValue;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26487e : (List) invokeV.objValue;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26488f : (SuggestAddrInfo) invokeV.objValue;
    }

    public TaxiInfo getTaxiInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26485c : (TaxiInfo) invokeV.objValue;
    }

    public int getTotal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26486d : invokeV.intValue;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, transitResultNode) == null) {
            this.f26484b = transitResultNode;
        }
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, transitResultNode) == null) {
            this.a = transitResultNode;
        }
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f26487e = list;
        }
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, suggestAddrInfo) == null) {
            this.f26488f = suggestAddrInfo;
        }
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, taxiInfo) == null) {
            this.f26485c = taxiInfo;
        }
    }

    public void setTotal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f26486d = i;
        }
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i) == null) {
            parcel.writeParcelable(this.a, 1);
            parcel.writeParcelable(this.f26484b, 1);
            parcel.writeParcelable(this.f26485c, 1);
            parcel.writeInt(this.f26486d);
            parcel.writeList(this.f26487e);
            parcel.writeParcelable(this.f26488f, 1);
        }
    }
}
