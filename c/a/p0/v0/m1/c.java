package c.a.p0.v0.m1;

import android.view.View;
import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import c.a.p0.v0.n2.k;
import c.a.p0.v0.o2.h;
import c.a.p0.v0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c implements c.a.p0.v0.m1.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.v0.m1.e.b
    public void a(h hVar, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, hVar, frsViewData) == null) || hVar == null || frsViewData == null) {
            return;
        }
        ArrayList<n> threadList = frsViewData.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = threadList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.getType() == c2.V2) {
                arrayList.add(next);
            }
        }
        frsViewData.setTopThreadList(arrayList);
    }

    @Override // c.a.p0.v0.m1.e.b
    public void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.setVisibility(8);
        }
    }

    @Override // c.a.p0.v0.m1.e.b
    public void c(h hVar, q qVar, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, hVar, qVar, frsViewData) == null) || hVar == null || qVar == null || frsViewData == null) {
            return;
        }
        hVar.p();
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        qVar.W0(frsViewData.getForum().getFrsBannerData());
    }

    @Override // c.a.p0.v0.m1.e.b
    public int d(int i2, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, frsRequestData)) == null) ? k.e(i2, frsRequestData) : invokeIL.intValue;
    }

    @Override // c.a.p0.v0.m1.e.b
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }
}
