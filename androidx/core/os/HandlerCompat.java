package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
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

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class Api28Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api28Impl() {
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

        public static Handler createAsync(Looper looper) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, looper)) == null) {
                return Handler.createAsync(looper);
            }
            return (Handler) invokeL.objValue;
        }

        public static Handler createAsync(Looper looper, Handler.Callback callback) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, looper, callback)) == null) {
                return Handler.createAsync(looper, callback);
            }
            return (Handler) invokeLL.objValue;
        }

        public static boolean postDelayed(Handler handler, Runnable runnable, Object obj, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{handler, runnable, obj, Long.valueOf(j)})) == null) {
                return handler.postDelayed(runnable, obj, j);
            }
            return invokeCommon.booleanValue;
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api29Impl() {
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

        public static boolean hasCallbacks(Handler handler, Runnable runnable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, handler, runnable)) == null) {
                return handler.hasCallbacks(runnable);
            }
            return invokeLL.booleanValue;
        }
    }

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
                return Api28Impl.createAsync(looper);
            }
            if (i >= 17) {
                try {
                    return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
                } catch (IllegalAccessException e) {
                    e = e;
                    Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                    return new Handler(looper);
                } catch (InstantiationException e2) {
                    e = e2;
                    Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                    return new Handler(looper);
                } catch (NoSuchMethodException e3) {
                    e = e3;
                    Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                    return new Handler(looper);
                } catch (InvocationTargetException e4) {
                    Throwable cause = e4.getCause();
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

    @NonNull
    public static Handler createAsync(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, looper, callback)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                return Api28Impl.createAsync(looper, callback);
            }
            if (i >= 17) {
                try {
                    return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, callback, Boolean.TRUE);
                } catch (IllegalAccessException e) {
                    e = e;
                    Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                    return new Handler(looper, callback);
                } catch (InstantiationException e2) {
                    e = e2;
                    Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                    return new Handler(looper, callback);
                } catch (NoSuchMethodException e3) {
                    e = e3;
                    Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                    return new Handler(looper, callback);
                } catch (InvocationTargetException e4) {
                    Throwable cause = e4.getCause();
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

    @RequiresApi(16)
    public static boolean hasCallbacks(@NonNull Handler handler, @NonNull Runnable runnable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, handler, runnable)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                return Api29Impl.hasCallbacks(handler, runnable);
            }
            if (i >= 16) {
                try {
                    return ((Boolean) Handler.class.getMethod("hasCallbacks", Runnable.class).invoke(handler, runnable)).booleanValue();
                } catch (IllegalAccessException e) {
                    e = e;
                } catch (NoSuchMethodException e2) {
                    e = e2;
                } catch (NullPointerException e3) {
                    e = e3;
                } catch (InvocationTargetException e4) {
                    Throwable cause = e4.getCause();
                    if (!(cause instanceof RuntimeException)) {
                        if (cause instanceof Error) {
                            throw ((Error) cause);
                        }
                        throw new RuntimeException(cause);
                    }
                    throw ((RuntimeException) cause);
                }
            } else {
                e = null;
            }
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
        }
        return invokeLL.booleanValue;
    }

    public static boolean postDelayed(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{handler, runnable, obj, Long.valueOf(j)})) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.postDelayed(handler, runnable, obj, j);
            }
            Message obtain = Message.obtain(handler, runnable);
            obtain.obj = obj;
            return handler.sendMessageDelayed(obtain, j);
        }
        return invokeCommon.booleanValue;
    }
}
