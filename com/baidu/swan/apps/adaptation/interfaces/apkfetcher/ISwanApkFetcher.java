package com.baidu.swan.apps.adaptation.interfaces.apkfetcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e93;
import com.baidu.tieba.yu1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface ISwanApkFetcher {

    /* loaded from: classes3.dex */
    public interface a {
    }

    boolean D();

    void F(@NonNull String str, @Nullable a aVar);

    void d(@NonNull String str, @NonNull yu1 yu1Var);

    void e(@NonNull String str, @NonNull yu1 yu1Var);

    void f(@NonNull String str, @NonNull yu1 yu1Var);

    void g(@NonNull String str, @Nullable a aVar);

    void h(@NonNull String str, @NonNull yu1 yu1Var);

    void j(@NonNull String str, @NonNull yu1 yu1Var);

    void release();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class FetchStates {
        public static final /* synthetic */ FetchStates[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FetchStates DELETED;
        public static final FetchStates FETCHED;
        public static final FetchStates FETCHING;
        public static final FetchStates FETCH_FAILED;
        public static final FetchStates FETCH_PAUSED;
        public static final FetchStates FETCH_PREPARE;
        public static final FetchStates FINISHED;
        public static final FetchStates INSTALLED;
        public static final FetchStates PENDING;
        public static final FetchStates WAITING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1882523620, "Lcom/baidu/swan/apps/adaptation/interfaces/apkfetcher/ISwanApkFetcher$FetchStates;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1882523620, "Lcom/baidu/swan/apps/adaptation/interfaces/apkfetcher/ISwanApkFetcher$FetchStates;");
                    return;
                }
            }
            PENDING = new FetchStates("PENDING", 0);
            FETCHING = new FetchStates("FETCHING", 1);
            FETCH_PAUSED = new FetchStates("FETCH_PAUSED", 2);
            FETCHED = new FetchStates("FETCHED", 3);
            FETCH_FAILED = new FetchStates("FETCH_FAILED", 4);
            INSTALLED = new FetchStates("INSTALLED", 5);
            DELETED = new FetchStates("DELETED", 6);
            FETCH_PREPARE = new FetchStates("FETCH_PREPARE", 7);
            WAITING = new FetchStates("WAITING", 8);
            FetchStates fetchStates = new FetchStates("FINISHED", 9);
            FINISHED = fetchStates;
            $VALUES = new FetchStates[]{PENDING, FETCHING, FETCH_PAUSED, FETCHED, FETCH_FAILED, INSTALLED, DELETED, FETCH_PREPARE, WAITING, fetchStates};
        }

        public FetchStates(String str, int i) {
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

        public static FetchStates valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (FetchStates) Enum.valueOf(FetchStates.class, str);
            }
            return (FetchStates) invokeL.objValue;
        }

        public static FetchStates[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (FetchStates[]) $VALUES.clone();
            }
            return (FetchStates[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends e93 implements ISwanApkFetcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public boolean D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void F(@NonNull String str, @Nullable a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            }
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void d(@NonNull String str, @NonNull yu1 yu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, yu1Var) == null) {
            }
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void e(@NonNull String str, @NonNull yu1 yu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, yu1Var) == null) {
            }
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void f(@NonNull String str, @NonNull yu1 yu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, yu1Var) == null) {
            }
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void g(@NonNull String str, @Nullable a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, aVar) == null) {
            }
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void h(@NonNull String str, @NonNull yu1 yu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, yu1Var) == null) {
            }
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void j(@NonNull String str, @NonNull yu1 yu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, yu1Var) == null) {
            }
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }
}
