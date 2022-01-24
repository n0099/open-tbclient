package c.a.c0.a0.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder a;

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
        this.a = new StringBuilder();
    }

    @Override // c.a.c0.a0.c.d
    public <T extends d> T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? (T) c(str, str2) : (T) invokeLL.objValue;
    }

    public <T extends d> T b(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) ? (T) c(str, obj) : (T) invokeLL.objValue;
    }

    public <T extends d> T c(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj)) == null) {
            if (!TextUtils.isEmpty(str) && obj != null) {
                try {
                    if (!TextUtils.isEmpty(String.valueOf(obj))) {
                        if (this.a.length() > 0) {
                            this.a.append(Typography.amp);
                        }
                        StringBuilder sb = this.a;
                        sb.append(str);
                        sb.append(com.alipay.sdk.encrypt.a.f30893h);
                        sb.append(obj);
                    }
                } catch (Exception unused) {
                }
            }
            return this;
        }
        return (T) invokeLL.objValue;
    }

    @Override // c.a.c0.a0.c.d
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.toString() : (String) invokeV.objValue;
    }
}
