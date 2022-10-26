package com.baidu.nadcore.download.proxy;

import com.baidu.tieba.il0;
import com.baidu.tieba.mk0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public interface IAdDownloader {
    int a(mk0 mk0Var, il0 il0Var);

    void b(mk0 mk0Var);

    void c(mk0 mk0Var);

    void d(mk0 mk0Var, il0 il0Var);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class STATE {
        public static final /* synthetic */ STATE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final STATE DOWNLOADED;
        public static final STATE DOWNLOADING;
        public static final STATE DOWNLOAD_FAILED;
        public static final STATE DOWNLOAD_PAUSED;
        public static final STATE NOT_START;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197848584, "Lcom/baidu/nadcore/download/proxy/IAdDownloader$STATE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(197848584, "Lcom/baidu/nadcore/download/proxy/IAdDownloader$STATE;");
                    return;
                }
            }
            NOT_START = new STATE("NOT_START", 0);
            DOWNLOADING = new STATE("DOWNLOADING", 1);
            DOWNLOAD_PAUSED = new STATE("DOWNLOAD_PAUSED", 2);
            DOWNLOADED = new STATE("DOWNLOADED", 3);
            STATE state = new STATE("DOWNLOAD_FAILED", 4);
            DOWNLOAD_FAILED = state;
            $VALUES = new STATE[]{NOT_START, DOWNLOADING, DOWNLOAD_PAUSED, DOWNLOADED, state};
        }

        public STATE(String str, int i) {
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

        public static STATE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (STATE) Enum.valueOf(STATE.class, str);
            }
            return (STATE) invokeL.objValue;
        }

        public static STATE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (STATE[]) $VALUES.clone();
            }
            return (STATE[]) invokeV.objValue;
        }
    }
}
