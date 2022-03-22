package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Map<String, Object> mBagOfTags;
    public volatile boolean mCleared;

    public ViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBagOfTags = new HashMap();
        this.mCleared = false;
    }

    public static void closeWithRuntimeException(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, obj) == null) && (obj instanceof Closeable)) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @MainThread
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mCleared = true;
            Map<String, Object> map = this.mBagOfTags;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : this.mBagOfTags.values()) {
                        closeWithRuntimeException(obj);
                    }
                }
            }
            onCleared();
        }
    }

    public <T> T getTag(String str) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Map<String, Object> map = this.mBagOfTags;
            if (map == null) {
                return null;
            }
            synchronized (map) {
                t = (T) this.mBagOfTags.get(str);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public void onCleared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public <T> T setTagIfAbsent(String str, T t) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            synchronized (this.mBagOfTags) {
                obj = this.mBagOfTags.get(str);
                if (obj == null) {
                    this.mBagOfTags.put(str, t);
                }
            }
            if (obj != null) {
                t = obj;
            }
            if (this.mCleared) {
                closeWithRuntimeException(t);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }
}
