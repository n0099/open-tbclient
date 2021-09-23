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
public class MassTransitRoutePlanOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCoordType;
    public PlanNode mFrom;
    public int mPageIndex;
    public int mPageSize;
    public TacticsIncity mTacticsIncity;
    public TacticsIntercity mTacticsIntercity;
    public PlanNode mTo;
    public TransTypeIntercity mTransTypeIntercity;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class TacticsIncity {
        public static /* synthetic */ Interceptable $ic;
        public static final TacticsIncity ETRANS_LEAST_TIME;
        public static final TacticsIncity ETRANS_LEAST_TRANSFER;
        public static final TacticsIncity ETRANS_LEAST_WALK;
        public static final TacticsIncity ETRANS_NO_SUBWAY;
        public static final TacticsIncity ETRANS_SUBWAY_FIRST;
        public static final TacticsIncity ETRANS_SUGGEST;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ TacticsIncity[] f41962b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f41963a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1599499102, "Lcom/baidu/mapapi/search/route/MassTransitRoutePlanOption$TacticsIncity;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1599499102, "Lcom/baidu/mapapi/search/route/MassTransitRoutePlanOption$TacticsIncity;");
                    return;
                }
            }
            ETRANS_SUGGEST = new TacticsIncity("ETRANS_SUGGEST", 0, 0);
            ETRANS_LEAST_TRANSFER = new TacticsIncity("ETRANS_LEAST_TRANSFER", 1, 1);
            ETRANS_LEAST_WALK = new TacticsIncity("ETRANS_LEAST_WALK", 2, 2);
            ETRANS_NO_SUBWAY = new TacticsIncity("ETRANS_NO_SUBWAY", 3, 3);
            ETRANS_LEAST_TIME = new TacticsIncity("ETRANS_LEAST_TIME", 4, 4);
            TacticsIncity tacticsIncity = new TacticsIncity("ETRANS_SUBWAY_FIRST", 5, 5);
            ETRANS_SUBWAY_FIRST = tacticsIncity;
            f41962b = new TacticsIncity[]{ETRANS_SUGGEST, ETRANS_LEAST_TRANSFER, ETRANS_LEAST_WALK, ETRANS_NO_SUBWAY, ETRANS_LEAST_TIME, tacticsIncity};
        }

        public TacticsIncity(String str, int i2, int i3) {
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
            this.f41963a = 0;
            this.f41963a = i3;
        }

        public static TacticsIncity valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TacticsIncity) Enum.valueOf(TacticsIncity.class, str) : (TacticsIncity) invokeL.objValue;
        }

        public static TacticsIncity[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TacticsIncity[]) f41962b.clone() : (TacticsIncity[]) invokeV.objValue;
        }

        public int getInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41963a : invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class TacticsIntercity {
        public static /* synthetic */ Interceptable $ic;
        public static final TacticsIntercity ETRANS_LEAST_PRICE;
        public static final TacticsIntercity ETRANS_LEAST_TIME;
        public static final TacticsIntercity ETRANS_START_EARLY;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ TacticsIntercity[] f41964b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f41965a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2078698755, "Lcom/baidu/mapapi/search/route/MassTransitRoutePlanOption$TacticsIntercity;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2078698755, "Lcom/baidu/mapapi/search/route/MassTransitRoutePlanOption$TacticsIntercity;");
                    return;
                }
            }
            ETRANS_LEAST_TIME = new TacticsIntercity("ETRANS_LEAST_TIME", 0, 0);
            ETRANS_START_EARLY = new TacticsIntercity("ETRANS_START_EARLY", 1, 1);
            TacticsIntercity tacticsIntercity = new TacticsIntercity("ETRANS_LEAST_PRICE", 2, 2);
            ETRANS_LEAST_PRICE = tacticsIntercity;
            f41964b = new TacticsIntercity[]{ETRANS_LEAST_TIME, ETRANS_START_EARLY, tacticsIntercity};
        }

        public TacticsIntercity(String str, int i2, int i3) {
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
            this.f41965a = 0;
            this.f41965a = i3;
        }

        public static TacticsIntercity valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TacticsIntercity) Enum.valueOf(TacticsIntercity.class, str) : (TacticsIntercity) invokeL.objValue;
        }

        public static TacticsIntercity[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TacticsIntercity[]) f41964b.clone() : (TacticsIntercity[]) invokeV.objValue;
        }

        public int getInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41965a : invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class TransTypeIntercity {
        public static /* synthetic */ Interceptable $ic;
        public static final TransTypeIntercity ETRANS_COACH_FIRST;
        public static final TransTypeIntercity ETRANS_PLANE_FIRST;
        public static final TransTypeIntercity ETRANS_TRAIN_FIRST;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ TransTypeIntercity[] f41966b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f41967a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1252238980, "Lcom/baidu/mapapi/search/route/MassTransitRoutePlanOption$TransTypeIntercity;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1252238980, "Lcom/baidu/mapapi/search/route/MassTransitRoutePlanOption$TransTypeIntercity;");
                    return;
                }
            }
            ETRANS_TRAIN_FIRST = new TransTypeIntercity("ETRANS_TRAIN_FIRST", 0, 0);
            ETRANS_PLANE_FIRST = new TransTypeIntercity("ETRANS_PLANE_FIRST", 1, 1);
            TransTypeIntercity transTypeIntercity = new TransTypeIntercity("ETRANS_COACH_FIRST", 2, 2);
            ETRANS_COACH_FIRST = transTypeIntercity;
            f41966b = new TransTypeIntercity[]{ETRANS_TRAIN_FIRST, ETRANS_PLANE_FIRST, transTypeIntercity};
        }

        public TransTypeIntercity(String str, int i2, int i3) {
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
            this.f41967a = 0;
            this.f41967a = i3;
        }

        public static TransTypeIntercity valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TransTypeIntercity) Enum.valueOf(TransTypeIntercity.class, str) : (TransTypeIntercity) invokeL.objValue;
        }

        public static TransTypeIntercity[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TransTypeIntercity[]) f41966b.clone() : (TransTypeIntercity[]) invokeV.objValue;
        }

        public int getInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41967a : invokeV.intValue;
        }
    }

    public MassTransitRoutePlanOption() {
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
        this.mCoordType = "bd09ll";
        this.mTacticsIncity = TacticsIncity.ETRANS_SUGGEST;
        this.mTacticsIntercity = TacticsIntercity.ETRANS_LEAST_TIME;
        this.mTransTypeIntercity = TransTypeIntercity.ETRANS_TRAIN_FIRST;
        this.mPageSize = 10;
        this.mPageIndex = 1;
    }

    @Deprecated
    public MassTransitRoutePlanOption coordType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mCoordType = str;
            return this;
        }
        return (MassTransitRoutePlanOption) invokeL.objValue;
    }

    public MassTransitRoutePlanOption from(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, planNode)) == null) {
            this.mFrom = planNode;
            return this;
        }
        return (MassTransitRoutePlanOption) invokeL.objValue;
    }

    public MassTransitRoutePlanOption pageIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 >= 0 && i2 <= 2147483646) {
                this.mPageIndex = i2 + 1;
            }
            return this;
        }
        return (MassTransitRoutePlanOption) invokeI.objValue;
    }

    public MassTransitRoutePlanOption pageSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 >= 1 && i2 <= 10) {
                this.mPageSize = i2;
            }
            return this;
        }
        return (MassTransitRoutePlanOption) invokeI.objValue;
    }

    public MassTransitRoutePlanOption tacticsIncity(TacticsIncity tacticsIncity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tacticsIncity)) == null) {
            this.mTacticsIncity = tacticsIncity;
            return this;
        }
        return (MassTransitRoutePlanOption) invokeL.objValue;
    }

    public MassTransitRoutePlanOption tacticsIntercity(TacticsIntercity tacticsIntercity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tacticsIntercity)) == null) {
            this.mTacticsIntercity = tacticsIntercity;
            return this;
        }
        return (MassTransitRoutePlanOption) invokeL.objValue;
    }

    public MassTransitRoutePlanOption to(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, planNode)) == null) {
            this.mTo = planNode;
            return this;
        }
        return (MassTransitRoutePlanOption) invokeL.objValue;
    }

    public MassTransitRoutePlanOption transtypeintercity(TransTypeIntercity transTypeIntercity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, transTypeIntercity)) == null) {
            this.mTransTypeIntercity = transTypeIntercity;
            return this;
        }
        return (MassTransitRoutePlanOption) invokeL.objValue;
    }
}
