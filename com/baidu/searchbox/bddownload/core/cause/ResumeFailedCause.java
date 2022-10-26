package com.baidu.searchbox.bddownload.core.cause;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class ResumeFailedCause {
    public static final /* synthetic */ ResumeFailedCause[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ResumeFailedCause CONTENT_LENGTH_CHANGED;
    public static final ResumeFailedCause FILE_NOT_EXIST;
    public static final ResumeFailedCause INFO_DIRTY;
    public static final ResumeFailedCause OUTPUT_STREAM_NOT_SUPPORT;
    public static final ResumeFailedCause RESPONSE_CREATED_RANGE_NOT_FROM_0;
    public static final ResumeFailedCause RESPONSE_ETAG_CHANGED;
    public static final ResumeFailedCause RESPONSE_PRECONDITION_FAILED;
    public static final ResumeFailedCause RESPONSE_RESET_RANGE_NOT_FROM_0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(455909575, "Lcom/baidu/searchbox/bddownload/core/cause/ResumeFailedCause;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(455909575, "Lcom/baidu/searchbox/bddownload/core/cause/ResumeFailedCause;");
                return;
            }
        }
        INFO_DIRTY = new ResumeFailedCause("INFO_DIRTY", 0);
        FILE_NOT_EXIST = new ResumeFailedCause("FILE_NOT_EXIST", 1);
        OUTPUT_STREAM_NOT_SUPPORT = new ResumeFailedCause("OUTPUT_STREAM_NOT_SUPPORT", 2);
        RESPONSE_ETAG_CHANGED = new ResumeFailedCause("RESPONSE_ETAG_CHANGED", 3);
        RESPONSE_PRECONDITION_FAILED = new ResumeFailedCause("RESPONSE_PRECONDITION_FAILED", 4);
        RESPONSE_CREATED_RANGE_NOT_FROM_0 = new ResumeFailedCause("RESPONSE_CREATED_RANGE_NOT_FROM_0", 5);
        RESPONSE_RESET_RANGE_NOT_FROM_0 = new ResumeFailedCause("RESPONSE_RESET_RANGE_NOT_FROM_0", 6);
        ResumeFailedCause resumeFailedCause = new ResumeFailedCause("CONTENT_LENGTH_CHANGED", 7);
        CONTENT_LENGTH_CHANGED = resumeFailedCause;
        $VALUES = new ResumeFailedCause[]{INFO_DIRTY, FILE_NOT_EXIST, OUTPUT_STREAM_NOT_SUPPORT, RESPONSE_ETAG_CHANGED, RESPONSE_PRECONDITION_FAILED, RESPONSE_CREATED_RANGE_NOT_FROM_0, RESPONSE_RESET_RANGE_NOT_FROM_0, resumeFailedCause};
    }

    public ResumeFailedCause(String str, int i) {
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

    public static ResumeFailedCause valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ResumeFailedCause) Enum.valueOf(ResumeFailedCause.class, str);
        }
        return (ResumeFailedCause) invokeL.objValue;
    }

    public static ResumeFailedCause[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ResumeFailedCause[]) $VALUES.clone();
        }
        return (ResumeFailedCause[]) invokeV.objValue;
    }
}
