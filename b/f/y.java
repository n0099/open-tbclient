package b.f;

import b.f.n;
import b.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class y implements z.a<j> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f32135a;

    public y(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32135a = zVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.f.z.a
    public void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", jVar.f32026a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.f.z.a
    public void b(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
            j jVar2 = jVar;
            LogPrinter.v("Update SerialSlotId:%s", jVar2.f32026a);
            HashMap<String, p> hashMap = this.f32135a.f32138c;
            String str = jVar2.f32026a;
            hashMap.put(str, new p(str, new w(this, jVar2)));
            n nVar = this.f32135a.f32137b;
            synchronized (nVar.f32072a) {
                nVar.a(jVar2.f32026a).add(new n.b(jVar2));
            }
        }
    }
}
