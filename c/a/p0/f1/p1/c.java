package c.a.p0.f1.p1;

import android.view.View;
import c.a.d.o.e.n;
import c.a.p0.f1.q;
import c.a.p0.f1.r2.p;
import c.a.p0.f1.s2.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class c implements c.a.p0.f1.p1.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.f1.p1.e.b
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
            if (next.getType() == ThreadData.TYPE_TOP) {
                arrayList.add(next);
            }
        }
        frsViewData.setTopThreadList(arrayList);
    }

    @Override // c.a.p0.f1.p1.e.b
    public void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.setVisibility(8);
        }
    }

    @Override // c.a.p0.f1.p1.e.b
    public void c(h hVar, q qVar, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, hVar, qVar, frsViewData) == null) || hVar == null || qVar == null || frsViewData == null) {
            return;
        }
        hVar.r();
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        qVar.Y0(frsViewData.getForum().getFrsBannerData());
    }

    @Override // c.a.p0.f1.p1.e.b
    public int d(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, frsRequestData)) == null) ? p.e(i, frsRequestData) : invokeIL.intValue;
    }

    @Override // c.a.p0.f1.p1.e.b
    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }
}
