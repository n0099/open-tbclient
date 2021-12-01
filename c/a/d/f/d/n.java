package c.a.d.f.d;

import c.a.d.f.d.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class n<T> extends m<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, k<T> kVar) {
        super(str, kVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (k) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.d.f.d.m, c.a.d.f.d.l
    public void e(String str, T t, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, t, Long.valueOf(j2)}) == null) {
            try {
                super.e(str, t, j2);
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th);
                }
            }
        }
    }

    @Override // c.a.d.f.d.m, c.a.d.f.d.l
    public T get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return (T) super.get(str);
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th);
                    return null;
                }
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.d.f.d.m, c.a.d.f.d.l
    public l.b<T> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return super.h(str);
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th);
                    return null;
                }
                return null;
            }
        }
        return (l.b) invokeL.objValue;
    }

    @Override // c.a.d.f.d.m, c.a.d.f.d.l
    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                super.remove(str);
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th);
                }
            }
        }
    }
}
