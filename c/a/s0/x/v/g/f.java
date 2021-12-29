package c.a.s0.x.v.g;

import android.content.Context;
import c.a.s0.x.m;
import com.baidu.tbadk.editortools.local.view.LocalInputContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LocalInputContainer r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, c.a.s0.x.v.e.a aVar) {
        super(context, (String) null, 36);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f(context, aVar);
        this.f14538k = this.r;
        this.m = false;
        this.l = 3;
        this.n = new int[]{24, 3};
    }

    public final void f(Context context, c.a.s0.x.v.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) {
            LocalInputContainer localInputContainer = new LocalInputContainer(context);
            this.r = localInputContainer;
            localInputContainer.init(aVar);
        }
    }
}
