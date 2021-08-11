package c.i.b.a.e0.m;

import c.i.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public final class a extends c.i.b.a.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<byte[]> list) {
        super("DvbDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        l lVar = new l(list.get(0));
        this.n = new b(lVar.D(), lVar.D());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.e0.c
    /* renamed from: z */
    public c w(byte[] bArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                this.n.r();
            }
            return new c(this.n.b(bArr, i2));
        }
        return (c) invokeCommon.objValue;
    }
}
