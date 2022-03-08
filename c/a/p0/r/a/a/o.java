package c.a.p0.r.a.a;

import androidx.annotation.AnimRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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

    public abstract o a(@IdRes int i2, Fragment fragment);

    public abstract o b(@IdRes int i2, Fragment fragment, @Nullable String str);

    public abstract o c(Fragment fragment, String str);

    public abstract o d(@Nullable String str);

    public abstract int e();

    public abstract int f();

    public abstract o g(Fragment fragment);

    public abstract o h(Fragment fragment);

    public abstract o i(@AnimRes int i2, @AnimRes int i3);

    public abstract o j(Fragment fragment);
}
