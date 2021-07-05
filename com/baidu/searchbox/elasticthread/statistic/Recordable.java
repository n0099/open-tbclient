package com.baidu.searchbox.elasticthread.statistic;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface Recordable {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RecordStatus {
        public static final /* synthetic */ RecordStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RecordStatus RECORDING;
        public static final RecordStatus RECORD_END;
        public static final RecordStatus UNINITIATED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-917414136, "Lcom/baidu/searchbox/elasticthread/statistic/Recordable$RecordStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-917414136, "Lcom/baidu/searchbox/elasticthread/statistic/Recordable$RecordStatus;");
                    return;
                }
            }
            UNINITIATED = new RecordStatus("UNINITIATED", 0);
            RECORDING = new RecordStatus("RECORDING", 1);
            RecordStatus recordStatus = new RecordStatus("RECORD_END", 2);
            RECORD_END = recordStatus;
            $VALUES = new RecordStatus[]{UNINITIATED, RECORDING, recordStatus};
        }

        public RecordStatus(String str, int i2) {
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

        public static RecordStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RecordStatus) Enum.valueOf(RecordStatus.class, str) : (RecordStatus) invokeL.objValue;
        }

        public static RecordStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RecordStatus[]) $VALUES.clone() : (RecordStatus[]) invokeV.objValue;
        }
    }

    void onRecordBegin();

    void onRecordEnd();
}
