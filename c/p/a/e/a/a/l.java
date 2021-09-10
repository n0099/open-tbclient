package c.p.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.mapsdkplatform.comapi.map.ag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, c.p.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.p.a.e.b.j.a) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.p.a.e.a.a.e
    public Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String t = this.f34909b.t("s");
            String b2 = c.p.a.e.a.h.d.b(this.f34909b.t(ag.f42204h), t);
            String b3 = c.p.a.e.a.h.d.b(this.f34909b.t("ah"), t);
            String b4 = c.p.a.e.a.h.d.b(this.f34909b.t("ai"), t);
            String b5 = c.p.a.e.a.h.d.b(this.f34909b.t("aj"), t);
            Intent intent = new Intent();
            intent.putExtra(b2, this.f34910c);
            intent.putExtra(b3, "*/*");
            intent.putExtra(b4, true);
            intent.setAction(b5);
            intent.addFlags(268435456);
            intent.addFlags(32768);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }
}
