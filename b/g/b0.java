package b.g;

import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.m0;
/* loaded from: classes6.dex */
public class b0 implements m0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f31124a;

    public b0(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31124a = g0Var;
    }

    @Override // com.fun.m0.b
    public void a(@Nullable NetworkInfo networkInfo) {
        g0 g0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
            if (networkInfo == null) {
                this.f31124a.f31151d = "unknow";
                return;
            }
            if (networkInfo.isConnectedOrConnecting()) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName)) {
                    this.f31124a.f31151d = subtypeName;
                    return;
                } else {
                    g0Var = this.f31124a;
                    str = networkInfo.getTypeName();
                }
            } else {
                g0Var = this.f31124a;
                str = "unknow";
            }
            g0Var.f31151d = str;
        }
    }
}
