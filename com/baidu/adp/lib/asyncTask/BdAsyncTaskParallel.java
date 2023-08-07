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
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId mBdAsyncTaskParallelTag;
    public BdAsyncTaskParallelType mBdAsyncTaskParallelType;
    public int mExecuteNum;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
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

        public BdAsyncTaskParallelType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BdAsyncTaskParallelType) Enum.valueOf(BdAsyncTaskParallelType.class, str);
            }
            return (BdAsyncTaskParallelType) invokeL.objValue;
        }

        public static BdAsyncTaskParallelType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BdAsyncTaskParallelType[]) $VALUES.clone();
            }
            return (BdAsyncTaskParallelType[]) invokeV.objValue;
        }
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBdAsyncTaskParallelTag = null;
        this.mBdAsyncTaskParallelType = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdUniqueId != null) {
            this.mBdAsyncTaskParallelType = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
            this.mExecuteNum = i;
            this.mBdAsyncTaskParallelTag = bdUniqueId;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public BdAsyncTaskParallel(BdAsyncTaskParallelType bdAsyncTaskParallelType, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdAsyncTaskParallelType, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBdAsyncTaskParallelTag = null;
        this.mBdAsyncTaskParallelType = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdAsyncTaskParallelType != null && bdUniqueId != null) {
            this.mBdAsyncTaskParallelType = bdAsyncTaskParallelType;
            this.mBdAsyncTaskParallelTag = bdUniqueId;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int getExecuteNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mExecuteNum;
        }
        return invokeV.intValue;
    }

    public int getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdUniqueId bdUniqueId = this.mBdAsyncTaskParallelTag;
            if (bdUniqueId == null) {
                return 0;
            }
            return bdUniqueId.getId();
        }
        return invokeV.intValue;
    }

    public BdAsyncTaskParallelType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBdAsyncTaskParallelType;
        }
        return (BdAsyncTaskParallelType) invokeV.objValue;
    }
}
