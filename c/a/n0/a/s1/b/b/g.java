package c.a.n0.a.s1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import c.a.n0.a.s1.b.b.h;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g extends h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f6221f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6221f = context;
    }

    @Override // c.a.n0.a.s1.b.b.h.a
    public h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f6227e = this.f6221f.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f7);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f6227e);
            layoutParams.addRule(12);
            this.a.t.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f6221f.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f5));
            layoutParams2.addRule(2, this.a.t.getId());
            this.a.f6239h.setLayoutParams(layoutParams2);
            o(R.color.obfuscated_res_0x7f06037e);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(2, this.a.f6239h.getId());
            this.a.u.setLayoutParams(layoutParams3);
            return super.c();
        }
        return (h) invokeV.objValue;
    }
}
