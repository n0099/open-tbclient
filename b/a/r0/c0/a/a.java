package b.a.r0.c0.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class a extends b.a.q0.k0.f.b<tinfo, b.a.q0.k0.d.b, b.a.q0.k0.f.a<tinfo, b.a.q0.k0.d.b>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, clsArr, iArr, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class[]) objArr2[1], (int[]) objArr2[2], (ViewEventCenter) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.q0.k0.f.b
    public int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            tinfo item = getItem(i2);
            if (item == null) {
                return -1;
            }
            List<Pic> list = item.pics;
            if (list != null) {
                int size = list.size();
                if (size >= 3) {
                    return 0;
                }
                if (size > 0 && size < 3) {
                    return 2;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void p(long j) {
        List<tinfo> d2;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j <= 0 || (d2 = d()) == null || d2.size() <= 0) {
            return;
        }
        tinfo tinfoVar = null;
        int size = d2.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                tinfo tinfoVar2 = d2.get(i2);
                if (tinfoVar2 != null && (l = tinfoVar2.thread_id) != null && l.longValue() == j) {
                    tinfoVar = d2.get(i2);
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (tinfoVar != null) {
            h(tinfoVar);
        }
    }
}
