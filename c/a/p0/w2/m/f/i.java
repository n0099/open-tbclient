package c.a.p0.w2.m.f;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.o0.e1.n.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.o0.e1.n.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
