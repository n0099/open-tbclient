package c.a.p0.n.i.i.e;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f11914a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11914a = new ArrayList();
    }

    public synchronized T c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f11914a.isEmpty()) {
                    return null;
                }
                T t = this.f11914a.get(0);
                this.f11914a.remove(0);
                return t;
            }
        }
        return (T) invokeV.objValue;
    }

    public synchronized T d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.f11914a.isEmpty()) {
                    return null;
                }
                return this.f11914a.get(0);
            }
        }
        return (T) invokeV.objValue;
    }

    public T e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            if (t != null) {
                for (int size = this.f11914a.size() - 1; size >= 0; size--) {
                    if (t.equals(this.f11914a.get(size))) {
                        return this.f11914a.get(size);
                    }
                }
                return null;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    public Iterator<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11914a.iterator() : (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(",Queue Size:" + this.f11914a.size());
            synchronized (this) {
                int i2 = 0;
                for (T t : this.f11914a) {
                    sb.append(":[" + i2 + PreferencesUtil.RIGHT_MOUNT + t);
                    i2++;
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
