package c.a.p0.i2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.o0.d1.m.a aVar) {
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
                super((c.a.o0.d1.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
