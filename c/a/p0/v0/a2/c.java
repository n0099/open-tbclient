package c.a.p0.v0.a2;

import c.a.e.k.e.n;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
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
/* loaded from: classes4.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsItemTabFragment f25489e;

    /* renamed from: f  reason: collision with root package name */
    public d f25490f;

    /* renamed from: g  reason: collision with root package name */
    public FrsItemTabNetModel f25491g;

    /* renamed from: h  reason: collision with root package name */
    public int f25492h;

    /* renamed from: i  reason: collision with root package name */
    public String f25493i;

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
        this.f25489e = frsItemTabFragment;
        FrsItemTabRequestData frsItemTabRequestData = new FrsItemTabRequestData();
        frsItemTabRequestData.itemId = i2;
        FrsItemTabNetModel frsItemTabNetModel = new FrsItemTabNetModel(frsItemTabFragment.getPageContext(), frsItemTabRequestData);
        this.f25491g = frsItemTabNetModel;
        frsItemTabNetModel.Z(this);
        this.f25491g.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = this.f25490f;
            return (dVar == null || dVar.f25494e == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.f25492h);
            errorData.setError_msg(this.f25493i);
            if (this.f25492h != 0) {
                this.f25489e.onServerError(errorData);
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
            this.f25490f = dVar;
            dVar.f25496g = e(dVar.f25496g);
            this.f25489e.onViewDataChange(this.f25490f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f25491g.Q()) {
            return;
        }
        this.f25491g.R();
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
                if (next instanceof c2) {
                    c2 c2Var = (c2) next;
                    c.a.o0.b.f.a.e(c2Var);
                    int[] g0 = c2Var.g0();
                    if (c2Var.getType() == c2.W2 && !c2Var.w2()) {
                        b2 b2Var = new b2();
                        b2Var.w = c2Var;
                        b2Var.position = i2;
                        b2Var.f13845e = true;
                        b2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(b2Var);
                        b2 b2Var2 = new b2();
                        b2Var2.w = c2Var;
                        b2Var2.position = i2;
                        if (c2Var.X2() == 1) {
                            b2Var2.f13848h = true;
                            b2Var2.x = g0[0];
                            b2Var2.y = g0[1];
                        } else if (c2Var.X2() >= 2) {
                            b2Var2.f13849i = true;
                        } else {
                            b2Var2.f13846f = true;
                        }
                        b2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(b2Var2);
                        b2 b2Var3 = new b2();
                        b2Var3.k = true;
                        b2Var3.w = c2Var;
                        b2Var3.position = i2;
                        b2Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(b2Var3);
                        i2++;
                    }
                    c2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                } else {
                    if (next instanceof BaseCardInfo) {
                        ((BaseCardInfo) next).position = i2;
                    }
                    arrayList2.add(next);
                    i2++;
                }
            }
            c.a.o0.b.f.a.d(arrayList2);
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
            this.f25492h = mvcSocketResponsedMessage.getError();
            this.f25493i = mvcSocketResponsedMessage.getErrorString();
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
            this.f25492h = mvcHttpResponsedMessage.getError();
            this.f25493i = mvcHttpResponsedMessage.getErrorString();
            b();
        }
    }
}
