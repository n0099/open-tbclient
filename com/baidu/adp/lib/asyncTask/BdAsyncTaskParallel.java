package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes4.dex */
public class BdAsyncTaskParallel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f36261a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f36262b;

    /* renamed from: c  reason: collision with root package name */
    public int f36263c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class BdAsyncTaskParallelType {
        public static final /* synthetic */ BdAsyncTaskParallelType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdAsyncTaskParallelType CUSTOM_PARALLEL;
        public static final BdAsyncTaskParallelType FOUR_PARALLEL;
        public static final BdAsyncTaskParallelType MAX_PARALLEL;
        public static final BdAsyncTaskParallelType SERIAL;
        public static final BdAsyncTaskParallelType THREE_PARALLEL;
        public static final BdAsyncTaskParallelType TWO_PARALLEL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(47652321, "Lcom/baidu/adp/lib/asyncTask/BdAsyncTaskParallel$BdAsyncTaskParallelType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(47652321, "Lcom/baidu/adp/lib/asyncTask/BdAsyncTaskParallel$BdAsyncTaskParallelType;");
                    return;
                }
            }
            SERIAL = new BdAsyncTaskParallelType("SERIAL", 0);
            TWO_PARALLEL = new BdAsyncTaskParallelType("TWO_PARALLEL", 1);
            THREE_PARALLEL = new BdAsyncTaskParallelType("THREE_PARALLEL", 2);
            FOUR_PARALLEL = new BdAsyncTaskParallelType("FOUR_PARALLEL", 3);
            CUSTOM_PARALLEL = new BdAsyncTaskParallelType("CUSTOM_PARALLEL", 4);
            BdAsyncTaskParallelType bdAsyncTaskParallelType = new BdAsyncTaskParallelType("MAX_PARALLEL", 5);
            MAX_PARALLEL = bdAsyncTaskParallelType;
            $VALUES = new BdAsyncTaskParallelType[]{SERIAL, TWO_PARALLEL, THREE_PARALLEL, FOUR_PARALLEL, CUSTOM_PARALLEL, bdAsyncTaskParallelType};
        }

        public BdAsyncTaskParallelType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BdAsyncTaskParallelType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdAsyncTaskParallelType) Enum.valueOf(BdAsyncTaskParallelType.class, str) : (BdAsyncTaskParallelType) invokeL.objValue;
        }

        public static BdAsyncTaskParallelType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdAsyncTaskParallelType[]) $VALUES.clone() : (BdAsyncTaskParallelType[]) invokeV.objValue;
        }
    }

    public BdAsyncTaskParallel(BdAsyncTaskParallelType bdAsyncTaskParallelType, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdAsyncTaskParallelType, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36261a = null;
        this.f36262b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.f36263c = 1;
        if (bdAsyncTaskParallelType != null && bdUniqueId != null) {
            this.f36262b = bdAsyncTaskParallelType;
            this.f36261a = bdUniqueId;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36263c : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdUniqueId bdUniqueId = this.f36261a;
            if (bdUniqueId == null) {
                return 0;
            }
            return bdUniqueId.getId();
        }
        return invokeV.intValue;
    }

    public BdAsyncTaskParallelType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36262b : (BdAsyncTaskParallelType) invokeV.objValue;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36261a = null;
        this.f36262b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.f36263c = 1;
        if (bdUniqueId != null) {
            this.f36262b = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
            this.f36263c = i2;
            this.f36261a = bdUniqueId;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }
}
