package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class HandlerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HandlerCompat";
    public transient /* synthetic */ FieldHolder $fh;

    public HandlerCompat() {
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
    public static Handler createAsync(@NonNull Looper looper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, looper)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                return Handler.createAsync(looper);
            }
            if (i >= 16) {
                try {
                    return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
                } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
                    Log.v(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor");
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    if (!(cause instanceof RuntimeException)) {
                        if (cause instanceof Error) {
                            throw ((Error) cause);
                        }
                        throw new RuntimeException(cause);
                    }
                    throw ((RuntimeException) cause);
                }
            }
            return new Handler(looper);
        }
        return (Handler) invokeL.objValue;
    }

    public static boolean postDelayed(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{handler, runnable, obj, Long.valueOf(j)})) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return handler.postDelayed(runnable, obj, j);
            }
            Message obtain = Message.obtain(handler, runnable);
            obtain.obj = obj;
            return handler.sendMessageDelayed(obtain, j);
        }
        return invokeCommon.booleanValue;
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, looper, callback)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                return Handler.createAsync(looper, callback);
            }
            if (i >= 16) {
                try {
                    return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, callback, Boolean.TRUE);
                } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
                    Log.v(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor");
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    if (!(cause instanceof RuntimeException)) {
                        if (cause instanceof Error) {
                            throw ((Error) cause);
                        }
                        throw new RuntimeException(cause);
                    }
                    throw ((RuntimeException) cause);
                }
            }
            return new Handler(looper, callback);
        }
        return (Handler) invokeLL.objValue;
    }
}
