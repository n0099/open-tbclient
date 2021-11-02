package b.a.r0.k2.u.f;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b.a.q0.f1.n.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.q0.f1.n.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds48), b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds48));
        y(0);
        l(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds0));
        m(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds0));
        r(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds32), b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds44));
        f(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds18));
        s(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds32));
        u(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds38));
        j(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds31));
        h(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.M_H_X004));
    }
}
