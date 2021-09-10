package c.a.l;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.l.v0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class y extends c.a.l.a<c.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public MutiImgSingleVerticalLayout f3885j;
    public c.a.q0.s.q.a k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f3886a;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3886a = yVar;
        }

        @Override // c.a.l.v0.a.b
        public boolean a(a.C0095a c0095a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0095a)) == null) {
                if (this.f3886a.k != null && this.f3886a.k.getThreadData() != null) {
                    c.a.r0.a0.m.a(this.f3886a.k.getThreadData().f0());
                    y yVar = this.f3886a;
                    c.a.r0.a0.m.l(yVar.f3885j.mTitle, yVar.k.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    y yVar2 = this.f3886a;
                    c.a.r0.a0.m.l(yVar2.f3885j.mAbstract, yVar2.k.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().f14238i instanceof MutiImgSingleVerticalLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().f14238i.getParent() == null) {
            this.f3885j = (MutiImgSingleVerticalLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().f14238i;
        } else {
            this.f3885j = new MutiImgSingleVerticalLayout(context);
        }
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3885j : (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(1, new a(this));
        }
    }

    @Override // c.a.l.a
    public void k(c.a.r0.a0.b0<c.a.q0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b0Var) == null) {
            this.f3885j.setSubClickListener(b0Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: o */
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.k = aVar;
            this.f3885j.setFrom(this.m);
            this.f3885j.onBindDataToView(aVar);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            this.l = i2;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f3885j.setFromCDN(z);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f3885j.setNeedFrsTabName(z);
        }
    }
}
