package com.baidu.mapapi.search.route;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TransitRoutePlanOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCityName;
    public PlanNode mFrom;
    public TransitPolicy mPolicy;
    public PlanNode mTo;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class TransitPolicy {
        public static /* synthetic */ Interceptable $ic;
        public static final TransitPolicy EBUS_NO_SUBWAY;
        public static final TransitPolicy EBUS_TIME_FIRST;
        public static final TransitPolicy EBUS_TRANSFER_FIRST;
        public static final TransitPolicy EBUS_WALK_FIRST;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ TransitPolicy[] f41712b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f41713a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2030563652, "Lcom/baidu/mapapi/search/route/TransitRoutePlanOption$TransitPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2030563652, "Lcom/baidu/mapapi/search/route/TransitRoutePlanOption$TransitPolicy;");
                    return;
                }
            }
            EBUS_TIME_FIRST = new TransitPolicy("EBUS_TIME_FIRST", 0, 0);
            EBUS_TRANSFER_FIRST = new TransitPolicy("EBUS_TRANSFER_FIRST", 1, 2);
            EBUS_WALK_FIRST = new TransitPolicy("EBUS_WALK_FIRST", 2, 3);
            TransitPolicy transitPolicy = new TransitPolicy("EBUS_NO_SUBWAY", 3, 4);
            EBUS_NO_SUBWAY = transitPolicy;
            f41712b = new TransitPolicy[]{EBUS_TIME_FIRST, EBUS_TRANSFER_FIRST, EBUS_WALK_FIRST, transitPolicy};
        }

        public TransitPolicy(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f41713a = 0;
            this.f41713a = i3;
        }

        public static TransitPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TransitPolicy) Enum.valueOf(TransitPolicy.class, str) : (TransitPolicy) invokeL.objValue;
        }

        public static TransitPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TransitPolicy[]) f41712b.clone() : (TransitPolicy[]) invokeV.objValue;
        }

        public int getInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41713a : invokeV.intValue;
        }
    }

    public TransitRoutePlanOption() {
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
        this.mFrom = null;
        this.mTo = null;
        this.mCityName = null;
        this.mPolicy = TransitPolicy.EBUS_TIME_FIRST;
    }

    public TransitRoutePlanOption city(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mCityName = str;
            return this;
        }
        return (TransitRoutePlanOption) invokeL.objValue;
    }

    public TransitRoutePlanOption from(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, planNode)) == null) {
            this.mFrom = planNode;
            return this;
        }
        return (TransitRoutePlanOption) invokeL.objValue;
    }

    public TransitRoutePlanOption policy(TransitPolicy transitPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, transitPolicy)) == null) {
            this.mPolicy = transitPolicy;
            return this;
        }
        return (TransitRoutePlanOption) invokeL.objValue;
    }

    public TransitRoutePlanOption to(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, planNode)) == null) {
            this.mTo = planNode;
            return this;
        }
        return (TransitRoutePlanOption) invokeL.objValue;
    }
}
