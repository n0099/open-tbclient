package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RequiresApi(17)
/* loaded from: classes.dex */
public class UserHandleCompat {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static Method sGetUserIdMethod;
    @Nullable
    public static Constructor<UserHandle> sUserHandleConstructor;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class Api24Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api24Impl() {
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

        @NonNull
        public static UserHandle getUserHandleForUid(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
                return UserHandle.getUserHandleForUid(i);
            }
            return (UserHandle) invokeI.objValue;
        }
    }

    public UserHandleCompat() {
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

    public static Method getGetUserIdMethod() throws NoSuchMethodException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sGetUserIdMethod == null) {
                Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", Integer.TYPE);
                sGetUserIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return sGetUserIdMethod;
        }
        return (Method) invokeV.objValue;
    }

    public static Constructor<UserHandle> getUserHandleConstructor() throws NoSuchMethodException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sUserHandleConstructor == null) {
                Constructor<UserHandle> declaredConstructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
                sUserHandleConstructor = declaredConstructor;
                declaredConstructor.setAccessible(true);
            }
            return sUserHandleConstructor;
        }
        return (Constructor) invokeV.objValue;
    }

    @NonNull
    public static UserHandle getUserHandleForUid(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return Api24Impl.getUserHandleForUid(i);
            }
            try {
                return getUserHandleConstructor().newInstance((Integer) getGetUserIdMethod().invoke(null, Integer.valueOf(i)));
            } catch (IllegalAccessException e) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e);
                throw illegalAccessError;
            } catch (InstantiationException e2) {
                InstantiationError instantiationError = new InstantiationError();
                instantiationError.initCause(e2);
                throw instantiationError;
            } catch (NoSuchMethodException e3) {
                NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
                noSuchMethodError.initCause(e3);
                throw noSuchMethodError;
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        }
        return (UserHandle) invokeI.objValue;
    }
}
