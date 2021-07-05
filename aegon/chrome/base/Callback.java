package aegon.chrome.base;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface Callback<T> {

    /* loaded from: classes.dex */
    public static abstract class Helper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Helper() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void onBooleanResultFromNative(Callback callback, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65537, null, callback, z) == null) {
                callback.onResult(Boolean.valueOf(z));
            }
        }

        public static void onIntResultFromNative(Callback callback, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65538, null, callback, i2) == null) {
                callback.onResult(Integer.valueOf(i2));
            }
        }

        public static void onObjectResultFromNative(Callback callback, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, callback, obj) == null) {
                callback.onResult(obj);
            }
        }

        public static void runRunnable(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65540, null, runnable) == null) {
                runnable.run();
            }
        }
    }

    void onResult(T t);
}
