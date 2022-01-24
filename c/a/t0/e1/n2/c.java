package c.a.t0.e1.n2;

import c.a.d.n.e.n;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabHttpResponseMessage;
import com.baidu.tieba.frs.itemtab.FrsItemTabNetModel;
import com.baidu.tieba.frs.itemtab.FrsItemTabRequestData;
import com.baidu.tieba.frs.itemtab.FrsItemTabSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsItemTabFragment f16639e;

    /* renamed from: f  reason: collision with root package name */
    public d f16640f;

    /* renamed from: g  reason: collision with root package name */
    public FrsItemTabNetModel f16641g;

    /* renamed from: h  reason: collision with root package name */
    public int f16642h;

    /* renamed from: i  reason: collision with root package name */
    public String f16643i;

    public c(FrsItemTabFragment frsItemTabFragment, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsItemTabFragment == null) {
            return;
        }
        this.f16639e = frsItemTabFragment;
        FrsItemTabRequestData frsItemTabRequestData = new FrsItemTabRequestData();
        frsItemTabRequestData.itemId = i2;
        FrsItemTabNetModel frsItemTabNetModel = new FrsItemTabNetModel(frsItemTabFragment.getPageContext(), frsItemTabRequestData);
        this.f16641g = frsItemTabNetModel;
        frsItemTabNetModel.Y(this);
        this.f16641g.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = this.f16640f;
            return (dVar == null || dVar.f16644e == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.f16642h);
            errorData.setError_msg(this.f16643i);
            if (this.f16642h != 0) {
                this.f16639e.onServerError(errorData);
            }
        }
    }

    public final boolean c(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            this.f16640f = dVar;
            dVar.f16646g = e(dVar.f16646g);
            this.f16639e.onViewDataChange(this.f16640f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f16641g.Q()) {
            return;
        }
        this.f16641g.loadData();
    }

    public final ArrayList<n> e(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof e2) {
                    e2 e2Var = (e2) next;
                    c.a.s0.b.f.a.e(e2Var);
                    int[] i0 = e2Var.i0();
                    if (e2Var.getType() == e2.j3 && !e2Var.E2()) {
                        d2 d2Var = new d2();
                        d2Var.w = e2Var;
                        d2Var.position = i2;
                        d2Var.f13529e = true;
                        d2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var);
                        d2 d2Var2 = new d2();
                        d2Var2.w = e2Var;
                        d2Var2.position = i2;
                        if (e2Var.i3() == 1) {
                            d2Var2.f13532h = true;
                            d2Var2.x = i0[0];
                            d2Var2.y = i0[1];
                        } else if (e2Var.i3() >= 2) {
                            d2Var2.f13533i = true;
                        } else {
                            d2Var2.f13530f = true;
                        }
                        d2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var2);
                        d2 d2Var3 = new d2();
                        d2Var3.k = true;
                        d2Var3.w = e2Var;
                        d2Var3.position = i2;
                        d2Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var3);
                        i2++;
                    }
                    e2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                } else {
                    if (next instanceof BaseCardInfo) {
                        ((BaseCardInfo) next).position = i2;
                    }
                    arrayList2.add(next);
                    i2++;
                }
            }
            c.a.s0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof FrsItemTabSocketResponseMessage)) {
            dVar = ((FrsItemTabSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (dVar == null || !c(dVar)) {
            this.f16642h = mvcSocketResponsedMessage.getError();
            this.f16643i = mvcSocketResponsedMessage.getErrorString();
            b();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof FrsItemTabHttpResponseMessage)) {
            dVar = (d) ((FrsItemTabHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (dVar == null || !c(dVar)) {
            this.f16642h = mvcHttpResponsedMessage.getError();
            this.f16643i = mvcHttpResponsedMessage.getErrorString();
            b();
        }
    }
}
