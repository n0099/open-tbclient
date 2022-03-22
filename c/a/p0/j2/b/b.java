package c.a.p0.j2.b;

import android.content.Context;
import c.a.o0.w.m;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, context.getString(R.string.obfuscated_res_0x7f0f0521), 12);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11510d = R.drawable.obfuscated_res_0x7f080957;
        this.f11512f = R.drawable.icon_pure_post_more_bubble64;
        this.f11511e = R.drawable.obfuscated_res_0x7f080810;
        this.p = R.drawable.obfuscated_res_0x7f080953;
        this.f11513g = false;
        this.f11514h = true;
        this.m = true;
        CommonTabHost commonTabHost = new CommonTabHost(context);
        this.k = commonTabHost;
        commonTabHost.k(new a());
        this.l = 6;
        this.n = new int[]{1};
    }
}
