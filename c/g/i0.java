package c.g;

import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.p0;
/* loaded from: classes9.dex */
public class i0 implements p0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ m0 a;

    public i0(m0 m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m0Var;
    }

    @Override // com.fun.p0.b
    public void a(@Nullable NetworkInfo networkInfo) {
        m0 m0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
            if (networkInfo == null) {
                this.a.f29327d = "unknow";
                return;
            }
            if (networkInfo.isConnectedOrConnecting()) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName)) {
                    this.a.f29327d = subtypeName;
                    return;
                } else {
                    m0Var = this.a;
                    str = networkInfo.getTypeName();
                }
            } else {
                m0Var = this.a;
                str = "unknow";
            }
            m0Var.f29327d = str;
        }
    }
}
